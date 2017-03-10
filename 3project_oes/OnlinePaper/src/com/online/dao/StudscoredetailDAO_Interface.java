package com.online.dao;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;

import com.online.domain.Studscoredetail;

/**
 * A data access object (DAO) providing persistence and search support for
 * Studscoredetail entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.online.domain.Studscoredetail
 * @author MyEclipse Persistence Tools
 */

public interface StudscoredetailDAO_Interface  {
	//private static final Log log = LogFactory.getLog(StudscoredetailDAO.class);
	// property constants
	public static final String ANSWER = "answer";
	public static final String SCORE_FOR_ID = "scoreForId";
	public static final String FLAG = "flag";

	public void save(Studscoredetail transientInstance);

	public void delete(Studscoredetail persistentInstance);

	public Studscoredetail findById(java.lang.Integer id);

	public List findByExample(Studscoredetail instance);

	public List findByProperty(String propertyName, Object value);
	public List findByAnswer(Object answer);

	public List findByScoreForId(Object scoreForId);

	public List findByFlag(Object flag);

	public List findAll();

	public Studscoredetail merge(Studscoredetail detachedInstance);

	public void attachDirty(Studscoredetail instance);

	public void attachClean(Studscoredetail instance);
}