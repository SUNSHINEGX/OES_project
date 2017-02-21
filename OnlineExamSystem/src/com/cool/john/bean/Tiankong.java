package com.cool.john.bean;

public class Tiankong {
	private int id;
	private String subject;
	private String FillTop;
	private String answer;
	private int level;
	public Tiankong() {
		super();
	}
	public Tiankong(int id, String subject, String fillTop, String answer,
			int level) {
		super();
		this.id = id;
		this.subject = subject;
		FillTop = fillTop;
		this.answer = answer;
		this.level = level;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getFillTop() {
		return FillTop;
	}
	public void setFillTop(String fillTop) {
		FillTop = fillTop;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	@Override
	public String toString() {
		return "{\"id\":\"" + id + "\", \"subject\":\"" + subject
				+ "\", \"FillTop\":\"" + FillTop + "\", \"answer\":\"" + answer
				+ "\", \"level\":\"" + level + "\"}";
	}
}
