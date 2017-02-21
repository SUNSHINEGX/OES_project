package com.cool.john.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.cool.john.service.ScoreListService;
import com.cool.john.service.TestPaperListService;
import com.opensymphony.xwork2.ActionSupport;

public class FindScoreAction extends ActionSupport{
	private String score_name;
	private ScoreListService slService;
	
	public String getScore_name() {
		return score_name;
	}



	public void setScore_name(String score_name) {
		this.score_name = score_name;
	}



	public ScoreListService getSlService() {
		return slService;
	}



	public void setSlService(ScoreListService slService) {
		this.slService = slService;
	}



	public void findScore() throws IOException{
		String str  = new String(this.getScore_name().getBytes("iso-8859-1"),"utf-8");
		System.out.println("ËÑË÷µÄÃû×Ö:"+str);
		List list = slService.find(str);
		System.out.println(list);
								
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter pw=response.getWriter();
		pw.print(list.toString());
	}
	
}
