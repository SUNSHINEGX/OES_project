package org.matrix.action;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.DynaValidatorForm;
import org.matrix.action.base.BaseAction;
import org.matrix.pojo.Question;

public class ReplyAction extends BaseAction {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		HttpSession session = request.getSession(false);
		Map<String,Integer> replyMap = null;
		if((replyMap = (Map)session.getAttribute("replyMap"))==null){
			replyMap = new HashMap<String,Integer>();
		}
		DynaValidatorForm replyForm = (DynaValidatorForm)form;
		String questionId = (String)replyForm.get("id");
		String[] options = (String[])replyForm.get("options");

		Question question = examService.getQuestionById(Integer.parseInt(questionId));
		//���ش�������������һ��Map�У���ԷŸ���÷�
		//�Ƚ��û��ύ��ѡ��ѡ���������������бȶԣ���ͬ���ԣ�������Ŀ�����ŵ�replyMap�����У��������0��
		if(Arrays.equals(options, question.getQuAnswer().split(":"))){
			replyMap.put(questionId, question.getQuScore());
		}
		//����0��
		else{
			replyMap.put(questionId, 0);
		}
		session.setAttribute("replyMap", replyMap);
		List<Integer> alreadys = new ArrayList<Integer>();

		int questionIndex = 1;
		//���Ѿ��������ĿID�ŵ�alreadys�����У������ٱ�ѡ��
		for(String replyId:replyMap.keySet()){
			alreadys.add(Integer.parseInt(replyId));
			questionIndex++;
		}
		//ֻ��10�⣬�����˳�
		if(questionIndex>10){
			return mapping.findForward("finish");
		}
		int typeId = (Integer)session.getAttribute("typeId");
		//��ȡ��һ�⣬�����alreadys���Ѿ��������⣬Ҫ�жϹ���
		Question nextQuestion = examService.getNextQuestion(alreadys, typeId);
		request.setAttribute("question", nextQuestion);
		List<String> nextOptions = new ArrayList<String>();
		//��ȡ��һ��Ŀ��ѡ��
		for(String option:nextQuestion.getSelectOption().split(":")){
			nextOptions.add(option);
		}
		request.setAttribute("questionIndex", questionIndex);
		request.setAttribute("questionOption", nextOptions);
		return mapping.findForward("success");
	}

}
