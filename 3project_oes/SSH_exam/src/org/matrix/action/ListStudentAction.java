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
		//System.out.println("��ʾѧ��");
		int studentCount = examService.getStudentCount();
		if(studentCount<1){
			request.setAttribute("msg", "��ʱû���κ�ѧ��!");
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
		//�������ҳ�Ѿ����������ҳ
		if(pageNo>pageCount){
			pageNo=pageCount;
		}
		request.setAttribute("pageCount", pageCount);
		request.setAttribute("currentPage", pageNo);
		request.setAttribute("studentList", examService.listStudent(pageNo));
		return mapping.findForward("success");
	}
	
}
