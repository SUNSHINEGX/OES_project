package org.matrix.pojo;

/**
 * Question entity. @author MyEclipse Persistence Tools
 */

public class Question implements java.io.Serializable {

	// Fields

	private int id;
	private ExamType examType;
	private String quTitle;
	private String quHard;
	private String quType;
	private Integer quScore;
	private String quAnswer;
	private String selectOption;

	// Constructors

	/** default constructor */
	public Question() {
	}

	/** full constructor */
	public Question(String quTitle, String quHard,Integer quScore,
			String quAnswer, String quType,  String selectOption,ExamType examType) {
		this.examType = examType;
		this.quTitle = quTitle;
		this.quHard = quHard;
		this.quType = quType;
		this.quScore = quScore;
		this.quAnswer = quAnswer;
		this.selectOption = selectOption;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ExamType getExamType() {
		return examType;
	}

	public void setExamType(ExamType examType) {
		this.examType = examType;
	}

	public String getQuTitle() {
		return quTitle;
	}

	public void setQuTitle(String quTitle) {
		this.quTitle = quTitle;
	}

	public String getQuHard() {
		return quHard;
	}

	public void setQuHard(String quHard) {
		this.quHard = quHard;
	}

	public String getQuType() {
		return quType;
	}

	public void setQuType(String quType) {
		this.quType = quType;
	}

	public Integer getQuScore() {
		return quScore;
	}

	public void setQuScore(Integer quScore) {
		this.quScore = quScore;
	}

	public String getQuAnswer() {
		return quAnswer;
	}

	public void setQuAnswer(String quAnswer) {
		this.quAnswer = quAnswer;
	}

	public String getSelectOption() {
		return selectOption;
	}

	public void setSelectOption(String selectOption) {
		this.selectOption = selectOption;
	}

	// Property accessors

	

}