<%@page import="javax.websocket.Session,java.util.*,com.cool.john.bean.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="/struts-tags"  prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>在线考试</title>
<link rel="stylesheet" type="text/css" href="css/exam.css"/>
</head>
<body>
	<div class="box clearfix">
			<div class="left clearfix">
				<header class="clearfix">
				<%
				int ec_size= (Integer)session.getAttribute("ec_size");
				int hc_size= (Integer)session.getAttribute("hc_size");
				int et_size= (Integer)session.getAttribute("et_size");
				int ht_size= (Integer)session.getAttribute("ht_size");
				List ca=(List)session.getAttribute("choice_anwser");
				List ta=(List)session.getAttribute("tiankong_anwser");
				%>
				<ul id="choice_anwser">
				<%
				for(int i=0; i<ca.size(); i++){
				%>
					<li><%=ca.get(i) %></li>
				<%
				}
				%>
				</ul>
				<ul id="tiankong_anwser">
				<%
				for(int i=0; i<ta.size(); i++){
				%>
					<li><%=ta.get(i) %></li>
				<%
				}
				%>
				</ul>
					<dl class="clearfix">
						<dt>在线考试系统<s:property value="#choice_anwser" /></dt>
						<dd>考生姓名：<span id="StuName"><s:property value="#StuName" /></span></dd>
						<dd>考生学号：<span id="StuNum"><s:property value="#StuNum" /></span></dd>
						<dd>考生班级：<span id="classNum"><s:property value="#classNum" /></span></dd>
						<dd>考试科目：<span id="subject"><s:property value="#subject" /></span></dd>
					</dl>
					<p>考试时间:<span id="exam_time"><s:property value="#time" /></span>分钟 试卷总分:<span><s:property value="#exam_score" /></span>分</p>
				</header>
				<!-- -----------------------------------------选择题-->
				<div class="top clearfix">
					<p>
						<span class="top_span_1">一、选择题</span>
						<span class="top_span_2">(每小题<span id="sel_littlescore"><s:property value="#sel_littlescore" /></span>分，共<s:property value="#sel_score" />分)下列各题A、B、C、D四个选项中只有一个是正确的。</span>
					</p>
				</div>
				<div class="clearfix">
				<%
					int a=0;
					for(a=0; a<ec_size; a++){
						Choice ec=(Choice)session.getAttribute("ec"+a);
				%>
						<section class="xz_section clearfix">
							<fieldset class="clearfix">
							    <legend>第<%=a+1 %>题</legend>
							   	<dl class="clearfix">
							   		<dt><%=ec.getSelTop() %></dt>
							   		<dd>A、<%=ec.getA()%></dd>
							   		<dd>B、<%=ec.getB() %></dd>
							   		<dd>C、<%=ec.getC() %></dd>
							   		<dd>D、<%=ec.getD() %></dd>
							   	</dl>
							   	<div class="clearfix">
							   		<span>【选择答案】</span>
							   		<input class="selanswer" type="radio" name="x<%=a+1 %>" id="" value="A" />
							   		<label for="x<%=a+1 %>">A</label>
							   		<input class="selanswer" type="radio" name="x<%=a+1 %>" id="" value="B" />
							   		<label for="x<%=a+1 %>">B</label>
							   		<input class="selanswer" type="radio" name="x<%=a+1 %>" id="" value="C" />
							   		<label for="x<%=a+1 %>">C</label>
							   		<input class="selanswer" type="radio" name="x<%=a+1 %>" id="" value="D" />
							   		<label for="x<%=a+1 %>">D</label>
							   	</div>
							   	<i class="sel"></i>
							 </fieldset>
						</section>
				<%
					}
					for(int b=0;b<hc_size; b++){
						Choice hc=(Choice)session.getAttribute("hc"+b);
				%>
						<section class="xz_section clearfix">
							<fieldset class="clearfix">
							    <legend>第<%=b+a+1 %>题</legend>
							   	<dl class="clearfix">
							   		<dt><%=hc.getSelTop() %></dt>
							   		<dd>A、<%=hc.getA()%></dd>
							   		<dd>B、<%=hc.getB() %></dd>
							   		<dd>C、<%=hc.getC() %></dd>
							   		<dd>D、<%=hc.getD() %></dd>
							   	</dl>
							   	<div class="clearfix">
							   		<span>【选择答案】</span>
							   		<input class="selanswer" type="radio" name="x<%=b+a+1 %>" id="" value="A" />
							   		<label for="x<%=b+a+1 %>">A</label>
							   		<input class="selanswer" type="radio" name="x<%=b+a+1 %>" id="" value="B" />
							   		<label for="x<%=b+a+1 %>">B</label>
							   		<input class="selanswer" type="radio" name="x<%=b+a+1 %>" id="" value="C" />
							   		<label for="x<%=b+a+1 %>">C</label>
							   		<input class="selanswer" type="radio" name="x<%=b+a+1 %>" id="" value="D" />
							   		<label for="x<%=b+a+1 %>">D</label>
							   	</div>
							   	<i class="sel"></i>
							 </fieldset>
						</section>
				<%
					}
				%>
				</div>
				<!-- -----------------------------------------填空题-->
				<div class="top clearfix">
					<p>
						<span class="top_span_1">一、填空题</span>
						<span class="top_span_2">(每小题<span id="fill_littlescore"><s:property value="#fill_littlescore" /></span>分，共<s:property value="#fill_score" />分)请在答案框中作答。</span>
					</p>
				</div>
				<div class="clearfix">
				<%
					int c=0;
					for(c=0;c<et_size; c++){
						Tiankong et=(Tiankong)session.getAttribute("et"+c);
				%>
					<section class="tk_section clearfix">
						<fieldset class="clearfix">
						    <legend>第<%=c+1%>题</legend>
						   	<p>
						   		<%=et.getFillTop()%>
						   	</p>
						   	<div class="tk">
						   		<input class="fillanswer" type="text" id="" value="" placeholder="请在此输入答案"/>
						   	</div>
						   	<i class="fill"></i>
						 </fieldset>
					</section>
					<%
						}
						for(int d=0;d<ht_size; d++){
							Tiankong ht=(Tiankong)session.getAttribute("ht"+d);
					%>
						<section class="tk_section clearfix">
							<fieldset class="clearfix">
							    <legend>第<%=c+d+1 %>题</legend>
							   	<p>
							   		<%=ht.getFillTop() %>
							   	</p>
							   	<div class="tk">
							   		<input class="fillanswer" type="text" id="" value="" placeholder="请在此输入答案"/>
							   	</div>
							   	<i class="fill"></i>
							 </fieldset>
						</section>
					<%
						}
					%>
				</div>
				<!-- -----------------------------------------问答题-->
				<div class="top clearfix">
					<p>
						<span class="top_span_1">一、问答题</span>
						<span class="top_span_2">(每小题<s:property value="#qa_littlescore" />分，共<s:property value="#qa_score" />分)请在答案框中作答。</span>
					</p>
				</div>
				<div class="clearfix">
				<%
					int e=0;
					int ew_size= (Integer)session.getAttribute("ew_size");
					for(e=0;e<ew_size; e++){
						Wenda ew=(Wenda)session.getAttribute("ew"+e);
				%>
					<section class="wd_section clearfix">
						<fieldset class="clearfix">
						    <legend>第<%=e+1 %>题</legend>
						   	<p class="qatop"><%=ew.getQaTop() %></p>
						   	<div class="wd">
						   		<textarea class="qaanswer"  rows="15" cols="100" placeholder="请在此输入答案"></textarea>
						   	</div>
						 </fieldset>
					</section>
				<% 
					}
					int hw_size= (Integer)session.getAttribute("hw_size");
					for(int f=0;f<hw_size; f++){
						Wenda hw=(Wenda)session.getAttribute("hw"+f);
				%>
					<section class="wd_section clearfix">
						<fieldset class="clearfix">
						    <legend>第<%=e+f+1 %>题</legend>
						   	<p class="qatop"><%=hw.getQaTop() %></p>
						   	<div class="wd">
						   		<textarea class="qaanswer"  rows="15" cols="100" placeholder="请在此输入答案"></textarea>
						   	</div>
						 </fieldset>
					</section>
				<%
					}
				%>
				</div>	
			</div>
			<div class="right">
				<div class="right_box clearfix">
					<p class="top">
						<img src="img/Top.jpg" alt="" />
						题目快速预览
					</p>
					<div class="right_xz right_tm clearfix">
						<p>选择题</p>
						<ul class="clearfix">
							
						</ul>
					</div>
					<div class="right_tk right_tm clearfix">
						<p>填空题</p>
						<ul class="clearfix">
							
						</ul>
					</div>
					<div class="right_wd right_tm clearfix">
						<p>问答题</p>
						<ul class="clearfix">
							
						</ul>
					</div>
					<div class="exp clearfix">
						<i></i>
						<span>未做答</span>
						<i></i>
						<span>已做答</span>
					</div>
					<div class="time clearfix">
						<h1>答题剩余时间:</h1>
						<span id="time">00小时00分00秒</span>
					</div>
					<div class="qua clearfix">
						<h2>
							<i>共</i>
							<span id="tinum"></span>
							<i>题，已做答</i>
							<span id="tinum_yes"></span>
							<i>未做答</i>
							<span id="tinum_no"></span>
						</h2>
					</div>
					<div class="butt clearfix">
						<button id="submit">提交试卷</button>
					</div>
				</div>
			</div>
		</div>
		
		<!-- -----------------------------------------提示框-->
		<div class="bg"></div><!--提示框背景-->
		<div class="tips">
			<div class="tips_box clearfix">
				<h1>温馨提示</h1>
				<h2>&nbsp;&nbsp;亲爱的同学，您的答题时间剩余不足五分钟，请及时检查并提交试卷，以免影响您的成绩</h2>
				<button id="know">我知道了</button>
				<button id="submit_tips">提交试卷</button>
			</div>
		</div>
		<div class="affirm">
			<div class="affirm_box clearfix">
				<h1>温馨提示</h1>
				<h2>&nbsp;&nbsp;亲爱的同学，是否确认提交试卷</h2>
				<button id="cancel">取消提交</button>
				<button id="submit_confrim">确认提交</button>
			</div>
		</div>
		<div id="back">
			点
			击
			退
			出
		</div>
		<script src="js/jquery-1.10.2.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="js/exam.js" type="text/javascript" charset="utf-8"></script>
		<script src="js/uploadExam.js" type="text/javascript" charset="utf-8"></script>
</body>
</html>