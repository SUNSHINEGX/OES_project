package com.cool.john.service;

import java.util.List;

import com.cool.john.bean.TestPaperList;
import com.cool.john.dao.TestPaperListDao;

public class TestPaperListService {
	private TestPaperListDao tpDao;

	public TestPaperListDao getTpDao() {
		return tpDao;
	}

	public void setTpDao(TestPaperListDao tpDao) {
		this.tpDao = tpDao;
	}
	
	public List find(){
		return this.getTpDao().find();
	}
	
	public List find(String subject){
		return this.getTpDao().find(subject);
	}
	
	public void insert(TestPaperList examTime){
		 this.getTpDao().insert(examTime);
	}
	
	
	public void update(TestPaperList examTime){
		this.getTpDao().update(examTime);
	}

		
	public List find(TestPaperList examTime){
		return this.getTpDao().find(examTime);
	}
	
	
}
