package com.cool.john.dao;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.orm.hibernate3.HibernateTemplate;

public class ScoreListDao {
	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	public List find(){
		String hql="select s from ScoreList s";
		return this.getHibernateTemplate().find(hql);
	}
	
	public List findScore(String stuName){		
		System.out.println(stuName);
		String hql="from ScoreList s where s.stuNum=?";
		String[] str={stuName};
		return this.getHibernateTemplate().find(hql,str);
	}
	
	public List find(String subject){
		HttpServletRequest req = ServletActionContext.getRequest();
		HttpSession hs = req.getSession();
		String stuNum = "%" + (String) hs.getAttribute("stuNum") + "%";
		System.out.println(stuNum);
		
		String subject1 = "%"+subject+"%";
		System.out.println(subject1);
		String hql="from ScoreList sl where sl.subject like ? and sl.stuNum like ?";
		String[] str={subject1,stuNum};
		return this.getHibernateTemplate().find(hql,str);
	}
}
