package org.matrix.dao;

import java.util.List;

import org.matrix.pojo.Admin;




public interface AdminDao {
	
	/**
	 * 根据主键加载考试管理员
	 * @param id 需要加载的考试管理员的主键值
	 * @return 加载的考试管理员PO
	 */
	Admin get(int id);
	
	/**
	 * 保存考试管理员实体，新增一条考试管理员记录
	 * @param Admin 保存的考试管理员实例
	 */
	void save(Admin admin);
	
	/**
	 * 删除考试管理员实体，删除一条考试管理员记录
	 * @param Admin 删除的考试管理员实例
	 */
	void delete(Admin admin);
	
	/**
	 * 根据主键删除考试管理员实体，删除一条考试管理员记录
	 * @param id 删除的考试管理员实例
	 */
	void delete(int id);
	
	/**
	 * 更新一条考试管理员记录
	 * @param Admin 需要更新的考试管理员
	 */
	void update(Admin admin);
	
	/**
	 * 根据用户名和密码查找考试管理员
	 * @param name 用户名
	 * @param pass 密码
	 * @return 根据用户名和密码查找到的考试管理员列表
	 */
	List<Admin> findAdminByNameAndPass(String name,String pass);
	
	
}