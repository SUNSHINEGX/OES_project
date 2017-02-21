package com.cool.john.service;


import java.util.List;

import com.cool.john.bean.Teacher;
import com.cool.john.dao.TeacherDao;

public class TeacherService {
	private TeacherDao teacherDao;
		
	public TeacherDao getTeacherDao() {
		return teacherDao;
	}

	public void setTeacherDao(TeacherDao teacherDao) {
		this.teacherDao = teacherDao;
	}

	public List find(){
		return this.getTeacherDao().find();
	}
	
	public List find(Teacher tea){
		return this.getTeacherDao().find(tea);
	}
	public void update(Teacher teacher){
		this.getTeacherDao().update(teacher);
	}
	
	public void insert(Teacher teacher){
		 this.getTeacherDao().insert(teacher);
	}
	
	public List findjiansuo(Teacher teacher){
		return this.getTeacherDao().findjiansuo(teacher);
	}
	
	public List find(String TeaNum){
		return this.getTeacherDao().find(TeaNum);
	}
}
