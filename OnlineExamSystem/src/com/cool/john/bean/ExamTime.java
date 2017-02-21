package com.cool.john.bean;

public class ExamTime {
	private String examSubject;
	private String examTime;
	private String examDate;
	private String examBegin;
	private String examEnd;
	public ExamTime() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ExamTime(String examSubject, String examTime, String examDate,
			String examBegin, String examEnd) {
		super();
		this.examSubject = examSubject;
		this.examTime = examTime;
		this.examDate = examDate;
		this.examBegin = examBegin;
		this.examEnd = examEnd;
	}
	public String getExamSubject() {
		return examSubject;
	}
	public void setExamSubject(String examSubject) {
		this.examSubject = examSubject;
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
	public String getExamBegin() {
		return examBegin;
	}
	public void setExamBegin(String examBegin) {
		this.examBegin = examBegin;
	}
	public String getExamEnd() {
		return examEnd;
	}
	public void setExamEnd(String examEnd) {
		this.examEnd = examEnd;
	}
	@Override
	public String toString() {
		return "{\"examSubject\":\"" + examSubject + "\", \"examTime\":\""
				+ examTime + "\", \"examDate\":\"" + examDate
				+ "\", \"examBegin\":\"" + examBegin + "\", \"examEnd\":\""
				+ examEnd + "\"}";
	}
	
	
	
}
