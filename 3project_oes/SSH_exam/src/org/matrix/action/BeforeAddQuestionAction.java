package org.matrix.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.matrix.action.base.BaseAction;

public class BeforeAddQuestionAction extends BaseAction {

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		//System.out.println("sss");
		List list=examService.getAllExamType();
		//System.out.println(list);
		request.setAttribute("typeList",list);
		
		return mapping.findForward("success");
	}
	
}
