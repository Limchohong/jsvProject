package com.jsv.mgz.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsv.mgz.dao.MagazineDAO;
import com.jsv.mgz.dto.MagazineDTO;
import com.jsv.mgz.dto.MfileDTO;
@Service("magazineservice")
public class MagazineServiceImpl implements MagazineService {

	@Autowired
	private MagazineDAO magazinedao;
	
	//매거진 목록보기 
	@Override
	public List<MagazineDTO> getMList() throws Exception {
		List<MagazineDTO> mList = magazinedao.getMList();
		return mList;
	}

	//매거진 상세조회
	@Override
	public Map<String,Object> getMgzDetail(int mno) throws Exception {
		//상세정보를 넣기위한 맵생성
		Map<String,Object> mgzMap = new HashMap<String,Object>(); 
		MagazineDTO magazindto = magazinedao.getMgzDetail(mno);
		mgzMap.put("magazindto", magazindto);//매거진정보
		
		List<MfileDTO> mfiledto = magazinedao.getMgzDImg(mno);
		mgzMap.put("mfiledto", mfiledto);	//상세이미지
		
		return mgzMap;	//map으로 묶어서 보낸다
	}

}
