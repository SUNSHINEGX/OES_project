package com.cool.john.bean;

public class Score {
	private int ScoreID = 0;
	private String StuNum = null;
	private String StuName = null;
	private String subject = null;
	private String classNo = null;
	private int SelScore = 0;
	private int FillScore = 0;
	private int QaScore = 0;
	private int Total = 0;
	
	private String address = null;
	
	
	public Score(){
		super();
	}
	
	//提交试卷
	public Score(String StuNum,
			String StuName,String subject,String classNo,
			int SelScore,int FillScore,int QaScore,
			int Total,String address){
		this.StuNum = StuNum;
		this.StuName = StuName;
		this.subject = subject;
		this.classNo = classNo;
		this.SelScore = SelScore;
		this.FillScore = FillScore;
		this.QaScore = QaScore;
		this.Total = Total;
		this.address = address;
	}
	//学生成绩查询
	public Score(int SelScore,int FillScore,int QaScore,int Total,String address,String subject){
		this.SelScore = SelScore;
		this.FillScore = FillScore;
		this.QaScore = QaScore;
		this.Total = Total;
		this.address = address;
		this.subject = subject;
	}
	
	public int getScoreID() {
		return ScoreID;
	}
	public void setScoreID(int scoreID) {
		ScoreID = scoreID;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "{\"StuNum\":\"" + StuNum + "\",\"StuName\":\"" + StuName
				+ "\",\"subject\":\"" + subject + "\",\"classNo\":\"" + classNo
				+ "\",\"SelScore\":\"" + SelScore + "\",\"FillScore\":\""
				+ FillScore + "\",\"QaScore\":\"" + QaScore + "\",\"Total\":\""
				+ Total + "\",\"address\":\"" + address
				+ "\"}";
	}


}
