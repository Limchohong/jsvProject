package com.jsv.mgz.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

public interface MagazineController {
	
	//매거진목록보기
	public ModelAndView mgzList(HttpServletRequest request, 
			   HttpServletResponse response) throws Exception;
	
	//매거진 상세보기
	public ModelAndView getMgzDetail(HttpServletRequest request, 
			   HttpServletResponse response,@RequestParam("mno")int mno) throws Exception;
}
