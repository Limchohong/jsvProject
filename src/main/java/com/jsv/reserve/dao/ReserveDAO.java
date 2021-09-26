package com.jsv.reserve.dao;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.jsv.reserve.dto.MovieDTO;
import com.jsv.reserve.dto.ReserveDTO;
import com.jsv.reserve.dto.TheaterDTO;

public interface ReserveDAO {
	public boolean Reserve(ReserveDTO dto);
	public List<ReserveDTO> getReserveList(ReserveDTO dto);
	public List<ReserveDTO> getPayJoinTable(ReserveDTO dto);
	public List<TheaterDTO> getTheaterList(String location) throws DataAccessException;
	public List<MovieDTO> getMovieList() throws DataAccessException;
}
