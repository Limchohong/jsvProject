package com.jsv.admin.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONArray;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.jsv.giftShop.util.Pagination;


//기프트샵 관련 관리자 컨트롤러 인터페이스
public interface AdminGoodsController {
	
	//(관리자)관리자 페이지 - 상품 목록조회
	public ModelAndView adminIndex(Pagination paging, ModelAndView mv, 
			@RequestParam(value="nowPage", required=false)String nowPage,
			@RequestParam(value="cntPerPage", required=false)String cntPerPage) throws Exception;
	
	//(관리자)상품등록 폼 보여주기
	public ModelAndView newGoodsForm(ModelAndView mv) throws Exception;
	
	//(관리자)상품등록 처리
	@SuppressWarnings("rawtypes")
	public ResponseEntity newGoods(MultipartHttpServletRequest multiRequest,
			RedirectAttributes rAttr) throws Exception;
	
	//(관리자)상품수정 폼보여주기
	public ModelAndView setGoodsForm(ModelAndView mv,@RequestParam("goods_no") int goods_no) throws Exception;
	
	//(관리자)상품 수정처리
	@SuppressWarnings("rawtypes")
	public ResponseEntity setGoods(MultipartHttpServletRequest multiRequest,
			RedirectAttributes rAttr, ModelAndView mv) throws Exception;
	
	//(관리자)상품 삭제
	@SuppressWarnings("rawtypes")
	public ResponseEntity removeGoods(HttpServletRequest request,
			@RequestParam() int goods_no) throws Exception;

	//(관리자) 체크박스 상품 삭제
	public Object removeCheckedGoods(@RequestParam("checkArr[]")List<Integer> checkArr) throws Exception;
	
	//(관리자) 매출조회 폼 보여주기
	public ModelAndView goodsSales(ModelAndView mv) throws Exception;
	
	//(관리자) 연매출 목록 조회
	public JSONArray getGoodsSales() throws Exception;
	
	//(관리자) 월매출 조회
	public ModelAndView getGoodsMonthlySales(ModelAndView mv) throws Exception;
	
	//(관리자) 월별 일매출 조회
	public ModelAndView getGoodsDailySales(ModelAndView mv,
			@RequestParam("year") int year,
			@RequestParam("month") int month) throws Exception;
	
}
