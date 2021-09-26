package com.jsv.admin.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.jsv.event.dto.EventDTO;

public interface AdminEventController {
	
		//이벤트 등록폼 보여주기
		public String newEventForm(HttpServletRequest request, 
				   HttpServletResponse response) throws Exception;
		
		//(관리자가)이벤트 등록하기
		public  ResponseEntity  newEvent(MultipartHttpServletRequest  multiReq, 
				   HttpServletResponse response) throws Exception;
		
		//(관리자가)이벤트 수정폼 보여주기
		public String newEvent(HttpServletRequest request,
				HttpServletResponse response,@RequestParam("eno") int eno,Model model) throws Exception;
		
		// 이벤트 내용 수정처리
		public String updateEvent(MultipartHttpServletRequest  request, 
				   HttpServletResponse response) throws Exception;
				
		//(관리자가)이벤트삭제
		public String delEvent(HttpServletRequest request, 
				HttpServletResponse response,@RequestParam("eno") int eno) throws Exception;
		
				   
}
