<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Insert title here</title>
<script src="/mvc/resources/jquery-3.2.1.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<script>
	$(document).ready(function() {

	});
</script>
<script type="text/javascript">
	alert("등록된 회원이 아닙니다.");
</script>
</head>
<body>
	<form method="post" action="/mybatis/memberinsert">
		<h3 style="text-align: center;">회원가입 화면</h3>
		<div class="form-group">
			<input type="text" class="form-control" placeholder="아이디"
				name="userid" maxlength="20">
		</div>
		<div class="form-group">
			<input type="password" class="form-control" placeholder="비밀번호"
				name="password" maxlength="20">
		</div>
		<div class="form-group">
			<input type="text" class="form-control" placeholder="이름" name="name"
				maxlength="20">
		</div>

		<div class="form-group">
			<input type="text" class="form-control"
				placeholder="휴대폰 번호(- 포함)" name="phone" maxlength="20">
		</div>

		<div class="form-group">
			<input type="email" class="form-control" placeholder="이메일"
				name="email" maxlength="50">
		</div>
		<input type="submit" class="btn btn-primary form-control" value="회원가입">
	</form>
</body>
</html>