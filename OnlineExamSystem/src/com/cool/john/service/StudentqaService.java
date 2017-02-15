package com.cool.john.service;

import java.util.Iterator;
import java.util.List;

import com.cool.john.bean.Score;
import com.cool.john.bean.Studentqa;
import com.cool.john.dao.StudentqaDao;

public class StudentqaService {
	private StudentqaDao studentqaDao;

	public StudentqaDao getStudentqaDao() {
		return studentqaDao;
	}
	public void deleteStudentqa (Studentqa sq){
		 List<Studentqa> list = this.getStudentqaDao().findStudentqa(sq);
		 System.out.println( list.size());
		Studentqa obj = list.get(0);
		
		this.getStudentqaDao().deleteStudentQa(obj);
	}
	public void setStudentqaDao(StudentqaDao studentqaDao) {
		this.studentqaDao = studentqaDao;
	}
	public List find(String flag){
		return this.getStudentqaDao().find(flag);
	}
	public void insertStudentqaService(Studentqa sq){
		this.studentqaDao.insertStudentqa(sq);
	}
}
