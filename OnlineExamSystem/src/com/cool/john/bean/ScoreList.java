package com.cool.john.bean;

public class ScoreList {
	private int ScoreID;
	private String stuNum;
	private String stuName;
	private String subject;
	private String classNum;
	private int selScore;
	private int fillScore;
	private int qaScore;
	private int total;
	private String address;
	
	public ScoreList() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ScoreList(String stuNum, String stuName, String subject,
			String classNum, int selScore, int fillScore, int qaScore, int total) {
		super();
		this.stuNum = stuNum;
		this.stuName = stuName;
		this.subject = subject;
		this.classNum = classNum;
		this.selScore = selScore;
		this.fillScore = fillScore;
		this.qaScore = qaScore;
		this.total = total;
	}

	public int getScoreID() {
		return ScoreID;
	}

	public void setScoreID(int scoreID) {
		ScoreID = scoreID;
	}

	public String getStuNum() {
		return stuNum;
	}

	public void setStuNum(String stuNum) {
		this.stuNum = stuNum;
	}

	public String getStuName() {
		return stuName;
	}

	public void setStuName(String stuName) {
		this.stuName = stuName;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getClassNum() {
		return classNum;
	}

	public void setClassNum(String classNum) {
		this.classNum = classNum;
	}

	public int getSelScore() {
		return selScore;
	}

	public void setSelScore(int selScore) {
		this.selScore = selScore;
	}

	public int getFillScore() {
		return fillScore;
	}

	public void setFillScore(int fillScore) {
		this.fillScore = fillScore;
	}

	public int getQaScore() {
		return qaScore;
	}

	public void setQaScore(int qaScore) {
		this.qaScore = qaScore;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "{\"ScoreID\":\"" + ScoreID + "\", \"stuNum\":\"" + stuNum
				+ "\", \"stuName\":\"" + stuName + "\", \"subject\":\""
				+ subject + "\", \"classNum\":\"" + classNum
				+ "\", \"selScore\":\"" + selScore + "\", \"fillScore\":\""
				+ fillScore + "\", \"qaScore\":\"" + qaScore
				+ "\", \"total\":\"" + total + "\", \"address\":\"" + address
				+ "\"}";
	}
	
	
}
