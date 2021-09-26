package com.jsv.reserve.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsv.reserve.dto.PayDTO;

@Service
public class PayServiceImpl implements PayService {

	@Autowired
	com.jsv.reserve.dao.PayDAO PayDAO;
	
	@Override
	public boolean payTicket(PayDTO dto) {
		return PayDAO.payTicket(dto);
	}
}
