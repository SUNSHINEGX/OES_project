package com.cool.john.dao;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;

import com.cool.john.bean.Student;
import com.cool.john.bean.Studentqa;


public class StudentqaDao {
	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}
	public void deleteStudentQa(Studentqa sq){
		this.getHibernateTemplate().delete(sq);
	}
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	public List find(String flag){
		String hql="from Studentqa s where s.subject=?";
		System.out.println("cdas"+this.getHibernateTemplate().find(hql,flag));
		return this.getHibernateTemplate().find(hql,flag);	
	}
	public List findStudentqa(Studentqa sq){
		String hql="from Studentqa s where s.QaTop='"+sq.getQaTop()+"' and s.StuNum="+sq.getStuNum();
		return this.getHibernateTemplate().find(hql);
	}
	public void insertStudentqa(Studentqa sq){
		this.getHibernateTemplate().save(sq);
	}
}
