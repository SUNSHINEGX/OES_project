package org.matrix.dao.impl;

import java.util.List;

import org.hibernate.Hibernate;
import org.matrix.dao.QuestionDao;
import org.matrix.pojo.ExamType;
import org.matrix.pojo.Question;

public class QuestionDaoImpl extends MyHibernateDaoSupport implements
		QuestionDao {
	/**
	 * ɾ������ʵ�壬ɾ��һ�������¼
	 * @param question ɾ��������ʵ��
	 */
	public void delete(Question question) {
		getHibernateTemplate().delete(question);
	}
	
	/**
	 * ��������ɾ������ʵ�壬ɾ��һ�������¼
	 * @param id ɾ��������ʵ��
	 */
	public void delete(int id) {
		getHibernateTemplate().delete(get(id));
	}
	
	/**
	 * ����ҳ���ѯ�����б�
	 * @param pageNo ��ѯ��ҳ��
	 * @param pageSize ÿҳ��ʾ��������
	 * @return ָ��ҳ�������б�
	 */
	public List<Question> findAllByPage(int pageNo, int pageSize) {
		if(pageNo<1){
			return null;
		}
		int offset = (pageNo-1)*pageSize;
		return findByPage("from Question", offset, pageSize);
	}
	
	/**
	 * ��������id,�������Ͳ�������
	 * @param id ��Ҫ��ѯ������id
	 * @param examType ��������
	 * @return ָ��id����Ӧ�������͵�����
	 */
	public Question findQuestionByExamType(int id, ExamType examType) {
		Question question = get(id);
		if(question==null){
			return null;
		}
		if(question.getExamType().getId()==examType.getId()){
			return question;
		}
		return null;
	}
	
	/**
	 * ����������������
	 * @param id ��Ҫ���ص����������ֵ
	 * @return ���ص�����PO
	 */
	public Question get(int id) {
		Question q = (Question)getHibernateTemplate().load(Question.class, id);
		Hibernate.initialize(q);
		return q;
	}
	
	/**
	 * ��ѯ��������id
	 * @return ��������id
	 */
	public int getMaxId() {
		List questionList = getHibernateTemplate().find("select max(question.id) from Question question");
		if(questionList==null){
			return 0;
		}
		return (Integer)questionList.get(0);
	}
	
	/**
	 * ��ѯ���������
	 * @return ���������
	 */
	public long getQuestionCount() {
		List questionList = getHibernateTemplate().find("select count(question.id) from Question question");
		if(questionList==null){
			return 0;
		}
		return (Long)questionList.get(0);
	}
	
	/**
	 * ��������ʵ�壬����һ�������¼
	 * @param question ���������ʵ��
	 */
	public void save(Question question) {
		getHibernateTemplate().save(question);
	}
	
	/**
	 * ����һ�������¼
	 * @param question ��Ҫ���µ�����
	 */
	public void update(Question question) {
		getHibernateTemplate().update(question);
	}

}
