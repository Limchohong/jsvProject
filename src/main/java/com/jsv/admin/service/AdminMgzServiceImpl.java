package com.jsv.admin.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsv.admin.dao.AdminMgzDAO;
import com.jsv.mgz.dto.MagazineDTO;
import com.jsv.mgz.dto.MfileDTO;
@Service("adminMgzService")
public class AdminMgzServiceImpl implements AdminMgzService {

	@Autowired
	private AdminMgzDAO adminmgzdao;
	
	//관리자 매거진 게시물 등록 map으로 내용 +이미지 묶음
	@Override
	public int newMgz(Map newMgzMap) throws Exception {
		int mno = adminmgzdao.newMgz(newMgzMap); //등록성공한 mno 가져오기
		List<MfileDTO> imageFileList = (ArrayList)newMgzMap.get("imageFileList");
		System.out.println("imageFileList"+imageFileList);
		for(MfileDTO mfiledto : imageFileList) {
			mfiledto.setMno(mno);
		}//for
		adminmgzdao.newMgzImg(imageFileList);
		return mno;
	}

	//관리자 매거진 게시물 삭제
	@Override
	public void delMgz(int mno) throws Exception {
			adminmgzdao.delMgz(mno);
	}

	//관리자-> 매거진 정보들
	@Override
	public Map getMgzDetail(int mno) throws Exception {
		//map 선언
		//상세정보를 넣기위한 맵생성
		Map<String,Object> mgzMap = new HashMap<String,Object>(); 
		MagazineDTO magazindto =adminmgzdao.getMgzDetail(mno);
		mgzMap.put("magazindto", magazindto);//매거진정보
		
		List<MfileDTO> mfiledto = adminmgzdao.getMgzDImg(mno);
		mgzMap.put("mfiledto", mfiledto);	//상세이미지
		
		return mgzMap;	//map으로 묶어서 보낸다
	}

	//매거진 수정처리 -정보들
	@Override
	public int updateMinfo(Map mgzMap) throws Exception {
		 return adminmgzdao.updateMinfo(mgzMap);
	}

	
	//매거진 수정처리 이미지수정
	@Override
	public void updateMimg(MfileDTO mfiledto) throws Exception {
			adminmgzdao.updateMimg(mfiledto);
	}
}