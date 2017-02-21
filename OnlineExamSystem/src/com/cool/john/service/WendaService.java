package com.cool.john.service;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.cool.john.bean.Wenda;
import com.cool.john.dao.WendaDao;

public class WendaService {
	private WendaDao wendaDao;

	public WendaDao getWendaDao() {
		return wendaDao;
	}
	public void setWendaDao(WendaDao wendaDao) {
		this.wendaDao = wendaDao;
	}
	public List findEWendaService(String subject){
		return this.getWendaDao().findEWenda(subject);
	}
	public List findHWendaService(String subject){
		return this.getWendaDao().findHWenda(subject);
	}
	public int insert(Wenda wenda){
		return this.getWendaDao().insert(wenda);
	}
	
	public void update(Wenda wenda){
		this.getWendaDao().update(wenda);
	}
	
	public List find(Wenda wenda){
		return this.getWendaDao().find(wenda);
	}
	public List prosuch(String flag){
		return this.getWendaDao().prosuch(flag);
	}
//	public static void main(String[] args) {
//		ApplicationContext applicationContext=new FileSystemXmlApplicationContext("src/spring.xml");
//		WendaService us=(WendaService)applicationContext.getBean("wendaServiceProxy");
//		System.out.println(us.findEWendaService("Java"));
//	}
}
