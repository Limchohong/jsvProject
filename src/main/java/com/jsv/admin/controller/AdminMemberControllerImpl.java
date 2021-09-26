package com.jsv.admin.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.jsv.admin.service.AdminMemberService;
import com.jsv.giftShop.util.Pagination;

@Controller("AdminMemberController")
public class AdminMemberControllerImpl implements AdminMemberController {
	
	@Autowired
	private AdminMemberService adminMemberService;
	
	//관리자 - 회원 목록 조회 
	@Override
	@RequestMapping("/admin/member/memberList.mo")
	public ModelAndView getMemberList(ModelAndView mv, Pagination paging,
			@RequestParam(value="nowPage", required=false)String nowPage,
			@RequestParam(value="cntPerPage", required=false)String cntPerPage) throws Exception {
		
		//페이징처리
		int total = adminMemberService.countMember();
		if (nowPage == null && cntPerPage == null) {
			nowPage = "1";
			cntPerPage = "10";
		} else if (nowPage == null) {
			nowPage = "1";
		} else if (cntPerPage == null) { 
			cntPerPage = "10";
		}
		
		paging = new Pagination(total, Integer.parseInt(nowPage), Integer.parseInt(cntPerPage));
		
		//페이징에 관한 내용을 map에 담아 view에 전달
		mv.addObject("paging", paging);
		
		List<Map<String,Object>> memberListMap = adminMemberService.getMemberList(paging);
		
		//회원정보 목록을 map에 담아 view에 전달
		mv.addObject("memberListMap",memberListMap);
		
		//view지정
		mv.setViewName("/admin/member/memberList");
		return mv;
	}
	
	//회원 활동정지
	@Override
	@RequestMapping("/admin/member/memberStop.mo")
	public String memberStop(RedirectAttributes rAttr,@RequestParam("uno") int u_no)throws Exception {
		
		//파라미터로 받은 회원번호로 해당 회원의 활동 여부 컬럼의 데이터 변경 된 행 수를 리턴받음
		int result = adminMemberService.memberStop(u_no);
		
		/*데이터 변경 된 행 수를 기준으로 header가 아닌 세션을 통해 
		    성공여부의 데이터를 담은 후 리다이렉트를 통해 view지정   */
		if(result>0) {
			rAttr.addFlashAttribute("result", "stopSuccess");
			return "redirect:/admin/member/memberList.mo";
		}else {
			rAttr.addFlashAttribute("result", "stopFailed");
			return "redirect:/admin/member/memberList.mo";
		}
	}
	
	//회원 활동정지 해제 
	@Override
	@RequestMapping("/admin/member/memberRelease.mo")
	public String memberRelease(RedirectAttributes rAttr,@RequestParam("uno") int u_no)throws Exception {
		
		//파라미터로 받은 회원번호로 해당 회원의 활동 여부 컬럼의 데이터 변경 된 행 수를 리턴받음
		int result = adminMemberService.memberRelease(u_no);
		
		/*데이터 변경 된 행 수를 기준으로 header가 아닌 세션을 통해 
	   	   성공여부의 데이터를 담은 후 리다이렉트를 통해 view지정   */
		if(result>0) {
			rAttr.addFlashAttribute("result", "releaseSuccess");
			return "redirect:/admin/member/memberList.mo";
		}else {
			rAttr.addFlashAttribute("result", "releaseFailed");
			return "redirect:/admin/member/memberList.mo";
		}
	}

}
