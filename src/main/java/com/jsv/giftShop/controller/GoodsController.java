package com.jsv.giftShop.controller;


import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

public interface GoodsController {

	//기프트샵 메인 - 상품목록
	public ModelAndView getIndexGoodsList(ModelAndView mv) throws Exception;
	
	//상품 상세조회
	public ModelAndView getGoodsDetail(@RequestParam("goods_no") int goods_no,ModelAndView mv) throws Exception;
	
	//카테고리별 상품조회
	ModelAndView getCateGoodsList(@RequestParam("goods_cate_no")int goods_cate_no, ModelAndView mv) throws Exception;
}
