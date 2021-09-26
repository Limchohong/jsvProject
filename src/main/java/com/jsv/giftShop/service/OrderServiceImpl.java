package com.jsv.giftShop.service;

//주문 서비스 
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsv.giftShop.dao.OrderDAO;
import com.jsv.giftShop.dto.GoodsOrderDTO;

@Service("OrderService")
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderDAO orderDAO;
	
	//결제 폼 보여주기 - 장바구니-결제할 상품 목록
	@Override
	public List<Map<String,Object>> getCartList(List<Integer> checkArr) throws Exception{
		
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		for(int i:checkArr) {
			Map<String, Object> result = orderDAO.getCartList(i);
			list.add(result);
		}
		return list;
	};
	
	//결제폼 보여주기 - 회원이름, 휴대폰 번호
	@Override
	public Map<String,Object> getMemberInfo(int userno) throws Exception{
		return orderDAO.getMamberInfo(userno);
	}

	//결제 폼 보여주기 - 상품상세 구매시
	@Override
	public List<Map<String, Object>> getOrderGoods(int goods_no) throws Exception {
		List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();
		list.add(orderDAO.getGoodsInfo(goods_no));
		return list;
	}

	//결제처리
	@Override
	public List<Map<String,String>> newGoodsOrder(GoodsOrderDTO goodsOrderDTO, Map<String, Object> map) throws Exception {
		
		int result = orderDAO.newGoodsOrder(goodsOrderDTO);	//주문
		List<Map<String,String>> giftcones = null;
		if(result > 0) {
			result = orderDAO.newGoodsOrderDetail(map);	//주문 상세 
			if(result>0) {	//주문번호로 주문상세 테이블의 기프티콘 번호 조회 
				giftcones = orderDAO.getGiftcone(goodsOrderDTO.getGoods_order_no());
				return giftcones;
			}else {
				return giftcones;
			}
		}else {
			return giftcones;
		}
	}
	
	//주문 목록 보기
	@Override
	public List<Map<String,Object>> getOrderList(int userno) throws Exception{
		return orderDAO.getOrderList(userno);
	}
	
	//주문 상세내역 조회
	@Override
	public List<Map<String, Object>> getOrderDetail(String goods_order_no) throws Exception {
		return orderDAO.getOrderDetail(goods_order_no);
	}

}
