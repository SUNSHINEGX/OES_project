package com.online.dao;

import java.util.List;
import java.util.Set;
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

public class StudscoreDAO extends BaseHibernateDAO implements StudscoreDAO_Interface{
	private static final Log log = LogFactory.getLog(StudscoreDAO.class);
	// property constants
	public static final String SCORE = "score";

	public void save(Studscore transientInstance) {
		log.debug("saving Studscore instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Studscore persistentInstance) {
		log.debug("deleting Studscore instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Studscore findById(java.lang.Integer id) {
		log.debug("getting Studscore instance with id: " + id);
		try {
			Studscore instance = (Studscore) getSession().get(
					"com.online.domain.Studscore", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Studscore instance) {
		log.debug("finding Studscore instance by example");
		try {
			List results = getSession().createCriteria(
					"com.online.domain.Studscore")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Studscore instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Studscore as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByScore(Object score) {
		return findByProperty(SCORE, score);
	}

	public List findAll() {
		log.debug("finding all Studscore instances");
		try {
			String queryString = "from Studscore";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Studscore merge(Studscore detachedInstance) {
		log.debug("merging Studscore instance");
		try {
			Studscore result = (Studscore) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Studscore instance) {
		log.debug("attaching dirty Studscore instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Studscore instance) {
		log.debug("attaching clean Studscore instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public List findByStudAnswer(Object studAnswer) {
		// TODO Auto-generated method stub
		return null;
	}
}