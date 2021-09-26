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
$(document).ready(function(){
	$(".dropdown ul li").hover(function() {
	        $(this).children("ul").stop().slideToggle(500)
	      });
});   
</script>
<style>
</style>
<title></title>
</head>
<body>
<div class="nav-wrap">
	<div id="logo1_container">
		<div id="logo1">
		<a href="${contextPath}/main.mo">
			<img src="${contextPath}/resources/img/sam2.png" width="200px" height="120px"/>
		</a>	
		</div>
	</div>
	<div id="logo2">
		<a href="${contextPath}">
			<img src="${contextPath}/resources/img/logo2.png" width="230px" height="32px"/>
		</a>
	</div>
	<hr class="h1" style="margin:-32px;padding:28px 0px 28px;"/>
	<hr/>
	<div class="dropdown">
		<div id="dw">
			  <ul class="menu">
			    <li><a href="#">영화</a>
			      <ul class="sub sub1">
			        <li><a href="${contextPath}/mvchart/mvChartList.mo">무비차트</a></li>
			        <li><a href="#">HD트레일러</a></li>
			        <li><a href="${contextPath}/mvfind/mvfinder.mo">무비파인더</a></li>
			      </ul>
			    </li>
			    
			    <li><a href="#">예매</a>
			      <ul class="sub sub2">
			        <li><a href="${contextPath}/moveReserve.mo">빠른예매</a></li>
			        <li><a href="#">상영시간표</a></li>
			      </ul>
			    </li>
			    
			    <li><a href="#">극장</a>
			      <ul class="sub sub3">
			        <li><a href="#">JSV극장</a></li>
			      </ul>
			    </li>
			    
			    <li><a href="#">이벤트&컬처</a>
			      <ul class="sub sub4">
			        <li><a href="${contextPath}/event/eventList.mo">이벤트</a></li>
			        <li><a href="${contextPath}/gift-shop.mo">기프트샵</a></li>
			        <li><a href="${contextPath}/mgz/mgzList.mo">매거진</a></li>
			      </ul>
			    </li>
			  </ul>
	  </div>
	  <!-- 검색 -->
		<div id="search" >
		<form name="search" action="~" >
			<input name="searchWord" class="main_input" type="text" placeholder="건파우더 밀크세이크" onKeyUp=""/> 
			<input type="submit" name="search" class="btn1"  value="검색" >
		</form>
	</div>
	 <hr/>
	</div>
</div>	
</body>
</html> 