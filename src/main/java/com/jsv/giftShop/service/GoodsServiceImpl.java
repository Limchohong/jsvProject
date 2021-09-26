package com.jsv.giftShop.service;

//상품 서비스
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsv.giftShop.dao.GoodsDAO;
import com.jsv.giftShop.dto.GoodsCateDTO;
import com.jsv.giftShop.dto.GoodsDTO;

@Service("GoodsService")
public class GoodsServiceImpl implements GoodsService {
	
	@Autowired
	private GoodsDAO goodsDAO;
	
	//기프트샵 메인 - 상품목록
	@Override
	public Map<String,List<GoodsDTO>> getGoodsList() throws Exception {
		Map<String,List<GoodsDTO>> goodsListMap = new HashMap<String,List<GoodsDTO>>();
		
		List<GoodsDTO> goodsList = goodsDAO.getGoodsList("영화관람권");
		goodsListMap.put("movieTicket", goodsList);
		
		goodsList = goodsDAO.getGoodsList("기프트카드");
		goodsListMap.put("giftCard", goodsList);
		
		goodsList = goodsDAO.getGoodsList("콤보");
		goodsListMap.put("combo", goodsList);
		
		goodsList = goodsDAO.getGoodsList("팝콘");
		goodsListMap.put("popcon", goodsList);
		
		goodsList = goodsDAO.getGoodsList("음료");
		goodsListMap.put("drink", goodsList);
		
		goodsList = goodsDAO.getGoodsList("스낵");
		goodsListMap.put("snack", goodsList);
		
		return goodsListMap;
	}
	
	//카테고리 목록조회
	@Override
	public List<GoodsCateDTO> getGoodsCates() throws Exception {
		return goodsDAO.getGoodsCates();
	}
	
	//상품 상세조회
	@Override
	public Map<String,String> getGoodsDetail(int goods_no) throws Exception {
		return goodsDAO.getGoodsDetail(goods_no);
	}
	
	//카테고리별 상품조회
	@Override
	public List<Object> getCateGoodsList(int goods_cate_no) throws Exception {
		return goodsDAO.getCateGoodsList(goods_cate_no);
	}

}
