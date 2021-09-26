package com.jsv.mvfinder.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.jsv.mvChart.dto.MvChartDTO;
import com.jsv.mvfinder.dto.Search;
import com.jsv.mvfinder.service.MvfinderService;

@Controller("mvfindercontroller")
public class MvfinderControllerImpl implements MvfinderController {
	
	@Autowired
	private MvfinderService mvfinderservice;

	//검색+페이징
	@Override
	@RequestMapping("/mvfind/mvfinder.mo")
	public String getmvfinder(HttpServletRequest request, 
			HttpServletResponse response,Model model,@RequestParam(required = false, defaultValue="1") int page,
			@RequestParam(required= false, defaultValue="1") int range,
			@RequestParam(required= false, defaultValue="ctitle") String searchType,
			@RequestParam(required= false)String keyword,
			@ModelAttribute("search") Search search) throws Exception{
		
		
		//전체 게시글 개수를 얻어와 listcnt에 저장
		int listCnt = mvfinderservice.getMvCnt(search);
		//검색기능
		model.addAttribute("search", search);
		search.setSearchType(searchType);
		search.setKeyword(keyword);
		
		//검색
		search.pageInfo(page, range, listCnt);
		
		//페이징
		model.addAttribute("pagination", search);
		
		//게시글 화면출력
		model.addAttribute("list", mvfinderservice.mvfinderList(search));
		
		return "/mvfind/mvfinder";
	}

}
