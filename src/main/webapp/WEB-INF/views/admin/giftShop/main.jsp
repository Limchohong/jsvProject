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
<script src="${contextPath}/resources/js/giftShop/admin/giftShop_main.js"></script>
<link href="${contextPath}/resources/css/giftShop/admin/giftShop_main.css" rel="stylesheet" type="text/css">
<title>JSV_관리자</title>
</head>
<body>
<form id="admin_frm">
	<div class="admin_title">기프트샵 상품관리</div>
	<a href="${contextPath}/admin/gift-shop/newGoodsForm.mo" class="goods_reg_link">상품 등록</a>
	<table class="goods_list_wrap">
		<tr class="list_title">
			<td><input type="checkbox" id="allCheck"></td>
			<td>상품번호</td>
			<td>상품 이미지</td>
			<td>카테고리명</td>
			<td>상품명</td>
			<td>판매가</td>
			<td>등록일</td>
			<td>수정일</td>
			<td colspan="2">수정 | 삭제</td>
		</tr>
		<c:forEach var="item" items="${goodsList}">
			<tr class="goods_item${item.goods_no}">
				<td><input type="checkbox" name="checkOne" value="${item.goods_no}"></td>
				<td>${item.goods_no}</td>
				<td>
					<a href="${contextPath}/gift-shop/goodsDetail.mo?goods_no=${item.goods_no}">
						<img class="goods_imgList" alt="${item.goods_name}" 
							 src="${contextPath}/cartThum.mo?goods_no=${item.goods_no}&goods_img=${item.goods_img}" />
					</a>
				</td>
				<td>${item.goods_cate_name}</td>
				<td>${item.goods_name}</td>
				<td><fmt:formatNumber value="${item.goods_price}" pattern="#,###"/></td>
				<td><fmt:formatDate value="${item.goods_regdate}" pattern="yy-MM-dd"/></td>
				<c:choose>
					<c:when test="${empty item.goods_update}">
						<td>-</td>
					</c:when>
					<c:when test="${!empty item.goods_update}">
						<td><fmt:formatDate value="${item.goods_update}" pattern="yy-MM-dd"/></td>
					</c:when>					
				</c:choose>
				<td colspan="2">
					<a href="${contextPath}/admin/gift-shop/setGoodsForm.mo?goods_no=${item.goods_no}" class="update_link">수정</a>	
					<a href="#none" class="del_link" onclick="removeGoods(${item.goods_no},this)">삭제</a>
				</td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="9"><input type="button" id="checkRemove" value="삭제"></td>
		</tr>
	</table>
	<!-- 페이징처리 -->
	<div class="paging">		
		<c:if test="${paging.startPage != 1}">
			<a href="${contextPath}/admin/gift-shop.mo?nowPage=${paging.startPage - 1}&cntPerPage=${paging.cntPerPage}">&lt;</a>
		</c:if>
		<c:forEach begin="${paging.startPage}" end="${paging.endPage}" var="p">
			<c:choose>
				<c:when test="${p == paging.nowPage}">
					<span>${p}</span>
				</c:when>
				<c:when test="${p != paging.nowPage}">
					<a href="${contextPath}/admin/gift-shop.mo?nowPage=${p}&cntPerPage=${paging.cntPerPage}">${p}</a>
				</c:when>
			</c:choose>
		</c:forEach>
		<c:if test="${paging.endPage != paging.lastPage}">
			<a href="${contextPath}/admin/gift-shop.mo?nowPage=${paging.endPage+1}&cntPerPage=${paging.cntPerPage}">&gt;</a>
		</c:if>
	</div>
</form> 
</body>
</html>