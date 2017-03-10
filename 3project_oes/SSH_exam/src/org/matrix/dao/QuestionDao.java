package org.matrix.dao;

import java.util.List;

import org.matrix.pojo.ExamType;
import org.matrix.pojo.Question;




public interface QuestionDao {
	
	/**
	 * ����������������
	 * @param id ��Ҫ���ص����������ֵ
	 * @return ���ص�����PO
	 */
	Question get(int id);
	
	/**
	 * ��������ʵ�壬����һ�������¼
	 * @param question ���������ʵ��
	 */
	void save(Question question);
	
	/**
	 * ɾ������ʵ�壬ɾ��һ�������¼
	 * @param question ɾ��������ʵ��
	 */
	void delete(Question question);
	
	/**
	 * ��������ɾ������ʵ�壬ɾ��һ�������¼
	 * @param id ɾ��������ʵ��
	 */
	void delete(int id);
	
	/**
	 * ����һ�������¼
	 * @param question ��Ҫ���µ�����
	 */
	void update(Question question);
	
	/**
	 * ����ҳ���ѯ�����б�
	 * @param pageNo ��ѯ��ҳ��
	 * @param pageSize ÿҳ��ʾ��������
	 * @return ָ��ҳ�������б�
	 */
	List<Question> findAllByPage(int pageNo,int pageSize);
	
	/**
	 * ��������id,�������Ͳ�������
	 * @param id ��Ҫ��ѯ������id
	 * @param question ��������
	 * @return ָ��id����Ӧ�������͵�����
	 */
	Question findQuestionByExamType(int id,ExamType examType);
	
	/**
	 * ��ѯ��������id
	 * @return ��������id
	 */
	int getMaxId();
	
	/**
	 * ��ѯ���������
	 * @return ���������
	 */
	long getQuestionCount();
}