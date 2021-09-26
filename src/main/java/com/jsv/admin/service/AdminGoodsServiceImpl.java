package com.jsv.admin.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsv.admin.dao.AdminGoodsDAO;
import com.jsv.giftShop.dto.GoodsCateDTO;
import com.jsv.giftShop.util.Pagination;

@Service("AdminGoodsService")
public class AdminGoodsServiceImpl implements AdminGoodsService {
	
	@Autowired
	private AdminGoodsDAO adminGoodsDAO;
	
	//상품 갯수 조회
	@Override
	public int countGoods() throws Exception{
		return adminGoodsDAO.countGoods();
	}
		
	// (관리자)카테고리 목록조회 - 상품등록 폼
	@Override
	public List<GoodsCateDTO> getGoodsCates() throws Exception {
		return adminGoodsDAO.getGoodsCates();
	}
	
	// (관리자)상품등록
	@Override
	public int newGoods(Map<String,Object> newGoodsMap) throws Exception {
		
		int goods_no = adminGoodsDAO.newGoods(newGoodsMap);	//상품테이블
		adminGoodsDAO.newGoodsDetail(newGoodsMap);			//상세내용 테이블
		return goods_no;
	}
	
	// (관리자) 관리자 페이지 조회 - 상품 목록 조회
	@Override
	public List<Map<String,Object>> getGoodsList(Pagination paging) throws Exception {
		return adminGoodsDAO.getGoodsList(paging);
	}
	
	//(관리자) 상품수정 폼보여주기
	@Override
	public Map<String, Object> setGoodsForm(int goods_no) throws Exception {
		Map<String, Object> goodsMap = new HashMap<String, Object>();
		
		List<GoodsCateDTO> cateDTO = getGoodsCates();
		goodsMap.put("cateDTO", cateDTO);
		
		Map<String,String> detailMap = adminGoodsDAO.setGoodsForm(goods_no);
		goodsMap.put("detailMap", detailMap);
		
		return goodsMap;
	}
	
	//(관리자) 상품수정처리
	@Override
	public void setGoods(Map<String, String> goodsMap) throws Exception {
		adminGoodsDAO.setGoods(goodsMap);
		adminGoodsDAO.setGoodsDetail(goodsMap);
	}
		
	//(관리자) 상품삭제
	@Override
	public int removeGoods(int goods_no) throws Exception {
		return adminGoodsDAO.removeGoods(goods_no);
	}

	//(관리자) 체크박스 선택 상품 삭제
	@Override
	public int removeCheckedGoods(List<Integer> arr) throws Exception {
		int result = 0;
		for(Integer goods_no:arr) {
			result = adminGoodsDAO.removeGoods(goods_no);
		}
		return result;
	}

	//(관리자)연매출 조회
	@Override
	public List<Map<String,String>> getGoodsYearSales() throws Exception{
		return adminGoodsDAO.getGoodsYearSales();
	}
	
	//(관리자)월 매출 조회
	@Override
	public List<Map<String, Object>> getGoodsMonthlySales() throws Exception {
		return adminGoodsDAO.getGoodsMonthlySales();
	}

	//(관리자)월별 일매출 조회
	@Override
	public List<Map<String, Object>> getGoodsDailySales(int year, int month) throws Exception{
		
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("year", year);
		map.put("month", month);
		
		return adminGoodsDAO.getGoodsDailySales(map);
	}
}
