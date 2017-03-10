<%@ page language="java" contentType="text/html;charset=UTF-8" errorPage="exception.jsp"%>
<%@include file="taglibs.jsp" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
	<meta http-equiv="Content-Language" content="zh-cn">
	<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
     <title>科帮网在线考试系统</title>
 <link href="images/Type.css" rel="stylesheet" type="text/css">
 <script language="javascript" type="text/javascript">
   function chaeck(){
   //判断用户名是否填写
   if(document.lobform.name.value==""){
          alert("请输入用户名");  
          document.lobform.name.focus();
          return false;
   }
   //判断密码是否填写
   if(document.lobform.pass.value==""){
      alert("请输入密码");
      document.lobform.pass.focus();
      return false;
   }
 }
 
</script>
  </head>
  <body>
   <div align="center">
    <table width="778" border="0" cellpadding="0" cellspacing="0" bgcolor="#FFFFFF" style="border:2px solid #008000;padding:0px" height="451">
        <tr>
            <td height="161" align="justify" valign="bottom" background="images/2.jpg" style="border-bottom:1px soloid #008000 padding=0"></td>
       </tr>
   <form name="loginAdminForm" method="post" action="adminLogin.do" onsubmit="return check();">
       <tr>
          <td height="275" align="center">
        <logic:messagesPresent>
            <div class="error">
                 <bean:message key="errors.header"/>
                  <ul>
                   <html:messages id="error">
                       <li><bean:write name="error"/></li>
                   </html:messages>
                 </ul>
            </div>
       </logic:messagesPresent>
            <div class="error">${requestScope.msg}</div>
             <font face="黑体" size="4">管理员<b>:</b></font><font size="4"><input type="text" id="name" name="name" size="14">&nbsp;&nbsp;</font>  
             <font face="黑体" size="4">密码<b>:</b></font><font size="4"><input type="password" id="pass" name="password" size="14"></font><p>
             <p><input type="submit" name="B1" value="提交">&nbsp;&nbsp;&nbsp;<input type="reset" name="B2" value="重置"></p>
         </td>
      </tr>
   </form>
   </table>
<%@ include file="footer.jsp"%>
  </div>
  </body>
</html>
