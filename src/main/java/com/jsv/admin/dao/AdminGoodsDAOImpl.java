package com.jsv.admin.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.jsv.giftShop.dto.GoodsCateDTO;
import com.jsv.giftShop.util.Pagination;

@Repository("AdminGoodsDAO")
public class AdminGoodsDAOImpl implements AdminGoodsDAO {
	
	@Autowired
	private SqlSession session;

	//상품 갯수 조회
	@Override
	public int countGoods() throws DataAccessException{
		return session.selectOne("goods.goodsCount");
	}
	
	//(관리자)상품목록 조회
	@Override
	public List<Map<String,Object>> getGoodsList(Pagination paging) throws DataAccessException {
		return session.selectList("goods.getGoodsCate",paging);
	}
	
	
	//(관리자)카테고리 목록 조회
	@Override
	public List<GoodsCateDTO> getGoodsCates() throws DataAccessException {
		return session.selectList("goods.getGoodsCates");
	}

	//(관리자)상품등록
	@Override
	public int newGoods(Map<String, Object> newGoodsMap) throws DataAccessException {
		session.insert("admin_goods.newGoods", newGoodsMap);
		return (Integer)newGoodsMap.get("goods_no");
	}

	//(관리자) 상품등록 - 상세내용 등록
	@Override
	public void newGoodsDetail(Map<String, Object> newGoodsMap) throws DataAccessException {
		session.insert("admin_goods.newGoodsDetail", newGoodsMap);
	}

	//(관리자)상품수정 폼 
	@Override
	public Map<String, String> setGoodsForm(int goods_no) throws DataAccessException {
		return session.selectOne("goods.getGoodsDetail", goods_no);
	}
	
	//(관리자) 상품수정처리 - 상품테이블
	@Override
	public void setGoods(Map<String, String> goodsMap) throws DataAccessException{
		session.update("admin_goods.setGoods", goodsMap);
	}
	
	//(관리자) 상품수정처리 - 상품상세테이블
	@Override
	public void setGoodsDetail(Map<String, String> goodsMap) {
		session.update("admin_goods.setGoodsDetail", goodsMap);
	}
		
	//(관리자)상품삭제
	@Override
	public int removeGoods(int goods_no) throws DataAccessException {
		return session.delete("admin_goods.removeGoods", goods_no);
	}
	
	//(관리자)연매출 조회
	public List<Map<String,String>> getGoodsYearSales() throws DataAccessException{
		return session.selectList("admin_goods.getGoodsYearSales");
	}
	
	//(관리자)월 매출 조회
	@Override
	public List<Map<String, Object>> getGoodsMonthlySales() throws DataAccessException {
		return session.selectList("admin_goods.getGoodsMonthlySales");
	}
	
	//(관리자)월별 일매출 조회
	@Override
	public List<Map<String, Object>> getGoodsDailySales(Map<String, Object> map) throws DataAccessException{
		return session.selectList("admin_goods.getGoodsDailySales",map);
	}

}
