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
<title></title>
<style>
.event_list_wrap {
    width: 980px;
    margin: 57px auto 0;
}
.event_list_title {
    display: block;
    padding-bottom: 5px;
    text-align:center;
    font-weight: 600;
    font-size: 40px;
    color: #000;
    border-bottom: 1px solid #999;
}
.event_list_title + .event_list_style {
    padding: 45px 40px;
}
.event_list_style {
    overflow: hidden;
}
.event_list_title + .event_list_style li {
    width: 270px;
    margin-left: 45px;
    margin-bottom: 50px;
}
.event_list_title + .event_list_style li:nth-child(3n + 1) {
    clear: both;
    margin-left: 0;
}
.event_list_style li {
    float: left;
    position: relative;
    background-color: black;
}
.event_main_img{
	width: 270px;
    height:326px;
}
.event_list_style li .event_text_wrap {
    display: block;
    padding-bottom: 20px;
}
.event_text_wrap{
	padding-left: 10px;
    padding-right: 10px;
}
    
.event_list_style { 
	text-aling:cneter;
}
.event_list_style > ul {
	display:inline-block; / display:inline; 
}
.event_text_title{
	display: block;
    font-size: 20px;
    color: #fff;
    padding-top: 10px;
    padding-left: 11px;
    padding-right: 11px;
    text-align: left;
    font-weight: 500;
}

.event_text_name{
	display: block;
    font-size: 18px;
    color: #fff;
    padding-top: 10px;
    padding-left: 11px;
    padding-right: 11px;
    text-align: left;
}

.event_date_wrap{
	display: block;
    font-weight: 500;
    font-size: 16px;
    color: #fff;
    padding-top: 25px;
    padding-left: 11px;
    padding-right: 11px;
    text-align:left;
}
.event_list_wrap > a {
	display:inline-block;
	color:#ccc;
}

</style>
</head>
<body>
<div class="event_list_wrap">
	<c:if test="${authUser ne null}">
	<a href="${contextPath}/admin/mgz/newMgzForm.mo">매거진 등록</a>
	</c:if>
	<strong class="event_list_title">JSV 매거진</strong>
	<ul class="event_list_style">
		 <c:forEach items="${mList}" var="list">
			<li class="event_item">
				<a href="${contextPath}/mgz/mgzDetail.mo?mno=${list.mno}">
					<span class="event_img_wrap">
						<img src="${contextPath}//mthumbnails.mo?mno=${list.mno}&mFame=${list.mFame}" class="event_main_img">
					</span>
					<span class="event_text_wrap">
						<span class="event_text_name">${list.mname}</span>
						<span class="event_text_title">${list.mtitle}</span>
						<span class="event_date_wrap">
							<span class="event_date">${list.mcontent}</span>	
						</span>
					</span>	
				</a>
			</li>
		</c:forEach>
	</ul>
</div>
</body>
</html> 