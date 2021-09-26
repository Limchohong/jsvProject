package com.jsv.giftShop.service;

//주문 인터페이스
import java.util.List;
import java.util.Map;

import com.jsv.giftShop.dto.GoodsOrderDTO;

public interface OrderService {

	//결제 폼 보여주기 - 장바구니 / 결제상품 목록
	public List<Map<String,Object>> getCartList(List<Integer> checkArr) throws Exception;
	
	//결제폼 보여주기 - 회원이름 , 휴대폰번호
	public Map<String,Object> getMemberInfo(int userno) throws Exception;
	
	//결제 폼 보여주기 - 상품상세 구매시
	public List<Map<String,Object>> getOrderGoods(int goods_no) throws Exception;
	
	//결제처리
	public List<Map<String,String>> newGoodsOrder(GoodsOrderDTO goodsOrderDTO, Map<String, Object> map) throws Exception;
	
	//주문 목록 보기 
	public List<Map<String,Object>> getOrderList(int userno) throws Exception;

	//주문 상세내역 조회
	public List<Map<String, Object>> getOrderDetail(String goods_order_no) throws Exception;
}
