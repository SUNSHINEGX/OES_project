package com.cool.john.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.cool.john.service.TestPaperListService;
import com.opensymphony.xwork2.ActionSupport;

public class FindTestAction extends ActionSupport{
	private String test_name;
	private TestPaperListService tpService;

	public String getTest_name() {
		return test_name;
	}

	public void setTest_name(String test_name) throws UnsupportedEncodingException {
		this.test_name = test_name;
	}
	
	public TestPaperListService getTpService() {
		return tpService;
	}

	public void setTpService(TestPaperListService tpService) {
		this.tpService = tpService;
	}

	public void findTest() throws IOException{
		String str  = new String(this.getTest_name().getBytes("iso-8859-1"),"utf-8");
		System.out.println("ËÑË÷µÄÃû×Ö:"+str);
		List list = tpService.find(str);
		System.out.println(list.toString());
								
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter pw=response.getWriter();
		pw.print(list.toString());
	}
	
}
