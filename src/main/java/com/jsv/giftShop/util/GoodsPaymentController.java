package com.jsv.giftShop.util;

//상품 구매 결제 검증 관련

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.siot.IamportRestClient.IamportClient;
import com.siot.IamportRestClient.response.IamportResponse;
import com.siot.IamportRestClient.response.Payment;

@Controller("PaymentsController")
public class GoodsPaymentController {
	
	private IamportClient api;
	
	//결제 검증
	@ResponseBody
	@RequestMapping(value="/verifyIamport.mo", method=RequestMethod.POST, produces = "application/json")
	public IamportResponse<Payment> paymentsComplete(HttpServletRequest request, HttpServletResponse response,
			 @RequestParam(value= "imp_uid") String imp_uid) throws Exception{
		
		//토큰을 발급 받기 위해 
		//IamportClient생성자를 통해 REST API 키와 REST API secret를 이용하여 객체 생성
		this.api  = new IamportClient("9687728674866571",
				"91b5205883d34b20e4f8086d799ad84953e8aa9dafad85de719ea2e73bf500274f94c2634bcdb59e");
		
		//아임포트서버에서 imp_uid(거래 고유번호)를 검사하여, 데이터 전달
		return api.paymentByImpUid(imp_uid);
	}
	

}