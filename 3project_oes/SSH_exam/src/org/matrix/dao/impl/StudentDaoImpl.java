package org.matrix.dao.impl;

import java.util.List;

import org.matrix.dao.StudentDao;
import org.matrix.pojo.Student;

public class StudentDaoImpl extends MyHibernateDaoSupport implements StudentDao {
	
	/**
	 * ɾ��ѧ��ʵ�壬ɾ��һ��ѧ����¼
	 * @param student ɾ����ѧ��ʵ��
	 */
	public void delete(Student student) {
		getHibernateTemplate().delete(student);
	}
	
	/**
	 * ��������ɾ��ѧ��ʵ�壬ɾ��һ��ѧ����¼
	 * @param id ɾ����ѧ��ʵ��
	 */
	public void delete(int id) {
		getHibernateTemplate().delete(get(id));
	}
	
	/**
	 * ����ҳ���ѯѧ���б�
	 * @param pageNo ��ѯ��ҳ��
	 * @param pageSize ÿҳ��ʾ��ѧ����
	 * @return ָ��ҳ��ѧ���б�
	 */
	public List<Student> findAllByPage(int pageNo, int pageSize) {
		if(pageNo<1){
			return null;
		}
		int offset = (pageNo-1)*pageSize;
		return findByPage("from Student", offset, pageSize);
	}
	
	/**
	 * ����ѧ�ź�������ѯѧ��
	 * @param name ��Ҫ��ѯ��ѧ������
	 * @param stuNumber ѧ��
	 * @return �������ֺ�ѧ�Ų�ѯ������ѧ���б�
	 */
	public List<Student> findStudentByNameAndStuNumber(String name,
			String stuNumber) {
		return getHibernateTemplate().find("from Student student where student.stuNumber=? and student.name=?", new String[]{stuNumber,name});
	}

	/**
	 * ������������ѧ��
	 * @param id ��Ҫ���ص�ѧ��������ֵ
	 * @return ���ص�ѧ��PO
	 */
	public Student get(int id) {
		return (Student)getHibernateTemplate().load(Student.class, new Integer(id));
	}
	
	/**
	 * ��ѯѧ��������
	 * @return ѧ��������
	 */
	public long getStudentCount() {
		List studentList = getHibernateTemplate().find("select count(student.id) from Student student");
		if(studentList==null){
			return 0;
		}
		return (Long)studentList.get(0);
	}
	
	/**
	 * ����ѧ��ʵ�壬����һ��ѧ����¼
	 * @param student �����ѧ��ʵ��
	 */
	public void save(Student student) {
		getHibernateTemplate().save(student);
	}
	
	/**
	 * ����һ��ѧ����¼
	 * @param student ��Ҫ���µ�ѧ��
	 */
	public void update(Student student) {
		getHibernateTemplate().update(student);
	}

}
