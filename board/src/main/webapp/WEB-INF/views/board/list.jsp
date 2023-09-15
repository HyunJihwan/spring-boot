<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script src="${path}/resources/js/board.js"></script>
<title>게시판입니다</title>
</head>
<body>
<form id="role">
<table>
	<input type="hidden" value="" name="seq" id="seq">
	<thead>
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>내용</th>
			<th>작성자</th>
			<th>날짜</th>
			<th>조회수</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${list}" var="b">
			<tr>
				 <td>${b.seq}</td>
  				 <td><a href="/board/view?seq=${b.seq}" onclick="fn_goView(${b.seq})">${b.subject}</a></td>
				 <td>${b.content}</td>
 				 <td>${b.name}</td>
 				 <fmt:parseDate value="${b.reg_date}" var="dateValue" pattern="yyyyMMddHHmmss"/> 
 				 <td><fmt:formatDate value="${dateValue}" pattern="yyyy-MM-dd"/></td>
 				 <td>${b.readCount}</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
<button type="button" onclick="location.href='/board/regiView'">글작성</button>
</form>
</body>
</html>