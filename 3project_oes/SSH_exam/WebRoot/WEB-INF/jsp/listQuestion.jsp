<%@ page language="java" contentType="text/html;charset=UTF-8"
	errorPage="exception.jsp"%>
<%@include file="taglibs.jsp"%>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
		<title>欢迎光临科帮网在线考试系统</title>
		<link href="images/Style.css" rel="stylesheet" type="text/css">
		<script type="text/javascript" src="js/tree.js"></script>
	</head>

	<body>
		<div align="left">
			<table width="778" height="499" border="0" align="center"
				cellpadding="0" cellspacing="0" bgcolor="#FFFFFF"
				style="border: 2px solid #008000; padding: 0px">
				<tr>
					<td height="167" align="justify" valign="baseline"
						style="border-bottom: 2px solid #008000; padding: 0px" colspan="2">
						<img border="0" src="images/2.jpg" width="778" height="167">
					</td>
				</tr>
				<tr>
					<td height="320" align="left" valign="top" width="153">
						<jsp:include page="left.html" />
					</td>
					<td height="320" align="left" valign="top"
						style="border-bottom: 1px solid #808080; border-right: 1px solid #808080; border-right: 1px solid #808080; padding: 0; border-left-style: solid; border-left-width: 1px;"
						width="625">
						<TABLE class=Xsmall cellspacing=1 cellpadding=2 width="623"
							align="center" bgcolor="#d2ebff" border=0>
							<TBODY>
								<TR bgcolor="#ffffff">
									<TD colspan="4" height=28>
										<TABLE cellspacing=0 cellpadding=0 width="100%" border=0>
											<TBODY>
												<TR>
													<TD class=Xsmall background="images/backt.gif" height=25>
														<STRONG>试题浏览:</STRONG>
													</TD>
												</TR>
											</TBODY>
										</TABLE>
									</TD>
								</TR>
								<TR bgcolor="#ffffff">
									<TD colspan="4" height=30>
										<DIV align="center">
											<font color="#0000ff">全部试题信息</font>
										</DIV>
									</TD>
								</TR>
								<TR bgcolor="#ffffff">
									<TD width=407 height=25>
										<DIV align="center">
											题目
										</DIV>
									</TD>
									<TD width=51 align="center">
										分数
									</TD>
									<TD width=105>
										<DIV align="center">
											类型
										</DIV>
									</TD>
									<TD width=39>
										<DIV align="center">
											删除否
										</DIV>
									</TD>
								</TR>
								<logic:iterate id="question" name="questionList"
									type="org.matrix.pojo.Question" scope="request">
									<TR bgcolor="#ffffff">
										<TD height=25>
											<bean:write name="question" property="quTitle" />
										</TD>
										<TD>
											<DIV align="center">
												<bean:write name="question" property="quScore" />
											</DIV>
										</TD>
										<TD>
											<DIV align="center">
												<bean:write name="question" property="quType" />
											</DIV>
										</TD>
										<TD>
											<DIV align="center">
												<html:link action="delQuestion.do" paramName="question"
													paramProperty="id" paramId="questionId"
													onclick="return confirm('确认删除？');">
                                                                           删除</html:link>
											</DIV>
										</TD>
									</TR>
								</logic:iterate>
								<TR bgcolor="#ffffff">
									<TD colspan="4" height=30>
										<DIV align="center">
											第 ${requestScope.currentPage }页&nbsp; 共
											${requestScope.pageCount }页&nbsp;
											<a href="listQuestion.do?pageNo=1">首页</a>
											<logic:greaterThan name="currentPage" scope="request"
												value="1">
												<a
													href="listQuestion.do?pageNo=${requestScope.currentPage-1 }">
											上一页</a>
											</logic:greaterThan>

											<logic:lessThan name="currentPage" scope="request"
												value="${requestScope.pageCount }">
												<a
													href="listQuestion.do?pageNo=${requestScope.currentPage+1 }">
											下一页</a>
											</logic:lessThan>
											<a href="listQuestion.do?pageNo= ${requestScope.pageCount }">尾页</a>
										</DIV>
									</TD>
								</TR>
							</TBODY>
						</TABLE>
					</td>
				</tr>
			</table>
			<%@include file="footer.jsp"%>
		</div>
	</body>
</html>
