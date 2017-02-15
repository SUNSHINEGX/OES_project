<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta charset="utf-8" />
		<title></title>
		<link rel="stylesheet" type="text/css" href="css/teacher.css"/>
	</head>
	<body>
		<!--头部的引入-->
		<div class="head">
			<iframe src="header-common.html" height="59px" width="900px" frameborder="0" scrolling="no"></iframe>
		</div>
		<!--主体部分开始-->
		<div class="body clearfix">
			<!--主体左边开始-->
			<div class="left">
				<div class="shang clearfix">
					<img src="img/ico02.gif"/>
					<span>您好，<b name="TeaName"><%Object manageName = session.getAttribute("manage_name"); %><%=manageName %></b></span>
					<a href="login.jsp">[ 退出  ]</a>
				</div>
				<div class="xia">
					<ul>
						<li>
							<h3><img src="img/ico04.gif"/>试卷检索</h3>
							<ol class="clearfix">
								<li class="chaxuan"><img src="img/ico06.gif"/>选择题</li>
								<li class="chatian"><img src="img/ico06.gif"/>填空题</li>
								<li class="chawen"><img src="img/ico06.gif"/>问答题</li>
							</ol>
						</li>
						<li>
							<h3><img src="img/ico04.gif"/>更新题库</h3>
							<ol class="clearfix">
								<li class="gaixuan"><img src="img/ico06.gif"/>选择题</li>
								<li class="gaitian"><img src="img/ico06.gif"/>填空题</li>
								<li class="gaiwen"><img src="img/ico06.gif"/>问答题</li>
							</ol>
						</li>
						<li>
							<h3><img src="img/ico04.gif"/>试卷管理</h3>
							<ol class="clearfix">
								<li class="tixing"><img src="img/ico06.gif"/>题型设置</li>
								<li class="wendapigai" id="wendapigaianniu"><img src="img/ico06.gif"/>问答题批改</li>
							</ol>
						</li>
						<li>
							<h3><img src="img/ico04.gif"/>信息中心</h3>
							<ol class="clearfix">
								<li class="chafen" id="chafen1"><img src="img/ico06.gif"/>成绩查询</li>
								<li class="geren"><img src="img/ico06.gif"/>个人信息</li>
								<li class="gaimi"><img src="img/ico06.gif"/>密码修改</li>
							</ol>
						</li>
					</ul>
				</div>
			</div>
			<!--主体左边结束-->
			<!--主体右边开始-->
			<div class="right">
				<!--检索部分-->
				<div class="chaxuan">
					<div class="sousuo">
						<strong><img src="img/ico07.gif"/>查找内容:</strong>
						<input type="text" name="" id="chaxuan" value="" />
						<input type="button" name="" id="" value="查询" />
					</div>
					<h1>选择题列表</h1>
					<table border="1" cellspacing="0" cellpadding="0">
						<tr id="choiceti">
							<th>题目</th>
							<th>操作</th>
						</tr>
					</table>
				</div>
				<div class="chatian">
					<div class="sousuo">
						<strong><img src="img/ico07.gif"/>查找内容:</strong>
						<input type="text" name="" id="chatian" value="" />
						<input type="button" name="" id="" value="查询" />
					</div>
					<h1>填空题列表</h1>
					<table border="1" cellspacing="0" cellpadding="0">
						<tr id="tiankongti">
							<th>题目</th>
							<th>操作</th>
						</tr>
					</table>
				</div>
				<div class="chawen">
					<div class="sousuo">
						<strong><img src="img/ico07.gif"/>查找内容:</strong>
						<input type="text" name="" id="chawen" value="" />
						<input type="button" name="" id="" value="查询" />
					</div>
					<h1>问答题列表</h1>
					<table border="1" cellspacing="0" cellpadding="0">
						<tr id="wendati">
							<th>题目</th>
							<th>操作</th>
						</tr>
					</table>
				</div>
				<!--更新部分-->
				<div class="gaixuan">
					<form action="#" method="post" id="xuanzeti">
						<h1>更新题库</h1>
						<b>题  目</b><textarea name="choice.SelTop"></textarea>
						<b>选项A</b><textarea name="choice.A"></textarea>
						<b>选项B</b><textarea name="choice.B"></textarea>
						<b>选项C</b><textarea name="choice.C"></textarea>
						<b>选项D</b><textarea name="choice.D"></textarea>
						<strong>答案</strong><input type="radio" name="choice.answer" id="" value="A" /> A 
						<input type="radio" name="choice.answer" id="" value="B" /> B 
						<input type="radio" name="choice.answer" id="" value="C" /> C 
						<input type="radio" name="choice.answer" id="" value="D" /> D 
						<br /><strong>难度</strong><input type="radio" name="choice.level" id="nanyi" value="0" /> easy 
						<input type="radio" name="choice.level" id="nanyi" value="1" /> hard 
						<br /><input type="button" name="choice.level" id="tianjia" value="添加" />
						<input type="reset" name="" id="chongzhi" value="重置" />
					</form>
				</div>
				<div class="gaitian">
					<form action="#" method="post" id="tiankongti">
						<h1>更新题库</h1>
						<b>题  目</b><textarea name="tiankong.FillTop"></textarea>
						<b>答  案</b><textarea name="tiankong.answer"></textarea>
						<br /><strong>难度</strong><input type="radio" name="tiankong.level" id="nanyi" value="0" /> easy 
						<input type="radio" name="tiankong.level" id="nanyi" value="1" /> hard 
						<br /><input type="button" name="" id="tianjia" value="添加" />
						<input type="reset" name="" id="chongzhi" value="重置" />
					</form>
				</div>
				<div class="gaiwen">
					<form action="#" method="post" id="wendati">
						<h1>更新题库</h1>
						<b>题  目</b><textarea name="wenda.QaTop"></textarea>
						<br /><strong>难度</strong><input type="radio" name="wenda.level" id="nanyi" value="0" /> easy 
						<input type="radio" name="wenda.level" id="nanyi" value="1" /> hard 
						<br /><input type="button" name="" id="tianjia" value="添加" />
						<input type="reset" name="" id="chongzhi" value="重置" />
					</form>
				</div>
				<!--试卷管理部分-->
				<div class="tixing">
					<form action="#" method="post" id="tixingshezhi">
						<h1>题型设置</h1>
						<ul>
							<li>
								<span>选择题&nbsp;&nbsp;简单：</span><input type="text" name="exampaper.EasySelNum" id="xuanjian" value="" />
								<span>难：</span><input type="text" name="exampaper.HardSelNum" id="xuannan" value="" />
								<span>分值：</span><input type="text" name="exampaper.SelScore" id="xuanfen" value="" />
							</li>
							<li>
								<span>填空题&nbsp;&nbsp;简单：</span><input type="text" name="exampaper.EasyFillNum" id="tianjian" value="" />
								<span>难：</span><input type="text" name="exampaper.HardFillNum" id="tiannan" value="" />
								<span>分值：</span><input type="text" name="exampaper.FillScore" id="tianfen" value="" />
							</li>
							<li>
								<span>问答题&nbsp;&nbsp;简单：</span><input type="text" name="exampaper.EasyQaNum" id="wenjian" value="" />
								<span>难：</span><input type="text" name="exampaper.HardQaNum" id="wennan" value="" />
								<span>分值：</span><input type="text" name="exampaper.QaSocre" id="wenfen" value="" />
							</li>
						</ul>
						<br /><input type="button" name="" id="tianjia" value="添加" />
						<input type="reset" name="" id="chongzhi" value="重置" />
					</form>
				</div>
				<div class="wendapigai">
					<h1>问答题批改</h1>
					<table border="1" cellspacing="0" cellpadding="0">
						<tr id="wendapigai">
							<th>学号</th>
							<th>题目</th>
							<th>操作</th>
						</tr>
					</table>
				</div>
				<!--信息部分-->
				<div class="chafen"  id="chafen2">
					
				</div>
				<div class="geren">
					<h1>个人信息</h1>
					<table border="0" cellspacing="0" cellpadding="20">
						<tr>
							<th>姓名</th>
							<th>职工号</th>
							<th>院系</th>
							<th>科目</th>
						</tr>
						<tr>
							<td name="TeaName"></th>
							<td name="TeaNum"><%Object manageNum = session.getAttribute("manage_num"); %><%=manageNum %></th>
							<td name="department"></th>
							<td name="subject"></td>
						</tr>
					</table>
				</div>
				<div class="gaimi">
					<h1>密码修改</h1>
					<form action="#" method="post" id="changepassword">
						<b>修改密码为：</b><input type="password" name="teacher.password" id="" value="" />
						<input type="button" id="tijiao" value="提交"/>
					</form>
				</div>
				<div class="xuanzetineirong">
					
				</div>
				<div class="tiankongtineirong">
					
				</div>
				<div class="wendatineirong">
					
				</div>
				<div class="wendatipigaineirong">
					
				</div>
			</div>
			<!--主体右边结束-->
		</div>
		<!--主体部分结束-->
		<script src="js/jquery-1.10.2.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="js/teacher.js" type="text/javascript" charset="utf-8"></script>
	</body>
</html>
