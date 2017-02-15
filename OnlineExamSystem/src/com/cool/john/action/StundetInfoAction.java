package com.cool.john.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.cool.john.bean.Student;
import com.cool.john.service.StudentService;

public class StundetInfoAction {
	private StudentService stuService;
	private Student student;
	
	
	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public StudentService getStuService() {
		return stuService;
	}

	public void setStuService(StudentService stuService) {
		this.stuService = stuService;
	}
	
	public void stuInfo() throws IOException{
		HttpServletRequest req = ServletActionContext.getRequest();
		HttpSession hs = req.getSession();
		String stuNum = (String) hs.getAttribute("stuNum");		
		System.out.println("搜索的学号:"+stuNum);
		List list = stuService.findStudent(stuNum);
		System.out.println(list);
		
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter pw=response.getWriter();
		pw.print(list.toString());
	}
	
	public void getUsers() throws IOException{
		List list=this.getStuService().find();
		System.out.println(list);
		
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter pw=response.getWriter();
		pw.print(list.toString());
	}
	
	
	public void jiansuo() throws IOException{
		System.out.println(this.getStudent());
		List list=this.getStuService().findjiansuo(this.getStudent());
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
		System.out.println(this.getStudent());
		List list=this.getStuService().findjiansuo(this.getStudent());
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter pw=response.getWriter();
		if(list.size()>0){
			pw.print("此学生已存在！请重新输入");
		}else{
			this.getStuService().insert(this.getStudent());
			pw.print("success");
		}
		
	}
	
	public void update() throws IOException{
		System.out.println(this.getStudent());
		List list=this.getStuService().findjiansuo(this.getStudent());
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter pw=response.getWriter();
		if(list.size()>0){
			this.getStuService().update(this.getStudent());
			pw.print("success");
		}else{
			pw.print("此学生不存在！请重新输入");
		}
		
	}
}
