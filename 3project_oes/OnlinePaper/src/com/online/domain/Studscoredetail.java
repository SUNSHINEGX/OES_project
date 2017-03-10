package com.online.domain;

/**
 * Studscoredetail entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Studscoredetail implements java.io.Serializable {

	// Fields

	private Integer studscoreDetailId;
	private Studscore studscore;
	private Paperdetail paperdetail;
	private String answer;
	private Integer scoreForId;
	private Integer flag;
	private String correctAnswer;
	private Integer  correctScore;

	// Constructors

	/** default constructor */
	public Studscoredetail() {
	}

	/** minimal constructor */
	public Studscoredetail(Studscore studscore, Paperdetail paperdetail) {
		this.studscore = studscore;
		this.paperdetail = paperdetail;
	}

	/** full constructor */
	public Studscoredetail(Studscore studscore, Paperdetail paperdetail,
			String answer, Integer scoreForId, Integer flag) {
		this.studscore = studscore;
		this.paperdetail = paperdetail;
		this.answer = answer;
		this.scoreForId = scoreForId;
		this.flag = flag;
	}

	// Property accessors

	public Integer getStudscoreDetailId() {
		return this.studscoreDetailId;
	}

	public void setStudscoreDetailId(Integer studscoreDetailId) {
		this.studscoreDetailId = studscoreDetailId;
	}

	public Studscore getStudscore() {
		return this.studscore;
	}

	public void setStudscore(Studscore studscore) {
		this.studscore = studscore;
	}

	public Paperdetail getPaperdetail() {
		return this.paperdetail;
	}

	public void setPaperdetail(Paperdetail paperdetail) {
		this.paperdetail = paperdetail;
	}

	public String getAnswer() {
		return this.answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public Integer getScoreForId() {
		return this.scoreForId;
	}

	public void setScoreForId(Integer scoreForId) {
		this.scoreForId = scoreForId;
	}

	public Integer getFlag() {
		return this.flag;
	}

	public void setFlag(Integer flag) {
		this.flag = flag;
	}

	public String getCorrectAnswer() {
		return correctAnswer;
	}

	public void setCorrectAnswer(String correctAnswer) {
		this.correctAnswer = correctAnswer;
	}

	public Integer getCorrectScore() {
		return correctScore;
	}

	public void setCorrectScore(Integer correctScore) {
		this.correctScore = correctScore;
	}

}