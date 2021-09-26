package com.jsv.giftShop.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.jsv.giftShop.dto.GoodsOrderDTO;

@Repository("OrderDAO")
public class OrderDAOImpl implements OrderDAO {

	@Autowired
	private SqlSession session;
	
	//결제 폼 보여주기 - 결제할 상품 목록 조회
	@Override
	public Map<String, Object> getCartList(int goods_cart_no) throws DataAccessException {
		return session.selectOne("goods_payment.getOrdersList", goods_cart_no);
	}
	
	//결제 폼 보여주기 - 회원이름, 휴대폰 번호 
	public Map<String, Object> getMamberInfo(int userno) throws DataAccessException{
		return session.selectOne("goods_payment.getMemberInfo",userno);
	}

	//결제 폼 보여주기 - 상품상세 구매시
	@Override
	public Map<String, Object> getGoodsInfo(int goods_no) throws DataAccessException {
		return session.selectOne("goods_payment.getOrderGoods", goods_no);
	}

	//결제처리 - 주문테이블
	@Override
	public int newGoodsOrder(GoodsOrderDTO goodsOrderDTO) throws DataAccessException {
		return session.insert("goods_payment.newGoodsOrder", goodsOrderDTO);
	}

	//결제처리 - 주문 상세 테이블
	@Override
	public int newGoodsOrderDetail(Map<String, Object> map) throws DataAccessException {
		return session.insert("goods_payment.newGoodsOrderDetail", map);
	}

	//기프티콘 조회
	public List<Map<String,String>> getGiftcone(String goods_order_no) throws DataAccessException{
		return session.selectList("goods_payment.getGiftcone", goods_order_no);
	}

	//주문목록 보여주기
	@Override
	public List<Map<String,Object>> getOrderList(int userno) throws DataAccessException {
		return session.selectList("goods_payment.getOrderList", userno);
	}

	//주문 상세내역 조회
	@Override
	public List<Map<String, Object>> getOrderDetail(String goods_order_no) throws DataAccessException {
		return session.selectList("goods_payment.getOrderDetail", goods_order_no);
	}
	
}
