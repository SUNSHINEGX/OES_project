package com.cool.john.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.cool.john.bean.Exampaper;
import com.cool.john.service.ExampaperService;

public class ExampaperAction {
	private Exampaper exampaper;
	private ExampaperService exampaperService;
	
	
	public Exampaper getExampaper() {
		return exampaper;
	}

	public void setExampaper(Exampaper exampaper) {
		this.exampaper = exampaper;
	}

	public ExampaperService getExampaperService() {
		return exampaperService;
	}

	public void setExampaperService(ExampaperService exampaperService) {
		this.exampaperService = exampaperService;
	}



	public void Exampaper() throws IOException{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		String flag =new String( request.getParameter("flag").getBytes("ISO-8859-1"),"UTF-8");
		System.out.println(flag);
		exampaper.setSubject(flag);
		List list1 = this.getExampaperService().find(exampaper);
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter pw = response.getWriter();
		if(list1.size()>0){
			this.getExampaperService().update(exampaper);
		}else{
			this.getExampaperService().insert(this.getExampaper());
		}
		pw.print("success");
	}
}
