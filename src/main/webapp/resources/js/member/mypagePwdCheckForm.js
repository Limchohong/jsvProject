/**
 * 마이페이지 비밀번호 확인폼 js
 */

function check(){
	var u_password = $("#u_password").val();
	
	if(u_password==''){
		alert("비밀번호를 입력해 주세요");
		return;
	}
	
	$.ajax({
		type:"post",
		url :"pwdCheck.mo",
		data:{"u_password":u_password},
		contentType : "application/x-www-form-urlencoded; charset=UTF-8",
		dataType:"json",
		success:function(data){
			console.log(data);
			if(data>0){
				location.href="mypage.mo";
			}else{
				alert("비밀번호가 일치하지 않습니다");
			}
		},
		error:function(jqXHR, textStatus, errorThrown){
			console.log("비밀번호 조회 실패 \n" + textStatus + " : " + errorThrown);
		}
	});//$.ajax
	
}