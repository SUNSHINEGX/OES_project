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

public class StudentAction {
	private StudentService studentService;
	private Student student;

	
	public StudentService getStudentService() {
		return studentService;
	}

	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public String login(){
		System.out.println(this.getStudent());
		List list=this.getStudentService().find(this.getStudent());
		System.out.println(list);
		if(list.size()>0){
			return "success";
		}else{
			return "error";
		}
	}
	
	public void jiansuo() throws IOException{
		System.out.println(this.getStudent());
		List list=this.getStudentService().findjiansuo(this.getStudent());
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
	
	public void insert(){
		System.out.println(this.getStudent());
		this.getStudentService().insert(this.getStudent());
	}
	
	public void update(){
		System.out.println(this.getStudent());
		this.getStudentService().update(this.getStudent());
	}
	
	
	public void getUsers() throws IOException{
		List list=this.getStudentService().find();
		System.out.println(list);
		
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter pw=response.getWriter();
		pw.print(list.toString());
	}

}	
