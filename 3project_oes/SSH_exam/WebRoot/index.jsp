<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<meta http-equiv="Content-Language" content="zh-cn">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>===在线考试系统===</title>
		<link href="images/Style.css" rel="stylesheet" type="text/css">
	</head>
	<body background="#999999">
		<div align="center">
			<table width="777" border="0" cellpadding="0" cellspacing="0"
				bgcolor="#FFFFFF" style="border: 2px solid #008000; padding: 0px">
				<tr>
					<td height="162" align="justify" valign="bottom"
						background="images/2.jpg"
						style="border-bottom: 1px solid #008000; padding: 0">
					</td>
				</tr>
				<tr>
					<td height="289" align="center">
						<a href="login.do">开始在线考试</a>
						<br>
						<a href="admin.do">进入后台管理</a>
					</td>
				</tr>
				<tr bgcolor="#999999">
					<td height="52">
						<div align="center" style="font: 9pt">
							All Rights Reserved.
							<br>
							版权所有 Copyright@2017
							<BR>
							如有任何问题和建议，
							<A href="mailto:ajaxdreamer@gmail.com">请E-mail to me</A>！
							<BR>
							建议您使用1024*768分辨率，IE5.0以上版本浏览本站!
						</div>
					</td>
				</tr>
			</table>

		</div>

	</body>
</html>
