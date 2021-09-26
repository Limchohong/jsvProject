package com.jsv.mgz.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.jsv.mgz.dto.MagazineDTO;
import com.jsv.mgz.service.MagazineService;


@Controller("magazinecontroller")
public class MagazineControllerImpl implements MagazineController {

	@Autowired
	private MagazineService magazineservice;
	
	//매거진목록보기
	@Override
	@RequestMapping("/mgz/mgzList.mo")
	public ModelAndView mgzList(HttpServletRequest request, HttpServletResponse response) throws Exception {
			System.out.println("mlist진입");
		
			ModelAndView mv = new ModelAndView();
			List<MagazineDTO> mList = magazineservice.getMList();
			mv.setViewName("/mgz/mgzList");
			mv.addObject("mList", mList);
			return mv;
	}

	//매거진 상세보기
	@Override
	@RequestMapping("/mgz/mgzDetail.mo")
	public ModelAndView getMgzDetail(HttpServletRequest request, HttpServletResponse response, int mno)
			throws Exception {
		System.out.println("mdetail진입");
		
		ModelAndView mv = new ModelAndView();
		Map mgzMap = magazineservice.getMgzDetail(mno);	//맵으로 묶어놓은거 처리
		
		//view&모델
		mv.setViewName("/mgz/mgzDetail");
		mv.addObject("mgzMap", mgzMap);
		
		return mv;
	}

}
