package org.matrix.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.matrix.action.base.BaseAction;
import org.matrix.service.ExamService;

public class ListStudentAction extends BaseAction {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		//System.out.println("显示学生");
		int studentCount = examService.getStudentCount();
		if(studentCount<1){
			request.setAttribute("msg", "暂时没有任何学生!");
			return mapping.findForward("success");
		}
		int pageCount = examService.getPageCount(studentCount, ExamService.STUDENT_PAGE_SIZE);
		
		int pageNo;
		if(request.getParameter("pageNo")==null||request.getParameter("pageNo").trim().equals("")){
			pageNo = 1;
		}
		try {
			pageNo = Integer.parseInt(request.getParameter("pageNo").trim());
		} catch (Exception e) {
			pageNo = 1;
		}
		//如果请求页已经超出了最大页
		if(pageNo>pageCount){
			pageNo=pageCount;
		}
		request.setAttribute("pageCount", pageCount);
		request.setAttribute("currentPage", pageNo);
		request.setAttribute("studentList", examService.listStudent(pageNo));
		return mapping.findForward("success");
	}
	
}
