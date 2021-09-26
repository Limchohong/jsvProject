package com.jsv.giftShop.dao;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.jsv.giftShop.dto.GoodsOrderDTO;

public interface OrderDAO {
	
	//결제 폼 보여주기 - 장바구니 구매시 - 상품목록
	public Map<String,Object> getCartList(int goods_cart_no) throws DataAccessException;

	//결제 폼 보여주기 - 회원이름, 휴대폰 번호 
	public Map<String, Object> getMamberInfo(int userno) throws DataAccessException;

	//결제 폼 보여주기 - 상품상세 구매시
	public Map<String,Object> getGoodsInfo(int goods_no) throws DataAccessException;

	//결제처리 (주문테이블)
	public int newGoodsOrder(GoodsOrderDTO goodsOrderDTO) throws DataAccessException;

	//결제처리 (주문상세테이블)
	public int newGoodsOrderDetail(Map<String, Object> map) throws DataAccessException;
	
	//기프티콘 조회
	public List<Map<String,String>> getGiftcone(String goods_order_no) throws DataAccessException;
	
	//주문목록조회
	public List<Map<String,Object>> getOrderList(int userno) throws DataAccessException;

	//주문 상세내역 조회
	public List<Map<String, Object>> getOrderDetail(String goods_order_no) throws DataAccessException;

}
