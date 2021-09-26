package com.jsv.common.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import net.coobird.thumbnailator.Thumbnails;
@Controller("FileDownloadController")
public class FileDownloadController {

	private static final String CURR_IMAGE_PATH = "C:\\jsv";
	
	//기프트샵 - 상품 상세조회시 썸네일
	@RequestMapping("/goodsMainThum.mo")
	public void goodsMainThum(HttpServletRequest request,HttpServletResponse response,
			 @RequestParam("goods_no") int goods_no,
			 @RequestParam("goods_img") String goods_img) throws Exception{
		
		String filePath = CURR_IMAGE_PATH+"\\goods\\"+goods_no+"\\"+goods_img;
		File image = new File(filePath);
		OutputStream out = response.getOutputStream();
		
		response.setHeader("Cache-Control", "no-cache");
		response.addHeader("Content-disposition", "attachment;fileName="+goods_img);
		
		if(image.exists()) {
			Thumbnails.of(image).size(420,420).outputFormat("png").toOutputStream(out);
		}else {
			return;
		}
		
		byte[] buffer = new byte[1024*8];
		out.write(buffer);
		out.close();
		
	}
	
	//기프트샵 - 상품 메인페이지 목록에서 조회시 
	@RequestMapping("/goodsMainListThum.mo")
	public void goodsMainListThum(HttpServletRequest request,HttpServletResponse response,
							@RequestParam("goods_no") int goods_no,
							@RequestParam("goods_img") String goods_img) throws Exception{
		
		String filePath = CURR_IMAGE_PATH+"\\goods\\"+goods_no+"\\"+goods_img;
		File image = new File(filePath);
		OutputStream out = response.getOutputStream();
		
		response.setHeader("Cache-Control", "no-cache");
		response.addHeader("Content-disposition", "attachment;fileName="+goods_img);
		
		if(image.exists()) {
			Thumbnails.of(image).size(220,220).outputFormat("png").toOutputStream(out);
		}else {
			return;
		}
		
		byte[] buffer = new byte[1024*8];
		out.write(buffer);
		out.close();
	}
	
	//기프트샵 - 카테고리별 조회시 이미지 사이즈
	@RequestMapping("/goodsCateListThum.mo")
	public void goodsCateListThum(HttpServletRequest request,HttpServletResponse response,
							@RequestParam("goods_no") int goods_no,
							@RequestParam("goods_img") String goods_img) throws Exception{
		
		String filePath = CURR_IMAGE_PATH+"\\goods\\"+goods_no+"\\"+goods_img;
		File image = new File(filePath);
		OutputStream out = response.getOutputStream();
		
		response.setHeader("Cache-Control", "no-cache");
		response.addHeader("Content-disposition", "attachment;fileName="+goods_img);
		
		if(image.exists()) {
			Thumbnails.of(image).size(270,270).outputFormat("png").toOutputStream(out);
		}else {
			return;
		}
		
		byte[] buffer = new byte[1024*8];
		out.write(buffer);
		out.close();
	}
	
	//기프트샵 - 장바구니  조회시 이미지 사이즈
	@RequestMapping("/cartThum.mo")
	public void CartListThum(HttpServletRequest request,HttpServletResponse response,
							@RequestParam("goods_no") int goods_no,
							@RequestParam("goods_img") String goods_img) throws Exception{
		
		String filePath = CURR_IMAGE_PATH+"\\goods\\"+goods_no+"\\"+goods_img;
		File image = new File(filePath);
		OutputStream out = response.getOutputStream();
		
		response.setHeader("Cache-Control", "no-cache");
		response.addHeader("Content-disposition", "attachment;fileName="+goods_img);
		
		if(image.exists()) {
			Thumbnails.of(image).size(90,90).outputFormat("png").toOutputStream(out);
		}else {
			return;
		}
		
		byte[] buffer = new byte[1024*8];
		out.write(buffer);
		out.close();
	}
	
	 //이벤트 다운로드
	@RequestMapping("/download.mo")
	public  void  download(HttpServletRequest request,
		HttpServletResponse response,@RequestParam("eno") int eno,
		@RequestParam("e_img")String e_img) throws Exception {
		
		//1.파라미터받기 -  읽어들일 파일이 존재하는 폴더명 & 읽어들일 파일명
		System.out.println("e_img ="+e_img);
		
		String filePath = CURR_IMAGE_PATH+"\\event\\"+eno+"\\"+e_img;
		
		//2.비즈니스로직수행
		//filePath에 있는 파일의 정보를 읽어와   브라우저로 전송
		File image = new File(filePath);
		FileInputStream fin = new FileInputStream(image);
		OutputStream  out = response.getOutputStream();
		
		response.setHeader("Cache-Control", "no-cache");
		response.addHeader("Content-disposition", "attachment;fileName="+e_img);
		
		
		//파일 ->버퍼
		byte[] buffer = new byte[1024*8];
		while(true) {
			int count = fin.read(buffer); //버퍼에서 읽어들인 length
			if(count==-1) break; //버퍼에서 더 이상 읽어들일 내용이 없다면 -1을 리턴
			out.write(buffer, 0, count); //버퍼에서 읽어들인 길이만큼 브라우저로 출력
		}
		out.flush();
		fin.close();
		out.close();
	}
	
	//이벤트 썸넬
	@RequestMapping("/thumbnails.mo")
	public void  thummake(HttpServletRequest request,
			HttpServletResponse response,
			@RequestParam("eno") int eno,
			@RequestParam("e_img") String e_img
			) throws Exception {
		
		String filePath = CURR_IMAGE_PATH+"\\event\\"+eno+"\\"+e_img;
		File image = new File(filePath);
		OutputStream  out = response.getOutputStream();
		
		if( image.exists() ) {
			//썸네일이미지로 만들어서 다운로드 하겠다
			//원본 이미지에 대한  썸네일 이미지를 생성한 후   OutputStream객체에 할당한다
			Thumbnails.of(image).size(256, 170).outputFormat("png").toOutputStream(out);
		}//else {
		
		byte[] buffer = new byte[1024*8];
		out.write(buffer);
		out.close();
	}
	
	//무비차트썸넬
	@RequestMapping("/cthumbnails.mo")
	public void  cthummake(HttpServletRequest request,
			HttpServletResponse response,
			@RequestParam("cno") int cno,
			@RequestParam("c_img") String c_img
			) throws Exception {
		
		String path="c:\\jsv\\mvChart";
		String filePath =path+"\\"+cno+"\\"+c_img;
		File image = new File(filePath);
		OutputStream  out = response.getOutputStream();
		
		if( image.exists() ) {
			//썸네일이미지로 만들어서 다운로드 하겠다
			//원본 이미지에 대한  썸네일 이미지를 생성한 후   OutputStream객체에 할당한다
			Thumbnails.of(image).size(185, 260).outputFormat("png").toOutputStream(out);
		}//else {
		
		byte[] buffer = new byte[1024*8];
		out.write(buffer);
		out.close();
	}
	
	//무비차트 다운로드
	@RequestMapping("/cdownload.mo")
	public  void  cdownload(HttpServletRequest request,
		HttpServletResponse response,@RequestParam("cno") int cno,
		@RequestParam("c_img")String c_img) throws Exception {
		
		//1.파라미터받기 -  읽어들일 파일이 존재하는 폴더명 & 읽어들일 파일명
		System.out.println("c_img ="+c_img);
		
		String path="c:\\jsv\\mvChart";
		String filePath =path+"\\"+cno+"\\"+c_img;
		
		//2.비즈니스로직수행
		//filePath에 있는 파일의 정보를 읽어와   브라우저로 전송
		File image = new File(filePath);
		FileInputStream fin = new FileInputStream(image);
		OutputStream  out = response.getOutputStream();
		
		response.setHeader("Cache-Control", "no-cache");
		response.addHeader("Content-disposition", "attachment;fileName="+c_img);
		
		
		//파일 ->버퍼
		byte[] buffer = new byte[1024*8];
		while(true) {
			int count = fin.read(buffer); //버퍼에서 읽어들인 length
			if(count==-1) break; //버퍼에서 더 이상 읽어들일 내용이 없다면 -1을 리턴
			out.write(buffer, 0, count); //버퍼에서 읽어들인 길이만큼 브라우저로 출력
		}
		out.flush();
		fin.close();
		out.close();
	}
	
	//매거진 목록썸네일
	@RequestMapping("/mthumbnails.mo")
	public void  mthummake(HttpServletRequest request,
			HttpServletResponse response,
			@RequestParam("mno") int mno,
			@RequestParam("mFame") String mFame
			) throws Exception {
		
		String path = "c:\\jsv\\mgz";
		String filePath = path+"\\"+mno+"\\"+mFame;
		File image = new File(filePath);
		OutputStream  out = response.getOutputStream();
		
		if( image.exists() ) {
			//썸네일이미지로 만들어서 다운로드 하겠다
			//원본 이미지에 대한  썸네일 이미지를 생성한 후   OutputStream객체에 할당한다
			Thumbnails.of(image).size(326, 326).outputFormat("png").toOutputStream(out);
		}//else {
		
		byte[] buffer = new byte[1024*8];
		out.write(buffer);
		out.close();
	}
	
	//매거진 상세보기
	@RequestMapping("/mdownload.mo")
	public  void  mdownload(HttpServletRequest request,
		HttpServletResponse response,@RequestParam("mno") int mno,
		@RequestParam("mFame")String mFame) throws Exception {
		
		//1.파라미터받기 -  읽어들일 파일이 존재하는 폴더명 & 읽어들일 파일명
		
		String path = "c:\\jsv\\mgz";
		String filePath = path+"\\"+mno+"\\"+mFame;
		
		//2.비즈니스로직수행
		//filePath에 있는 파일의 정보를 읽어와   브라우저로 전송
		File image = new File(filePath);
		FileInputStream fin = new FileInputStream(image);
		OutputStream  out = response.getOutputStream();
		
		response.setHeader("Cache-Control", "no-cache");
		response.addHeader("Content-disposition", "attachment;fileName="+mFame);
		
		
		//파일 ->버퍼
		byte[] buffer = new byte[1024*8];
		while(true) {
			int count = fin.read(buffer); //버퍼에서 읽어들인 length
			if(count==-1) break; //버퍼에서 더 이상 읽어들일 내용이 없다면 -1을 리턴
			out.write(buffer, 0, count); //버퍼에서 읽어들인 길이만큼 브라우저로 출력
		}
		out.flush();
		fin.close();
		out.close();
	}
	
}
