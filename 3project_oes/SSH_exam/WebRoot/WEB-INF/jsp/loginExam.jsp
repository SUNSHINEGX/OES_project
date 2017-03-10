<%@ page language="java" contentType="text/html;charset=UTF-8" errorPage="exception.jsp"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
	<meta http-equiv="Content-Language" content="zh-cn">
	<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
     <title>在线考试系统</title>
 <link href="images/Type.css" rel="stylesheet" type="text/css">
 
  </head>
  <body>
   <div align="center">
    <table width="777" border="0" cellpadding="0" cellspacing="0" bgcolor="#FFFFFF" style="border:2px solid #008000;padding:0px" height="471">
        <tr>
            <td height="152" align="justify" valign="bottom" background="images/2.jpg" style="border-bottom:1px soloid #008000 padding=0">${reuestScope.msg }</td>
       </tr>
   <form name="StudentLoginForm" method="post" action="processLogin.do">
       <tr>
          <td height="275" align="center">
             <font face="黑体" size="4"><img border=0 src="images/stu_1.gif" width="16" height="16">考生学号<b>:</b></font><font size="4"><input type="text"  name="stuNumber" size="16">&nbsp;&nbsp;</font>  
             <font face="黑体" size="4"><img border=0 src="images/stu_1.gif" width="16" height="16">考生姓名<b>:</b></font><font size="4"><input type="text" name="stuName" size="16">&nbsp;&nbsp;</font>
             <p><font size="4">&nbsp;</font></p>
             <p><input type="submit" name="B1" value="提交">&nbsp;&nbsp;&nbsp;
                <input type="reset" name="B2" value="重置"></p>
         </td>
      </tr>
  </form>
   </table>
<%@ include file="footer.jsp"%>
  </div>
  </body>
</html>
