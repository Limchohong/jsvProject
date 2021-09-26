package com.jsv.giftShop.service;

//상품 인터페이스
import java.util.List;
import java.util.Map;

import com.jsv.giftShop.dto.GoodsCateDTO;
import com.jsv.giftShop.dto.GoodsDTO;

public interface GoodsService {
	
	//기프트샵 메인 - 상품목록
	public Map<String,List<GoodsDTO>> getGoodsList() throws Exception;
	
	//카테고리 목록조회
	public List<GoodsCateDTO> getGoodsCates() throws Exception;
	
	//상품 상세조회
	public Map<String, String> getGoodsDetail(int goods_no) throws Exception;
	
	//카테고리별 상품조회
	public List<Object> getCateGoodsList(int goods_cate_no) throws Exception;
}
