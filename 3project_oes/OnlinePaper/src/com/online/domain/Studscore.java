package com.online.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * Studscore entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Studscore implements java.io.Serializable {

	// Fields
	private Integer studScoreId;
	private Paper paper;
	private Studentinfo studentinfo;
	private Integer score;
	private Set studscoredetails = new HashSet(0);

	// Constructors

	/** default constructor */
	public Studscore() {
	}

	/** full constructor */
	public Studscore(Paper paper, Studentinfo studentinfo, Integer score,
			Set studscoredetails) {
		this.paper = paper;
		this.studentinfo = studentinfo;
		this.score = score;
		this.studscoredetails = studscoredetails;
	}

	// Property accessors

	public Integer getStudScoreId() {
		return this.studScoreId;
	}

	public void setStudScoreId(Integer studScoreId) {
		this.studScoreId = studScoreId;
	}

	public Paper getPaper() {
		return this.paper;
	}

	public void setPaper(Paper paper) {
		this.paper = paper;
	}

	public Studentinfo getStudentinfo() {
		return this.studentinfo;
	}

	public void setStudentinfo(Studentinfo studentinfo) {
		this.studentinfo = studentinfo;
	}

	public Integer getScore() {
		return this.score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public Set getStudscoredetails() {
		return this.studscoredetails;
	}

	public void setStudscoredetails(Set studscoredetails) {
		this.studscoredetails = studscoredetails;
	}

}