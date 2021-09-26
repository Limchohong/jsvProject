package com.jsv.member.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.jsv.member.dto.MemberDTO;



//접근제어자  interface 인터페이스명 {
@SuppressWarnings("unused")
public interface MemberController {
			
	//회원가입 폼 보여주기
	public String signupForm(Model model) throws Exception;

	//회원가입시 ID중복체크
	public int idCheck(MemberDTO memberDto) throws Exception;
	
	//회원가입시 이메일 인증
	public String sendMail(HttpServletRequest request, @RequestParam("email") String email) throws Exception;
	
	//회원가입처리
	public String insertUser(@ModelAttribute("memberDto") MemberDTO memberDto, RedirectAttributes rttr) throws Exception;
	
	//로그인폼 보여주기
	public String loginForm(HttpServletRequest request, HttpServletResponse response) throws Exception;
	
	//로그인 처리하기
	public  Map<String,String> loginProc(HttpServletRequest request,HttpServletResponse response, 
			RedirectAttributes rAttr,
			@RequestParam("u_id") String u_id,
			@RequestParam("u_password") String u_password) throws Exception;

	//로그아웃
	public ModelAndView logout(HttpServletRequest request, 
							   HttpServletResponse response, ModelAndView mv) throws Exception;

	//마이페이지 비밀번호 입력 폼 보여주기
	public String mypagePwdCheckForm(HttpServletRequest request) throws Exception;
	
	//마이페이지 - 패스워드 체크
	public int pwdCheck(HttpServletRequest request, @RequestParam("u_password") String u_password)throws Exception;
	
	//마이페이지 폼 보여주기
	public ModelAndView mypageForm(HttpServletRequest request,ModelAndView mv) throws Exception;
	
	//마이페이지 수정처리
	public Integer update_mypage(@ModelAttribute MemberDTO memberDto, HttpSession session) throws Exception;
	
	//회원탈퇴 처리
	public Integer membershipWithdrawal(HttpSession session) throws Exception;
	
	//아이디 찾기 폼보여주기
	public ModelAndView findIdForm(ModelAndView mv) throws Exception;
	
	//아이디 찾기
	public ModelAndView findId(ModelAndView mv,
			@RequestParam("u_name") String u_name,
			@RequestParam("u_email") String u_email ) throws Exception;
	
	//비밀번호 찾기 폼 보여주기
	public ModelAndView findPwdForm(ModelAndView mv) throws Exception;
	
	//비밀번호 찾기 
	public ModelAndView findPwd(ModelAndView mv,MemberDTO memberDTO) throws Exception;
	
	//비밀번호 재설정
	public int setPwd(ModelAndView mv,
			@RequestParam("u_id") String u_id,
			@RequestParam("u_password") String u_password) throws Exception;
}











