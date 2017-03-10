<%@ page language="java"  pageEncoding="GBK"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
		<title>新增试卷</title>
		<link href="<s:url value="/css/main.css" />" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="<s:url value="/js/commCheck.js" />"></script>
		<script type="text/javascript" src="<s:url value="/js/wpCalendar.js" />"></script>
		<style type="text/css">
<!--
.STYLE1 {
	color: #0066FF;
	font-weight: bold;
	font-size: 17px;
}
.STYLE2 {color: #ECE9D8}
.STYLE3 {color: #FFFF99}
.STYLE4 {
	color: #000000;
	font-weight: bold;
	font-size: 16px;
	 }

-->
        </style>
	</head>

	<script type="text/javascript">
		var req;
		var checkFlag=false;

		var baseText = null; 
		function showPopup(w,h,uniqid){ 
          var popUp = document.getElementById("popupcontent"); 
          popUp.style.background="#0066FF";
          popUp.style.top = "185px"; 
          popUp.style.left = "240px"; 
          //popUp.style.top = event.x; 
          //popUp.style.left = event.y; 
          popUp.style.zIndex =100;                
          popUp.style.width = w + "px"; 
          popUp.style.height = h + "px"; 
          //popUp.innerHTML="帐户的详细信息";
          //*****call ajax****************//
          req=new ActiveXObject("Microsoft.XMLHttp");
          req.open("get","<s:url value="/displayQuestionInfoAction.action?questID=" />"+uniqid);  
		  req.onreadystatechange=handleRequestPop;
		  req.send(null);
          popUp.style.visibility = "visible";
      }

		function handleRequestPop(){
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
		

	     function selectQuestionWithSearch(crietia)
	         {
	          checkFlag=false;
	          req=new ActiveXObject("Microsoft.XMLHttp");
              req.open("get","<s:url value="/listQuestionForPaperAction.action?search=true" />");
              //req.open("get","<s:url value="/listQuestionForPaperAction!queryQuestionForPaperList.action?stdID=" />"+uniqid);  
		      req.onreadystatechange=handleRequest;
		      req.send(null);
	         }

	     function selectQuestion(crietia)
	         {
	          //alert("dddd");
	          checkFlag=false;
	          req=new ActiveXObject("Microsoft.XMLHttp");
              req.open("get","<s:url value="/listQuestionForPaperAction.action" />");
              //req.open("get","<s:url value="/listQuestionForPaperAction!queryQuestionForPaperList.action?stdID=" />"+uniqid);  
		      req.onreadystatechange=handleRequest;
		      req.send(null);
	         }
	         
		function handleRequest(){
			var checkResult=document.getElementById("PaperLayer1");
			if(req.readyState==4){
				if(req.status==200){
					checkResult.innerHTML=req.responseText;
				}	
				else{
					alert("An error occurred:"+req.statusText);
				}
			}
		}
	         
	         
	    function  selectAll()
	       {
	        if(checkFlag==false)
	            {
	              for(i=0;i<document.paperForm.questionIDs.length;i++)
	                 {  f =document.paperForm.questionIDs[i];
	                    f.checked=true; 
	                 }
	              checkFlag=true;
	            }
	        else
	            {
	              for(i=0;i<document.paperForm.questionIDs.length;i++)
	                 {  f =document.paperForm.questionIDs[i]; 
	                    f.checked=false; 
	                 }
	              checkFlag=false;
	            }
	       }
	    

	    function  selectAll2()
	       {
	        //alert(checkFlag);
	        if(checkFlag==false)
	            {
	              for(i=0;i<document.paperForm.questionIDs2.length;i++)
	                 {  f =document.paperForm.questionIDs2[i];
	                    f.checked=true; 
	                 }
	              checkFlag=true;
	            }
	        else
	            {
	              for(i=0;i<document.paperForm.questionIDs2.length;i++)
	                 {  f =document.paperForm.questionIDs2[i]; 
	                    f.checked=false; 
	                 }
	              checkFlag=false;
	            }
	       }

	    
	    function selQes()
	       {
	        var questsStr="";
	        for(i=0;i<document.paperForm.questionIDs.length;i++)
	            {  f =document.paperForm.questionIDs[i];
	               if (f.checked==true)
	                  {
	                  questsStr=questsStr+f.value+",";
	                  } 
	            }
	        if (questsStr=="")
	             {
	               alert("无选择题目");
	               return;
	             } 
	            
	        //alert(questsStr);
	          req=new ActiveXObject("Microsoft.XMLHttp");
              req.open("get","<s:url value="/chooseQestToPaperAction.action?paramIDs=" />"+questsStr);
              //req.open("get","<s:url value="/listQuestionForPaperAction!queryQuestionForPaperList.action?stdID=" />"+uniqid);  
		      req.onreadystatechange=handleRequest;
		      req.send(null);
	       }
	       /*
		function handleRequest2(){
			var checkResult=document.getElementById("PaperLayer1");
			if(req.readyState==4){
				if(req.status==200){
					checkResult.innerHTML=req.responseText;
				}	
				else{
					alert("An error occurred:"+req.statusText);
				}
			}
		}	       
		*/
		function unSelQes()
		  {
	        var questsStr="";
	        for(i=0;i<document.paperForm.questionIDs2.length;i++)
	            {  f =document.paperForm.questionIDs2[i];
	               if (f.checked==true)
	                  {
	                  questsStr=questsStr+f.value+",";
	                  } 
	            }
	        if (questsStr=="")
	             {
	               alert("无选择题目");
	               return;
	             } 
	            
	        //alert(questsStr);
	          req=new ActiveXObject("Microsoft.XMLHttp");
              req.open("get","<s:url value="/choosePaperToQestAction.action?paramIDs=" />"+questsStr);
              //req.open("get","<s:url value="/listQuestionForPaperAction!queryQuestionForPaperList.action?stdID=" />"+uniqid);  
		      req.onreadystatechange=handleRequest;
		      req.send(null);
		  }
		  
            function checkChooseOptions()
		      {
		      if  (document.paperForm.questionIDs2==null || document.paperForm.questionIDs2.length==0)
		         {alert("请选择试题");
		          return false; }
		      else
		         {return true;}
		      }
	</script>
	

	<body onLoad="javascript:selectQuestion('criteria')" >
	  <s:form action="addPaperAction.action" validate="false" name="paperForm" onsubmit="return checkChooseOptions();" >
		<div id="Layer_AddReader">
				<table width="671" height="189" border="0" bgcolor="#FFFF99">
					<tr>
					  <td height="22" colspan="5"><s:fielderror/>						</td>
					</tr>
					<tr>
						<td height="18" colspan="5">
							<div align="center">
					  <span class="STYLE1">试卷基本信息</span>							</div>						</td>
					</tr>
					<tr>
						<td width="109" height="18">试卷名称:</td>
						<td width="123">
					  <s:textfield name="paperName"   theme="simple" />						</td>
						<td width="110"> &nbsp;&nbsp;出卷人:						</td>
					  <td width="77"><s:textfield name="byUser" size="20"  theme="simple" />						</td>
						<td width="173"></td>
					</tr>
					<tr>
					    <td width="109" height="15">满分设置:</td>
						<td>
							<s:textfield name="fullScore"  size="8" theme="simple" />						</td>
					    <td> &nbsp;&nbsp;有效期:</td>
						<td >
							<s:textfield name="paperTime" size="20"  theme="simple"  />						</td>
						<td></td>
					</tr>

					<tr>
						<td height="18" colspan="5">
							<div align="center"></div>						</td>
					</tr>
					<tr>
					   <td height="10" colspan="4" align="center" bordercolor="#00CC33" bgcolor="#996699"><input name="button" type="button" onClick="javascript:selectQuestionWithSearch('criteria')" value="搜索题库(可根据以下条件进行搜索)" /></td>
					   <td rowspan="2"><div align="center">
					     <input name="generate" type="submit" class="STYLE4" value="生成试卷" />
					   </div></td>
					</tr>
					<tr bordercolor="#00CC33" bgcolor="#996699">
					  <td height="11"><span class="STYLE3">题干:</span></td>
				      <td><div align="center" class="STYLE2">
                        <s:textfield name="teacher" key="teacher" theme="simple" />
                      </div></td>
				      <td><span class="STYLE2">&nbsp;&nbsp;题型:</span></td>
				      <td><s:textfield name="grade" key="grade" theme="simple" />	</td>
				  </tr>
		  </table>
		</div>
		<br/>
	<div id="PaperLayer1"></div>
    <div id="popupcontent">	帐户的详细信息	</div>	
   	</s:form>
	</body>
	
</html>
