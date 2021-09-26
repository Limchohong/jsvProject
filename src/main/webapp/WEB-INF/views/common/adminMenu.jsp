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
<style>
.adminsub{
	position:absolute;
	left:140px;
	top:240px;
	border:"1";
}	
.adminsub ul{
	list-style:none;
	margin:0px;
	padding:0px;
	position:relative;
	text-align:center;
	border:3px solid black;
}
.adminsub ul li a{
	font-size: 13pt;
	color:black;
	text-decoration:none;
	display:block;
	width:90px;
	height:25px; 
	line-height:40px;
	font-size:400;
	
	
}
.adminsub li{
	width:150px; 
	height:45px;
	background:white;
	border:1px solid black;
}
.adminsub ul li:hover{
	   text-decoration:underline;
}
.adminsub ul ul{
	display:none;position:absolute;left:150px;top:93px;
}
.adminsub ul li:hover>ul {display:block;}
</style>
<title></title>
</head>
<body>
<div class="adminsub">
	<ul>
		<li><a href="${contextPath}/admin/member/memberList.mo">회원관리</a></li>
		<li><a href="#">예매관리</a></li>
		<li><a href="${contextPath}/gift-shop.mo">기프트샵</a>
			<ul>
				<li><a href="${contextPath}/admin/gift-shop.mo">상품관리</a></li>
				<li><a href="${contextPath}/admin/gift-shop/goodsSales.mo">매출조회</a></li>
			</ul>
		</li>
	</ul>
</div>
</body>
</html> 