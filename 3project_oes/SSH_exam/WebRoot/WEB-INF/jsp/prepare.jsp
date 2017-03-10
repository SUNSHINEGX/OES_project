<%@ page language="java" contentType="text/html;charset=UTF-8" errorPage="exception.jsp"%>
<%@ include file="taglibs.jsp" %>

<html>
  <head> 
	<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <title>欢迎来到在线考试系统</title>  	
	<link href="images/Style.css" rel="stylesheet" type="text/css" >
  </head>
  
	<body topmargin="100">
		<table width="600" border="0" align="center" cellpadding="0" cellspacing="0">
			<tr>
				<td width="49" height="35" background="images/HOME_BG3.GIF">&nbsp;</td>
				<td height="35"  background="images/HOME_BG9.GIF"><div align="center"><span class="Xsmall"><font color="#FF0000"><strong>欢迎光临在线考试系统</strong></font></span></div>
				</td>
				<td width="13" height="1"><img src="images/HOME_BG8.GIF" width="13" height="35" /></td>
			</tr>
			<tr>
				<td width="49" background="images/HOME_BG1.GIF"><br></td>
				<td background="images/HOME_BG10.GIF"><p><span class="Xsmall">
					<font color="red">${sessionScope.student}</font>同学：
					<br>
						请验证你的学号是否正确！<img src="images/forword_1.gif" width="16" height="15" />
					<br>
						若正确请点击开始进入在线考试，若错误请与考场老师联系！<br>
					<br>
						&nbsp;&nbsp;&nbsp;&nbsp;<img src="images/announce.gif" width="18" height="18" />
						请遵守本考场规则如下：</span></p>
					<blockquote>
						<img src="images/forget_1.gif" width="14" height="14" /><span class="Xsmall"><font color="#FF0000">请不要点击刷新、后退等违纪按钮<br>
						<img src="images/forget_1.gif" width="14" height="14" />考生如果做完试题，可以点击“完成”按钮，提交试卷。<br>
						<img src="images/forget_1.gif" width="14" height="14" />系统将根据考生选择的考试类型，随机从题库生成考题。</font></span></p>
					</blockquote>
				<td width="13" background="images/HOME_BG7.GIF">&nbsp;</td>
			</tr>
			<tr>
				<td width="49" height="42" background="images/HOME_BG2.GIF">&nbsp;</td>
				<td height="22" background="images/home_bg10.gif" bgcolor="#FFFFFF">
					<div align="center">
					请选择考试类型：</div>
					<form name="beginForm" action="begin.do" method="post">
						<div align="center">
							<select name="examType">
							<logic:present name="type" scope="request">
								<logic:iterate id="type" name="type" type="org.matrix.pojo.ExamType" scope="request">
								<option value='<bean:write name="type" property="id" />'><bean:write name="type" property="examName" /></option>
								</logic:iterate>
							</logic:present>
							</select>
							<input type="submit" name="start_b" class="Sborder" id="start_b" value="开始">
						</div>
					</form>
				</td> 
				<td width="13" height="22" background="images/HOME_BG7.GIF">&nbsp;</td>
			</tr>
			<tr>
				<td height="12" background="images/HOME_BG4.GIF">&nbsp;</td>
				<td background="images/HOME_BG5.GIF">&nbsp;</td> 
				<td background="images/HOME_BG6.GIF">&nbsp;</td>
			</tr>
	   </table>
   </body>
</html>