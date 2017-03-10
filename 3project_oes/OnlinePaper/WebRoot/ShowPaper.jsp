<%@ page language="java" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<link href="<s:url value="/css/main.css" />" rel="stylesheet" type="text/css" />
 您正在查看的信息详细如下:<br>

<s:bean  name="com.online.domain.Paper" id="paper">
 ---试卷基本信息---<br>
   试卷号: <s:property value="paper.paperId" />&nbsp;&nbsp;&nbsp; 试卷名称: <s:property value="paper.paperName" /><br>
   试卷满分: <s:property value="paper.fullScore" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;出卷人: <s:property value="paper.byUser" /><br>
 ---试卷试题信息---
      <s:iterator value="paper.paperdetails" id="iterOptions" >
           &nbsp;&nbsp;<s:property value="#iterOptions.paperDetailId"  /><br>
            <s:iterator value="#iterOptions.question.questiondetails" id="subIterOptions" >
                <s:property value="#subIterOptions.optionNo"  /><br>
                <s:property value="#subIterOptions.optionContent"  /><br>
           </s:iterator>
           
     </s:iterator>
</s:bean>