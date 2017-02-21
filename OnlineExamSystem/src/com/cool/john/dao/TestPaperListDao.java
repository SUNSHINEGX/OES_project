package com.cool.john.dao;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.cool.john.bean.TestPaperList;


public class TestPaperListDao {
	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	public List find(){
		String hql="select tp from TestPaperList tp";
		return this.getHibernateTemplate().find(hql);
	}
	
	public List find(String subject){		
		String hql="from TestPaperList tp where tp.subject like'%"+subject+"%'";
		//String[] str={subject};
		return this.getHibernateTemplate().find(hql);
	}
	
	public void update(TestPaperList examTime){
		this.getHibernateTemplate().update(examTime);
	}
	

	public void insert(TestPaperList examTime){
		 this.getHibernateTemplate().save(examTime);
	}
	
	public List find(TestPaperList examTime){
		String hql="from TestPaperList where subject='"+examTime.getSubject()+"'";
		return this.getHibernateTemplate().find(hql);
	}
	
}
