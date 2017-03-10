package com.online.service;

import java.util.List;

import com.online.domain.Operator;
import com.online.domain.Studentinfo;
import com.online.domain.Studscore;

public interface StudScoreService {
    public void addStudScore(Studscore sts);      
    //public void deleteOperator(Operator opt);   
	public List queryStudscoreList(Studscore sts);
	//public List queryStudentInfoList(Studentinfo stu);
	//public Studentinfo getStudscore(Studscore sts);
	public Studscore getStudscore(Studscore opt);
}
