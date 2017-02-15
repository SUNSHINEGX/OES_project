package com.cool.john.service;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.cool.john.bean.Exampaper;
import com.cool.john.dao.ExampaperDao;

public class ExampaperService {
	private ExampaperDao exampaperDao;

	public ExampaperDao getExampaperDao() {
		return exampaperDao;
	}

	public void setExampaperDao(ExampaperDao exampaperDao) {
		this.exampaperDao = exampaperDao;
	}
	
	public List findExampaperService(String subject){
		return this.getExampaperDao().findExampaper(subject);
	}
	public int insert(Exampaper exampaper){
		return this.getExampaperDao().insert(exampaper);
	}
	public void update(Exampaper exampaper){
		this.getExampaperDao().update(exampaper);
	}
	
	public List find(Exampaper exampaper){
		return this.getExampaperDao().find(exampaper);
	}
//	public static void main(String[] args) {
//		ApplicationContext applicationContext=new 
//		FileSystemXmlApplicationContext("src/spring.xml");
//		ExampaperService us=(ExampaperService)applicationContext.getBean("exampaperServiceProxy");
//		System.out.println(us.findExampaperService("Java"));
//	}
}
