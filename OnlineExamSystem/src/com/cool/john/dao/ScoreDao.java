package com.cool.john.dao;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;

import com.cool.john.bean.Score;
import com.cool.john.bean.Studentqa;

public class ScoreDao {
	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	public int insert(Score score){
		int i=(int) this.getHibernateTemplate().save(score);
		return i;
	}
	
	public void delete(Score score){
		this.getHibernateTemplate().delete(score);
	}

	
	public void update(Score score){
		this.getHibernateTemplate().update(score);
	}
	
	public List find(){
		String hql="select s from Score s";
		return this.getHibernateTemplate().find(hql);
	}
	public List findClass(Score score){
		String hql="from Score s where s.classNo=? and s.subject=?";
		String[ ] str = {score.getClassNo(),score.getSubject()}; 
		return this.getHibernateTemplate().find(hql, str);
	}
	public List findStuName(Score score){
		String hql="from Score s where s.StuName=? and s.subject=?";
		String[ ] str = {score.getStuName(),score.getSubject()}; 
		return this.getHibernateTemplate().find(hql, str);
	}
	public List findScore(Score score){
		String hql="from Score s where s.StuNum=? and s.subject=?";
		String[] str ={score.getStuNum(),score.getSubject()};
		return this.getHibernateTemplate().find(hql, str);
	}
	public List findOnlySub(Score score){
		String hql="from Score s where s.subject=?";
		return this.getHibernateTemplate().find(hql,score.getSubject());
	}
	public List findSub(Score score){
		String hql="from Score s where s.StuNum=? and s.subject=?";
		String[] str ={score.getStuNum(),score.getSubject()};
		return this.getHibernateTemplate().find(hql,str);
	}
	//管理员班级搜索
	public List findAdClass(Score score){
		String hql="from Score s where  s.classNo=?";
		return this.getHibernateTemplate().find(hql,score.getClassNo());
	}
	//管理员学号搜索
	public List findAdStuNum(Score score){
		String hql="from Score s where  s.StuNum=?";
		return this.getHibernateTemplate().find(hql,score.getStuNum());
	}
	//管理员姓名搜索
	public List findAdStuName(Score score){
		String hql="from Score s where  s.StuName=?";
		return this.getHibernateTemplate().find(hql,score.getStuName());
	}
}
