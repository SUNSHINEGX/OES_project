package com.cool.john.dao;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;

import com.cool.john.bean.Choice;

public class ChoiceDao {
	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	public List findEChoice(String subject){
		String hql="select c from Choice c where c.subject='"+subject+"'"+"and c.level="+0;
		return this.getHibernateTemplate().find(hql);
	}
	public List findHChoice(String subject){
		String hql="select c from Choice c where c.subject='"+subject+"'"+"and c.level="+1;
		return this.getHibernateTemplate().find(hql);
	}
	public int insert(Choice choice){
		this.getHibernateTemplate().save(choice);
		int i =1;
		return i;
	}
	public void update(Choice choice){
		this.getHibernateTemplate().update(choice);
	}
	
	public List find(Choice choice){
		String hql="from Choice where SelTop='"+choice.getSelTop()+"'";
		return this.getHibernateTemplate().find(hql);
	}
	
	public List prosuch(String flag){
		String hql="from Choice where SelTop like '%"+flag+"%'";
		return this.getHibernateTemplate().find(hql);
	}
}
