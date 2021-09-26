<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>      
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<link href="${contextPath}/resources/css/giftShop/order/goodsOrderDetail.css" rel="stylesheet" type="text/css">
<title>JSV기프트샵</title>
</head>
<body>
<div class="order_detail_list_wrap">
	<div>
		<p class="order_detail_title">주문 상세내역</p>
		<p class="order_no">주문번호 : ${goods_order_no}</p>
	</div>
	<div class="order_detail_list">
		<ul>
			<c:forEach var="item" items="${detailListMap}">
				<li>
					<div class="item_wrap">
						<span class="img_wrap">
							<a href="${contextPath}/gift-shop/goodsDetail.mo?goods_no=${item.goods_no}">
								<img src="${contextPath}/goodsMainListThum.mo?goods_no=${item.goods_no}&goods_img=${item.goods_img}"
								 	alt="${item.goods_name}" class="goods_img">
							</a>	 
						</span>
						<div class="content_wrap">
							<span class="item_title">
								<strong>상품명</strong>
								<strong>상품 가격</strong>
								<strong>구매 수량</strong>
								<strong>결제 금액</strong>
								<strong>기프티콘 번호</strong>
								<strong>기프티콘 수신번호</strong>
								<strong>기프티콘 사용여부</strong>
								<c:if test="${item.goods_giftcone_use eq 'y'}">
									<strong>기프티콘 사용일</strong>
								</c:if>
							</span>
							<span class="item_content">
								<span>${item.goods_name}</span>
								<span><fmt:formatNumber value="${item.goods_price}" pattern="#,###원"/></span>
								<span>${item.goods_order_qty}개</span>
								<span><fmt:formatNumber value="${item.goods_price * item.goods_order_qty}" pattern="#,###원"/></span>
								<span>${item.goods_giftcone_code}</span>
								<span>
									<fmt:formatNumber var="ph" value="${item.goods_order_ph}" pattern="000,0000,0000"/>
									<c:out value="${fn:replace(ph, ',', '-')}" />
								</span>
								<c:if test="${item.goods_giftcone_use eq 'n'}"><span>미사용</span></c:if>
								<c:if test="${item.goods_giftcone_use eq 'y'}">
									<span>사용</span>
									<span><fmt:formatDate value="${item.goods_giftcone_uesdate}" pattern="yy-MM-dd HH:mm"/></span>
								</c:if>
							</span>
						</div>
					</div>
				</li>
			</c:forEach>
		</ul>
	</div>
</div>
</body>
</html>