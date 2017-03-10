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
	 * ����һ��ѧ��ʵ������ӦΪ����һ��ѧ���ļ�¼
	 * @param stuNumber ѧ��
	 * @param name ����
	 * @param classname �༶
	 * @param humanId ���
	 * @param email ����
	 * @param address ��ַ
	 * @param phone �绰
	 * @return ����ѧ��������
	 * @throws ExamException
	 */
	int addStudent(String stuNumber,String name,
			String classname,String humanId,String email,
			String address,String phone) throws ExamException;
	
	/**
	 * ����ѧ��idɾ��ѧ��
	 * @param id ��Ҫɾ����ѧ��������
	 * @throws ExamException
	 */
	void deleteStudent(int id) throws ExamException;
	
	/**
	 * ����ҳ���г�ѧ���б�
	 * @param pageNo ҳ��
	 * @return �г���ѧ���б�
	 * @throws ExamException
	 */
	List<Student> listStudent(int pageNo) throws ExamException;
	
	/**
	 * ����һ�����⣬����һ�������¼
	 * @param quTitle ��Ŀ
	 * @param quHard �Ѷ�
	 * @param quScore ����
	 * @param quAnswer ��
	 * @param quType ����
	 * @param selectOption ����ѡ��
	 * @param examTypeId �����Ӧ�Ŀ�������
	 * @return �������������
	 * @throws ExamException
	 */
	int addQuestion(String quTitle,String quHard,
			Integer quScore,String quAnswer,String quType,
			String selectOption,int examTypeId) throws ExamException;
	
	/**
	 * ��������idɾ������
	 * @param id ��Ҫɾ�������������
	 * @throws ExamException
	 */
	void deleteQuestion(int id) throws ExamException;
	
	/**
	 * ����ҳ���г������б�
	 * @param pageNo
	 * @return �г��������б�
	 * @throws ExamException
	 */
	List<Question> listQuestion(int pageNo) throws ExamException;
	
	/**
	 * ���ݿ�������idɾ����������
	 * @param id ��Ҫɾ���Ŀ������͵�����
	 * @throws ExamException
	 */
	void deleteExamType(int id) throws ExamException;
	
	/**
	 * ������������
	 * @param testTitle ��������
	 * @param testTime ����ʱ��
	 * @return �����Ŀ������͵�id
	 * @throws ExamException
	 */
	int addExamType(String testTitle,String testTime) throws ExamException;
	
	/**
	 * ��ȡ���п�������
	 * @return ���п�������
	 * @throws ExamException
	 */
	List<ExamType> getAllExamType() throws ExamException;
	
	/**
	 * �����û����������ж��û��Ƿ���Գɹ���¼
	 * @param user ��¼�õ��û���
	 * @param pass ��¼�õ�����
	 * @return 
	 * @throws ExamException
	 */
	boolean adminLogin(String user,String pass) throws ExamException;
	
	/**
	 * ��ȡѧ��������
	 * @return ѧ���ĸ���
	 * @throws ExamException
	 */
	int getStudentCount() throws ExamException;
	
	/**
	 * ��ȡ��������
	 * @return ����ĸ���
	 * @throws ExamException
	 */
	int getQuestionCount() throws ExamException;
	
	/**
	 * ����ÿҳ��¼�����ܼ�¼����ȡ��ҳ��
	 * @param count �ܼ�¼��
	 * @param pageSize ÿҳ��ʾ�ļ�¼��
	 * @return ����õ�����ҳ��
	 */
	int getPageCount(int count,int pageSize);
	
	/**
	 * �ж�ѧ���Ƿ���Գɹ���¼
	 * @param name ��¼�õ�ѧ������
	 * @param stuNumber ��¼�õ�ѧ��
	 * @return
	 * @throws ExamException
	 */
	String studentLogin(String name,String stuNumber) throws ExamException;
	
	/**
	 * ���ݿ�������id��ȡ��һ������
	 * @param alreadys �Ѿ��ش������id
	 * @param examTypeId ��������id
	 * @return �ÿ������͵���һ������
	 * @throws ExamException
	 */
	Question getNextQuestion(List<Integer> alreadys,int examTypeId) throws ExamException;
	
	/**
	 * ��������id��ȡ����
	 * @param id ����id
	 * @return ��id��Ӧ������
	 * @throws ExamException
	 */
	Question getQuestionById(int id) throws ExamException;
	
	/**
	 * ���ݿ�������id��ȡ��������
	 * @param typeId ��������id
	 * @return ��id��Ӧ�Ŀ���������
	 * @throws ExamException
	 */
	String getExamTypeName(int typeId) throws ExamException;
	
}
