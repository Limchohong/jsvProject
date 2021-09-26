/**
 * 상품 상세 js
 */

//3자리 컴마 
function setComma(value){
	return value.text().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
}

//금액 컴마 제거 
function removeComma(value){
    return value.text().replace(/[^\d]+/g, "");
}

//장바구니 추가 
function add_cart(goods_no){
	var qty = $("#count").text();
	
	$.ajax({
		type:"post",
		url:"addCart.mo",
		data:{"goods_no":goods_no,
			  "cart_qty":qty},	  
		success:function(data){
			if(data=="noLogin"){
				if(confirm("로그인이 필요한 서비스입니다.\n로그인 페이지로 이동하시겠습니까?")){
					location.href="../member/loginForm.mo";
				}
			}else if(data=="success"){
				if(confirm("장바구니에 등록되었습니다 \n확인하시겠습니까?")){
					location.href="../gift-shop/userCartList.mo"
				}
			}else if(data=="success"){
				alert("장바구니 등록에 실패하였습니다 다시 시도해주세요");
			}
		},
		error:function(jqXHR, textStatus, errorThrown){
			console.log("장바구니 등록 실패 \n" + textStatus + " : " + errorThrown);
		}
	});
}//add_cart

//+버튼
function plus_qty(price){
	var cnt = parseInt($("#count").text());
	if(cnt!=10){
		$("#count").text(cnt+1);
		$("#spantotalprice").text(price*(cnt+1));
		$("#spantotalprice").text(setComma($("#spantotalprice")));
		
		$("#totalPrice").text(price*(cnt+1));
		$("#totalPrice").text(setComma($("#totalPrice")));
		
	}else{
		alert("최대 구매수량은 10개입니다");
		return;
	}
}

//- 버튼
function minus_qty(price){
	var cnt = parseInt($("#count").text());
	if(cnt!=1){
		$("#count").text((cnt-1));
		$("#spantotalprice").text(price*(cnt-1));
		$("#spantotalprice").text(setComma($("#spantotalprice")));
		
		$("#totalPrice").text(price*(cnt-1));
		$("#totalPrice").text(setComma($("#totalPrice")));
		
	}else{
		alert("최소 구매수량은 1개입니다");
		return;
	}
}

//구매하기
function buy(goods_no,uno){
	if(uno!=null){
		var qty = $("#count").text();
		location.href="goodsOrderForm.mo?goods_no="+goods_no+"&qty="+qty;
	}else{
		if(confirm("로그인이 필요한 서비스 입니다.\n로그인 페이지로 이동하시겠습니까?")){
			location.href="../member/loginForm.mo";
		}
	}
}