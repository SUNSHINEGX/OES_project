package com.online.service;

import java.util.List;

import com.online.dao.PaperDAO_Interface;
import com.online.dao.StudscoreDAO_Interface;
import com.online.domain.Paper;
import com.online.domain.Studscore;

public class StudScoreServiceImpl implements StudScoreService{
	public StudscoreDAO_Interface  studScoreInterface;
	
	public void addStudScore(Studscore sts) {
		// TODO Auto-generated method stub
		this.getStudScoreInterface().save(sts);
	}

	public Studscore getStudscore(Studscore sts) {
		//Studscore studscore=this.getPaperInterface().findById(pap.getPaperId());
		Studscore studscore=this.getStudScoreInterface().findById(sts.getStudScoreId());
		return studscore;
	}

	public List queryStudscoreList(Studscore sts) {
		// TODO Auto-generated method stub
		return this.getStudScoreInterface().findAll();
	}

	
	public StudscoreDAO_Interface getStudScoreInterface() {
		return studScoreInterface;
	}

	public void setStudScoreInterface(StudscoreDAO_Interface studScoreInterface) {
		this.studScoreInterface = studScoreInterface;
	}

}
