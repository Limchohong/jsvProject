/**
 * 회원가입시 적용되는 js
 */
$(document).ready(function(){
	var code = "";				//인증번호를 담을 변수
	var idCheckResult = 0; 		//id체크 여부를 담을 변수
	var mailCheckResult = 0;	//이메일 인증 여부를 담을 변수
	
	//ID중복체크 버튼 클릭시 
	$("#idCheck").click(function(){
		var u_id = $("#u_id").val();
		if(u_id==''){
			alert('ID를 입력하세요');
			$("#u_id").focus();
			return;
		}else{
			$.ajax({
				url:"idChk.mo",
				type:"post",
				dataType:"json",
				data:{"u_id":$("#u_id").val()},
				success:function(data){
					if(data==1){	//중복된 ID일 경우 ID입력칸 초기화
						alert("중복된 ID입니다.");
						$("#u_id").val("");
						$("#u_id").focus();
						idCheckResult = 1;
						return;
					}else if(data==0){
						alert("사용가능한 ID입니다.");
					}
				}
			});
		}
	});
	
	//이메일 인증번호 받기 버튼 클릭시 
	$("#getProof").click(function(){
		
		//클라이언트가 입력한 email
		var email = $("#u_email").val();	
		
		//검증에 사용할 정규식 변수 regExp에 저장 
		var regExp = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i; 
		
		if(email==''){
			alert("이메일을 입력해주세요");
			$("#u_email").focus();
			return;
		}else if(email.match(regExp) == null){
			alert('올바른 이메일을 입력해주세요');
			$("#u_email").val("");
			$("#u_email").focus();
			return;
		}else{
			$.ajax({
				url:"sendMail.mo",
				type:"post",
				data:{"email":email},
				success:function(data){
					if(data!=""){
						$("#mail_check").attr("disabled",false); 	 //인증번호 입력란 활성화
						$("#mail_check").focus();					 //인증번호 입력란 포커싱
						$("#btn_mail_check").attr("disabled",false); //인증하기 버튼 활성화 
						mailCheckResult = 1;
						code=data;									 //전엳변수 code에 인증코드 넣기
					}else if(data==""){
						alert("중복된 이메일입니다.\n다른 이메일을 입력해주세요");
						$("#u_email").val("");
						$("#u_email").focus();
					}
				}
			});
		}
	});
	
	$("#btn_mail_check").click(function(){
		var checkValue = $("#mail_check").val();
		if(code!=checkValue){
			alert("인증번호가 일치하지 않습니다");
		}else{
			alert("인증이 완료되었습니다");
			
		}
	});
	
	//가입 폼 전송시 빈 값 유효성검사
	$("#joinForm").submit(function(){
		
		if($("#u_name").val()==""){
			alert("이름은 필수입력입니다.");
			$('html').scrollTop(0);
			$("#u_name").focus(); 
			return false;
		}
		
		if($("#u_id").val()==""){
			alert("id는 필수입력입니다.");
			$('html').scrollTop(0);
			$("#u_id").focus();
			return false;
		}
		
		if(idCheckResult<0){
			alert("ID중복체크는 필수입니다.");
			$('html').scrollTop(0);
			return false;
		}
		
		if($("#u_password").val()==""){ 
			alert("비밀번호는 필수입력입니다.");
			$("#u_password").focus(); 
			return false;
		}
		
		if($("#u_password2").val()==""){ 
			alert("비밀번호 확인은 필수입력입니다.");
			$("#u_password2").focus(); 
			return false;
		}
		
		if($("#u_password2").val()!=$("#u_password").val()){ 
			alert("비밀번호와 확인용 비밀번호가 일치하지 않습니다");
			$("#u_password2").focus(); 
			return false;
		}
		
		
		if($("#u_nic").val()==""){ 
			alert("닉네임은 필수입력입니다.");
			$("#u_nic").focus(); 
			return false;
		}
		
		if($("#u_phone").val()==""){ 
			alert("휴대폰번호는 필수입력입니다.");
			$("#u_phone").focus(); 
			return false;
		}
	
		if($("#u_email").val()==""){ 
			alert("이메일은 필수입력입니다.");
			$("#u_email").focus(); 
			return false;
		}
		
		if(mailCheckResult==0){
			alert("이메일 인증은 필수입니다");
			return false;
		}
		
		//휴대폰 번호에 대시바가 있을 경우 제거 
		if($("#u_phone").val().includes("-")){
			$("#u_phone").val($("#u_phone").val().replace(/-/g,""));
		}
	
		$("#joinForm").attr("method","post");
		$("#joinForm").attr("action","signup.mo");
		return true;
		
	});
});