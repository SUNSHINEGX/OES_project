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
		System.out.println("�Ծ���Ϣ��"+list_ep);
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
		HttpSession examsession = req.getSession(); //ͨ��request������session
		
		examsession.setAttribute("ec_size",el.getEasySelNum());//����ѡ���������Ž�session
		examsession.setAttribute("hc_size",el.getHardSelNum());//������ѡ���������Ž�session
		examsession.setAttribute("et_size",el.getEasyFillNum());//��������������Ž�session
		examsession.setAttribute("ht_size",el.getHardFillNum());//����������������Ž�session
		examsession.setAttribute("ew_size",el.getEasyQaNum());//�����ʴ��������Ž�session
		examsession.setAttribute("hw_size",el.getHardQaNum());//�������ʴ��������Ž�session
		
		List choice_anwser=new ArrayList();//����ѡ�������
		//------------------��ѡ������--------------------------------��ѡ������
		List list_ec=choiceService.findEChoiceService(subject);//���м�ѡ������
		List ec=new ArrayList();//���м�ѡ���������
		int i=0;
		for(i=0; i<list_ec.size();  i++){
			ec.add(i, i);
		}
		for(i=0; i<el.getEasySelNum();  i++){
			int j=(int)(0+Math.random()*(ec.size()-0));
			int index=(int)ec.get(j);//������Ϊj�ļ�ѡ��������list_ec�е��±�
			ec.remove(j);//�Ƴ����Ϊj�ļ�ѡ������
			Choice ec_subject=(Choice)list_ec.get(index);
			examsession.setAttribute("ec"+i,ec_subject);
			choice_anwser.add(i, ec_subject.getAnswer());//����ѡ����𰸷Ž�choice_anwser
		}
		//------------------����ѡ������--------------------------------����ѡ������
		List list_hc=choiceService.findHChoiceService(subject);//��������ѡ������
		List hc=new ArrayList();//��������ѡ���������
		for(int k=0; k<list_hc.size();  k++){
			hc.add(k, k);
		}
		for(int k=0; k<el.getHardSelNum();  k++){
			int j=(int)(0+Math.random()*(hc.size()-0));
			int index=(int)hc.get(j);//������Ϊj������ѡ��������list_ec�е��±�
			hc.remove(j);//�Ƴ����Ϊj������ѡ������
			Choice hc_subject=(Choice)list_hc.get(index);
			examsession.setAttribute("hc"+k,hc_subject);
			choice_anwser.add(i+k, hc_subject.getAnswer());//������ѡ����𰸷Ž�choice_anwser
		}
		examsession.setAttribute("choice_anwser",choice_anwser);//��ѡ����𰸴浽session
		
		
		List tiankong_anwser=new ArrayList();//������������
		//------------------���������--------------------------------���������
		List list_et=tiankongService.findETiankongService(subject);//���м��������
		List et=new ArrayList();//���м�����������
		for(i=0; i<list_et.size();  i++){
			et.add(i, i);
		}
		for(i=0; i<el.getEasyFillNum();  i++){
			int j=(int)(0+Math.random()*(et.size()-0));
			int index=(int)et.get(j);//������Ϊj�ļ����������list_ec�е��±�
			et.remove(j);//�Ƴ����Ϊj�ļ��������
			Tiankong et_subject=(Tiankong)list_et.get(index);
			examsession.setAttribute("et"+i,et_subject);
			tiankong_anwser.add(i, et_subject.getAnswer());//���������𰸷Ž�choice_anwser
		}
		//------------------�����������--------------------------------�����������
		List list_ht=tiankongService.findHTiankongService(subject);//���������������
		List ht=new ArrayList();//������������������
		for(int k=0; k<list_ht.size();  k++){
			ht.add(k,k);
		}
		for(int k=0; k<el.getHardFillNum();  k++){
			int j=(int)(0+Math.random()*(ht.size()-0));
			int index=(int)ht.get(j);//������Ϊj���������������list_ec�е��±�
			ht.remove(j);//�Ƴ����Ϊj�������������
			Tiankong ht_subject=(Tiankong)list_ht.get(index);
			examsession.setAttribute("ht"+k,ht_subject);
			tiankong_anwser.add(i+k, ht_subject.getAnswer());//�����������𰸷Ž�choice_anwser
		}
		examsession.setAttribute("tiankong_anwser",tiankong_anwser);//�������𰸴浽session
		
		//------------------���ʴ�����--------------------------------���ʴ�����
		List list_ew=wendaService.findEWendaService(subject);//���м��ʴ�����
		List ew=new ArrayList();//���м��ʴ��������
		for(i=0; i<list_ew.size();  i++){
			ew.add(i, i);
		}
		for(i=0; i<el.getEasyQaNum();  i++){
			int j=(int)(0+Math.random()*(ew.size()-0));
			int index=(int)ew.get(j);//������Ϊj�ļ��ʴ�������list_ec�е��±�
			ew.remove(j);//�Ƴ����Ϊj�ļ��ʴ�����
			examsession.setAttribute("ew"+i,list_ew.get(index));
		}
		//------------------�����ʴ�����--------------------------------�����ʴ�����
		List list_hw=wendaService.findHWendaService(subject);//���������ʴ�����
		List hw=new ArrayList();//���������ʴ��������
		for(int k=0; k<list_hw.size();  k++){
			hw.add(k, k);
		}
		for(int k=0; k<el.getHardQaNum();  k++){
			int j=(int)(0+Math.random()*(hw.size()-0));
			int index=(int)hw.get(j);//������Ϊj�������ʴ�������list_ec�е��±�
			hw.remove(j);//�Ƴ����Ϊj�������ʴ�����
			examsession.setAttribute("hw"+k,list_hw.get(index));
		}
		
		//------------------������Ϣ--------------------------------������Ϣ
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
		//------------------������Ϣend--------------------------------������Ϣend
		
		return "success";
	}
}
