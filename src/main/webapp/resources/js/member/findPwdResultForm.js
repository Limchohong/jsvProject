/**
 * 비밀번호 찾기 후 비밀번호 재설정시 빈값 유효성 검사 & 비밀번호 변경 js
 */

function setPwd(id){

	var pwd = $("#u_password").val();
	
	if($("#u_password").val()==""){ 
		alert("변경할 비밀번호는 필수입력입니다.");
		$("#u_password").focus(); 
		return false;
	}
	
	if($("#u_password2").val()==""){ 
		alert("변경할 비밀번호 확인은 필수입력입니다.");
		$("#u_password2").focus(); 
		return false;
	}
	
	if($("#u_password2").val()!=$("#u_password").val()){ 
		alert("변경할 비밀번호와 확인용 비밀번호가 일치하지 않습니다");
		$("#u_password2").focus(); 
		return false;
	}
	
	$.ajax({
		type:"post",
		url :"setPwd.mo",
		data:{"u_id":id,
			  "u_password":pwd
			 },
		contentType:"application/x-www-form-urlencoded; charset=UTF-8",
		success:function(data){
			if(data>0){
				alert("비밀번호가 재설정 되었습니다.");
				location.href="loginForm.mo";
			}else if(data<0){
				alert("비밀번호 재설정에 실패하였습니다\n다시 시도해주세요");
				$("#u_password").val("");
				$("#u_password2").val("");
			}
		},
		error:function(jqXHR, textStatus, errorThrown){
			console.log(textStatus + " : " + errorThrown);
		}
	});//$.ajax
	
}