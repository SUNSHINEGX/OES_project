<%@ page language="java"  pageEncoding="GBK"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
		<title>新增帐号</title>
		<link href="<s:url value="/css/main.css" />" rel="stylesheet" type="text/css" />
        <script type="text/javascript" src="<s:url value="/js/commCheck.js" />"></script>
		<script type="text/javascript" src="<s:url value="/js/wpCalendar.js" />"></script>
	</head>

	<body>
		<div id="Layer_AddReader">
		  <s:form action="addOperatorAction.action" validate="false"   >
				<table width="488" height="366" border="0" bgcolor="#FFFF99">
					<tr>
						<td colspan="4"><s:fielderror/></td>
					</tr>
					<tr><td colspan="4"><s:actionerror /></td>
					</tr>
					<tr>
						<td colspan="4">
							<div align="center">
								<span class="FORM_STYLE1">帐号信息</span>							</div>						</td>
					</tr>
					<tr>
						<td width="56">帐号:</td>
						<td>
							<s:textfield name="optID" key="optID"   theme="simple" />						</td>
						<td width="110"> &nbsp;&nbsp;管理员:						</td>
						<td><s:radio name="isAdmin" list="#{'1':'是','0':'否'}" key="isAdmin"  theme="simple" ></s:radio>						</td>
					</tr>
					<tr>
					    <td>密码:</td>
						<td>
							<s:password name="password" key="password" theme="simple" />						</td>
					    <td> &nbsp;&nbsp;重输密码:</td>
						<td>
							<s:password name="repPassword" key="repPassword" theme="simple"  />						</td>
					</tr>
					<tr>
						<td colspan="4">
							<div align="center">
								<span class="FORM_STYLE1">个人信息</span>							</div>						</td>
					</tr>
					<tr>
                        <td>姓名:</td>
						<td width="124">
							<div align="center">
								<s:textfield name="userName" key="userName" theme="simple" />
							</div>					  </td>
                      <td>&nbsp;&nbsp;性别:</td>
						<td width="192">
							<p>
								<s:radio name="sex" list="#{'1':'男','0':'女'}" key="sex" theme="simple" ></s:radio>
								<br />
							</p>					  </td>
					</tr>
					<tr>
					   <td>老师:</td>
						<td>
							<div align="center">
								<s:textfield name="teacher" key="teacher" theme="simple" />
							</div>						</td>
					   <td>&nbsp;&nbsp;年级:</td>
						<td>
							<s:textfield name="grade" key="grade" theme="simple" />						</td>
					</tr>
					<tr>
						<td colspan="4"><div align="center">
								<input type="submit" name="Submit" value="保存" /> 
							    <input type="submit" name="Submit2" value="返回" />
							</div></td>
					</tr>
			  </table>
			</s:form>
		</div>
	</body>
</html>
