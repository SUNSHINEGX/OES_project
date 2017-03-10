package org.matrix.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.matrix.action.base.BaseAction;
import org.matrix.exception.ExamException;

public class DelQuestionAction extends BaseAction {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		int questionId;
		String idStr = request.getParameter("questionId");
		if(idStr==null||idStr.trim().equals("")){
			throw new ExamException("删除试题的ID丢失！");
		}
		try {
			questionId = Integer.parseInt(idStr.trim());
		} catch (Exception e) {
			throw new ExamException("非法的试题的ID值！");
		}
		examService.deleteQuestion(questionId);
		return mapping.findForward("success");
	}
	
}
