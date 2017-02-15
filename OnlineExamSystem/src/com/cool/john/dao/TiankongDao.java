package com.cool.john.dao;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;

import com.cool.john.bean.Tiankong;

public class TiankongDao {
	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	public List findETiankong(String subject){
		String hql="select t from Tiankong t where t.subject='"+subject+"'"+"and t.level="+0;
		return this.getHibernateTemplate().find(hql);
	}
	public List findHTiankong(String subject){
		String hql="select t from Tiankong t where t.subject='"+subject+"'"+"and t.level="+1;
		return this.getHibernateTemplate().find(hql);
	}
	public int insert(Tiankong tiankong){
		this.getHibernateTemplate().save(tiankong);
		int i =1;
		return i;
	}
	public void update(Tiankong tiankong){
		this.getHibernateTemplate().update(tiankong);
	}
	
	public List find(Tiankong tiankong){
		String hql="from Tiankong where FillTop='"+tiankong.getFillTop()+"'";
		return this.getHibernateTemplate().find(hql);
	}
	public List prosuch(String flag){
		String hql="from Tiankong where FillTop like '%"+flag+"%'";
		return this.getHibernateTemplate().find(hql);
	}
}
