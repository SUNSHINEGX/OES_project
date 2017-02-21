package com.cool.john.bean;

public class Choice {
	private int id;
	private String subject;
	private String SelTop;
	private String A;
	private String B;
	private String C;
	private String D;
	private String answer;
	private int level;//0是简单  1是难
	public Choice() {
		super();
		// TODO Auto-generated constructor stub
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
	public String getSelTop() {
		return SelTop;
	}
	public void setSelTop(String selTop) {
		SelTop = selTop;
	}
	public String getA() {
		return A;
	}
	public void setA(String a) {
		A = a;
	}
	public String getB() {
		return B;
	}
	public void setB(String b) {
		B = b;
	}
	public String getC() {
		return C;
	}
	public void setC(String c) {
		C = c;
	}
	public String getD() {
		return D;
	}
	public void setD(String d) {
		D = d;
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
	public Choice(int id, String subject, String selTop, String a, String b,
			String c, String d, String answer, int level) {
		super();
		this.id = id;
		this.subject = subject;
		SelTop = selTop;
		A = a;
		B = b;
		C = c;
		D = d;
		this.answer = answer;
		this.level = level;
	}
	@Override
	public String toString() {
		return "{\"id\":\"" + id + "\", \"subject\":\"" + subject
				+ "\", \"SelTop\":\"" + SelTop + "\", \"A\":\"" + A
				+ "\", \"B\":\"" + B + "\", \"C\":\"" + C + "\", \"D\":\"" + D
				+ "\", \"answer\":\"" + answer + "\", \"level\":\"" + level
				+ "\"}";
	}
	
}
