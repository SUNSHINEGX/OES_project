package com.online.filter;

import java.io.*;
import java.net.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class CheckFilter implements Filter {
	private FilterConfig filterConfig;
	// 登录页面，当用户没有登录时，将会首先转到这个页面
	private String loginPage = "/login.jsp";

	public void init(FilterConfig config) throws ServletException {
		// 通过FilterConfig获得web.xml中设置的初始化参数
		filterConfig = config;
		if (filterConfig.getInitParameter("loginPage") != null)
			loginPage = filterConfig.getInitParameter("loginPage");
	}

	public void destroy() {
		filterConfig = null;
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
    
		// 通过判断session中是否具有auth参数来判断用户是否已经登录
		HttpSession session = req.getSession(true);
		//System.out.println(" request url is======="	+ req.getRequestURL().toString());
		// 如果已经登录
		//css,images,img,js下的请求不拦截
		String  reqSubStr=req.getRequestURL().toString();

		//|| reqSubStr.indexOf("css")!=-1 || reqSubStr.indexOf("js")!=-1
		if (reqSubStr.indexOf("images")!=-1 || reqSubStr.indexOf("img")!=-1
				|| reqSubStr.indexOf("css")!=-1  || reqSubStr.indexOf("login.jsp")!=-1			
				|| reqSubStr.indexOf("validateOperatorAction.action")!=-1)
		  {
			chain.doFilter(req, res);
			return;
		  }
		if (session.getAttribute("currentUser") != null) {
			chain.doFilter(req, res);
			return;
		}
		// 尚未登录
		else {
			
			ServletContext ctx = filterConfig.getServletContext();
			res.sendRedirect("login.jsp");
			//setForwardURI(req);
			// 跳转到登录页面
			//ctx.getRequestDispatcher(loginPage).
			//ctx.getRequestDispatcher(loginPage).forward(req, res);
		}
	}

	// 设置原始的请求URL
	private void setForwardURI(HttpServletRequest request) {
		// 首先获得用户所请求的资源
		StringBuffer requestURI = new StringBuffer(request.getRequestURI());
		// 以及所附的请求字符串，如showMsg?name=Alex中的?后的内容
		String queryString = request.getQueryString();
		if (queryString != null) {
			requestURI.append("?").append(queryString);
		}
		// 将用户的原始请求放在request的属性中
		request.setAttribute("orignURL", requestURI.toString());
	}
}
