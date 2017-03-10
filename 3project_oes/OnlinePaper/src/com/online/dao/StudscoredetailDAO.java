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

public class StudscoredetailDAO extends BaseHibernateDAO {
	private static final Log log = LogFactory.getLog(StudscoredetailDAO.class);
	// property constants
	public static final String ANSWER = "answer";
	public static final String SCORE_FOR_ID = "scoreForId";
	public static final String FLAG = "flag";

	public void save(Studscoredetail transientInstance) {
		log.debug("saving Studscoredetail instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Studscoredetail persistentInstance) {
		log.debug("deleting Studscoredetail instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Studscoredetail findById(java.lang.Integer id) {
		log.debug("getting Studscoredetail instance with id: " + id);
		try {
			Studscoredetail instance = (Studscoredetail) getSession().get(
					"com.online.domain.Studscoredetail", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Studscoredetail instance) {
		log.debug("finding Studscoredetail instance by example");
		try {
			List results = getSession().createCriteria(
					"com.online.domain.Studscoredetail").add(
					Example.create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Studscoredetail instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from Studscoredetail as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByAnswer(Object answer) {
		return findByProperty(ANSWER, answer);
	}

	public List findByScoreForId(Object scoreForId) {
		return findByProperty(SCORE_FOR_ID, scoreForId);
	}

	public List findByFlag(Object flag) {
		return findByProperty(FLAG, flag);
	}

	public List findAll() {
		log.debug("finding all Studscoredetail instances");
		try {
			String queryString = "from Studscoredetail";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Studscoredetail merge(Studscoredetail detachedInstance) {
		log.debug("merging Studscoredetail instance");
		try {
			Studscoredetail result = (Studscoredetail) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Studscoredetail instance) {
		log.debug("attaching dirty Studscoredetail instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Studscoredetail instance) {
		log.debug("attaching clean Studscoredetail instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}