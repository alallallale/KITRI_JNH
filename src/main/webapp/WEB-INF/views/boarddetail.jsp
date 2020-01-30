<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta  http-equiv="Content-Type" content="text/html" charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
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
<div class="table-responsive">
<table class=table>
	<tr><th colspan="5"><h3>${vo.title }</h3></th><th colspan="2"></th></tr>
	<tr><td colspan="1">${vo.writer }</td><td>${changeTime }</td><td colspan="4"></td><td>조회수 : ${vo.viewcount }</td></tr>
	<tr class =active><td colspan="7">${vo.contents }</td></tr>	
</table>
</div>
<div style="float: right;"><a href="/mybatis/boardupdate?seq=${vo.seq }" ><button type="button" class="btn btn-success">수정하기</button></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="/mybatis/boarddelete?seq=${vo.seq }" ><button type="button" class="btn btn-success">삭제하기</button></a></div>


</body>
</html>