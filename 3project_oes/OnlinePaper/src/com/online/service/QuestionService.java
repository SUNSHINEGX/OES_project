package com.online.service;

import java.util.List;
import com.online.domain.Question;


public interface QuestionService {
    public void addQuestion(Question qes);
    public void deleteQuestion(Question qes);
    public List queryQuestionList(Question qes);
    public Question getQuestion(Question qes);
    
}