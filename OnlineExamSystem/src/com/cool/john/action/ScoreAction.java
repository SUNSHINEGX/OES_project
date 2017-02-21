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
	//数据
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
	
	//执行函数
	public void run(){
		//上传试卷
		if(this.sign == 0){
			try {
				this.UploadExam();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//获取获得成绩
		else if(this.sign == 1){
			try {
				this.getSubList();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//通过科目获得成绩
		else if(this.sign == 2){
			try {
				this.getListBySub();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//教师查看学生成绩
		else if(this.sign == 3){
			try {
				this.getScoreBySub();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//教师通过学号查询成绩
		else if(this.sign == 5){
			try {
				this.getSubList();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//教师通过姓名查询成绩
		else if(this.sign == 6){
			try {
				this.getScoreByStuName();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		//教师通过班级查询成绩
		else if(this.sign == 4){
			try {
				this.getScoreByClass();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//更新问答题数据
				else if(this.sign == 7){
					try {
						this.updateQas();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
		//查找所有学生成绩
				else if(this.sign == 8){
					try {
						this.getScoreList();
					} catch (IOException e) {
						// TODO 自动生成的 catch 块
						e.printStackTrace();
					}
				}
		//管理员通过按班级
				else if(this.sign == 9){
					try {
						this.getAdClass();
					} catch (IOException e) {
						// TODO 自动生成的 catch 块
						e.printStackTrace();
					}
				}
		//管理员通过按学号
				else if(this.sign == 10){
					try {
						this.getAdStuNum();
					} catch (IOException e) {
						// TODO 自动生成的 catch 块
						e.printStackTrace();
					}
				}
		//管理员通过按姓名
				else if(this.sign == 11) {
					try {
						this.getAdStuName();
					} catch (IOException e) {
						// TODO 自动生成的 catch 块
						e.printStackTrace();
					}
				}
	}
	
	//-----------------分割线------------------------------
	//管理员按姓名查询
	public void getAdStuName() throws IOException{
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		this.StuName =  java.net.URLDecoder.decode(this.StuName,"UTF-8");
		
		//生成对象
		Score sc = new Score();
		sc.setStuName(this.StuName);
		//查询数据库
		List list = this.getScoreService().findAdStuName(sc);
		//list转换成json
		JSONArray jsonarray = JSONArray.fromObject(list); 
		
		out.write(jsonarray.toString());
	}
	//管理员按学号查询
	public void getAdStuNum() throws IOException{
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		this.StuNum =  java.net.URLDecoder.decode(this.StuNum,"UTF-8");
		
		//生成对象
		Score sc = new Score();
		sc.setStuNum(this.StuNum);
		//查询数据库
		List list = this.getScoreService().findAdStuNum(sc);
		//list转换成json
		JSONArray jsonarray = JSONArray.fromObject(list); 
		
		out.write(jsonarray.toString());
	}
	//管理员按班级查询
	public void getAdClass() throws IOException{
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		this.classNo =  java.net.URLDecoder.decode(this.classNo,"UTF-8");
		
		//生成对象
		Score sc = new Score();
		sc.setClassNo(this.classNo);
		//查询数据库
		List list = this.getScoreService().findAdClass(sc);
		//list转换成json
		JSONArray jsonarray = JSONArray.fromObject(list); 
		
		out.write(jsonarray.toString());
	}
	//更新问答题数据
		public void updateQas() throws IOException{
			this.StuNum = java.net.URLDecoder.decode(this.StuNum,"UTF-8");
			this.subject = java.net.URLDecoder.decode(this.subject,"UTF-8");
			this.Qatop = java.net.URLDecoder.decode(this.Qatop,"UTF-8");
			//生成对象
			Score sc = new Score();
			sc.setStuNum(this.StuNum);
			sc.setSubject(this.subject);
			//生成StudentQa
			Studentqa sq = new Studentqa();
			sq.setStuNum(this.StudenNum);
			sq.setQaTop(this.Qatop);
			System.out.println(sq);
			
			//更新问答题数据
			this.getScoreService().updateQa(sc,this.QaScore);
			//更新总分
			this.getScoreService().update(sc);
			//删除StudentQa
			this.getStudentqaService().deleteStudentqa(sq);
		}
	//教师通过姓名查询成绩
	public void getScoreByStuName() throws IOException{
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		this.StuName = java.net.URLDecoder.decode(this.StuName,"UTF-8");
		this.subject = java.net.URLDecoder.decode(this.subject,"UTF-8");
		
		//生成对象
		Score sc = new Score();
		sc.setStuName(this.StuName);
		sc.setSubject(this.subject);
		
		//查询数据库
		List list = this.getScoreService().findStuName(sc);
		//list转换成json
		JSONArray jsonarray = JSONArray.fromObject(list);
		
		out.write(jsonarray.toString());
	}
	
	//教师通过班级查询成绩
	public void getScoreByClass() throws IOException{
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		this.subject =  java.net.URLDecoder.decode(this.subject,"UTF-8");
		this.classNo = java.net.URLDecoder.decode(this.classNo,"UTF-8");
		
		//生成对象
		Score sc = new Score();
		sc.setClassNo(this.classNo);
		sc.setSubject(this.subject);
		
		//查询数据库
		List list = this.getScoreService().findClass(sc);
		//list转换成json
		JSONArray jsonarray = JSONArray.fromObject(list);
		
		out.write(jsonarray.toString());
	}
	//通过科目获得成绩列表
	public void getScoreBySub() throws IOException{
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		this.subject = java.net.URLDecoder.decode(this.subject,"UTF-8");
		
		//生成对象
		Score sc = new Score();
		sc.setSubject(this.subject);
		
		//查询数据库
		List list = this.getScoreService().findOnlySub(sc);
		//list转换成json
		JSONArray jsonarray = JSONArray.fromObject(list);
		
		out.write(jsonarray.toString());
	}
	
	
	//教师通过学号查询成绩
	//与getSubList函数功能相同
	
	//教师获得学生成绩列表
	public void getScoreList() throws IOException{
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		//查询数据库
		List list = this.getScoreService().find();
		//list转换成json
		JSONArray jsonarray = JSONArray.fromObject(list);
		System.out.println(jsonarray.toString());
		out.write(jsonarray.toString());
	}
	
	
	//------------通过科目获得成绩列表-----------------------------
	public void getListBySub() throws IOException{
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		this.subject = java.net.URLDecoder.decode(this.subject,"UTF-8");
		
		//生成对象
		Score sc = new Score();
		sc.setStuNum(this.StuNum);
		sc.setSubject(this.subject);
		
		//查询数据库
		List list = this.getScoreService().findSub(sc);
		//list转换成json
		JSONArray jsonarray = JSONArray.fromObject(list);
		
		out.write(jsonarray.toString());
	}
	
	//--------------------获得成绩列表-------------------------------
	public void getSubList() throws IOException{
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		this.subject =  java.net.URLDecoder.decode(this.subject,"UTF-8");
		
		//生成对象
		Score sc = new Score();
		sc.setStuNum(this.StuNum);
		sc.setSubject(this.subject);
		//查询数据库
		List list = this.getScoreService().findScore(sc);
		//list转换成json
		JSONArray jsonarray = JSONArray.fromObject(list); 
		
		out.write(jsonarray.toString());
	}
	
	//上传试卷
	public void UploadExam() throws IOException{
		
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		//计算文件名字，不重复
		String file = su.fileName();
		//解码
		this.content = java.net.URLDecoder.decode(this.content,"UTF-8");
		this.StuName = java.net.URLDecoder.decode(this.StuName,"UTF-8");
		this.subject = java.net.URLDecoder.decode(this.subject,"UTF-8");
		
		//生成对象
		Score sc = new Score(
				this.getStuNum(), //学号
				this.getStuName(),//姓名
				this.getSubject(),//科目
				this.getClassNo(),//班级
				this.getSelScore(),//选择题分数
				this.getFillScore(),//填空题分数
				this.getQaScore(),//问答题分数
				this.getTotal(),//总分
				null); //地址	
//		System.out.println(this.content);
		
		//保存到文件
		  
		try{
			su.saveAsFileWriter(this.content, path+file);
			//把文件路径放入对象
			sc.setAddress(dbpath+file);
			//把对象数据存入数据库
			this.getScoreService().insert(sc);
			
			//返回成功!
			out.write("success");
			
		}catch(IOException e){
			//返回失败!
			out.write("fail");
		}
		out.close();
	}
}
