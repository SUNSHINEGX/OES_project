package org.matrix.action;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.matrix.action.base.BaseAction;

public class FinishAction extends BaseAction {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		HttpSession session = request.getSession(false);
		Map<String,Integer> replyMap = null;
		if((replyMap = (Map)session.getAttribute("replyMap"))==null){
			replyMap = new HashMap<String,Integer>();
		}
		int questionTotal = 0;
		int rightTotal = 0;
		int total = 0;
		for(String replyId:replyMap.keySet()){
			int score = replyMap.get(replyId);
			total+=score;
			if(score>0){
				rightTotal++;
			}
			questionTotal++;
		}
		request.setAttribute("total", total);
		request.setAttribute("questionTotal", questionTotal);
		request.setAttribute("rightTotal", rightTotal);
		return mapping.findForward("success");
	}
	
}
