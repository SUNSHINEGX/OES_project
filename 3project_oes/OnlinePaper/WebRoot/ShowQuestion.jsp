<%@ page language="java"  pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<link href="<s:url value="/css/main.css" />" rel="stylesheet" type="text/css" />
 您正在查看的信息详细如下:<br>
<s:bean  name="com.online.domain.Question" id="question">
   题号: <s:property value="question.questId" />&nbsp;&nbsp;&nbsp; 题型: <s:property value="question.type" /><br>
   难易度: <s:property value="question.easyLevel" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 答案: <s:property value="question.answer" /><br>
   题干: <s:property value="question.mainContent" />&nbsp;&nbsp;&nbsp;&nbsp;<br>
      <s:iterator value="question.questiondetails" id="iterOptions" >
           &nbsp;&nbsp;<s:property value="#iterOptions.optionNo"  />:<s:property value="#iterOptions.optionContent"  /> <br>
     </s:iterator>
</s:bean>