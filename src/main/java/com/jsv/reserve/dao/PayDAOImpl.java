package com.jsv.reserve.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsv.reserve.dto.PayDTO;

@Repository
public class PayDAOImpl implements PayDAO {
	
	@Autowired
	SqlSession session;
	
	@Override
	public boolean payTicket(PayDTO dto) {
		int count = session.insert("Pay", dto);
		
		//count가 0보다 크면 true 아닐 경우 false 리턴
		return count > 0 ? true : false;
	}
}
