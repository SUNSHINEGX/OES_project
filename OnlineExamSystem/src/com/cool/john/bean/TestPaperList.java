package com.cool.john.bean;

public class TestPaperList {
	private String subject;
	private String examTime;
	private String examDate;
	private String beginTime;
	private String endTime;
	public TestPaperList() {
		super();
		// TODO 自动生成的构造函数存根
	}
	public TestPaperList(String subject, String examTime, String examDate,
			String beginTime, String endTime) {
		super();
		this.subject = subject;
		this.examTime = examTime;
		this.examDate = examDate;
		this.beginTime = beginTime;
		this.endTime = endTime;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getExamTime() {
		return examTime;
	}
	public void setExamTime(String examTime) {
		this.examTime = examTime;
	}
	public String getExamDate() {
		return examDate;
	}
	public void setExamDate(String examDate) {
		this.examDate = examDate;
	}
	public String getBeginTime() {
		return beginTime;
	}
	public void setBeginTime(String beginTime) {
		this.beginTime = beginTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	@Override
	public String toString() {
		return "{\"subject\":\"" + subject + "\", \"examTime\":\"" + examTime
				+ "\", \"examDate\":\"" + examDate + "\", \"beginTime\":\""
				+ beginTime + "\", \"endTime\":\"" + endTime + "\"}";
	}

}
