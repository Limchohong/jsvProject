package com.jsv.admin.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;

public interface AdminMgzController {

		//매거진 등록폼 보여주기
		public String newMgzForm(HttpServletRequest request, 
					   HttpServletResponse response) throws Exception;
		
		//매거진 등록처리 
		public ResponseEntity newMgz(MultipartHttpServletRequest request, 
				HttpServletResponse response) throws Exception;
		
		//매거진 삭제처리
		public String delMgz(HttpServletRequest request, 
				   HttpServletResponse response,@RequestParam("mno")int mno) throws Exception;
		
		//매거진 수정폼 보여기주기 
		public String updateMgz(HttpServletRequest request,
				HttpServletResponse response,@RequestParam("mno") int mno,Model model) throws Exception;
		
		// 매거진 내용 수정처리updateMinfo
		public ResponseEntity  updateMinfo(MultipartHttpServletRequest request, 
				HttpServletResponse response, 
				@RequestParam("mno") int mno,
				@RequestParam("attr")  String attribute,
				@RequestParam("value") String value	) throws Exception;
		
		 //매거진 이미지 수정처리
		 public void updateMimg(MultipartHttpServletRequest
		 multipartRequest, HttpServletResponse response) throws Exception;
		 
}
