package  com.online.dao;

import java.util.List;
import java.util.Set;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;

import com.online.domain.Studentinfo;


/**
 * A data access object (DAO) providing persistence and search support for
 * Studentinfo entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.online.domain.Studentinfo
 * @author MyEclipse Persistence Tools
 */

public interface StudentinfoDAO_Interface 
{
 public void save(Studentinfo transientInstance);
 public void delete(Studentinfo persistentInstance);
 public Studentinfo findById(java.lang.Integer id);
 public List findByExample(Studentinfo instance);
 public List findByProperty(String propertyName, Object value);
 public List findByName(Object name);
 public List findByAge(Object age);
 public List findBySex(Object sex);
 public List findByGrade(Object grade);
 public List findByTeacher(Object teacher);
 public List findAll();
 public Studentinfo merge(Studentinfo detachedInstance);
 public void attachDirty(Studentinfo instance);
 public void attachClean(Studentinfo instance);
}