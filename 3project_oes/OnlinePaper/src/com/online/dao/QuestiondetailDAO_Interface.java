package com.online.dao;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;

import com.online.domain.Questiondetail;


/**
 * A data access object (DAO) providing persistence and search support for
 * Questiondetail entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.online.domain.Questiondetail
 * @author MyEclipse Persistence Tools
 */

public interface QuestiondetailDAO_Interface
  {
	public void save(Questiondetail transientInstance);
	public void delete(Questiondetail persistentInstance);
	public Questiondetail findById(java.lang.Integer id);
	public List findByExample(Questiondetail instance);
	public List findByProperty(String propertyName, Object value);
	public List findByOptionNo(Object optionNo);
	public List findByOptionContent(Object optionContent);
	public List findAll();
	public Questiondetail merge(Questiondetail detachedInstance);
	public void attachDirty(Questiondetail instance);
	public void attachClean(Questiondetail instance);
}