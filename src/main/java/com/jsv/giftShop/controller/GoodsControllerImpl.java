package com.jsv.giftShop.controller;


import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.jsv.giftShop.dto.GoodsCateDTO;
import com.jsv.giftShop.dto.GoodsDTO;
import com.jsv.giftShop.service.GoodsService;

@Controller("GoodsController")
public class GoodsControllerImpl implements GoodsController {
	
	@Autowired
	private GoodsService goodsService;
	
	//기프트샵 메인 - 상품 목록
	@Override
	@RequestMapping("/gift-shop.mo")
	public ModelAndView getIndexGoodsList(ModelAndView mv) throws Exception {
		
		//DB에서 가져온 상품 정보를 Map안에 List타입으로 받음 
		Map<String, List<GoodsDTO>> goodsMap = goodsService.getGoodsList();
		
		//DB에서 가져온 카테고리의 정보를 List타입 카테고리DTO로 받음
		List<GoodsCateDTO> catesList = goodsService.getGoodsCates();
		
		//상품정보들을 view에 전달
		mv.addObject("goodsMap", goodsMap);

		//카테고리 정보들을 view에 전달
		mv.addObject("catesList",catesList);
		
		//view지정
		mv.setViewName("/giftShopMain");
		return mv;
	}
	
	//상품 상세조회
	@Override
	@RequestMapping("/gift-shop/goodsDetail.mo")
	public ModelAndView getGoodsDetail(@RequestParam("goods_no") int goods_no,
									   ModelAndView mv) throws Exception {
		
		//파라미터로 받은 상품번호로 DB에서 조회 후 해당 상품의 정보를 Map으로 return받음
		Map<String, String> goodsMap = goodsService.getGoodsDetail(goods_no);
		
		//해당 상품의 상세정보를 view에 전달
		mv.addObject("goodsMap", goodsMap);
		
		//view지정
		mv.setViewName("/goods/goodsDetail");
		return mv;
	}
	
	//카테고리별 상품조회
	@Override
	@RequestMapping("/gift-shop/getCateGoodsList.mo")
	@ResponseBody
	public ModelAndView getCateGoodsList(@RequestParam("goods_cate_no") int goods_cate_no,
									   ModelAndView mv) throws Exception {
		
		//파라미터로 받은 카테고리 번호로 DB에서 조회 후 해당 카테고리에 해당되는 상품의 정보를 return받음
		List<Object> goodsMap = goodsService.getCateGoodsList(goods_cate_no);
		
		//해당 카테고리에 해당되는 상품 정보들을 view에 전달
		mv.addObject("goodsMap", goodsMap);
		
		//view지정
		mv.setViewName("/goods/goodsList");
		return mv;
	}
	
	
}
