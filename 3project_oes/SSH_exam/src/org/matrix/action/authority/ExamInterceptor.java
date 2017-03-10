package org.matrix.action.authority;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.struts.action.ActionMapping;

public class ExamInterceptor implements MethodInterceptor {

	public Object invoke(MethodInvocation invocation) throws Throwable {
		HttpServletRequest request = null;
		ActionMapping mapping = null;
		Object[] args = invocation.getArguments();
		for(int i=0;i<args.length;i++){
			if(args[i] instanceof HttpServletRequest) request = (HttpServletRequest)args[i];
			if(args[i] instanceof ActionMapping) mapping = (ActionMapping)args[i];
		}
			HttpSession session = request.getSession(false);
			Object student = session.getAttribute("student");
			Object typeId = session.getAttribute("typeId");
		if(student!=null&&typeId!=null){
			return invocation.proceed();
		}
		else{
			request.setAttribute("msg","您还没有登录，请先登录");
			return mapping.findForward("loginExam");
		}
	}

}
