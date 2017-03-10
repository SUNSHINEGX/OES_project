package org.matrix.dao.impl;

import java.util.List;

import org.matrix.dao.StudentDao;
import org.matrix.pojo.Student;

public class StudentDaoImpl extends MyHibernateDaoSupport implements StudentDao {
	
	/**
	 * 删除学生实体，删除一条学生记录
	 * @param student 删除的学生实例
	 */
	public void delete(Student student) {
		getHibernateTemplate().delete(student);
	}
	
	/**
	 * 根据主键删除学生实体，删除一条学生记录
	 * @param id 删除的学生实例
	 */
	public void delete(int id) {
		getHibernateTemplate().delete(get(id));
	}
	
	/**
	 * 根据页码查询学生列表
	 * @param pageNo 查询的页码
	 * @param pageSize 每页显示的学生数
	 * @return 指定页的学生列表
	 */
	public List<Student> findAllByPage(int pageNo, int pageSize) {
		if(pageNo<1){
			return null;
		}
		int offset = (pageNo-1)*pageSize;
		return findByPage("from Student", offset, pageSize);
	}
	
	/**
	 * 根据学号和姓名查询学生
	 * @param name 需要查询的学生姓名
	 * @param stuNumber 学号
	 * @return 符合名字和学号查询条件的学生列表
	 */
	public List<Student> findStudentByNameAndStuNumber(String name,
			String stuNumber) {
		return getHibernateTemplate().find("from Student student where student.stuNumber=? and student.name=?", new String[]{stuNumber,name});
	}

	/**
	 * 根据主键加载学生
	 * @param id 需要加载的学生的主键值
	 * @return 加载的学生PO
	 */
	public Student get(int id) {
		return (Student)getHibernateTemplate().load(Student.class, new Integer(id));
	}
	
	/**
	 * 查询学生的数量
	 * @return 学生的数量
	 */
	public long getStudentCount() {
		List studentList = getHibernateTemplate().find("select count(student.id) from Student student");
		if(studentList==null){
			return 0;
		}
		return (Long)studentList.get(0);
	}
	
	/**
	 * 保存学生实体，新增一条学生记录
	 * @param student 保存的学生实例
	 */
	public void save(Student student) {
		getHibernateTemplate().save(student);
	}
	
	/**
	 * 更新一条学生记录
	 * @param student 需要更新的学生
	 */
	public void update(Student student) {
		getHibernateTemplate().update(student);
	}

}
