<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>      
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<link href="${contextPath}/resources/css/giftShop/giftShop_main.css" rel="stylesheet" type="text/css">
<title>JSV기프트샵</title>
</head>
<body>
<div id="contents" class="gift_store">
	<div class="category_product_wrap">
		<ul class="category_product_list">
			<li>
				<strong class="category_product_title">영화관람권</strong>
				<ul class="category_product_inner_list">
					<c:forEach var="list" items="${goodsMap.movieTicket}" begin="0" end="3">
						<li>
						<a href="${contextPath}/gift-shop/goodsDetail.mo?goods_no=${list.goods_no}" class="btn_category_product">
								<span class="best_product_img_wrap">
									<img alt="${list.goods_name}" class="top5_goods_img"
										src="${contextPath}/goodsMainListThum.mo?goods_no=${list.goods_no}&goods_img=${list.goods_img}"/>
								</span>
								<span class="best_product_text_wrap">
									<span class="best_product_text_title">${list.goods_name}</span>
									<span class="best_product_sale_price_wrap">
										<span class="store_deatail_source_price"><fmt:formatNumber value="${list.goods_price}" pattern="#,###"/></span>
									</span>
								</span>
							</a>
						</li>
					</c:forEach>
				</ul>
			</li>
			<li>
				<strong class="category_product_title">기프트카드</strong>
				<ul class="category_product_inner_list">
					<c:forEach var="list" items="${goodsMap.giftCard}" begin="0" end="2">
						<li class="state_giftcard">
							<a href="${contextPath}/gift-shop/goodsDetail.mo?goods_no=${list.goods_no}" class="btn_category_product">
								<span class="best_product_img_wrap" >
									<img alt="${list.goods_name}" class="another_goods_img"
										src="${contextPath}/goodsMainListThum.mo?goods_no=${list.goods_no}&goods_img=${list.goods_img}"/>
								</span>
								<span class="best_product_text_wrap">
									<span class="best_product_text_title">${list.goods_name}</span>
									<span class="best_product_sale_price_wrap">
										<span class="store_deatail_source_price"><fmt:formatNumber value="${list.goods_price}" pattern="#,###"/></span>
									</span>
								</span>
							</a>
						</li>
					</c:forEach>
				</ul>
			</li>
			<li>
				<strong class="category_product_title">콤보</strong>
				<ul class="category_product_inner_list">
					<c:forEach var="list" items="${goodsMap.combo}" begin="0" end="2">
						<li>
							<a href="${contextPath}/gift-shop/goodsDetail.mo?goods_no=${list.goods_no}" class="btn_category_product">
								<span class="best_product_img_wrap"  class="another_goods_img">
									<img alt="${list.goods_name}" class="another_goods_img"
										 src="${contextPath}/goodsMainListThum.mo?goods_no=${list.goods_no}&goods_img=${list.goods_img}"/>
								</span>
								<span class="best_product_text_wrap">
									<span class="best_product_text_title">${list.goods_name}</span>
									<span class="best_product_sale_price_wrap">
										<span class="store_deatail_source_price"><fmt:formatNumber value="${list.goods_price}" pattern="#,###"/></span>
									</span>
								</span>
							</a>
						</li>
					</c:forEach>
				</ul>
			</li>
			<li>
				<strong class="category_product_title">팝콘</strong>
				<ul class="category_product_inner_list">
					<c:forEach var="list" items="${goodsMap.popcon}" begin="0" end="1">
						<li>
							<a href="${contextPath}/gift-shop/goodsDetail.mo?goods_no=${list.goods_no}" class="btn_category_product">
								<span class="best_product_img_wrap">
									<img alt="${list.goods_name}" class="another_goods_img"
										 src="${contextPath}/goodsMainListThum.mo?goods_no=${list.goods_no}&goods_img=${list.goods_img}">
								</span>
								<span class="best_product_text_wrap">
									<span class="best_product_text_title">${list.goods_name}</span>
									<span class="best_product_sale_price_wrap">
										<span class="store_deatail_source_price"><fmt:formatNumber value="${list.goods_price}" pattern="#,###"/></span>
									</span>
								</span>
							</a>
						</li>
					</c:forEach>
				</ul>
			</li>
			<li>
				<strong class="category_product_title">음료</strong>
				<ul class="category_product_inner_list">
					<c:forEach var="list" items="${goodsMap.drink}" begin="0" end="1">
						<li>
							<a href="${contextPath}/gift-shop/goodsDetail.mo?goods_no=${list.goods_no}" class="btn_category_product">
								<span class="best_product_img_wrap">
									<img alt="${list.goods_name}" class="another_goods_img"
										 src="${contextPath}/goodsMainListThum.mo?goods_no=${list.goods_no}&goods_img=${list.goods_img}">
								</span>
								<span class="best_product_text_wrap">
									<span class="best_product_text_title">${list.goods_name}</span>
									<span class="best_product_sale_price_wrap">
										<span class="store_deatail_source_price"><fmt:formatNumber value="${list.goods_price}" pattern="#,###"/></span>
									</span>
								</span>
							</a>
						</li>
					</c:forEach>
				</ul>
			</li>
			<li>
				<strong class="category_product_title">스낵</strong>
				<ul class="category_product_inner_list">
					<c:forEach var="list" items="${goodsMap.snack}" begin="0" end="1">
						<li>
							<a href="${contextPath}/gift-shop/goodsDetail.mo?goods_no=${list.goods_no}" class="btn_category_product">
								<span class="best_product_img_wrap">
									<img alt="${list.goods_name}" class="another_goods_img"
										 src="${contextPath}/goodsMainListThum.mo?goods_no=${list.goods_no}&goods_img=${list.goods_img}">
								</span>
								<span class="best_product_text_wrap">
									<span class="best_product_text_title">${list.goods_name}</span>
									<span class="best_product_sale_price_wrap">
										<span class="store_deatail_source_price nowon"><fmt:formatNumber value="${list.goods_price}" pattern="#,###"/></span>
									</span>
								</span>
							</a>
						</li>
					</c:forEach>
				</ul>
			</li>
		</ul>
	</div>
</div>
</body>
</html>