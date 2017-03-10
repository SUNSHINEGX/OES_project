<%@ page language="java" contentType="text/html;charset=UTF-8" errorPage="exception.jsp"%>

<html>
  <head> 
    <meta http-equiv="Content-Language" content="zh-cn">
	<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <title>欢迎光临科帮网在线考试系统</title>  	
	<link href="images/Style.css" rel="stylesheet" type="text/css" >
<script language="javascript">
    function check(){
       if(document.addTestForm.testName.value==""){
           alert("试卷名称不能为空");
           document.addTestForm.testName.focus();
           return false;
       }
        if(document.addTestForm.testTime.value==""){
           alert("考试时间不能为空");
           document.addTestForm.testTime.focus();
           return false;
       }
    }
    
</script>
<script type="text/javascript" src="js/tree.js"></script>
  </head>
  
   <body>
    <div align="left">
        <table width="778" height="497" border="0" align="center" cellpadding="0" cellspacing="0" bgcolor="#FFFFFF" style="border:2px solid #008000;padding:0px">
           <tr>
              <td height="169" align="justify" valign="baseline" style="border-bottom: 2px solid #008000;padding:0px" colspan="2">
            <img border="0" src="images/2.jpg" width="778" height="167"></td>
           </tr>
           <tr>
               <td height="320" align="left" valign="top" width="180"><jsp:include page="left.html"/>
               </td>
               <td height="320" align="center" valign="top" style="border-bottom:1px solid #808080; border-right: 1px; solid #008000 padding: 0px border-left-style:solid; border-left-width: 1px;" width="602">
                 <TABLE class=Xsmall cellspacing=1 cellpadding=2 width=500 align="center" bgcolor="#d2ebff" border=0 id="table1">
                    <TBODY>
                       <TR>
                          <TD valign="top" bgcolor="#ffffff">
                            <TABLE cellspacing=0 cellpadding=0 width="100%" border=0 id="table2">
                               <TBODY>
                                    <TR>
                                       <TD class=Xsmall background=在线UI/img/backt.gif height=25><STRONG>添加试卷</STRONG></TD>
                                    </TR>
                               </TBODY>
                            </TABLE>
                          </TD>
                      </TR> 
                      <TR>
                          <TD valign="top" bgcolor="#ffffff">
                             <TABLE class=Xsmall cellspacing=0 cellpadding=0 width=500 align="center" border=0 id="table3">
                                 <FORM name="addTestForm" onSubmit="return check()" action="processAddTest.do" method="post">
                                    <TBODY>
                                       <TR>
                                          <TD width=98 height=25 style="border-bootom:1px;solid #CCFFFF; padding: 0px">
                                             <DIV align="center">&nbsp;试卷名称:</DIV> </TD>
                                          <TD style="border-bootom:1px;solid #CCFFFF; padding: 0px"><input class=Sborder id="testName" size=15 name="testName"></TD>
                                       </TR> 
                                       <TR>
                                          <TD height=25 style="border-bootom:1px;solid #CCFFFF; padding: 0px">
                                              <DIV align="center">考试时间：</DIV></TD>
                                          <TD style="border-bootom:1px;solid #CCFFFF; padding: 0px" width=338><input class=Sborder id="testTime" size=15 name="testTime"></TD>
                                       </TR>
                                       <TR>
                                          <TD colspan="2" height=30><DIV align="center">
                                            <TABLE class=Xsmall cellspacing=0 cellpadding=0 WIDTH="49%" border=0 id="table4">
                                                <TBODY>
                                                   <TR>
                                                       <TD><DIV align="center"><input class=Sborder type="submit" value="确定" name="submit"></DIV></TD>
                                                       <TD><DIV align="center"><input class=Sborder type="reset" value="重写" name="reset"></DIV></TD>
                                                   </TR>
                                                </TBODY>
                                            </TABLE>
                                          </DIV></TD>
                                       </TR>
                                   </TBODY>
                                 </FORM>
                             </TABLE>
                         </TD>
                      </TR>
                   </TBODY>
                 </TABLE>
              </td>
           </tr>
  </table>
<%@include file="footer.jsp" %>
 </div>
  </body>
</html>
