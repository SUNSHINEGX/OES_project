<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<style>

#hint{

 width:100px;

 border:1px solid #000000;

 background:#99ff33;

 position:absolute;

 z-index:9;

 padding:6px;

 line-height:17px;

 text-align:left;

 top: 1520px;

}

</style>


 <script language="javascript">

function showme(obj)

{
      alert("11111");
      alert(obj.value);
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

              bodySL=document.body.scrollLeft; //author: meizz

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
       
       alert("22222");
       var bodyCW, bodyCH;
       alert("22222233333333");
       if(windows.innerWidth)
       {
              alert("333333333");
              bodyCW=windows.innerWidth;
         
       }

       else if(document.documentElement&&document.documentElement.clientWidth)

       {
              alert("3333333332222222");
              bodyCW=document.documentElement.clientWidth;
        
       }

       else if(document.body)

       {
              alert("3333333332222222vvvvv");
              bodyCW=document.body.clientWidth; //author: meizz
    

       }
       
       alert("44444444444444444");
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


 var oSon=window.document.getElementByIdx("hint");

 if (oSon==null) return;

 with (oSon)

 {

  innerText=obj.value;

  style.display="block";

  style.pixelLeft=window.event.clientX + bodySL - oSon.clientWidth - 6;

//  style.pixelRight=50;

  if(window.event.clientY + oSon.clientHeight + 10 > bodyCH)

    style.pixelTop=bodyCH - oSon.clientHeight + bodyST - 10;

  else

    style.pixelTop=window.event.clientY + bodyST + 10;

 }

}

function hideme(obj)

{

 var oSon=window.document.getElementByIdx("hint");

 if (oSon==null) return;

 oSon.style.display="none";

}
</script>

 

<input type=text id="detailhint" value="test text" />

<label onmouseover=showme(detailhint) onmouseout=hideme() >²é¿´</label>

<div id=hint style="display:none"></div>