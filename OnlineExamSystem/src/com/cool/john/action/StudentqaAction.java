package com.cool.john.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.cool.john.bean.Studentqa;
import com.cool.john.service.StudentqaService;

public class StudentqaAction {
	private Studentqa studentqa;
	private StudentqaService studentqaService;
	public StudentqaService getStudentqaService() {
		return studentqaService;
	}
	public void setStudentqaService(StudentqaService studentqaService) {
		this.studentqaService = studentqaService;
	}
	public void studentqa() throws IOException{
		HttpServletRequest request = ServletActionContext.getRequest();
		String flag =new String(request.getParameter("flag").getBytes("ISO-8859-1"),"UTF-8");
		System.out.println(flag);
		
		List list = studentqaService.find(flag);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter pw = response.getWriter();
		pw.write(list.toString());
		
	}
}
