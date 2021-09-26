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
//수정
function update(eno){
	if(confirm("수정하시겠습니까?")){
		location.href="../admin/event/updateForm.mo?eno="+eno;
	}
}

//삭제
function del(eno){
	if(confirm("정말로 삭제하시겠습니까?")) {  // 확인 창이 열림
        location.href = "${contextPath}/event/delete.mo?eno="+eno;  
    }
}

//목록
function eventList(){
	location.href = "eventList.mo";
}
</script>
<style>
.event_detail_wrap{
	width:980px;
	margin-top: 20px;
	margin-bottom:20px;
}
.event_detail_title_wrap{
	margin-bottom:10px;
	border-top:1px solid #b8b6aa;
	border-bottom:1px solid #d6d4ca;
	background-color:#edebe1;
}
.event_title_sub{
	color:#2275a4 !important;
}
.event_titles{
	float:left;
	padding-top: 5px;
    padding-bottom: 5px;
    padding-left: 5px;
    font-size: 18px;
}
.event_date{
	float:right;
	padding-top: 5px;
    padding-bottom: 5px;
    padding-right: 5px;
    font-size: 18px;
}
.event_detail_title_wrap:after{
	content:'';
	clear:both;
	display:block;
}
.admin_btn_wrap .btn_update, .btn_del{
	width:15%;
	height:45px;
	border:none;
	cursor: pointer;
	background-color:#b8b6aa;
	color:#fff;
}
.btn_update{
	margin-right:10px;
}
.btn_del{
	margin-left:10px;
}
.btn_list{
	height:35px;
	width:100%;
	border:none;
	background-color:#edebe1;
	cursor: pointer;	
	
}
.btn_list_wrap{
	margin-bottom: 10px;
    border-bottom: 1px solid #d6d4ca;
    padding-bottom: 10px;
}
.admin_btn_wrap{
	margin-top: 20px;
}
</style>
<title></title>
</head>
<body>
<div class="event_detail_wrap">
	<div class="event_detail_title_wrap">
		<p class="event_titles">
			<span class="event_title_sub">스페셜 이벤트</span>
			<span class="event_title">${eDetail.ename}</span>
		</p>
		<p class="event_date">기간 : ${eDetail.estart} ~ ${eDetail.eEnd}</p>
	</div>
	<div class="event_content_wrap">
		<img src="${contextPath}/download.mo?eno=${eDetail.eno}&e_img=${eDetail.e_img}"/>
		<div class="btn_list_wrap">
			<input type="button" class="btn_list" value="목록" onclick="eventList()"/>
		</div>
		<c:if test="${authUser.u_id eq 'admin'}">
			<div class="admin_btn_wrap">
				<input type="button" class="btn_update" value="수정"  onclick="update(${eDetail.eno})"/>
				<input type="button" class="btn_del" value="삭제"  onclick="del(${eDetail.eno})"/>
			</div>
		</c:if>
	</div>
</div>
</body>
</html> 