package com.jsv.giftShop.dao;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.jsv.giftShop.dto.GoodsCateDTO;
import com.jsv.giftShop.dto.GoodsDTO;

public interface GoodsDAO {

	//기프트샵 메인 - 상품목록
	public List<GoodsDTO> getGoodsList(String goods_cate_name) throws DataAccessException;
	
	//카테고리 목록 조회 
	public List<GoodsCateDTO> getGoodsCates() throws DataAccessException;
	
	//상품 번호로 상품 상세내용 조회
	public Map<String,String> getGoodsDetail(int goods_no) throws DataAccessException;
	
	//카테고리별 상품조회
	public List<Object> getCateGoodsList(int goods_cate_no) throws DataAccessException;
	
}
