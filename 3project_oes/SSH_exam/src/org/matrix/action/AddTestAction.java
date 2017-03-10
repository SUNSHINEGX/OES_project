package org.matrix.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.DynaValidatorForm;
import org.matrix.action.base.BaseAction;

public class AddTestAction extends BaseAction {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		DynaValidatorForm addStudentForm = (DynaValidatorForm)form;
		String examName = (String)addStudentForm.get("testName");
		String examTime = (String)addStudentForm.get("testTime");
		examService.addExamType(examName, examTime);
		return mapping.findForward("success");
	}
	
}
