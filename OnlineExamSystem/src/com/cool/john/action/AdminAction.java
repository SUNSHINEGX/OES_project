package com.cool.john.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.cool.john.bean.Admin;
import com.cool.john.service.AdminService;

public class AdminAction {
	private AdminService admService;
	private Admin admin;

	public AdminService getAdmService() {
		return admService;
	}
	public void setAdmService(AdminService admService) {
		this.admService = admService;
	}
	public Admin getAdmin() {
		return admin;
	}
	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	
	
	public void update() throws IOException{
		System.out.println(this.getAdmin());
		String password = this.getAdmin().getPassword();
		Admin ad = new Admin("31130000","admin",password);
		System.out.println(this.getAdmService());
		this.getAdmService().update(ad);
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter pw=response.getWriter();
		pw.print("success");
	}
}	
