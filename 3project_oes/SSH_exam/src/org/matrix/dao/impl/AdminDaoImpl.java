package org.matrix.dao.impl;

import java.util.List;

import org.matrix.dao.AdminDao;
import org.matrix.pojo.Admin;

public class AdminDaoImpl extends MyHibernateDaoSupport implements AdminDao {

	/**
	 * ɾ�����Թ���Աʵ�壬ɾ��һ�����Թ���Ա��¼
	 * @param Admin ɾ���Ŀ��Թ���Աʵ��
	 */
	public void delete(Admin admin) {
		getHibernateTemplate().delete(admin);
	}
	
	/**
	 * ��������ɾ�����Թ���Աʵ�壬ɾ��һ�����Թ���Ա��¼
	 * @param id ɾ���Ŀ��Թ���Աʵ��
	 */
	public void delete(int id) {
		getHibernateTemplate().delete(get(id));
	}
	
	/**
	 * �����û�����������ҿ��Թ���Ա
	 * @param name �û���
	 * @param pass ����
	 * @return �����û�����������ҵ��Ŀ��Թ���Ա�б�
	 */
	public List<Admin> findAdminByNameAndPass(String name, String pass) {
		String[] args = {name,pass};
		return getHibernateTemplate().find("from Admin admin where admin.username=? and admin.password=?",args);
	}
	
	/**
	 * �����������ؿ��Թ���Ա
	 * @param id ��Ҫ���صĿ��Թ���Ա������ֵ
	 * @return ���صĿ��Թ���ԱPO
	 */
	public Admin get(int id) {
		
		return (Admin)getHibernateTemplate().load(Admin.class, new Integer(id));
	}
	
	/**
	 * ���濼�Թ���Աʵ�壬����һ�����Թ���Ա��¼
	 * @param admin ����Ŀ��Թ���Աʵ��
	 */
	public void save(Admin admin) {
		getHibernateTemplate().save(admin);
	}
	
	/**
	 * ����һ�����Թ���Ա��¼
	 * @param Admin ��Ҫ���µĿ��Թ���Ա
	 */
	public void update(Admin admin) {
		getHibernateTemplate().update(admin);
	}

}
