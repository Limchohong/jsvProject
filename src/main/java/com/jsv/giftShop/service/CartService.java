package com.jsv.giftShop.service;

//장바구니 인터페이스
import java.util.List;
import java.util.Map;

import com.jsv.giftShop.dto.GoodsCartDTO;

public interface CartService {

	//장바구니 담기
	public int addCart(GoodsCartDTO cartDTO) throws Exception;
	
	//장바구니 목록조회
	public List<GoodsCartDTO> getCartList(int userno) throws Exception;
	
	//장바구니 수량변경
	public int setCartQty(Map<String, Integer> cartMap) throws Exception;
	
	//장바구니 체크박스 선택삭제 
	public int removeCheckedCart(List<Integer> checkArr) throws Exception;

}
