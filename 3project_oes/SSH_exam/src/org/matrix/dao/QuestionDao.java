package org.matrix.dao;

import java.util.List;

import org.matrix.pojo.ExamType;
import org.matrix.pojo.Question;




public interface QuestionDao {
	
	/**
	 * 根据主键加载试题
	 * @param id 需要加载的试题的主键值
	 * @return 加载的试题PO
	 */
	Question get(int id);
	
	/**
	 * 保存试题实体，新增一条试题记录
	 * @param question 保存的试题实例
	 */
	void save(Question question);
	
	/**
	 * 删除试题实体，删除一条试题记录
	 * @param question 删除的试题实例
	 */
	void delete(Question question);
	
	/**
	 * 根据主键删除试题实体，删除一条试题记录
	 * @param id 删除的试题实例
	 */
	void delete(int id);
	
	/**
	 * 更新一条试题记录
	 * @param question 需要更新的试题
	 */
	void update(Question question);
	
	/**
	 * 根据页码查询试题列表
	 * @param pageNo 查询的页码
	 * @param pageSize 每页显示的试题数
	 * @return 指定页的试题列表
	 */
	List<Question> findAllByPage(int pageNo,int pageSize);
	
	/**
	 * 根据试题id,试题类型查找试题
	 * @param id 需要查询的试题id
	 * @param question 考试类型
	 * @return 指定id，对应考试类型的试题
	 */
	Question findQuestionByExamType(int id,ExamType examType);
	
	/**
	 * 查询试题的最大id
	 * @return 试题的最大id
	 */
	int getMaxId();
	
	/**
	 * 查询试题的数量
	 * @return 试题的数量
	 */
	long getQuestionCount();
}