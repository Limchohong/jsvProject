<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="tiles"  uri="http://tiles.apache.org/tags-tiles" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>     
<c:set var="contextPath" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
$(window).scroll(function(){
	var scrollTop = $(document).scrollTop();
	if (scrollTop < 180) {
	 scrollTop = 180;
	}
	$("#banner").stop();
	$("#banner").animate( { "top" : scrollTop });
});




</script>
<style>
</style>
<title></title>
<link href="${contextPath}/resources/css/layout.css" rel="stylesheet" type="text/css">
<link href="${contextPath}/resources/css/giftShop/giftShop_nav.css" rel="stylesheet" type="text/css">
</head>
<body>	
		<header><tiles:insertAttribute name="header"/></header>
		<div class="clear"></div>
		<nav><tiles:insertAttribute name="nav"/></nav>
		<div class="clear"></div>	
		<sub><tiles:insertAttribute name="goods_nav"/></sub>
		<div class="wrap">
			<div class="clear"></div>
			<article><tiles:insertAttribute name="main"/></article>
			<div class="clear"></div>
		</div>
		<c:if test="${authUser.u_id eq 'admin'}">
			<tiles:insertAttribute name="adminMenu"/>
		</c:if>
		<footer><tiles:insertAttribute name="footer"/></footer>
		<!-- 슬라이드 메뉴바 -->
		<tiles:insertAttribute name="side"/>

</body>
</html> 