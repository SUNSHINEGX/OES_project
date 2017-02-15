package com.cool.john.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.cool.john.dao.ScoreListDao;
import com.cool.john.dao.TestPaperListDao;

public class ScoreListService {
	private ScoreListDao slDao;
	
	public ScoreListDao getSlDao() {
		return slDao;
	}

	public void setSlDao(ScoreListDao slDao) {
		this.slDao = slDao;
	}

	public List find(){
		return this.getSlDao().find();
	}
	public List findScore(String stuName){
		return this.getSlDao().findScore(stuName);
	}
	public List find(String subject){
		/*HttpServletRequest req = ServletActionContext.getRequest();
		HttpSession hs = req.getSession();
		String stuNum = (String) hs.getAttribute("stuNum");
		System.out.println(stuNum);*/
		return this.getSlDao().find(subject);
	}
}
