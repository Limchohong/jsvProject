package com.jsv.mvChart.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

public interface MvChartController {

	//무비차트 목록보기
	public ModelAndView  getmvChart(HttpServletRequest request, 
				HttpServletResponse response,Model model) throws Exception;
	
	//무비차트 상세보기
	public ModelAndView getmvdetail(HttpServletRequest request, 
			HttpServletResponse response,@RequestParam("cno") int cno) throws Exception;
	
}
