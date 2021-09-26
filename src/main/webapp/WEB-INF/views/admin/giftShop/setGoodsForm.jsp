<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<c:set var="goods" value="${goodsMap.detailMap}"/>  
<% pageContext.setAttribute("newLineChar", "\n"); %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="${contextPath}/resources/js/giftShop/admin/newGoodsForm.js"></script>
<link href="${contextPath}/resources/css/giftShop/admin/new_set_Form.css" rel="stylesheet" type="text/css">
<script>
//카테고리 디폴트값 뿌려주기
window.onload = function() {
	$("#goods_cate_no").val($("#good_cno").val());
};
</script>
<title>JSV_관리자</title>
</head>
<body>
<form name="setGoodsFrm" id="setGoodsFrm" action="setGoods.mo" method="post" enctype="multipart/form-data">
<input type="hidden" id="good_cno" value="${goods.goods_cate_no}">
<input type="hidden" name="goods_no" value="${goods.goods_no}">
	<strong>기프트샵_상품수정</strong>
	<table>
		<tr>
			<td class="size">
				<table class="img_wrap">
					<tr>
						<td>
							<div id="preview">
								<img class="preview_img"
									src="${contextPath}/goodsMainThum.mo?goods_no=${goods.goods_no}&goods_img=${goodsMap.detailMap.goods_img}"
									id=previewImg 
									alt="${goods.goods_name}"/>
							</div>
							<input type="file" id="goods_img" name="goods_img">
							<div class="sizeInfo">
								  * 이미지의 너비 420px, 높이 420px을<br> 초과하는 경우 
								    이미지가 축소될 수 있습니다.
							</div>
							<div class='waring'>* 확장자 gif, jpg, jpeg, png 파일만 업로드 가능합니다</div>
						</td>
					</tr>
				</table>
			</td>
			<!-- 이미지등록(왼) 끝-->	
			<td class="size">
				<!-- 상품내용(오) 시작-->
				<table class="size text_wrap">
					<tr>
						<td class="text_title">카테고리</td>
						<td>
							<select name="goods_cate_no" id="goods_cate_no" class="select_box">
								<option value="default">--카테고리선택--</option>
								<c:forEach var="cate" items="${goodsMap.cateDTO}">
									<option value="${cate.goods_cate_no}">${cate.goods_cate_name}</option>
								</c:forEach>
							</select>
						</td>
					</tr>
					<tr>
						<td class="text_title">상품명</td>
						<td>
							<input type="text" name="goods_name" id="goods_name" class="text_box" value="${goods.goods_name}">
						</td>
					</tr>
					<tr>
						<td class="text_title">상품구성</td>
						<td>
							<input type="text" name="goods_comp" id="goods_comp" class="text_box" value="${goods.goods_comp}">
						</td>
					</tr>
					<tr>
						<td class="text_title">상품금액</td>
						<td>
							<input type="text" name="goods_price" id="goods_price"
							       placeholder="숫자만 입력 가능합니다" class="text_box" value="${goods.goods_price}">
						</td>
					</tr>
					<tr>
						<td class="text_title">유효기간</td>
						<td>
							<input type="text" name="goods_validity" class="text_box" id="goods_validity" value="${goods.goods_validity}">
						</td>
					</tr>
				</table>
			</td>
		</tr>
		<tr>
			<td colspan="2" class="desc_title">상품설명</td>
		</tr>
		<tr>
			<td colspan="2">
				<textarea name="goods_detail_desc1" id="goods_detail_desc1"
						  cols="80" rows="1">${goods.goods_detail_desc1}</textarea>
			</td>
		</tr>
		<tr>
			<td colspan="2" class="desc_title">이용안내</td>
		</tr>
		<tr>
			<td colspan="2">
				<textarea name="goods_detail_desc2" id="goods_detail_desc2"
						  cols="80" rows="5">${goods.goods_detail_desc2}</textarea>
			</td>
		</tr>
		<tr>
			<td colspan="2" class="desc_title">취소/환불 안내</td>
		</tr>
		<tr>
			<td colspan="2">
				<textarea name="goods_detail_desc3" id="goods_detail_desc3" 
						  cols="80" rows="5">${goods.goods_detail_desc3}</textarea>
			</td>
		</tr>
		<tr>
			<td colspan="2" class="desc_title">미성년자 권리보호 안내</td>
		</tr>
		<tr>
			<td colspan="2">
				<textarea name="goods_detail_desc4" id="goods_detail_desc4"
				cols="80" rows="1">${goods.goods_detail_desc4}</textarea>
			</td>
		</tr>
		<tr>
			<td colspan="2" class="desc_title">분쟁 해결 안내</td>
		</tr>
		<tr>
			<td colspan="2">
				<textarea name="goods_detail_desc5" id="goods_detail_desc5" 
						  cols="80" rows="5">${goods.goods_detail_desc5}</textarea>
			</td>
		</tr>
		<tr>
			<td colspan="2" class="btn_wrap">
				<input type="submit" class="btn_reg" value="수정">
				<input type="button" class="btn_can" onclick="history.back();" value="취소">
			</td>
		</tr>
	</table>
</form>
</body>
</html>