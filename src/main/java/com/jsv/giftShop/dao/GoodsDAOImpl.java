package com.jsv.giftShop.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.jsv.giftShop.dto.GoodsCateDTO;
import com.jsv.giftShop.dto.GoodsDTO;

@Repository("GoodsDAO")
public class GoodsDAOImpl implements GoodsDAO {

	@Autowired
	private SqlSession session;
	
	//기프트샵 메인 - 상품목록
	@Override
	public List<GoodsDTO> getGoodsList(String goods_cate_name) throws DataAccessException {
		return session.selectList("goods.getGoodsList", goods_cate_name);
	}

	//카테고리명 조회
	@Override
	public List<GoodsCateDTO> getGoodsCates() throws DataAccessException {
		return session.selectList("goods.getGoodsCates");
	}
	
	//상품 번호로 상품 상세정보 조회
	@Override
	public Map<String,String> getGoodsDetail(int goods_no) throws DataAccessException {
		return session.selectOne("goods.getGoodsDetail", goods_no);
	}
	
	//카테고리별 상품조회
	@Override
	public List<Object> getCateGoodsList(int goods_cate_no) throws DataAccessException {
		return session.selectList("goods.getCateGoodsList",goods_cate_no);
	}
	
}
