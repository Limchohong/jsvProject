package com.jsv.giftShop.dao;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.jsv.giftShop.dto.GoodsCartDTO;

public interface CartDAO {
	
	//장바구니 담기
	public int addCart(GoodsCartDTO cartDTO) throws DataAccessException;
	
	//장바구니 목록 조회
	public List<GoodsCartDTO> getCartList(int userno) throws DataAccessException;
	
	//장바구니 수량변경
	public int setCartQty(Map<String, Integer> cartMap) throws DataAccessException;
	
	//장바구니 삭제 
	public int removeCart(int goods_cart_no) throws DataAccessException;

}
