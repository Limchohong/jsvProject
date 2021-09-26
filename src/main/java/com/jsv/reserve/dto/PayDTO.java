package com.jsv.reserve.dto;

import java.io.Serializable;
import java.util.Date;

public class PayDTO{
	private String id;
	private int reserveSequence;
	private String payDate;
	private String payMoney;
	
	public PayDTO() {
	}

	public PayDTO(String id, int reserveSequence, String payDate, String payMoney) {
		this.id = id;
		this.reserveSequence = reserveSequence;
		this.payDate = payDate;
		this.payMoney = payMoney;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getReserveSequence() {
		return reserveSequence;
	}

	public void setReserveSequence(int reserveSequence) {
		this.reserveSequence = reserveSequence;
	}

	public String getPayDate() {
		return payDate;
	}

	public void setPayDate(String payDate) {
		this.payDate = payDate;
	}

	public String getPayMoney() {
		return payMoney;
	}

	public void setPayMoney(String payMoney) {
		this.payMoney = payMoney;
	}

	@Override
	public String toString() {
		return "PayDTO [id=" + id + ", reserveSequence=" + reserveSequence + ", payDate=" + payDate + ", payMoney="
				+ payMoney + "]";
	}
	
}
