<%@ page language="java"  pageEncoding="GBK"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
		<title>�����ʺ�</title>
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
								<span class="FORM_STYLE1">�ʺ���Ϣ</span>							</div>						</td>
					</tr>
					<tr>
						<td width="56">�ʺ�:</td>
						<td>
							<s:textfield name="optID" key="optID"   theme="simple" />						</td>
						<td width="110"> &nbsp;&nbsp;����Ա:						</td>
						<td><s:radio name="isAdmin" list="#{'1':'��','0':'��'}" key="isAdmin"  theme="simple" ></s:radio>						</td>
					</tr>
					<tr>
					    <td>����:</td>
						<td>
							<s:password name="password" key="password" theme="simple" />						</td>
					    <td> &nbsp;&nbsp;��������:</td>
						<td>
							<s:password name="repPassword" key="repPassword" theme="simple"  />						</td>
					</tr>
					<tr>
						<td colspan="4">
							<div align="center">
								<span class="FORM_STYLE1">������Ϣ</span>							</div>						</td>
					</tr>
					<tr>
                        <td>����:</td>
						<td width="124">
							<div align="center">
								<s:textfield name="userName" key="userName" theme="simple" />
							</div>					  </td>
                      <td>&nbsp;&nbsp;�Ա�:</td>
						<td width="192">
							<p>
								<s:radio name="sex" list="#{'1':'��','0':'Ů'}" key="sex" theme="simple" ></s:radio>
								<br />
							</p>					  </td>
					</tr>
					<tr>
					   <td>��ʦ:</td>
						<td>
							<div align="center">
								<s:textfield name="teacher" key="teacher" theme="simple" />
							</div>						</td>
					   <td>&nbsp;&nbsp;�꼶:</td>
						<td>
							<s:textfield name="grade" key="grade" theme="simple" />						</td>
					</tr>
					<tr>
						<td colspan="4"><div align="center">
								<input type="submit" name="Submit" value="����" /> 
							    <input type="submit" name="Submit2" value="����" />
							</div></td>
					</tr>
			  </table>
			</s:form>
		</div>
	</body>
</html>
