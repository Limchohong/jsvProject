package com.jsv.member.controller;

import java.util.Random;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

//이메일 인증 컨트롤러
public class MailController {
	
	@Autowired
    private JavaMailSender mailSender;
	
	public String mailSend(String email) {
		
		//랜덤 알파벳과 랜덤 정수 생성을 위한 Random 객체 생성
		Random random = new Random();
		
		String code="";  //인증번호를 담을 변수
		
		try {
			for(int i =0; i<8;i++) {
				int index=random.nextInt(25)+65; //A~Z까지 랜덤 알파벳 생성
				code+=(char)index;
			}
			
			int numIndex=random.nextInt(9999)+1000; //4자리 랜덤 정수를 생성
			code+=numIndex;
			
			//메일 발송할 내용
			String content =  "JSV 홈페이지를 방문해주셔서 감사합니다." +
					"<br><br>" + 
					"인증 번호는 " + code + "입니다." + 
					"<br>" + 
					"해당 인증번호를 인증번호 확인란에 기입하여 주세요.";
			
			//메일내용 설정을 위한 객체 생성
			SimpleMailMessage message = new SimpleMailMessage();

			message.setFrom("y_0511@naver.com");	//발신자 메일 주소
			message.setTo(email);					//수신자 메일 주소
			message.setSubject("JSV이메일 인증");		//메일 제목
			message.setText(content);			    //메일 내용
            mailSender.send(message);				//메세지 전송
            return code;
        }catch(Exception e) {
            e.printStackTrace();
            return code;
        }
	}
}
