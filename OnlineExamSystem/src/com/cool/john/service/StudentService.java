package com.cool.john.service;


import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.cool.john.bean.Student;
import com.cool.john.dao.StudentDao;

public class StudentService {
	private StudentDao stuDao;

	public StudentDao getStuDao() {
		return stuDao;
	}

	public void setStuDao(StudentDao stuDao) {
		this.stuDao = stuDao;
	}
	
	public List find(){
		return this.getStuDao().find();
	}
	
	public List find(Student stu){
		return this.getStuDao().find(stu);
	}
	public List findjiansuo(Student student){
		return this.getStuDao().findjiansuo(student);
	}
	
	public List findStudent(String stuNum){
		return this.getStuDao().findStudent(stuNum);
	}
	
	public void insert(Student student){
			this.getStuDao().insert(student);
	}
	
	public void update(Student student){
		this.getStuDao().update(student);
	}
	
	/*public static void main(String[] args) {
	ApplicationContext applicationContext=new FileSystemXmlApplicationContext("src/spring.xml");
	StudentService us=(StudentService)applicationContext.getBean("stuServiceProxy");
	System.out.println(us.find().toString());
	}*/
}
