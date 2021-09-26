package com.jsv.reserve.dao;

import com.jsv.reserve.dto.PayDTO;

public interface PayDAO {
	public boolean payTicket(PayDTO dto);
}
