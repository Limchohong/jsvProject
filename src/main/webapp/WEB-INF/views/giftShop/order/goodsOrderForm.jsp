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
<script type="text/javascript" src="https://service.iamport.kr/js/iamport.payment-1.1.5.js"></script>
<script src="${contextPath}/resources/js/giftShop/order/goodsOrderForm.js"></script>
<link href="${contextPath}/resources/css/giftShop/order/goodsOrderForm.css" rel="stylesheet" type="text/css">
<title>JSV기프트샵</title>
</head>
<body>
<form class="cart_form" id="orderFrm">
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
	<div class="order_title">구매상품 정보</div>
	<table class="order_list_wrap">
		<tr class="order_wrap">
			<td>상품명</td>
			<td>판매금액</td>
			<td>수량</td>
			<td>구매금액</td>
		</tr>
		<c:forEach var="item" items="${listMap}">
			<input type="hidden" name="goods_no" value="${item.goods_no}">
			<input type="hidden" name="goods_price" value="${item.goods_price}">
			<tr class="cart_item_wrap cart_item">		
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
					<span class="goods_price">
						<fmt:formatNumber value="${item.goods_price}" pattern="#,###"/></span>
				</td>
				<!-- 상품 상세에서 구매시 -->
				<c:if test="${result eq 'one'}">
					<td class="goods_qty_wrap">
						<span class="goods_qty">${qty}</span>
					</td>
					<td class="goods_buy_price_wrap">
						<span class="goods_buy_price">
							<fmt:formatNumber value="${item.goods_price * qty}" pattern="#,###"/></span>
					</td>
					<c:set var="sum" value="${sum + (item.goods_price * qty)}"/>
				</c:if>
				<!-- 장바구니에서 구매시 -->
				<c:if test="${result ne 'one'}">
					<td class="goods_qty_wrap">
						<span class="goods_qty">${item.goods_cart_qty}</span>
					</td>
					<td class="goods_buy_price_wrap">
						<span class="goods_buy_price">
							<fmt:formatNumber value="${item.goods_price * item.goods_cart_qty}" pattern="#,###"/></span>
					</td>
					<c:set var="sum" value="${sum + (item.goods_price * item.goods_cart_qty)}"/>
				</c:if>	
			</tr>
		</c:forEach>
	</table>
	<table class="order_total_price_wrap">
		<tr>
			<td>
				<strong>총 결제 예정금액</strong>
			</td>
			<td>
				<strong>=</strong>
			</td>
			<td>
				<span class="total_price" id="total_price">
					<fmt:formatNumber value="${sum}" pattern="#,###"/></span>
			</td>
		</tr>
	</table>
	<div class="member_info_wrap">
		<strong class="member_info_title">주문자 정보 확인</strong>
		<ul class="member_info">
			<li>
				<label for="member_info_name"> 이름</label>
				<input type="text" id="member_info_name" placeholder="이름" style="width: 128px" value="${memberInfoMap.u_name}" readonly>
				<label for="member_info_ph"> 휴대전화 번호</label>
				<input type="tel" id="member_info_ph" placeholder="휴대전화 번호" 
					   style="width: 228px" value="${memberInfoMap.u_phone}" readonly>
			</li>
		</ul>
		<p class="order_precautions">
			* 구매하신 JSV 기프트콘은 주문자 정보에 입력된 휴대전화 번호로 MMS로 발송됩니다.<br>
			* 입력된 휴대전화 번호가 맞는지 꼭 확인하세요.<br>
			* 입력된 휴대전화 번호와 발송받을 번호가 상이할 경우 마이페이지를 통하여 변경 가능합니다.
		</p>
	</div>
	<div class="agree_wrap">
		<p class="agree_wrap_title">
			<input type="checkbox" id="check00">
			<label for="check00">
			주문정보/결제 대행 서비스 약관 모두 동의
			</label>
		</p>
		<div class="agree_wrap_content">
			<p class="agree_wrap_title">
				<input type="checkbox" id="check01" name="agreeCheck">
				<label for="check01">기프티콘 구매 동의</label>
				<span class="agree_text">
					기프트콘 발송 및 CS처리 등을 이해 수신자로부터 CJCGV에 수신자의 휴대전화번호를 제공하는 것에 대한 적합한 동의를 받습니다.
				</span>
			</p>
			<p class="agree_wrap_title">
				<input type="checkbox" id="check02" name="agreeCheck">
				<label for="check02">결제 대행 서비스 약관 모두 동의</label>
				<span class="agree_text2">
					<label for="check03">전자 금융거래 이용약관</label>	
				</span>
				<span class="agree_text2">
					<label for="check04">개인정보 수집 이용약관</label>	
				</span>
				<span class="agree_text2">
					<label for="check05">개인정보 제공 및 위탁안내</label>	
				</span>
			</p>
		</div>
	</div>
	<div class="btn_payment_wrap">
		<input type="button" class="btn_payment" onclick="payment(${sum})" value="결제하기">
	</div>
</form>	
</body>
</html>