<%@ page language="java" contentType="text/html;charset=UTF-8" errorPage="exception.jsp"%>
<%@include file="taglibs.jsp" %>

<html>
  <head> 
    <meta http-equiv="Content-Language" content="zh-cn">
	<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <title>=====在线考试系统=====</title>  	
	<link href="images/Style.css" rel="stylesheet" type="text/css" >
 <script language="javascript" type="text/javascript">
    function check(){
      if(document.AddStudentForm.id.value==""){
          alert("身份证号不能为空");
          document.AddStudentForm.id.focus();
          return false;
      }
      if(document.AddStudentForm.realname.value==""){
          alert("考生姓名不能为空");
          document.AddStudentForm.realname.focus();
          return false;
      }
      if(document.AddStudentForm.address.value==""){
          alert("考生地址不能为空");
          document.AddStudentForm.address.focus();
          return false;
      }
      if(document.AddStudentForm.phone.value==""){
          alert("考生电话不能为空");
          document.AddStudentForm.phone.focus();
          return false;
      }
      if(document.AddStudentForm.classname.value==""){
          alert("考生班级不能为空");
          document.AddStudentForm.classname.focus();
          return false;
      }
      if(document.AddStudentForm.stuNumber.value==""){
          alert("学生考号不能为空");
          document.AddStudentForm.stuNumber.focus();
          return false;
      }
      if(document.AddStudentForm.email.value==""){
          alert("邮箱不能为空");
          document.AddStudentForm.email.focus();
          return false;
      }
       else if(document.AddStudentForm.email.value.indexOf("@")==-1){
          alert("邮箱地址不规范");
          document.AddStudentForm.email.focus();
          return false;
       }
    }
</script>
<script type="text/javascript" src="js/tree.js"></script>
  </head>
  
  <body>
    <div align="left">
        <table width="778" height="574" border="0" align="center" cellpadding="0" cellspacing="0" bgcolor="#FFFFFF" style="border:2px solid #008000;padding:0px">
           <tr>
              <td height="169" align="justify" valign="baseline" style="border-bottom: 2px solid #008000;padding:0px" colspan="2">
            <img border="0" src="images/2.jpg" width="778" height="167"></td>
           </tr>
           <tr>
              <td height="320" align="left" valign="top" width="160"><jsp:include page="left.html"/>
              </td>
              <td height="320" align="left" valign="top" style="border-bottom:1px solid #808080;border-left:1px solid #808080; border-right: 1px; solid #008000 padding: 0px" width="619" >
                 <TABLE class=Xsmall cellspacing=1 cellpadding=2 width=576 align="center" bgcolor=#d2ebff boeder=0 id="table11">
                    <TBODY>
                        <TR>
                           <TD valign="top" bgcolor="#ffffff">
                              <TABLE cellspacing=0 cellpadding=0 width="100%" border=0 id="table12">
                                 <TBODY>
                                     <TR>
                                        <TD class=Xsmall background="images/backt.gif" height=25><STRONG>添加考生</STRONG></TD>
                                    </TR>
                                </TBODY>
                             </TABLE>
                           </TD>
                        </TR>
                         <TR>
                            <TD valign="top" bgcolor="#ffffff">
                               <FORM name="AddStudentForm" onSubmit="return chaeck()" action="processAddStudent.do" method="post">
                                  <TABLE class=Xsmall cellspacing=0 cellpadding=0 width=500 align="center" border=0 id="table13" height="112">
                                     <TBODY>
                                          <TR>
                                               <TD width=88 height=25 align="center"><DIV align="center">身份证号：</DIV></TD>
                                               <TD width=162><input class=Sborder id="id" size=16 name="id"></TD>
                                               <TD width=100><DIV align="center">姓名：</DIV></TD>
                                               <TD width=150><input class=Sborder id="realname" size=17 name="realname"></TD>
                                           </TR>   
                                           <TR>
                                               <TD height=25 align="center"><DIV align="center">学&nbsp;&nbsp;&nbsp;号：</DIV></TD>
                                               <TD width=162><input class=Sborder id="stuNumber" size=17 name="stuNumber"></TD>
                                               <TD><DIV align="center">班&nbsp;级:</DIV></TD>
                                               <TD><input class=Sborder id="className" size=17 name="className"></TD>
                                           </TR>
                                           <TR>
                                              <TD height=25 align="center">地址:</TD>
                                              <TD width="162"><input class=Sborder id="address" size=16 name="address"></TD>
                                              <TD><DIV align="center">电话:</DIV></TD>
                                              <TD><input class=Sborder id="phone" size=17 name="phone"></TD>
                                           </TR>
                                           <TR>
                                              <TD height=25 align="center">&nbsp;&nbsp;E-mail:&nbsp;</TD>
                                              <TD width="162"><input class=Sborder id="email" size=16 name="email"></TD>
                                              <TD><DIV align="center">身份证:</DIV></TD>
                                              <TD><input class=Sborder id="humanId" size=17 name="humanId"></TD>
                                          </TR>
                                          <TR>
                                              <TD colspan="4" height=37><DIV align="center">
                                                  <TABLE class=Xsmall cellspacing=0 cellpadding=0 width="49%" border=0 id="table14">
                                                   <TBODY>
                                                        <TR>
                                                            <TD><DIV align="center"><input class=Sborder type="submit" value="确定" name="submit"></DIV></TD>
                                                            <TD><DIV align="center"><input class=Sborder type="reset" value="重写" name="reset"></DIV></TD>
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
             </td>
           </tr>
       </table>
<%@include file="footer.jsp" %>
    </div>
  </body>
</html>
