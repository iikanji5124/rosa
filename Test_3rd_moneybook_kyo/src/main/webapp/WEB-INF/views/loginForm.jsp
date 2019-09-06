<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<script src='<c:url value="/js/jquery-3.4.1.js" />'></script>
<script>
	function check() {
		var id = $("#userid").val();
		var pwd = $("#userpwd").val();
		
		if(id.length < 3 || id.length > 10){
			alert("아이디는 3~10 글자를 입력하세요.");
			return false;
		}
		if(pwd.length < 3 || pwd.length > 10){
			alert("비밀번호는 3~10 글자를 입력하세요.");
			return false;
		}
	}
	
</script>
</head>
<body>
	<h1>[로그인]</h1>
	<form action="login" method="post">
		아이디 : <input type="text" name="userid" id="userid"><br><br>
		비밀 번호 : <input type="password" name="userpwd" id="userpwd"><br>
		<input type="submit" value="로그인" onclick="return check()">
	</form>
	<br>
	<form action="goHome" method="post">
		<input type="submit" value="취소">
	</form>
</body>
</html>
