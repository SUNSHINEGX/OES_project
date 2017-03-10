<%@ page language="java" pageEncoding="GBK"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
		<title>无标题文档</title>
		<link href="<s:url value="/css/main.css" />" rel="stylesheet" type="text/css" />
        <s:bean id="usesort" name="com.online.compare.OptionNoSort"></s:bean>
	</head>

	<s:form action="addStudScoreAction!addStudScore.action"
		validate="false" name="studScoreForm">
		<s:bean name="com.online.domain.Paper" id="paper">
			<s:hidden name="paperID" value="%{paper.paperId}">
			</s:hidden>
			<body>
				<div id="StudScoreLayer1">
					<table width="649" border="1">
						<tr>
							<td bgcolor="#FFFFFF">
								<div align="center">
									<strong> 试卷名称:<s:property value="paper.paperName" />
									</strong>
								</div>
							</td>
						</tr>
						<s:iterator value="paperdetail" id="iterOptions"  status="st">
							<tr>
								<td bgcolor="#FFCC33">
								    <s:property value="#st.count"/>
									.
									<s:property value="#iterOptions.question.mainContent" />
								</td>
							</tr>
							<s:sort comparator="#usesort" source="#iterOptions.question.questiondetails">
								<s:iterator id="iterOptions2">
									<tr>
										<td>
											<input type="checkbox"
												name="paper_chooses_<s:property value="#iterOptions.paperDetailId" />"
												value="<s:property value="#iterOptions2.optionNo" />" />
											<s:property value="#iterOptions2.optionNo" />
											.
											<s:property value="#iterOptions2.optionContent" />
										</td>
									</tr>
								</s:iterator>
							</s:sort>
						</s:iterator>

						<tr>
							<td>
								<div align="center">
									<input type="submit" name="Submit" value="交卷" />
								</div>
							</td>
						</tr>
					</table>
				</div>
			</body>
		</s:bean>
	</s:form>
</html>
