package com.cool.john.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.cool.john.bean.Choice;
import com.cool.john.service.ChoiceService;

public class ChoiceAction {
	private Choice choice;
	private ChoiceService choiceService;
	public Choice getChoice() {
		return choice;
	}
	public void setChoice(Choice choice) {
		this.choice = choice;
	}
	public ChoiceService getChoiceService() {
		return choiceService;
	}
	public void setChoiceService(ChoiceService choiceService) {
		this.choiceService = choiceService;
	}
	
	public void choice(){
		
		HttpServletRequest request = ServletActionContext.getRequest();
		String flag = request.getParameter("flag");
		List<Choice> list1 = this.getChoiceService().find(choice);
		if(list1.size()>0){
			Choice cho = list1.get(0);
			cho.setA(choice.getA());
			cho.setB(choice.getB());
			cho.setC(choice.getC());
			cho.setD(choice.getD());
			cho.setAnswer(choice.getAnswer());
			cho.setLevel(choice.getLevel());
			this.getChoiceService().update(cho);
			System.out.println("ÐÞ¸Ächoice");
		}else{
			choice.setSubject(flag);
			this.getChoiceService().insert(choice);
			System.out.println("²åÈëchoice");
		}
		
	}
	
	public void chaxuan() throws IOException{
		HttpServletRequest request = ServletActionContext.getRequest();
		String flag =new String(request.getParameter("flag").getBytes("ISO-8859-1"),"UTF-8");
		System.out.println(flag);
		List<Choice> list2 = this.getChoiceService().prosuch(flag);
		System.out.println(list2.size());
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter pw = response.getWriter();
		pw.write(list2.toString());
	}
	
}
