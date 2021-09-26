<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>      
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="${contextPath}/resources/js/member/mypage.js"></script>
<link href="${contextPath}/resources/css/member/mypage.css" rel="stylesheet" type="text/css">
<title>JSV마이페이지</title>
</head>
<body>
<form class="mypageForm" id="setMemberInfoFrm">
	<div class="mypageForm_title">마이페이지</div>
	<table class="mypage_wrap">
		<tr>
			<td colspan="2">
				<input type="button" class="btn_withdrawal" id="withdrawal" value="탈퇴하기">
			</td>
		</tr>
		<tr>
			<td>이름</td>
			<td>${memberDTO.u_name}</td>
		</tr>
		<tr>
			<td>닉네임</td>
			<td><input type="text" name="u_nic" id="u_nic" value="${memberDTO.u_nic}"></td>
		</tr>
		<tr>
			<td>아이디</td>
			<td>${memberDTO.u_id}</td>
		</tr>
		<tr>
			<td>
				비밀번호
				<input type="button" name="set_pwd" id="set_pwd" value="변경">
			</td>
			<td></td>
		</tr>
		<tr>
			<td>휴대전화</td>
			<td><input type="text" name="u_phone" id="u_phone" value="${memberDTO.u_phone}" placeholder="'-'를 제외한 번호만 입력해주세요"></td>
		</tr>
		<tr>
			<td>이메일</td>
			<td><input type="text" name="u_email" id="u_email" value="${memberDTO.u_email}" placeholder="ex) aaa@aaa.com"></td>
		</tr>
		<tr>
			<td>가입일</td>
			<td>
				<fmt:formatDate value="${memberDTO.u_join_date}" pattern="yyyy년MM월dd일"/>
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="button" id="setMyPageInfo" class="btn_set" name="btn_set" value="수정">
				<input type="button" name="btn_cancel" class="btn_cancel" onclick="history.back()" value="취소">
			</td>
		</tr>
	</table>
</form>
</body>
</html>