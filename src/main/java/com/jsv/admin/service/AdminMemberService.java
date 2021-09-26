package com.jsv.admin.service;

import java.util.List;
import java.util.Map;

import com.jsv.giftShop.util.Pagination;

public interface AdminMemberService {
	
	//회원 수 조회
	public int countMember() throws Exception;
	
	//회원 목록 조회 
	public List<Map<String, Object>> getMemberList(Pagination paging) throws Exception;
	
	//회원 활동정지
	public int memberStop(int u_no) throws Exception;
	
	//회원 활동정지 해제
	public int memberRelease(int u_no) throws Exception;

}
