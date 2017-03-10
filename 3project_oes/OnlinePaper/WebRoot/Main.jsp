<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core"%>
<%@taglib prefix="s" uri="/struts-tags"%>


<html xmlns="http://www.w3.org/1999/xhtml">
<s:set name="currUser" value="#sessionScope.currentUser" />

<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>网上在线考试系统</title>

<link href="<s:url value="/css/main.css" />" rel="stylesheet"
	type="text/css" />
<link rel="StyleSheet" href="<s:url value="/css/dtree.css" />"
	type="text/css" />
<script type="text/javascript" src="<s:url value="/js/dtree.js" />">
</script>
</head>

<body scroll="no">
<div id="Layer1">
<div align="center" class="STYLE1">
<img src="<s:url value="/img/borrow_if.gif" />" width="863" height="73" />
<div id="Layer5">
<img src="<s:url value="/img/book.jpg" />" width="139" height="60" />
</div>
<div id="Layer4">
网上在线考试系统
</div>
</div>
</div>
<div id="currentUser">
<c:forEach var="item" items="${sessionScope.currentUser.studentinfos}">
		           ${item.name}
		   </c:forEach>
<span>，欢迎光临!</span>
</div>
<div id="Layer2">
<!--	<p><a href="javascript: d.openAll();">openAll</a>|<a href="javascript: d.closeAll();">closeAll</a></p>-->
<script type="text/javascript">
webRoot = "<%=request.getContextPath()%>";<c:if test="${sessionScope.currentUser.isAdmin==0}">
		f = new dTree('f');
        f.add(0,-1,'考生自助管理');
		//f.add(1,0,'','example01.html');
		f.add(2,0,'参加考试','listPaperForScoreAction.action','','iframe_a');
		f.add(3,0,'历史考试浏览','listStudScoreAction.action','','iframe_a');
		f.add(4,0,'错题浏览','unknown.html','','iframe_a');
		f.add(5,0,'退出','login.jsp');
		document.write(f);
		</c:if>
       <c:if test="${sessionScope.currentUser.isAdmin==1}">
		d = new dTree('d');
        d.add(0,-1,'题库后台管理');
		//d.add(1,0,'读者信息管理','example01.html');
		d.add(2,0,'题库管理','listQuestionAction.action','','iframe_a');
//		d.add(2,0,'题库管理','/questionMaintience.jsp','','iframe_a');
		d.add(3,0,'试卷管理','listPaperAction.action','','iframe_a');
		d.add(4,0,'成绩统计分析','unknown.html','','iframe_a');

		//d.add(4,0,'图书类别管理','example01.html');
		//d.add(5,4,'图书类型添加','test.html','','iframe_a');
		//d.add(6,4,'图书类型修改','example01.html','','iframe_a');

		e = new dTree('e');
        e.add(0,-1,'系统维护');
		e.add(1,0,'帐号维护','listOperatorAction.action','','iframe_a');
		e.add(2,0,'参数设置','unknown.html','','iframe_a');
		e.add(3,0,'退出','login.jsp');
		document.write(d);
		document.write(e);
      </c:if>
	</script>
<div id="Layer3">

<c:if test="${sessionScope.currentUser.isAdmin==0}">
	<iframe src="<s:url value="/listPaperForScoreAction.action" />"
		name="iframe_a" frameborder=0 scrolling="auto" width="780"
		height="410">
	<p>
	Your browser does not support iframes2222.
	</p>
	</iframe>
</c:if>
<c:if test="${sessionScope.currentUser.isAdmin==1}">
	<iframe src="<s:url value="/listQuestionAction.action" />"
		name="iframe_a" frameborder=0 scrolling="auto" width="780"
		height="410">
	<p>
	Your browser does not support iframes2222.
	</p>
	</iframe>
</c:if>

</div>
<div id="Layer6">
<div align="center" class="STYLE2">
安博教育广州基地版权所有 2011-06-10
</div>
</div>
</body>
</html>
