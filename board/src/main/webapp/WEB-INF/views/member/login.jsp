<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<%-- <script src="${path}/resources/js/member.js"></script> --%>
<title>로그인</title>
</head>
<body>
<form id="frm">
<div>아이디 : <input type="text" id="id" name="id"></div>
<div>비밀번호 : <input type="password" id="password" name="password" ></div>
<button type="button" onclick="fn_login();">로그인</button>
<button type="button" onclick='location.href="/member/join"'>회원가입</button>
</form>
</body>

<script>

function fn_login(){
	var id = $("#id").val();
	var password = $("#password").val();
	
	$.ajax({
		type : "POST",
		url : "/member/login",
		data : {id : id, password : password},
		success: function(data){
			if(data == "Y"){
				location.href = "/board/list";		
			}else{
				alert("아이디 또는 비밀번호가 일치하지 않습니다.");
			}
		},
		error: function(data){
			alert("아이디 또는 비밀번호가 일치하지 않습니다.");
		}
	});
};

</script>

</html>