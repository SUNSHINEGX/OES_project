package com.online.dao;

import java.util.List;
import java.util.Set;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;

import com.online.domain.Operator;


/**
 * A data access object (DAO) providing persistence and search support for
 * Operator entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.online.domain.Operator
 * @author MyEclipse Persistence Tools
 */

public interface OperatorDAO_Interface  {
	public void save(Operator transientInstance);
	public void delete(Operator persistentInstance);
	public Operator findById(java.lang.String id);
	public List findByExample(Operator instance);
	public List findByProperty(String propertyName, Object value);
	public List findByOptName(Object optName);
	public List findByPassword(Object password);
	public List findByIsExpired(Object isExpired);
	public List findByIsAdmin(Object isAdmin);
	public List findAll();
	public Operator merge(Operator detachedInstance);
	public void attachDirty(Operator instance);
	public void attachClean(Operator instance);
	}