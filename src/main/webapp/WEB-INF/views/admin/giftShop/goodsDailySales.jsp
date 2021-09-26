<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>      
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<link href="${contextPath}/resources/css/giftShop/admin/sales.css" rel="stylesheet" type="text/css">
<title>JSV_관리자</title>
</head>
<body>
<div class="sales_wrap">
	<div class="sales_title">${dateInfo.year}년 ${dateInfo.month}월 일 매출</div>
	<table>
		<c:forEach var="item" items="${listMap}">
			<tr>
				<td>${item.month}월 ${item.day}일</td>
				<td><fmt:formatNumber value="${item.total}" pattern="#,###원"/></td>
			</tr>
			<c:set var="total" value="${total=total+item.total}"/>
		</c:forEach>
		<tr>
			<td>합계</td>
			<td class="total_price"><fmt:formatNumber value="${total}" pattern="#,###원"/></td>
		</tr>
	</table>
</div>
</body>
</html>