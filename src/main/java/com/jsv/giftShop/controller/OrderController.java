package com.jsv.giftShop.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

public interface OrderController {

	//결제 폼 보여주기 - 장바구니 구매시
	public ModelAndView goodsOrdersForm(ModelAndView mv,
			@RequestParam("checkArr[]") List<Integer> checkArr) throws Exception;
	
	//결제 폼 보여주기 - 상품 상세에서 구매시
	public ModelAndView goodsOrderForm(HttpServletRequest request,HttpServletRequest response,
										ModelAndView mv,
										@RequestParam("goods_no") int goods_no,
										@RequestParam("qty") int qty) throws Exception;
	
	//결제처리
	public int newGoodsOrder (HttpServletRequest request,
								@RequestParam("goods_qty[]") List<Integer> goods_qty,
								@RequestParam("goods_no[]") List<Integer> goods_no,
								@RequestParam("goods_price[]") List<Integer> goods_price,
								@RequestParam("user_ph") int user_ph,
								@RequestParam("sum") int sum) throws Exception;
	
	//결제 성공,실패 페이지 리턴
	public ModelAndView isOrderComplete(ModelAndView mv, @RequestParam("code") int code) throws Exception;
	
	//결제 성공시
	public ModelAndView successOrderComplete(ModelAndView mv) throws Exception;
	
	//결제 실패시
	public ModelAndView failedOrderComplete(ModelAndView mv, @RequestParam("code") int code) throws Exception;
	
	//주문내역 조회
	public ModelAndView getOrderList(HttpServletRequest request,ModelAndView mv) throws Exception;
	
	//주문 상세내역 조회 
	public ModelAndView getOrderDetail(ModelAndView mv,
			@RequestParam("order_no") String goods_order_no) throws Exception;
}
