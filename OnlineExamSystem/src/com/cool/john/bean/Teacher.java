package com.cool.john.bean;

public class Teacher {
	//职工号TeaNum、科目号SubNum、姓名TeaName、密码password、院系department、科目subject
	private String TeaNum;
	private String TeaName;
	private String password;
	private String department;
	private String subject;
	
	public Teacher() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public Teacher(String teaNum, String teaName, String password,
			String department, String subject) {
		super();
		TeaNum = teaNum;
		TeaName = teaName;
		this.password = password;
		this.department = department;
		this.subject = subject;
	}



	public String getTeaNum() {
		return TeaNum;
	}


	public void setTeaNum(String teaNum) {
		TeaNum = teaNum;
	}


	public String getTeaName() {
		return TeaName;
	}


	public void setTeaName(String teaName) {
		TeaName = teaName;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getDepartment() {
		return department;
	}


	public void setDepartment(String department) {
		this.department = department;
	}


	public String getSubject() {
		return subject;
	}


	public void setSubject(String subject) {
		this.subject = subject;
	}


	@Override
	public String toString() {
		return "{\"TeaNum\":\"" + TeaNum + "\", \"TeaName\":\"" + TeaName
				+ "\", \"password\":\"" + password + "\", \"department\":\""
				+ department + "\", \"subject\":\"" + subject + "\"}";
	}
	
}
