package org.matrix.dao;

import java.util.List;

import org.matrix.pojo.ExamType;




public interface ExamTypeDao {
	
	/**
	 * 根据主键加载考试管理员
	 * @param id 需要加载的考试管理员的主键值
	 * @return 加载的考试管理员PO
	 */
	ExamType get(int id);
	
	/**
	 * 保存考试管理员实体，新增一条考试管理员记录
	 * @param examType 保存的考试管理员实例
	 */
	void save(ExamType examType);
	
	/**
	 * 删除考试管理员实体，删除一条考试管理员记录
	 * @param examType 删除的考试管理员实例
	 */
	void delete(ExamType examType);
	
	/**
	 * 根据主键删除考试管理员实体，删除一条考试管理员记录
	 * @param id 删除的考试管理员实例
	 */
	void delete(int id);
	
	/**
	 * 更新一条考试管理员记录
	 * @param examType 需要更新的考试管理员
	 */
	void update(ExamType examType);
	
	/**
	 * 查询全部的考试类型
	 * @return 需要更新的考试管理员
	 */
	List<ExamType> findAll();
	
}