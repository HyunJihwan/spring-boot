<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@ taglib prefix="pageObject" tagdir="/WEB-INF/tags"%>

<!DOCTYPE html>

<html>

<head>

<meta charset="UTF-8">

<title>게시판 리스트</title> ​

<!-- bootstrap 라이브러리 등록 - CDN 방식 : sitemesh에서 decorator.jsp에서 한꺼번에 해결-->

<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

​

<style type="text/css">
.dataRow:hover {
	background: #eee;
	cursor: pointer;
}
</style>

​

<script type="text/javascript">

$(function(){

​

${(empty msg)?"":"alert('" += msg += "');"}

​

$(".dataRow").click(function(){

var no = $(this).find(".no").text();

var query = ${(empty pageObject)?"''":"'&page=" += pageObject.page

+= "&perPageNum=" += pageObject.perPageNum += "'"};

location = "view.do?no=" + no + "&inc=1" + query;

});

});

</script>

​

</head>

<body>

	<div class="container">

		<h1>게시판 리스트</h1>

		<ul class="list-group">

			<c:if test="${empty boardList}">

				<!-- 데이터가 존재하지 않는 경우 -->

				<li class="list-group-item">데이터가 존재하지 않습니다.</li>

			</c:if>

			<c:if test="${!empty boardList }">

				<c:forEach items="${boardList }" var="vo">

					<li class="list-group-item dataRow">

						<div>

							<span class="no">${vo.BNO }</span>. ${vo.TITLE }

						</div> ${vo.WRITER } (<fmt:formatDate value="${vo.REGDATE }" />) <span
						class="badge">${vo.VIEWCNT }</span>

					</li>

				</c:forEach>

			</c:if>

		</ul>

		<!-- a tag, js : location, 주소입력 : get방식으로 넘어 간다. post방식 꼭 지정을 해야한다. -->

		<a href="write.do?perPageNum=${pageObject.perPageNum }"
			class="btn btn-default">글쓰기</a>

		<div>

			<pageObject:pageNav listURI="list.do" pageObject="${pageObject }" />

		</div>

	</div>

</body>

</html>