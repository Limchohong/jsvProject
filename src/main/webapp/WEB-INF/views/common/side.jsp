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
<div id="banner">
	<img src="${contextPath}/resources/img/banner.jpg" style="width:116px; hegith:300px;"/>
		<div class="content-btm">
			<a href="#"><img src="${contextPath}/resources/img/art.gif" style="width:95px; hegith:95px; margin-top:25px"/></a>
			<a href="#"><img src="${contextPath}/resources/img/btn_person_theater.gif"  style="width:95px; hegith:95px; padding:5px;" /></a>
			<a href="#"><img src="${contextPath}/resources/img/special.gif"  style="width:95px; hegith:95px; padding:5px;"/></a>
			<a href="#"><img src="${contextPath}/resources/img/ticket.gif" style="width:95px; hegith:95px; padding:5px;"/></a>
		</div>
</div>
</body>
</html> 