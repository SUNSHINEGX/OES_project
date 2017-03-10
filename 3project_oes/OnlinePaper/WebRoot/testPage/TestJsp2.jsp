<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<script Language="JavaScript">

//***********默认设置定义.*********************

tPopWait=50;//停留tWait豪秒后显示提示。

tPopShow=50000;//显示tShow豪秒后关闭提示

showPopStep=20;

popOpacity=99;

//***************内部变量定义*****************

sPop=null;

curShow=null;

tFadeOut=null;

tFadeIn=null;

tFadeWaiting=null;

document.write("<style type='text/css'id='defaultPopStyle'>");

document.write(".cPopText {  background-color: #FFFF99;color:#000000; border: 1px #000000 solid;font-color: font-size: 9px; padding-right: 4px; padding-left: 4px; height: 20px; padding-top: 2px; padding-bottom: 2px; filter: Alpha(Opacity=0)}");

document.write("</style>");

document.write("<div id='dypopLayer' style='position:absolute;z-index:1000;' class='cPopText'></div>");

 

function showPopupText()

{

       var o=event.srcElement;

       MouseX=event.x;

       MouseY=event.y;

       if(o.alt!=null && o.alt!=""){o.dypop=o.alt;o.alt=""};

       if(o.title!=null && o.title!=""){o.dypop=o.title;o.title=""};

       if(o.dypop!=sPop)

       {

              sPop=o.dypop;

              clearTimeout(curShow);

              clearTimeout(tFadeOut);

              clearTimeout(tFadeIn);

              clearTimeout(tFadeWaiting);

              if(sPop==null || sPop=="")

              {

                     dypopLayer.innerHTML="";

                     dypopLayer.style.filter="Alpha()";

                     dypopLayer.filters.Alpha.opacity=0;

              }

              else

              {

                     sPop = sPop.replace(/[\r\n]/g,"<br>");

                     if(o.dyclass!=null)

                            popStyle=o.dyclass

                     else

                            popStyle="cPopText";

                     curShow=setTimeout("showIt()",tPopWait);

              }

       }

}

 

function showIt()

{

      var bodySL, bodyST;

       if(window.pageXOffset)

       {

              bodySL=window.pageXOffset;

       }

       else if(document.documentElement&&document.documentElement.scrollLeft)

       {

              bodySL=document.documentElement.scrollLeft;

       }

       else if(document.body)

       {

              bodySL=document.body.scrollLeft;

       }

 

       if(window.pageYOffset)

       {

              bodyST=window.pageYOffset;

       }

       else if(document.documentElement&&document.documentElement.scrollTop)

       {

              bodyST=document.documentElement.scrollTop;

       }

       else if(document.body)

       {

              bodyST=document.body.scrollTop;

       }

 

       var bodyCW, bodyCH;

       if(windows.innerWidth)

       {

              bodyCW=windows.innerWidth;

       }

       else if(document.documentElement&&document.documentElement.clientWidth)

       {

              bodyCW=document.documentElement.clientWidth;

       }

       else if(document.body)

       {

              bodyCW=document.body.clientWidth;

       }

 

       if(windows.innerHeight)

       {

              bodyCH=windows.innerHeight;

       }

       else if(document.documentElement&&document.documentElement.clientHeight)

       {

              bodyCH=document.documentElement.clientHeight;

       }

       else if(document.body)

       {

              bodyCH=document.body.clientHeight;

       }

 

       dypopLayer.className=popStyle;

       dypopLayer.innerHTML=sPop;

       popWidth=dypopLayer.clientWidth;

       popHeight=dypopLayer.clientHeight;

       if(MouseX+12+popWidth>bodyCW)

              popLeftAdjust=-popWidth-24

       else

              popLeftAdjust=0;

       if(MouseY+12+popHeight>bodyCH)

              popTopAdjust=-popHeight-24

       else

              popTopAdjust=0;

       dypopLayer.style.left=MouseX+12+bodySL+popLeftAdjust;

       dypopLayer.style.top=MouseY+12+bodyST+popTopAdjust;

       dypopLayer.style.filter="Alpha(Opacity=0)";

       fadeOut();

}

 

function fadeOut(){

       if(dypopLayer.filters.Alpha.opacity<popOpacity)

       {

              dypopLayer.filters.Alpha.opacity+=showPopStep;

              tFadeOut=setTimeout("fadeOut()",1);

       }

       else

       {

              dypopLayer.filters.Alpha.opacity=popOpacity;

              tFadeWaiting=setTimeout("fadeIn()",tPopShow);

       }

}

 

function fadeIn(){

       if(dypopLayer.filters.Alpha.opacity>0)

       {

              dypopLayer.filters.Alpha.opacity-=1;

              tFadeIn=setTimeout("fadeIn()",1);

       }

}

document.onmouseover=showPopupText;

</script>

 

<label title="test text2">查看2</label>