<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles"  uri="http://tiles.apache.org/tags-tiles" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>     
<c:set var="contextPath" value="${pageContext.request.contextPath}"></c:set>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
//무조건 이전페이지 범위의 가장 앞 페이지로 이동
function fn_prev(page, range, rangeSize, listSize, searchType, keyword) {
		
	var page = ((range - 2) * rangeSize) + 1;
	var range = range - 1;
		
	var url = "${contextPath}/mvfind/mvfinder.mo";
	url = url + "?page=" + page;
	url = url + "&range=" + range;
	url = url + "&listSize=" + listSize;
	url = url + "&searchType=" + searchType;
	url = url + "&keyword=" + keyword;
	location.href = url;
	}

  //페이지 번호 클릭

function fn_pagination(page, range, rangeSize, listSize, searchType, keyword) {

	var url = "${contextPath}/mvfind/mvfinder.mo";
		url = url + "?page=" + page;
		url = url + "&range=" + range;
	/* 	url = url + "&listSize=" + listSize; */
		url = url + "&searchType=" + searchType;
		url = url + "&keyword=" + keyword; 

		location.href = url;	
	}

	//다음 버튼 이벤트
	//다음 페이지 범위의 가장 앞 페이지로 이동
function fn_next(page, range, rangeSize, listSize, searchType, keyword) {
	var page = parseInt((range * rangeSize)) + 1;
	var range = parseInt(range) + 1;			
	var url = "${contextPath}/mvfind/mvfinder.mo";
		url = url + "?page=" + page;
		url = url + "&range=" + range;
/* 		url = url + "&listSize=" + listSize; */
		url = url + "&searchType=" + searchType;
		url = url + "&keyword=" + keyword;
		location.href = url;
	}
		
	// 검색
$(document).on('click', '#btnSearch', function(e){
	e.preventDefault();
	var url = "${contextPath}/mvfind/mvfinder.mo";
	url = url + "?searchType=" + $('#searchType').val();
	url = url + "&keyword=" + $('#keyword').val();
/* 	url = url + "&listSize=" + $('#listSize').val(); */
	location.href = url;
	console.log(url);

});	




/*한페이지당 게시물 */
function page(cno){
  var startPage = cno;
  var listSize = $("#listSize option:selected").val();
	
  if(listSize == 10){
	  var url="/mvfind/mvfinder.mo?startPage="+startPage+"&listSize="+listSize
  }else if(listSize == 15){
	  var url ="/mvfind/mvfinder.mo?startPage="+startPage+"&listSize="+listSize
  }else if(listSize == 20){
      var url="/mvfind/mvfinder.mo?startPage="+startPage+"&listSize="+listSize
  }
  location.href = url;
}
</script>
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
    text-align: center;
    font-weight: 500;
}

.event_text_name{
   display: block;
    font-size: 18px;
    color: #fff;
    padding-top: 10px;
    padding-left: 11px;
    padding-right: 11px;
    text-align: center;
}

.event_date_wrap{
   display: block;
    font-weight: 500;
    font-size: 16px;
    color: #fff;
    padding-top: 25px;
    padding-left: 11px;
    padding-right: 11px;
    text-align:center;
}
.event_list_wrap > a {
   display:inline-block;
   color:#ccc;
}

.fin_wrap{
		position:absolute;
 		left:-65px;
		width:2000px;
		height:450px;
		background-image:url("${contextPath}/resources/img/bac_ban.png");
    	background-position:left-top;
    	background-position: center;
    	display:block;
}
.mvWrap{
	position:relatvice;
}
.searchS{
	position:relative;
}
.form-group row justify-content-center{
	position:absolute;
	bottom:600px;
}
.event_list_title{
	margin:200px;
}
.w100{
	margin-top:50px;
}
.w300{
	padding:5px;
}
</style>
<title></title>
</head>
<body>
<div class="fin_wrap">
	<div class="searchS">
	<!-- search{s} -->
		<div class="form-group row justify-content-center">
			<div class="w100" style="padding-right: 10px;" >
			<table class="searchG">
			<tr>
			<td>
				<select class="form-control form-control-sm" name="searchType"
					id="searchType" style="width:100px; height: 30px;">
					<option value="ctitle">영화제목</option>
					<option value="cactor">주연배우</option>
					<option value="cdir">감독</option>
				</select>
	</div>
			</td>
			<td>
			<div class="w300" style="padding-right:10px"> 
				<input type="text" class="form-control form-control-sm"  placeholder="키워드를 입력해주세요." name="keyword" id="keyword"  style="width:220px; height: 25px;">
			</div>
		     </td>
		     <td>
			<div >
				<button class="btn btn-sm btn-primary" name="btnSearch"
					id="btnSearch"  style="width:60px; height: 28px;">검색</button>
			</td>
			</tr>
			<tr>
				<td></td>
			</tr>
			</table>
		</div>
	</div>
</div>	
<!-- search{e} -->
</div>
<div>
<hr/>
<!-- 검색에 따라서 변환됨 -->
<div class="mvWrap">
	<div class="testlist">
		<form id="mvForm" name="mvForm" method="post">
			<div class="event_list_wrap">
			   <strong class="event_list_title">무비차트</strong>
			   <ul class="event_list_style">
			       <c:forEach items="${list}" var="mvlist">
			         <li class="event_item">
			                 <a href="${contextPath}/mvchart/mvDetail.mo?cno=<c:out value='${mvlist.cno}'/>"/>
			                   <img src="${contextPath}/cthumbnails.mo?cno=<c:out value="${mvlist.cno}"/>&c_img=<c:out value='${mvlist.c_img}'/>"/>
			                  </a>
			               <span class="event_img_wrap">
			               </span>
			            </a>
			            <span class="event_text_wrap">
			               <span class="event_text_name"><c:out value="${mvlist.ctitle}"/></span>
			               <span class="event_text_title"><c:out value="${mvlist.crate}"/></span>
			               <span class="event_date_wrap">
			                  <span class="event_date"><c:out value="${mvlist.copen}"/>개봉</span>
			                  <input type="button" value="예매"/>   
			               </span>
			            </span>   
			         </li>
			      </c:forEach>
			   </ul>
			</div>
		</form>
	</div>
</div>
	<br>
	<!-- pagination{s} -->
</div>
</body>
</html> 