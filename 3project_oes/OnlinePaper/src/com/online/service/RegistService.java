package com.online.service;
import java.util.List;

import com.online.domain.*;

public interface RegistService {
	public Integer validateOperator(Operator opt);
    public void addOperator(Operator opt);      
    public void deleteOperator(Operator opt);   
	public List queryOperatorList(Operator opt);
	public List queryStudentInfoList(Studentinfo stu);
	public Studentinfo getStudentInfo(Studentinfo std);
	public Operator getOperator(Operator opt);
}
