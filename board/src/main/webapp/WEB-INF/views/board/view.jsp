<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script src="${path}/resources/js/board.js"></script>
<title>게시글 상세 정보</title>
<style>
    body {
        font-family: Arial, sans-serif;
        margin: 20px;
        padding: 10px;
    }
    .btn {
        margin-right: 10px;
    }
</style>
</head>
<body>
<form id="role">
    <input type="hidden" value="" name="seq" id="seq">
    <h2>${view.subject}</h2>
    <div>작성자: ${view.name}</div>
    <div>조회수: ${view.readCount}</div>
    <hr>
    <div>${view.content}</div>
    <hr>
    <button type="button" class="btn" onclick='location.href="/board/list"'>목록</button>
    <button type="button" class="btn" onclick='fn_goUpdateView(${view.seq})'>수정</button>
    <button type="button" class="btn" onclick='fn_boardDelete(${view.seq})'>삭제</button>
</form>
</body>
</html>
