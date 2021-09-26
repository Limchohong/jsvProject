package com.jsv.giftShop.dto;

import java.util.Date;

//주문상세 테이블
public class GoodsOrderDetailDTO {

	private int goods_order_detail_no;		//주문상세 번호
	private String goods_order_no;			//주문번호
	private int u_no;						//회원번호
	private int goods_no;					//상품번호
	private int goods_price;				//상품가격
	private int goods_order_qty;			//구매수량
	private String goods_order_method;		//구매방법
	private String goods_giftcone_code;		//기프티콘 번호
	private String goods_giftcone_use;		//기프티콘 사용여부
	private Date goods_giftcone_uesdate;	//기프티콘 사용일
	
	
	public GoodsOrderDetailDTO() {}
	
	
	public GoodsOrderDetailDTO(String goods_order_no, int u_no, int goods_no,
			int goods_price, int goods_order_qty, String goods_order_method, String goods_giftcone_code) {
		this.goods_order_no = goods_order_no;
		this.u_no = u_no;
		this.goods_no = goods_no;
		this.goods_price = goods_price;
		this.goods_order_qty = goods_order_qty;
		this.goods_order_method = goods_order_method;
		this.goods_giftcone_code = goods_giftcone_code;
	}
	

	public GoodsOrderDetailDTO(int goods_order_detail_no, String goods_order_no, int u_no, int goods_no,
			int goods_price, int goods_order_qty, String goods_order_method, String goods_giftcone_code,
			String goods_giftcone_use, Date goods_giftcone_uesdate) {
		this.goods_order_detail_no = goods_order_detail_no;
		this.goods_order_no = goods_order_no;
		this.u_no = u_no;
		this.goods_no = goods_no;
		this.goods_price = goods_price;
		this.goods_order_qty = goods_order_qty;
		this.goods_order_method = goods_order_method;
		this.goods_giftcone_code = goods_giftcone_code;
		this.goods_giftcone_use = goods_giftcone_use;
		this.goods_giftcone_uesdate = goods_giftcone_uesdate;
	}


	public int getGoods_order_detail_no() {
		return goods_order_detail_no;
	}


	public void setGoods_order_detail_no(int goods_order_detail_no) {
		this.goods_order_detail_no = goods_order_detail_no;
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


	public void setU_no(int u_no) {
		this.u_no = u_no;
	}


	public int getGoods_no() {
		return goods_no;
	}


	public void setGoods_no(int goods_no) {
		this.goods_no = goods_no;
	}


	public int getGoods_price() {
		return goods_price;
	}


	public void setGoods_price(int goods_price) {
		this.goods_price = goods_price;
	}


	public int getGoods_order_qty() {
		return goods_order_qty;
	}


	public void setGoods_order_qty(int goods_order_qty) {
		this.goods_order_qty = goods_order_qty;
	}


	public String getGoods_order_method() {
		return goods_order_method;
	}


	public void setGoods_order_method(String goods_order_method) {
		this.goods_order_method = goods_order_method;
	}


	public String getGoods_giftcone_code() {
		return goods_giftcone_code;
	}


	public void setGoods_giftcone_code(String goods_giftcone_code) {
		this.goods_giftcone_code = goods_giftcone_code;
	}


	public String getGoods_giftcone_use() {
		return goods_giftcone_use;
	}


	public void setGoods_giftcone_use(String goods_giftcone_use) {
		this.goods_giftcone_use = goods_giftcone_use;
	}


	public Date getGoods_giftcone_uesdate() {
		return goods_giftcone_uesdate;
	}


	public void setGoods_giftcone_uesdate(Date goods_giftcone_uesdate) {
		this.goods_giftcone_uesdate = goods_giftcone_uesdate;
	}


	@Override
	public String toString() {
		return "GoodsOrderDetailDTO [goods_order_detail_no=" + goods_order_detail_no + ", goods_order_no="
				+ goods_order_no + ", u_no=" + u_no + ", goods_no=" + goods_no + ", goods_price=" + goods_price
				+ ", goods_order_qty=" + goods_order_qty + ", goods_order_method=" + goods_order_method
				+ ", goods_giftcone_code=" + goods_giftcone_code + ", goods_giftcone_use=" + goods_giftcone_use
				+ ", goods_giftcone_uesdate=" + goods_giftcone_uesdate + "]";
	}


	
	
	
	
	
}
