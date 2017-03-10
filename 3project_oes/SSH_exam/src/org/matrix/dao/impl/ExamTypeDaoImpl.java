package org.matrix.dao.impl;

import java.util.List;

import org.matrix.dao.ExamTypeDao;
import org.matrix.pojo.ExamType;

public class ExamTypeDaoImpl extends MyHibernateDaoSupport implements
		ExamTypeDao {
	/**
	 * ɾ�����Թ���Աʵ�壬ɾ��һ�����Թ���Ա��¼
	 * @param examType ɾ���Ŀ��Թ���Աʵ��
	 */
	public void delete(ExamType examType) {
		getHibernateTemplate().delete(examType);
	}
	
	/**
	 * ��������ɾ�����Թ���Աʵ�壬ɾ��һ�����Թ���Ա��¼
	 * @param id ɾ���Ŀ��Թ���Աʵ��
	 */
	public void delete(int id) {
		getHibernateTemplate().delete(get(id));
	}
	
	/**
	 * ��ѯȫ���Ŀ�������
	 * @return ��Ҫ���µĿ��Թ���Ա
	 */
	public List<ExamType> findAll() {
		return getHibernateTemplate().find("from ExamType");
	}
	
	/**
	 * �����������ؿ��Թ���Ա
	 * @param id ��Ҫ���صĿ��Թ���Ա������ֵ
	 * @return ���صĿ��Թ���ԱPO
	 */
	public ExamType get(int id) {
		return (ExamType) getHibernateTemplate().load(ExamType.class, new Integer(id));
	}
	
	/**
	 * ���濼�Թ���Աʵ�壬����һ�����Թ���Ա��¼
	 * @param examType ����Ŀ��Թ���Աʵ��
	 */
	public void save(ExamType examType) {
		getHibernateTemplate().save(examType);
	}
	
	/**
	 * ����һ�����Թ���Ա��¼
	 * @param examType ��Ҫ���µĿ��Թ���Ա
	 */
	public void update(ExamType examType) {
		getHibernateTemplate().update(examType);
	}

}
