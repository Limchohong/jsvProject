package com.jsv.admin.controller;


import java.io.File;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

import com.jsv.admin.service.AdminEventService;
import com.jsv.common.base.BaseController;
import com.jsv.event.dto.EventDTO;
import com.jsv.event.service.EventService;
@Controller("admineventcontroller")
public class AdminEventControllerImpl extends BaseController implements AdminEventController {

	//파일 저장 위치
    private static final  String  CURR_IMAGE_PATH = "c:\\jsv\\event\\";
    
    //서비스
    @Autowired
    private AdminEventService admineventservice;
    
    @Autowired
    private EventService eventsevice;
    
	//이벤트 등록폼 보여주기
	@Override
	@RequestMapping("/admin/event/newEventForm.mo")
	public String newEventForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return "/admin/event/newEventForm";
	}
	
	//이벤트 등록하기
	@Override
	@RequestMapping(value="/admin/event/newEvent.mo",method=RequestMethod.POST)
	public ResponseEntity newEvent(MultipartHttpServletRequest multiReq, HttpServletResponse response)
			throws Exception {
		
			response.setContentType("text/html; charset=UTF-8");		
			System.out.println("newEventController()진입");
			
			//1.파라미터 가져오기
			Map<String,Object> eventMap = new HashMap<String,Object>();
			
			Enumeration enu = multiReq.getParameterNames(); //파라미터명을 전부 가져오기
			while( enu.hasMoreElements() ) { 
				String name = (String)enu.nextElement(); //파라미터명을 하나씩 가져와 name변수에 저장
				    String value = multiReq.getParameter(name);//저장된 한개의 파라미터명에 해당하는  값을  가져오기
				    eventMap.put(name, value);
			}
			
			//base upload1 메서드, originalname가져오기
			 String e_img = upload1(multiReq);//tmp에 저장
			 if (e_img!=null && e_img.length()!=0) {
				 eventMap.put("e_img", e_img);
			 }
			 
			//2.비즈니스로직수행<->Service<->DAO<->MyBatis<->DB
			String msg = null; //veiw 전달내용
			ResponseEntity resEntity = null;	//응답시 보낼내용
			HttpHeaders responseHeaders = new HttpHeaders();
			responseHeaders.add("Content-Type", "text/html; charset=UTF-8"); 
			 
			int eno = admineventservice.newEvent(eventMap);
			try {
				if(e_img!=null && e_img.length()!=0) {
					File srcFile = new File(CURR_IMAGE_PATH+"\\temp\\"+e_img); //temp에 있는 파일
					File destDir = new File (CURR_IMAGE_PATH+"\\"+eno);	//eno 폴더 생성
					FileUtils.moveFileToDirectory(srcFile, destDir, true); //파일에서 디렉토리로 이동
				}//if
					msg = "<script>";
					msg += "alert('새 상품을 추가하였습니다');";		
					msg += "location.href='"+multiReq.getContextPath()+"/event/eventList.mo'";
					msg += "</script>";
				}catch(Exception e) {
					//예외가 발생하면  이미지저장소의 temp폴더에 있는 파일을 삭제
					if(e_img!=null && e_img.length()!=0) {
							File srcFile = new File(CURR_IMAGE_PATH+"\\temp\\"+e_img); //이미지저장소의 temp폴더에 있는 파일
							srcFile.delete(); //파일을 삭제
					}//if	
					msg = "<script>";
					msg += "alert('오류가 발생했습니다. 다시 시도해주세요');";		
					msg += "location.href='"+multiReq.getContextPath()+"/admin/event/newEvent.mo'";
					msg += "</script>";
					e.printStackTrace(); //콘솔에 출력
				}//try catch
	
				resEntity = new ResponseEntity(msg, responseHeaders, HttpStatus.OK);
				return resEntity;
		}

		//이벤트 삭제하기
		@Override
		@RequestMapping(value="/event/delete.mo",method=RequestMethod.GET)
		public String delEvent(HttpServletRequest request, HttpServletResponse response, @RequestParam ("eno") int eno) throws Exception {
				//파일삭제
				 	delFile(request,eno);
					admineventservice.delEvent(eno);					
					return "redirect:/event/eventList.mo";					
	   }

		//이벤트 수정 폼 보여주기 
		@Override
		@RequestMapping(value="/admin/event/updateForm.mo",method=RequestMethod.GET)
		public String newEvent(HttpServletRequest request, HttpServletResponse response, int eno,Model model) throws Exception {
			//비지니스로직
			EventDTO Eupdata = eventsevice.getEdetail(eno);
			model.addAttribute("Eupdata", Eupdata);
			return "/admin/event/updateEventForm";
		}

		//이벤트 수정처리 + 파일
		@Override
		@RequestMapping(value="/event/update.mo",method=RequestMethod.POST)
		public String updateEvent(MultipartHttpServletRequest  request, 
				   HttpServletResponse response) throws Exception {
				System.out.println("수정처리 진입 제 ~ 발");
				Map<String,Object> eventMap = new HashMap<String,Object>();
				//파라미터 받기
				int eno = Integer.parseInt(request.getParameter("eno"));
				String ename= request.getParameter("ename");
				String estart= request.getParameter("estart");
				String eEnd= request.getParameter("eEnd");
				MultipartFile file = request.getFile("file");	//변수선어
				
				EventDTO eventdto = new EventDTO();
				eventdto.setEno(eno);
				eventdto.setEname(ename);
				eventdto.setEstart(estart);
				eventdto.seteEnd(eEnd);
				System.out.println("set된 파라미터="+eno+ename+estart+eEnd);
				if(!file.isEmpty()) {
					//기존파일 조회
					EventDTO info = (EventDTO)eventsevice.getEdetail(eno);
					String path= CURR_IMAGE_PATH+eno;
					//기존파일 존재하면 지우는 부분
					String originSaveNum = info.getE_img();
					System.out.println("orginSaveNUM"+originSaveNum);
					File fileOrginSave = new File(path+"\\"+originSaveNum);//기존 파일명 조회
					System.out.println("eno"+eno);
					System.out.println("path"+fileOrginSave);
					if(fileOrginSave.exists()) {//존재하면
						fileOrginSave.delete();	//삭제
					}
					//새로운 파일 올리는 부분
					 String e_img=upload1(request);
					 if(e_img!=null && e_img.length()!=0) {
						 eventdto.setE_img(e_img);
						 File srcFile = new File(CURR_IMAGE_PATH+"\\temp\\"+e_img); //temp에 있는 파일
						 File destDir = new File (CURR_IMAGE_PATH+"\\"+eno);	//eno 폴더 생성
						 FileUtils.moveFileToDirectory(srcFile, destDir, true); //파일에서 디렉토리로 이동
					 }
				}
				admineventservice.updatEimg(eventdto);
				admineventservice.updateEvent(eventdto);
				return"redirect:/event/eventList.mo";	
		}
		
}