<%@ page language="java"  pageEncoding="GBK"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
		<title>读者信息添加</title>
		<link href="<s:url value="/css/main.css" />" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="<s:url value="/js/commCheck.js" />" ></script>
		<script type="text/javascript" src="<s:url value="/js/wpCalendar.js" />"></script>
	</head>

	<body>
		<div id="TipLayer1">
			按住Ctrl键可进行多选
		</div>
		<div id="Layer_AddReader">
		    <s:fielderror></s:fielderror>
			<s:form action="addQuestionAction.action"  >
				<table width="549" height="276" border="0" bgcolor="#FFFF99">
					<tr>
						<td width="44" height="60" rowspan="2">
							&nbsp;题干
						</td>
						<td width="263" rowspan="2">
							<s:textarea name="mainContent" key="mainContent" cols="35" rows="5" theme="simple" />
						</td>
						<td height="18">
							难易度
						</td>
						<td>
							<s:select name="easyLevel" key="easyLevel"
								list="#{'01':'容易', '02':'一般','03':'较难','04':'难'}" theme="simple">
							</s:select>
						</td>
						<td width="49" rowspan="2">
							答案
						</td>
						<td width="52" rowspan="2">
							<label></label>
							<label>
							<s:select name="answer"  key="answer" multiple="true" onmouseover="showTip()" onmouseout="hideTip()"
								list="#{'A':'A','B':'B','C':'C','D':'D'}" theme="simple">
							</s:select>
							</label>
						</td>
					</tr>
					<tr>
						<td>
							分值
						</td>
						<td>
						    <s:textfield name="score" key="score" size="6" theme="simple" ></s:textfield>
						</td>
					</tr>
					<tr>
						<td rowspan="4">
							<p>
								&nbsp;
							</p>
						</td>
						<td height="33" colspan="5">
							选项A：
							<s:textfield name="optionA" key="optionA" size="50" theme="simple" />
						</td>
					</tr>
					<tr>
						<td colspan="5">
							选项B：
							<s:textfield name="optionB" key="optionB" size="50" theme="simple" />
						</td>
					</tr>
					<tr>
						<td colspan="5">
							选项C：
							<s:textfield name="optionC"  key="optionC"  size="50" theme="simple" />
						</td>
					</tr>
					<tr>
						<td height="29" colspan="5">
							选项D：
							<s:textfield name="optionD" key="optionD" size="50" theme="simple" />
						</td>
					</tr>
					<tr>
						<td height="15">
							&nbsp;
						</td>
						<td colspan="3">
							&nbsp;
						</td>
						<td>
							&nbsp;
						</td>
						<td>
							&nbsp;
						</td>
					</tr>

					<tr>
						<td>
							<div align="left"></div>
						</td>
						<td colspan="3">
							<div align="center">
								<input type="submit" name="Submit" value="保存" />
								&nbsp;&nbsp;&nbsp;&nbsp;
								<input type="submit" name="Submit2" value="返回" />
							</div>
						</td>
						<td>
							<div align="left"></div>
						</td>

						<td>
							&nbsp;
						</td>
					</tr>
				</table>
			</s:form>
		</div>
	</body>

	<script type="text/javascript">
     var tip = document.getElementById("TipLayer1"); 
     tip.style.visibility = "hidden";
     function showTip()
        {
         var tip = document.getElementById("TipLayer1"); 
         tip.style.visibility = "visible";
        }
        
     function hideTip()
        {
         var tip = document.getElementById("TipLayer1");         
         tip.style.visibility = "hidden";
        }
</script>

</html>
