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
<h1>게시판 작성하기</h1>
<form class="form-group" action="/mybatis/boardwrite" method="post">
  <div class="form-group">
    <label>제목</label>
    <input type="text" class="form-control" name="title" required="required">
  </div>
  <div class="form-group">
    <label>비밀번호</label>
    <input type="password" class="form-control" name="password" required="required">
  </div>
  <div class="form-group">
    <label>작성자</label>
    <input type="text" class="form-control" name="writer" value="kitri" required="required">
  </div>
  <div class="form-group">
  <label>내용</label>
  <textarea class="form-control"  rows="17" style="resize: none; overflow-x:hidden; overflow-y:auto" name="contents"></textarea>
  </div>
  <button type="submit" class="btn btn-success">작성하기</button>
</form>
</body>
</html>