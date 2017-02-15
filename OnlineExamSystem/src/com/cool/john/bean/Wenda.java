package com.cool.john.bean;

public class Wenda {
	private int id;
	private String subject;
	private String QaTop;
	private int level;
	public Wenda() {
		super();
	}
	public Wenda(int id, String subject, String qaTop, int level) {
		super();
		this.id = id;
		this.subject = subject;
		QaTop = qaTop;
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
	public String getQaTop() {
		return QaTop;
	}
	public void setQaTop(String qaTop) {
		QaTop = qaTop;
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
				+ "\", \"QaTop\":\"" + QaTop + "\", \"level\":\"" + level
				+ "\"}";
	}
}
