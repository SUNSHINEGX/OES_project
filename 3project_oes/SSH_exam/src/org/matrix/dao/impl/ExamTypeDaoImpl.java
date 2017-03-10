package org.matrix.dao.impl;

import java.util.List;

import org.matrix.dao.ExamTypeDao;
import org.matrix.pojo.ExamType;

public class ExamTypeDaoImpl extends MyHibernateDaoSupport implements
		ExamTypeDao {
	/**
	 * 删除考试管理员实体，删除一条考试管理员记录
	 * @param examType 删除的考试管理员实例
	 */
	public void delete(ExamType examType) {
		getHibernateTemplate().delete(examType);
	}
	
	/**
	 * 根据主键删除考试管理员实体，删除一条考试管理员记录
	 * @param id 删除的考试管理员实例
	 */
	public void delete(int id) {
		getHibernateTemplate().delete(get(id));
	}
	
	/**
	 * 查询全部的考试类型
	 * @return 需要更新的考试管理员
	 */
	public List<ExamType> findAll() {
		return getHibernateTemplate().find("from ExamType");
	}
	
	/**
	 * 根据主键加载考试管理员
	 * @param id 需要加载的考试管理员的主键值
	 * @return 加载的考试管理员PO
	 */
	public ExamType get(int id) {
		return (ExamType) getHibernateTemplate().load(ExamType.class, new Integer(id));
	}
	
	/**
	 * 保存考试管理员实体，新增一条考试管理员记录
	 * @param examType 保存的考试管理员实例
	 */
	public void save(ExamType examType) {
		getHibernateTemplate().save(examType);
	}
	
	/**
	 * 更新一条考试管理员记录
	 * @param examType 需要更新的考试管理员
	 */
	public void update(ExamType examType) {
		getHibernateTemplate().update(examType);
	}

}
