package org.matrix.action.base;

import org.apache.struts.action.Action;
import org.matrix.service.ExamService;

public class BaseAction extends Action {
	protected ExamService examService;

	public void setExamService(ExamService examService) {
		this.examService = examService;
	}
	
}
