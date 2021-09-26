package com.jsv.event.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

public interface EventController {

	//이벤트 목록보기
	public ModelAndView getElist(HttpServletRequest request, 
			HttpServletResponse response,Model model) throws Exception;
	
	//이벤트 상세보기 
	public ModelAndView getEdetail(HttpServletRequest request, 
			HttpServletResponse response,@RequestParam("eno") int eno) throws Exception;
	
}
