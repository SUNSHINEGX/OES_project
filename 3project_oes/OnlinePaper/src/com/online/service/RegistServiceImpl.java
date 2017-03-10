package com.online.service;

import java.util.List;

import org.hibernate.Transaction;

import com.online.dao.OperatorDAO;
import com.online.dao.OperatorDAO_Interface;
import com.online.dao.StudentinfoDAO_Interface;
import com.online.domain.HibernateSessionFactory;
import com.online.domain.Operator;
import com.online.domain.Studentinfo;

public class RegistServiceImpl implements RegistService {
	public OperatorDAO_Interface optDAOInterface;
	public StudentinfoDAO_Interface studentInfoDAOInterface;
	
	public void addOperator(Operator opt) {
	    this.getOptDAOInterface().save(opt);
	}
	
	public void deleteOperator(Operator opt) {
	    this.getOptDAOInterface().delete(opt); 
	}
	
	public List queryOperatorList(Operator opt)
	 {
		return this.getOptDAOInterface().findAll();
	 }
	
	public Studentinfo getStudentInfo(Studentinfo std)
	   {
		Studentinfo studentInfo=this.getStudentInfoDAOInterface().findById(std.getStdId());
		return studentInfo;
	   }
	public List queryStudentInfoList(Studentinfo stu) {
		// TODO Auto-generated method stub
		return this.getStudentInfoDAOInterface().findAll();
	}

	public StudentinfoDAO_Interface getStudentInfoDAOInterface() {
		return studentInfoDAOInterface;
	}

	public void setStudentInfoDAOInterface(
			StudentinfoDAO_Interface studentInfoDAOInterface) {
		this.studentInfoDAOInterface = studentInfoDAOInterface;
	}

	public Operator getOperator(Operator opt) {
		// TODO Auto-generated method stub
		String id=opt.getOptId();
		return  this.getOptDAOInterface().findById(id);
	}

	//set and get method	
	public OperatorDAO_Interface getOptDAOInterface() {
		return optDAOInterface;
	}
	public void setOptDAOInterface(OperatorDAO_Interface optDAOInterface) {
		this.optDAOInterface = optDAOInterface;
	}

	public Integer validateOperator(Operator opt) {
		Integer rtnFlag;
		Operator optByID=this.getOptDAOInterface().findById(opt.getOptId());
		if  (optByID==null) {rtnFlag= 0;return rtnFlag;}
		if (opt.getPassword().equals(optByID.getPassword()))
		    {
			rtnFlag= 1;
            opt.setIsAdmin(optByID.getIsAdmin());
            opt.setIsExpired(optByID.getIsExpired());
            opt.setOptName(optByID.getOptName());
            opt.setStudentinfos(optByID.getStudentinfos());
		    }
		else
		   {
			rtnFlag= 2;
		   }
		return rtnFlag;
	}
}
