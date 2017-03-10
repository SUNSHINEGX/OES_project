package org.matrix.dao;

import java.util.List;

import org.matrix.pojo.Student;



public interface StudentDao {
	
	/**
	 * 根据主键加载学生
	 * @param id 需要加载的学生的主键值
	 * @return 加载的学生PO
	 */
	Student get(int id);
	
	/**
	 * 保存学生实体，新增一条学生记录
	 * @param student 保存的学生实例
	 */
	void save(Student student);
	
	/**
	 * 删除学生实体，删除一条学生记录
	 * @param student 删除的学生实例
	 */
	void delete(Student student);
	
	/**
	 * 根据主键删除学生实体，删除一条学生记录
	 * @param id 删除的学生实例
	 */
	void delete(int id);
	
	/**
	 * 更新一条学生记录
	 * @param student 需要更新的学生
	 */
	void update(Student student);
	
	/**
	 * 根据学号和姓名查询学生
	 * @param name 需要查询的学生姓名
	 * @param stuNumber 学号
	 * @return 符合名字和学号查询条件的学生列表
	 */
	List<Student> findStudentByNameAndStuNumber(String name,String stuNumber);
	
	/**
	 * 根据页码查询学生列表
	 * @param pageNo 查询的页码
	 * @param pageSize 每页显示的学生数
	 * @return 指定页的学生列表
	 */
	List<Student> findAllByPage(int pageNo,int pageSize);
	
	/**
	 * 查询学生的数量
	 * @return 学生的数量
	 */
	long getStudentCount();
}