<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>      
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="${contextPath}/resources/js/member/memberList.js"></script>
<link href="${contextPath}/resources/css/member/memberList.css" rel="stylesheet" type="text/css">
<title>JSV_관리자</title>
<c:choose>
	<c:when test="${result eq 'stopSuccess'}">
		<script>
			alert('해당 회원의 활동이 정지 되었습니다.');
		</script>
	</c:when>
	<c:when test="${result eq 'stopFailed'}">
		<script>
			alert('해당 회원의 활동 정지에 실패하였습니다.');
		</script>
	</c:when>
	<c:when test="${result eq 'releaseSuccess'}">
		<script>
			alert('해당 회원의 활동 정지가 해제 되었습니다.');
		</script>
	</c:when>
	<c:when test="${result eq 'releaseFailed'}">
		<script>
			alert('해당 회원의 활동 정지 해제에 실패하였습니다.');
		</script>
	</c:when>
</c:choose>
</head>
<body>
<form class="memberList_frm">
	<div class="admin_title">회원 목록</div>
	<table class="member_list_wrap">
		<tr>
			<td>회원번호</td>
			<td>회원명</td>
			<td>ID</td>
			<td>닉네임</td>
			<td>휴대폰 번호</td>
			<td>이메일</td>
			<td>가입일</td>
			<td>활동상태</td>
			<td>활동정지 | 정지해제</td>
		</tr>
		<c:forEach var="member" items="${memberListMap}">
			<tr>
				<td>${member.u_no}</td>
				<td>${member.u_name}</td>
				<td>${member.u_id}</td>
				<td>${member.u_nic}</td>
				<td>
					<fmt:formatNumber var="ph" value="${member.u_phone}" pattern="000,0000,0000"/>
					<c:out value="${fn:replace(ph, ',', '-')}" />
				</td>
				<td>${member.u_email}</td>
				<td>
					<fmt:formatDate value="${member.u_join_date}" pattern="yyyy-MM-dd"/>
				</td>
				<c:choose>
					<c:when test="${member.is_connection eq 'y'}">
						<td class="connection_y">활동중</td>
					</c:when>
					<c:when test="${member.is_connection eq 'n'}">
						<td class="connection_n">탈퇴</td>
					</c:when>
					<c:when test="${member.is_connection eq 's'}">
						<td class="connection_s">활동정지</td>
					</c:when>
				</c:choose>
				<td>
					<c:if test="${member.is_connection ne 'n' && member.is_connection eq 'y'}">
						<input type="button" onclick="stop(${member.u_no})" value="활동정지">
					</c:if>
					<c:if test="${member.is_connection ne 'n' && member.is_connection eq 's'}">
						<input type="button" onclick="release(${member.u_no})" value="정지해제">
					</c:if>
				</td>
			</tr>
		</c:forEach>
	</table>
	<!-- 페이징처리 -->
	<div class="paging">		
		<c:if test="${paging.startPage != 1}">
			<a href="${contextPath}/admin/member/memberList.mo?nowPage=${paging.startPage - 1}&cntPerPage=${paging.cntPerPage}">&lt;</a>
		</c:if>
		<c:forEach begin="${paging.startPage}" end="${paging.endPage}" var="p">
			<c:choose>
				<c:when test="${p == paging.nowPage}">
					<span>${p}</span>
				</c:when>
				<c:when test="${p != paging.nowPage}">
					<a href="${contextPath}/admin/member/memberList.mo?nowPage=${p}&cntPerPage=${paging.cntPerPage}">${p}</a>
				</c:when>
			</c:choose>
		</c:forEach>
		<c:if test="${paging.endPage != paging.lastPage}">
			<a href="${contextPath}/admin/member/memberList.mo?nowPage=${paging.endPage+1}&cntPerPage=${paging.cntPerPage}">&gt;</a>
		</c:if>
	</div>
</form>	
</body>
</html>