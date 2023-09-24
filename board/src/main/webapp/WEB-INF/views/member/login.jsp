<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <script src="${path}/resources/js/member.js"></script>
    <title>로그인</title>
</head>
<body>
    <div class="container mt-5">
        <div class="row justify-content-center">
            <div class="col-md-6">
                <div class="card">
                    <div class="card-header">로그인</div>
                    <div class="card-body">
                        <form id="frm">
                            <div class="form-group">
                                <label for="id">아이디:</label>
                                <input type="text" class="form-control" id="id" name="id">
                            </div>
                            <div class="form-group">
                                <label for="password">비밀번호:</label>
                                <input type="password" class="form-control" id="password" name="password">
                            </div>
                            <button type="button" class="btn btn-primary" onclick="fn_login();">로그인</button>
                            <button type="button" class="btn btn-secondary" onclick='location.href="/member/joinForm"'>회원가입</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
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
</body>
</html>
