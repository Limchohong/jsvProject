package com.jsv.reserve.service;

import java.util.List;
import java.util.Map;

import com.jsv.reserve.dto.MovieDTO;
import com.jsv.reserve.dto.ReserveDTO;
import com.jsv.reserve.dto.TheaterDTO;

public interface ReserveService {
	public boolean Reserve(ReserveDTO dto);
	public List<ReserveDTO> getReserve(ReserveDTO dto);
	public List<ReserveDTO> getPayJoinTable(ReserveDTO dto);
	public List<TheaterDTO> getTheaterList(String location) throws Exception;
	public List<MovieDTO> getMovieList() throws Exception;
}
