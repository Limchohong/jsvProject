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
</head>
<body>	
   <div id="header-wrap">	
		<header><tiles:insertAttribute name="header"/></header>
		<div class="clear"></div>
		<nav><tiles:insertAttribute name="nav"/></nav>	
	</div>
	<div id="body-wrap">
		<div id="body-content">
			<div class="clear"></div>
			<tiles:insertAttribute name="side"/>
			<article><tiles:insertAttribute name="main"/></article>
			<div class="clear"></div>
			<div class="adminMenu"><tiles:insertAttribute name="adminMenu"/></div>
			<div class="clear"></div>
		</div>
		<footer><tiles:insertAttribute name="footer"/></footer>
	</div>
</body>
</html> 