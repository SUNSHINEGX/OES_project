getTestList();
function getTestList(){
	document.getElementById("test_name").value="";
	document.getElementById("score_name").value="";
	//test_name.test();
	$.ajax({
		cache: true,
		type: "POST",
		url:"getTestList.action",
		//data:$('#formid1').serialize(),// 你的formid
		async: true,
		error: function(request) {
			alert("Connection error");
		},
		success: function(data) {
			var o = JSON.parse(data);
			var str="";
			for(var i =0;i<o.length;i++){
			  str +="<dt id='subject"+i+"'>"+o[i].subject+"</dt>";
			  str +="<dd>所属院系:计算机学院</dd>";
			  str +="<dd class='clearfix'><span>考试日期:"+o[i].examDate+"</span>";
			  str +="<span>开始时间:"+o[i].beginTime+"</span>";
			  str +="<span>结束时间:"+o[i].endTime+"</span>";
			  str +="<span class='examtime'>"+o[i].examTime+"</span>";
			  str +="<button class='btn'>开始考试</button>";
			  str +="</dd>"
			}			
			console.log(str);
			$("#testlist_id").html(str);	
			$(".btn").click(function(){
				var subject = $(this).parent().prev().prev().text();
				var examTime = $(this).prev().text();
				var userName = $("#userName").text().trim();
				var classNum = $("#classNum").text().trim();
				var stuNum = $("#stuNum").text().trim();
				window.location=encodeURI(encodeURI("startexam.action?StuName="+userName+"&StuNum="+stuNum+"&classNum="+classNum+"&subject="+subject+"&time="+examTime));
			})
		}
		
	});
	
}

function check_score(){
	//alert(1)
	$.ajax({
		cache: true,
		type: "POST",
		url:"checkScore.action",
		//data:$('#formid1').serialize(),// 你的formid
		async: true,
		error: function(request) {
			alert("Connection error");
		},
		success: function(data) {
			var o = JSON.parse(data);
			var str="";
			for(var i =0;i<o.length;i++){
			  str +="<tr class='subject_t'><th colspan='5'>"+o[i].subject+"</th></tr>";
			  str +="<tr class='topic_tr'><td>选择题</td><td>填空题</td><td>问答题</td><td>总分</td><td></td></tr>";
			  str +="<tr class='score_tr'><td>"+o[i].selScore+"分</td>";
			  str +="<td>"+o[i].fillScore+"分</td>";
			  str +="<td>"+o[i].qaScore+"分</td>";
			  str +="<td>"+o[i].total+"分</td>";
			  str +="<td><a class='review_a' href='"+o[i].address+"'>试卷回顾</a></td>";
			  str +="</tr>";
			}
			console.log(str);
			$("#score_table").html(str);			
		}
	});
}

function getTest(){
	var test_name=document.getElementById("test_name").value;
	$.ajax({
		cache: true,
		type: "POST",
		url:"findTest.action?test_name="+test_name,
		//data:$('#formid1').serialize(),// 你的formid
		async: true,
		error: function(request) {
			alert("Connection error");
		},
		success: function(data) {
			var o = JSON.parse(data);
			var str="";
			for(var i =0;i<o.length;i++){
			  str +="<dt id=subject'"+i+"'>"+o[i].subject+"</dt>";
			  str +="<dd>所属院系:计算机学院</dd>";
			  str +="<dd class='clearfix'><span>考试日期:"+o[i].examDate+"</span>";
			  str +="<span>开始时间:"+o[i].beginTime+"</span>";
			  str +="<span>结束时间:"+o[i].endTime+"</span>";
			  str +="<button onclick='beginTest("+i+")' id='btn'>开始考试</button>";
			  str +="</dd>"
			}
			console.log(str);
			$("#testlist_id").html(str);			
		}
	});
}

function findScore(){
	var score_name=document.getElementById("score_name").value;
	$.ajax({
		cache: true,
		type: "POST",
		url:"findScore.action?score_name="+score_name,
		//data:$('#formid1').serialize(),// 你的formid
		async: true,
		error: function(request) {
			alert("Connection error");
		},
		success: function(data) {
			//alert(1);
			var o = JSON.parse(data);
			var str="";
			for(var i =0;i<o.length;i++){
			  str +="<tr class='subject_t'><th colspan='5'>"+o[i].subject+"</th></tr>";
			  str +="<tr class='topic_tr'><td>选择题</td><td>填空题</td><td>问答题</td><td>总分</td><td></td></tr>";
			  str +="<tr class='score_tr'><td>"+o[i].selScore+"</td>";
			  str +="<td>"+o[i].fillScore+"分</td>";
			  str +="<td>"+o[i].qaScore+"分</td>";
			  str +="<td>"+o[i].total+"分</td>";
			  str +="<td><a class='review_a' href='"+o[i].address+"'>试卷回顾</a></td>";
			  str +="</tr>";
			}
			console.log(str);
			$("#score_table").html(str);	
		}
	});
}

function stu_info(){
	document.getElementById("score_name").value="";
	$.ajax({
		cache: true,
		type: "POST",
		url:"stuInfo.action",
		//data:$('#formid1').serialize(),// 你的formid
		async: true,
		error: function(request) {
			alert("Connection error");
		},
		success: function(data) {
			var o = JSON.parse(data);
			var str="";
			for(var i =0;i<o.length;i++){
			  str +="<tr><td>学&nbsp;&nbsp;号：</td><td>"+o[i].stuNum+"</td>";
			  str +="<tr><td>密&nbsp;&nbsp;码：</td><td>"+o[i].password+"</td>";
			  str +="<tr><td>姓&nbsp;&nbsp;名：</td><td>"+o[i].stuName+"</td>";
			  str +="<tr><td>性&nbsp;&nbsp;别：</td><td>"+o[i].sex+"</td>";
			  str +="<tr><td>院&nbsp;&nbsp;系：</td><td>"+o[i].department+"</td>";
			  str +="<tr><td>专&nbsp;&nbsp;业：</td><td>"+o[i].major+"</td>";
			  str +="<tr><td>班&nbsp;&nbsp;级：</td><td>"+o[i].classNum+"</td>";
			}
			console.log(str);
			$("#stuInfo_id").html(str);
		}
	});
}


