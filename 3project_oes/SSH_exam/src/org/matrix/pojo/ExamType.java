package org.matrix.pojo;

import java.util.HashSet;
import java.util.Set;

/**
 * Examtype entity. @author MyEclipse Persistence Tools
 */

public class ExamType implements java.io.Serializable {

	// Fields

	private int id;
	private String examName;
	private String examTime;
	private Set<Question> questions = new HashSet<Question>();
	
	public ExamType(){
		
	}
	public ExamType(String examName,String examTime){
		 this.examName=examName;
		 this.examTime=examTime;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public String getExamName() {
		return examName;
	}
	public void setExamName(String examName) {
		this.examName = examName;
	}
	public String getExamTime() {
		return examTime;
	}
	public void setExamTime(String examTime) {
		this.examTime = examTime;
	}
	public Set<Question> getQuestions() {
		return questions;
	}
	public void setQuestions(Set<Question> questions) {
		this.questions = questions;
	}
	

}