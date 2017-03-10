package com.online.action;

import java.util.HashSet;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.online.domain.Operator;
import com.online.domain.Question;
import com.online.domain.Questiondetail;
import com.online.domain.Studentinfo;
import com.online.service.QuestionService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

//public class QuestionAction {
public class QuestionAction extends ActionSupport {
	public QuestionService questionServ;
    public Integer questID;
	public String type;
	public String mainContent;
	public String easyLevel;
	public String answer;
	public Integer score;
	
	public String optionA;
	public String optionB;
	public String optionC;
	public String optionD;
	
	public List<Question> questionList;
	public Question question;

	
	public String  addQuestion()
	  {
		Question ques=new  Question();
		ques.setMainContent(mainContent);
		ques.setEasyLevel(easyLevel);
		ques.setScore(score);
		ques.setAnswer(answer);
		ques.setType(type);
		//ques.setQuestiondetails(questiondetails);
		
		Questiondetail quesDetailA=new  Questiondetail();
		quesDetailA.setOptionNo("A");
		quesDetailA.setOptionContent(optionA);
		quesDetailA.setQuestion(ques);
		
		Questiondetail quesDetailB=new  Questiondetail();
		quesDetailB.setOptionNo("B");
		quesDetailB.setOptionContent(optionB);
		quesDetailB.setQuestion(ques);

		
		Questiondetail quesDetailC=new  Questiondetail();
		quesDetailC.setOptionNo("C");
		quesDetailC.setOptionContent(optionC);
		quesDetailC.setQuestion(ques);
		
		Questiondetail quesDetailD=new  Questiondetail();
		quesDetailD.setOptionNo("D");
		quesDetailD.setOptionContent(optionD);
		quesDetailD.setQuestion(ques);
		
		HashSet<Questiondetail> hs=new HashSet<Questiondetail>();
		hs.add(quesDetailA);
		hs.add(quesDetailB);
		hs.add(quesDetailC);
		hs.add(quesDetailD);
		
        ques.setQuestiondetails(hs);		
        this.getQuestionServ().addQuestion(ques);
		return "goList";	
	  }
	
	public String deleteQuestion()
	  {
		Question qes=new Question();
		qes.setQuestId(questID);
		qes=this.getQuestionServ().getQuestion(qes);
		this.getQuestionServ().deleteQuestion(qes);
		return "goList";
	  }
	
	public String queryQuestionList()
	  { 
		questionList=this.getQuestionServ().queryQuestionList(null);
		return "list";
	  }
	
	public String queryQuestionForPaperList()
	  {
		ActionContext ctx = ActionContext.getContext();        
		HttpServletRequest request = (HttpServletRequest)ctx.get(ServletActionContext.HTTP_REQUEST);
		String searchFlag=(String)request.getParameter("search");
		if (searchFlag==null)
		   {
			HttpSession session=request.getSession();
		    session.removeAttribute("paperQuestionList");
		   }
		
		questionList=this.getQuestionServ().queryQuestionList(null);
		return "listForpaper";
	  }
	
	public String getQuestionBean()
	  {
		Question qes=new Question();
		qes.setQuestId(questID);
		question=this.getQuestionServ().getQuestion(qes);
		return "beanInfo";
	  }
	
	
	
	//get and set method 
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getMainContent() {
		return mainContent;
	}

	public void setMainContent(String mainContent) {
		this.mainContent = mainContent;
	}

	public String getEasyLevel() {
		return easyLevel;
	}

	public void setEasyLevel(String easyLevel) {
		this.easyLevel = easyLevel;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public List getQuestionList() {
		return questionList;
	}

	public void setQuestionList(List questionList) {
		this.questionList = questionList;
	}


	public QuestionService getQuestionServ() {
		return questionServ;
	}

	public void setQuestionServ(QuestionService questionServ) {
		this.questionServ = questionServ;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public String getOptionA() {
		return optionA;
	}

	public void setOptionA(String optionA) {
		this.optionA = optionA;
	}

	public String getOptionB() {
		return optionB;
	}

	public void setOptionB(String optionB) {
		this.optionB = optionB;
	}

	public String getOptionC() {
		return optionC;
	}

	public void setOptionC(String optionC) {
		this.optionC = optionC;
	}

	public String getOptionD() {
		return optionD;
	}

	public void setOptionD(String optionD) {
		this.optionD = optionD;
	}

	public Integer getQuestID() {
		return questID;
	}

	public void setQuestID(Integer questID) {
		this.questID = questID;
	}
}