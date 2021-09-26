package com.jsv.member.dao;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jsv.member.dto.MemberDTO;


@Repository("userDAO")
public class MemberDAOImpl implements MemberDAO {
	
	@Autowired
	private  SqlSession sqlSession;
	
	public MemberDAOImpl() {}
	
	//회원가입시 ID중복체크
	@Override
	public int idCheck (MemberDTO memberDto) throws DataAccessException{
		return sqlSession.selectOne("member.getIdCnt", memberDto);
	}
	
	//회원가입시 메일인증 & 메일 중복체크
	@Override
	public int emailCheck(String u_email) throws DataAccessException{
		return sqlSession.selectOne("member.getEmailCnt", u_email);
	}
		
	//회원가입 처리
	@Override 
	public int insertUser(MemberDTO memberDto) throws DataAccessException { 
		return sqlSession.insert("member.insertUser", memberDto);
	}
		
	//로그인처리
	@Override
	public MemberDTO loginProc(MemberDTO memberDto) throws DataAccessException {
		return sqlSession.selectOne("member.loginProc",memberDto);
	}
	
	//로그인 검사
	@Override
	public MemberDTO login(String u_id) throws DataAccessException{
		return sqlSession.selectOne("member.login", u_id);
	}
		
	//마이페이지 - 패스워드 체크
	@Override
	public int pwdCheck(Map<String,Object> map) throws DataAccessException{
		return sqlSession.selectOne("member.pwdCheck",map);
	}
	
	//마이페이지 폼 보여주기
	@Override
	public MemberDTO getMypageInfo(int u_no) throws DataAccessException{
		return sqlSession.selectOne("member.getMypageInfo", u_no);
	}
	
	//마이페이지 수정처리
	@Override
	public int setMypageInfo(MemberDTO memberDto) throws DataAccessException{
		return sqlSession.update("member.setMypageInfo", memberDto);
	}
	
	//회원탈퇴
	@Override
	@Transactional
	public int withdrawal(int u_no) throws DataAccessException{
		return sqlSession.update("member.withdrawal", u_no);
	}
	
	//아이디 찾기
	@Override
	public String findId(Map<String, Object> infoMap) throws DataAccessException{
		return sqlSession.selectOne("member.findId", infoMap);
	}
	
	//비밀번호 찾기
	@Override
	public int findPwd(MemberDTO memberDTO) throws DataAccessException{
		return sqlSession.selectOne("member.findPwd", memberDTO);
	}
	
	//비밀번호 재설정
	@Override
	public int setPwd(Map<String, Object> infoMap) throws DataAccessException{
		return sqlSession.update("member.setPwd", infoMap);
	}
}
