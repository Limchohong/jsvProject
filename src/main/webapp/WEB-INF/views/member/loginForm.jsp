<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/> 

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="${contextPath}/resources/js/member/loginForm.js"></script>
<link href="${contextPath}/resources/css/member/loginForm.css" rel="stylesheet" type="text/css">
<c:if test="${result eq 'joinSuccess'}">
	<script>
		alert('${name} 님의 회원가입을 축하합니다!');
	</script>
</c:if>
<title>JSV로그인</title>
</head>
<body>
	<form class="loginForm" name="loginForm" id="loginForm">
		<h2>Login</h2>
		<div class="idForm">
		  <input type="text" class="id" placeholder="id" name="u_id" id="u_id">
		</div>
		<div class="passForm">
		  <input type="password" class="password" placeholder="password" name="u_password">
		</div>
		<input type="button" class="btn" onclick="login(this.form);" value="LOGIN">
		<div class="bottomText_wrap">
			<div class="bottomText">
				<a href="findIdForm.mo">아이디 찾기</a>
				<a href="findPwdForm.mo">비밀번호 찾기</a>
				<a href="signupForm.mo">회원가입</a>
			</div>
		</div>
	</form>
</body>
</html>