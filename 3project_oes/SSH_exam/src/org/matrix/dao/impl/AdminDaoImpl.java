package org.matrix.dao.impl;

import java.util.List;

import org.matrix.dao.AdminDao;
import org.matrix.pojo.Admin;

public class AdminDaoImpl extends MyHibernateDaoSupport implements AdminDao {

	/**
	 * 删除考试管理员实体，删除一条考试管理员记录
	 * @param Admin 删除的考试管理员实例
	 */
	public void delete(Admin admin) {
		getHibernateTemplate().delete(admin);
	}
	
	/**
	 * 根据主键删除考试管理员实体，删除一条考试管理员记录
	 * @param id 删除的考试管理员实例
	 */
	public void delete(int id) {
		getHibernateTemplate().delete(get(id));
	}
	
	/**
	 * 根据用户名和密码查找考试管理员
	 * @param name 用户名
	 * @param pass 密码
	 * @return 根据用户名和密码查找到的考试管理员列表
	 */
	public List<Admin> findAdminByNameAndPass(String name, String pass) {
		String[] args = {name,pass};
		return getHibernateTemplate().find("from Admin admin where admin.username=? and admin.password=?",args);
	}
	
	/**
	 * 根据主键加载考试管理员
	 * @param id 需要加载的考试管理员的主键值
	 * @return 加载的考试管理员PO
	 */
	public Admin get(int id) {
		
		return (Admin)getHibernateTemplate().load(Admin.class, new Integer(id));
	}
	
	/**
	 * 保存考试管理员实体，新增一条考试管理员记录
	 * @param admin 保存的考试管理员实例
	 */
	public void save(Admin admin) {
		getHibernateTemplate().save(admin);
	}
	
	/**
	 * 更新一条考试管理员记录
	 * @param Admin 需要更新的考试管理员
	 */
	public void update(Admin admin) {
		getHibernateTemplate().update(admin);
	}

}
