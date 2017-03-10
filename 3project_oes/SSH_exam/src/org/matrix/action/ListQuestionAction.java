package org.matrix.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.matrix.action.base.BaseAction;
import org.matrix.service.ExamService;

public class ListQuestionAction extends BaseAction {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		int questionCount = examService.getQuestionCount();
		if(questionCount<1){
			request.setAttribute("msg", "��ʱû���κ�����!");
			return mapping.findForward("success");
		}
		//��ȡ��ҳ��
		int pageCount = examService.getPageCount(questionCount, ExamService.QUESTION_PAGE_SIZE);
		
		int pageNo;
		String pageNoStr = request.getParameter("pageNo");
		if(pageNoStr==null||pageNoStr.trim().equals("")){
			pageNo = 1;
		}
		try {
			pageNo = Integer.parseInt(pageNoStr.trim());
		} catch (Exception e) {
			pageNo = 1;
		}
		//�������ҳ�Ѿ����������ҳ
		if(pageNo>pageCount){
			pageNo=pageCount;
		}
		request.setAttribute("pageCount", pageCount);
		request.setAttribute("currentPage", pageNo);
		request.setAttribute("questionList", examService.listQuestion(pageNo));
		return mapping.findForward("success");
	}
	
}
