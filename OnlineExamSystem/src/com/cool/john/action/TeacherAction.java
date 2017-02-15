package com.cool.john.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.cool.john.bean.Teacher;
import com.cool.john.service.TeacherService;

public class TeacherAction {
	private Teacher teacher;
	private TeacherService teacherService;
	
	
	public Teacher getTeacher() {
		return teacher;
	}


	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}


	public TeacherService getTeacherService() {
		return teacherService;
	}


	public void setTeacherService(TeacherService teacherService) {
		this.teacherService = teacherService;
	}


	public void changepassword(){
		HttpServletRequest request = ServletActionContext.getRequest();
		
		String flag = request.getParameter("flag");
		
		Teacher teacher2 = new Teacher();
		List<Teacher> list = teacherService.find(flag);
		teacher2 = list.get(0);
		teacher2.setPassword(teacher.getPassword());
		this.getTeacherService().update(teacher2);
		System.out.println("修改密码成功");
	}
	
	public void geren() throws IOException{
		
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter pw = response.getWriter();
		String flag = request.getParameter("flag");
		List<Teacher> list = teacherService.find(flag);
		pw.write(list.toString());
	}
	
	
	public void insert() throws IOException{
		System.out.println(this.getTeacher());
		List list=this.getTeacherService().findjiansuo(this.getTeacher());
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter pw=response.getWriter();
		if(list.size()>0){
			pw.print("此教师已存在！请重新输入！");
		}else{
			this.getTeacherService().insert(this.getTeacher());
			pw.print("success");
			
		}
		
		
	}
	
	public void update() throws IOException{
		System.out.println(this.getTeacher());
		List list=this.getTeacherService().findjiansuo(this.getTeacher());
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter pw=response.getWriter();
		if(list.size()>0){
			this.getTeacherService().update(this.getTeacher());
			pw.print("success");
		}else{
			pw.print("此教师不存在！请重新输入！");
		}
		
	}

	
	public void jiansuo() throws IOException{
		System.out.println(this.getTeacher());
		List list=this.getTeacherService().findjiansuo(this.getTeacher());
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
	
	
	public void getTeachers() throws IOException{
		List list=this.getTeacherService().find();
		System.out.println(list);
		
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter pw=response.getWriter();
		pw.print(list.toString());
	}
	
}
