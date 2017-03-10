<%@ page language="java" contentType="text/html;charset=UTF-8" errorPage="exception.jsp"%>
<%@ include file="taglibs.jsp" %>

<html>
  <head> 
	<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <title>欢迎光临国兴在线考试系统</title>  	
	<link href="images/Style.css" rel="stylesheet" type="text/css" >
  </head>
  
	<body topmargin="100">
		<table width="600" height="243" border="0" align="center" cellpadding="0" cellspacing="0">
			<tr>
				<td width="49" height="35" background="images/HOME_BG3.GIF">&nbsp;</td>
				<td height="35"  background="images/HOME_BG9.GIF"><div align="center"><span class="Xsmall"><font color="#FF0000"><strong><font color="red">${sessionScope.student}</font>同学，您参与的${sessionScope.typeName}考试结果如下：</strong></font></span></div>
				</td>
				<td width="13" height="35"><img src="images/HOME_BG8.GIF" width="13" height="35" /></td>
			</tr>
			<tr>
				<td width="49" background="images/HOME_BG1.GIF"><br><br></td>
				<td background="images/home_bg10.gif">
					<div align="center">
						<p>您一共答了：${requestScope.questionTotal}题</p>
						<p>其中答对了：${requestScope.rightTotal}题</p>
						<p>总共得分：${requestScope.total}</p>
					</div>
				</td>
				<td width="13" background="images/HOME_BG7.GIF">&nbsp;</td>
			</tr>
			<tr>
				<td height="12" background="images/HOME_BG4.GIF">&nbsp;</td>
				<td background="images/HOME_BG5.GIF">&nbsp;</td> 
				<td background="images/HOME_BG6.GIF">&nbsp;</td>
			</tr>

	   </table>
   </body>
</html>