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
<script src="${contextPath}/resources/js/member/findPwdForm.js"></script>
<link href="${contextPath}/resources/css/member/find_setForm.css" rel="stylesheet" type="text/css">
<title>JSV비밀번호 찾기</title>
</head>
<body>
<form class="findForm" id="findForm" >
	<div class="findForm_title">비밀번호 찾기</div>
	<table>
		<tr>
			<td>이름</td>
			<td>
				<input type="text" name="u_name" id="u_name" placeholder="고객님의 이름을 입력해주세요.">
			</td>
		</tr>
		<tr>
			<td>아이디</td>
			<td>
				<input type="text" name="u_id" id="u_id" placeholder="고객님의 ID를 입력해주세요.">
			</td>
		</tr>
		<tr>
			<td>이메일</td>
			<td>
				<input type="text" name="u_email" id="u_email" placeholder="가입 시 등록하신 이메일 주소를 입력해주세요">
			</td>
		</tr>
		<tr>
			<td></td>
			<td>
				<input type="submit" class="btn_find" value="확인">
			</td>
		</tr>
	</table>
</form>
</body>
</html>