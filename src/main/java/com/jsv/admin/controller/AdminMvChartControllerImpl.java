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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.jsv.admin.service.AdminMvChartService;
import com.jsv.common.base.BaseController;

@Controller("adminmvChartController")
public class AdminMvChartControllerImpl extends BaseController implements AdminMvChartController {

	@Autowired
	private AdminMvChartService adminmvchartservice;
	
	//파일 저장 위치
    private static final  String  CURR_IMAGE_PATH = "c:\\jsv\\mvChart\\";
    
	//무비차트 폼 보여주기
	@Override
	@RequestMapping("/admin/mvchart/newMvchartForm.mo")
	public String newMvChartForm(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		return "/admin/mvchart/newMvchartForm";
	}

	
	//무비차트 등록처리
	@Override
	@RequestMapping("/admin/mvchart/newMvchart.mo")
	public ResponseEntity newMvChart(MultipartHttpServletRequest multiReq, HttpServletResponse response)
			throws Exception {
			response.setContentType("text/html; charset=UTF-8");		
			System.out.println("newMvChart()진입");
			
			//1.파라미터 가져오기
			Map<String,Object> mvChartmap = new HashMap<String,Object>();
			
			Enumeration enu = multiReq.getParameterNames(); //파라미터명을 전부 가져오기
			while( enu.hasMoreElements() ) { 
				String name = (String)enu.nextElement(); //파라미터명을 하나씩 가져와 name변수에 저장
				    String value = multiReq.getParameter(name);//저장된 한개의 파라미터명에 해당하는  값을  가져오기
				    mvChartmap.put(name, value);
			}
			
			//base mupload1 메서드, originalname가져오기
			 String c_img = mupload1(multiReq);//tmp에 저장
			 if (c_img!=null && c_img.length()!=0) {
				 mvChartmap.put("c_img", c_img);
			 }
			 
			//2.비즈니스로직수행<->Service<->DAO<->MyBatis<->DB
			String msg = null; //veiw 전달내용
			ResponseEntity resEntity = null;	//응답시 보낼내용
			HttpHeaders responseHeaders = new HttpHeaders();
			responseHeaders.add("Content-Type", "text/html; charset=UTF-8"); 
			 
			int cno = adminmvchartservice.newMvChart(mvChartmap);
			try {
				if(c_img!=null && c_img.length()!=0) {
					File srcFile = new File(CURR_IMAGE_PATH+"\\temp\\"+c_img); //temp에 있는 파일변경!!!!!!!!!!
					File destDir = new File (CURR_IMAGE_PATH+"\\"+cno);	//cno 폴더 생성
					FileUtils.moveFileToDirectory(srcFile, destDir, true); //파일에서 디렉토리로 이동
				}//if
					msg = "<script>";
					msg += "alert('새 상품을 추가하였습니다');";		
					msg += "location.href='"+multiReq.getContextPath()+"/mvchart/mvChartList.mo'";
					msg += "</script>";
				}catch(Exception e) {
					//예외가 발생하면  이미지저장소의 temp폴더에 있는 파일을 삭제
					if(c_img!=null && c_img.length()!=0) {
							File srcFile = new File(CURR_IMAGE_PATH+"\\temp\\"+c_img); //이미지저장소의 temp폴더에 있는 파일
							srcFile.delete(); //파일을 삭제
					}//if	
					msg = "<script>";
					msg += "alert('오류가 발생했습니다. 다시 시도해주세요');";		
					msg += "location.href='"+multiReq.getContextPath()+"/admin/mvchart/newMvchartForm.mo'";
					msg += "</script>";
					e.printStackTrace(); //콘솔에 출력
				}//try catch
	
				resEntity = new ResponseEntity(msg, responseHeaders, HttpStatus.OK);
				return resEntity;
	}
	
		//무비차트 삭제
		@Override
		@RequestMapping("/mvchart/delete.mo")
		public String delMvChart(HttpServletRequest request, HttpServletResponse response, int cno) throws Exception {
				delCFile(request, cno);
				adminmvchartservice.delMyChart(cno);
				
				return "redirect:/mvchart/mvChartList.mo";
		}

}
