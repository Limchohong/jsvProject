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
$(function(){
	var cnt=0; //추가되는 버튼의 id 속성값 변수
	
	//최대 8개까지 업로드 할 수 있음
	$("#addImgbtn").click(function(){
		if(cnt==9){
			alert("업로드 할 수 있는 파일은 최대 9개입니다");
			return;
		}
		if(cnt==0){
			$("#addImg").append('<input type="file" name="main_img" id="main_img"/><br/>');	//썸네일 처리도 같이 할 이미지
		}else{
			$("#addImg").append('<input type="file" name="sub_img'+cnt+'" id="sub_img'+cnt+'"/><br/>');
		}
		cnt++;
	});//addingbtn
	
});
</script>
<style>
.new_frm_wrap{
	width:980px;
	margin-top: 50px;
	margin-bottom:20px;
}
.new_text_wrap{
	border-bottom:3px solid #ccc;
	margin-bottom: 20px;
    padding-bottom: 20px;
}
.new_img_wrap{
	border-bottom:3px solid #ccc;
	margin-bottom: 20px;
    padding-bottom: 20px;
}

.new_text_wrap span, .movie_info_wrap span{
	font-size:18px
}

.new_sub_title{
	margin-top: 5px;
}

.new_title input[type="text"]{
	margin-left: 17px;
}

.new_title input[type="text"], .new_sub_title input[type="text"]{
	width: 80%;
	height: 25px;
	border: 1px solid #b8b6aa;
	padding-left:5px;
    padding-top: 3px;
    padding-bottom: 3px;
    text-align:left
}

#mwriter{
	width: 60%;
    margin-left: 10px;
    border: 1px solid #b8b6aa;
    padding-top: 6px;
    padding-bottom: 6px;
    text-align:left  
}

.new_text_wrap .regdate{
	font-size: 16px;
}
.new_info_text input[type="date"]{
	border: 1px solid #b8b6aa;
	padding-top: 6px;
    padding-bottom: 6px;
}

.movie_info_wrap{
	border-bottom:3px solid #ccc;
	margin-bottom: 20px;
    padding-bottom: 20px;
    
}
#addImgbtn{
	height:25px;
	width:21%;
	border:none;
	background-color:#edebe1;
	cursor: pointer;
}
.movie_info_wrap div{
	text-align:center;
	margin-top: 3px;
	width:70%;
}

.movie_info_wrap div input[type="text"]{
	width: 50%;
    height: 15px;
    padding-top: 5px;
    padding-bottom: 5px;
    padding-left: 5px;
	border: 1px solid #b8b6aa;
}
.movie_info_wrap div input[type="date"]{
	padding-top: 5px;
    padding-bottom: 5px;
    padding-left: 5px;
	border: 1px solid #b8b6aa;
}
.btn_wrap{
	margin-top: 20px;
}
.btn_wrap .suBtn{
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
	<form name="newMgzFrm" id="newMgzFrm" method="POST" enctype="multipart/form-data" action="${contextPath}/admin/mgz/newMgz.mo">
		<div class="new_text_wrap">
			<div>
				<div class="new_title">
					<span>매거진 제목</span>
					<span>
						<input type="text" name="mtitle" id="mtitle"/>
					</span>
				</div>
				<div class="new_sub_title">
					<span>매거진 부제목</span>
					<span>
						<input type="text" name="mcontent" id="mcontent"/>
					</span>
				</div>
				<div class="new_info_text">	
					<span>Published by</span> 
					<span>	
						<input type="text" name="mwriter" id="mwriter"/>
					</span>
					<span class="regdate">등록일</span>
					<span>
						<input type="date" id="mregDate" name="mregDate"/>
					</span>
				</div>
			</div>
		</div>
		<div class="new_img_wrap">
			<p>매거진 이미지 등록</p>
			<input type="button" name="addImgbtn" id="addImgbtn" value="파일추가"/>
			<div>
				<div id="addImg"></div>
				<div id="removeImg"></div>
			</div>
		</div>
		<div class="movie_info_wrap">
			<strong>영화 정보</strong>
			<div>
				<span>제목</span>
				<span>
					<input type="text" name="mname" id="mname"/>
				</span>
			</div>
			<div>
				<span>감독</span>
				<span>
					<input type="text" name="mdir" id="mdir"/>
				</span>
			</div>
			<div>	
				<span>배우</span>
				<span>
					<input type="text" name="mactor" id="mactor"/>
				</span>
			</div>
			<div>
				<span>장르</span>
				<span>
					<input type="text" name="mgenre" id="mgenre"/>
				</span>
			</div>
			<div>	
				<span>정보</span>
				<span>
					<input type="text" name="minfo" id="minfo"/>
				</span>
			</div>
			<div>
				<span>개봉일</span>
				<span>
					<input type="date" name="mopen" id="mopen"/>
				</span>
			</div>
		</div>
		<div class="btn_wrap">	
			<input type="submit" value="매거진 등록" id="suBtn" class="suBtn"/>
		</div>	 
	</form>
</div>
</body>
</html> 