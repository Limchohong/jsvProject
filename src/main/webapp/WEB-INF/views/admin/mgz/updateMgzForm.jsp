<%@ taglib prefix="tiles"  uri="http://tiles.apache.org/tags-tiles" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>     
<c:set var="contextPath" value="${pageContext.request.contextPath}"></c:set>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<c:set var="mgz" value="${mgzMap.magazindto}"/>
<c:set var="imgList" value="${mgzMap.mfiledto}"/> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
//매거진 내용수정
function fn_modify_mgz(mno,nameObj){
	var upFrm = document.updateMgzFrm; //폼객체
	//nameObj;//user가 수정한 대상
	var newValue="";
	switch(nameObj){
	case 'mtitle': newValue=upFrm.mtitle.value; break;
	case 'mwriter': newValue=upFrm.mwriter.value; break;
	case 'mregDate': newValue=upFrm.mregDate.value; break;
	case 'mname': newValue=upFrm.mname.value; break;
	case 'mcontent': newValue=upFrm.mcontent.value; break;
	case 'mdir': newValue=upFrm.mdir.value; break;
	case 'mactor': newValue=upFrm.mactor.value; break;
	case 'mgenre': newValue=upFrm.mgenre.value; break;
	case 'mopen': newValue=upFrm.	mopen.value; break;
	}
	//Ajax이용    
	$.ajax({
		type: "post",
		async:false,
		url : "${contextPath}/mgz/updateMgzInfo.mo",
		data: { mno:mno,
				attr:nameObj,  //user가 수정한 대상
				value:newValue,//user가 입력하거나 선택한 value
			   },
		success:function(data, textStatus){//정상요청 및 응답시 호출되는 함수
			if(data=='updateSuccess'){
				alert("상품정보를 수정하였습니다");
			}else if(data=='updateFail'){
				alert("상품정보를 수정실패하였어요");
			}
		},
		error:function(data, status, error){ //오류발생시 호출되는 함수 
			console.log("에러발생했어요 data="+data); 
		},
		complete:function(data, textStatus){//작업완료후 호출되는 함수 
			alert("작업완료."); 
		}
	});//ajax
	
}//fn_modify_mgz

function modImgFile(fieldId, mno, mFno, mFtype){	
	var frm = $("#FILE_FORM")[0]; //폼객체
	var formData = new FormData( frm ); //FormData객체생성
	formData.append("mFtype",$("#"+fieldId)[0].files[0]);
	formData.append("mno", mno);
	formData.append("mFno", mFno);
	formData.append("mFtype", mFtype);
 $.ajax({
		type: "post",
		url : "${contextPath}/mgz/updateMgzImg.mo",
		data: formData,
		processData: false, //false값을 주면  query string 방식으로 전송하지x
		contentType: false, //false값을 주면 application/x-www-form-urlencoded방식으로 전송하지x
		success:function(data, textStatus){//정상요청 및 응답시 호출되는 함수
			alert("첨부파일이미지를 수정했습니다");
		},
		error:function(data, status, error){ //오류발생시 호출되는 함수 
			console.log("에러입니다"); 
		}
	});//ajax 
	
}//modImgFile함수
</script>
<style>
	
</style>
<title></title>
</head>
<body onload="init()">
<div>
	<form id="updateMgzFrm" name="updateMgzFrm" method="post" action="${contextPath}/mgz/updateMgzInfo.mo" >
		<table>
			<tr>
				<td><input type="text" name="mtitle" id="mtitle" value="${mgz.mtitle}"/><td>
				<td><input  type="button" value="수정"  onClick="fn_modify_mgz(${mgz.mno},'mtitle')"/></td>
			</tr>
			<tr>
				<td><input type="text" name="mwriter" id="mwriter" value="${mgz.mwriter}"/><td>
				<td><input  type="button" value="수정"  onClick="fn_modify_mgz(${mgz.mno},'mwriter')"/></td>
			</tr>
			<tr>
				<td><input type="date" id="mregDate" name="mregDate" value="${mgz.mregDate}"/><td>
				<td><input  type="button" value="수정"  onClick="fn_modify_mgz(${mgz.mno},'mregDate')"/></td>
			</tr>
			<tr>
				<td><input type="text" name="mname" id="mname" value="${mgz.mname}"/><td>
				<td><input  type="button" value="수정"  onClick="fn_modify_mgz(${mgz.mno},'mname')"/></td>
			</tr>
			<tr>
				<td><input type="text" name="mcontent" id="mcontent" value="${mgz.mcontent}"/><td>
				<td><input  type="button" value="수정"  onClick="fn_modify_mgz(${mgz.mno},'mcontent')"/></td>
			</tr>
			<tr>
				<td><input type="text" name="mdir" id="mdir" value="${mgz.mdir}"/><td>
				<td><input  type="button" value="수정"  onClick="fn_modify_mgz(${mgz.mno},'mdir')"/></td>
			</tr>
			<tr>
				<td><input type="text" name="mactor" id="mactor" value="${mgz.mactor}"/><td>
				<td><input  type="button" value="수정"  onClick="fn_modify_mgz(${mgz.mno},'mactor')"/></td>
			</tr>
			<tr>
				<td><input type="text" name="mgenre" id="mgenre" value="${mgz.mgenre}"/><td>
				<td><input  type="button" value="수정"  onClick="fn_modify_mgz(${mgz.mno},'mgenre')"/></td>
			</tr>
			<tr>
				<td><input type="date" name="mopen" id="mopen" value="${mgz.mopen}"/><td>
				<td><input  type="button" value="수정"  onClick="fn_modify_mgz(${mgz.mno},'mopen')"/></td>
			</tr>
		</table>
		<h1>매거진 상세 이미지</h1>
		<form id="FILE_FORM" method="POST" enctype="multipart/form-data">
			<h4>상품이미지</h4>
			<table border="1">
			 <c:forEach var="imgFile"  items="${imgList}" varStatus="status">
		  		 <c:choose>
		            <c:when test="${imgFile.mFtype eq 'main_img'}"><%--파일타입이 메인이미지일때 --%>
		              <tr>
					    <td>메인 이미지</td>
					    <td>
						  <input type="file"  id="main_img"  name="main_img"/>
						  <input type="hidden"  name="mFno" id="mFno" value="${imgFile.mFno}" /><%--db의 pk에 해당하는 이미지id를 숨겨서 서버로 전송 --%>
						</td>
						<td>
							<input  type="button" value="수정"  onClick="modImgFile('main_img','${mgz.mno}','${imgFile.mFno}','${imgFile.mFtype}')"/>
						</td>
					 </tr>
					</c:when>
			 		<c:otherwise>
			 		<tr>
			 			<TD>상세이미지${imgFile.mFtype}</TD>
			 			<td> <img  width="200" height="200" src="${contextPath}/mdownload.mo?mno=${imgFile.mno}&mFame=${imgFile.mFame}"></td>
			 			<Td><input type="file" name="sub_img"  id="sub_img" />
							<input type="hidden"  name="mFno"  value="${imgFile.mFno}"/>
						<td> <input  type="button" value="수정"  onClick="modImgFile('sub_img','${mgz.mno}','${imgFile.mFno}','${imgFile.mFtype}')"/></td>
			 		</tr>
			 		</c:otherwise>
				</c:choose>
			</c:forEach>	
			 <tr align="center">
			      <td colspan="3">
				      <div id="addImg">
				      </div>
			       </td>
			    </tr>	
		</table>
		</form>
	</form>	
</div>	
</body>
</html> 