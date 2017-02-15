package com.cool.john.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.cool.john.bean.Studentqa;
import com.cool.john.service.StudentqaService;

public class InsertStudentqaAction {
	private StudentqaService studentqaService;
	public StudentqaService getStudentqaService() {
		return studentqaService;
	}
	public void setStudentqaService(StudentqaService studentqaService) {
		this.studentqaService = studentqaService;
	}
	public void insertstudentqa() throws IOException{
		HttpServletRequest request = ServletActionContext.getRequest();
		String qaStuNumstr =new String(request.getParameter("qaStuNum").getBytes("ISO-8859-1"),"UTF-8");
		Integer qaStuNum=Integer.parseInt(qaStuNumstr);
		String qasubject =new String(request.getParameter("qasubject").getBytes("ISO-8859-1"),"UTF-8");
		String qatopstr =new String(request.getParameter("qatop").getBytes("ISO-8859-1"),"UTF-8");
		String qaanswerstr =new String(request.getParameter("qaanswer").getBytes("ISO-8859-1"),"UTF-8");
	    String[] qatop = qatopstr.split(",");
	    List<String> qatoplist = java.util.Arrays.asList(qatop);
	    String[] qaanswer = qaanswerstr.split(",");
	    List<String> qaanswerlist = java.util.Arrays.asList(qaanswer);
		Studentqa sq=new Studentqa();
		sq.setStuNum(qaStuNum);
		sq.setSubject(qasubject);
		for(int i=0; i<qatoplist.size(); i++){
			sq.setQaTop(qatoplist.get(i));
			sq.setAnswer(qaanswerlist.get(i));
			this.getStudentqaService().insertStudentqaService(sq);
		}	
	}
}
