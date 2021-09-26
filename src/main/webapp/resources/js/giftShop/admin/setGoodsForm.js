/**
 * 상품 수정 폼 js

 */


//첨부파일 미리보기
function readInputFile(input) {
    if(input.files && input.files[0]) {
        var reader = new FileReader();
        reader.onload = function (e) {
            $('#preview').html("<img src="+ e.target.result +" id=previewImg alt=첨부파일 미리보기>");
            $('#previewImg').css({"height":"232.938","width":"232.938"});
        }
        reader.readAsDataURL(input.files[0]);
    }
}
 
//금액 컴마 제거 
function removeComma(value){
    return value.replace(/[^\d]+/g, ""); }

//숫자 유효성 검사
function numberCheck(value){
	return value.replace(/[^0-9]/g,""); }

//콤마 직접 입력시 공백
function strCommaCheck(value){
	return value.replace(/,/g,""); }

//3자리 컴마 
function setComma(value){
	value = String(value);
	return value.replace(/\B(?=(\d{3})+(?!\d))/g, ",");
}

//공백인 경우 속성 추가 
function blankCheck (value,str,cateDefault){
	if(cateDefault=="default"){
		return;
	}else{
		alert(str);
		value.focus();
		value.attr("placeholder",str);
	}
}

$(document).ready(function(){
	
	$("#fileType").css({"font-size":"1rem","color":"gray"});
	//첨부파일 값 변경시 & 확장자 체크
	$("#goods_img").on('change', function(){
		if($(this).val()!=""){
			var ext =$(this).val().split(".").pop().toLowerCase();
			if($.inArray(ext,["gif","jpg","jpeg","png"])== -1){
				$(this).val("");
				$('#preview').html("");
				alert("해당 파일은 업로드 할 수 없습니다\n"+ 
					  "gif, jpg, jpeg, png 파일만 업로드 가능합니다");
				return;
			}else{
			    readInputFile(this);
			}
		}
	});
	
	$("#goods_price").keyup(function(){//정가 유효성 검사 (숫자가 아닐 경우 value 비우기)
		var value = $("#goods_price");
		value.val(numberCheck(value.val()));	//숫자검사
		value.val(strCommaCheck(value.val()));	//,컴마입력 검사
		value.val(setComma(value.val()));		//3자리 ,찍기
	});
		
	$("#setGoodsFrm").submit(function(){//폼 전송시 
			
		//금액 컴마 제거 
		if( $("#goods_price").val().includes(",") ){
			var price = $("#goods_price");
			price.val(removeComma(price.val()));
		}
		
		//카테고리 유효성 검사
		if( $("#goods_cate_no").val()=="default"){
			alert("카테고리 선택은 필수입니다");
			return false;
		}
		
		//상품명 유효성 검사
		if( $("#goods_name").val().length<1 ){
			blankCheck($("#goods_name"),"상품명은 필수 입력입니다");
			return false;
		}
		
		//상품구성 유효성 검사
		if( $("#goods_comp").val().length<1 ){
			blankCheck($("#goods_comp"),"상품 구성은 필수 입력입니다");
			return false;
		}
		
		//상품가격 유효성 검사
		if( $("#goods_price").val().length<1 ){
			blankCheck($("#goods_price"),"가격은 필수 입력입니다");
			return false;
		}
		
		//유효기간 유효성 검사
		if( $("#goods_validity").val().length<1 ){
			blankCheck($("#goods_validity"),"유효기간은 필수 입력입니다");
			return false;
		}
		
		//상품설명 유효성
		if( $("#goods_detail_desc1").val().length<1 ){
			blankCheck($("#goods_detail_desc1"),"상품설명은 필수 입력입니다");
			return false;	
		}
		
		//이용안내 유효성
		if( $("#goods_detail_desc2").val().length<1 ){
			blankCheck($("#goods_detail_desc2"),"이용안내는 필수 입력입니다");
			return false;	
		}
		
		//취소 & 환불 유효성
		if( $("#goods_detail_desc3").val().length<1 ){
			blankCheck($("#goods_detail_desc3"),"취소/환불 안내는 필수 입력입니다");
			return false;	
		}
		
		//미성년자 권리보호 안내
		if( $("#goods_detail_desc4").val().length<1 ){
			blankCheck($("#goods_detail_desc4"),"미성년자 권리보호 안내는 필수 입력입니다");
			return false;	
		}
		
		//분쟁해결 안내
		if( $("#goods_detail_desc5").val().length<1 ){
			blankCheck($("#goods_detail_desc5"),"분쟁해결 안내는 필수 입력입니다");
			return false;	
		}
		
		//상품이미지
		if($('#preview').html()==''){
			alert("상품 이미지 등록은 필수입니다.");
			return false;
		}
	}); //form전송시끝
});