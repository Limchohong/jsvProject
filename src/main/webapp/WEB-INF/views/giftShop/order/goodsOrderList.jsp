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
<link href="${contextPath}/resources/css/giftShop/order/goodsOrderList.css" rel="stylesheet" type="text/css">
<title>JSV기프트샵</title>
</head>
<body>
<form>
<div class="order_list_wrap">
	<div class="order_list_title">나의 주문내역</div>
	<c:if test="${empty orderListMap}"><div class="order_empty">주문 내역이 없습니다</div></c:if>
	<div class="order_list">
		<ul>
			<c:forEach var="item" items="${orderListMap}">
				<li>
					<a href="getOrderDetail.mo?order_no=${item.goods_order_no}" class="order_detail_link">
						<span class="item_title">
							<strong>주문번호</strong>
							<strong>주문자</strong>
							<strong>휴대폰 번호</strong>
							<strong>결제 금액</strong>
							<strong>결제일</strong>
						</span>
						<span class="item_content">
							<span>${item.goods_order_no}</span>
							<span>${item.u_name}</span>
							<span>
								<fmt:formatNumber var="ph" value="0${item.goods_order_ph}" pattern="000,0000,0000"/>
								<c:out value="${fn:replace(ph, ',', '-')}" />
							</span>
							<span>
								<fmt:formatNumber value="${item.goods_order_price}" pattern="#,###원"/>
							</span>
							<span>
								<fmt:formatDate value="${item.goods_order_date}" pattern="yy-MM-dd HH:mm"/>
							</span>
						</span>
					</a>
				</li>
			</c:forEach>
		</ul>
	</div>
</div>
</form>
</body>
</html>