package org.matrix.service;

import java.util.List;

import org.matrix.exception.ExamException;
import org.matrix.pojo.ExamType;
import org.matrix.pojo.Question;
import org.matrix.pojo.Student;

public interface ExamService {
	int QUESTION_PAGE_SIZE=3;
	int STUDENT_PAGE_SIZE=2;
	
	/**
	 * 增加一个学生实例，对应为增加一条学生的记录
	 * @param stuNumber 学号
	 * @param name 姓名
	 * @param classname 班级
	 * @param humanId 编号
	 * @param email 邮箱
	 * @param address 地址
	 * @param phone 电话
	 * @return 新增学生的主键
	 * @throws ExamException
	 */
	int addStudent(String stuNumber,String name,
			String classname,String humanId,String email,
			String address,String phone) throws ExamException;
	
	/**
	 * 根据学生id删除学生
	 * @param id 需要删除的学生的主键
	 * @throws ExamException
	 */
	void deleteStudent(int id) throws ExamException;
	
	/**
	 * 根据页码列出学生列表
	 * @param pageNo 页码
	 * @return 列出的学生列表
	 * @throws ExamException
	 */
	List<Student> listStudent(int pageNo) throws ExamException;
	
	/**
	 * 增加一个试题，增加一条试题记录
	 * @param quTitle 题目
	 * @param quHard 难度
	 * @param quScore 分数
	 * @param quAnswer 答案
	 * @param quType 类型
	 * @param selectOption 试题选项
	 * @param examTypeId 试题对应的考试类型
	 * @return 新增试题的主键
	 * @throws ExamException
	 */
	int addQuestion(String quTitle,String quHard,
			Integer quScore,String quAnswer,String quType,
			String selectOption,int examTypeId) throws ExamException;
	
	/**
	 * 根据试题id删除试题
	 * @param id 需要删除的试题的主键
	 * @throws ExamException
	 */
	void deleteQuestion(int id) throws ExamException;
	
	/**
	 * 根据页码列出试题列表
	 * @param pageNo
	 * @return 列出的试题列表
	 * @throws ExamException
	 */
	List<Question> listQuestion(int pageNo) throws ExamException;
	
	/**
	 * 根据考试类型id删除考试类型
	 * @param id 需要删除的考试类型的主键
	 * @throws ExamException
	 */
	void deleteExamType(int id) throws ExamException;
	
	/**
	 * 新增考试类型
	 * @param testTitle 考试名称
	 * @param testTime 考试时间
	 * @return 新增的考试类型的id
	 * @throws ExamException
	 */
	int addExamType(String testTitle,String testTime) throws ExamException;
	
	/**
	 * 获取所有考试类型
	 * @return 所有考试类型
	 * @throws ExamException
	 */
	List<ExamType> getAllExamType() throws ExamException;
	
	/**
	 * 根据用户名和密码判断用户是否可以成功登录
	 * @param user 登录用的用户名
	 * @param pass 登录用的密码
	 * @return 
	 * @throws ExamException
	 */
	boolean adminLogin(String user,String pass) throws ExamException;
	
	/**
	 * 获取学生的数量
	 * @return 学生的个数
	 * @throws ExamException
	 */
	int getStudentCount() throws ExamException;
	
	/**
	 * 获取试题数量
	 * @return 试题的个数
	 * @throws ExamException
	 */
	int getQuestionCount() throws ExamException;
	
	/**
	 * 根据每页记录数，总记录数获取总页数
	 * @param count 总记录数
	 * @param pageSize 每页显示的记录数
	 * @return 计算得到的总页数
	 */
	int getPageCount(int count,int pageSize);
	
	/**
	 * 判断学生是否可以成功登录
	 * @param name 登录用的学生姓名
	 * @param stuNumber 登录用的学号
	 * @return
	 * @throws ExamException
	 */
	String studentLogin(String name,String stuNumber) throws ExamException;
	
	/**
	 * 根据考试类型id获取下一个试题
	 * @param alreadys 已经回答的试题id
	 * @param examTypeId 考试类型id
	 * @return 该考试类型的下一个试题
	 * @throws ExamException
	 */
	Question getNextQuestion(List<Integer> alreadys,int examTypeId) throws ExamException;
	
	/**
	 * 根据试题id获取试题
	 * @param id 试题id
	 * @return 该id对应的试题
	 * @throws ExamException
	 */
	Question getQuestionById(int id) throws ExamException;
	
	/**
	 * 根据考试类型id获取考试类型
	 * @param typeId 考试类型id
	 * @return 该id对应的考试类型名
	 * @throws ExamException
	 */
	String getExamTypeName(int typeId) throws ExamException;
	
}
