package com.online.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * Question entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Question implements java.io.Serializable {

	// Fields

	private Integer questId;
	private String type;
	private String mainContent;
	private Integer score;
	private String easyLevel;
	private String answer;
	private Set questiondetails = new HashSet(0);
	private Set paperdetails = new HashSet(0);

	// Constructors

	/** default constructor */
	public Question() {
	}

	/** full constructor */
	public Question(String type, String mainContent, Integer score,
			String easyLevel, String answer, Set questiondetails,
			Set paperdetails) {
		this.type = type;
		this.mainContent = mainContent;
		this.score = score;
		this.easyLevel = easyLevel;
		this.answer = answer;
		this.questiondetails = questiondetails;
		this.paperdetails = paperdetails;
	}

	// Property accessors

	public Integer getQuestId() {
		return this.questId;
	}

	public void setQuestId(Integer questId) {
		this.questId = questId;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getMainContent() {
		return this.mainContent;
	}

	public void setMainContent(String mainContent) {
		this.mainContent = mainContent;
	}

	public Integer getScore() {
		return this.score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public String getEasyLevel() {
		return this.easyLevel;
	}

	public void setEasyLevel(String easyLevel) {
		this.easyLevel = easyLevel;
	}

	public String getAnswer() {
		return this.answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public Set getQuestiondetails() {
		return this.questiondetails;
	}

	public void setQuestiondetails(Set questiondetails) {
		this.questiondetails = questiondetails;
	}

	public Set getPaperdetails() {
		return this.paperdetails;
	}

	public void setPaperdetails(Set paperdetails) {
		this.paperdetails = paperdetails;
	}

}