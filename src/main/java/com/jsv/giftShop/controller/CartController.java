package com.jsv.giftShop.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

//장바구니 관련 인터페이스
public interface CartController {
	
	//장바구니 담기
	public String addCart(HttpServletRequest request,
			@RequestParam("goods_no") int goods_no,
			@RequestParam("goods_cart_qty") int goods_cart_qty) throws Exception;

	//장바구니 목록 조회
	public ModelAndView getCartList(HttpServletRequest request) throws Exception;
	
	//장바구니 수량변경
	public String setCartQty(@RequestParam("cart_no") int goods_cart_no,
						    @RequestParam("qty") int goods_cart_qty) throws Exception;

	//장바구니 체크박스 선택 삭제 
	public String removeCheckedCart(@RequestParam("checkArr[]") List<Integer> checkArr) throws Exception;
	
}
