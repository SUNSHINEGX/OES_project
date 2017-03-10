package org.matrix.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.matrix.action.base.BaseAction;

public class PrepareAction extends BaseAction {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		if(request.getSession(false).getAttribute("student")==null){
			return mapping.findForward("loginExam");
		}
		request.setAttribute("type", examService.getAllExamType());
		return mapping.findForward("success");
	}
	
}
