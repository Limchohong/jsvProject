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
    $(".delete").on('click', function() {  
        if(confirm("정말로 삭제하시겠습니까?")) {  // 확인 창이 열림
            location.href = "${contextPath}/mvchart/delete.mo?cno=${mvdto.cno}" ;  
        }else{
        	location.href="${contextPath}/mvchart/mvChartList.mo";
        }
    });
});
</script>
<style>
</style>
<title></title>
</head>
<body>
<h2>영화상세</h2>
<hr/>
<table border="1" class="mvd1" >
	<tr width="80%">
		<td><img src="${contextPath}/cdownload.mo?cno=${mvdto.cno}&c_img=${mvdto.c_img}"
						/></td>
		<td>
			<table border='1'>
				<tr >
					<td>${mvdto.ctitle}</td>
				</tr>
				<tr>	
					<td>예매율:${mvdto.crate}</td>
				</tr>
				<tr>	
					<td>감독: ${mvdto.cdir}/배우:${mvdto.cactor}</td>
				</tr>
				<tr>
					<td>장르:${mvdto.cgenre} /기본:${mvdto.cinfo}</td>
				</tr>
				<tr>
					<td>개봉:${mvdto.copen}</td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="button" value="프리에그"/>
						<input type="button" value="예매"/>
					</td>
				</tr>
			</table>
		</td>
	</tr>
	<tr>
		<td colspan="2">${mvdto.c_content}</td>
	</tr>
	<c:if test="${authUser ne null}">
	<tr>
		<Td colspan="2"><input type="button" value="삭제" class="delete"/></Td>
	</tr>
	</c:if>
</table>
</body>
</html> 