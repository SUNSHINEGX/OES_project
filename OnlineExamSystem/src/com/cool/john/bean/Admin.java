package com.cool.john.bean;

public class Admin {
	private String adminNum;
	private String adminName;
	private String password;
	
	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}
		

	public Admin(String adminNum, String password) {
		super();
		this.adminNum = adminNum;
		this.password = password;
	}



	public Admin(String adminNum, String adminName, String password) {
		super();
		this.adminNum = adminNum;
		this.adminName = adminName;
		this.password = password;
	}

	public String getAdminNum() {
		return adminNum;
	}

	public void setAdminNum(String adminNum) {
		this.adminNum = adminNum;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "{\"adminNum\":\"" + adminNum + "\", \"adminName\":\""
				+ adminName + "\", \"password\":\"" + password + "\"} ";
	}
	
	
}
