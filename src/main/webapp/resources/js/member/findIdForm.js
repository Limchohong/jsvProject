/**
 *  id찾기 폼 빈칸 유효성검사
 */
$(document).ready(function(){
	$("#findForm").submit(function(){
		
		if($("#u_name").val()==""){
			alert("이름을 입력해주세요");
			$("#u_name").focus();
			return false;
		}
		
		if($("#u_email").val()==""){
			alert("가입시 등록한 이메일을 입력해주세요");
			$("#u_email").focus();
			return false;
		}
		
		$(this).attr("method","post");
		$(this).attr("action","findId.mo");
	});
});