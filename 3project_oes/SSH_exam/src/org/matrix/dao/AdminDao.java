package org.matrix.dao;

import java.util.List;

import org.matrix.pojo.Admin;




public interface AdminDao {
	
	/**
	 * �����������ؿ��Թ���Ա
	 * @param id ��Ҫ���صĿ��Թ���Ա������ֵ
	 * @return ���صĿ��Թ���ԱPO
	 */
	Admin get(int id);
	
	/**
	 * ���濼�Թ���Աʵ�壬����һ�����Թ���Ա��¼
	 * @param Admin ����Ŀ��Թ���Աʵ��
	 */
	void save(Admin admin);
	
	/**
	 * ɾ�����Թ���Աʵ�壬ɾ��һ�����Թ���Ա��¼
	 * @param Admin ɾ���Ŀ��Թ���Աʵ��
	 */
	void delete(Admin admin);
	
	/**
	 * ��������ɾ�����Թ���Աʵ�壬ɾ��һ�����Թ���Ա��¼
	 * @param id ɾ���Ŀ��Թ���Աʵ��
	 */
	void delete(int id);
	
	/**
	 * ����һ�����Թ���Ա��¼
	 * @param Admin ��Ҫ���µĿ��Թ���Ա
	 */
	void update(Admin admin);
	
	/**
	 * �����û�����������ҿ��Թ���Ա
	 * @param name �û���
	 * @param pass ����
	 * @return �����û�����������ҵ��Ŀ��Թ���Ա�б�
	 */
	List<Admin> findAdminByNameAndPass(String name,String pass);
	
	
}