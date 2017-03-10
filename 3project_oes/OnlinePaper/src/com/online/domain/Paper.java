package com.online.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Paper entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Paper implements java.io.Serializable {

	// Fields

	private Integer paperId;
	private Integer fullScore;
	private Date paperTime;
	private Date validateTime;
	private String paperName;
	private String byUser;
	private Set paperdetails = new HashSet(0);
	private Set studscores = new HashSet(0);

	// Constructors

	/** default constructor */
	public Paper() {
	}

	/** minimal constructor */
	public Paper(String paperName, String byUser) {
		this.paperName = paperName;
		this.byUser = byUser;
	}

	/** full constructor */
	public Paper(Integer fullScore, Date paperTime, Date validateTime,
			String paperName, String byUser, Set paperdetails, Set studscores) {
		this.fullScore = fullScore;
		this.paperTime = paperTime;
		this.validateTime = validateTime;
		this.paperName = paperName;
		this.byUser = byUser;
		this.paperdetails = paperdetails;
		this.studscores = studscores;
	}

	// Property accessors

	public Integer getPaperId() {
		return this.paperId;
	}

	public void setPaperId(Integer paperId) {
		this.paperId = paperId;
	}

	public Integer getFullScore() {
		return this.fullScore;
	}

	public void setFullScore(Integer fullScore) {
		this.fullScore = fullScore;
	}

	public Date getPaperTime() {
		return this.paperTime;
	}

	public void setPaperTime(Date paperTime) {
		this.paperTime = paperTime;
	}

	public Date getValidateTime() {
		return this.validateTime;
	}

	public void setValidateTime(Date validateTime) {
		this.validateTime = validateTime;
	}

	public String getPaperName() {
		return this.paperName;
	}

	public void setPaperName(String paperName) {
		this.paperName = paperName;
	}

	public String getByUser() {
		return this.byUser;
	}

	public void setByUser(String byUser) {
		this.byUser = byUser;
	}

	public Set getPaperdetails() {
		return this.paperdetails;
	}

	public void setPaperdetails(Set paperdetails) {
		this.paperdetails = paperdetails;
	}

	public Set getStudscores() {
		return this.studscores;
	}

	public void setStudscores(Set studscores) {
		this.studscores = studscores;
	}

}