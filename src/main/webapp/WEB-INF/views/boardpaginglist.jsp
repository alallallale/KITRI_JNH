<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="/mybatis/resources/jquery-3.2.1.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<script>
	$(document).ready(function() {

	});
</script>
</head>
<body>
<h1> 게시판 리스트</h1>
<table class="table table-striped">
	<thead><tr><th>번호</th><th>제목</th><th>작성자</th><th>조회수</th></tr></thead>
	<tbody>
<c:forEach items="${list }" var="vo">
<tr><td>${vo.seq }</td><td><a href="/mybatis/boarddetail?seq=${vo.seq}">${vo.title }</a></td><td>${vo.writer }</td><td>${vo.viewcount }</td></tr>
</c:forEach>
	</tbody>
</table>
<div style="float: right;"><a href="/mybatis/boardwrite"><button type="button" class="btn btn-success">글쓰기</button></a></div>
<!-- 페이지 번호 지정 -->

<nav style="text-align: center;">
  <ul class="pagination">

    <c:forEach var = "i" begin="1" end = "${totalPageNumber}" step="1">
<li><a href="?num=${ i }"><c:out value="${ i }"/></a></li>
</c:forEach>

  </ul>
</nav>


</body>
</html>