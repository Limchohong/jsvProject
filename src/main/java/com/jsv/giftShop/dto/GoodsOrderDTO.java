package com.jsv.giftShop.dto;

import java.util.Date;

//주문테이블
public class GoodsOrderDTO {

	
	private String goods_order_no; 	//주문번호
	private int u_no;				//회원번호
	private String goods_order_ph;		//기프티콘 수신 번호 
	private int goods_order_price;	//구매가격
	private Date goods_order_date;	//구매일
	
	
	public GoodsOrderDTO() {}

	public GoodsOrderDTO(String goods_order_no, int u_no, String goods_order_ph, int goods_order_price) {
		this.goods_order_no = goods_order_no;
		this.u_no = u_no;
		this.goods_order_ph = goods_order_ph;
		this.goods_order_price = goods_order_price;
	}
	

	public GoodsOrderDTO(String goods_order_no, int u_no, String goods_order_ph, int goods_order_price,
			Date goods_order_date) {
		this.goods_order_no = goods_order_no;
		this.u_no = u_no;
		this.goods_order_ph = goods_order_ph;
		this.goods_order_price = goods_order_price;
		this.goods_order_date = goods_order_date;
	}


	public String getGoods_order_no() {
		return goods_order_no;
	}


	public void setGoods_order_no(String goods_order_no) {
		this.goods_order_no = goods_order_no;
	}


	public int getU_no() {
		return u_no;
	}


	public void setU_no(int userno) {
		this.u_no = userno;
	}


	public String getGoods_order_ph() {
		return goods_order_ph;
	}


	public void setGoods_order_ph(String goods_order_ph) {
		this.goods_order_ph = goods_order_ph;
	}


	public int getGoods_order_price() {
		return goods_order_price;
	}


	public void setGoods_order_price(int goods_order_price) {
		this.goods_order_price = goods_order_price;
	}


	public Date getGoods_order_date() {
		return goods_order_date;
	}


	public void setGoods_order_date(Date goods_order_date) {
		this.goods_order_date = goods_order_date;
	}


	@Override
	public String toString() {
		return "GoodsOrderDTO [goods_order_no=" + goods_order_no + ", u_no=" + u_no + ", goods_order_ph="
				+ goods_order_ph + ", goods_order_price=" + goods_order_price + ", goods_order_date=" + goods_order_date
				+ "]";
	}
	
	
	
	
	

	
	
	
	
}
