window.onload = function(){
	geren();
}


$(".body .left .xia ul li h3").click(function(){
	if($(this).next().css("display")=="none"){
		$(this).children().attr("src","img/ico03.gif");
		$(this).next().css("display","block");
	}else{
		$(this).children().attr("src","img/ico04.gif");
		$(this).next().css("display","none");
	}
})


$(".body .left .xia ul li ol li").click(function(){
	$(".body .left .xia ul li ol li img").attr("src","img/ico06.gif");
	$(this).children().attr("src","img/ico05.gif");
	$(".body .right div").css("display","none");
	$("."+$(this).attr("class")).css("display","block").children("div").css("display","block");
})

$(".tixing #tianjia").click(function(){
	var xuanzefen = (parseInt($("#xuanjian").val())+parseInt($("#xuannan").val()))*parseInt($("#xuanfen").val());
	var tiankongfen = (parseInt($("#tianjian").val())+parseInt($("#tiannan").val()))*parseInt($("#tianfen").val());
	var wendafen = (parseInt($("#wenjian").val())+parseInt($("#wennan").val()))*parseInt($("#wenfen").val());
	if((xuanzefen+tiankongfen+wendafen)!= 100){
		alert("添加失败！不等于100分");
		return;
	}
	var subject = $("td[name=subject]").text();
	$.ajax({
		cache:true,
		type:"POST",
		url:"exampaper.action?flag="+subject,
		data:$("#tixingshezhi").serialize(),
		async:false,
		error:function(request){
			alert("添加失败！");
		},
		success:function(data){
			alert(data);
		}
	});
})

$(".gaimi #tijiao").click(function(){
	if($("input[type=password]").val()==""){
		alert("密码不能为空！");
		return;
	}
	var TeaNum = $("td[name=TeaNum]").text();
	$.ajax({
		cache:true,
		type:"POST",
		url:"gaimi.action?flag="+TeaNum,
		data:$("#changepassword").serialize(),
		async:false,
		error:function(request){
			alert("修改失败！");
		},
		success:function(data){
			alert("修改成功!");
		}
	});
})


function geren(){
	var TeaNum = $("td[name=TeaNum]").text();
	$.ajax({
		cache:true,
		type:"POST",
		url:"geren.action?flag="+TeaNum,
		async:false,
		error:function(request){
			alert("获取失败！");
		},
		success:function(data){
			var o = JSON.parse(data);
			$("td[name=TeaName]").text(o[0].TeaName);
			$("td[name=department]").text(o[0].department);
			$("td[name=subject]").text(o[0].subject);
		}
	});
}

$(".gaixuan #tianjia").click(function(){
	var subject = $("td[name=subject]").text();
	$.ajax({
		cache:true,
		type:"POST",
		url:"choice.action?flag="+subject,
		data:$("#xuanzeti").serialize(),
		async:false,
		error:function(request){
			alert("添加失败！");
		},
		success:function(data){
			alert("添加成功！");
		}
	});
})

$(".gaitian #tianjia").click(function(){
	var subject = $("td[name=subject]").text();
	$.ajax({
		cache:true,
		type:"POST",
		url:"tiankong.action?flag="+subject,
		data:$("#tiankongti").serialize(),
		async:false,
		error:function(request){
			alert("添加失败！");
		},
		success:function(data){
			alert("添加成功！");
		}
	});
})

$(".gaiwen #tianjia").click(function(){
	var subject = $("td[name=subject]").text();
	$.ajax({
		cache:true,
		type:"POST",
		url:"wenda.action?flag="+subject,
		data:$("#wendati").serialize(),
		async:false,
		error:function(request){
			alert("添加失败！");
		},
		success:function(data){
			alert("添加成功！");
		}
	});
})

$(".chaxuan input[type=button]").click(function(){
	$("#choiceti").siblings().remove();
	$(".xuanzetineirong").html("");
	if($("#chaxuan").val()==""){
		alert("查找内容不能为空！");
		return;
	}
	var chaxuan = $("#chaxuan").val();
	$.ajax({
		cache:true,
		type:"POST",
		url:"chaxuan.action?flag="+chaxuan,
		async:false,
		error:function(request){
			alert("查询失败！");
		},
		success:function(data){
			
			var o = JSON.parse(data);
			for(var i=0;i<o.length;i++){
				$("#choiceti").after("<tr><td>"+o[i].SelTop+"</td>"+"<td name='ch"+i+"'>查看详情</td></tr>");
			}
			for(var i=0;i<o.length;i++){
				$(".xuanzetineirong").append("<div class='ch"+i+"'><h1>查看选择题</h1><b>题  目:</b><p>" +
						o[i].SelTop+"</p><b>选项A:</b><p>" +
						o[i].A+"</p><b>选项B:</b><p>" +
						o[i].B+"</p><b>选项C:</b><p>" +
						o[i].C+"</p><b>选项D:</b><p>" +
						o[i].D+"</p><b>答 案:</b><p>" +
						o[i].answer+"</p><b>难 度:</b><p>" +
						o[i].level+"</p></div>");
			}
			$(".chaxuan table tr td:nth-child(2n)").click(function(){
				$(".body .right div").css("display","none");
				$(".xuanzetineirong").css("display","block");
				$("."+$(this).attr("name")).css("display","block");
			});
		}
	});
})

$(".chatian input[type=button]").click(function(){
	$("#tiankongti").siblings().remove();
	$(".tiankongtineirong").html("");
	if($("#chatian").val()==""){
		alert("查找内容不能为空！");
		return;
	}
	var chatian = $("#chatian").val();
	$.ajax({
		cache:true,
		type:"POST",
		url:"chatian.action?flag="+chatian,
		async:false,
		error:function(request){
			alert("查询失败！");
		},
		success:function(data){
			
			var o = JSON.parse(data);
			for(var i=0;i<o.length;i++){
				$("#tiankongti").after("<tr><td>"+o[i].FillTop+"</td>"+"<td name='tian"+i+"'>查看详情</td></tr>");
			}
			for(var i=0;i<o.length;i++){
				$(".tiankongtineirong").append("<div class='tian"+i+"'><h1>查看填空题</h1><b>题  目:</b><p>" +
						o[i].FillTop+"</p><b>答 案:</b><p>" +
						o[i].answer+"</p><b>难 度:</b><p>" +
						o[i].level+"</p></div>");
			}
			$(".chatian table tr td:nth-child(2n)").click(function(){
				$(".body .right div").css("display","none");
				$(".tiankongtineirong").css("display","block");
				$("."+$(this).attr("name")).css("display","block");
			});
		}
	});
})

$(".chawen input[type=button]").click(function(){
	$("#wendati").siblings().remove();
	$(".wendatineirong").html("");
	if($("#chawen").val()==""){
		alert("查找内容不能为空！");
		return;
	}
	var chawen = $("#chawen").val();
	$.ajax({
		cache:true,
		type:"POST",
		url:"chawen.action?flag="+chawen,
		async:false,
		error:function(request){
			alert("查询失败！");
		},
		success:function(data){
			
			var o = JSON.parse(data);
			for(var i=0;i<o.length;i++){
				$("#wendati").after("<tr><td>"+o[i].QaTop+"</td>"+"<td name='wen"+i+"'>查看详情</td></tr>");
			}
			for(var i=0;i<o.length;i++){
				$(".wendatineirong").append("<div class='wen"+i+"'><h1>查看问答题</h1><b>题  目:</b><p>" +
						o[i].QaTop+"</p><b>难 度:</b><p>" +
						o[i].level+"</p></div>");
			}
			$(".chawen table tr td:nth-child(2n)").click(function(){
				$(".body .right div").css("display","none");
				$(".wendatineirong").css("display","block");
				$("."+$(this).attr("name")).css("display","block");
			});
			
		}
	});
})

$("#wendapigaianniu").click(function(){
	chawen2();
});
function chawen2(){
	chawen();
	$(".wendapigai").css("display","block");
	$(".wendapigai").children("div").css("display","block");
}
function chawen(){
	$("#wendapigai").siblings().remove();
	$(".wendatipigaineirong").html("");
	var subject = $("td[name=subject]").text();
	$.ajax({
		cache:true,
		type:"POST",
		url:"studentqa.action?flag="+subject,
		async:false,
		error:function(request){
			alert("查询失败！");
		},
		success:function(data){
			var o = JSON.parse(data);
			for(var i=0;i<o.length;i++){
				$("#wendapigai").after("<tr><td>"+o[i].StuNum+"</td><td>"+o[i].QaTop+"</td><td name='pi"+i+"'>批改</td></tr>");
			}
			for(var i=0;i<o.length;i++){
				$(".wendatipigaineirong").append("<div class='pi"+i+"'><h1>批改问答题</h1><b>学号:</b><p name='stu'>" +
						o[i].StuNum+"</p><b>题目:</b><p name='QATOP'>" +
						o[i].QaTop+"</p><b>答案:</b><p>" +
						o[i].answer+"</p><b>打分:</b><input type='text'/><input type='button' id='pi" +
								i+"'value='提交' /></div>");
			}
			
			$(".wendapigai table tr td:nth-child(3n)").click(function(){
				$(".body .right div").css("display","none");
				$(".wendatipigaineirong").css("display","block");
				$("."+$(this).attr("name")).css("display","block");
				
				
				
			});
			
			$(".wendatipigaineirong input[type=button]").click(function(){
				
				var r=/^[0-9]+.?[0-9]*$/;
		        if(!r.test($(this).prev().val())){
		            alert('只能输入合法数字');
		            return;
		        }
				window.updateMsg ={
					StuNum:$(this).prevAll("p[name=stu]").text(),
					subject:$("td[name=subject]").text(),
					QaScore:$(this).prev().val(),
					Qatop:$(this).prevAll("p[name=QATOP]").text()
				}
					$.ajax({
						type:"get",
						url:"run.action?sign=7&StuNum="+window.updateMsg.StuNum+
							"&subject="+escape(encodeURIComponent(window.updateMsg.subject))+
							"&QaScore="+window.updateMsg.QaScore+
							"&Qatop="+escape(encodeURIComponent(window.updateMsg.Qatop))+
							"&StudenNum="+window.updateMsg.StuNum,
						async:true,
						success: function(data){
							alert("修改成功");
							chawen2();
						}
					});
				
			    
			});
		}
	});
}


$("#chafen1").click(function(){
	window.sub={
			subject:$("td[name=subject]").text()
	}
	var html = "";
	html = "<div class='head'>"+
				"<span>查看内容:</span>"+
				"<input type='radio' name='Tsearch' id='searchClass' checked='checked'/>"+
				"<label for='searchClass'>按班级</label>"+
				"<input type='radio' name='Tsearch' id='searchStuNum' />"+
				"<label for='searchStuNum'>按学号</label>"+
				"<input type='radio' name='Tsearch' id='searchStuName' />"+
				"<label for='searchStuName'>按姓名</label>"+
				"<input type='search' name='seaScore' id='seaScore' />"+
				"<input type='button' id='searchBtn' value='查询' onclick='teacherSearch()' /></div>"+
				"<div id='score_list'>"+
				"<div>成绩列表</div>"+
				"<table border='0' cellspacing='2' cellpadding='5' width='100%'>"+
				"<tr>"+
				"<th>学号</th>"+
				"<th>姓名</th>"+
				"<th>班级</th>"+
				"<th>选择</th>"+
				"<th>填空</th>"+
				"<th>问答</th>"+
				"<th>总分</th>"+
				"</tr>";
	
	$.ajax({
		type:"get",
		url:"run.action?sign=3&subject="+escape(encodeURIComponent(window.sub.subject)),
		dataType:"text",
		async:true,
		success: function(data){
			data = eval(data);
			for(var i =0; i<data.length;i++){
				html += "<tr>";
				html +=	"<td>"+data[i].stuNum+"</td>";
				html +=	"<td>"+data[i].stuName+"</td>";
				html +=	"<td>"+data[i].classNo+"</td>";
				html +=	"<td>"+data[i].selScore+"</td>";
				html +=	"<td>"+data[i].fillScore+"</td>";
				html +=	"<td>"+data[i].qaScore+"</td>";
				html +=	"<td>"+data[i].total+"</td>";
				html +=	"</tr>";
			}
			html += "</table></div>";
			$("#chafen2").html("") ;
			$("#chafen2").html(html);
			$("#chafen2 div").css('display','block');
		}
	});
});

function teacherSearch(){
	
	var sel = document.getElementsByName("Tsearch");
	var vail = document.getElementById("seaScore");
	var score_list = document.getElementById("score_list");
	
	var surl;
	//查找哪一个被选
	for(var i =0; i<=2; i++){
		if(sel[i].checked){
			sign = i+4;
		}
	}
	//组合URL
	if(sign == 5){
		surl = "run.action?sign="+sign+"&StuNum="+vail.value+
		'&subject='+escape(encodeURIComponent(window.sub.subject));
	}else if(sign == 6){
		surl = "run.action?sign="+sign+"&StuName="+escape(encodeURIComponent(vail.value))+
		'&subject='+escape(encodeURIComponent(window.sub.subject));
	}else{
		surl = "run.action?sign="+sign+"&classNo="+vail.value+
		'&subject='+escape(encodeURIComponent(window.sub.subject));
	}
	
	
	$.ajax({
		type:"get",
		url:surl,
		dataType:"text",
		async:true,
		success: function(data){
			html = "";
			html = "<div style='display:block'>成绩列表</div>"+
					"<table border='0' cellspacing='2' cellpadding='5' width='100%'>"+
					"<tr>"+
					"<th>学号</th>"+
					"<th>姓名</th>"+
					"<th>班级</th>"+
					"<th>选择</th>"+
					"<th>填空</th>"+
					"<th>问答</th>"+
					"<th>总分</th>"+
					"</tr>";
			data = eval(data);
			for(var i =0; i<data.length;i++){
				html += "<tr>";
				html +=	"<td>"+data[i].stuNum+"</td>";
				html +=	"<td>"+data[i].stuName+"</td>";
				html +=	"<td>"+data[i].classNo+"</td>";
				html +=	"<td>"+data[i].selScore+"</td>";
				html +=	"<td>"+data[i].fillScore+"</td>";
				html +=	"<td>"+data[i].qaScore+"</td>";
				html +=	"<td>"+data[i].total+"</td>";
				html +=	"</tr>";
			}
			html += "</div></div>";
			score_list.innerHTML = "";
			score_list.innerHTML = html;
		}
	});
}