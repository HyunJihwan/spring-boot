<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<%-- <script src="${path}/resources/js/board.js"></script> --%>
<title>Insert title here</title>
</head>
<body>
<form id="frm">
<input type="text" placeholder="제목" id="subject" name="subject">
<input type="text" placeholder="작성자" id="name" name="name">
<input type="text" placeholder="내용" id="content" name="content"> 
<button type="button" id="board_regi" onclick="fn_boardRegi();">등록</button>
</form>
</body>

<script>
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
</script>

</html>