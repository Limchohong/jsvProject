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
function update(mno){
	if(confirm("수정하시겠습니까?")){
		location.href="../admin/mgz/updateForm.mo?mno="+mno;
	}
}

//삭제
function del(mno){
	if(confirm("정말로 삭제하시겠습니까?")) {  // 확인 창이 열림
        location.href = "../mgz/delete.mo?mno="+mno;
    }
}

//목록
function mgzList(){
	location.href = "mgzList.mo";
}

</script>
<style>
.magazine_detail_wrap{
	width:980px;
	margin-bottom:20px;
    margin-top: 20px;
}
/* 타이틀 */
.magazine_detail_title_wrap{
	padding-bottom: 10px;
	border-bottom:3px solid #000;
}
.magazine_detail_title_wrap strong {
	font-size: 40px;
    font-weight: 600;
}
.magazine_detail_title_wrap p {
	margin-top: 10px;
	font-size:16px;
	text-align: right;
}
.magazine_detail_title_wrap p > span{
	font-weight:600;
}
/* 상세내용 이미지 */
.magazine_detail_img_wrap{
	margin-top: 40px;
}
/* 영화정보 */
.movie_info_wrap{
	border-bottom: 2px solid #ccc;
    margin-bottom: 20px;
    padding-bottom: 20px;
}
.movie_info_wrap table{
	border-collapse: collapse;
	height: 330px;
}
.movie_info_wrap img{
	width:330px;
	height: 330px;
}
.movie_info_text{
	width:400px;
	margin-left:10px;
}
.movie_info_text tr:first-child td{
	padding-bottom: 60px;
	font-size:20px;
	font-weight: 600;
}
.movie_info_wrap td{
	font-size:15px;
    text-align: left;
}
.magazine_detail_img_wrap{
    border-bottom: 2px solid #ccc;
    margin-bottom: 20px;
    padding-bottom: 20px;
}
/* 버튼 */
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
.admin_btn_wrap{
	margin-top: 20px;
}
</style>
<title></title>
</head>
<body>
	<div class="magazine_detail_wrap">
		<div class="magazine_detail_title_wrap">
			<strong>${mgzMap.magazindto.mtitle}</strong>
			<p>
				<span>published by</span>
				:${mgzMap.magazindto.mwriter} | 등록일 : ${mgzMap.magazindto.mregDate}
			</p>
		</div>
		<div class="magazine_detail_img_wrap">
			<c:forEach var="mfile" items="${mgzMap.mfiledto}">
				<img src="${contextPath}/mdownload.mo?mno=${mfile.mno}&mFame=${mfile.mFame}"/>
			</c:forEach>
		</div>
		<div class="movie_info_wrap">
			<table>
				<tr>
					<td>
						<img src="${contextPath}/mdownload.mo?mno=${mgzMap.magazindto.mno}&mFame=${mgzMap.magazindto.mFame}"/>
					</td>
					<td>
						<table class="movie_info_text">
							<tr>
								<td>${mgzMap.magazindto.mname}</td>
							</tr>
							<tr>
								<Td>감독 : ${mgzMap.magazindto.mdir} / 배우 : ${mgzMap.magazindto.mactor}</Td>
							</tr>
							<tr>
								<Td>장르 : ${mgzMap.magazindto.mgenre} / 기본 : ${mgzMap.magazindto.minfo}</Td>
							</tr>
							<tr>
								<Td>개봉 : ${mgzMap.magazindto.mopen}</Td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
		</div>
		<div class="btn_list_wrap">
			<input type="button" class="btn_list" value="목록" onclick="mgzList()"/>
		</div>
		<div class="admin_btn_wrap">
			<c:if test="${authUser.u_id eq 'admin'}">
				<input type="button" value="수정" class="btn_update" onclick="update(${mgzMap.magazindto.mno})"/>
				<input type="button" value="삭제" class="btn_del" onclick="del(${mgzMap.magazindto.mno})"/>
			</c:if>
		</div>
	</div>	
</body>
</html> 