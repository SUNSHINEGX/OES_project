package com.online.service;

import java.util.List;

import com.online.domain.Paper;
import com.online.domain.Paperdetail;
import com.online.domain.Question;


public interface PaperService {
    public void addPaper(Paper pap);
    public void deletePaper(Paper pap);
    public List queryPaperList(Paper pap);
    public List queryPaperDetailList(Paper paper); 
    public Paper getPaper(Paper pap);
}