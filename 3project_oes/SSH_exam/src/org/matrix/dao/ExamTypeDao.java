package org.matrix.dao;

import java.util.List;

import org.matrix.pojo.ExamType;




public interface ExamTypeDao {
	
	/**
	 * �����������ؿ��Թ���Ա
	 * @param id ��Ҫ���صĿ��Թ���Ա������ֵ
	 * @return ���صĿ��Թ���ԱPO
	 */
	ExamType get(int id);
	
	/**
	 * ���濼�Թ���Աʵ�壬����һ�����Թ���Ա��¼
	 * @param examType ����Ŀ��Թ���Աʵ��
	 */
	void save(ExamType examType);
	
	/**
	 * ɾ�����Թ���Աʵ�壬ɾ��һ�����Թ���Ա��¼
	 * @param examType ɾ���Ŀ��Թ���Աʵ��
	 */
	void delete(ExamType examType);
	
	/**
	 * ��������ɾ�����Թ���Աʵ�壬ɾ��һ�����Թ���Ա��¼
	 * @param id ɾ���Ŀ��Թ���Աʵ��
	 */
	void delete(int id);
	
	/**
	 * ����һ�����Թ���Ա��¼
	 * @param examType ��Ҫ���µĿ��Թ���Ա
	 */
	void update(ExamType examType);
	
	/**
	 * ��ѯȫ���Ŀ�������
	 * @return ��Ҫ���µĿ��Թ���Ա
	 */
	List<ExamType> findAll();
	
}