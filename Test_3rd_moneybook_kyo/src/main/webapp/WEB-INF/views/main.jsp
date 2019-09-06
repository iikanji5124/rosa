<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인화면</title>
<script src='<c:url value="/js/jquery-3.4.1.js" />'></script>
</head>
<body>
	<h1>[일일 가계부]</h1>
	<c:if test="${sessionScope.loginId == null}">
	<a href="SignupForm">회원 가입</a><br><br>
	<a href="loginForm">로그인</a>
	</c:if>
	
	<c:if test="${sessionScope.loginId != null}">
	${sessionScope.loginId} 님 환영합니다!<br><br>
	<a href="ListForm">내 가계부</a><br><br>
	<a href="logoutForm">로그아웃</a>
	</c:if>
</body>
</html>
