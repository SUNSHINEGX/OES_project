package com.online.dao;

import java.util.Date;
import java.util.List;
import java.util.Set;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;

import com.online.domain.Paper;


/**
 * A data access object (DAO) providing persistence and search support for Paper
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see com.online.domain.Paper
 * @author MyEclipse Persistence Tools
 */

public interface PaperDAO_Interface {
	public void save(Paper transientInstance);
	public void delete(Paper persistentInstance);
	public Paper findById(java.lang.Integer id);
	public List findByExample(Paper instance);
	public List findByProperty(String propertyName, Object value);
	public List findByFullScore(Object fullScore);
	public List findAll();
	public Paper merge(Paper detachedInstance);
	public void attachDirty(Paper instance);
	public void attachClean(Paper instance);
}