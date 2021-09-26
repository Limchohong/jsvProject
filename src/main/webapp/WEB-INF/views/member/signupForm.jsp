<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
    <c:set var="contextPath" value="${pageContext.request.contextPath}"/> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="${contextPath}/resources/js/member/signupForm.js"></script>
<link href="${contextPath}/resources/css/member/signupForm.css" rel="stylesheet" type="text/css">
<title>JSV회원가입</title>
<c:if test="${result eq 'joinFailed'}">
	<script>
		alert("회원 가입에 실패하였습니다.\n다시 시도해주세요");
	</script>
</c:if>
</head>
<body>
<form name="joinForm" class="joinForm" id="joinForm">
	<div class="joinForm_title">회원가입</div>
	<table class="join_wrap">
		<tr>
			<td colspan="2">
				<div class="joinForm_sub_title">표시는 필수입력란 입니다.</div>
			</td>
		</tr>
		<tr>
			<td>
				<label for="u_name" class="essential">이름</label>
			</td>
			<td>
				<input type="text" id="u_name" name="u_name" placeholder="이름을 입력해주세요."/>
			</td>
		</tr>
		<tr>
			<td>
				<label for="u_id" class="essential">아이디</label>
			</td>
			<td>
				<input type="text" id="u_id" name="u_id" placeholder="ID를 입력해주세요."/>
				<input type="button" class="btn_check" id="idCheck" value="id중복체크">
			</td>
		</tr>
		<tr>
			<td>
				<label for="u_password" class="essential">비밀번호</label>
			</td>
			<td>
				<input type="password" id="u_password" name="u_password" placeholder="비밀번호를 입력해주세요."/>
			</td>
		</tr>
		<tr>
			<td>
				<label for="u_password2" class="essential">비밀번호 확인</label>
			</td>
			<td>
				<input type="password" id="u_password2" name="u_password2" placeholder="비밀번호를 확인하세요"/>
			</td>
		</tr>
		<tr>
			<td>
				<label for="u_nic" class="essential">닉네임</label>
			</td>
			<td>
				<input type="text" id="u_nic" name="u_nic" placeholder="닉네임을 입력해주세요."/>
			</td>
		</tr>
		<tr>
			<td>
				<label for="u_phone" class="essential">휴대폰 번호</label>
			</td>
			<td>
				<input type="text" id="u_phone" name="u_phone" placeholder="'-'제외한 번호를 입력주세요"/>
			</td>
		</tr>
		<tr>
			<td>
				<label for="u_email" class="essential">이메일</label>
			</td>
			<td>
				<input type="text" id="u_email" name="u_email" maxlength="30" placeholder="ex)gildong@naver.com"/>
				<input type="button" class="btn_check btn_mail" id="getProof" value="인증번호 받기">
			</td>
		</tr>
		<tr>
		    <td>
				<label for="mail_confirm" class="essential">메일인증</label>
			</td>
			<td>
				<input type="text" id="mail_check" name="mail_check" placeholder="인증번호를 입력해주세요" disabled="disabled"/>
				<input type="button" class="btn_check" id="btn_mail_check" value="인증하기" disabled="disabled">
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit" class="btn_join" id="submit" value="회원가입">
				<input type="button" class="btn_cancel" onclick="history.back()" value="취소">
			</td>
		</tr>
	</table>
</form>
</body>
</html>