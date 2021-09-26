<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="${contextPath}/resources/js/member/mypagePwdCheckForm.js"></script>
<link href="${contextPath}/resources/css/member/mypagePwdCheckForm.css" rel="stylesheet" type="text/css">
<title>마이페이지</title>
</head>
<body>
<a href="../gift-shop/getOrderList.mo">기프트샵 구매내역(임시링크)</a>
<form name="confirm_pwd_frm" id="confirm_pwd_frm">
	<div class="contents">
		<div class="content_title">
			<h1 class="title">회원정보 수정</h1>
			<p class="title_desc">회원님의 소중한 정보를 안전하게 관리하세요.</p>
		</div>
		<div class="content_wrap">
			<div class="mypage_modify">
				<div class="regi_complete">
					<span class="img"></span>
					<p class="sub_title">회원정보를 수정하시려면 비밀번호를 입력하셔야 합니다.</p>
					<p class="sub_desc">회원님의 개인정보 보호를 위한 본인 확인 절차이오니, 회원 로그인 시 사용하시는 비밀번호를 입력해주세요.</p>
					<div class="pwd_box">
						<span class="input_txt w330">
							<input type="password" id="u_password" class="text" placeholder="비밀번호를 입력해주세요." title="비밀번호" maxlength="20">
						</span>
					</div>
					<div class="btn_center">
						<input type="button" onclick="check()" class="btn btn_em" value="확인">
						<input type="button" onclick="history.back()" class="btn" value="취소">
					</div>
				</div>
			</div>
		</div>
	</div>
</form>	
</body>
</html>