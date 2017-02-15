<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="javax.websocket.Session"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta charset="UTF-8">
		<title>考场界面</title>
		<link rel="stylesheet" type="text/css" href="css/student.css"/>
		<script src="js/jquery-1.10.2.min.js" type="text/javascript" charset="utf-8"></script>
	</head>
	<body>
		<div class="body wrapper">
			<iframe src="header-common.html" width="900px" height="70px" frameborder="0"></iframe>
			<div class="content wrapper ">
				<div class="options">
					<div class="welcome_view clearfix">
						<div class="head_img">
							<img src="img/ico02.gif"/>
						</div>
						<div class="student_name">
							<p>您好，<b id="userName"><%-- <%Object manageName = session.getAttribute("manage_name"); %><%=manageName %> --%>
							<s:property value="#manage_name"/></b></p>
							<b id="classNum" style="display:none"><s:property value="#classNum"/></b>
							<b id="stuNum" style="display:none"><s:property value="#stuNum"/></b>
							<a href="login.jsp">[退出]</a>
						</div>
					</div>
					<div class="option">
						<ul>
							<li>
								<i></i>
								<a class="aa" href="javascript:void(0)" onclick="getTestList()">在线考试</a>
							</li>
							<li>
								<i></i>
								<a class="aa" href="javascript:void(0)" onclick="check_score()">成绩查询</a>
							</li>
							<li>
								<i></i>
								<a class="aa" href="javascript:void(0)" onclick="stu_info()">个人信息管理</a>
							</li>
						</ul>
					</div>
				</div>
				<div class="content_right">
					<div class="test_list on">
						<form>
							<input type="text" name="test_name" id="test_name" />
							<input onclick="getTest()" class="search" type="button" value="检索考试科目"/>
						</form>
						<div class="list_content">
							<p class="clearfix">试卷列表
								<span></span>								
							</p>
							
							<div class="test_time">
								<dl id="testlist_id">
									<%-- <dt>Java程序设计</dt>
									<dd>所属院系：计算机与信息工程学院</dd>
									<dd class="clearfix">
										<span>考试日期：2016-12-8</span>
										<span>开始时间：8:00  </span>
										<span>结束时间：10:00</span>       
										<button>开始考试</button>
									</dd> --%>									
								</dl>								
							</div>
						</div>
					</div>
					<div class="test_score">
						<form>
							<input type="text" name="score_name" id="score_name" />
							<input onclick="findScore()" class="search" type="button" value="输入科目查询考试结果"/>
						</form>
						<div class="score_content">
							<p class="clearfix">成绩列表
								<span></span>								
							</p>
							<table id="score_table" border="0" cellspacing="0" cellpadding="0">									
							</table>
						</div>
					</div>
					<div class="person_info">
						<table id="stuInfo_id" border="0" cellspacing="0" cellpadding="0">
							<!-- <tr>
								<td>学&nbsp;&nbsp;号：</td>
								<td>3113002426</td>
							</tr>
							<tr>
								<td>密&nbsp;&nbsp;码：</td>
								<td>88888</td>
							</tr>
							<tr>
								<td>姓&nbsp;&nbsp;名：</td>
								<td>陈晓明</td>
							</tr>
							<tr>
								<td>性&nbsp;&nbsp;别：</td>
								<td>男</td>
							</tr>
							<tr>
								<td>院&nbsp;&nbsp;系：</td>
								<td>计算机学院</td>
							</tr>
							<tr>
								<td>专&nbsp;&nbsp;业：</td>
								<td>网络工程</td>
							</tr>
							<tr>
								<td>班&nbsp;&nbsp;级：</td>
								<td>130804</td>
							</tr> -->
						</table>
					</div>		
				</div>
			</div>
			
		</div>		
	</body>
	<script src="js/student.js" type="text/javascript" charset="utf-8"></script>
	<script type="text/javascript">
		$(function(){
			$(".option a").click(function(){
				//alert($(".aa").index($(this)));
				$(".content_right>div").eq($(".aa").index($(this))).css("display","block").siblings().css("display","none")
			})
		})
	</script>
</html>