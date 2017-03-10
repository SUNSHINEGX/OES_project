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
          
          //popUp.style.top = "255px"; 
          //popUp.style.left = "40px"; 
          popUp.style.top =event.x; 
          popUp.style.left =event.y; 
          popUp.style.zIndex =5;
          popUp.style.width = w + "px"; 
          popUp.style.height = h + "px"; 
          //popUp.innerHTML="�ʻ�����ϸ��Ϣ";
          //*****call ajax****************//
          req=new ActiveXObject("Microsoft.XMLHttp");
          req.open("get","<s:url value="/displayPaperAction.action?paperId=" />"+uniqid);  
		  req.onreadystatechange=handleRequest;
		  req.send(null);
          popUp.style.visibility = "visible";
      }

		function handleRequest(){
			var checkResult=document.getElementById("popupcontent");
			if(req.readyState==4){
				if(req.status==200){
					checkResult.innerHTML=req.responseText;
				}	
				else{
				    alert(" req.status = " + req.status);
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
          location.href="<s:url value="/deletePaperAction.action?paperId=" />"+param;
         }
       }

   function  addPaper()
      {
      location.href="<s:url value="/addPaper.jsp" />";
      }
      
 </script>
		<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
		<title>�������߿���ϵͳ</title>
		<link href="<s:url value="/css/main.css" />" rel="stylesheet" type="text/css" />
		<link href="<s:url value="/css/screen.css" />" rel="stylesheet" type="text/css" />
		<link href="<s:url value="/css/maven-base.css" />" rel="stylesheet"
			type="text/css" />
		<link href="<s:url value="/css/maven-theme.css" />"  rel="stylesheet"
			type="text/css" />
		<link href="<s:url value="/css/site.css" />" rel="stylesheet" type="text/css" />
		<link href="<s:url value="/css/print.css" />" rel="stylesheet" type="text/css" />
	</head>
	<body>
		<div id="MTLayer1">&nbsp; 
            <s:set name="paperList2" value="paperList" scope="request"/>					
			<display:table name="paperList2" id="row" pagesize="5"
				requestURI="" export="true">
				<display:column title="�Ծ��">
					<a href="javascript:showPopup(200,150,${row.paperId})"
						onmouseover="javascript:showPopup(500,350,${row.paperId})"
						onmouseout="javascript:hidePopup()"><c:out
							value="${row.paperId}" /> </a> 
				</display:column>
				<display:column property="paperName" title="�Ծ�����" sortable="true" />
				<display:column property="byUser" title="������" />
				<display:column property="fullScore" title="����" sortable="true" />
				<display:column property="paperTime" title="����ʱ��" sortable="true" />
				<display:column title="����">
					<a href="x">�޸�</a>||<a
						href="javascript:deleteConfirm('${row.paperId}')">ɾ��</a>
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
			<form id="form1" name="form1" method="post"
				action="#">
				<table width="100%" border="0" >
					<tr>
						<td width="167">
							�Ծ�����						</td>
						<td width="168">
							<label>
								<input type="text" name="Sname" size=15 />
							</label>
					  </td>
						<td width="119">
							������						</td>
						<td width="141">
							<input type="text" name="Sisbn" size=15 />
					  </td>
						<td width="368">
								<div align="right">
									<input type="submit" name="Submit3" value="��ѯ" />
									||
									<input type="button" name="button_addAccount"
										onclick="javascript:addPaper()" value="�����Ծ�" />
								</div>
					  </td>
					</tr>
				</table>
			</form>
		</div>
		<div id="popupcontent">
			�Ծ����ϸ��Ϣ
		</div>
		<script type="text/javascript">
  		    hidePopup();
        </script>
	</body>
</html>