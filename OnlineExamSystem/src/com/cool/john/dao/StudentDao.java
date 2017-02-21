package com.cool.john.dao;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;

import com.cool.john.bean.Student;

public class StudentDao {
	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	public List find(){
		String hql="select s from Student s";
		return this.getHibernateTemplate().find(hql);
	}
	
	public List find(Student stu){
		String hql="from Student s where s.stuNum=? and s.password=?";
		String[] str={stu.getStuNum(),stu.getPassword()};
		return this.getHibernateTemplate().find(hql,str);
	}
	public List findjiansuo(Student student){
		String hql="from Student where stuNum='"+student.getStuNum()+"'";
		return this.getHibernateTemplate().find(hql);
	}
	
	public List findStudent(String stuNum){
		String hql="from Student s where s.stuNum=?";
		String[] str={stuNum};
		return this.getHibernateTemplate().find(hql,str);
	}
	
	public void update(Student student){
		this.getHibernateTemplate().update(student);
	}

	public void insert(Student student){
		this.getHibernateTemplate().save(student);
		
	}
}
