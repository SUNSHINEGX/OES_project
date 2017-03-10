<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3c.org/TR/1999/REC-html401-19991224/loose.dtd">
<%@page language="java" pageEncoding="GBK"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<html>
	<head>
		<title>欢迎登陆</title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<link rel="stylesheet" type="text/css" href="css/styles.css" />
	</head>
	<body id=login>
		<s:form action="validateOperatorAction.action" validate="false"
			name="loginForm">
			<div id=wrappertop></div>
			<div id=wrapper>
				<div id=content>
					<div id=header>
						<h1>
							<img src="images/Ambow.png">
						</h1>
					</div>
					<div id=darkbanner>
						<h2>
							登&nbsp;&nbsp;录
						</h2>
					</div>
					<div id=darkbannerwrap></div>
					<fieldset class=form>
					     <DIV id=loginError><s:fielderror /></DIV>
						<p>
							<label for=user_name>
								用户名:
							</label>
							 <s:textfield  name="optID"  key="optID" cssClass="TxtUserNameCssClass" maxLength="20" theme="simple" />
						</p>
						<p>
							<label for=user_password>
								密&nbsp;&nbsp;&nbsp;&nbsp;码:
							</label>
							<s:password  cssClass="TxtPasswordCssClass" name="password"  key="password" theme="simple" ></s:password>
						</p>
						<p>
							<button class=positive name=submit type=submit>
								登&nbsp;&nbsp;&nbsp;&nbsp;录
							</button>
						<ul id=forgottenpassword>
							<li class=boldtext>
								|
							</li>
							<li>
								<a href="">遗忘密码？</a>
							</li>
						</ul>
					</fieldset>
				</div>
			</div>
			<div id=wrapperbottom_branding>
				<div id=wrapperbottom_branding_text>
					网上在线考试系统测试版&nbsp;&nbsp;2011-2012
				</div>
			</div>
		</s:form>
	</body>
</html>
