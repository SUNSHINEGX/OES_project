package com.online.domain;

/**
 * Questiondetail entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Questiondetail implements java.io.Serializable {

	// Fields

	private Integer questDetailId;
	private Question question;
	private String optionNo;
	private String optionContent;

	// Constructors

	/** default constructor */
	public Questiondetail() {
	}

	/** full constructor */
	public Questiondetail(Question question, String optionNo,
			String optionContent) {
		this.question = question;
		this.optionNo = optionNo;
		this.optionContent = optionContent;
	}

	// Property accessors

	public Integer getQuestDetailId() {
		return this.questDetailId;
	}

	public void setQuestDetailId(Integer questDetailId) {
		this.questDetailId = questDetailId;
	}

	public Question getQuestion() {
		return this.question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public String getOptionNo() {
		return this.optionNo;
	}

	public void setOptionNo(String optionNo) {
		this.optionNo = optionNo;
	}

	public String getOptionContent() {
		return this.optionContent;
	}

	public void setOptionContent(String optionContent) {
		this.optionContent = optionContent;
	}

}