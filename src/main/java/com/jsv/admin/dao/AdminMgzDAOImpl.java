package com.jsv.admin.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.jsv.event.dto.EventDTO;
import com.jsv.mgz.dto.MagazineDTO;
import com.jsv.mgz.dto.MfileDTO;
@Repository("adminMgzdao")
public class AdminMgzDAOImpl implements AdminMgzDAO{

		@Autowired
		private SqlSession sqlsession;
		
		//매거진 게시물 내용 등록처리
		@Override
		public int newMgz(Map newMgzMap) throws DataAccessException {
			int result = sqlsession.insert("adminMgz.insertMgz", newMgzMap);
			System.out.println("내용등록처리"+result);
			int mno = (Integer)newMgzMap.get("mno");
			return mno;
		}

		//매거진 게시물 다중 이미지 등록처리
		@Override
		public void newMgzImg(List fileList) throws DataAccessException {			
			for(int i=0; i<fileList.size(); i++) {
				System.out.println("dao문제가"+fileList);
				MfileDTO mfiledto = (MfileDTO)fileList.get(i);
				int result=sqlsession.insert("adminMgz.insertMimg",mfiledto);			
				System.out.println("이미지등록처리"+result);
			}
		}

		
		//매거진 게시물 삭제
		@Override
		public void delMgz(int mno) throws DataAccessException {
			int result= sqlsession.delete("adminMgz.delMgz", mno);
			System.out.println("삭제 실행횟수"+result);
		}
		
		//매거진상세조회 -정보
		@Override
		public MagazineDTO getMgzDetail(int mno) throws DataAccessException {
			System.out.println("admin제품상세정보조회진입");
			return sqlsession.selectOne("adminMgz.getMgzDetail", mno);
		}

		//매거진 상세조회 -이미지
		@Override
		public List<MfileDTO> getMgzDImg(int mno) throws DataAccessException {
			return sqlsession.selectList("adminMgz.getMgzImg", mno);
		}

		//매거진 정보 업데이트 
		@Override
		public int updateMinfo(Map mgzMap) throws DataAccessException {
			int result =sqlsession.update("adminMgz.updateMinfo",  mgzMap);
			System.out.println("매거진 업데이트 실행 레코드"+result);
			return result;
		}

		
		//매거진 이미지 업데이트
		@Override
		public void updateMimg(MfileDTO mfiledto) throws DataAccessException {
				sqlsession.update("adminMgz.updateMimg", mfiledto);
		}


}	