<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/> 
<% pageContext.setAttribute("newLineChar", "\n"); %>       
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="${contextPath}/resources/js/giftShop/goods/goodsDetail.js"></script>
<link href="${contextPath}/resources/css/giftShop/goods/goodsDetail.css" rel="stylesheet" type="text/css">
<title>JSV기프트샵</title>
</head>
<body>
<form name="goods_detail_frm" id="goods_detail_frm" >
<div class="category_product_detail_wrap">
	<strong class="category_product_detail_title">${goodsMap.goods_name}</strong>
	<div class="category_product_detail_contents">
		<div class="category_product_detail_contents_img_wrap">
			<ul class="bxslider">
				<li>
					<img alt="${goodsMap.goods_name}"
					     src="${contextPath}/goodsMainThum.mo?goods_no=${goodsMap.goods_no}&goods_img=${goodsMap.goods_img}"/>
				</li>
			</ul>
		</div>
		<div class="category_product_detail_contents_wrap">
			<p class="category_product_detail_sale_price_wrap">
				<span class="store_deatail_sale_price" id="spnSalePrice">
					<fmt:formatNumber value="${goodsMap.goods_price}" pattern="#,###"/></span>	
			</p>
			<dl class="category_product_detail_add_info">
				<dt>상품구성</dt>
				<dd>${goodsMap.goods_comp}</dd>
				<dt>유효기간</dt>
				<dd>${goodsMap.goods_validity}</dd>
			</dl>
			<!-- 금액 출력 부분 -->
			<div class="category_product_detail_price_wrap">
				<div class="com_form_number">
					<input type="button" class="com_btn_minus" value="-" 
						   onclick="minus_qty(${goodsMap.goods_price});">
					<span class="com_form_count com_form_count0" id="count">1</span>
					<input type="button" class="com_btn_plus" value="+" 
						   onclick="plus_qty(${goodsMap.goods_price});">
					<span class="com_total_price" id="spantotalprice">
						<fmt:formatNumber value="${goodsMap.goods_price}" pattern="#,###"/></span>
				</div>
			</div>
			<div class="category_product_detail_total_price">
				<p class="com_form_total_price">총 구매금액
					<span class="com_total_price0 com_product_total_price" id="totalPrice">
						<fmt:formatNumber value="${goodsMap.goods_price}" pattern="#,###"/></span>
				</p>
			</div>
			<div class="category_product_detail_btn_wrap">
				<input type="button" id="btn_cart" class="btn_cart" onclick="add_cart(${goodsMap.goods_no});">
				<input type="button" id="btn_buy"  onclick="buy(${goodsMap.goods_no},${authUser.u_no});" value="구매하기">
			</div>
		</div>
	</div>
	<p class="category_product_detail_txtbox">
		${goodsMap.goods_detail_desc1}
	</p>
	<dl class="category_product_detail_dlist">
		<dt>이용안내</dt>
		<dd>
			${fn:replace(goodsMap.goods_detail_desc2, newLineChar, "<br/>")}
		</dd>
		<dt>취소/환불</dt>
		<dd>
			${fn:replace(goodsMap.goods_detail_desc3, newLineChar, "<br/>")}
		</dd>
		<dt>미성년자 권리보호 안내</dt>
		<dd>
			${fn:replace(goodsMap.goods_detail_desc4, newLineChar, "<br/>")}
		</dd>
		<dt>분쟁 해결</dt>
		<dd>
			${fn:replace(goodsMap.goods_detail_desc5, newLineChar, "<br/>")}
		</dd>
	</dl>
</div>
</form>
<!-- category_product_detail_wrap -->
</body>
</html>