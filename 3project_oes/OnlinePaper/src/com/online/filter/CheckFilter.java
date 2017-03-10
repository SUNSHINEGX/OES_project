package com.online.filter;

import java.io.*;
import java.net.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class CheckFilter implements Filter {
	private FilterConfig filterConfig;
	// ��¼ҳ�棬���û�û�е�¼ʱ����������ת�����ҳ��
	private String loginPage = "/login.jsp";

	public void init(FilterConfig config) throws ServletException {
		// ͨ��FilterConfig���web.xml�����õĳ�ʼ������
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
    
		// ͨ���ж�session���Ƿ����auth�������ж��û��Ƿ��Ѿ���¼
		HttpSession session = req.getSession(true);
		//System.out.println(" request url is======="	+ req.getRequestURL().toString());
		// ����Ѿ���¼
		//css,images,img,js�µ���������
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
		// ��δ��¼
		else {
			
			ServletContext ctx = filterConfig.getServletContext();
			res.sendRedirect("login.jsp");
			//setForwardURI(req);
			// ��ת����¼ҳ��
			//ctx.getRequestDispatcher(loginPage).
			//ctx.getRequestDispatcher(loginPage).forward(req, res);
		}
	}

	// ����ԭʼ������URL
	private void setForwardURI(HttpServletRequest request) {
		// ���Ȼ���û����������Դ
		StringBuffer requestURI = new StringBuffer(request.getRequestURI());
		// �Լ������������ַ�������showMsg?name=Alex�е�?�������
		String queryString = request.getQueryString();
		if (queryString != null) {
			requestURI.append("?").append(queryString);
		}
		// ���û���ԭʼ�������request��������
		request.setAttribute("orignURL", requestURI.toString());
	}
}
