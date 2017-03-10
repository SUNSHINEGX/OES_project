package org.matrix.dao.impl;

import java.util.List;

import org.hibernate.Hibernate;
import org.matrix.dao.QuestionDao;
import org.matrix.pojo.ExamType;
import org.matrix.pojo.Question;

public class QuestionDaoImpl extends MyHibernateDaoSupport implements
		QuestionDao {
	/**
	 * 删除试题实体，删除一条试题记录
	 * @param question 删除的试题实例
	 */
	public void delete(Question question) {
		getHibernateTemplate().delete(question);
	}
	
	/**
	 * 根据主键删除试题实体，删除一条试题记录
	 * @param id 删除的试题实例
	 */
	public void delete(int id) {
		getHibernateTemplate().delete(get(id));
	}
	
	/**
	 * 根据页码查询试题列表
	 * @param pageNo 查询的页码
	 * @param pageSize 每页显示的试题数
	 * @return 指定页的试题列表
	 */
	public List<Question> findAllByPage(int pageNo, int pageSize) {
		if(pageNo<1){
			return null;
		}
		int offset = (pageNo-1)*pageSize;
		return findByPage("from Question", offset, pageSize);
	}
	
	/**
	 * 根据试题id,试题类型查找试题
	 * @param id 需要查询的试题id
	 * @param examType 考试类型
	 * @return 指定id，对应考试类型的试题
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
	 * 根据主键加载试题
	 * @param id 需要加载的试题的主键值
	 * @return 加载的试题PO
	 */
	public Question get(int id) {
		Question q = (Question)getHibernateTemplate().load(Question.class, id);
		Hibernate.initialize(q);
		return q;
	}
	
	/**
	 * 查询试题的最大id
	 * @return 试题的最大id
	 */
	public int getMaxId() {
		List questionList = getHibernateTemplate().find("select max(question.id) from Question question");
		if(questionList==null){
			return 0;
		}
		return (Integer)questionList.get(0);
	}
	
	/**
	 * 查询试题的数量
	 * @return 试题的数量
	 */
	public long getQuestionCount() {
		List questionList = getHibernateTemplate().find("select count(question.id) from Question question");
		if(questionList==null){
			return 0;
		}
		return (Long)questionList.get(0);
	}
	
	/**
	 * 保存试题实体，新增一条试题记录
	 * @param question 保存的试题实例
	 */
	public void save(Question question) {
		getHibernateTemplate().save(question);
	}
	
	/**
	 * 更新一条试题记录
	 * @param question 需要更新的试题
	 */
	public void update(Question question) {
		getHibernateTemplate().update(question);
	}

}
