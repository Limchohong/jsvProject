package com.jsv.giftShop.service;

//장바구니 서비스
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsv.giftShop.dao.CartDAO;
import com.jsv.giftShop.dto.GoodsCartDTO;

@Service("CartService")
public class CartServiceImpl implements CartService {

	@Autowired
	private CartDAO cartDAO;
	
	//장바구니 담기
	@Override
	public int addCart(GoodsCartDTO cartDTO) throws Exception {
		return cartDAO.addCart(cartDTO);
	}
	
	//장바구니 목록조회
	@Override
	public List<GoodsCartDTO> getCartList(int userno) throws Exception {
		return cartDAO.getCartList(userno);
	}
	
	//장바구니 수량변경
	@Override
	public int setCartQty(Map<String, Integer> cartMap) throws Exception {
		return cartDAO.setCartQty(cartMap);
	}
	
	//장바구니 체크박스 선택 삭제
	@Override
	public int removeCheckedCart(List<Integer> checkArr) throws Exception {
		int result = 0;
		for(int goods_cart_no:checkArr) {
			result += cartDAO.removeCart(goods_cart_no);
		}
		System.out.println("카트 서비스 result="+result);
		return result;
	}

}
