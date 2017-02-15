package com.cool.john.bean;

public class Student {
	private String stuNum;
	private String stuName;
	private String password;
	private String sex;
	private String department;
	private String major;
	private String classNum;
	
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(String stuNum, String password) {
		super();
		this.stuNum = stuNum;
		this.password = password;
	}
		

	public Student(String stuNum, String stuName, String password, String sex,
			String department, String major, String classNum) {
		super();
		this.stuNum = stuNum;
		this.stuName = stuName;
		this.password = password;
		this.sex = sex;
		this.department = department;
		this.major = major;
		this.classNum = classNum;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getClassNum() {
		return classNum;
	}

	public void setClassNum(String classNum) {
		this.classNum = classNum;
	}
	@Override
	public String toString() {
		return "{\"stuNum\":\"" + stuNum + "\", \"stuName\":\"" + stuName
				+ "\", \"password\":\"" + password + "\", \"sex\":\"" + sex
				+ "\", \"department\":\"" + department + "\", \"major\":\""
				+ major + "\", \"classNum\":\"" + classNum + "\"} ";
	}		
	
}
