<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script src="${path}/resources/js/board.js"></script>
<title>게시글 수정</title>
<style>
    body {
        font-family: Arial, sans-serif;
        display: flex;
        flex-direction: column;
        justify-content: center;
        align-items: center;
        min-height: 100vh;
        margin: 0;
    }
    form {
        width: 500px; /* 원하는 폭으로 조절하세요 */
        padding: 10px;
        border: 1px solid #ccc;
        border-radius: 4px;
    }
    input[type="text"] {
        width: 80%;
        padding: 10px;
        margin-bottom: 10px;
        border: 1px solid #ccc;
        border-radius: 4px;
    }
    button {
        padding: 10px 20px;
        background-color: #4CAF50;
        color: white;
        border: none;
        border-radius: 4px;
        cursor: pointer;
    }
    button:hover {
        background-color: #45a049;
    }
</style>
</head>
<body>
<form id="role">
    <input type="hidden" value="${view.seq}" name="seq" id="seq">
    <h2>게시글 수정</h2>
    <div>
        제목 : 
        <input type="text" id="subject" name="subject" placeholder="제목" value="${view.subject}">
    </div>
    <div>
        작성자 : 
        <input type="text" id="name" name="name" placeholder="작성자" readonly="readonly" value="${view.name}">
    </div>
    <div>
     <p>내용 </p>
    <textarea id="content" class="con" name="content" placeholder="내용" rows="5" style="width: 465px; height: 57px;">${view.content}</textarea>
</div>
    
    <button type="button" onclick="fn_boardUpdate();">수정</button>
</form>
</body>
</html>
