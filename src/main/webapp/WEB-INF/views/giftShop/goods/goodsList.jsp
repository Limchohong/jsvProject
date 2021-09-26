<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>      
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<link href="${contextPath}/resources/css/giftShop/goods/goodsList.css" rel="stylesheet" type="text/css">
<title>JSV기프트샵</title>
</head>
<body>
<div class="category_product_list_wrap">
	<c:if test="${empty goodsMap}">
		<strong class="category_product_list_title">해당 카테고리에 등록된 상품이 없습니다.</strong>
	</c:if>
	<c:if test="${!empty goodsMap}">
		<strong class="category_product_list_title">${goodsMap[0].goods_cate_name}</strong>
		<ul class="com_list_style">
			<c:forEach var="item" items="${goodsMap}">
				<li class="state_giftcard">
					<a href="${contextPath}/gift-shop/goodsDetail.mo?goods_no=${item.goods_no}" class="btn_category_product">
						<span class="com_list_img_wrap ">
							<img src="${contextPath}/goodsCateListThum.mo?goods_no=${item.goods_no}&goods_img=${item.goods_img}"
								 alt="${item.goods_name}" class="goods_img">
						</span>
						<span class="com_list_text_wrap">
							<span class="com_list_text_title">${item.goods_name}</span>
							<span class="com_list_sale_price_wrap">
								<span class="store_deatail_source_price"><fmt:formatNumber value="${item.goods_price}" pattern="#,###"/></span>	
							</span>
						</span>	
					</a>
				</li>
			</c:forEach>
		</ul>
	</c:if>
</div>
</body>
</html>