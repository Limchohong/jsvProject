package com.jsv.member.service;

import java.util.Map;


import org.springframework.dao.DataAccessException;

import com.jsv.member.dto.MemberDTO;

public interface MemberService {
		
	// 회원가입시 - 아이디중복체크
	public int idCheck(MemberDTO memberDto) throws Exception;
	
	//회원가입시 메일인증 & 메일 중복체크
	public int emailCheck(String u_email) throws Exception;
		
	//회원가입 처리
	public int insertUser(MemberDTO memberDto) throws Exception;
	
	//로그인처리
	public MemberDTO loginProc(MemberDTO memberdto) throws DataAccessException;
	
	//패스워드 체크
	public int pwdCheck(Map<String,Object> map) throws Exception;
	
	//마이페이지 폼 보여주기
	public MemberDTO getMypageInfo(int u_no) throws Exception;
	
	//마이페이지 수정처리
	public int setMypageInfo(MemberDTO memberDto) throws Exception;
	
	//회원탈퇴
	public int withdrawal(int u_no) throws Exception;

	//아이디 찾기
	public String findId(Map<String, Object> infoMap) throws Exception;
	
	//비밀번호 찾기 
	public int findPwd(MemberDTO memberDTO) throws Exception;
	
	//비밀번호 재설정
	public int setPwd(Map<String, Object> infoMap) throws Exception;
	
	

}
