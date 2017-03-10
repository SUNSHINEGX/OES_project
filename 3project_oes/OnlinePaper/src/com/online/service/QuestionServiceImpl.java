package com.online.service;

import java.util.List;

import com.online.dao.QuestionDAO_Interface;
import com.online.domain.Question;
import com.online.domain.Studentinfo;

public class QuestionServiceImpl implements QuestionService {
    public QuestionDAO_Interface  qesInterface;
	public void addQuestion(Question qes) {
		this.getQesInterface().save(qes);
	}

	public void deleteQuestion(Question qes) {
		this.getQesInterface().delete(qes);
	}

	public Question getQuestion(Question qes) {
		Question qestion=this.getQesInterface().findById(qes.getQuestId());
		return qestion;
	}

	public List queryQuestionList(Question qes) {
		return  this.getQesInterface().findAll();
	}

	//set and get method
	public QuestionDAO_Interface getQesInterface() {
		return qesInterface;
	}

	public void setQesInterface(QuestionDAO_Interface qesInterface) {
		this.qesInterface = qesInterface;
	}
	

}
