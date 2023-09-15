/**
 * 
 */
 
function fn_boardRegi(){
	var subject = $("#subject").val();
	var name = $("#name").val();
	var content = $("#content").val();
	
	if (subject === "" || name === "" || content === "") {
                alert("빈 칸을 모두 채워주세요.");
                return;
      }
	
	
	$.ajax({
		type : "POST",
		url : "/board/regi",
		data : {subject : subject, name : name, content : content},
		success: function(data){
			if(data == "Y"){
				alert("글 등록이 완료되었습니다.");
				location.href = "/board/list";		
			}
		},
		error: function(data){
			alert("실패");
			console.log(data);
		}
	});
	
	  
};

function fn_goView(seq){
	$("#seq").val(seq);

	var f = $("#role");
	f.attr("action", "/board/view");
	f.attr("method", "GET");
	f.submit();
	
};

function fn_goUpdateView(seq){
	$("#seq").val(seq);

	var f = $("#role");
	f.attr("action", "/board/goUpdateView");
	f.attr("method", "GET");
	f.submit();
};

function fn_boardUpdate(seq){
	var seq = $("#seq").val();
	var subject = $("#subject").val();
	var name = $("#name").val();
	var content = $("#content").val();

	$.ajax({
		type : "POST",
		url : "/board/update",
		data : {seq: seq, subject : subject, name : name, content : content},
		success: function(data){
			if(data == "Y"){
				alert("글 수정이 완료되었습니다.");
				fn_goView(seq);
			}else{
				alert("글 수정이 실패되었습니다.");
			}
		},
		error: function(data){
			alert("실패");
			console.log(data);
		}
	});
	
};

function fn_boardDelete(seq){
	
	
};


