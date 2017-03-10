package org.matrix.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.DynaValidatorForm;
import org.matrix.action.base.BaseAction;

public class AdminLoginAction extends BaseAction {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		DynaValidatorForm addStudentForm = (DynaValidatorForm)form;
		String name = (String)addStudentForm.get("name");
		String pass = (String)addStudentForm.get("password");
		if(examService.adminLogin(name, pass)){
			request.getSession().setAttribute("admin", "admin");
			return mapping.findForward("success");
		}
		request.setAttribute("msg", "用户名和密码不匹配，请重试！");
		return mapping.findForward("failure");
	}

	

}
