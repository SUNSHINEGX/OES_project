package org.matrix.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.matrix.action.base.BaseAction;
import org.matrix.pojo.Question;

public class BeginAction extends BaseAction {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		HttpSession session = request.getSession(false);
		if(session.getAttribute("student")==null){
			return mapping.findForward("loginExam");
		}
		int typeId = Integer.parseInt(request.getParameter("examType"));
		
		session.setAttribute("typeId", typeId);
		session.setAttribute("typeName", examService.getExamTypeName(typeId));
		Question question = examService.getNextQuestion(null, typeId);
		request.setAttribute("question", question);
		List<String> options = new ArrayList<String>();
		//读出问题的选项，解析为数组
		for(String option:question.getSelectOption().split(":")){
			options.add(option);
		}
		//计数为第一题
		request.setAttribute("questionIndex", 1);
		request.setAttribute("questionOption", options);
		return mapping.findForward("success");
	}
	
}
