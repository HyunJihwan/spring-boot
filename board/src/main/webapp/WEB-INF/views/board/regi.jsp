<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script src="${path}/resources/js/board.js"></script>
    <meta charset="UTF-8">
    <title>게시판 등록</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f5f5f5;
            margin: 0;
            padding: 0;
        }

        #frm {
            max-width: 400px;
            margin: 20px auto;
            background-color: #fff;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        input[type="text"] {
            width: 100%;
            padding: 10px;
            margin-bottom: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }

        button#board_regi {
            background-color: #007bff;
            color: #fff;
            border: none;
            padding: 10px 20px;
            border-radius: 5px;
            cursor: pointer;
        }

        button#board_regi:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
    <form id="frm">
        <h2>게시판 등록</h2>
        <input type="text" placeholder="아이디" value=${user.id } readonly >
        <input type="text" placeholder="제목" id="subject" name="subject">
        <input type="text" placeholder="작성자" id="name" name="name" value="${user.name}" readonly >
        <textarea placeholder="내용" id="content" name="content" rows="4" style="width: 410px; height: 113px;"></textarea>
        <button type="button" id="board_regi" onclick="fn_boardRegi();">등록</button>
    </form>
</body>

  <script>
 
    </script>

</html>
