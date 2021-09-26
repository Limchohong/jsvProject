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
<script src="${contextPath}/resources/js/member/findPwdResultForm.js"></script>
<link href="${contextPath}/resources/css/member/findResultForm.css" rel="stylesheet" type="text/css">
<link href="${contextPath}/resources/css/member/find_setForm.css" rel="stylesheet" type="text/css">
<title>JSV비밀번호 찾기</title>
</head>
<body>
	<c:if test="${result eq 'findIt'}">
		<div class="find_result_wrap">
		<h3 class="find_title">비밀번호 찾기</h3>
			<div class="find_result_view">
				<img class="thumb" src="${contextPath}/resources/img/member/ico_id_find2.png">
				<p class="desc">
					고객님께서 입력하신 정보가 일치하므로<br/>
					비밀번호를 재설정 해주세요.
				</p>
			</div>
			<form class="setPwdForm" id="setPwdForm">
				<table>
					<tr>
						<td>변경 비밀번호</td>
						<td>
							<input type="password" name="u_password" id="u_password" placeholder="변경할 비밀번호를 입력해주세요.">
						</td>
					</tr>
					<tr>
						<td>변경 비밀번호 확인</td>
						<td>
							<input type="password" name="u_password2" id="u_password2" placeholder="변경할 비밀번호를 확인해주세요">
						</td>
					</tr>
					<tr>
						<td></td>
						<td>
							<input type="button" class="btn_find" onclick="setPwd('${id}')" value="비밀번호 재설정">
						</td>
					</tr>
				</table>
			</form>
		</div>
	</c:if>
	<c:if test="${result eq 'notFindIt'}">
		<div class="find_result_wrap">
		<h3 class="find_title">비밀번호 찾기</h3>
		<div class="find_result_view">
			<img class="thumb" src="${contextPath}/resources/img/member/ico_id_find1.png">
			<p class="desc">
				고객님께서 입력하신 정보가<br/>
				정확한지 확인 후 다시 시도해주세요.
			</p>
			<a href="findPwdForm.mo" class="btn_type"><span class="text">비밀번호 다시 찾기</span></a>
			<a href="findIdForm.mo" class="btn_type"><span class="text">아이디 찾기</span></a>
		</div>
	</div>
	</c:if>
</body>
</html>