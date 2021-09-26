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
function test(){
$('#slide3>ul>li').hide();
$('#slide3>ul>li:first-child').show();
setInterval(function(){ 
	$('#slide3>ul>li:first-child').fadeOut() .next().fadeIn().end(1000) .appendTo('#slide3>ul'); 
	},2500);
		//넘기는초 :2000
}
//페이드인 페이드아웃 
</script>
<style>
/* 백그라운드 이미지 */
.mout_wrap{
 		position:absolute;
 		left:-65px;
		width:2000px;
		height:450px;
		background-image:url("${contextPath}/resources/img/bac_ban.png");
    	background-position:left-top;
    	background-position: center;
}
</style>
<link href="${contextPath}/resources/css/main.css" rel="stylesheet" type="text/css">
<title></title>
</head>
<body onload="test()">
<div class="cen_out">
 <div class="out_wrap">
	<div class="mout_wrap">
		<div id="index_03"> 
			<div id="header3"></div>
		 		<div id="slide3"> 
		 			<ul> 
					   <li><a href="#"><img src="${contextPath}/resources/img/ban1.jpg" alt="슬라이드7"></a></li>
					   <li><a href="#"><img src="${contextPath}/resources/img/ban2.jpg" alt="슬라이드8"></a></li> 
					   <li><a href="#"><img src="${contextPath}/resources/img/ban3.jpg" alt="슬라이드9"></a></li> 
					   <li><a href="#"><img src="${contextPath}/resources/img/ban3.jpg" alt="슬라이드9"></a></li> 
		  			</ul> 
		 	   </div>
		   </div>
	</div>
	<div class="movie">
			<img src="${contextPath}/resources/img/movie.gif" width="422px" height="41px">
	</div>
	<div class="mS1">
		<iframe width="733" height="388" src="https://www.youtube.com/embed/Kwdb2UO9PCI" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen>
		</iframe>
		<img src="${contextPath}/resources/img/voice.png"/>
	</div>
	<div class="event">
		<img src="${contextPath}/resources/img/event.gif"/>
	</div>
	<div class="eS1">
		<table>
			<tr>
				<td><img src="${contextPath}/resources/img/ef1.jpg"/></td>
				<td><img src="${contextPath}/resources/img/ef2.jpg"/></td>
				<td><img src="${contextPath}/resources/img/ef3.jpg"/></td>
				<td><img src="${contextPath}/resources/img/ef4.jpg"/></td>
			</tr>
		</table>
		<hr class="h3"/>
	</div>
	<div class="eS2">
		<table>
			<tr>
				<td class="b1"><img src="${contextPath}/resources/img/e1.png"/></td>
				<td><img src="${contextPath}/resources/img/e2.jpg"/></td>
				<td class="b1"><img src="${contextPath}/resources/img/e1.png"/></td>
			</tr>
		</table>
		<hr class="h4"/>
		
	</div>
	</div>
</div>
</body>
</html>