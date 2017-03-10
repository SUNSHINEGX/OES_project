package org.matrix.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.DynaValidatorForm;
import org.matrix.action.base.BaseAction;

public class AddStudentAction extends BaseAction {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		DynaValidatorForm addStudentForm = (DynaValidatorForm)form;
		String realname = (String)addStudentForm.get("realname");
		String stuNumber = (String)addStudentForm.get("stuNumber");
		String className = (String)addStudentForm.get("className");
		String humanId = (String)addStudentForm.get("humanId");
		String email = (String)addStudentForm.get("email");
		String address = (String)addStudentForm.get("address");
		String phone = (String)addStudentForm.get("phone");
		examService.addStudent(stuNumber, realname, className, humanId, email, address, phone);
		return mapping.findForward("success");
	}
	
}
