<%@ page language="java"  pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<link href="<s:url value="/css/main.css" />" rel="stylesheet" type="text/css" />
 您正在查看的信息详细如下:<br>
<s:bean  name="com.online.domain.Studentinfo" id="studentInfo">
   姓名: <s:property value="studentInfo.name" />&nbsp;&nbsp;&nbsp; 帐号: <s:property value="studentInfo.operator.optId" /><br>
   年龄: <s:property value="studentInfo.age" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 性别: <s:property value="studentInfo.sex" /><br>
   年级: <s:property value="studentInfo.grade" />&nbsp;&nbsp;&nbsp;&nbsp; 班主任: <s:property value="studentInfo.teacher" />
</s:bean>