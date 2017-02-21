package com.cool.john.dao;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;

import com.cool.john.bean.Exampaper;

public class ExampaperDao {
	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	public List findExampaper(String subject){
		String hql="select e from Exampaper e where e.subject='"+subject+"'";
		return this.getHibernateTemplate().find(hql);
	}
	public int insert(Exampaper exampaper){
		this.getHibernateTemplate().save(exampaper);
		int i =1;
		return i;
	}
	public void update(Exampaper exampaper){
		this.getHibernateTemplate().update(exampaper);
	}
	
	public List find(Exampaper exampaper){
		String hql="from Exampaper where subject='"+exampaper.getSubject()+"'";
		return this.getHibernateTemplate().find(hql);
	}
}
