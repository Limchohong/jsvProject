/**
 * 마이페이지 정보 수정 관련 빈값 유효성 검사_탈퇴처리 js
 */


$(document).ready(function(){
	//비밀번호 변경 버튼 클릭시 동적으로 input박스 생성
	$("#set_pwd").one('click',function(){
			$(this).parent().next().append("<input type='password' id='u_password' name='u_password' placeholder='비밀번호를 입력해주세요'>")
			$(this).parent().parent().after("<tr>"+
											 	"<td>비밀번호 확인</td>"+
											 	"<td>"+
											 		"<input type='password' id='u_con_password' name='u_con_password' placeholder='비밀번호를 재입력해주세요'>"+
											 	"</td>"+
											 "</tr>");
	});
	
	//수정버튼 클릭시 
	$("#setMyPageInfo").click(function(){
		
		if($("#u_nic").val()==''){
			alert("닉네임을 입력해주세요");
			$("#u_nic").focus();
			return;
		}
		
		if($("#u_password").val() ==''){
			alert("비밀번호를 입력해주세요");
			$("#u_password").focus();
			return;
		}
		
		if($("#u_con_password").val() ==''){
			alert("비밀번호 확인을 입력해주세요");
			$("#u_con_password").focus();
			return;
		}
		
		if($("#u_password").val()!=$("#u_con_password").val()){
			alert("비밀번호와 비밀번호 확인이 일치하지 않습니다");
			$("#u_password").focus();
			return;
		}
		
		if($("#u_phone").val()==''){
			alert("휴대폰 번호를 입력해주세요");
			$("#u_phone").focus();
			return;
		}
		
		if($("#u_phone").val().includes("-")){
			$("#u_phone").val($("#u_phone").val().replace(/-/g,""));
		}
	
		if($("#u_email").val()==''){
			alert("이메일을 입력해주세요");
			$("#u_email").focus();
			return;
		}
		
		var formData = $("#setMemberInfoFrm").serialize();
		
		$.ajax({
			type:"post",
			url :"setMypageInfo.mo",
			data:formData,
			contentType : "application/x-www-form-urlencoded; charset=UTF-8",
			success:function(data){
				if(data==1){
					alert("수정이 완료되었습니다");
				}else{
					alert("수정이 실패되었습니다. 다시 수정해주세요");
				}
			},
			error:function(jqXHR, textStatus, errorThrown){
				console.log("수정실패 \n" + textStatus + " : " + errorThrown);
			}
		});//$.ajax
		
	});//setMyPageInfo
		
	//탈퇴버튼 클릭시
	$("#withdrawal").click(function(){
		if(confirm("탈퇴하시겠습니까?")){
			$.ajax({
				type:"post",
				url :"withdrawal.mo",
				success:function(data){
					if(data==1){
						alert("탈퇴가 완료되었습니다.\n탈퇴 후 재가입시 기존 ID는 사용할 수 없습니다.");
						location.href="../"
					}else{
						alert("탈퇴에 실패하였습니다");
					}
				},
				error:function(jqXHR, textStatus, errorThrown){
					console.log("탈퇴실패 \n" + textStatus + " : " + errorThrown);
				}
			});//$.ajax
		}
	});//withdrawal
});
