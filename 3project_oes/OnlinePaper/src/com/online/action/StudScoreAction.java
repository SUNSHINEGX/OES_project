package com.online.action;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.online.domain.Operator;
import com.online.domain.Paper;
import com.online.domain.Paperdetail;
import com.online.domain.Studentinfo;
import com.online.domain.Studscore;
import com.online.domain.Studscoredetail;
import com.online.service.PaperService;
import com.online.service.RegistService;
import com.online.service.StudScoreService;
import com.opensymphony.xwork2.ActionContext;

public class StudScoreAction {
   public StudScoreService studScoreServ;
   public PaperService paperServ;
   public RegistService registServ;
	
   public Integer studScoreID;
   public Integer paperID;
   public Integer stdID;
   public Studscore studScore;
   public List<Studscore> studScoreList;
   
   public String  addStudScore()
	  {
       ActionContext ctx = ActionContext.getContext();        
	   HttpServletRequest request = (HttpServletRequest)ctx.get(ServletActionContext.HTTP_REQUEST);
      //从session中取出登录用户//
	   //String optID=(String)request.getSession().getAttribute("loginID");
	   
	   Operator opt=(Operator)request.getSession().getAttribute("currentUser");;
	   //opt.setOptId(optID);
	   //opt=this.getRegistServ().getOperator(opt);
	   Set hsStud=opt.getStudentinfos();
	   Iterator it_studinfo=hsStud.iterator();
	   Studentinfo studinfo=(Studentinfo)hsStud.iterator().next();
      //----取出试卷信息------------------//	   
	   Paper paper=new Paper();
	   paper.setPaperId(paperID);
	   paper=this.getPaperServ().getPaper(paper);

	   Studscore studScore=new Studscore();
	   studScore.setPaper(paper);
	   
	   Iterator<Paperdetail> it=paper.getPaperdetails().iterator();
	   Paperdetail  papderDetail=null;
	   HashSet<Studscoredetail> hs=new HashSet<Studscoredetail>();
	   int totalScore=0;
	   //循环获取试题，并进行自动判卷及评分
	   while (it.hasNext())
	    {
		   papderDetail=it.next();

		   String answer[]=request.getParameterValues("paper_chooses_"+papderDetail.getPaperDetailId().toString());
		   String answerString=fromArrayToStr(answer);
		   String correctString=fromArrayToStr(papderDetail.getQuestion().getAnswer().split(","));

		   Studscoredetail studScoreDetail=new  Studscoredetail();
		   studScoreDetail.setPaperdetail(papderDetail);
		   studScoreDetail.setStudscore(studScore);
		   studScoreDetail.setAnswer(answerString);
		   studScoreDetail.setCorrectAnswer(correctString);		   
		   studScoreDetail.setCorrectScore(papderDetail.getQuestion().getScore());
		   
		   if (answerString.equals(correctString))
		      {
			   studScoreDetail.setScoreForId(studScoreDetail.getCorrectScore());
			   studScoreDetail.setFlag(1);
			   totalScore=totalScore+studScoreDetail.getCorrectScore().intValue();
		      }
		   else
		     {
			   studScoreDetail.setScoreForId(0);
			   studScoreDetail.setFlag(0);
		     }
		   hs.add(studScoreDetail);
	    }
	     studScore.setScore(totalScore);
	     studScore.setStudscoredetails(hs);
	     studScore.setStudentinfo(studinfo);
	     this.getStudScoreServ().addStudScore(studScore);
		return "goList";
	  }
   
   public String fromArrayToStr(String[] str)
      {
	   String rtnString="";
	   for (int i=0;i<str.length;i++)
	     {
		   rtnString=rtnString+str[i].trim();
	     }
	   return rtnString;
      }
   

   public String queryStudScoreList()
	  { 
		//studScoreList=this.getPaperServ().queryPaperList(null);
		Studscore studScore=new Studscore();
		studScore.setStudScoreId(studScoreID);
		studScoreList=this.getStudScoreServ().queryStudscoreList(studScore);
		return "list";
	  }
	
	public String getStudScoreBean()
	  {
		Studscore sts=new Studscore();
		sts.setStudScoreId(studScoreID);
		studScore=this.getStudScoreServ().getStudscore(sts);
		return "beanInfo";		
	  }

public Integer getStudScoreID() {
	return studScoreID;
}

public void setStudScoreID(Integer studScoreID) {
	this.studScoreID = studScoreID;
}
public StudScoreService getStudScoreServ() {
	return studScoreServ;
}
public void setStudScoreServ(StudScoreService studScoreServ) {
	this.studScoreServ = studScoreServ;
}
public Studscore getStudScore() {
	return studScore;
}
public void setStudScore(Studscore studScore) {
	this.studScore = studScore;
}
public Integer getPaperID() {
	return paperID;
}
public void setPaperID(Integer paperID) {
	this.paperID = paperID;
}
public Integer getStdID() {
	return stdID;
}
public void setStdID(Integer stdID) {
	this.stdID = stdID;
}
public List<Studscore> getStudScoreList() {
	return studScoreList;
}
public void setStudScoreList(List<Studscore> studScoreList) {
	this.studScoreList = studScoreList;
}
public PaperService getPaperServ() {
	return paperServ;
}
public void setPaperServ(PaperService paperServ) {
	this.paperServ = paperServ;
}

public RegistService getRegistServ() {
	return registServ;
}

public void setRegistServ(RegistService registServ) {
	this.registServ = registServ;
}
}
