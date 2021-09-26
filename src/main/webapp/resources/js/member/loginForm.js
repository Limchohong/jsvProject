/**
 * 로그인 폼 빈값 유효성 검사 & 회원 활동여부 확인
 */

function login(f_obj){
	var u_id = f_obj.u_id.value;
	var u_password = f_obj.u_password.value;
	
	if(u_id==""){
		f_obj.u_id.focus();
		alert("ID를 입력하세요");
		return;
	}
	
	if(u_password==""){
		f_obj.u_password.focus();
		alert("비밀번호를 입력하세요");
		return;
	}
	
	$.ajax({
		type:"post",
		url :"login.mo",
		data:{"u_id":u_id,
			  "u_password":u_password
			 },
		contentType:"application/x-www-form-urlencoded; charset=UTF-8",
		dataType:"json",
		success:function(data){
			if(data.code=="success"){
				location.href="../main.mo";
			}else if(data.code=="withdrawal"){
				alert('탈퇴한 ID입니다.');
			}else if(data.code=="stop"){
				alert('이용정지된 ID입니다.\n문의사항은 고객센터(02-0000-0000)로 문의 바랍니다.');
			}else if(data.code=="loginFailed"){
				alert('아이디 또는 패스워드가 맞지 않습니다. 확인 후 입력해주세요.');
			}
		},
		error:function(jqXHR, textStatus, errorThrown){
			console.log(textStatus + " : " + errorThrown);
		}
	});//$.ajax
}