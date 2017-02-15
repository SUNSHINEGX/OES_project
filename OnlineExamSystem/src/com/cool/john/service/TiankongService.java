package com.cool.john.service;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.cool.john.bean.Tiankong;
import com.cool.john.dao.TiankongDao;

public class TiankongService {
	private TiankongDao tiankongDao;

	public TiankongDao getTiankongDao() {
		return tiankongDao;
	}
	public void setTiankongDao(TiankongDao tiankongDao) {
		this.tiankongDao = tiankongDao;
	}
	public List findETiankongService(String subject){
		return this.getTiankongDao().findETiankong(subject);
	}
	public List findHTiankongService(String subject){
		return this.getTiankongDao().findHTiankong(subject);
	}
	public int insert(Tiankong tiankong){
		return this.getTiankongDao().insert(tiankong);
	}
	public void update(Tiankong tiankong){
		this.getTiankongDao().update(tiankong);
	}
	
	public List find(Tiankong tiankong){
		return this.getTiankongDao().find(tiankong);
	}
	public List prosuch(String flag){
		return this.getTiankongDao().prosuch(flag);
	}
//	public static void main(String[] args) {
//		ApplicationContext applicationContext=new FileSystemXmlApplicationContext("src/spring.xml");
//		TianKongService us=(TianKongService)applicationContext.getBean("tiankongServiceProxy");
//		System.out.println(us.findHTianKongService("Java"));
//	}
}
