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
<style>
.new_frm_wrap{
	width:980px;
	margin-top: 50px;
	margin-bottom:20px;
}
.new_text_wrap table{
	border-collapse: collapse;
	width:100%;
}
.new_text_wrap, .new_img_wrap{
	border-bottom:3px solid #ccc;
	margin-bottom: 20px;
    padding-bottom: 10px;
}
.new_text_wrap span{
	font-size:18px
}
.new_text_wrap input[type="text"]{
	height: 20px;
    border: 1px solid #b8b6aa;
    padding-bottom: 0px;
    padding-top: 3px;
    padding-bottom: 3px;
    font-size:16px
}
.new_img_wrap table{
	width:100%
}

.new_img_wrap table td{
	padding-bottom: 10px;
    padding-top: 10px;
}
.new_img_wrap input[type="file"]{
	padding-left: 60px;
}
.btn_wrap .subtn{
	height:35px;
	width:100%;
	border:none;
	background-color:#edebe1;
	cursor: pointer;
}
</style>
<title></title>
</head>
<body>
<div class="new_frm_wrap">
	<form name ="newEvent" id="newEvent" method="POST"  enctype="multipart/form-data" action="newEvent.mo">
	 	<div class="new_text_wrap">
	 		<span>스페셜이벤트</span>
	 		<span>이벤트명 : </span>
	 		<span><input type="text" id="ename" name="ename"/></span>
	 		<span>기간 : </span>
	 		<span>
	 			<input type="text" id="estart" name="estart"/> ~
	 		    <input type="text" id="eEnd" name="eEnd"/>
		 	</span>
	 	</div>
	 	<div class="new_img_wrap">
		 	<table>
		 		<tr>
		 			<td>이벤트 이미지 등록</td>
		 		</tr>
		 		<tr>
		 			<td rowspan="2">
		 				<input type="file" name="file" id="file"/>
		 			</td>
		 		</tr>
		 	</table>	
	 	</div>
	 	<div class="btn_wrap">
	 		<input type="submit" id="subtn" class="subtn"/>
	 	</div>
	</form>
</div>
</body>
</html> 