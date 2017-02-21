package com.cool.john.dao;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;

import com.cool.john.bean.Admin;


public class AdminDao {
	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	public List find(){
		String hql="select a from Admin a";
		return this.getHibernateTemplate().find(hql);
	}
	
	public List find(Admin adm){
		String hql="from Admin a where a.adminNum=? and a.password=?";
		String[] str={adm.getAdminNum(),adm.getPassword()};
		return this.getHibernateTemplate().find(hql,str);
	}
	
	public void update(Admin admin){
		this.getHibernateTemplate().update(admin);
	}
}
