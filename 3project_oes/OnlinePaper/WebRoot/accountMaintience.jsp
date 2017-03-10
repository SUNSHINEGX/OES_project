<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" pageEncoding="GBK"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="display" uri="/WEB-INF/displaytag-11.tld"%>

<html xmlns="http://www.w3.org/1999/xhtml">

	<head>
		<script type="text/javascript">
		var baseText = null; 
		var req;
		function showPopup(w,h,uniqid){ 
          var popUp = document.getElementById("popupcontent"); 
          popUp.style.background="#0066FF";

          //popUp.style.top = "295px"; 
          //popUp.style.left = "40px"; 
          popUp.style.top = event.x; 
          popUp.style.left = event.y; 

          popUp.style.width = w + "px"; 
          popUp.style.height = h + "px"; 
                
          //popUp.innerHTML="�ʻ�����ϸ��Ϣ2";
          //*****call ajax****************//
          req=new ActiveXObject("Microsoft.XMLHttp");
          req.open("get","<s:url value="/displayStudentInfoAction.action?stdID=" />"+uniqid);  

		  req.onreadystatechange=handleRequest;
		  req.send(null);
          popUp.style.visibility = "visible";
              popUp.style.zIndex =5;
      }

		function handleRequest(){
			var checkResult=document.getElementById("popupcontent");
			if(req.readyState==4){
				if(req.status==200){
					checkResult.innerHTML=req.responseText;
				}	
				else{
					alert("An error occurred:"+req.statusText);
				}
			}
		}
      
     function hidePopup(){
       var popUp = document.getElementById("popupcontent");
          popUp.style.visibility = "hidden";
       }      
     function  deleteConfirm(param)
     { 
       if(confirm("��ȷ��Ҫɾ��������¼��?"))
        {
          location.href="<s:url value="/deleteOperatorAction.action?optID=" />"+param;
         }
       }

   function  addAccount()
      {
      location.href="<s:url  value="/addAccount.jsp" />" ;
      }
 </script>
		<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
		<title>�������߿���ϵͳ</title>
		<link href="<s:url value="/css/main.css" />" rel="stylesheet"
			type="text/css" />
		<link href="<s:url value="/css/screen.css" />" rel="stylesheet"
			type="text/css" />
		<link href="<s:url value="/css/maven-base.css" />" rel="stylesheet"
			type="text/css" />
		<link href="<s:url value="/css/maven-theme.css" />" rel="stylesheet"
			type="text/css" />
		<link href="<s:url  value="/css/site.css" />" rel="stylesheet"
			type="text/css" />
		<link href="<s:url value="/css/print.css" />" rel="stylesheet"
			type="text/css" />
	</head>
	<body>
		<div id="MTLayer1">
		    <!-- ��display��ǩ�����ý���struts2��ǩ�еĶ�������������s:set����������� -->
			<s:set name="studentinfoList2" value="studentinfoList"	scope="request" />
			<display:table name="studentinfoList2" id="row" pagesize="5"
				requestURI="" export="true">
				<display:column title="�ʺ�">
					<a href="javascript:showPopup(200,100,${row.stdId})"
						onmouseover="javascript:showPopup(200,100,${row.stdId})"
                         onmouseout="javascript:hidePopup()"><c:out
							value="${row.operator.optId}" /> </a>
				</display:column>
				<display:column property="name" title="����" sortable="true" />
				<display:column title="�Ƿ����Ա" sortable="true">
					<c:if test="${row.operator.isAdmin== 1}">��</c:if>
					<c:if test="${row.operator.isAdmin== 0}">��</c:if>
				</display:column>

				<display:column title="�Ա�" sortable="true">
					<c:if test="${row.sex== 1}">��</c:if>
					<c:if test="${row.sex== 0}">Ů</c:if>
				</display:column>
				<display:column property="grade" title="�꼶" sortable="true" />
				<display:column property="teacher" title="������" sortable="true" />
				<display:column title="����">
					<a href="x">�޸�</a>||<a
						href="javascript:deleteConfirm('${row.operator.optId}')">ɾ��</a>
				</display:column>
				<display:setProperty name="export.pdf" value="true" />
				<display:setProperty name="export.csv" value="true" />
				<display:setProperty name="export.xls" value="true" />
				<display:setProperty name="export.xml" value="true" />
				<display:setProperty name="sort.amount" value="list" />
				<display:setProperty name="paging.banner.placement" value="bottom" />
				<display:footer>(��ʾ:�������'�ʻ�'���Ӵ���ֱ�Ӳ鿴��ϸ��Ϣ)</display:footer>
			</display:table>
		</div>
		<div id="MTLayer4">
			<form id="form1" name="form1" method="post" action="#">
				<table width="95%" border="0">
					<tr>
						<td width="88">
							����
						</td>
						<td width="125">
							<label>
								<input type="text" name="Sname" size=15 />
							</label>
						</td>
						<td width="88">
							�ʺ�
						</td>
						<td width="160">
							<input type="text" name="Sisbn" size=15 />
						</td>
						<td width="479">
								<div align="right">
									<input type="submit" name="Submit3" value="��ѯ" />
									||
									<input type="button" name="button_addAccount"
										onclick="javascript:addAccount()" value="�����ʺ�" />
								</div>
						</td>
					</tr>
				</table>
			</form>
		</div>
		<div id="popupcontent">
			�ʻ�����ϸ��Ϣ
		</div>

		<script type="text/javascript">
  		    hidePopup();
        </script>
	</body>
</html>