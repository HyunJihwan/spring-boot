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
    <button type="button" class="btn" id="del" data-seq="${view.seq}">삭제</button>
</form>
</body>
<script>
document.getElementById('del').addEventListener('click', function() {
    var seq = this.getAttribute('data-seq'); // data-seq 속성을 통해 글 번호를 가져옴

    var confirmed = confirm("정말 글을 삭제하시겠습니까?");

    if (confirmed) {
        // 사용자가 확인을 클릭한 경우
        $.ajax({
            type:"POST",
            url: "/board/delete", // 삭제 요청을 처리할 서버의 URL을 여기에 입력
            data: { seq: seq }, // 글 번호를 서버로 보냄
            success: function(data) {
                // 삭제 요청이 성공했을 때 처리
                if (data === "Y") {
                    alert("글 삭제가 완료되었습니다.");
                    location.href = "/board/list"; // 성공 시 목록 페이지로 이동 (예시)
                } else {
                    alert("글 삭제에 실패했습니다.");
                }
            },
            error: function(data) {
                // 삭제 요청이 실패했을 때 처리
                alert("글 삭제에 실패했습니다.");
                console.log(data);
            }
        });
    }
});
</script>

</html>
