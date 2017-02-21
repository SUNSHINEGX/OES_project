(function(){
	/*
	init
	需要参数:
	
		selAnswer --- array
		fillAnswer --- array
		selClassName --- String
		tijiaoID --- String 
		count ---- 5
		
	*/
	window.init={
		//选择题答案
		selAnswer:null,
		//填空题答案
		fillAnswer:null,
		//选择题ClassName
		selClassName:"selanswer",
		//填空题ClassName
		fillClassName:"fillanswer",
		//问答题ClassName
		qaClassName:"qaanswer",
		//提交ID
		tijiaoID : "submit_confrim",
		//选择题提示标签
		signSelClassName : "sel",
		//填空题提示标签
		signFillClassName : "fill",
		//选择题数量
		selcount : null,
		//填空题数量
		fillcount : null,
	};
	/*
	 * 分值
	 * */
	window.score={
		sel:0,
		fill:0
	}
	/*
	 * 学生基本信息
	 * */
	window.userMsg={
		//学号
		StuNum : null,
		//姓名
		StuName : null,
		//科目
		subject : null,
		//班级
		classNo : null
	}
	/*
	 * 分数数据
	 * */
	window.scoreMsg={
		//选择题
		SelScore : 0,
		FillScore : 0,
		QaScore : 0,
		Total : 0
	}

	var tijiao = document.getElementById(window.init.tijiaoID);
	
	
	tijiao.onclick = function tj(){
		//检查选择题
		checkSel();
		//检查填空题
		checkFill();
		//检查问答题e
		checkQa();
		//提交按钮失效
		tijiao.disabled=true;
		
//		设置右侧栏背景高度star-------------------------------设置右侧栏背景高度star
		var height=$(".box").css("height");
		$(".right").css("height",height)
//		设置右侧栏背景高度end-------------------------------设置右侧栏背景高度end
		$(".affirm").css("display","none");
		$(".bg").css("display","none");
		
//		移除提交试卷按钮
		$("#submit").remove();
		//获得html页面
		var ht=document.getElementsByTagName('html')[0].innerHTML
		$.ajax({
			type:"post",
			url:"run.action?sign=0"+
				"&StuNum="+window.userMsg.StuNum+
				"&StuName="+escape(encodeURIComponent(window.userMsg.StuName))+
				"&subject="+escape(encodeURIComponent(window.userMsg.subject))+
				"&classNo="+window.userMsg.classNo+
				"&SelScore="+window.scoreMsg.SelScore+
				"&FillScore="+window.scoreMsg.FillScore+
				"&QaScore="+window.scoreMsg.QaScore+
				"&Total="+window.scoreMsg.Total,
			dataType:"text",
			async:true,
			data:"content="+escape(encodeURIComponent(ht)),
			error: function(request) {
				alert("提交试卷失败!重新来过吧!");
			},
			success: function(data){
				if(data == "success"){
					$("#time").css("opacity","0");
					$("#back").css("display","block").on("click",function(){
						history.back();
					})
   					alert("提交试卷成功!");
   				}else{
   					alert("提交试卷失败!重新来过吧!");
   				}
			}
		});
		//上传问答题答案
		var qaStuNum=window.userMsg.StuNum;
		var qasubject=window.userMsg.subject;
		var qatoparray=new Array();
		var qaanswerarray=new Array();
		for(var i=0; i<$(".qatop").length; i++){
			var str=$(".qatop").eq(i).html();
			qatoparray.push(str);
		}
		for(var i=0; i<$(".qaanswer").length; i++){
			var str=$(".qaanswer").eq(i).val();
			if(""==str){
				str="警告：学生没有做此题，请老师打0分！！！"
			}
			qaanswerarray.push(str);
		}
		$.ajax({
			cache: true,
			type: "POST",
			url:"insertstudentqa.action?qaStuNum="+qaStuNum+"&qasubject="+qasubject+"&qatop="+qatoparray+"&qaanswer="+qaanswerarray,
			async: false,
			error: function(request) {
				alert("Connection error");
			},
			success: function(data) {
			}
		});
	}
	
	
	//问答题验证
	function checkQa(){
		var qa = document.getElementsByClassName(window.init.qaClassName);
		
//		记录单选按钮,并且设置disable
		for(var i =0; i<qa.length; i++){
			qa[i].innerHTML = qa[i].value;
			qa[i].setAttribute("disabled","true");
		}
	}
	//填空题验证
	function checkFill(){
		window.scoreMsg.FillScore =0;
		var StuAn = new Array();
		var sign = document.getElementsByClassName(window.init.signFillClassName);
		var fill = document.getElementsByClassName(window.init.fillClassName);
		
//		记录单选按钮,并且设置disable
		for(var i =0; i<fill.length; i++){
			if(fill[i].value){
				StuAn.push(fill[i].value);
			}else{
				StuAn.push("你的答案为空");
			}
			fill[i].setAttribute("value",fill[i].value);
			fill[i].setAttribute("disabled","true");
		}
		
		//比较学生答案和标准答案
		var compare =  comperArray(StuAn,window.init.fillAnswer,window.init.fillcount);
		//添加span对象，显示结果
		for(var j = 0 ; j<sign.length;j++){
			var h1 = document.createElement("h1");
			h1.style=(compare[j].isRight ==  0 ? "color: green;":"color: red;");
			h1.innerHTML=(compare[j].isRight ==  0 ? "正确":"错误")+
			"&nbsp;你的答案:"+compare[j].yourAn+
			"&nbsp;正确答案:"+compare[j].An;
			$(sign[j]).append(h1);
			//计算分数
			if(compare[j].isRight){
				window.scoreMsg.FillScore +=0;
			}else{
				window.scoreMsg.FillScore += window.score.fill;
			}
		}
	}
	
	//单选题验证
	function checkSel(){
		window.scoreMsg.SelScore =0;
		var StuAn = new Array();
		var sign = document.getElementsByClassName(window.init.signSelClassName);
		var rado = document.getElementsByClassName(window.init.selClassName);	
		var temp = 0;
		//记录单选按钮,并且设置disable
		//计算选择题数
		var count = rado.length / 4;
		for(var i =0; i<count; i++){
			for(var j = i*4; j < (i+1)*4 ; j++){
				temp ++;
				if(rado.item(j).checked){
					StuAn.push(rado.item(j).value);
					temp = 0;
				}
				rado[i].setAttribute("disabled","true");
			}
			if(temp == 4){
				StuAn.push("你的答案为空");
				temp = 0;
			}
			temp = 0;
		}

		//比较学生答案和标准答案
		var compare =  comperArray(StuAn,window.init.selAnswer,window.init.selcount);
		//添加span对象，显示结果
		for(var j = 0 ; j<sign.length;j++){
			var h1 = document.createElement("h1");
			h1.style=(compare[j].isRight ==  0 ? "color: green;":"color: red;");
			h1.innerHTML=(compare[j].isRight ==  0 ? "正确":"错误")+
			"&nbsp;你的答案:"+compare[j].yourAn+
			"&nbsp;正确答案:"+compare[j].An;
//			sign[j].append(h1);
			$(sign[j]).append(h1);
			//计算
			if(compare[j].isRight){
				window.scoreMsg.SelScore +=0;
			}else{
				window.scoreMsg.SelScore += window.score.sel;
			}
			
		}
	}
	
	//两个数组比较
	function comperArray(stuAn,answer,count){
		var total = 0;
		var validate = new Array();
		for (var i  = 0; i< count; i++) {
			var res = {
			"isRight":"",
			"yourAn":stuAn[i],
			"An":answer[i]
			}
			if(stuAn[i] == answer[i]){
				res.isRight = 0;
				validate.push(res);
			}else{
				res.isRight = 1;
				validate.push(res);
			}
		}
		return validate;
	}
})();
