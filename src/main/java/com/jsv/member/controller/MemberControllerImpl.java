package com.jsv.member.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.jsv.member.dto.MemberDTO;
import com.jsv.member.service.MemberService;

@Controller("MemberController")
public class MemberControllerImpl extends MailController implements MemberController {
	
	@Autowired
	MemberService memberService;
	
	//회원가입 폼 보여주기
	@Override
	@RequestMapping(value = "/member/signupForm.mo", method = RequestMethod.GET) 
	public String signupForm(Model model) throws Exception { 
		
		//view지정
		return "/member/signupForm";
	}
	
	//회원가입시 아이디중복체크
	@Override
	@RequestMapping(value="/member/idChk.mo", method = RequestMethod.POST)
	@ResponseBody
	public int idCheck(MemberDTO memberDto) throws Exception{
		
		/*파라미터로 받은 회원 ID로 DB내에서 조회후 조회된 컬럼의 갯수를 전달
		  0일경우 ID사용 가능, 0보다 클 경우 중복된 ID*/
		return memberService.idCheck(memberDto);
	}
		
	//회원가입시 메일인증 & 메일 중복체크
	@Override
	@RequestMapping(value = "/member/sendMail.mo", method = RequestMethod.POST)
	@ResponseBody
	public String sendMail(HttpServletRequest request,
			@RequestParam("email") String u_email) throws Exception{	
		
		//파라미터로 받은 이메일로 DB에서 조회 후 조회된 컬럼의 갯수 받아오기
		int result = memberService.emailCheck(u_email);
		
		//조회된 컬럼의 갯수가 0이 아닐경우 (이메일이 중복일경우)
		if(result!=0) {	
			return "";	
		}else {	
			/*조회된 컬럼의 갯수가 0일 경우 (이메일 중복이 아닐 경우) 
			   상속받은 메일컨트롤러의 메일인증 메서드 실행 후 인증코드 전달*/
			return mailSend(u_email);
		}
	}
	
	//회원가입처리
	@Override
	@RequestMapping(value = "/member/signup.mo", method = RequestMethod.POST)
	public String insertUser(@ModelAttribute("memberDto") MemberDTO memberDto , 
			RedirectAttributes rttr) throws Exception { 
		
		//파라미터로 받은 값을 DB에 저장 후 저장된 행 수 받기
		int result = memberService.insertUser(memberDto); 
 
		/*데이터가 저장된 행 수를 기준으로 header가 아닌 세션을 통해 
	   	   성공여부의 데이터를 담은 후 리다이렉트를 통해 view지정  
	   	  0보다 클 경우 로그인 폼으로 이동, alert창을 이용하여 가입한 유저의 이름과 환영 메세지 띄움
	   	  0과 같을 경우 회원가입 폼으로 재이동, alert창을 이용하여 가입 실패 메세지 띄움 */
		if(result!=0) {
			rttr.addFlashAttribute("result", "joinSuccess");
			rttr.addFlashAttribute("name", memberDto.getU_name());
			return "redirect:/member/loginForm.mo"; 
		}else {
			rttr.addFlashAttribute("result", "joinFailed");
			return "redirect:/member/signupForm.mo"; 
		}
	}
		
	//로그인폼 보여주기
	@Override
	@RequestMapping("/member/loginForm.mo")
	public String loginForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		//view지정
		return "/member/loginForm";
	}
	
	//로그인처리
	@Override
	@ResponseBody
	@RequestMapping(value="/member/login.mo", method = RequestMethod.POST)
	public Map<String,String> loginProc(HttpServletRequest request, HttpServletResponse response,
			RedirectAttributes rAttr,
			@RequestParam("u_id") String u_id,
			@RequestParam("u_password") String u_password) throws Exception {
		
		//파라미터로 받은 아이디와 비밀번호를 담기 위해 MemberDTO 객체 생성
		MemberDTO memberDto = new MemberDTO();
		memberDto.setU_id(u_id);
		memberDto.setU_password(u_password);
		
		//파라미터로 받은 값을 DB에서 조회 후 일치하는 회원의 정보 받기 
		memberDto = memberService.loginProc(memberDto);
		
		//로그인 성공 여부를 담기 위한 객체 생성
		Map<String,String> data = new HashMap<String,String>();
		
		//로그인 성공시
		if(memberDto!=null && memberDto.getIs_connection().equals("y")) { 
			
			//세션에 해당 회원의 정보를 담아 view에 "success" 전달
			HttpSession session = request.getSession();
			session.setAttribute("authUser",memberDto); 
			session.setAttribute("isLogOn",true); 
			
			data.put("code", "success");
		}else if(memberDto!=null && memberDto.getIs_connection().equals("n")) { //탈퇴회원일 경우
			data.put("code", "withdrawal");
		}else if(memberDto!=null && memberDto.getIs_connection().equals("s")) { //활동정지 회원일 경우 
			data.put("code", "stop");	
		}else{ //로그인실패시
			data.put("code", "loginFailed");	
		}
		
		return data;
	}
	
	//로그아웃
	@Override
	@RequestMapping("/member/logout.mo")
	public ModelAndView logout(HttpServletRequest request, 
			HttpServletResponse response, ModelAndView mv) throws Exception {
		
		//세션에 저장된 정보 삭제
		HttpSession session = request.getSession();
		session.removeAttribute("authUser");
		session.removeAttribute("isLogOn");

		//메인 페이지로 view지정
		mv.setViewName("redirect:/main.mo");
		return mv;
	}
	
	//마이페이지 비밀번호 입력 폼 보여주기
	@Override
	@RequestMapping(value = "/member/mypagePwdCheck.mo")
	public String mypagePwdCheckForm(HttpServletRequest request) throws Exception{
		//view 지정
		return "/member/mypagePwdCheckForm";
	}
	
	//마이페이지 - 패스워드 체크
	@Override
	@ResponseBody
	@RequestMapping(value="/member/pwdCheck.mo", method=RequestMethod.POST)
	public int pwdCheck(HttpServletRequest request,
						@RequestParam("u_password") String u_password)throws Exception{
		
		//세션에 저장된 회원의 정보 가져오기
		MemberDTO user = (MemberDTO)request.getSession().getAttribute("authUser");
		
		//파라미터로 받은 비밀번호와 세션에 저장된 회원번호 정보 담기
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("u_no", user.getU_no());
		map.put("u_password",u_password);
		
		/*비밀번호와 회원번호가 담긴 객체를 DB에서 조회 후 
		    조회된 행의 수를 view에 전달
		    행의 수가 1일 경우 마이페이지 수정 폼 보여주기
		    행의 수가 0일 경우 비밀번호 재입력 alert창 띄움  */
		int result = memberService.pwdCheck(map);
		return result;
	}
	
	//마이페이지 폼 보여주기 
	@Override
	@RequestMapping("/member/mypage.mo")
	public ModelAndView mypageForm(HttpServletRequest request, ModelAndView mv) throws Exception {
		
		//세션에 저장된 회원 정보 받아오기
		MemberDTO user = (MemberDTO)request.getSession().getAttribute("authUser");
		
		//받아온 회원 정보 내 회원 번호 받아오기
		int u_no = user.getU_no();
		
		//회원번호로 회원의 정보 조회후 정보 받기
		MemberDTO memberDTO = memberService.getMypageInfo(u_no);
		
		//회원의 정보가 담긴 변수를 view에 전달
		mv.addObject("memberDTO", memberDTO);
		
		//view지정
		mv.setViewName("/member/mypage");
		return mv;
	}
	
	//마이페이지 수정처리
	@Override
	@RequestMapping(value = "/member/setMypageInfo.mo", method = RequestMethod.POST)
	@ResponseBody
	public Integer update_mypage(@ModelAttribute MemberDTO memberDto, HttpSession session) throws Exception{
		
		//세션에 저장된 회원 정보 받아오기
		MemberDTO user = (MemberDTO)session.getAttribute("authUser");
		
		//받아온 회원 정보 내 회원 번호 받아오기
		int u_no = user.getU_no();
		
		//파라미터로 받은 MemberDTO에 setter를 이용하여 회원번호 세팅
		memberDto.setU_no(u_no);
		
		//DB에서 회원 정보 수정 후 수정된 행의 수 반환 
		int result = memberService.setMypageInfo(memberDto);
		
		//수정된 행의 수가 0보다 클 경우 1을 전달 -> view에서 alert를 이용하여 수정처리 완료 메세지
		//수정된 행의 수가 0과 같거나 작은 경우 0을 전달 -> view에서 alert를 이용하여 수정실패 메세지
		if(result>0) {
			return 1;
		}else {
			return 0;
		}
	}
		
	//회원탈퇴
	@Override
	@RequestMapping(value = "/member/withdrawal.mo")
	@ResponseBody
	public Integer membershipWithdrawal(HttpSession session) throws Exception{
		
		//세션에 저장된 회원 정보 받아오기
		MemberDTO user = (MemberDTO)session.getAttribute("authUser");
		
		//받아온 회원 정보 내 회원 번호 받아오기
		int u_no = user.getU_no();
		
		//파라미터로 받은 회원번호로 DB에서 회원의 정보 삭제 후 삭제 된 행의 수 반환
		int result = memberService.withdrawal(u_no);
		
		//반환된 행의 수가 0보다 클 경우 세션에 저장된 회원의 정보 삭제 view에 1전달 -> 메인페이지 이동
		//반환된 행의 수가 0과 같거나 작은 경우 0을 전달 -> view에서 alert를 이용하여 탈퇴 실패 메세지
		if(result>0) {
			session.removeAttribute("authUser");
			return 1;
		}else {
			return 0;
		}
	}
	
	//아이디 찾기 폼보여주기
	@Override
	@RequestMapping("/member/findIdForm.mo")
	public ModelAndView findIdForm(ModelAndView mv) throws Exception{
		
		//view지정
		mv.setViewName("/member/findIdForm");
		return mv;
	}
	
	//아이디 찾기
	@Override
	@RequestMapping(value="/member/findId.mo", method=RequestMethod.POST)
	public ModelAndView findId(ModelAndView mv,
			@RequestParam("u_name") String u_name,
			@RequestParam("u_email") String u_email ) throws Exception{
		
		//파라미터로 받은 이름과 이메일을 담기 위해  Map객체 생성 후 데이터 추가
		Map<String,Object> infoMap = new HashMap<String,Object>();
		infoMap.put("u_name", u_name);
		infoMap.put("u_email", u_email);
		
		//이름과 이메일을 담긴 Map으로 DB에서 조회 후 id값 받아오기
		String id = memberService.findId(infoMap);
		
		//받아온 id값을 view에 전달
		mv.addObject("id", id);
		
		//view지정
		mv.setViewName("/member/findIdResultForm");
		return mv;
	}
	
	//비밀번호 찾기 폼 보여주기
	@Override
	@RequestMapping("/member/findPwdForm.mo")
	public ModelAndView findPwdForm(ModelAndView mv) throws Exception{
		
		//view지정
		mv.setViewName("/member/findPwdForm");
		return mv;
	}
	
	//비밀번호 찾기 
	@Override
	@RequestMapping(value="/member/findPwd.mo", method=RequestMethod.POST)
	public ModelAndView findPwd(ModelAndView mv,MemberDTO memberDTO) throws Exception{
		
		/*파라미터로 받은 memberDTO안에 이름,아이디,이메일이 담겨있음
		  memberDTO에 있는 정보로 DB에서 조회 후 조회된 행의 수 받기  */
		int result = memberService.findPwd(memberDTO);
		
		//조회된 행의 수가 0보다 클 경우 회원 ID를 view에 전달 -> view서는 전달받은 ID가 비어 있지 않을 경우 비밀번호 재설정 할 수 있게 함
		//조회된 행의 수가 0과 같거나 작을 경우 view서는 비밀번호 다시 찾기 , 회원가입 버튼을 보여줌
		if(result>0) {
			mv.addObject("result", "findIt");
			mv.addObject("id", memberDTO.getU_id());
		}else {
			mv.addObject("result", "notFindIt");
		}
	
		//view지정
		mv.setViewName("/member/findPwdResultForm");
		return mv;
	}
	
	//비밀번호 재설정
	@Override
	@ResponseBody
	@RequestMapping(value="/member/setPwd.mo", method=RequestMethod.POST)
	public int setPwd(ModelAndView mv,
			@RequestParam("u_id") String u_id,
			@RequestParam("u_password") String u_password) throws Exception{
		
		//파라미터로 받은 ID와 재설정할 비밀번호를 Map에 담아 DB에 전달
		Map<String,Object> infoMap = new HashMap<String,Object>();
		infoMap.put("u_id", u_id);
		infoMap.put("u_password", u_password);
		
		//파라미터로 받은 값을 DB에 전달 후 해당 회원의 비밀번호 수정 후 수정된 행의 수 전달
		return memberService.setPwd(infoMap);
	}
	
	
	
	
}
