package com.online.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.online.domain.Operator;
import com.online.domain.Paper;
import com.online.domain.Paperdetail;
import com.online.domain.Question;
import com.online.domain.Questiondetail;
import com.online.domain.Studentinfo;
import com.online.service.PaperService;
import com.online.service.QuestionService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

//public class QuestionAction {
public class PaperAction extends ActionSupport {
	public PaperService paperServ;

	public Integer paperId;
	public Integer fullScore;
	public Date paperTime;
	public Date validateTime;
	public String paperName;
	public String byUser;
	public List<Paper> paperList;
	public List<Paperdetail> paperdetail;
	public List<Question>	questionList;
	public Paper paper;

	public String addPaper() {
		Paper paper = new Paper();
		paper.setPaperName(paperName);
		paper.setFullScore(fullScore);
		paper.setByUser(byUser);

		HashSet<Paperdetail> hs = new HashSet<Paperdetail>();

		ActionContext ctx = ActionContext.getContext();
		HttpServletRequest request = (HttpServletRequest) ctx
				.get(ServletActionContext.HTTP_REQUEST);
		HttpSession session = request.getSession();

		List questionPaperList = (List) session
				.getAttribute("paperQuestionList");
		if (questionPaperList != null) {
			Iterator it = questionPaperList.iterator();
			while (it.hasNext()) {
				Question qes = (Question) it.next();

				Paperdetail pd = new Paperdetail();
				pd.setPaper(paper);
				pd.setQuestion(qes);
				hs.add(pd);
				// pd.setValidFlag(true);
			}
			paper.setPaperdetails(hs);
		}
		this.getPaperServ().addPaper(paper);
		return "goList";
	}

	public String deletePaper() {
		Paper pap = new Paper();
		pap.setPaperId(paperId);
		pap = this.getPaperServ().getPaper(pap);
		this.getPaperServ().deletePaper(pap);
		return "goList";
	}

	public String queryPaperList() {
		paperList = this.getPaperServ().queryPaperList(null);
		return "list";
	}

	public String queryPaperForScoreList() {
		paperList = this.getPaperServ().queryPaperList(null);
		return "list";
	}

	public String getPaperBean() {
		Paper pap = new Paper();
		pap.setPaperId(paperId);
		paper = this.getPaperServ().getPaper(pap);
		return "beanInfo";
	}

	public String getPaperForScoreBean() {
		Paper pap = new Paper();
		pap.setPaperId(paperId);
		paper = this.getPaperServ().getPaper(pap);
		paperdetail = this.getPaperServ().queryPaperDetailList(paper);
		return "beanInfo";
	}

	public String chooseQesToPaper() {
		ActionContext ctx = ActionContext.getContext();
		HttpServletRequest request = (HttpServletRequest) ctx
				.get(ServletActionContext.HTTP_REQUEST);
		String str = (String) request.getParameter("paramIDs");
		String[] arrayStr = str.split(",");

		HttpSession session = request.getSession();
		//List questionList = (List) session.getAttribute("questionList");
		questionList = (List) session.getAttribute("questionList");

		List questionPaperList = (List) session
				.getAttribute("paperQuestionList");
		if (questionPaperList == null) {
			questionPaperList = new ArrayList();
		}

		Iterator it = questionList.iterator();
		while (it.hasNext()) {
			Question qes = (Question) it.next();
			boolean existFlag = false;
			for (int i = 0; i < arrayStr.length; i++) {
				if (Integer.parseInt(arrayStr[i]) == qes.getQuestId()
						.intValue()) {
					existFlag = true;
					// questionList.remove(qes);
					it.remove();
					questionPaperList.add(qes);
				}
			}
		}
		//session.setAttribute("questionList", questionList);
		session.setAttribute("paperQuestionList", questionPaperList);
		return "choosePage";
	}

	public String choosePaperToQes() {
		ActionContext ctx = ActionContext.getContext();
		HttpServletRequest request = (HttpServletRequest) ctx
				.get(ServletActionContext.HTTP_REQUEST);
		String str = (String) request.getParameter("paramIDs");
		String[] arrayStr = str.split(",");

		HttpSession session = request.getSession();
		// List questionList=(List)session.getAttribute("questionList");
		List questionPaperList = (List) session
				.getAttribute("paperQuestionList");
		//List questionList = (List) session.getAttribute("questionList");
		questionList = (List) session.getAttribute("questionList");

		if (questionPaperList == null) {
			questionPaperList = new ArrayList();
		}

		Iterator it = questionPaperList.iterator();
		while (it.hasNext()) {
			Question qes = (Question) it.next();
			boolean existFlag = false;
			for (int i = 0; i < arrayStr.length; i++) {
				if (Integer.parseInt(arrayStr[i]) == qes.getQuestId()
						.intValue()) {
					existFlag = true;
					// questionList.remove(qes);
					it.remove();
					questionList.add(qes);
				}
			}
		}
		//session.setAttribute("questionList", questionList);
		session.setAttribute("paperQuestionList", questionPaperList);
		return "choosePage";
	}

	// get and set method
	public PaperService getPaperServ() {
		return paperServ;
	}

	public void setPaperServ(PaperService paperServ) {
		this.paperServ = paperServ;
	}

	public Integer getPaperId() {
		return paperId;
	}

	public void setPaperId(Integer paperId) {
		this.paperId = paperId;
	}

	public Integer getFullScore() {
		return fullScore;
	}

	public void setFullScore(Integer fullScore) {
		this.fullScore = fullScore;
	}

	public Date getPaperTime() {
		return paperTime;
	}

	public void setPaperTime(Date paperTime) {
		this.paperTime = paperTime;
	}

	public Date getValidateTime() {
		return validateTime;
	}

	public void setValidateTime(Date validateTime) {
		this.validateTime = validateTime;
	}

	public String getPaperName() {
		return paperName;
	}

	public void setPaperName(String paperName) {
		this.paperName = paperName;
	}

	public String getByUser() {
		return byUser;
	}

	public void setByUser(String byUser) {
		this.byUser = byUser;
	}

	public List<Paper> getPaperList() {
		return paperList;
	}

	public void setPaperList(List<Paper> paperList) {
		this.paperList = paperList;
	}

	public Paper getPaper() {
		return paper;
	}

	public void setPaper(Paper paper) {
		this.paper = paper;
	}

	public List<Paperdetail> getPaperdetail() {
		return paperdetail;
	}

	public void setPaperdetail(List<Paperdetail> paperdetail) {
		this.paperdetail = paperdetail;
	}

	public List<Question> getQuestionList() {
		return questionList;
	}

	public void setQuestionList(List<Question> questionList) {
		this.questionList = questionList;
	}
}