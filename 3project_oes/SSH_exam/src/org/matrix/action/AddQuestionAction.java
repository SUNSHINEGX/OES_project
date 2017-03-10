package org.matrix.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.DynaValidatorForm;
import org.matrix.action.base.BaseAction;

public class AddQuestionAction extends BaseAction {


	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		//System.out.println("saaa");
		DynaValidatorForm addStudentForm = (DynaValidatorForm)form;
		String title = (String)addStudentForm.get("title");
		String examType = (String)addStudentForm.get("examType");
		String score = (String)addStudentForm.get("score");
		String level = (String)addStudentForm.get("level");
		String type = (String)addStudentForm.get("note");
		String selectOption = (String)addStudentForm.get("choices");
		String standardAnswer = (String)addStudentForm.get("standardAnswer");
		examService.addQuestion(title, level, Integer.parseInt(score), standardAnswer, type, selectOption, Integer.parseInt(examType));
		return mapping.findForward("success");
	}
	
}
