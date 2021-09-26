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
	
	
})
</script>
<title></title>
</head>
<body>
<form name ="newMvChart" id="newMvChart" method="POST"  enctype="multipart/form-data" action="${contextPath}/admin/mvchart/newMvchart.mo">
<h2>영화상세</h2>
<hr/>
<table border="1">
	<tr>
		<td><input type="file" name="file" id="file"/></td>
		<td>
			<table border="1">
				<tr>
					<td><input type="text" name="ctitle" id="ctitle"/></td>
				</tr>
				<tr>
					<td>예매율 <input type="text" name="crate" id="crate"/></td>
				</tr>
				<tr>
					<td>감독:<input type="text" name="cdir" id="cdir"/>
					 /배우 :<input type="text" name="cactor" id="cactor"/></td>
				</tr>
				<tr>
					<td>장르:<input type="text" name="cgenre" id="cgenre"/>
					 /기본:<input type="text" name="cinfo" id="cinfo"/></td>
				</tr>
				<tr>
					<td>개봉:<input type="date" name="copen" id="copen"/></td>
				</tr>
			</table>
		</td>
	</tr>
	<tr>
		<td colspan="2"><textarea cols="50" rows="10" name="c_content" id="c_content"></textarea></td>
	</tr>
	<tr>
		<td colspan="2"><input type="submit" value="등록"/></td>
	</tr>
</table>
</form>
</body>
</html> 