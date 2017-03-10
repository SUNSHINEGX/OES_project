package com.online.action;

import java.util.HashSet;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.online.domain.Operator;
import com.online.domain.Studentinfo;
import com.online.service.RegistService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

//public class RegistAction {
public class RegistAction extends ActionSupport {
	public RegistService registServ;
	public Integer stdID;
	public String optID;
	public Byte isAdmin;
	public Byte isExpired;
	public String password;
	public String repPassword;
	public String userName;
	public Integer sex;
	public String teacher;
	public String grade;
	public Integer age;
	public List studentinfoList;
	public Studentinfo studentInfo;

	// public List operatorList;

	// 考虑将operator做成 表单提交数据时的自动转换功能。
	// public void addOperator(Operator opt) {
	public String validateLogin() {
		Operator opt = new Operator();
		opt.setOptId(optID);
		opt.setPassword(password);
		String rtnString = "";
		
		Integer rtnFlag=this.getRegistServ().validateOperator(opt);
		if (rtnFlag==1) {//正确登录
			rtnString = "main";
			ActionContext ctx = ActionContext.getContext();
			HttpServletRequest request = (HttpServletRequest) ctx
					.get(ServletActionContext.HTTP_REQUEST);
			HttpSession session = request.getSession();
			// session.setAttribute("loginID", optID);
			session.setAttribute("currentUser", opt);
		} else if (rtnFlag==0)
		         {this.addFieldError("optId", "帐号不存在");rtnString = "input";}
		       else //2
		        {this.addFieldError("password", "密码不对");rtnString = "input";}
		return rtnString;
	}

	public String addOperator() {
		Operator opt = new Operator();
		opt.setOptId(this.getOptID());
		opt.setPassword(this.getPassword());
		// opt.setOptName("kelvin");
		opt.setIsAdmin(this.getIsAdmin());
		opt.setIsExpired(this.getIsExpired());
		Studentinfo std = new Studentinfo();
		std.setAge(this.getAge());
		std.setGrade(this.getGrade());
		std.setName(this.getUserName());
		std.setSex(this.getSex());
		std.setTeacher(this.getTeacher());
		std.setOperator(opt);
		HashSet hs = new HashSet();
		hs.add(std);
		opt.setStudentinfos(hs);

		if (this.getRegistServ().getOperator(opt) != null) {
			this.addActionError("帐号已存在， 请重新输入!");
			// this.addFieldError("optID","帐号已存在， 请重新输入!");
			return "input";
		} else {
			this.getRegistServ().addOperator(opt);
			return "goList";
		}
	}

	public String deleteOperator() {
		Operator opt = new Operator();
		opt.setOptId(optID);
		opt = this.getRegistServ().getOperator(opt);
		this.getRegistServ().deleteOperator(opt);
		return "goList";
	}

	public String queryOperatorList()
	// public List queryOperatorList(Operator opt)
	{
		// operatorList=this.getRegistServ().queryOperatorList(null);
		return "list";
	}

	/*
	 * public String execute() { addOperator(); return "list"; }
	 */

	public String queryStudentInfoList()
	// public List queryOperatorList(Operator opt)
	{
		studentinfoList = this.getRegistServ().queryStudentInfoList(null);
		return "list";
	}

	public String getStudentInfoBean() {
		Studentinfo studInfo = new Studentinfo();
		studInfo.setStdId(stdID);
		studentInfo = this.getRegistServ().getStudentInfo(studInfo);
		return "beanInfo";
	}

	public RegistService getRegistServ() {
		return registServ;
	}

	public void setRegistServ(RegistService registServ) {
		this.registServ = registServ;
	}

	public String getOptID() {
		return optID;
	}

	public void setOptID(String optID) {
		this.optID = optID;
	}

	/*
	 * public Integer getIsAdmin() { return isAdmin; }
	 * 
	 * public void setIsAdmin(Integer isAdmin) { this.isAdmin = isAdmin; }
	 */
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public String getTeacher() {
		return teacher;
	}

	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public List getStudentinfoList() {
		return studentinfoList;
	}

	public void setStudentinfoList(List studentinfoList) {
		this.studentinfoList = studentinfoList;
	}

	public Studentinfo getStudentInfo() {
		return studentInfo;
	}

	public void setStudentInfo(Studentinfo studentInfo) {
		this.studentInfo = studentInfo;
	}

	public Integer getStdID() {
		return stdID;
	}

	public void setStdID(Integer stdID) {
		this.stdID = stdID;
	}

	public String getRepPassword() {
		return repPassword;
	}

	public void setRepPassword(String repPassword) {
		this.repPassword = repPassword;
	}

	public Byte getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(Byte isAdmin) {
		this.isAdmin = isAdmin;
	}

	public Byte getIsExpired() {
		return isExpired;
	}

	public void setIsExpired(Byte isExpired) {
		this.isExpired = isExpired;
	}
}