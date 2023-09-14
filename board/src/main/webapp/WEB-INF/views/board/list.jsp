<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판입니다</title>
</head>
<body>
<table>
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
  				 <td>${b.subject}</td>
				 <td>${b.content}</td>
 				 <td>${b.name}</td>
 				 <td>${b.reg_date}</td>
 				 <td>${b.readCount}</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
</body>
</html>