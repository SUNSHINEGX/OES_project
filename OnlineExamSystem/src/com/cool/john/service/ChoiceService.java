package com.cool.john.service;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.cool.john.bean.Choice;
import com.cool.john.dao.ChoiceDao;

public class ChoiceService {
	private ChoiceDao choiceDao;

	public ChoiceDao getChoiceDao() {
		return choiceDao;
	}

	public void setChoiceDao(ChoiceDao choiceDao) {
		this.choiceDao = choiceDao;
	}

	public List findEChoiceService(String subject){
		return this.getChoiceDao().findEChoice(subject);
	}
	public List findHChoiceService(String subject){
		return this.getChoiceDao().findHChoice(subject);
	}
	public int insert(Choice choice){
		return this.getChoiceDao().insert(choice);
	}
	public void update(Choice choice){
		this.getChoiceDao().update(choice);
	}
	
	public List find(Choice choice){
		return this.getChoiceDao().find(choice);
	}
	public List prosuch(String flag){
		return this.getChoiceDao().prosuch(flag);
	}
//	public static void main(String[] args) {
//		ApplicationContext applicationContext=new FileSystemXmlApplicationContext("src/spring.xml");
//		ChoiceService us=(ChoiceService)applicationContext.getBean("choiceServiceProxy");
//		System.out.println(us.findEChoiceService("Java"));
//	}
}
