package com.jsv.giftShop.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.jsv.giftShop.dto.GoodsCartDTO;

@Repository("CartDAO")
public class CartDAOImpl implements CartDAO {

	@Autowired
	private SqlSession session;
	
	//장바구니 추가
	@Override
	public int addCart(GoodsCartDTO cartDTO) throws DataAccessException {
		return session.insert("cart.addCart", cartDTO);
	}
	
	//장바구니 목록 조회
	@Override
	public List<GoodsCartDTO> getCartList(int userno) throws DataAccessException {
		return session.selectList("cart.getCartList", userno);
	}
	
	//장바구니 수량변경
	@Override
	public int setCartQty(Map<String, Integer> cartMap) throws DataAccessException {
		return  session.update("cart.setCartQty", cartMap);
	}
	
	//장바구니 삭제 
	@Override
	public int removeCart(int goods_cart_no) throws DataAccessException {
		return session.delete("cart.removeCart", goods_cart_no);
	}
}
