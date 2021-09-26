package com.jsv.mvfinder.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import com.jsv.mvfinder.dto.Search;

public interface MvfinderController {

	//무비차트 목록보기+페이징
		public String  getmvfinder(HttpServletRequest request, 
					HttpServletResponse response,Model model,
					@RequestParam(required = false, defaultValue="1") int page,
					@RequestParam(required= false, defaultValue="1") int range,
					@RequestParam(required= false, defaultValue="ctitle") String searchType,
					@RequestParam(required= false)String keyword,
					@ModelAttribute("search") Search search) throws Exception;
}
