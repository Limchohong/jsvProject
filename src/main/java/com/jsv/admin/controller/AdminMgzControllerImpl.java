package com.jsv.admin.controller;


import java.io.File;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.jsv.admin.service.AdminMgzService;
import com.jsv.common.base.BaseController;
import com.jsv.event.dto.EventDTO;
import com.jsv.mgz.dto.MfileDTO;

@Controller("adminMgzController")
public class AdminMgzControllerImpl extends BaseController implements AdminMgzController {
	
	//파일 저장 위치
    private static final  String  CURR_IMAGE_PATH = "c:\\jsv\\mgz";
	
	@Autowired
	private AdminMgzService adminmgzservice;
	//매거진 등록폼 보여주기
	@Override
	@RequestMapping("/admin/mgz/newMgzForm.mo")
	public String newMgzForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
			return "/admin/mgz/newMgzForm";
	}

	//매거진 등록처리
	@Override
	@RequestMapping(value="/admin/mgz/newMgz.mo",method=RequestMethod.POST)
	public ResponseEntity newMgz(MultipartHttpServletRequest request, HttpServletResponse response) throws Exception {
			response.setContentType("text/html; charset=UTF-8");
		
			String imgName=null;  //이미지파일명을 저장하기위한 변수선언
		
			System.out.println("newMgz()진입");
		
			//정보 이미지를 담기위한 Map생성
			Map newMgzMap = new HashMap();
		
			//1.파라미터 map 매거진 정보 + 이미지처리 함
			Enumeration enu = request.getParameterNames(); //파라미터명을 전부 가져오기
			while( enu.hasMoreElements() ) { 
				String name = (String)enu.nextElement(); //파라미터명을 하나씩 가져와 name변수에 저장
			    String value = request.getParameter(name);//저장된 한개의 파라미터명에 해당하는  값을  가져오기
			    newMgzMap.put(name, value);
			}
		
			 //첨부파일이미지정보목록 가져오기
			 List<MfileDTO> imageFileList =  Multiupload(request);
			 if(imageFileList!=null && imageFileList.size()!=0 ) {
				 	newMgzMap.put("imageFileList",imageFileList);
			 }
		 
			//2.비즈니스로직수행
			String msg = null;
			ResponseEntity resEntity = null;
			HttpHeaders responseHeaders = new HttpHeaders();
			responseHeaders.add("Content-Type", "text/html; charset=UTF-8"); 
			 
			int mno = adminmgzservice.newMgz(newMgzMap);	//매거진 mno
			try {
				if(imageFileList!=null && imageFileList.size()!=0 ) {
					System.out.println("리스트에서 받아왔나?"+imageFileList);
					for(MfileDTO mfiledto :imageFileList) {
						imgName = mfiledto.getmFame();
						File srcFile = new File(CURR_IMAGE_PATH+"\\temp\\"+imgName); //이미지저장소의 temp폴더에 있는 파일
						File destDir = new File(CURR_IMAGE_PATH+"\\"+mno); //이미지저장소내  상품번호(goods_id)이름인 폴더를 생성
						FileUtils.moveFileToDirectory(srcFile, destDir, true);
					}//for
				}//if
				msg = "<script>";
				msg += "alert('게시물을 추가하였습니다');";		
				msg += "location.href='"+request.getContextPath()+"/mgz/mgzList.mo'";
				msg += "</script>";
			}catch(Exception e) {
				//예외가 발생하면  이미지저장소의 temp폴더에 있는 파일을 삭제
				if(imageFileList!=null && imageFileList.size()!=0 ) {
					for(MfileDTO mfiledto : imageFileList) {
						imgName = mfiledto.getmFame();
						File srcFile = new File(CURR_IMAGE_PATH+"\\temp\\"+imgName); // temp폴더에 있는 파일
						srcFile.delete(); //파일을 삭제
					}//for
				}//if	
				msg = "<script>";
				msg += "alert('오류가 발생했습니다. 다시 시도해주세요');";		
				msg += "location.href='"+request.getContextPath()+"/mgz/mgzList.mo'";
				msg += "</script>";
				e.printStackTrace(); //콘솔에 출력
			}//try catch
			resEntity = new ResponseEntity(msg, responseHeaders, HttpStatus.OK);
			return resEntity;
		}

	
	//매거진 삭제처리
	@Override
	@RequestMapping("/mgz/delete.mo")
	public String delMgz(HttpServletRequest request, HttpServletResponse response, int mno) throws Exception {
			delMFile(request,mno);
			adminmgzservice.delMgz(mno);
			return "redirect:/mgz/mgzList.mo";
	}

	//수정폼 보여주기
	@Override
	@RequestMapping(value="/admin/mgz/updateForm.mo",method=RequestMethod.GET)
	public String updateMgz(HttpServletRequest request, HttpServletResponse response,int mno, Model model) throws Exception {
		
		//비지니스로직
		Map mgzMap = adminmgzservice.getMgzDetail(mno);	//맵으로 묶어놓은거 처리
		model.addAttribute("mgzMap", mgzMap);
	
		//view&모델
		return "/admin/mgz/updateMgzForm";
	}

	//매거진 정보 수정처리 요청
	@Override
	@RequestMapping(value="/mgz/updateMgzInfo.mo",method=RequestMethod.POST)
	public ResponseEntity updateMinfo (MultipartHttpServletRequest multipartRequest, HttpServletResponse response,
			@RequestParam("mno") int mno,
			@RequestParam("attr")  String attribute,
			@RequestParam("value") String value) throws Exception {
		
			
			Map mgzMap = new HashMap();
			MfileDTO mfiledto = new MfileDTO();
			mfiledto=Modupload(multipartRequest);
			mgzMap.put("mno", mno);
			mgzMap.put(attribute, value);
			
			int result = adminmgzservice.updateMinfo(mgzMap);
			
			ResponseEntity resEntity = null;
			HttpHeaders responseHeaders = new HttpHeaders();
			
			String data = null;	//메세지 변수
			
			if(result==1) {//업데이트 성공하면
				data ="updateSuccess";
			}else {
				data="updateFail";
			}
			resEntity = new ResponseEntity(data, responseHeaders, HttpStatus.OK);
			return resEntity;
		}

	   //이미지 수정처리
	   @Override
	   @RequestMapping(value="/mgz/updateMgzImg.mo",method=RequestMethod.POST)
	   public void updateMimg(MultipartHttpServletRequest multipartRequest, HttpServletResponse response)
	         throws Exception {
		   System.out.println("이미지파일수정처리 updateGoodsImageFile()진입");
			
			//2.비즈니스로직 -DB작업, File객체 작업
			response.setContentType("text/html; charset=UTF-8");
			String imageFileName=null;  //이미지파일명을 저장하기위한 변수선언
		
			
			 HttpSession session = multipartRequest.getSession();		//난중
			 MfileDTO mfiledto = new MfileDTO();
			 mfiledto = Modupload(multipartRequest);
			 int mno = mfiledto.getMno();
					if(mfiledto!=null) { 
						imageFileName = mfiledto.getmFame();
						File srcFile = new File(CURR_IMAGE_PATH+"\\temp\\"+imageFileName); //이미지저장소의 temp폴더에 있는 파일
						File destDir = new File(CURR_IMAGE_PATH+"\\"+mno); //이미지저장소내  상품번호(goods_id)이름인 폴더를 생성
						FileUtils.moveFileToDirectory(srcFile, destDir, true);
				 }//if 처리
				 adminmgzservice.updateMimg(mfiledto);	
				 }
	   
			 }
