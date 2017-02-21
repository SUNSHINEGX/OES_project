package com.cool.john.dao;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;

import com.cool.john.bean.Teacher;

public class TeacherDao {
	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	public List find(){
		String hql="select t from Teacher t";
		return this.getHibernateTemplate().find(hql);
	}
	
	public List find(Teacher tea){
		String hql="from Teacher where TeaNum=? and password=?";
		String[] str={tea.getTeaNum(),tea.getPassword()};
		return this.getHibernateTemplate().find(hql,str);
	}
	public void update(Teacher teacher){
		this.getHibernateTemplate().update(teacher);
	}
	public void insert(Teacher teacher){
		this.getHibernateTemplate().save(teacher);
		
	}
	
	public List findjiansuo(Teacher teacher){
		String hql="from Teacher where  TeaNum="+teacher.getTeaNum()+"";
		return this.getHibernateTemplate().find(hql);
	}
	
	public List find(String TeaNum){
		String hql="from Teacher where TeaNum="+TeaNum;
		return this.getHibernateTemplate().find(hql);
	}
	
}
