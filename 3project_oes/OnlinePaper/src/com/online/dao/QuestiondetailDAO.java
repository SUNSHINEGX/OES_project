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

public class QuestiondetailDAO extends BaseHibernateDAO implements QuestiondetailDAO_Interface {
	private static final Log log = LogFactory.getLog(QuestiondetailDAO.class);
	// property constants
	public static final String OPTION_NO = "optionNo";
	public static final String OPTION_CONTENT = "optionContent";

	public void save(Questiondetail transientInstance) {
		log.debug("saving Questiondetail instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Questiondetail persistentInstance) {
		log.debug("deleting Questiondetail instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Questiondetail findById(java.lang.Integer id) {
		log.debug("getting Questiondetail instance with id: " + id);
		try {
			Questiondetail instance = (Questiondetail) getSession().get(
					"com.online.domain.Questiondetail", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Questiondetail instance) {
		log.debug("finding Questiondetail instance by example");
		try {
			List results = getSession().createCriteria(
					"com.online.domain.Questiondetail").add(
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
		log.debug("finding Questiondetail instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from Questiondetail as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByOptionNo(Object optionNo) {
		return findByProperty(OPTION_NO, optionNo);
	}

	public List findByOptionContent(Object optionContent) {
		return findByProperty(OPTION_CONTENT, optionContent);
	}

	public List findAll() {
		log.debug("finding all Questiondetail instances");
		try {
			String queryString = "from Questiondetail";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Questiondetail merge(Questiondetail detachedInstance) {
		log.debug("merging Questiondetail instance");
		try {
			Questiondetail result = (Questiondetail) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Questiondetail instance) {
		log.debug("attaching dirty Questiondetail instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Questiondetail instance) {
		log.debug("attaching clean Questiondetail instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}