package com.cool.john.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.cool.john.bean.TestPaperList;
import com.cool.john.service.TestPaperListService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class TestListAction extends ActionSupport{
	private TestPaperListService tpService;
	private TestPaperList testPaperList;

	public TestPaperList getTestPaperList() {
		return testPaperList;
	}

	public void setTestPaperList(TestPaperList testPaperList) {
		this.testPaperList = testPaperList;
	}

	public TestPaperListService getTpService() {
		return tpService;
	}

	public void setTpService(TestPaperListService tpService) {
		this.tpService = tpService;
	}
	
	public void getTestList() throws IOException{
		ActionContext ac = ActionContext.getContext();
		List list = this.getTpService().find();
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter pw=response.getWriter();
		pw.print(list.toString());
		
	}
	public void jiansuo() throws IOException{
		System.out.println(this.getTestPaperList());
		List list=this.getTpService().find(this.getTestPaperList());
		System.out.println(list);
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter pw=response.getWriter();
		if(list.size()>0){
			pw.print(list.toString());
		}else{
			pw.print("");
		}
		

	}
	public void insert() throws IOException{
		List list=this.getTpService().find(this.getTestPaperList().getSubject());
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter pw=response.getWriter();
		if(list.size()>0){
			pw.print("此科目已存在！");
		}else{
			System.out.println(this.getTestPaperList());
			this.getTpService().insert(this.getTestPaperList());
			pw.print("success");
		}
	}
	
	public void update() throws IOException{
		List list=this.getTpService().find(this.getTestPaperList().getSubject());
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter pw=response.getWriter();
		if(list.size()>0){
			System.out.println(this.getTestPaperList());
			this.getTpService().update(this.getTestPaperList());
			pw.print("success");
		}else{
			pw.print("找不到此科目！");
		}
		
	}
	
	public void getExamtimes() throws IOException{
		List list=getTpService().find();
		System.out.println(list);
		
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter pw=response.getWriter();
		pw.print(list.toString());
	}

}
