
	gettime();
	var choice = document.getElementsByClassName("choice");
	var shanjiao = document.getElementsByClassName("shanjiao");
	var xiala = document.getElementsByClassName("xiala");
	var li_tag = document.getElementsByClassName("li-tag");
	var gongneng = document.getElementsByClassName('gongneng');
	for(var i=0;i<choice.length;i++){
		choice[i].index=i;
		li_tag[i].index=i;
	}
	for(var i=0;i<li_tag.length;i++){
		li_tag[i].index=i;
	}
	for(var j =0;j<choice.length;j++){
		choice[j].addEventListener('click',function(){
			if(xiala[this.index].style.display!=='none'){
				xiala[this.index].style.display='none';
				shanjiao[this.index].setAttribute('src', 'img/ico04.gif');
			}else{
				xiala[this.index].style.display='block';
				shanjiao[this.index].setAttribute('src', 'img/ico03.gif');
			}
			
			
		})
		
	}
	for(var n = 0; n<li_tag.length;n++){
		li_tag[n].addEventListener('click',function(){
			for(var k=0;k<li_tag.length;k++){
				li_tag[k].getElementsByTagName('img')[0].setAttribute('src','img/ico06.gif');
				gongneng[k].style.display="none";
			}
			this.getElementsByTagName('img')[0].setAttribute('src','img/ico05.gif');
			gongneng[this.index].style.display="block";
			if(this.index==3){
				teachersearch();
			}
			else if(this.index==2){
				scoresearch();
			}	
			else if(this.index==5){
				examtimesearch();
			}
		})
	}
	function gettime(){
	 	var show_day=new Array('星期日','星期一','星期二','星期三','星期四','星期五','星期六');
	 	var date = new Date();
		var seperator1 = "-";
	    var seperator2 = ":";
	    var month = date.getMonth() + 1;
	    var strDate = date.getDate();
	    if (month >= 1 && month <= 9) {
	        month = "0" + month;
	    }
	    if (strDate >= 0 && strDate <= 9) {
	        strDate = "0" + strDate;
	    }
	    var currentdate = date.getFullYear() + "年" + month + "月" + strDate
	            + "日"+"&nbsp;"+show_day[date.getDay()] ;
	    var currenttime= date.getHours() + "时" + date.getMinutes()
	            + "分" + date.getSeconds()+"秒";
	    document.getElementById("current_date").innerHTML=currentdate;
	    document.getElementById("current_time").innerHTML=currenttime;
		setTimeout("gettime()",1000); 
	}
	
	//学生管理
	studentsearch();
	function studentsearch(){
		$.ajax({
			cache: true,
			type: "POST",
			url:"getstudents.action",
			data:"",// 你的formid
			async: false,
			error: function(request) {
				alert("Connection error");
			},
			success: function(data) {
				console.log(data);
				var o = JSON.parse(data);
				var str="<table border='0' cellspacing='5' cellpadding='2' align='center'><tr><th>学号</th><th>名字</th><th>密码</th><th>性别</th><th>院系</th><th>专业</th><th>班级</th></tr>";
				for(var i =0;i<o.length;i++){
				  str += "<tr>";
			      str += "<td>"+o[i].stuNum+"</td>";
			      str += "<td>"+o[i].stuName+"</td>";
			      str += "<td>"+o[i].password+"</td>";
			      str += "<td>"+o[i].sex+"</td>";
			      str += "<td>"+o[i].department+"</td>";
			      str += "<td>"+o[i].major+"</td>";
			      str += "<td>"+o[i].classNum+"</td>";
			      str += "</tr>";
				}
				str+="</table>";
				console.log(str);
				$("#student-info").html(str);
			}
		});
	}
	
	//根据学号检索
	$("#studentjiansuo").on('click',studentjiansuo);
	function studentjiansuo(){
		$.ajax({
			cache: true,
			type: "POST",
			url:"getstudent.action",
			data:$('#form1').serialize(),// 你的formid
			async: false,
			error: function(request) {
				alert("Connection error");
			},
			success: function(data) {
				if(data!==""&&data!==null){
					var o = JSON.parse(data);
					var str="<table border='0' cellspacing='5' cellpadding='2' align='center'><tr><th>学号</th><th>名字</th><th>密码</th><th>性别</th><th>院系</th><th>专业</th><th>班级</th></tr>";
					for(var i =0;i<o.length;i++){
					  str += "<tr>";
					  str += "<td>"+o[i].stuNum+"</td>";
				      str += "<td>"+o[i].stuName+"</td>";
				      str += "<td>"+o[i].password+"</td>";
				      str += "<td>"+o[i].sex+"</td>";
				      str += "<td>"+o[i].department+"</td>";
				      str += "<td>"+o[i].major+"</td>";
				      str += "<td>"+o[i].classNum+"</td>";
				      str += "</tr>";
					}
					str+="</table>";
					console.log(str);
					$("#student-info").html(str);
				}else{
					alert("查找失败！");
				}
				
			}
		});
	}
	

	$("#stu_addclick").on('click',addstudent);
	function addstudent(){
		$.ajax({
			cache: true,
			type: "POST",
			url:"addstudent.action",
			data:$('#form2').serialize(),// 你的formid
			async: false,
			error: function(request) {
				alert("Connection error");
			},
			success: function(data) {
				alert(data);
				
			}
		});
	 }
	

	$("#stu_updateclick").on('click',updatestudent);
	function updatestudent(){
		$.ajax({
			cache: true,
			type: "POST",
			url:"updatestudent.action",
			data:$('#form2').serialize(),// 你的formid
			async: false,
			error: function(request) {
				alert("Connection error");
			},
			success: function(data) {
				alert(data);
				
			}
		});
	 }
	
	//成绩查询
	function scoresearch(){
		
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
			cache: true,
			type: "POST",
			url:"run.action?sign=8",
			data:"",// 你的formid
			async: false,
			error: function(request) {
				alert("Connection error");
			},
			success: function(data) {
				
				
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
				
				$("#student-score").html("");
				$("#student-score").html(html);
			}
		});
	}
	
	
	
	//教师管理
	
	function teachersearch(){
		$.ajax({
			cache: true,
			type: "POST",
			url:"getteachers.action",
			data:"",// 你的formid
			async: false,
			error: function(request) {
				alert("Connection error");
			},
			success: function(data) {
				console.log(data);
				var o = JSON.parse(data);
				var str="<table border='0' cellspacing='5' cellpadding='2' align='center'><tr><th>职工号</th><th>姓名</th><th>密码</th><th>院系</th><th>科目</th></tr>";
				for(var i =0;i<o.length;i++){
				  str += "<tr>";
			      str += "<td>"+o[i].TeaNum+"</td>";
			      str += "<td>"+o[i].TeaName+"</td>";
			      str += "<td>"+o[i].password+"</td>";
			      str += "<td>"+o[i].department+"</td>";
			      str += "<td>"+o[i].subject+"</td>";
			      str += "</tr>";
				}
				str+="</table>";
				console.log(str);
				$("#teacher-info").html(str);
			}
		});
	}

	//根据教师职工号检索
	
	
	$("#teacherjiansuo").on('click',teacherjiansuo);
	function teacherjiansuo(){
		$.ajax({
			cache: true,
			type: "POST",
			url:"getteacher.action",
			data:$('#form4').serialize(),// 你的formid
			async: false,
			error: function(request) {
				alert("Connection error");
			},
			success: function(data) {
				if(data!==""&&data!==null){
					var o = JSON.parse(data);
					var str="<table border='0' cellspacing='5' cellpadding='2' align='center'><tr><th>职工号</th><th>姓名</th><th>密码</th><th>院系</th><th>科目</th></tr>";
					for(var i =0;i<o.length;i++){
					  str += "<tr>";
					  str += "<td>"+o[i].TeaNum+"</td>";
				      str += "<td>"+o[i].TeaName+"</td>";
				      str += "<td>"+o[i].password+"</td>";
				      str += "<td>"+o[i].department+"</td>";
				      str += "<td>"+o[i].subject+"</td>";
				      str += "</tr>";
					}
					str+="</table>";
					console.log(str);
					$("#teacher-info").html(str);
				}else{
					alert("查询失败！");
				}
			}
		});
	}

	
	
	$("#tea_addclick").on('click',addteacher);
	function addteacher(){
		console.log($('#form5').serialize());
		$.ajax({
			cache: true,
			type: "POST",
			url:"addteacher.action",
			data:$('#form5').serialize(),// 你的formid
			async: false,
			error: function(request) {
				alert("Connection error");
			},
			success: function(data) {
				alert(data);
				
			}
		});
	 }
	

	$("#tea_updateclick").on('click',updateteacher);
	function updateteacher(){
		$.ajax({
			cache: true,
			type: "POST",
			url:"updateteacher.action",
			data:$('#form5').serialize(),// 你的formid
			async: false,
			error: function(request) {
				alert("Connection error");
			},
			success: function(data) {
				alert(data);
				
			}
		});
	 }
	
	
	//考试安排
	
	function examtimesearch(){
		$.ajax({
			cache: true,
			type: "POST",
			url:"getexamtimes.action",
			data:"",// 你的formid
			async: false,
			error: function(request) {
				alert("Connection error");
			},
			success: function(data) {
				var o = JSON.parse(data);
				var str="<table border='0' cellspacing='5' cellpadding='2' align='center'><tr><th>科目</th><th>考试时长</th><th>考试日期</th><th>开始时间</th><th>结束时间</th></tr>";
				for(var i =0;i<o.length;i++){
				  str += "<tr>";
			      str += "<td>"+o[i].subject+"</td>";
			      str += "<td>"+o[i].examTime+"</td>";
			      str += "<td>"+o[i].examDate+"</td>";
			      str += "<td>"+o[i].beginTime+"</td>";
			      str += "<td>"+o[i].endTime+"</td>";
			      str += "</tr>";
				}
				str+="</table>";
				console.log(str);
				$("#examtime-info").html(str);
			}
		});
	}
	
	
	//根据科目名进行检索
	$("#examjiansuo").on('click',examjiansuo);
	
	function examjiansuo(){
		$.ajax({
			cache: true,
			type: "POST",
			url:"getexamtime.action",
			data:$('#form6').serialize(),// 你的formid
			async: false,
			error: function(request) {
				alert("Connection error");
			},
			success: function(data) {
				if(data!==""&&data!==null){
					var o = JSON.parse(data);
					var str="<table border='0' cellspacing='5' cellpadding='2' align='center'><tr><th>科目</th><th>考试时长</th><th>考试日期</th><th>开始时间</th><th>结束时间</th></tr>";
					for(var i =0;i<o.length;i++){
					  str += "<tr>";
					  str += "<td>"+o[i].subject+"</td>";
				      str += "<td>"+o[i].examTime+"</td>";
				      str += "<td>"+o[i].examDate+"</td>";
				      str += "<td>"+o[i].beginTime+"</td>";
				      str += "<td>"+o[i].endTime+"</td>";
				      str += "</tr>";
					}
					str+="</table>";
					console.log(str);
					$("#examtime-info").html(str);
				}else{
					alert("检索失败！");
				}
				
			}
		});
	}
	
	
	
	
	$("#addexamtime").on('click',addexamtime);
	function addexamtime(){
		console.log($('#form7').serialize());
		$.ajax({
			cache: true,
			type: "POST",
			url:"addexamtime.action",
			data:$('#form7').serialize(),// 你的formid
			async: false,
			error: function(request) {
				alert("Connection error");
			},
			success: function(data) {
				alert(data);
				
			}
		});
	 }
	

	$("#updateexamtime").on('click',updateexamtime);
	function updateexamtime(){
		$.ajax({
			cache: true,
			type: "POST",
			url:"updateexamtime.action",
			data:$('#form7').serialize(),// 你的formid
			async: false,
			error: function(request) {
				alert("Connection error");
			},
			success: function(data) {
				alert(data);
				
			}
		});
	 }
	
	
	//管理员密码修改
	$("#adminmodify").on('click',adminmodify);
	
	function adminmodify(){
		$.ajax({
			cache: true,
			type: "POST",
			url:"adminmodify.action",
			data:$('#form8').serialize(),// 你的formid
			async: false,
			error: function(request) {
				alert("Connection error");
			},
			success: function(data) {
				if(data!==""&&data!==null){
					alert(data);
				}else{
					alert("更新失败！");
				}
			}
		});
	}
function teacherSearch(){
		var sel = document.getElementsByName("Tsearch");
		var vail = document.getElementById("seaScore");
		var score_list = document.getElementById("score_list");
		
		var surl;
		//查找哪一个被选
		for(var i =0; i<=2; i++){
			if(sel[i].checked){
				sign = i+9;
			}
		}
		//组合URL
		if(sign == 10){
			surl = "run.action?sign="+sign+"&StuNum="+vail.value;
		}else if(sign == 11){
			surl = "run.action?sign="+sign+"&StuName="+escape(encodeURIComponent(vail.value));
		}else{
			surl = "run.action?sign="+sign+"&classNo="+vail.value;
		}
		
		
		$.ajax({
			type:"get",
			url:surl,
			dataType:"text",
			async:true,
			success: function(data){
				html = "";
				html = "<div>成绩列表</div>"+
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

