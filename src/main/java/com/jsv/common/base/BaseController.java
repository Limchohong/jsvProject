package com.jsv.common.base;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.jsv.mgz.dto.MfileDTO;

public class BaseController {
	
	private static final String CURR_IMAGE_PATH = "C:\\jsv";
	
	private void makeDir() {
		File dir = new File(CURR_IMAGE_PATH);
		 if(!dir.exists()) {
			 dir.mkdirs();
		 }
	}
	
	//기프트샵 상품 이미지 업로드
	 public String uploadGoodsImg(MultipartHttpServletRequest multiResuest) throws IOException {
		 makeDir();
		 
		 //파일객체 얻어오기
		 MultipartFile mf =  multiResuest.getFile("goods_img");
		 
		 //원본파일명 얻어오기
		 String originalName =  mf.getOriginalFilename();
		
		 //이미지 저장 경로
		 String path = CURR_IMAGE_PATH+"\\goods\\temp\\"; 
		 
		 File file = new File(path);
		 
		//해당 경로에 폴더가 없을 경우 폴더 생성
		 if(!file.exists()) {	
			 if(file.mkdirs()) {
				file.createNewFile();
			 }
		 }
		 
		 //해당 경로 밑에 원본파일명으로 파일 객체 생성
		 File saveFullPath = new File(path+"\\"+originalName);
		 
		//파일 객체 생성후 복사
		 mf.transferTo(saveFullPath);	
		 
		 //원본파일명 전달
		 return originalName;
	 }
	 
	 //기프트샵 - 상품 업로드 이미지 폴더이동
	 public void uploadGoodsImgMove(String goods_img,int goods_no) throws IOException {
		 
		 //기존에 업로드 되어 있는 경로 
		 File srcFile = new File(CURR_IMAGE_PATH+"\\goods\\temp\\"+goods_img);
		 
		 //이동할 경로 
		 File destDir = new File(CURR_IMAGE_PATH+"\\goods\\"+goods_no);
		 
		 //폴더를 생성하여 해당 폴더로 파일 이동
		 FileUtils.moveFileToDirectory(srcFile, destDir, true);
	 }
	 
	 //기프트샵 - 상품 이미지 폴더 삭제
	 public void removeGoodsImgFolder(Object goods_no) {
		 
		 //파일 경로로 객체 생성
		 File dir = new File(CURR_IMAGE_PATH+"\\goods\\"+goods_no);
		 
		 //해당 폴더에 파일이 있을 경우 폴더 내 파일 삭제 후 폴더 삭제
		 if(dir.exists()) {
			 File[] files = dir.listFiles();
			 for(int i=0;i<files.length;i++) {
					 files[i].delete();
			 }//for
			 dir.delete();
		 }
	 }
	 
	//무비차트 단일 파일업로드,,
	 public String mupload1(MultipartHttpServletRequest  multipartRequest) throws Exception {
		  makeDir();
		  MultipartFile mf = multipartRequest.getFile("file");
		  String originalName = mf.getOriginalFilename();
		  System.out.println("이름"+originalName);
		  String path= CURR_IMAGE_PATH +"\\mvChart\\temp\\"; //저장경로
		  File file = new File(path);
		  if(!file.exists()) {
			  if(file.mkdir()) {
				  file.createNewFile();
			  }
		  }
		  File saveFile = new File(path+"\\"+originalName);
		  mf.transferTo(saveFile);
	  	  
		  return originalName;
	  }
	  
	 
	 //이벤트단일파일업로드
	  public String upload1(MultipartHttpServletRequest  multipartRequest) throws Exception {
		  makeDir();
		  MultipartFile mf = multipartRequest.getFile("file");
		  String originalName = mf.getOriginalFilename();
		  System.out.println("이름"+originalName);
		  String path= CURR_IMAGE_PATH +"\\event\\temp\\"; //저장경로
		  File file = new File(path);
		  if(!file.exists()) {
			  if(file.mkdir()) {
				  file.createNewFile();
			  }
		  }
		  File saveFile = new File(path+"\\"+originalName);
		  mf.transferTo(saveFile);
	  	  
		  return originalName;
	  }
	  
	  //다중 업로드
	  public  List<MfileDTO> Multiupload(MultipartHttpServletRequest  multipartRequest) throws Exception {
		   System.out.println("업로드 진입!@@");
		   List<MfileDTO> fileList = new ArrayList<MfileDTO>();
		   Iterator<String> fileNames = multipartRequest.getFileNames();
		   while( fileNames.hasNext() ) {
			   MfileDTO mfiledto = new MfileDTO();
			   String fileName = fileNames.next();  //여기에서는 파라미터명에 해당
			   mfiledto.setmFtype(fileName);//동적으로 추가되는 파일들
			   
			   MultipartFile mFile = multipartRequest.getFile(fileName);
			   String originalFileName = mFile.getOriginalFilename(); //실제 파일명을 가져오기
			   mfiledto.setmFame(originalFileName); //이미지파일명 
			   fileList.add(mfiledto);
			   String path= CURR_IMAGE_PATH +"\\mgz\\"; //저장경로
			   File file = new File(path+fileName);
			   if( mFile.getSize()!=0 ) {  //첨부된 파일이 존재하면
				   if(!file.exists()){ 
					   if(file.getParentFile().mkdirs()) {//폴더생성하기
					   file.createNewFile(); //파일생성
					   }
				   } 
				   mFile.transferTo(new File(CURR_IMAGE_PATH+"\\mgz\\temp\\"+originalFileName));
			   }//if끝		   
		   }//while		  
		   return fileList; //첨부파일정보
	  }
	  //다중업로드 수정처리를 위한 메서드
	  public MfileDTO Modupload(MultipartHttpServletRequest  multipartRequest) throws Exception {
			  System.out.println("수정처리 업로드 진입");
			  
			  MfileDTO mfiledto = new MfileDTO();
			  Iterator<String> fileNames = multipartRequest.getFileNames();
			  Map  imgMap = new HashMap();
			  Enumeration enu = multipartRequest.getParameterNames(); //파라미터명을 전부 가져오기
		  
			  int mno = Integer.parseInt(multipartRequest.getParameter("mno"));
			  int mFno = Integer.parseInt(multipartRequest.getParameter("mFno"));
			  
		  while(fileNames.hasNext()) {//파일
			   String fileName = fileNames.next();  //여기에서는 파라미터명에 해당
			   mfiledto.setmFtype(fileName);//동적으로 추가되는 파일들
			   mfiledto.setmFno(mFno);	//번호
			   mfiledto.setMno(mno);	//번호
			   //셋팅
			   MultipartFile mFile = multipartRequest.getFile(fileName);
			   String originalFileName = mFile.getOriginalFilename(); //실제 파일명을 가져오기
			   mfiledto.setmFame(originalFileName); //이미지파일명 

			   String path= CURR_IMAGE_PATH +"\\mgz\\"; //저장경로
			   File file = new File(path+fileName);
			 
			   if( mFile.getSize()!=0 ) {  //첨부된 파일이 존재하면
				   if(!file.exists()){ 
					   if(file.getParentFile().mkdirs()) {//폴더생성하기
					   file.createNewFile(); //파일생성
					   }
				   } 
				   mFile.transferTo(new File(CURR_IMAGE_PATH+"\\mgz\\temp\\"+originalFileName));
			   }//if끝		   
		   }//while		  
		   return mfiledto; //첨부파일정보+파라미터 전부 다 넣었음
	  }
	  
	  //이벤트 파일 삭제
	  public void delFile(HttpServletRequest request,@RequestParam("eno") int eno) {
		  System.out.println("delfile진입");
		  System.out.println("eno"+eno);
		  
		  String filePath="c:\\jsv\\event\\"+eno;
		  File file = new File(filePath);	        
	      if(file.exists()){ //파일존재여부확인		          
	         if(file.isDirectory()){ //파일이 디렉토리인지 확인	             
	            File[] files = file.listFiles();             
	            for( int i=0; i<files.length; i++){
	               if( files[i].delete() ){
	                  System.out.println(files[i].getName()+" 삭제성공");
	               }else{
	                  System.out.println(files[i].getName()+" 삭제실패");
	               }
	            } //for
	         }//if
	         if(file.delete()){
	            System.out.println("파일삭제 성공");
	         }else{
	            System.out.println("파일삭제 실패");
	         }
	      }
	  }
	  
	  //무비차트 삭제
	  public void delCFile(HttpServletRequest request,@RequestParam("cno") int cno) {
		  String filePath="c:\\jsv\\mvChart\\"+cno;
		  File file = new File(filePath);	        
		  if(file.exists()){ //파일존재여부확인		          
			  if(file.isDirectory()){ //파일이 디렉토리인지 확인	             
				  File[] files = file.listFiles();             
				  for( int i=0; i<files.length; i++){
					  if( files[i].delete() ){
						  System.out.println(files[i].getName()+" 삭제성공");
					  }else{
						  System.out.println(files[i].getName()+" 삭제실패");
					  }
				  } //for
			  }//if
			  if(file.delete()){
				  System.out.println("파일삭제 성공");
			  }else{
				  System.out.println("파일삭제 실패");
			  }
		  }
	  }
	  
	  //다중파일 삭제
	  public void delMFile(HttpServletRequest request,@RequestParam("mno") int mno) {
		  System.out.println("delfile진입");
		  System.out.println("mno"+mno);
		  
		  String filePath="c:\\jsv\\mgz\\"+mno;
		  File file = new File(filePath);	        
	      if(file.exists()){ //파일존재여부확인		          
	         if(file.isDirectory()){ //파일이 디렉토리인지 확인	             
	            File[] files = file.listFiles();             
	            for( int i=0; i<files.length; i++){
	               if( files[i].delete() ){
	                  System.out.println(files[i].getName()+" 삭제성공");
	               }else{
	                  System.out.println(files[i].getName()+" 삭제실패");
	               }
	            } //for
	         }//if
	         if(file.delete()){
	            System.out.println("파일삭제 성공");
	         }else{
	            System.out.println("파일삭제 실패");
	         }
	      }
	  }
	 
}
