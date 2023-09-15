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
<form id="role">
<div>제목 : ${view.subject} 조회수 : ${view.readCount}</div>
<div>작성자 : ${view.name}</div>
<div>내용 : ${view.content} </div>
<button type="button" onclick='location.href="/board/list"'>목록</button>
<button type="button" onclick='fn_goUpdateView(${view.seq})'>수정</button>
<button type="button" onclick='fn_boardDelete(${view.seq})'>삭제</button>
</form>
</body>

<script>
function fn_goView(seq){
	$("#seq").val(seq);

	var f = $("#role");
	f.attr("action", "/board/view");
	f.attr("method", "GET");
	f.submit();
	
};

function fn_goUpdateView(seq){
	
	
};

function fn_boardDelete(seq){
	
	
};

</script>

</html>