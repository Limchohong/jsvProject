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
.update_frm_wrap{
	width:980px;
	margin-top: 50px;
	margin-bottom:20px;
}
.update_frm_wrap table{
	border-collapse: collapse;
	width:100%;
}
.update_text_wrap{
	border-bottom:3px solid #ccc;
	margin-bottom: 20px;
    padding-bottom: 10px;
}
.update_text_wrap span{
	font-size:18px
}
.update_text_wrap input[type="text"]{
	height: 20px;
    border: 1px solid #b8b6aa;
    padding-bottom: 0px;
    padding-top: 3px;
    padding-bottom: 3px;
    font-size:16px
}
.preview_wrap{
	margin-bottom: 20px;
}
.update_img_wrap{
	border-bottom:3px solid #ccc;
	margin-bottom: 20px;
    padding-bottom: 10px;
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
<div class="update_frm_wrap">
	<form name ="updateEvent" id="updateEvent" method="POST"  enctype="multipart/form-data" action="../../event/update.mo">
		<input type="hidden" name="eno" value="${Eupdata.eno}" id="eno"/>
	 	<div class="update_text_wrap">
	 		<span>스페셜이벤트</span>
	 		<span>이벤트명 : </span>
	 		<span><input type="text" id="ename" value="${Eupdata.ename}" name="ename"/></span>
	 		<span>기간 : </span>
	 		<span>
	 			<input type="text" id="estart" value="${Eupdata.estart}" name="estart"/>
		 		~ <input type="text" id="eEnd"  value="${Eupdata.eEnd}" name="eEnd"/>
		 	</span>
	 	</div>
	 	<div class="update_img_wrap">
		 	<table>
		 		<tr>
		 			<td rowspan="2">
		 				<div class="preview_wrap">
				 			<img src="${contextPath}/download.mo?eno=${Eupdata.eno}&e_img=${Eupdata.e_img}">
		 				</div>
			 			<input type="file" value="${Eupdata.e_img}" name="file" id="file"/>
		 			</td>
		 		</tr>
		 	</table>	
	 	</div>
	 	<div class="btn_wrap">
	 		<input type="submit" id="subtn" class="subtn" value="수정"/>
	 	</div>
	</form>
</div>
</body>
</html> 