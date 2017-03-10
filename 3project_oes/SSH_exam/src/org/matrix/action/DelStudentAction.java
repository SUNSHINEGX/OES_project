package org.matrix.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.matrix.action.base.BaseAction;
import org.matrix.exception.ExamException;

public class DelStudentAction extends BaseAction {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		int studentId;
		String idStr = request.getParameter("studentId");
		if(idStr==null||idStr.trim().equals("")){
			throw new ExamException("删除学生的ID丢失！");
		}
		try {
			studentId = Integer.parseInt(idStr.trim());
		} catch (Exception e) {
			throw new ExamException("非法的学生的ID值！");
		}
		examService.deleteStudent(studentId);
		return mapping.findForward("success");
	}
	
}
