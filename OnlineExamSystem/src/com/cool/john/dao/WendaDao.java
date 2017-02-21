package com.cool.john.dao;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;

import com.cool.john.bean.Wenda;

public class WendaDao {
	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	public List findEWenda(String subject){
		String hql="select w from Wenda w where w.subject='"+subject+"'"+"and w.level="+0;
		return this.getHibernateTemplate().find(hql);
	}
	public List findHWenda(String subject){
		String hql="select w from Wenda w where w.subject='"+subject+"'"+"and w.level="+1;
		return this.getHibernateTemplate().find(hql);
	}
	public int insert(Wenda wenda){
		this.getHibernateTemplate().save(wenda);
		int i =1;
		return i;
	}
	
	public void update(Wenda wenda){
		this.getHibernateTemplate().update(wenda);
	}
	
	public List find(Wenda wenda){
		String hql="from Wenda where QaTop='"+wenda.getQaTop()+"'";
		return this.getHibernateTemplate().find(hql);
	}
	public List prosuch(String flag){
		String hql="from Wenda where QaTop like '%"+flag+"%'";
		return this.getHibernateTemplate().find(hql);
	}
}
