package com.online.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * Operator entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Operator implements java.io.Serializable {

	// Fields

	private String optId;
	private String optName;
	private String password;
	private Byte isExpired;
	private Byte isAdmin;
	private Set studentinfos = new HashSet(0);

	// Constructors

	/** default constructor */
	public Operator() {
	}

	/** minimal constructor */
	public Operator(String optId) {
		this.optId = optId;
	}

	/** full constructor */
	public Operator(String optId, String optName, String password,
			Byte isExpired, Byte isAdmin, Set studentinfos) {
		this.optId = optId;
		this.optName = optName;
		this.password = password;
		this.isExpired = isExpired;
		this.isAdmin = isAdmin;
		this.studentinfos = studentinfos;
	}

	// Property accessors

	public String getOptId() {
		return this.optId;
	}

	public void setOptId(String optId) {
		this.optId = optId;
	}

	public String getOptName() {
		return this.optName;
	}

	public void setOptName(String optName) {
		this.optName = optName;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Byte getIsExpired() {
		return this.isExpired;
	}

	public void setIsExpired(Byte isExpired) {
		this.isExpired = isExpired;
	}

	public Byte getIsAdmin() {
		return this.isAdmin;
	}

	public void setIsAdmin(Byte isAdmin) {
		this.isAdmin = isAdmin;
	}

	public Set getStudentinfos() {
		return this.studentinfos;
	}

	public void setStudentinfos(Set studentinfos) {
		this.studentinfos = studentinfos;
	}

}