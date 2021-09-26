<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>      
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
function showCart(uno){
	if(uno!=null){
		location.href="${contextPath}/gift-shop/userCartList.mo";
	}else{
		if(confirm("로그인이 필요한 서비스 입니다.\n로그인 페이지로 이동하시겠습니까?")){
			location.href="${contextPath}/member/loginForm.mo";
		}
	}
}
</script>
</head>
<body>
<div class="category_wrap">
	<div class="category_contents_wrap">
		<ul class="category_content" style="padding-left: 0px; max-width: 740px;">
				<li id="cm1" class="categorymenu" >
					<a class="cateGoodsList" href="${contextPath}/gift-shop/getCateGoodsList.mo?goods_cate_no=1">영화관람권</a>
				</li>
				<li id="cm2" class="categorymenu" >
					<a class="cateGoodsList" href="${contextPath}/gift-shop/getCateGoodsList.mo?goods_cate_no=2">기프트카드</a>
				</li>
				<li id="cm3" class="categorymenu" >
					<a class="cateGoodsList" href="${contextPath}/gift-shop/getCateGoodsList.mo?goods_cate_no=3">콤보</a>
				</li>
				<li id="cm4" class="categorymenu" >
					<a class="cateGoodsList" href="${contextPath}/gift-shop/getCateGoodsList.mo?goods_cate_no=4">팝콘</a>
				</li>
				<li id="cm5" class="categorymenu" >
					<a class="cateGoodsList" href="${contextPath}/gift-shop/getCateGoodsList.mo?goods_cate_no=5">음료</a>
				</li>
				<li id="cm6" class="categorymenu" >
					<a class="cateGoodsList" href="${contextPath}/gift-shop/getCateGoodsList.mo?goods_cate_no=6">스낵</a>
				</li>
		</ul>
		<ul class="cart_content">
			<li>
				<a href="#" onclick="showCart(${authUser.u_no})">장바구니</a>
			</li>
		</ul>
	</div>
</div>
</body>
</html>