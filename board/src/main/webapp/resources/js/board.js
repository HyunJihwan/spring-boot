/**
 * 
 */
 
function fn_boardRegi(){
	var subject = $("#subject").val();
	var name = $("#name").val();
	var content = $("#content").val();
	
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