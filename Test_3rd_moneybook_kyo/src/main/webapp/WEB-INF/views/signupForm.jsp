<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<script src='<c:url value="/js/jquery-3.4.1.js" />'></script>
<script>
	function check() {
		var id = $("#userid").val();
		var pwd = $("#userpwd").val();
		var pwd2 = $("#userpwd2").val();
		
		if(id.length < 3 || id.length > 10){
			alert("아이디는 3~10 글자를 입력하세요.");
			return false;
		}
		if(pwd.length < 3 || pwd.length > 10){
			alert("비밀번호는 3~10 글자를 입력하세요.");
			return false;
		}
		if(pwd != pwd2){
			alert("비밀번호가 일치하지 않습니다.");
			return false;
		}
	}
</script>
</head>
<body>
	<h1>[회원가입]</h1>
	<form action="singup" method="post">
		아이디 : <input type="text" id="userid" name="userid"><br><br>
		비밀번호 : <input type="password" id="userpwd" name="userpwd"><br><br>
		비밀번호 확인 :<input type="password" id="userpwd2" name="userpwd2" ><br><br>
		<input type="submit" value="가입" id="liginbutton" onclick="return check()">
	</form>
	<br>
	<form action="goHome" method="post">
		<input type="submit" value="취소">
	</form>
</body>
</html>
