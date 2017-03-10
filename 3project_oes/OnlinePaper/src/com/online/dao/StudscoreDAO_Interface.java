package com.online.dao;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;

import com.online.domain.Studscore;


/**
 * A data access object (DAO) providing persistence and search support for
 * Studscore entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.online.domain.Studscore
 * @author MyEclipse Persistence Tools
 */

public interface StudscoreDAO_Interface {
	public void save(Studscore transientInstance);
	public void delete(Studscore persistentInstance);
	public Studscore findById(java.lang.Integer id);
	public List findByExample(Studscore instance);
	public List findByProperty(String propertyName, Object value);
	public List findByStudAnswer(Object studAnswer);
	public List findAll();
	public Studscore merge(Studscore detachedInstance);
	public void attachDirty(Studscore instance);
	public void attachClean(Studscore instance);
}