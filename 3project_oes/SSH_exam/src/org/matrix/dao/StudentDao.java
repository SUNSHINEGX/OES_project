package org.matrix.dao;

import java.util.List;

import org.matrix.pojo.Student;



public interface StudentDao {
	
	/**
	 * ������������ѧ��
	 * @param id ��Ҫ���ص�ѧ��������ֵ
	 * @return ���ص�ѧ��PO
	 */
	Student get(int id);
	
	/**
	 * ����ѧ��ʵ�壬����һ��ѧ����¼
	 * @param student �����ѧ��ʵ��
	 */
	void save(Student student);
	
	/**
	 * ɾ��ѧ��ʵ�壬ɾ��һ��ѧ����¼
	 * @param student ɾ����ѧ��ʵ��
	 */
	void delete(Student student);
	
	/**
	 * ��������ɾ��ѧ��ʵ�壬ɾ��һ��ѧ����¼
	 * @param id ɾ����ѧ��ʵ��
	 */
	void delete(int id);
	
	/**
	 * ����һ��ѧ����¼
	 * @param student ��Ҫ���µ�ѧ��
	 */
	void update(Student student);
	
	/**
	 * ����ѧ�ź�������ѯѧ��
	 * @param name ��Ҫ��ѯ��ѧ������
	 * @param stuNumber ѧ��
	 * @return �������ֺ�ѧ�Ų�ѯ������ѧ���б�
	 */
	List<Student> findStudentByNameAndStuNumber(String name,String stuNumber);
	
	/**
	 * ����ҳ���ѯѧ���б�
	 * @param pageNo ��ѯ��ҳ��
	 * @param pageSize ÿҳ��ʾ��ѧ����
	 * @return ָ��ҳ��ѧ���б�
	 */
	List<Student> findAllByPage(int pageNo,int pageSize);
	
	/**
	 * ��ѯѧ��������
	 * @return ѧ��������
	 */
	long getStudentCount();
}