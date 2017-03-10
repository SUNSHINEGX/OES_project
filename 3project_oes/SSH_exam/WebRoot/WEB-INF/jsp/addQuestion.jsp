<%@ page language="java" contentType="text/html;charset=UTF-8" errorPage="exception.jsp"%>
<%@ include file="taglibs.jsp"%>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
		<title>欢迎光临科帮网在线考试系统</title>
		<link href="images/Style.css" rel="stylesheet" type="text/css">
		<script language="javascript">
    function check(){
     //判断是否填写题目
      if(document.addQuestionForm.title.value==""){
        alert("题目不能为空");
        document.addQuestionForm.title.focus();
        return false;
      }
     //判断是否填写选项
     if(document.addQuestionForm.choices.value==""){
        alert("选项不能为空");
        document.addQuestionForm.choices.focus();
        return false;
     }
     //判断是否填写答案
     if(document.addQuestionForm.standardAnswer.value==""){
        alert("答案不能为空");
        document.addQuestionForm.standardAnswer.focus();
        return false;
     }
    }
 </script>
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
					<td height="320" align="left" valign="top" width="155">
						<jsp:include page="left.html" /></td>
					<td height="320" align="center" valign="top"
						style="border-bottom: 1px solid #808080; border-right: 1px solid #808080; padding: 0; border-left-style: solid; border-left-width: 1px;"
						width="623">
						<TABLE class=Xsmall cellspacing=1 cellpadding=2 width="621"
							align="center" bgcolor="#d2ebff" border=0 id="table1">
							<TBODY>
								<TR>
									<TD vAlign="top" bgColor="#ffffff">
										<TABLE cellSpacing="0" cellPadding=0 width="100%" border=0
											id="table2">
											<TBODY>
												<TR>
													<TD class=Xsmall background="images/backt.gif" height=25>
														<STRONG>添加试题</STRONG>
													</TD>
												</TR>
											</TBODY>
										</TABLE>
									</TD>
								</TR>
								<TR>
									<TD vAlign="top" bgColor="#ffffff">
										<FORM name="addQuestionForm" action="processAddQuestion.do"
											method="post" onSubmit="return check();">
											<TABLE class=Xsmall cellSpacing=0 cellPadding=0 width=615
												align="center" border=0 id="table3">
												<TBODY>
													<TR>
														<TD colSpan=6 height=30>
															<DIV align="center"></DIV>
														</TD>
													</TR>
													<TR>
														<TD height="25" width="86" align="center">
															<DIV align="center">
																&nbsp;题目：
															</DIV>
														</TD>
														<TD colSpan=5>
															<INPUT class=Sborder id="title" size=58 name="title">
														</TD>
													</TR>
													<TR>
														<TD width=86 align="center">
															&nbsp;科&nbsp;目:
														</TD>
														<TD width=113>
															&nbsp;
															<SELECT id="examType" name="examType">
																<logic:present name="typeList" scope="request">
																	<logic:iterate id="examType" name="typeList"
																		type="org.matrix.pojo.ExamType" scope="request">
																		<OPTION
																			value='<bean:write name="examType" property="id"/>'>
																			<bean:write name="examType" property="examName" />
																		</OPTION>
																	</logic:iterate>
																</logic:present>
															</SELECT>
														</TD>
														<TD width="75" align="center">
															分&nbsp;数:
														</TD>
														<TD width="202" align="left">
															<SELECT id="score" name="score">
																<OPTION value="1">
																	1
																</OPTION>
																<OPTION value="2">
																	2
																</OPTION>
																<OPTION value="3">
																	3
																</OPTION>
																<OPTION value="4">
																	4
																</OPTION>
																<OPTION value="5">
																	5
																</OPTION>
																<OPTION value="6">
																	6
																</OPTION>
																<OPTION value="7">
																	7
																</OPTION>
																<OPTION value="8">
																	8
																</OPTION>
																<OPTION value="9">
																	9
																</OPTION>
																<OPTION value="10">
																	10
																</OPTION>
															</SELECT>
														</TD>
														<TD width=53 align="left"></TD>
														<TD width=173></TD>
													</TR>
													<TR>
														<TD height=25 width="86" align="center">
															<DIV align="center">
																&nbsp;难度:
															</DIV>
														</TD>
														<TD width="113">
															<SELECT id="level" name="level">
																<OPTION value="简单" selected>
																	简单
																</OPTION>
																<OPTION value="中等">
																	中等
																</OPTION>
																<OPTION value="较难">
																	较难
																</OPTION>
															</SELECT>
														</TD>
														<TD width="75" align="center">
															类型:
														</TD>
														<TD width="202" align="left">
															<SELECT id="note" name="note">
																<OPTION value="单选题" selected>
																	单选题
																</OPTION>
																<OPTION value="多选题" selected>
																	多选题
																</OPTION>
															</SELECT>
														</TD>
														<TD width=53 align="left"></TD>
														<TD width=173>
															&nbsp;
														</TD>
													</TR>
													<TR>
														<TD height=25 width="86" align="center">
															<DIV align="center">
																&nbsp;选&nbsp;&nbsp;项
															</DIV>
														</TD>
														<TD colspan="5">
															<INPUT class=Sborder id="choices" size=37 name="choices">
															<font size="2">(<font color="ff0000">注意</font>:选项用":"分开，如选项1：选项2)</font>
														</TD>
													</TR>
													<TR>
														<TD height=25 width="86" align="center">
															<DIV align="center">
																&nbsp;答案:
															</DIV>
														</TD>
														<TD colspan="5">
															<INPUT class=Sborder id="standardAnswer" size=37
																name="standardAnswer">
															<font size="2">(<FONT color="#ff0000">注意</FONT>:多选题用":"分开，如1:2:2:3)</font>
														</TD>
													</TR>
													<TR>
														<TD colspan="6" height=30>
															<DIV align="center">
																<TABLE class=Xsmall cellspacing=0 cellpadding=0
																	width="49%" border=0 id="table4">
																	<TBODY>
																		<TR>
																			<TD>
																				<DIV align="center">
																					<input class=Sborder type="submit" value="确定"
																						name="submit">
																				</DIV>
																			</TD>
																			<TD>
																				<DIV align="center">
																					<input class=Sborder type="reset" value="重写"
																						name="reset">
																				</DIV>
																			</TD>
																		</TR>
																	</TBODY>
																</TABLE>
															</DIV>
														</TD>
													</TR>
												</TBODY>
											</TABLE>
										</FORM>
									</TD>
								</TR>
							</TBODY>
						</TABLE>
					<td>
				</tr>
			</table>
			<%@ include file="footer.jsp"%>
		</div>
	</body>
</html>
