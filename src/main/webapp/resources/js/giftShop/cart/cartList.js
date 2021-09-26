/**
 * 장바구니 목록 js
 */

//3자리 컴마 
function setComma(value){
	return value.text().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
}

//금액 컴마 제거 
function removeComma(value){
    return value.text().replace(/[^\d]+/g, "");
}

/* 추후 결제페이지 완성시 사용할 메서드   */
function buy_now(goods_no,cart_no){
	var qty = $("#qty"+cart_no).text();
	location.href="goodsOrderForm.mo?goods_no="+goods_no+"&qty="+qty;
}

//수량변경버튼
function setQty(no){
	var qty = $("#qty"+no).text();
	var cart_no = no;
	
	$.ajax({
		type:"post",
		url :"../gift-shop/setCartQty.mo",
		data:{"qty":qty,
			  "cart_no":cart_no
			  },
		contentType : "application/x-www-form-urlencoded; charset=UTF-8",
		success:function(data){
			console.log(data);
			if(data=="success"){
				alert("수량이 변경되었습니다");
			}else if(data=="failed"){
				alert("수량변경에 실패하였습니다 다시 시도 해주세요");
			}
		},
		error:function(jqXHR, textStatus, errorThrown){
			console.log("수량변경실패 \n" + textStatus + " : " + errorThrown);
		}
	});//$.ajax
}

//수량 + 버튼
function plus_qty(no){
	qty = parseInt($("#qty"+no).text());//수량
	buy_price = parseInt(removeComma($("#goods_buy_price"+no)));//구매금액
	price = parseInt(removeComma($("#goods_price"+no)));//정가
	
	var total_buy_price = 0;
	var goods_buy_price = $(".goods_buy_price");
	
	if(qty!=10){
		$("#qty"+no).text(qty+1);						//수량증가
		$("#goods_buy_price"+no).text(price*(qty+1));	//구매가격 변경
		$("#goods_buy_price"+no).text(setComma($("#goods_buy_price"+no)));
		
		for(var i=0;i<goods_buy_price.length;i++){
			total_buy_price+=parseInt(removeComma(goods_buy_price.eq(i)));
		}
		
		$("#total_price").text(total_buy_price);
		$("#total_price").text(setComma($("#total_price")));
		
	}else{
		alert("최대 구매수량은 10개입니다");
	}
	
}

//수량 - 버튼
function minus_qty(no){
	var qty = parseInt($("#qty"+no).text());//수량
	var buy_price = parseInt(removeComma($("#goods_buy_price"+no)));//구매금액
	var price = parseInt(removeComma($("#goods_price"+no)));//정가
	
	var total_buy_price = 0;
	var goods_buy_price = $(".goods_buy_price");
	
	if(qty!=1){
		$("#qty"+no).text(qty-1);						//수량증가
		$("#goods_buy_price"+no).text(price*(qty-1));	//구매가격 변경
		$("#goods_buy_price"+no).text(setComma($("#goods_buy_price"+no)));
		
		for(var i=0;i<goods_buy_price.length;i++){
			total_buy_price+=parseInt(removeComma(goods_buy_price.eq(i)));
		}
		
		$("#total_price").text(total_buy_price);	
		$("#total_price").text(setComma($("#total_price")));
		
	}else{
		alert("최소 구매수량은 1개 입니다");
	}
}


$(document).ready(function(){
	
	/* 결제 예정금액 뿌려주기 */
	var total_buy_price = 0;
	var goods_buy_price = $(".goods_buy_price");
	
	for(var i=0;i<goods_buy_price.length;i++){
		total_buy_price+=parseInt(removeComma(goods_buy_price.eq(i)));
	}
	$("#total_price").text(total_buy_price);
	$("#total_price").text(setComma($("#total_price")));
	
	$("input[name=checkOne]").prop("checked",true);
	$("#allCheck").prop("checked",true);
	
	
	
	//개별 체크박스 선택
	$("input[name=checkOne]").click(function(){
		
		var checkLength = $("input[name='checkOne']").length;
		var checkedLength =  $("input[name='checkOne']:checked").length;
		
		var buy_price = parseInt(removeComma($("#goods_buy_price"+$(this).val())));//구매금액
		var total_price = parseInt(removeComma($("#total_price")));//총 결제 예정금액
		
		if($(this).prop("checked")){/* 체크박스 선택시 총 결제 예정금액 변경 */
			$("#total_price").text(total_price+buy_price);
			$("#total_price").text(setComma($("#total_price")));
		}else {
			$("#total_price").text(total_price-buy_price);
			$("#total_price").text(setComma($("#total_price")));
		}

		if(checkLength==checkedLength){
			$("#allCheck").prop("checked",true);
		}else{
			$("#allCheck").prop("checked",false);
		}
	});//$("input[name='checkOne']")
	
	
	//전체선택 & 해제
	$("#allCheck").click(function(){
		var checkLength = $("input[name=checkOne]").length;
		var checkedLength =  $("input[name='checkOne']:checked").length;
		var checked = $("input[name=checkOne]").is(":checked");
		
		if(!$(this).prop("checked")){
			$("#total_price").text(0);
		}else{
			$("#total_price").text(total_buy_price);
			$("#total_price").text(setComma($("#total_price")));
		}
			
		if(!checked || checkLength!=checkedLength){
			$("input[name=checkOne]").prop("checked",true);
		}else{
			$("input[name=checkOne]").prop("checked",false);
		}
	});//$("#allCheck").click

	
	//선택상품 삭제 버튼
	$(".btn_del").click(function(){
		var checkArr = [];
		$("input[name=checkOne]:checked").each(function(i){
			checkArr.push($(this).val());
		});
		
		if(checkArr==""||checkArr.length==0){
			alert("삭제할 상품을 선택하세요.");
			return;
		}
		
		if(confirm("선택한 상품을 삭제 하시겠습니까?")){
			$.ajax({
				type:"post",
				url :"../gift-shop/removeCheckedCart.mo",
				data:{"checkArr":checkArr},
				contentType : "application/x-www-form-urlencoded; charset=UTF-8",
				success:function(data){
					if(data=="success"){
						alert("삭제되었습니다");
						
						$.each(checkArr, function(index, item){                               
							$(".cart_item"+item).remove();
						});
							if($(".cart_item_wrap").length==0){
								$(".cart_all_content").remove();
								$(".step_wrap").after("<div class='cart_empty'>장바구니가 비어있습니다</div>")
							}
						var total_buy_price = 0;
						var goods_buy_price = $(".goods_buy_price");
						
						for(var i=0;i<goods_buy_price.length;i++){
							total_buy_price+=parseInt(removeComma(goods_buy_price.eq(i)));
						}
						
						$("#total_price").text(total_buy_price);
						$("#total_price").text(setComma($("#total_price")));
						
						$("input[name=checkOne]").prop("checked",true);
						$("#allCheck").prop("checked",true);

					}else if(data=="failed"){
						alert("삭제에 실패하였습니다 다시 시도 해주세요");
					}
				},
				error:function(jqXHR, textStatus, errorThrown){
					console.log("장바구니 선택 상품 삭제실패 \n" + textStatus + " : " + errorThrown);
				}
			});//$.ajax
		}//if
	});
	
	
	//폼전송시
	$("#cart_form").submit(function(){
		
		if(!$("input[name=checkOne]").is(":checked")){
			alert('상품을 선택하세요.');
			return false;
		}else{
			var checkArr = [];
			$("input[name=checkOne]:checked").each(function(i){
				checkArr.push($(this).val());
			});
			
			$("input[name=checkArr]").val(checkArr);
			$("#cart_form").attr("action","goodsOrdersForm.mo");
			
		}
		
		
	});
	
});