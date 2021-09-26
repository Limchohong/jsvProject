package com.jsv.admin.dao;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.jsv.giftShop.dto.GoodsCateDTO;
import com.jsv.giftShop.util.Pagination;

public interface AdminGoodsDAO {
	
	//상품 갯수 조회
	public int countGoods() throws DataAccessException;
		
	//(관리자) 카테고리 목록 조회 
	public List<GoodsCateDTO> getGoodsCates() throws DataAccessException;
	
	//(관리자) 상품등록
	public int newGoods(Map<String, Object> newGoodsMap) throws DataAccessException;
	
	//(관리자) 상품 상세내용 등록
	public void newGoodsDetail(Map<String, Object> newGoodsMap) throws DataAccessException;

	//(관리자) 관리자 페이지 조회 - 상품 목록 조회
	public List<Map<String,Object>> getGoodsList(Pagination paging) throws DataAccessException;
	
	//(관리자) 상품수정 폼보여주기
	public Map<String,String> setGoodsForm(int goods_no) throws DataAccessException;

	//(관리자) 상품수정처리 - 상품테이블
	public void setGoods(Map<String, String> goodsMap) throws DataAccessException;
	
	//(관리자) 상품수정처리 - 상품상세 테이블
	public void setGoodsDetail(Map<String, String> goodsMap)throws DataAccessException;
	
	//(관리자)상품 삭제
	public int removeGoods(int goods_no) throws DataAccessException;
	
	//(관리자) 연매출 조회
	public List<Map<String,String>> getGoodsYearSales() throws DataAccessException;

	//(관리자)월 매출 조회
	public List<Map<String, Object>> getGoodsMonthlySales() throws DataAccessException;
	
	//(관리자)월별 일매출 조회
	public List<Map<String, Object>> getGoodsDailySales(Map<String, Object> map) throws DataAccessException;

}
