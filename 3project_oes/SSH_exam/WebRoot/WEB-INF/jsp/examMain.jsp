<%@ page language="java" contentType="text/html;charset=UTF-8"
	errorPage="exception.jsp"%>
<%@ include file="taglibs.jsp"%>
<html>
	<head>

		<title>欢迎光临在线考试系统</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
		<link href="images/Style.css" rel="stylesheet" type="text/css">
	</head>
	<body topmargin="100">
		<form action="reply.do" method="post">
			<table width="600" height="243" border="0" align="center"
				cellpadding="0" cellspacing="0">
				<tr>
					<td width="49" height="35" background="images/HOME_BG3.GIF">
						&nbsp;
					</td>
					<td height="35" background="images/HOME_BG9.GIF">
						<div align="center">
							<span class="Xsmall"><font color="#FF0000"><strong><font
										color="red">${sessionScope.student }</font>同学，你已经开始了${sessionScope.typeName
										}考试！</strong>
							</font>
							</span>
						</div>
					</td>
					<td width="13" height="1">
						<img src="images/HOME_BG8.GIF" width="13" height="35">
					</td>
				</tr>
				<tr>
					<td width="49" background="images/HOME_BG1.GIF">
						<br>
					</td>
					<td background="images/home_bg10.gif">
						<p>
							&nbsp;
						</p>
					</td>
					<td width="13" background="images/HOME_BG7.GIF">
						&nbsp;
					</td>
				</tr>
				<tr>
					<td width="49" background="images/HOME_BG1.GIF">
					</td>
					<td background="images/home_bg10.gif">
						<p>
							&nbsp;&nbsp;第${requestScope.questionIndex}题，该题的分数为：${requestScope.question.quScore}
							<br>
							&nbsp;&nbsp; 问题：${requestScope.question.quTitle }
							<br>
							&nbsp;&nbsp;选项如下，请在您认为正确的选项前打勾
						</p>
						<input type="hidden" name="id"
							value="${requestScope.question.id }" />
						<logic:present name="questionOption" scope="request">
							<logic:iterate id="option" name="questionOption" scope="request"
								indexId="index">
               &nbsp;&nbsp;<input type="checkbox" value='${index+1 }'
									name="questionOption" />&nbsp;${index+1}.<bean:write
									name="option" />
								<br />
							</logic:iterate>
						</logic:present>
					</td>
					<td background="images/HOME_BG7.GIF">
						&nbsp;
					</td>
				</tr>
				<tr>
					<td width="51" background="images/HOME_BG1.GIF">
						<br>
					</td>
					<td background="images/home_bg10.gif">
						<div align="center">
							<input type="submit" value="提交">
							&nbsp;
							<input type="reset" value="重设">
							&nbsp;
						</div>
					</td>
					<td background="images/HOME_BG7.GIF">
						&nbsp;
					</td>
				</tr>
				<tr>
					<td height="12" background="images/HOME_BG4.GIF">
						&nbsp;
					</td>
					<td background="images/HOME_BG5.gif">
						&nbsp;
					</td>
					<td background="images/HOME_BG6.GIF">
						&nbsp;
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>
