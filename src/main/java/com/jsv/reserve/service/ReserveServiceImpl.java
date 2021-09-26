package com.jsv.reserve.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsv.reserve.dao.ReserveDAO;
import com.jsv.reserve.dto.MovieDTO;
import com.jsv.reserve.dto.ReserveDTO;
import com.jsv.reserve.dto.TheaterDTO;

@Service
public class ReserveServiceImpl implements ReserveService {

	@Autowired
	ReserveDAO reserveDAO;
	
	@Override
	public boolean Reserve(ReserveDTO dto) {
		
		return reserveDAO.Reserve(dto);
	}
	
	@Override
	public List<ReserveDTO> getReserve(ReserveDTO dto){
		List<ReserveDTO> list = new ArrayList<ReserveDTO>();
		list = reserveDAO.getReserveList(dto);
		
		return list;
	}
	
	@Override
	public List<ReserveDTO> getPayJoinTable(ReserveDTO dto){
		return reserveDAO.getPayJoinTable(dto);
	}
	
	@Override
	public List<TheaterDTO> getTheaterList(String str) throws Exception { 
		List<TheaterDTO> theaterList = reserveDAO.getTheaterList(str);
		System.out.println(theaterList);
		return theaterList;
	}
	
	@Override
	public List<MovieDTO> getMovieList() throws Exception{
		
		List<MovieDTO> movieList = reserveDAO.getMovieList();
		System.out.println(movieList);
		return movieList;
	}
}
