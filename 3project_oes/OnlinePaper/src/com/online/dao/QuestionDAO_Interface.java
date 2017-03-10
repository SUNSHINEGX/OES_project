package com.online.dao;

import java.util.List;
import java.util.Set;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;

import com.online.domain.Question;


/**
 * A data access object (DAO) providing persistence and search support for
 * Question entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.online.domain.Question
 * @author MyEclipse Persistence Tools
 */

public interface QuestionDAO_Interface  {
	public void save(Question transientInstance);
	public void delete(Question persistentInstance);
	public Question findById(java.lang.Integer id);
	public List findByExample(Question instance);
	public List findByProperty(String propertyName, Object value);
	public List findByType(Object type);
	public List findByMainContent(Object mainContent);
	public List findByScore(Object score);
	public List findByEasyLevel(Object easyLevel);
	public List findByAnswer(Object answer);
	public List findAll();
	public Question merge(Question detachedInstance);
	public void attachDirty(Question instance);
	public void attachClean(Question instance);
	}