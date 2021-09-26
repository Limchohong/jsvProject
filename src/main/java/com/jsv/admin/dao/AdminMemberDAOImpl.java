package com.jsv.admin.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.jsv.giftShop.util.Pagination;

@Repository("AdminMemberDAO")
public class AdminMemberDAOImpl implements AdminMemberDAO {

	@Autowired
	private SqlSession session;
	
	//회원 수 조회
	public int countMember() throws DataAccessException{
		return session.selectOne("admin_mamber.countMember");
	}
	
	//회원 목록 조회
	public List<Map<String, Object>> getMemberList(Pagination paging) throws DataAccessException{
		return session.selectList("admin_mamber.getMemberList",paging);
	}
	
	//회원 활동정지
	public int memberStop(int u_no) throws DataAccessException{
		return session.update("admin_mamber.memberStop", u_no);
	}
	
	//회원 활동정지 해제
	public int memberRelease(int u_no) throws DataAccessException{
		return session.update("admin_mamber.memberRelease", u_no);
	}
}
