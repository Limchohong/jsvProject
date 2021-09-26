package com.jsv.mgz.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.jsv.mgz.dto.MagazineDTO;
import com.jsv.mgz.dto.MfileDTO;

@Repository("magazineDAO")
public class MagazineDAOImpl implements MagazineDAO {

	
	@Autowired
	private SqlSession sqlsession;
		
	//매거진 목록조회
	@Override
	public List<MagazineDTO> getMList() throws DataAccessException {
		List<MagazineDTO> mList = (ArrayList)sqlsession.selectList("mgz.getMList");
		return mList;
	}

	//매거진 상세조회- 제품정보
	@Override
	public MagazineDTO getMgzDetail(int mno) throws DataAccessException {
			return sqlsession.selectOne("mgz.getMgzDetail", mno);
	}

	//매거진상세조회 - 제품이미지들정보
	@Override
	public List<MfileDTO> getMgzDImg(int mno) throws DataAccessException {
			return sqlsession.selectList("mgz.getMgzImg", mno);
	}

	

}
