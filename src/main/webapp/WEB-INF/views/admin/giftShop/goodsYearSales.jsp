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
<script src="https://www.gstatic.com/charts/loader.js"></script>
<script src="${contextPath}/resources/js/giftShop/admin/goodsYearSales.js"></script>
<link href="${contextPath}/resources/css/giftShop/admin/sales.css" rel="stylesheet" type="text/css">
<title>JSV_관리자</title>
</head>
<body onload="getArrayList()">
<form>
	<input type="hidden" value="${jsonArray}" id="jsonArray">
</form>
<div class="sales_wrap">
	<strong>기프트샵 연매출</strong>
	<div class="sales_links">
		<a href="${contextPath}/admin/gift-shop/getGoodsMonthlySales.mo">연도별 월매출 조회</a>
	</div>
	<div id="chart_wrap"></div>
</div>
</body>
</html>