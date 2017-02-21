$(function(){
	var timu_num=$("section").length;//题目总数
	$("#tinum").html(timu_num);//初始化题目总数
	$("#tinum_yes").html("0");//初始化已做题目总数
	$("#tinum_no").html(timu_num);//初始化未做题目总数
//	设置右侧栏背景高度star-------------------------------设置右侧栏背景高度star
	var height=$(".box").css("height");
	$(".right").css("height",height)
//	设置右侧栏背景高度end-------------------------------设置右侧栏背景高度end

//	题目快速预览star--------------------------------------------题目快速预览star
	for(var i=0; i<$(".xz_section").length ;i++){
		$(".right_xz ul").append("<li>"+(i+1)+"</li>");//添加题目快速预览
		$(".xz_section").eq(i).find("input").on("click",function(){//改变题目作答状态
			var index=$(this).parents("section").index();
			$(".right_xz ul li").eq(index).css({"background-color":"#c2c9c3","border":"1px solid #c2c9c3"});
			change();//更新做题数值
		})
	}
	for(var i=0; i<$(".tk_section").length ;i++){
		$(".right_tk ul").append("<li>"+(i+1)+"</li>");//添加题目快速预览
		$(".tk_section").eq(i).find("input").on("focusout",function(){//改变题目作答状态
			var index=$(this).parents("section").index();
			if($(this).val()!=""){
				$(".right_tk ul li").eq(index).css({"background-color":"#c2c9c3","border":"1px solid #c2c9c3"});
				change();//更新做题数值
			}else{
				$(".right_tk ul li").eq(index).css({"background-color":"white","border":"1px solid black"});
				change();//更新做题数值
			}
		})
	}
	for(var i=0; i<$(".wd_section").length ;i++){
		$(".right_wd ul").append("<li>"+(i+1)+"</li>");//添加题目快速预览
		$(".wd_section").eq(i).find("textarea").on("focusout",function(){//改变题目作答状态
			var index=$(this).parents("section").index();
			if($(this).val()!=""){
				$(".right_wd ul li").eq(index).css({"background-color":"#c2c9c3","border":"1px solid #c2c9c3"});
				change();//更新做题数值
			}else{
				$(".right_wd ul li").eq(index).css({"background-color":"white","border":"1px solid black"});
				change();//更新做题数值
			}
		})
	}
//	题目快速预览end---------------------------------------------题目快速预览end

//	函数，用于更新做题数值star--------------------------------------------函数，用于更新做题数值star
	function change(){
		var k=0;
		for(var i=0; i<$(".right li").length; i++){
			if($(".right li").eq(i).css("background-color")=="rgb(194, 201, 195)"){
				k++;
			}
		}
		$("#tinum_no").html(timu_num-k);
		$("#tinum_yes").html(k);
	}
//	函数，用于更新做题数值end--------------------------------------------函数，用于更新做题数值end

//	倒计时star-------------------------------------------------倒计时star
	var exam_time=$("#exam_time").html();//考试时间_分钟
	var h,m,s,hstr,mstr,sstr,timestr;
	var etimeMinu = exam_time; // 考试时间_分钟
	var etime = etimeMinu * 60;//考试时间_秒数
	var downtime=setInterval(timer,1000)//启动倒计时
	function timer(){

	    h = Math.floor(etime / 3600);    //时
	    m = Math.floor(etime / 60) % 60; //分
	    s = Math.floor(etime % 60);      //秒
	    
	    h < 0 ? h = 0 : h = h;
	    m < 0 ? m = 0 : m = m;
	    s < 0 ? s = 0 : s = s;
	    
	    h.toString().length < 2 ? hstr = "0" + h.toString() : hstr = h; //1显示01
	    m.toString().length < 2 ? mstr = "0" + m.toString() : mstr = m; //1显示01
	    s.toString().length < 2 ? sstr = "0" + s.toString() : sstr = s; //1显示01
	    
	    timestr = hstr + "时" + mstr + "分" + sstr + "秒";
	    etime = etime - 1;
	    if(etime==299){
	    	$(".tips").css("display","block");
			$(".bg").css("display","block");
		}else if(etime>0){
		    document.getElementById('time').innerHTML = timestr;   
		}else {
		    clearInterval(downtime);
		    $(".bg").css("display","block");
		}
	}
//	倒计时end----------------------------------------------------倒计时end
	
	$("#know").on("click",function(){//通知框"我知道"按钮
		$(".bg").css("display","none");
		$(".tips").css("display","none");
	})
	$("#cancel").on("click",function(){//通知框"取消提交"按钮
		$(".bg").css("display","none");
		$(".affirm").css("display","none");
		$(".tips").css("display","none");
	})
	$("#submit").on("click",function(){//"提交试卷"按钮
		$(".bg").css("display","block");
		$(".affirm").css("display","block");
	})
	$("#submit_tips").on("click",function(){//提示框里的"提交试卷"按钮
		$(".affirm").css("display","block");
	})

	//	获取所有数据----------------------------------------------------获取所有数据
	var StuNum=$("#StuNum").html();
	var StuName=$("#StuName").html();
	var classNum=$("#classNum").html();
	var subject=$("#subject").html();
	var sel_num=$(".xz_section").length;
	var fill_num=$(".tk_section").length;
	
	var sel_answer=new Array();
	var fill_answer=new Array();
	
	for(var i=0; i<$("#choice_anwser li").length ;i++){//获取选择题答案
		var str=$("#choice_anwser li").eq(i).html();
		sel_answer.push(str);
	}
	$("#choice_anwser").remove();
	
	for(var i=0; i<$("#tiankong_anwser li").length ;i++){//获取填空题答案
		var str=$("#tiankong_anwser li").eq(i).html();
		fill_answer.push(str);
	}
	$("#tiankong_anwser").remove();
	
	
	//	上传试卷----------------------------------------------------上传试卷
	//设置选择题答案
	window.init.selAnswer = sel_answer;
	//设置选择题数量
	window.init.selcount = sel_num;
	//设置填空题答案
	window.init.fillAnswer = fill_answer;
	//设置填空题数量
	window.init.fillcount = fill_num;
	
	//设置选择题小题分值
	window.score.sel=parseInt($("#sel_littlescore").html());
	window.score.fill=parseInt($("#fill_littlescore").html());
	
	//设置基本信息
	window.userMsg.StuNum=StuNum;
	window.userMsg.StuName=StuName;
	window.userMsg.subject=subject;
	window.userMsg.classNo=classNum;
})
