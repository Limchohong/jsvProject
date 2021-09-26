package com.jsv.admin.controller;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.jsv.admin.service.AdminGoodsService;
import com.jsv.common.base.BaseController;
import com.jsv.giftShop.dto.GoodsCateDTO;
import com.jsv.giftShop.util.Pagination;

//기프트샵 관련 관리자 컨트롤러 
@Controller("AdminGoodsController")
public class AdminGoodsControllerImpl extends BaseController implements AdminGoodsController {
	
	
	@Autowired
	private AdminGoodsService adminGoodsService;
	
	//관리자 페이지 - 상품 목록조회
	@Override
	@RequestMapping("/admin/gift-shop.mo")
	public ModelAndView adminIndex(Pagination paging, ModelAndView mv, 
			@RequestParam(value="nowPage", required=false)String nowPage,
			@RequestParam(value="cntPerPage", required=false)String cntPerPage) throws Exception {
		
		//페이징처리
		int total = adminGoodsService.countGoods();
		if (nowPage == null && cntPerPage == null) {
			nowPage = "1";
			cntPerPage = "10";
		} else if (nowPage == null) {
			nowPage = "1";
		} else if (cntPerPage == null) { 
			cntPerPage = "10";
		}
		
		//페이징에 관한 내용을 map에 담아 view에 전달
		paging = new Pagination(total, Integer.parseInt(nowPage), Integer.parseInt(cntPerPage));
		mv.addObject("paging", paging);
		
		//상품목록을 map에 담아 view에 전달
		List<Map<String,Object>> goodsList  = adminGoodsService.getGoodsList(paging);
		mv.addObject("goodsList", goodsList);
		
		//view지정
		mv.setViewName("/admin/giftShop/main");
		return mv;
	}
		
	//(관리자)상품등록 폼 보여주기
	@Override
	@RequestMapping("/admin/gift-shop/newGoodsForm.mo")
	public ModelAndView newGoodsForm(ModelAndView mv) throws Exception {
		
		//상품 등록을 위해 카테고리의 데이터를 map에 담아 view에 전달
		List<GoodsCateDTO> cateDTO = adminGoodsService.getGoodsCates();
		mv.addObject("cateDTO",cateDTO);
		
		//view지정
		mv.setViewName("/admin/giftShop/newGoodsForm");
		return mv;
	}
	
	//(관리자)상품등록 처리
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	@RequestMapping(value="/admin/gift-shop/newGoods.mo", method=RequestMethod.POST)
	public ResponseEntity newGoods(MultipartHttpServletRequest multiRequest,
			RedirectAttributes rAttr) throws Exception {
		
		//상품정보와 이미지정보를 담기위한 Map 생성
		Map<String, Object> newGoodsMap = new HashMap<String,Object>();
		
		//view에 전달할 script를 담기위한 변수 초기화 - 동일페이지 내에서 처리
		String msg = null; 
		
		//응답에 관해 추가적으로 여러개 보낼때 사용할 변수 초기화 
		ResponseEntity resEntity = null;
		
		//응답시 헤더에 내용을 추가하기 위한 객체 생성
		HttpHeaders responseHerders = new HttpHeaders();
		
		//응답시 헤더에 추가할 내용
		responseHerders.add("Content-Type", "text/html; charset=UTF-8");
		
		/*Enumeration 형태로 추출된  이름을 키값으로 하여, while문을 돌면서 넘어온 값의 정보를 추출한다. 
	             파라미터명을 하나씩 가져와 name변수에 저장 후  저장된 한개의 파라미터명에 해당하는 값을 가져옴
	      DB수정처리를 위해 map에 담기 : 파라미터명,값 	*/
		Enumeration eur = multiRequest.getParameterNames();
		while(eur.hasMoreElements()) {
			String name = (String) eur.nextElement();
				String value = multiRequest.getParameter(name);
				newGoodsMap.put(name, value);
		}
		
		//goods_img이 비어있지 않을 경우 파일 객체 생성후 복사 -> 상품정보와 이미지정보를 담기위한 Map에 추가
		String goods_img = uploadGoodsImg(multiRequest);
		if(goods_img!=null && goods_img.length()!=0) {
			newGoodsMap.put("goods_img",goods_img);
		}
		
		/*DB에 상품 내용을 저장 후 pk인 상품 번호 return 받아 파라미터명이 goods_img이 비어있지 않을 경우
		    이미지 저장소내 상품번호(goods_id)이름인 폴더를 생성하여 이미지 저장소(temp)에 있는 파일을 이동시킨다 */
		int goods_no = adminGoodsService.newGoods(newGoodsMap);
		
		try {
			if(goods_img!=null && goods_img.length()!=0) {
				uploadGoodsImgMove(goods_img, goods_no); //폴더 이동 모듈로 뺌
				msg = "<script>";
				msg += "alert('상품이 등록되었습니다');";		
				msg += "location.href='"+multiRequest.getContextPath()+"/admin/gift-shop.mo'";
				msg += "</script>";
			}
		}catch(Exception e){
			msg =  "<sctipt>";
			msg += "alert('오류 발생으로 상품 등록이 실패 되었습니다');";
			msg += "location.href='"+multiRequest.getContextPath()+"/admin/gift-shop.mo'";
			msg += "</script>";
			e.printStackTrace();
		}
		
		//응답할 내용, 응답시 헤더에 추가, status지정(응답코드) 객체 생성
		resEntity = new ResponseEntity(msg,responseHerders,HttpStatus.OK);
		
		//스크립트 형태의 내용을 view에 전달
		return resEntity;
	}
	
	//(관리자)상품수정 폼 보여주기 
	@Override
	@RequestMapping("/admin/gift-shop/setGoodsForm.mo")
	public ModelAndView setGoodsForm(ModelAndView mv,
			@RequestParam("goods_no") int goods_no) throws Exception {
		
		//등록된 상품의 정보를 map에 담아 view에 전달 
		Map<String, Object> goodsMap = adminGoodsService.setGoodsForm(goods_no);
		mv.addObject("goodsMap", goodsMap);
		
		//view지정
		mv.setViewName("/admin/giftShop/setGoodsForm");
		return mv;
	}

	//(관리자) 상품수정처리
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	@RequestMapping(value = "/admin/gift-shop/setGoods.mo", method=RequestMethod.POST)
	public ResponseEntity setGoods(MultipartHttpServletRequest multiRequest, 
			RedirectAttributes rAttr,ModelAndView mv) throws Exception {
		Map<String,String> goodsMap = new HashMap<String,String>();
		
		//전송받은 폼에 담겨진 파라미터들의 값 얻기
		Enumeration names = multiRequest.getParameterNames();
		
		//업로드 된 파일명과 상품 번호를 담기 위한 변수 초기화 
		String goods_img = null;
		int goods_no = 0;
		
		//view에 전달할 script를 담기위한 변수 초기화 - 동일페이지 내에서 처리
		String msg = null; 
		
		//응답에 관해 추가적으로 여러개 보낼때 사용할 변수 초기화 
		ResponseEntity resEntity = null;	
		
		//응답시 헤더 부분에 추가할 내용
		HttpHeaders responseHerders = new HttpHeaders(); 
		responseHerders.add("Content-Type", "text/html; charset=UTF-8");
		
		/*Enumeration 형태로 추출된  이름을 키값으로 하여, while문을 돌면서 넘어온 값의 정보를 추출한다. 
		    파라미터명을 하나씩 가져와 name변수에 저장 후  저장된 한개의 파라미터명에 해당하는 값을 가져옴
		  DB수정처리를 위해 map에 담기 : 파라미터명,값 	*/
		while(names.hasMoreElements()) {
			String name = (String) names.nextElement();
			String value = multiRequest.getParameter(name);
			goodsMap.put(name, value);
		}
		
		//수정할 파일이 존재할 경우 기존 파일이 담김 폴더&파일 삭제 후 업로드->폴더이동 
		if(!multiRequest.getFile("goods_img").isEmpty()) {	//파일
			goods_no = Integer.parseInt(goodsMap.get("goods_no"));
			
			removeGoodsImgFolder(goods_no); 		  //폴더 삭제
			goods_img = uploadGoodsImg(multiRequest); //업로드
			uploadGoodsImgMove(goods_img,goods_no);	  //폴더이동
			goodsMap.put("goods_img", goods_img);
			
			//수정할 상품 정보의 내용을 Map에 담아 DB에서 수정처리
			adminGoodsService.setGoods(goodsMap);
			msg = "<script>";
			msg += "alert('상품이 수정되었습니다');";		
			msg += "location.href='"+multiRequest.getContextPath()+"/admin/gift-shop.mo'";
			msg += "</script>";
			
		 //수정할 파일이 존재하지 않을 경우 기존에 업로드된 파일 유지	
		}else if(multiRequest.getFile("goods_img").isEmpty()){
			adminGoodsService.setGoods(goodsMap);
			msg = "<script>";
			msg += "alert('상품이 수정되었습니다');";		
			msg += "location.href='"+multiRequest.getContextPath()+"/admin/gift-shop.mo'";
			msg += "</script>";
		
		 //문제 발생시 경고창 띄운 후 상품 수정 폼으로 이동
		}else {
			msg =  "<sctipt>";
			msg += "alert('오류 발생으로 상품 수정이 실패 되었습니다');";
			msg += "location.href='"+multiRequest.getContextPath()+"/admin/gift-shop/setGoodsForm.mo?'"+goods_no+"'";
			msg += "</script>";
		}
		
		//응답할 내용, 응답시 헤더에 추가, status지정(응답코드) 객체 생성
		resEntity = new ResponseEntity(msg,responseHerders,HttpStatus.OK);
			
		//스크립트 형태의 내용을 view에 전달
		return resEntity;
	}
	
	//(관리자) 상품삭제
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	@RequestMapping("/admin/gift-shop/removeGoods.mo")
	public ResponseEntity removeGoods(HttpServletRequest request,
			@RequestParam("goods_no") int goods_no) throws Exception {
		
		//view에 전달할 script를 담기위한 변수 초기화 - 동일페이지 내에서 처리
		String msg = null; 
		
		//응답에 관해 추가적으로 여러개 보낼때 사용할 변수 초기화 
		ResponseEntity resEntity = null;
		
		//응답시 헤더 부분에 추가할 내용
		HttpHeaders responseHerders = new HttpHeaders(); 
		responseHerders.add("Content-Type", "text/html; charset=UTF-8");
		
		/*파라미터로 받은 상품번호를 이용하여 DB내에 해당 상품번호의 행 삭제 후 삭제한 갯수를
		  return받아 삭제된 행이 있을 경우 폴더와, 폴더 내부 파일 삭제 */
		int result = adminGoodsService.removeGoods(goods_no);
		
		try {
			if(result>0) {
				//폴더명이 해당 상품번호인 폴더 안에 있는 파일 삭제 후 해당 폴더 삭제 메서드
				removeGoodsImgFolder(goods_no);
				
				msg = "<script>";
				msg += "alert('상품이 삭제되었습니다');";		
				msg += "location.href='"+request.getContextPath()+"/admin/gift-shop.mo'";
				msg += "</script>";
			}//if
		}catch(Exception e) {
			msg = "<script>";
			msg += "alert('오류로 인해 상품 삭제가 실패되었습니다');";		
			msg += "location.href='"+request.getContextPath()+"/admin/gift-shop.mo'";
			msg += "</script>";
			e.printStackTrace();
		}
		
		//응답할 내용, 응답시 헤더에 추가, status지정(응답코드) 객체 생성
		resEntity = new ResponseEntity(msg,responseHerders,HttpStatus.OK);
		
		//스크립트 형태의 내용을 view에 전달
		return resEntity;
	}
	
	//(관리자) 체크박스 상품 삭제
	@Override
	@ResponseBody
	@RequestMapping("/admin/gift-shop/removeCheckedGoods.mo")
	public String removeCheckedGoods(@RequestParam("checkArr[]") List<Integer> checkArr) throws Exception {
		
		/*파라미터로 받은 상품번호를 이용하여 DB내에 해당 상품번호의 행 삭제 후 삭제한 갯수를
		  return받아 return받은 값과 삭제할 갯수를 비교하여 일치할 경우 해당 상품번호의 폴더와, 폴더 내부 파일 삭제 */
		int result = adminGoodsService.removeCheckedGoods(checkArr);

		if(result==checkArr.size()) {
			for(Integer goods_no : checkArr){
				//폴더명이 상품번호인 폴더 삭제 후 내부 파일 삭제 메서드
				removeGoodsImgFolder(goods_no);
			}
			//성공시 전송할 데이터 
			return "success";
		}else {
			//실패시 전송할 데이터 
			return "failed";
		}
	}
	
	
	//(관리자) 연매출조회 폼 보여주기
	@Override
	@RequestMapping("/admin/gift-shop/goodsSales.mo")
	public ModelAndView goodsSales(ModelAndView mv) throws Exception {
		//view지정
		mv.setViewName("/admin/giftShop/goodsYearSales");
		return mv;
	}
	
	//(관리자) 연매출 조회 
	@Override
	@SuppressWarnings("unchecked")
	@ResponseBody
	@RequestMapping("/admin/gift-shop/getGoodsSales.mo")
	public JSONArray getGoodsSales() throws Exception {
		
		//DB에서 연도별로 조회한 매출 정보를 List안에 Map으로 받기 
		List<Map<String, String>> listMap = adminGoodsService.getGoodsYearSales();
		
		//구글 그래프 시각화를 위해 배열을 담기 위한 배열 객체 생성
		JSONArray jsonArray = new JSONArray();
		
		//컬럼 타이틀 설정을 위한 객체 생성
		JSONArray colNameArray = new JSONArray(); 
		colNameArray.add("연도");
		colNameArray.add("매출");
		jsonArray.add(colNameArray);
		
		/*DB에서 연도별로 조회한 매출 정보가 담긴 List의 크기 만큼 반복을 돌면서
		  Map안에 있는 값을 rowArray에 추가 후 
		    구글 그래프 시각화를 위해 배열을 담기 위한 배열에 추가 */
		for(int i=0;i<listMap.size();i++) {
			JSONArray rowArray = new JSONArray();
			rowArray.add(listMap.get(i).get("year"));
			rowArray.add(listMap.get(i).get("total"));
			jsonArray.add(rowArray);
		}
		
		//데이터가 담긴 배열을 전달
		return jsonArray;
	}
	
	//(관리자) 월 매출 조회
	@Override
	@RequestMapping("/admin/gift-shop/getGoodsMonthlySales.mo")
	public ModelAndView getGoodsMonthlySales(ModelAndView mv) throws Exception {
		
		//DB에서 월 매출 조회한 정보를 List안에 Map으로 받기 
		List<Map<String,Object>> listMap = adminGoodsService.getGoodsMonthlySales();
		
		//월매출 정보를 view에 전달
		mv.addObject("listMap", listMap);
		
		//view지정
		mv.setViewName("/admin/giftShop/goodsMonthlySales");
		return mv;
	}
	
	//(관리자) 월별  일매출 조회
	@Override
	@RequestMapping("/admin/gift-shop/getGoodsDailySales.mo")
	public ModelAndView getGoodsDailySales(ModelAndView mv,
								@RequestParam("year") int year,
								@RequestParam("month") int month) throws Exception {
		
		//파라미터로 받은 값을 담을 Map생성
		Map<String,Object> yearAndMonthMap = new HashMap<String,Object>();
		yearAndMonthMap.put("year", year);		//연도
		yearAndMonthMap.put("month", month);	//월
		
		//DB에서 연도별 월로 조회한 일매출의 정보를  List안에 Map으로 받기 
		List<Map<String,Object>> listMap = adminGoodsService.getGoodsDailySales(year,month);
		
		//view에서 ㅇㅇ년 ㅇㅇ월 으로 보여주기 위해 view에전달
		mv.addObject("dateInfo", yearAndMonthMap);
		
		//연도별 월별 일매출 정보를 view에 전달
		mv.addObject("listMap", listMap);
		
		//view지정
		mv.setViewName("/admin/giftShop/goodsDailySales");
		return mv;
	}
	
}
