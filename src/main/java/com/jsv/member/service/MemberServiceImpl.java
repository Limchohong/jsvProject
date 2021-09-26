package com.jsv.member.service;

import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.jsv.member.dao.MemberDAO;
import com.jsv.member.dto.MemberDTO;


@Service("memberService")
public class MemberServiceImpl implements MemberService{

	@Autowired
	private MemberDAO mamberDAO;
	
	
	//아이디 중복체크
	@Override
	public int idCheck(MemberDTO memberDto) throws Exception{
		return mamberDAO.idCheck(memberDto);
	}
	
	//회원가입시 메일인증 & 메일 중복체크
	@Override
	public int emailCheck(String u_email) throws Exception{
		return mamberDAO.emailCheck(u_email);
	}
		
	//회원가입처리
	@Override 
	public int insertUser(MemberDTO memberDto) throws Exception { 
		return mamberDAO.insertUser(memberDto); 
	}
		
	//로그인처리
	@Override
	public MemberDTO loginProc(MemberDTO memberDto) throws DataAccessException {
		return mamberDAO.loginProc(memberDto);
	}
	
	//마이페이지 - 패스워드 체크
	@Override
	public int pwdCheck(Map<String,Object> map) throws Exception{
		return mamberDAO.pwdCheck(map);
	}
	
	//마이페이지 폼 보여주기
	@Override
	public MemberDTO getMypageInfo(int u_no) throws Exception{
		return mamberDAO.getMypageInfo(u_no);
	}
	
	//마이페이지 수정처리
	@Override
	public int setMypageInfo(MemberDTO memberDto) throws Exception{
		return mamberDAO.setMypageInfo(memberDto);
	}
		
	// 회원탈퇴
	@Override
	public int withdrawal(int u_no) throws Exception {
		return mamberDAO.withdrawal(u_no);
	}

	//아이디 찾기
	@Override
	public String findId(Map<String, Object> infoMap) throws Exception{
		return mamberDAO.findId(infoMap);
	}
	
	//비밀번호 찾기
	@Override
	public int findPwd(MemberDTO memberDTO) throws Exception{
		return mamberDAO.findPwd(memberDTO);
	}
	
	//비밀번호 재설정
	@Override
	public int setPwd(Map<String, Object> infoMap) throws Exception{
		return mamberDAO.setPwd(infoMap);
	}
}

