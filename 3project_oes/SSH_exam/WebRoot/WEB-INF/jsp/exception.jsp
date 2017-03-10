<%@ page language="java" contentType="text/html;charset=UTF-8" isErrorPage="true"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head> 
  <meta http-equiv="Content-language" content="zh-cn">
    <title>=====在线考试系统=====</title>
  <link href="images/Type.css" rel="stylesheet" type="text/css">
  </head>
  <body>
   <div align="center">
     <table width="777" border="0" cellpadding="0" cellspacing="0" bgcolor="#FFFFFF" style="border:2px solid #008000;padding:0px" height="478">
        <tr>
            <td height="136" align="justify" valign="bottom" background="images/2.jpg" style="border-bottom:1px soloid #008000 padding=0"></td>
       </tr>
 	   <tr>
           <td height="275" align="center">
             <div align="center"><font color="#FF0000" size="+1"><b>系统处理过程中发生了异常，信息如下：</b></font></div>
             ${exception.message}
             <div align="center">请您先核对输入，如果再次出现错误，请与站长联系，ajaxdreamer@gmail.com,谢谢！</div>
        </td>
 	   </tr>
  </table>
 <%@ include file="footer.jsp" %>
  </div>
  </body>
</html>
