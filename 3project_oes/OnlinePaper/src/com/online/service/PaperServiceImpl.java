package com.online.service;

import java.util.List;

import com.online.dao.PaperDAO_Interface;
import com.online.dao.PaperdetailDAO_Interface;
import com.online.dao.QuestionDAO_Interface;
import com.online.domain.Paper;
import com.online.domain.Paperdetail;
import com.online.domain.Question;
import com.online.domain.Studentinfo;

public class PaperServiceImpl implements PaperService {
    public PaperDAO_Interface  paperInterface;
    public PaperdetailDAO_Interface  paperdetailInterface;

	public void addPaper(Paper pap) {
		this.getPaperInterface().save(pap);
		}

	public void deletePaper(Paper pap) {
		this.getPaperInterface().delete(pap);
		}

	public Paper getPaper(Paper pap) {
		Paper paper=this.getPaperInterface().findById(pap.getPaperId());
		return paper;
	}
	public List queryPaperList(Paper pap) {
		return  this.getPaperInterface().findAll();
	}
	public PaperDAO_Interface getPaperInterface() {
		return paperInterface;
	}
	public void setPaperInterface(PaperDAO_Interface paperInterface) {
		this.paperInterface = paperInterface;
	}

	public PaperdetailDAO_Interface getPaperdetailInterface() {
		return paperdetailInterface;
	}

	public void setPaperdetailInterface(
			PaperdetailDAO_Interface paperdetailInterface) {
		this.paperdetailInterface = paperdetailInterface;
	}

	public List queryPaperDetailList(Paper paper) {
		// TODO Auto-generated method stub
		return  this.getPaperdetailInterface().findByProperty("paper", paper);
	}
}