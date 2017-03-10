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

public class PaperdetailDAO extends BaseHibernateDAO  implements PaperdetailDAO_Interface {
	private static final Log log = LogFactory.getLog(PaperdetailDAO.class);
	// property constants
	public static final String VALID_FLAG = "validFlag";

	public void save(Paperdetail transientInstance) {
		log.debug("saving Paperdetail instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Paperdetail persistentInstance) {
		log.debug("deleting Paperdetail instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Paperdetail findById(java.lang.Integer id) {
		log.debug("getting Paperdetail instance with id: " + id);
		try {
			Paperdetail instance = (Paperdetail) getSession().get(
					"com.online.domain.Paperdetail", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Paperdetail instance) {
		log.debug("finding Paperdetail instance by example");
		try {
			List results = getSession().createCriteria(
					"com.online.domain.Paperdetail").add(
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
		log.debug("finding Paperdetail instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Paperdetail as model where model."
					+ propertyName + "= ?  order by paperDetailId ";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByValidFlag(Object validFlag) {
		return findByProperty(VALID_FLAG, validFlag);
	}

	public List findAll() {
		log.debug("finding all Paperdetail instances");
		try {
			String queryString = "from Paperdetail";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Paperdetail merge(Paperdetail detachedInstance) {
		log.debug("merging Paperdetail instance");
		try {
			Paperdetail result = (Paperdetail) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Paperdetail instance) {
		log.debug("attaching dirty Paperdetail instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Paperdetail instance) {
		log.debug("attaching clean Paperdetail instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}