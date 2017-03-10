package com.online.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * Studentinfo entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Studentinfo implements java.io.Serializable {

	// Fields

	private Integer stdId;
	private Operator operator;
	private String name;
	private Integer age;
	private Integer sex;
	private String grade;
	private String teacher;
	private Set studscores = new HashSet(0);

	// Constructors

	/** default constructor */
	public Studentinfo() {
	}

	/** full constructor */
	public Studentinfo(Operator operator, String name, Integer age,
			Integer sex, String grade, String teacher, Set studscores) {
		this.operator = operator;
		this.name = name;
		this.age = age;
		this.sex = sex;
		this.grade = grade;
		this.teacher = teacher;
		this.studscores = studscores;
	}

	// Property accessors

	public Integer getStdId() {
		return this.stdId;
	}

	public void setStdId(Integer stdId) {
		this.stdId = stdId;
	}

	public Operator getOperator() {
		return this.operator;
	}

	public void setOperator(Operator operator) {
		this.operator = operator;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return this.age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Integer getSex() {
		return this.sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public String getGrade() {
		return this.grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getTeacher() {
		return this.teacher;
	}

	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}

	public Set getStudscores() {
		return this.studscores;
	}

	public void setStudscores(Set studscores) {
		this.studscores = studscores;
	}

}