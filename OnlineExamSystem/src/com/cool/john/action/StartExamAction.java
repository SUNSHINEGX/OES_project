package com.cool.john.action;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.cool.john.bean.Choice;
import com.cool.john.bean.Exampaper;
import com.cool.john.bean.Tiankong;
import com.cool.john.service.ChoiceService;
import com.cool.john.service.ExampaperService;
import com.cool.john.service.TiankongService;
import com.cool.john.service.WendaService;
import com.opensymphony.xwork2.ActionContext;

public class StartExamAction {
	private String StuName;
	private String StuNum;
	private String subject;
	private String time;
	private String classNum;
	private Exampaper exampaper;
	private ExampaperService exampaperService;
	private ChoiceService choiceService;
	private TiankongService tiankongService;
	private WendaService wendaService;
	public WendaService getWendaService() {
		return wendaService;
	}
	public void setWendaService(WendaService wendaService) {
		this.wendaService = wendaService;
	}
	public TiankongService getTiankongService() {
		return tiankongService;
	}
	public void setTiankongService(TiankongService tiankongService) {
		this.tiankongService = tiankongService;
	}
	public ChoiceService getChoiceService() {
		return choiceService;
	}
	public void setChoiceService(ChoiceService choiceService) {
		this.choiceService = choiceService;
	}
	public Exampaper getExampaper() {
		return exampaper;
	}
	public void setExampaper(Exampaper exampaper) {
		this.exampaper = exampaper;
	}
	public ExampaperService getExampaperService() {
		return exampaperService;
	}
	public void setExampaperService(ExampaperService exampaperService) {
		this.exampaperService = exampaperService;
	}
	public String getStuName() {
		return StuName;
	}
	public void setStuName(String stuName) throws UnsupportedEncodingException {
		HttpServletRequest req = ServletActionContext.getRequest();
		stuName =  URLDecoder.decode(req.getParameter("StuName"),"UTF-8");
		this.StuName = stuName;
	}
	public String getStuNum() {
		return StuNum;
	}
	public void setStuNum(String stuNum) {
		this.StuNum = stuNum;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) throws UnsupportedEncodingException {
		HttpServletRequest req = ServletActionContext.getRequest();
		subject =  URLDecoder.decode(req.getParameter("subject"),"UTF-8");
		this.subject = subject;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getClassNum() {
		return classNum;
	}
	public void setClassNum(String classNum) {
		this.classNum = classNum;
	}
	public String getExam(){
		List list_ep=exampaperService.findExampaperService(subject);
		System.out.println("试卷信息："+list_ep);
		Exampaper el=(Exampaper)list_ep.get(0);
		int sel_num=el.getEasySelNum()+el.getHardSelNum();
		int fill_num=el.getEasyFillNum()+el.getHardFillNum();
		int qa_num=el.getEasyQaNum()+el.getHardQaNum();
		int sel_score=el.getSelScore()*sel_num;
		int fill_score=el.getFillScore()*fill_num;
		int qa_score=el.getQaSocre()*qa_num;
		int exam_score=sel_score+fill_score+qa_score;
		int sel_littlescore=el.getSelScore();
		int fill_littlescore=el.getFillScore();
		int qa_littlescore=el.getQaSocre();
		
		ActionContext ac=ActionContext.getContext();
		HttpServletRequest req = ServletActionContext.getRequest();
		HttpSession examsession = req.getSession(); //通过request对象获得session
		
		examsession.setAttribute("ec_size",el.getEasySelNum());//将简单选择题数量放进session
		examsession.setAttribute("hc_size",el.getHardSelNum());//将困难选择题数量放进session
		examsession.setAttribute("et_size",el.getEasyFillNum());//将简单填空题数量放进session
		examsession.setAttribute("ht_size",el.getHardFillNum());//将困难填空题数量放进session
		examsession.setAttribute("ew_size",el.getEasyQaNum());//将简单问答题数量放进session
		examsession.setAttribute("hw_size",el.getHardQaNum());//将困难问答题数量放进session
		
		List choice_anwser=new ArrayList();//所有选择问题答案
		//------------------简单选择问题--------------------------------简单选择问题
		List list_ec=choiceService.findEChoiceService(subject);//所有简单选择问题
		List ec=new ArrayList();//所有简单选择问题序号
		int i=0;
		for(i=0; i<list_ec.size();  i++){
			ec.add(i, i);
		}
		for(i=0; i<el.getEasySelNum();  i++){
			int j=(int)(0+Math.random()*(ec.size()-0));
			int index=(int)ec.get(j);//获得序号为j的简单选择问题在list_ec中的下标
			ec.remove(j);//移除序号为j的简单选择问题
			Choice ec_subject=(Choice)list_ec.get(index);
			examsession.setAttribute("ec"+i,ec_subject);
			choice_anwser.add(i, ec_subject.getAnswer());//将简单选择题答案放进choice_anwser
		}
		//------------------困难选择问题--------------------------------困难选择问题
		List list_hc=choiceService.findHChoiceService(subject);//所有困难选择问题
		List hc=new ArrayList();//所有困难选择问题序号
		for(int k=0; k<list_hc.size();  k++){
			hc.add(k, k);
		}
		for(int k=0; k<el.getHardSelNum();  k++){
			int j=(int)(0+Math.random()*(hc.size()-0));
			int index=(int)hc.get(j);//获得序号为j的困难选择问题在list_ec中的下标
			hc.remove(j);//移除序号为j的困难选择问题
			Choice hc_subject=(Choice)list_hc.get(index);
			examsession.setAttribute("hc"+k,hc_subject);
			choice_anwser.add(i+k, hc_subject.getAnswer());//将困难选择题答案放进choice_anwser
		}
		examsession.setAttribute("choice_anwser",choice_anwser);//将选择题答案存到session
		
		
		List tiankong_anwser=new ArrayList();//所有填空问题答案
		//------------------简单填空问题--------------------------------简单填空问题
		List list_et=tiankongService.findETiankongService(subject);//所有简单填空问题
		List et=new ArrayList();//所有简单填空问题序号
		for(i=0; i<list_et.size();  i++){
			et.add(i, i);
		}
		for(i=0; i<el.getEasyFillNum();  i++){
			int j=(int)(0+Math.random()*(et.size()-0));
			int index=(int)et.get(j);//获得序号为j的简单填空问题在list_ec中的下标
			et.remove(j);//移除序号为j的简单填空问题
			Tiankong et_subject=(Tiankong)list_et.get(index);
			examsession.setAttribute("et"+i,et_subject);
			tiankong_anwser.add(i, et_subject.getAnswer());//将简单填空题答案放进choice_anwser
		}
		//------------------困难填空问题--------------------------------困难填空问题
		List list_ht=tiankongService.findHTiankongService(subject);//所有困难填空问题
		List ht=new ArrayList();//所有困难填空问题序号
		for(int k=0; k<list_ht.size();  k++){
			ht.add(k,k);
		}
		for(int k=0; k<el.getHardFillNum();  k++){
			int j=(int)(0+Math.random()*(ht.size()-0));
			int index=(int)ht.get(j);//获得序号为j的困难填空问题在list_ec中的下标
			ht.remove(j);//移除序号为j的困难填空问题
			Tiankong ht_subject=(Tiankong)list_ht.get(index);
			examsession.setAttribute("ht"+k,ht_subject);
			tiankong_anwser.add(i+k, ht_subject.getAnswer());//将困难填空题答案放进choice_anwser
		}
		examsession.setAttribute("tiankong_anwser",tiankong_anwser);//将填空题答案存到session
		
		//------------------简单问答问题--------------------------------简单问答问题
		List list_ew=wendaService.findEWendaService(subject);//所有简单问答问题
		List ew=new ArrayList();//所有简单问答问题序号
		for(i=0; i<list_ew.size();  i++){
			ew.add(i, i);
		}
		for(i=0; i<el.getEasyQaNum();  i++){
			int j=(int)(0+Math.random()*(ew.size()-0));
			int index=(int)ew.get(j);//获得序号为j的简单问答问题在list_ec中的下标
			ew.remove(j);//移除序号为j的简单问答问题
			examsession.setAttribute("ew"+i,list_ew.get(index));
		}
		//------------------困难问答问题--------------------------------困难问答问题
		List list_hw=wendaService.findHWendaService(subject);//所有困难问答问题
		List hw=new ArrayList();//所有困难问答问题序号
		for(int k=0; k<list_hw.size();  k++){
			hw.add(k, k);
		}
		for(int k=0; k<el.getHardQaNum();  k++){
			int j=(int)(0+Math.random()*(hw.size()-0));
			int index=(int)hw.get(j);//获得序号为j的困难问答问题在list_ec中的下标
			hw.remove(j);//移除序号为j的困难问答问题
			examsession.setAttribute("hw"+k,list_hw.get(index));
		}
		
		//------------------基本信息--------------------------------基本信息
		ac.put("StuName", StuName);
		ac.put("StuNum", StuNum);
		ac.put("subject", subject);
		ac.put("time", time);
		ac.put("classNum", classNum);
		ac.put("sel_num", sel_num);
		ac.put("fill_num", fill_num);
		ac.put("qa_num", qa_num);
		ac.put("sel_score", sel_score);
		ac.put("fill_score", fill_score);
		ac.put("qa_score", qa_score);
		ac.put("exam_score", exam_score);
		ac.put("sel_littlescore", sel_littlescore);
		ac.put("fill_littlescore", fill_littlescore);
		ac.put("qa_littlescore", qa_littlescore);
		//------------------基本信息end--------------------------------基本信息end
		
		return "success";
	}
}
