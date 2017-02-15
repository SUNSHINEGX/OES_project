<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<style>
 a{
 width:100px;
 height:50px;
 display:block;
 border:3px solid black;
 }
</style>
</head>
<body>
<button id="sub" onclick="sub()">提交</button>
<script type="text/javascript">
	function sub(){
	  window.location = encodeURI(encodeURI("startexam.action?StuName=老王&StuNum=123&classNum=130804&subject=Java&time=360"));
	}
</script>
</body>
</html>