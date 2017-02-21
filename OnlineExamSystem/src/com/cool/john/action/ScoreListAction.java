package com.cool.john.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.cool.john.service.ScoreListService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ScoreListAction extends ActionSupport{
	private ScoreListService slService;

	public ScoreListService getSlService() {
		return slService;
	}

	public void setSlService(ScoreListService slService) {
		this.slService = slService;
	}
	
	public void getScoreList() throws IOException{
		HttpServletRequest req = ServletActionContext.getRequest();
		HttpSession hs = req.getSession();
		
		String stuNum = (String) hs.getAttribute("stuNum");
		System.out.println(stuNum);
		List list = this.getSlService().findScore(stuNum);
		System.out.println(list);
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter pw=response.getWriter();
		pw.print(list.toString());
	}
}
