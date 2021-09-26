<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>      
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<link href="${contextPath}/resources/css/giftShop/order/isCompleteForm.css" rel="stylesheet" type="text/css">
<title>JSV기프트샵</title>
</head>
<body>
<form class="is_complete_frm">
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
	<div class="payment_complete_wrap">
		<div class="payment_complete_contents_wrap">
			<c:choose>
				<c:when test="${result eq 'complete'}">
					<p class="complete_content">
						<strong>상품이 결제되었습니다.</strong>
					</p>
					<p class="complete_olist">
						주문하신 내역은 하단 주문내역을 통해 확인 가능합니다.
					</p>
					<p class="complete_olist">
						또는 'MyPage' > '결제내역'을 통해 확인 할 수 있습니다.
					</p>
					<div class="btn_wrap">
						<a href="getOrderList.mo" class="btn_01">나의 구매내역</a>
						<a href="../gift-shop.mo" class="btn_02">기프트샵 홈</a>
					</div>
				</c:when>

				<c:when test="${result eq 'failed_404'}">
					<p class="complete_content">
						<strong>상품 결제에 실패하였습니다.</strong>
					</p>
					<p class="complete_olist">
						주문하신 내역의 결제가 실패하였습니다.
					</p>
					<p class="complete_olist">
						확인 하신 후 다시 결제해주시기 바랍니다.
					</p>
					<div class="btn_wrap">
						<a href="userCartList.mo" class="btn_01">다시 결제하기</a>
						<a href="../gift-shop.mo" class="btn_02">기프트샵 홈</a>
					</div>
				</c:when>
			</c:choose>
		</div>
	</div>
</form>
</body>
</html>