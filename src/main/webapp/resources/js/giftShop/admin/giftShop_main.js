/**
 * 기프트샵 관리자 메인 js
 */

//삭제 링크 클릭시
function removeGoods(goods_no,Obj){
	if(confirm("삭제하시겠습니까?")){
		Obj.href = "../admin/gift-shop/removeGoods.mo?goods_no="+goods_no;
	}
}

$(document).ready(function(){
	
	//전체선택 & 해제
	$("#allCheck").click(function(){
		var checked = $("input[name=checkOne]").is(":checked");
		var checkLength = $("input[name='checkOne']").length;
		var checkedLength =  $("input[name='checkOne']:checked").length;
		
		if(!checked || checkLength!=checkedLength){
			$("input[name=checkOne]").prop("checked",true);
		}else{
			$("input[name=checkOne]").prop("checked",false);
		}
	});//$("#allCheck").click
	
	$("input[name='checkOne']").click(function(){
		var checkLength = $("input[name='checkOne']").length;
		var checkedLength =  $("input[name='checkOne']:checked").length;
		
		if(checkLength==checkedLength){
			$("#allCheck").prop("checked",true);
		}else{
			$("#allCheck").prop("checked",false);
		}
	});//$("input[name='checkOne']")
	
	//체크박스 선택 후 삭제버튼 클릭시 
	$("#checkRemove").click(function(){
		var checkArr = [];
		$("input[name='checkOne']:checked").each(function(i){
			checkArr.push($(this).val());
		});
		
		if(checkArr==""||checkArr.length==0){
			alert("삭제할 상품을 선택해주세요");
			return;
		}
		
		if(confirm("체크된 상품을 삭제 하시겠습니까?")){
			$.ajax({
				type:"post",
				url :"./gift-shop/removeCheckedGoods.mo",
				data:{"checkArr":checkArr},
				contentType : "application/x-www-form-urlencoded; charset=UTF-8",
				success:function(data){
					if(data=="success"){
						alert("상품이 삭제되었습니다");
						$.each(checkArr, function(index, item){                               
							 $(".goods_item"+item).remove();
						});
					}else if(data=="failed"){
						alert("상품 삭제에 실패하였습니다 다시 시도 해주세요");
					}
				},
				error:function(jqXHR, textStatus, errorThrown){
					console.log("삭제실패 \n" + textStatus + " : " + errorThrown);
				}
			});//$.ajax
		}//if
	});//$("#checkRemove")

});