<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>      
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<link href="${contextPath}/resources/css/member/findResultForm.css" rel="stylesheet" type="text/css">
<title>JSV아이디 찾기</title>
</head>
<body>
<c:if test="${id eq null}">
	<div class="find_result_wrap">
		<h3 class="find_title">아이디 찾기</h3>
		<div class="find_result_view">
			<img class="thumb" src="${contextPath}/resources/img/member/ico_id_find1.png">
			<p class="desc">
				고객님께서 입력하신 정보가<br/>
				정확한지 확인 후 다시 시도해주세요.
			</p>
			<a href="findIdForm.mo" class="btn_type"><span class="text">아이디 다시 찾기</span></a>
			<a href="signupForm.mo" class="btn_type"><span class="text">회원가입 하러 가기</span></a>
		</div>
	</div>
</c:if>
<c:if test="${id ne null}">
	<div class="find_result_wrap">
		<h3 class="find_title">아이디 찾기</h3>
		<div class="find_result_view">
			<img class="thumb" src="${contextPath}/resources/img/member/ico_id_find2.png">
			<p class="desc">입력한 정보로 조회된<br/>
				ID는 <span class="result_wrap">${id}</span> 입니다.
			</p>
			<a href="findPwdForm.mo" class="btn_type"><span class="text">비밀번호 찾기</span></a>
			<a href="loginForm.mo" class="btn_type"><span class="text">로그인 하러 가기</span></a>
		</div>
	</div>
</c:if>
</body>
</html>