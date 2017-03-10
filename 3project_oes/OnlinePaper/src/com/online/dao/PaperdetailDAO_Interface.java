package com.online.dao;

import java.util.List;
import java.util.Set;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;

import com.online.domain.Paperdetail;


/**
 * A data access object (DAO) providing persistence and search support for
 * Paperdetail entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.online.domain.Paperdetail
 * @author MyEclipse Persistence Tools
 */

public interface PaperdetailDAO_Interface 
 {
	public void save(Paperdetail transientInstance);
	public void delete(Paperdetail persistentInstance);
	public Paperdetail findById(java.lang.Integer id);
	public List findByExample(Paperdetail instance);
	public List findByProperty(String propertyName, Object value);
	public List findByValidFlag(Object validFlag);
	public List findAll();
	public Paperdetail merge(Paperdetail detachedInstance);
	public void attachDirty(Paperdetail instance);
	public void attachClean(Paperdetail instance);
}