<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ page pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
	<head>
		<title>register.html</title>

		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="this is my page">
		<meta http-equiv="content-type" content="text/html; charset=UTF-8">

		<!--<link rel="stylesheet" type="text/css" href="./styles.css">-->

	</head>

	<body>

		<H1>
			Demo 邮件系统-用户注册
		</H1>
		<form name="regForm" id="regForm" action="DoRegister.jsp"
			method="post">
			注册用户名:
			<input type="text" name="userName" id="userName"
				onblur="checkUser();">
			<label id="checkResult"></label>
			<br />
			注册密码：
			<input type="password" name="password" id="pasword">
			<br />
			确认密码:
			<input type="password" name="password2" id="pasword2">

			<input type="submit" value="提交">
		</form>
	</body>

	<script language="JavaScript">
		var req;
		function checkUser(){  
			var ckeckResult=document.getElementById("checkReuslt");
			checkResult.innerHTML="正在检验用户名...";
			var userName=document.getElementById("userName").value;
			//alert("eeee");     学会调试
			req=new ActiveXObject("Microsoft.XMLHttp");
		//	alert("eeee222");			
			req.open("get","Http://localhost:8080/OnlinePaper0602/CheckUserName.jsp?checkUserName="+userName);
			req.onreadystatechange=handleRequest;
	//		alert("eeee444");			
			req.send(null);
		}
		
		function handleRequest(){
			var checkResult=document.getElementById("checkResult");
          //  alert(req.readyState);
			if(req.readyState==4){
			 //           alert(req.status);
				if(req.status==200){
				//			            alert(req.responseText);
					checkResult.innerHTML=req.responseText;
				}	
				else{
					alert("An error occurred:"+req.statusText);
				}
			}
		}
	</script>
</html>
