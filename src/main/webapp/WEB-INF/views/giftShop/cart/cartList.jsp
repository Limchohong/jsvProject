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
<script src="${contextPath}/resources/js/giftShop/cart/cartList.js"></script>
<link href="${contextPath}/resources/css/giftShop/cart/cartList.css" rel="stylesheet" type="text/css">
<title>JSV기프트샵_장바구니</title>
</head>
<body>
<form class="cart_form" id="cart_form" method="post">
	<input type="hidden" name="checkArr">
	<table class="step_wrap">
		<tr>
			<td class="setpIndex1">
				<span class="step01">STEP 01</span>
				<strong class="cart">장바구니</strong>
			</td>
			<td class="setpIndex2">
				<span class="step02">STEP 02</span>
				<strong class="payment">결제하기</strong>
			</td>
			<td class="setpIndex3">
				<span class="step03">STEP 03</span>
				<strong class="payment_completed">결제완료</strong>
			</td>
		</tr>
	</table>
	<c:choose>
		<c:when test="${empty cartList}">
			<div class="cart_empty">장바구니가 비어있습니다</div>
			<div class="btn_wrap"><a href="../gift-shop.mo" class="btn_02">기프트샵 홈</a></div>
		</c:when>
		<c:otherwise>
			<div class="cart_all_content">
				<table class="cart_list_wrap">
					<tr class="cart_wrap">
						<td><input type="checkbox" id="allCheck"></td>
						<td>상품명</td>
						<td>판매금액</td>
						<td>수량</td>
						<td>구매금액</td>
						<td>구매</td>
					</tr>
				<c:forEach var="item" items="${cartList}">
					<tr class="cart_item_wrap cart_item${item.goods_cart_no}">
						<td><input type="checkbox" name="checkOne" value="${item.goods_cart_no}"></td>		
						<td class="goods_info_wrap">
							<a href="${contextPath}/gift-shop/goodsDetail.mo?goods_no=${item.goods_no}">
								<img src="${contextPath}/cartThum.mo?goods_no=${item.goods_no}&goods_img=${item.goods_img}"
									 alt="${item.goods_name}" class="goods_img">
								<span class="goods_info">
									<strong class="goods_name">${item.goods_name}</strong>
									<span class="goods_comp">${item.goods_comp}</span>
								</span>
							</a>
						</td>
						<td class="goods_price_wrap">
							<span class="goods_price" id="goods_price${item.goods_cart_no}">
								<fmt:formatNumber pattern="#,###" value="${item.goods_price}"/></span>
						</td>
						<td class="goods_qty_wrap">
							<span class="btn_wrap">
								<input type="button" class="btn_plus" onclick="plus_qty(${item.goods_cart_no})">
								<span class="goods_qty" id="qty${item.goods_cart_no}">${item.goods_cart_qty}</span>
								<input type="button" class="btn_minus" onclick="minus_qty(${item.goods_cart_no})">
								<input type="button" class="set_btn" value="변경" onclick="setQty(${item.goods_cart_no});">
							</span>
						</td>
						<td class="goods_buy_price_wrap">
							<span class="goods_buy_price" id="goods_buy_price${item.goods_cart_no}">
								<fmt:formatNumber pattern="#,###" value="${item.goods_price * item.goods_cart_qty}"/></span>	
						</td>
						<td>
							<input type="button" value="바로구매" class="btn_now_buy" onclick="buy_now(${item.goods_no},${item.goods_cart_no})">
						</td>
					</tr>
					<c:set var="sum" value="${sum+(item.goods_price * item.goods_cart_qty)}"/>
				</c:forEach>
				</table>
				<div class="btn_del_wrap">
					<input type="button" class="btn_del" value="선택상품 삭제">
				</div>
				<div class="clear"></div>
				<table class="cart_total_price_wrap">
					<tr>
						<td><strong>총 결제 예정금액</strong></td>
						<td><strong>=</strong></td>
						<td><span class="total_price" id="total_price"></span></td>
					</tr>
				</table>
				<div class="btn_buy_wrap"><input type="submit" class="btn_buy" id="btn_buy" value="구매하기"></div>
			</div>
		</c:otherwise>
	</c:choose>
</form>
</body>
</html>