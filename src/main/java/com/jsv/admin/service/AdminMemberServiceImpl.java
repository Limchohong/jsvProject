package com.jsv.admin.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsv.admin.dao.AdminMemberDAO;
import com.jsv.giftShop.util.Pagination;

@Service("AdminMemberService")
public class AdminMemberServiceImpl implements AdminMemberService {
	
	@Autowired
	private AdminMemberDAO adminMemberDAO;
	
	//회원 수 조회
	public int countMember() throws Exception{
		return adminMemberDAO.countMember();
	}
	
	//회원 목록 조회 
	public List<Map<String, Object>> getMemberList(Pagination paging) throws Exception{
		return adminMemberDAO.getMemberList(paging);
	}
	
	//회원 활동정지
	public int memberStop(int u_no) throws Exception{
		return adminMemberDAO.memberStop(u_no);
	}
	
	//회원 활동정지 해제
	public int memberRelease(int u_no) throws Exception{
		return adminMemberDAO.memberRelease(u_no);
	}
}
