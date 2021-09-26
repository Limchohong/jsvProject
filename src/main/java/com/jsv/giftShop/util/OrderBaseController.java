package com.jsv.giftShop.util;

//상품 주문시 사용되는 메서드 따로 빼놓은 클래스
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Random;

import org.json.simple.JSONObject;

import net.nurigo.java_sdk.api.Message;

public class OrderBaseController {

	//주문번호 생성
	public String getOrderNo() {
		
		String now = new SimpleDateFormat("yyyyMMdd").format(new Date());
		String now2 = new SimpleDateFormat("HHmmss").format(System.currentTimeMillis());

		String orderNo = now+"_"+now2;
		return orderNo;
	}
	
	//기프티콘 일련번호 생성 (12자리)
	public String getGiftconeNum() {
		Random random=new Random();  //난수 생성을 위한 랜덤 클래스
		String getOrderNo="";  //기프티콘 담을 변수 
		
		//입력 키를 위한 코드
		for(int i =0; i<8;i++) {
			int index=random.nextInt(25)+65; //A~Z까지 랜덤 알파벳 생성
			getOrderNo+=(char)index;
		}
		int numIndex=random.nextInt(9999)+1000; //4자리 랜덤 정수를 생성
		getOrderNo+=numIndex;
        return getOrderNo;
	}
	
	//기프티콘 sms발송
	//sms전송
	public void sendsms(String order_ph,String text) {
		
		//파라미터 받기
		String ph = "01048215882";
		String api_key = "NCSA04XALZ6LG2UW"; 					//사이트에서 발급 받은 API KEY 
		String api_secret = "C5ZL3ZU7SQZSZNK6UN25LCYEWPOI0UGM"; //사이트에서 발급 받은 API SECRET KEY 
		Message coolsms = new Message(api_key, api_secret); 
		
		HashMap<String, String> params = new HashMap<String, String>(); 
		params.put("to", order_ph);     //문자 받는 사람 번호 
		params.put("from", ph);     	//사전에 사이트에서 번호를 인증하고 등록하여야 함 
		params.put("type", "SMS");  	//보낼 타입
		params.put("text", text);   	//메시지 내용 
		params.put("app_version", "test app 1.2"); 
		
		try { 
			JSONObject obj = (JSONObject) coolsms.send(params); 
			System.out.println(obj.toString()); //전송 결과 출력
			} catch (Exception e) { 
				System.out.println(e.getMessage()); 
				System.out.println(e); 
			}
		}

}
