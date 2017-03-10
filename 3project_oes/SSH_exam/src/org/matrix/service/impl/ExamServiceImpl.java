package org.matrix.service.impl;

import java.util.List;

import org.matrix.dao.AdminDao;
import org.matrix.dao.ExamTypeDao;
import org.matrix.dao.QuestionDao;
import org.matrix.dao.StudentDao;
import org.matrix.exception.ExamException;
import org.matrix.pojo.ExamType;
import org.matrix.pojo.Question;
import org.matrix.pojo.Student;
import org.matrix.service.ExamService;

public class ExamServiceImpl implements ExamService {

    private AdminDao adminDao;
    private ExamTypeDao examTypeDao;
    private QuestionDao questionDao;
    private StudentDao studentDao;

    public void setAdminDao(AdminDao adminDao) {
        this.adminDao = adminDao;
    }

    public void setExamTypeDao(ExamTypeDao examTypeDao) {
        this.examTypeDao = examTypeDao;
    }

    public void setQuestionDao(QuestionDao questionDao) {
        this.questionDao = questionDao;
    }

    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    /**
     * ������������
     * @param testTitle ��������
     * @param testTime ����ʱ��
     * @return �����Ŀ������͵�id
     * @throws ExamException
     */
    public int addExamType(String testTitle, String testTime)
            throws ExamException {
        try {
            ExamType et = new ExamType(testTitle,testTime);
            examTypeDao.save(et);
            return et.getId();
        } catch (Exception e) {
            e.printStackTrace();
            throw new ExamException("��ӿ�������ʱ�����쳣�������ԣ�");
        }
    }

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
    public int addQuestion(String quTitle, String quHard, Integer quScore,
            String quAnswer, String quType, String selectOption, int examTypeId)
            throws ExamException {
        try {
            ExamType examType = examTypeDao.get(examTypeId);
            if(examType==null){
                throw new ExamException("�����ڸÿ������ͣ�������ѡ��");
            }

            Question question = new Question(quTitle, quHard,quScore,
                    quAnswer, quType, selectOption,examType);
            questionDao.save(question);
            return question.getId();
        } catch (Exception e) {
            e.printStackTrace();
            throw new ExamException("�����������쳣�������ԣ�");
        }
    }

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
    public int addStudent(String stuNumber, String name, String classname,
            String humanId, String email, String address, String phone)
            throws ExamException {
        try {
            Student student = new Student(stuNumber,name,classname,humanId,email,address,phone);
            studentDao.save(student);
            return student.getId();
        } catch (Exception e) {
            e.printStackTrace();
            throw new ExamException("���ѧ��ʱ�����쳣�������ԣ�");
        }
    }

    /**
     * �����û����������ж��û��Ƿ���Գɹ���¼
     * @param user ��¼�õ��û���
     * @param pass ��¼�õ�����
     * @return
     * @throws ExamException
     */
    public boolean adminLogin(String user, String pass) throws ExamException {
        try {
            List result = adminDao.findAdminByNameAndPass(user, pass);
            if(result!=null&&result.size()>0){
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            throw new ExamException("ϵͳ����Ա��¼�����쳣�������ԣ�");
        }
    }

    /**
     * ���ݿ�������idɾ����������
     * @param id ��Ҫɾ���Ŀ������͵�����
     * @throws ExamException
     */
    public void deleteExamType(int id) throws ExamException {
        try {
            examTypeDao.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ExamException("ɾ����������ʱ�����쳣�������ԣ�");
        }
    }

    /**
     * ��������idɾ������
     * @param id ��Ҫɾ�������������
     * @throws ExamException
     */
    public void deleteQuestion(int id) throws ExamException {
        try {
            questionDao.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ExamException("ɾ������ʱ�����쳣�������ԣ�");
        }
    }

    /**
     * ����ѧ��idɾ��ѧ��
     * @param id ��Ҫɾ����ѧ��������
     * @throws ExamException
     */
    public void deleteStudent(int id) throws ExamException {
        try {
            studentDao.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ExamException("ɾ��ѧ��ʱ�����쳣�������ԣ�");
        }
    }

    /**
     * ��ȡ���п�������
     * @return ���п�������
     * @throws ExamException
     */
    public List<ExamType> getAllExamType() throws ExamException {

        return examTypeDao.findAll();
    }

    /**
     * ���ݿ�������id��ȡ��������
     * @param typeId ��������id
     * @return ��id��Ӧ�Ŀ���������
     * @throws ExamException
     */
    public String getExamTypeName(int typeId) throws ExamException {
        try {
            return examTypeDao.get(typeId).getExamName();
        } catch (Exception e) {
            e.printStackTrace();
            throw new ExamException("��ȡ�������ͳ����쳣�������ԣ�");
        }
    }

    /**
     * ���ݿ�������id��ȡ��һ������
     * @param alreadys �Ѿ��ش������id
     * @param examTypeId ��������id
     * @return �ÿ������͵���һ������
     * @throws ExamException
     */
    public Question getNextQuestion(List<Integer> alreadys, int examTypeId)
            throws ExamException {
        try {
            //��ȡָ������
            ExamType examType = examTypeDao.get(examTypeId);
            if(examType==null){
                throw new ExamException("�����ڸÿ������ͣ�������ѡ��");
            }
            //��ȡquestion�������id��
            int maxId = questionDao.getMaxId();

            //ֱ����ȡ1����ȷ����Ŀʱ���˳�ѭ��
            REPEAT_TRY:
                while(true){
                    //����һ�������������������������id
                    int randomId = (int)Math.round(Math.random()*maxId)+1;
                    //����Ѵ�������鲻Ϊ�գ��жϻ�ȡ�����Ƿ������Ѵ���������
                    if(alreadys!=null){
                        for(int alreadyId:alreadys){
                            if(alreadyId==randomId){
                                //��������������������Ϊ(REPEAT_TRY)��whileѭ������һ��ѭ�������»�ȡ�����
                                continue REPEAT_TRY;
                            }
                        }
                    }
                    Question question = null;
                    //�����ȡ��Ŀ�����쳣�����¿�ʼѭ������ȡ��һ��
                    try {
                        //ÿ���������ȡ��һ����Ŀ��������Ŀ�Ƿ�����ָ��ExamType,ͬʱ��Ҫ����Ƿ��Ѿ�����
                        question = questionDao.findQuestionByExamType(randomId, examType);
                        if(question==null){//û���ҵ�idΪ���������Ŀ������ѭ��ֱ���ҵ�
                            continue;
                        }
                    } catch (Exception e) {
                        continue;
                    }
                    //������˵����������ȡһ����Ŀ�������˳�ѭ��������Ŀ����
                    return question;
                }
        } catch (Exception e) {
            e.printStackTrace();
            throw new ExamException("��ȡ��һ������ʱ�����쳣�������ԣ�");
        }
    }

    /**
     * ����ÿҳ��¼�����ܼ�¼����ȡ��ҳ��
     * @param count �ܼ�¼��
     * @param pageSize ÿҳ��ʾ�ļ�¼��
     * @return ����õ�����ҳ��
     */
    public int getPageCount(int count, int pageSize) {
        return (count+pageSize-1)/pageSize;
    }

    /**
     * ��������id��ȡ����
     * @param id ����id
     * @return ��id��Ӧ������
     * @throws ExamException
     */
    public Question getQuestionById(int id) throws ExamException {

        try {
            return questionDao.get(id);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ExamException("����id��ȡ��������쳣�������ԣ�");
        }
    }

    /**
     * ��ȡ��������
     * @return ����ĸ���
     * @throws ExamException
     */
    public int getQuestionCount() throws ExamException {
        try {
            return (int)questionDao.getQuestionCount();
        } catch (Exception e) {
            e.printStackTrace();
            throw new ExamException("��ȡ��������ʱ�����쳣�������ԣ�");
        }
    }

    /**
     * ��ȡѧ��������
     * @return ѧ���ĸ���
     * @throws ExamException
     */
    public int getStudentCount() throws ExamException {
        try {
            return (int)studentDao.getStudentCount();
        } catch (Exception e) {
            e.printStackTrace();
            throw new ExamException("��ȡѧ������ʱ�����쳣�������ԣ�");
        }
    }

    /**
     * ����ҳ���г������б�
     * @param pageNo
     * @return �г��������б�
     * @throws ExamException
     */
    public List<Question> listQuestion(int pageNo) throws ExamException {
        try {
            return questionDao.findAllByPage(pageNo, QUESTION_PAGE_SIZE);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ExamException("�г���������ʱ�����쳣�������ԣ�");
        }
    }

    /**
     * ����ҳ���г�ѧ���б�
     * @param pageNo ҳ��
     * @return �г���ѧ���б�
     * @throws ExamException
     */
    public List<Student> listStudent(int pageNo) throws ExamException {
        try {
            return studentDao.findAllByPage(pageNo, STUDENT_PAGE_SIZE);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ExamException("�г�ѧ��ʱ�����쳣�������ԣ�");
        }

    }

    /**
     * �ж�ѧ���Ƿ���Գɹ���¼
     * @param name ��¼�õ�ѧ������
     * @param stuNumber ��¼�õ�ѧ��
     * @return
     * @throws ExamException
     */
    public String studentLogin(String name, String stuNumber)
            throws ExamException {
        try {
            List result = studentDao.findStudentByNameAndStuNumber(name, stuNumber);
            if(result!=null&&result.size()>0){
                return name;
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            throw new ExamException("ѧ����¼�����쳣�������ԣ�");
        }
    }

}
