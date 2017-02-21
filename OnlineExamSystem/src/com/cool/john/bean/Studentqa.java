package com.cool.john.bean;

public class Studentqa {
	private int id;
	private int StuNum;
	private String subject;
	private String QaTop;
	private String answer;
	public Studentqa() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Studentqa(int id, int stuNum, String subject, String qaTop,
			String answer) {
		super();
		this.id = id;
		StuNum = stuNum;
		this.subject = subject;
		QaTop = qaTop;
		this.answer = answer;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getStuNum() {
		return StuNum;
	}
	public void setStuNum(int stuNum) {
		StuNum = stuNum;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getQaTop() {
		return QaTop;
	}
	public void setQaTop(String qaTop) {
		QaTop = qaTop;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	@Override
	public String toString() {
		return "{\"id\":\"" + id + "\", \"StuNum\":\"" + StuNum
				+ "\", \"subject\":\"" + subject + "\", \"QaTop\":\"" + QaTop
				+ "\", \"answer\":\"" + answer + "\"}";
	}
	
	
}
