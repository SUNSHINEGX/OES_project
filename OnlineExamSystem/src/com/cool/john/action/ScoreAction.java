package com.cool.john.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.apache.struts2.ServletActionContext;

import com.cool.john.bean.Score;
import com.cool.john.bean.Studentqa;
import com.cool.john.service.ScoreService;
import com.cool.john.service.StudentqaService;
import com.cool.john.util.ScoreUtil;

public class ScoreAction {
	ScoreUtil su = new ScoreUtil();
	private ScoreService scoreService;
	private StudentqaService studentqaService;
	
	public StudentqaService getStudentqaService() {
		return studentqaService;
	}
	public void setStudentqaService(StudentqaService studentqaService) {
		this.studentqaService = studentqaService;
	}

	private Score score;
	private String content;
	//����
	private String StuNum;
	private String StuName;
	private String subject;
	private String classNo;
	private String Qatop;
	
	public String getQatop() {
		return Qatop;
	}
	public void setQatop(String qatop) {
		Qatop = qatop;
	}

	private int	SelScore;
	private int FillScore;
	private int QaScore;
	private int Total;
	private int sign;
	private int StudenNum;
	
	public int getStudenNum() {
		return StudenNum;
	}
	public void setStudenNum(int studenNum) {
		StudenNum = studenNum;
	}
	public int getSign() {
		return sign;
	}
	public void setSign(int sign) {
		this.sign = sign;
	}
	public String getStuNum() {
		return StuNum;
	}
	public void setStuNum(String stuNum) {
		StuNum = stuNum;
	}
	public String getStuName() {
		return StuName;
	}
	public void setStuName(String stuName) {
		StuName = stuName;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getClassNo() {
		return classNo;
	}
	public void setClassNo(String classNo) {
		this.classNo = classNo;
	}
	public int getSelScore() {
		return SelScore;
	}
	public void setSelScore(int selScore) {
		SelScore = selScore;
	}
	public int getFillScore() {
		return FillScore;
	}
	public void setFillScore(int fillScore) {
		FillScore = fillScore;
	}
	public int getQaScore() {
		return QaScore;
	}
	public void setQaScore(int qaScore) {
		QaScore = qaScore;
	}
	public int getTotal() {
		return Total;
	}
	public void setTotal(int total) {
		Total = total;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}

	private static final String path = "D:\\eclipse_Workspace\\ExamOL\\WebContent\\ExamFiles\\";
	private static final String dbpath = "ExamFiles/";
	
	
	public ScoreService getScoreService() {
		return scoreService;
	}
	public void setScoreService(ScoreService scoreService) {
		this.scoreService = scoreService;
	}
	public Score getScore() {
		return score;
	}
	public void setScore(Score score) {
		this.score = score;
	}
	
	//ִ�к���
	public void run(){
		//�ϴ��Ծ�
		if(this.sign == 0){
			try {
				this.UploadExam();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//��ȡ��óɼ�
		else if(this.sign == 1){
			try {
				this.getSubList();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//ͨ����Ŀ��óɼ�
		else if(this.sign == 2){
			try {
				this.getListBySub();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//��ʦ�鿴ѧ���ɼ�
		else if(this.sign == 3){
			try {
				this.getScoreBySub();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//��ʦͨ��ѧ�Ų�ѯ�ɼ�
		else if(this.sign == 5){
			try {
				this.getSubList();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//��ʦͨ��������ѯ�ɼ�
		else if(this.sign == 6){
			try {
				this.getScoreByStuName();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		//��ʦͨ���༶��ѯ�ɼ�
		else if(this.sign == 4){
			try {
				this.getScoreByClass();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//�����ʴ�������
				else if(this.sign == 7){
					try {
						this.updateQas();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
		//��������ѧ���ɼ�
				else if(this.sign == 8){
					try {
						this.getScoreList();
					} catch (IOException e) {
						// TODO �Զ����ɵ� catch ��
						e.printStackTrace();
					}
				}
		//����Աͨ�����༶
				else if(this.sign == 9){
					try {
						this.getAdClass();
					} catch (IOException e) {
						// TODO �Զ����ɵ� catch ��
						e.printStackTrace();
					}
				}
		//����Աͨ����ѧ��
				else if(this.sign == 10){
					try {
						this.getAdStuNum();
					} catch (IOException e) {
						// TODO �Զ����ɵ� catch ��
						e.printStackTrace();
					}
				}
		//����Աͨ��������
				else if(this.sign == 11) {
					try {
						this.getAdStuName();
					} catch (IOException e) {
						// TODO �Զ����ɵ� catch ��
						e.printStackTrace();
					}
				}
	}
	
	//-----------------�ָ���------------------------------
	//����Ա��������ѯ
	public void getAdStuName() throws IOException{
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		this.StuName =  java.net.URLDecoder.decode(this.StuName,"UTF-8");
		
		//���ɶ���
		Score sc = new Score();
		sc.setStuName(this.StuName);
		//��ѯ���ݿ�
		List list = this.getScoreService().findAdStuName(sc);
		//listת����json
		JSONArray jsonarray = JSONArray.fromObject(list); 
		
		out.write(jsonarray.toString());
	}
	//����Ա��ѧ�Ų�ѯ
	public void getAdStuNum() throws IOException{
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		this.StuNum =  java.net.URLDecoder.decode(this.StuNum,"UTF-8");
		
		//���ɶ���
		Score sc = new Score();
		sc.setStuNum(this.StuNum);
		//��ѯ���ݿ�
		List list = this.getScoreService().findAdStuNum(sc);
		//listת����json
		JSONArray jsonarray = JSONArray.fromObject(list); 
		
		out.write(jsonarray.toString());
	}
	//����Ա���༶��ѯ
	public void getAdClass() throws IOException{
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		this.classNo =  java.net.URLDecoder.decode(this.classNo,"UTF-8");
		
		//���ɶ���
		Score sc = new Score();
		sc.setClassNo(this.classNo);
		//��ѯ���ݿ�
		List list = this.getScoreService().findAdClass(sc);
		//listת����json
		JSONArray jsonarray = JSONArray.fromObject(list); 
		
		out.write(jsonarray.toString());
	}
	//�����ʴ�������
		public void updateQas() throws IOException{
			this.StuNum = java.net.URLDecoder.decode(this.StuNum,"UTF-8");
			this.subject = java.net.URLDecoder.decode(this.subject,"UTF-8");
			this.Qatop = java.net.URLDecoder.decode(this.Qatop,"UTF-8");
			//���ɶ���
			Score sc = new Score();
			sc.setStuNum(this.StuNum);
			sc.setSubject(this.subject);
			//����StudentQa
			Studentqa sq = new Studentqa();
			sq.setStuNum(this.StudenNum);
			sq.setQaTop(this.Qatop);
			System.out.println(sq);
			
			//�����ʴ�������
			this.getScoreService().updateQa(sc,this.QaScore);
			//�����ܷ�
			this.getScoreService().update(sc);
			//ɾ��StudentQa
			this.getStudentqaService().deleteStudentqa(sq);
		}
	//��ʦͨ��������ѯ�ɼ�
	public void getScoreByStuName() throws IOException{
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		this.StuName = java.net.URLDecoder.decode(this.StuName,"UTF-8");
		this.subject = java.net.URLDecoder.decode(this.subject,"UTF-8");
		
		//���ɶ���
		Score sc = new Score();
		sc.setStuName(this.StuName);
		sc.setSubject(this.subject);
		
		//��ѯ���ݿ�
		List list = this.getScoreService().findStuName(sc);
		//listת����json
		JSONArray jsonarray = JSONArray.fromObject(list);
		
		out.write(jsonarray.toString());
	}
	
	//��ʦͨ���༶��ѯ�ɼ�
	public void getScoreByClass() throws IOException{
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		this.subject =  java.net.URLDecoder.decode(this.subject,"UTF-8");
		this.classNo = java.net.URLDecoder.decode(this.classNo,"UTF-8");
		
		//���ɶ���
		Score sc = new Score();
		sc.setClassNo(this.classNo);
		sc.setSubject(this.subject);
		
		//��ѯ���ݿ�
		List list = this.getScoreService().findClass(sc);
		//listת����json
		JSONArray jsonarray = JSONArray.fromObject(list);
		
		out.write(jsonarray.toString());
	}
	//ͨ����Ŀ��óɼ��б�
	public void getScoreBySub() throws IOException{
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		this.subject = java.net.URLDecoder.decode(this.subject,"UTF-8");
		
		//���ɶ���
		Score sc = new Score();
		sc.setSubject(this.subject);
		
		//��ѯ���ݿ�
		List list = this.getScoreService().findOnlySub(sc);
		//listת����json
		JSONArray jsonarray = JSONArray.fromObject(list);
		
		out.write(jsonarray.toString());
	}
	
	
	//��ʦͨ��ѧ�Ų�ѯ�ɼ�
	//��getSubList����������ͬ
	
	//��ʦ���ѧ���ɼ��б�
	public void getScoreList() throws IOException{
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		//��ѯ���ݿ�
		List list = this.getScoreService().find();
		//listת����json
		JSONArray jsonarray = JSONArray.fromObject(list);
		System.out.println(jsonarray.toString());
		out.write(jsonarray.toString());
	}
	
	
	//------------ͨ����Ŀ��óɼ��б�-----------------------------
	public void getListBySub() throws IOException{
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		this.subject = java.net.URLDecoder.decode(this.subject,"UTF-8");
		
		//���ɶ���
		Score sc = new Score();
		sc.setStuNum(this.StuNum);
		sc.setSubject(this.subject);
		
		//��ѯ���ݿ�
		List list = this.getScoreService().findSub(sc);
		//listת����json
		JSONArray jsonarray = JSONArray.fromObject(list);
		
		out.write(jsonarray.toString());
	}
	
	//--------------------��óɼ��б�-------------------------------
	public void getSubList() throws IOException{
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		this.subject =  java.net.URLDecoder.decode(this.subject,"UTF-8");
		
		//���ɶ���
		Score sc = new Score();
		sc.setStuNum(this.StuNum);
		sc.setSubject(this.subject);
		//��ѯ���ݿ�
		List list = this.getScoreService().findScore(sc);
		//listת����json
		JSONArray jsonarray = JSONArray.fromObject(list); 
		
		out.write(jsonarray.toString());
	}
	
	//�ϴ��Ծ�
	public void UploadExam() throws IOException{
		
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		//�����ļ����֣����ظ�
		String file = su.fileName();
		//����
		this.content = java.net.URLDecoder.decode(this.content,"UTF-8");
		this.StuName = java.net.URLDecoder.decode(this.StuName,"UTF-8");
		this.subject = java.net.URLDecoder.decode(this.subject,"UTF-8");
		
		//���ɶ���
		Score sc = new Score(
				this.getStuNum(), //ѧ��
				this.getStuName(),//����
				this.getSubject(),//��Ŀ
				this.getClassNo(),//�༶
				this.getSelScore(),//ѡ�������
				this.getFillScore(),//��������
				this.getQaScore(),//�ʴ������
				this.getTotal(),//�ܷ�
				null); //��ַ	
//		System.out.println(this.content);
		
		//���浽�ļ�
		  
		try{
			su.saveAsFileWriter(this.content, path+file);
			//���ļ�·���������
			sc.setAddress(dbpath+file);
			//�Ѷ������ݴ������ݿ�
			this.getScoreService().insert(sc);
			
			//���سɹ�!
			out.write("success");
			
		}catch(IOException e){
			//����ʧ��!
			out.write("fail");
		}
		out.close();
	}
}
