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
<script src="${contextPath}/resources/js/giftShop/admin/newGoodsForm.js"></script>
<link href="${contextPath}/resources/css/giftShop/admin/new_set_Form.css" rel="stylesheet" type="text/css">
<title>JSV_관리자</title>
</head>
<body>
<form name="newGoodsFrm" id="newGoodsFrm" method="post" enctype="multipart/form-data">
<input type="hidden" id="goods_cate_name" name="goods_cate_name">
	<strong>기프트샵_상품등록</strong>
	<table>
		<tr>
			<td class="size">
				<table class="img_wrap">
					<tr>
						<td>
							<div id="preview" ></div>
							<input type="file" name="goods_img" id="goods_img">
							<div class="sizeInfo">
								* 이미지의 너비 420px, 높이 420px을 <br>초과하는 경우 이미지가 축소될 수 있습니다.
							</div>
							<div class='waring'>* 확장자 gif, jpg, jpeg, png 파일만 업로드 가능합니다</div>
						</td>
					</tr>
				</table>
			</td>
			<td class="size">
				<!-- 상품내용(오) 시작-->
				<table class="size text_wrap">
					<tr>
						<td class="text_title">카테고리</td>
						<td>
							<select name="goods_cate_no" class="select_box" id="goods_cate_no">
								<option value="default">--카테고리선택--</option>
								<c:forEach var="cate" items="${cateDTO}">
									<option value="${cate.goods_cate_no}">${cate.goods_cate_name}</option>
								</c:forEach>
							</select>
						</td>
					</tr>
					<tr>
						<td class="text_title">상품명　</td>
						<td><input type="text" name="goods_name" class="text_box" id="goods_name"></td>
					</tr>
					<tr>
						<td class="text_title">상품구성</td>
						<td><input type="text" name="goods_comp" class="text_box" id="goods_comp"></td>
					</tr>
					<tr>
						<td class="text_title">상품금액</td>
						<td><input type="text" name="goods_price" class="text_box" id="goods_price"placeholder="숫자만 입력 가능합니다"></td>
					</tr>

					<tr>
						<td class="text_title">유효기간</td>
						<td><input type="text" name="goods_validity" class="text_box" id="goods_validity"></td>
					</tr>
				</table>
				<!-- 상품내용(오) 끝-->
			</td>
		</tr>
		<tr>
			<td colspan="2" class="desc_title">상품설명</td>
		</tr>
		<tr>
			<td colspan="2">
				<textarea name="goods_detail_desc1" id="goods_detail_desc1" cols="80" rows="1"></textarea>
			</td>
		</tr>
		<tr>
			<td colspan="2" class="desc_title">이용안내</td>
		</tr>
		<tr>
			<td colspan="2">
				<textarea name="goods_detail_desc2" id="goods_detail_desc2" cols="80" rows="5"></textarea>
			</td>
		</tr>
		<tr>
			<td colspan="2" class="desc_title">취소/환불 안내</td>
		</tr>
		<tr>
			<td colspan="2">
				<textarea name="goods_detail_desc3" id="goods_detail_desc3" cols="80" rows="5"></textarea>
			</td>
		</tr>
		<tr>
			<td colspan="2" class="desc_title">미성년자 권리보호 안내</td>
		</tr>
		<tr>
			<td colspan="2">
				<textarea name="goods_detail_desc4" id="goods_detail_desc4" cols="80" rows="1"></textarea>
			</td>
		</tr>
		<tr>
			<td colspan="2" class="desc_title">분쟁 해결 안내</td>
		</tr>
		<tr>
			<td colspan="2">
				<textarea name="goods_detail_desc5" id="goods_detail_desc5" cols="80" rows="5"></textarea>
			</td>
		</tr>
		<tr>
			<td colspan="2" class="btn_wrap">
				<input type="submit" class="btn_reg" value="상품 등록">
				<input type="button" class="btn_can" onclick="history.back();" value="취소">
			</td>
		</tr>
	</table>
</form>
</body>
</html>