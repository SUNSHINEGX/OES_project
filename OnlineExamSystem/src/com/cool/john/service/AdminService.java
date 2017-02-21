package com.cool.john.service;

import java.util.List;

import com.cool.john.bean.Admin;
import com.cool.john.dao.AdminDao;

public class AdminService {
	private AdminDao admDao;

	
	public AdminDao getAdmDao() {
		return admDao;
	}

	public void setAdmDao(AdminDao admDao) {
		this.admDao = admDao;
	}

	public List find(){
		return this.getAdmDao().find();
	}
	
	public List find(Admin adm){
		return this.getAdmDao().find(adm);
	}
	
	public void update(Admin admin){
		this.getAdmDao().update(admin);
	}
}
