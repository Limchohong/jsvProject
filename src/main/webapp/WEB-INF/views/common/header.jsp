<%@ taglib prefix="tiles"  uri="http://tiles.apache.org/tags-tiles" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>     
<c:set var="contextPath" value="${pageContext.request.contextPath}"></c:set>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>

</script>
<title></title>
</head>
<body>
<div class="head-wrap">
	<div id="header-link">
		<ul>
			<c:choose>
				<c:when test="${authUser eq null}">
					<li><a href="${contextPath}/member/loginForm.mo">로그인</a></li>
					<li><a href="${contextPath}/member/signupForm.mo">회원가입</a></li>
					<li><a href="#">빠른예매</a></li>
				</c:when>
				<c:when test="${authUser.u_id eq 'admin'}">
					<li><a href="${contextPath}/member/logout.mo">로그아웃</a></li>
					<li><a href="${contextPath}/admin/member/memberList.mo">관리자 페이지</a></li>
					<li><a href="#">빠른예매</a></li>
				</c:when>
				<c:otherwise>
					<li><a href="${contextPath}/member/logout.mo">로그아웃</a></li>
					<li><a href="${contextPath}/member/mypagePwdCheck.mo">MYCGV</a></li>
					<li><a href="#">빠른예매</a></li>
				</c:otherwise>
			</c:choose>
		</ul>
	</div>
</div>
</body>
</html> 