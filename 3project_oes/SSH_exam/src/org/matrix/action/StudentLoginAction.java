package org.matrix.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.DynaValidatorForm;
import org.matrix.action.base.BaseAction;

public class StudentLoginAction extends BaseAction {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		DynaValidatorForm replyForm = (DynaValidatorForm)form;
		String stuNumber = (String)replyForm.get("stuNumber");
		String stuName = (String)replyForm.get("stuName");
		if(examService.studentLogin(stuName, stuNumber)!=null){
			request.getSession(false).setAttribute("student", stuName);
			return mapping.findForward("success");
		}
		request.setAttribute("msg", "学号和学生姓名不匹配，请重试！");
		return mapping.findForward("failure");
	}
	
}
