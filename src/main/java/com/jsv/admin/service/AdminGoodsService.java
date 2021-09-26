package com.jsv.admin.service;

import java.util.List;
import java.util.Map;

import com.jsv.giftShop.dto.GoodsCateDTO;
import com.jsv.giftShop.util.Pagination;

public interface AdminGoodsService {

	//상품 갯수 조회
	public int countGoods() throws Exception;
	
	//(관리자)카테고리 조회
	public List<GoodsCateDTO> getGoodsCates() throws Exception;
	
	//(관리자)상품등록 - 상품번호 리턴
	public int newGoods(Map<String,Object> newGoodsMap) throws Exception;

	//(관리자) 관리자 페이지 조회 - 상품 목록 조회
	public List<Map<String,Object>> getGoodsList(Pagination paging) throws Exception;
	
	//(관리자) 상품수정 폼보여주기
	public Map<String, Object> setGoodsForm(int goods_no) throws Exception;
	
	//(관리자) 상품수정처리
	public void setGoods(Map<String, String> goodsMap)throws Exception;

	//(관리자) 상품삭제
	public int removeGoods(int goods_no) throws Exception;
	
	//(관리자) 체크박스 선택 상품 삭제
	public int removeCheckedGoods(List<Integer> arr) throws Exception;
	
	//(관리자)연매출 조회
	public List<Map<String,String>> getGoodsYearSales() throws Exception;
	
	//(관리자)월 매출 조회
	public List<Map<String, Object>> getGoodsMonthlySales() throws Exception;
	
	//(관리자)월별 일매출 조회
	public List<Map<String, Object>> getGoodsDailySales(int year, int month) throws Exception;

}

