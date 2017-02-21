<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta charset="UTF-8">
		<title>企业测试平台管理入口</title>
		<link rel="stylesheet" type="text/css" href="css/login.css"/>
		<script src="js/jquery-1.10.2.min.js" type="text/javascript" charset="utf-8"></script>
	</head>
	<body>
		<div class="body">
			<header class="wrapper">
			<div class="header">
				
			</div>
		</header>
		<div class="login wrapper clearfix">
			<div class="login_logo">
				<img src="img/ico13.gif"/>
			</div>
			<div class="login_info">
				<div class="information">
					<s:form action="login" method="post">
						<s:textfield label="账 号" name="manageName"></s:textfield>
						<s:password label="密 码" name="password"></s:password>
						<s:select label="角 色" list="#{1:'超级管理员',2:'教师',3:'学生'}" name="identify" listKey="key" listValue="value" >
						</s:select>
						<s:div cssClass="login_btn clearfix">
						<s:submit cssClass="btn_login" theme="simple" value="登陆"></s:submit>
						<input type="button" id="login_2" class="btn_reset" onclick="chongzhi()" value="重置">
						</s:div>						 																														
					</s:form>
				</div>								
			</div>
			<span id="manage_fail">用户名格式不对</span>
			<span id="password_fail">密码格式不对</span>
		</div>
			<footer class="wrapper">
				Copyright @ 2016
			</footer>
		</div>	
	</body>
	<script type="text/javascript">
	function chongzhi(){
		//alert(1);
		document.getElementsByName("manageName")[0].value="";
		document.getElementsByName("password")[0].value="";
	} 
	$(function(){
		$(function(){
			$("input[name='manageName']").blur(function(){
				var str = this.value;
				var reg = new RegExp("3[0-9]+");
				if(!reg.test(str)||str.length>10){
					$("#manage_fail").css("display","block");
				}else{
					$("#manage_fail").css("display","none");
				}
			})
			$("input[name='password']").blur(function(){
				var str = this.value;
				var reg = new RegExp("\\w{5,9}");
				if(!reg.test(str)||str.length>10){
					$("#password_fail").css("display","block");
				}else{
					$("#password_fail").css("display","none");
				}
			})
		})
	}) 
	</script>
</html>