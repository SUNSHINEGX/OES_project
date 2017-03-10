<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<html>
<head>
   <style type="text/css">
    .xy {
     color:blue;
     font-weight:bold;
     font-size:15px;
    }
    #box {
     background-color:aqua;
     width:100%;
     height:100%;
    }
    #heading {
     background-color:#800000;
     color:ffff00;
     text-align:center;
    }
   </style>

   <script type="text/javascript">
    function getXandY(){
     var Xa = window.event.clientX;
     var Ya = window.event.clientY;
     document.getElementByIdx("xa").innerHTML = Xa;
     document.getElementByIdx("ya").innerHTML = Ya;
     var Xb = window.event.x;
     var Yb = window.event.y;
     document.getElementByIdx("xb").innerHTML = Xb;
     document.getElementByIdx("yb").innerHTML = Yb;
     var Xc = window.event.screenX;
     var Yc = window.event.screenY;
     document.getElementByIdx("xc").innerHTML = Xc;
     document.getElementByIdx("yc").innerHTML = Yc;

     var screenHeight = window.screen.height;
     var screenWidth = window.screen.Width;
     document.getElementByIdx("screenHeight").innerHTML = screenHeight;
     document.getElementByIdx("screenWidth").innerHTML = screenWidth;

     var clientHeight = window.document.body.clientHeight;
     var clientWidth = window.document.body.clientWidth;
     var clientLeft = window.document.body.clientLeft;
     var clientTop = window.document.body.clientTop;
     document.getElementByIdx("ch").innerHTML = clientHeight;
     document.getElementByIdx("cw").innerHTML = clientWidth;
     document.getElementByIdx("cl").innerHTML = clientLeft;
     document.getElementByIdx("ct").innerHTML = clientTop;

     var scrollHeight = window.document.body.scrollHeight;
     var scrollWidth = window.document.body.scrollWidth;
     var scrollLeft = window.document.body.scrollLeft;
     var scrollTop = window.document.body.scrollTop;
     document.getElementByIdx("sh").innerHTML = scrollHeight;
     document.getElementByIdx("sw").innerHTML = scrollWidth;
     document.getElementByIdx("sl").innerHTML = scrollLeft;
     document.getElementByIdx("st").innerHTML = scrollTop;

     var offsetHeight = window.document.body.offsetHeight;
     var offsetWidth = window.document.body.offsetWidth;
     var offsetLeft = window.document.body.offsetLeft;
     var offsetTop = window.document.body.offsetTop;
     document.getElementByIdx("oh").innerHTML = offsetHeight;
     document.getElementByIdx("ow").innerHTML = offsetWidth;
     document.getElementByIdx("ol").innerHTML = offsetLeft;
     document.getElementByIdx("ot").innerHTML = offsetTop;
    }
   </script>
</head>
<BODY onmousemove="getXandY()">
<div align="center"></div>
<table width="1200" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td>

   <div id="box">
    <div id="heading">
     <B>鼠标当前坐标测试</B>
    </div>
    <BR>
  
    <label>window.event.clientX：</label><label id="xa" class="xy"></label><BR>
    <label>window.event.clientY：</label><label id="ya" class="xy"></label><BR>
    <label>window.event.x      ：</label><label id="xb" class="xy"></label><BR>
    <label>window.event.y      ：</label><label id="yb" class="xy"></label><BR>
    <label>window.event.screenX：</label><label id="xc" class="xy"></label><BR>
    <label>window.event.screenY：</label><label id="yc" class="xy"></label><BR><BR>

    <label>window.screen.height：</label><label id="screenHeight" class="xy"></label><BR>
    <label>window.screen.Width：</label><label id="screenWidth" class="xy"></label><BR><BR>

    <label>window.document.body.clientHeight：</label><label id="ch" class="xy"></label><BR>
    <label>window.document.body.clientWidth：</label><label id="cw" class="xy"></label><BR>
    <label>window.document.body.clientLeft：</label><label id="cl" class="xy"></label><BR>
    <label>window.document.body.clientTop：</label><label id="ct" class="xy"></label><BR><BR>

    <label>window.document.body.scrollHeight：</label><label id="sh" class="xy"></label><BR>
    <label>window.document.body.scrollWidth：</label><label id="sw" class="xy"></label><BR>
    <label>window.document.body.scrollLeft：</label><label id="sl" class="xy"></label><BR>
    <label>window.document.body.scrollTop：</label><label id="st" class="xy"></label><BR><BR>

    <label>window.document.body.offsetHeight：</label><label id="oh" class="xy"></label><BR>
    <label>window.document.body.offsetWidth：</label><label id="ow" class="xy"></label><BR>
    <label>window.document.body.offsetLeft：</label><label id="ol" class="xy"></label><BR>
    <label>window.document.body.offsetTop：</label><label id="ot" class="xy"></label><BR><BR>
   </div>
</td>
  </tr>
</table>
</body>
</html>