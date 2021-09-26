package com.jsv.admin.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;

public interface AdminMvChartController {

	
	//(관리자)무비차트 등록폼 보여주기
	public String newMvChartForm(HttpServletRequest request, 
					   HttpServletResponse response) throws Exception;
			
	//(관리자가)무비차트 등록하기
	public  ResponseEntity  newMvChart(MultipartHttpServletRequest  multiReq, 
			   HttpServletResponse response) throws Exception;
	
	//무비차트 삭제
	public String delMvChart (HttpServletRequest request, 
	   		HttpServletResponse response,@RequestParam("cno")int cno) throws Exception;
}
