package com.online.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * Paperdetail entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Paperdetail implements java.io.Serializable {

	// Fields

	private Integer paperDetailId;
	private Question question;
	private Paper paper;
	private Byte validFlag;
	private Set studscoredetails = new HashSet(0);

	// Constructors

	/** default constructor */
	public Paperdetail() {
	}

	/** full constructor */
	public Paperdetail(Question question, Paper paper, Byte validFlag,
			Set studscoredetails) {
		this.question = question;
		this.paper = paper;
		this.validFlag = validFlag;
		this.studscoredetails = studscoredetails;
	}

	// Property accessors

	public Integer getPaperDetailId() {
		return this.paperDetailId;
	}

	public void setPaperDetailId(Integer paperDetailId) {
		this.paperDetailId = paperDetailId;
	}

	public Question getQuestion() {
		return this.question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public Paper getPaper() {
		return this.paper;
	}

	public void setPaper(Paper paper) {
		this.paper = paper;
	}

	public Byte getValidFlag() {
		return this.validFlag;
	}

	public void setValidFlag(Byte validFlag) {
		this.validFlag = validFlag;
	}

	public Set getStudscoredetails() {
		return this.studscoredetails;
	}

	public void setStudscoredetails(Set studscoredetails) {
		this.studscoredetails = studscoredetails;
	}

}