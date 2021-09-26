package com.jsv.giftShop.dto;

import java.util.Date;

//상품관련 테이블
public class GoodsDTO {

	private int goods_no;					//상품번호
	private int goods_cate_no;				//카테고리 번호
	private String goods_name;				//상품명
	private String goods_comp;				//상품구성
	private int goods_price;				//상품가격
	private String goods_validity;			//유효기간
	private String goods_country;			//원산지
	private String goods_img;				//상품 이미지명
	private Date goods_regdate;				//상품 등록일
	private Date goods_update;				//상품 수정일
	
	public GoodsDTO() {}

	public int getGoods_no() {
		return goods_no;
	}

	public void setGoods_no(int goods_no) {
		this.goods_no = goods_no;
	}

	public int getGoods_cate_no() {
		return goods_cate_no;
	}

	public void setGoods_cate_no(int goods_cate_no) {
		this.goods_cate_no = goods_cate_no;
	}

	public String getGoods_name() {
		return goods_name;
	}

	public void setGoods_name(String goods_name) {
		this.goods_name = goods_name;
	}

	public String getGoods_comp() {
		return goods_comp;
	}

	public void setGoods_comp(String goods_comp) {
		this.goods_comp = goods_comp;
	}

	public int getGoods_price() {
		return goods_price;
	}

	public void setGoods_price(int goods_price) {
		this.goods_price = goods_price;
	}

	public String getGoods_validity() {
		return goods_validity;
	}

	public void setGoods_validity(String goods_validity) {
		this.goods_validity = goods_validity;
	}

	public String getGoods_country() {
		return goods_country;
	}

	public void setGoods_country(String goods_country) {
		this.goods_country = goods_country;
	}

	public String getGoods_img() {
		return goods_img;
	}

	public void setGoods_img(String goods_img) {
		this.goods_img = goods_img;
	}

	public Date getGoods_regdate() {
		return goods_regdate;
	}

	public void setGoods_regdate(Date goods_regdate) {
		this.goods_regdate = goods_regdate;
	}

	public Date getGoods_update() {
		return goods_update;
	}

	public void setGoods_update(Date goods_update) {
		this.goods_update = goods_update;
	}


	@Override
	public String toString() {
		return "GoodsDTO [goods_no=" + goods_no + ", goods_cate_no=" + goods_cate_no + ", goods_name=" + goods_name
				+ ", goods_comp=" + goods_comp + ", goods_price=" + goods_price + ", goods_validity=" + goods_validity
				+ ", goods_country=" + goods_country + ", goods_img=" + goods_img
			    + ", goods_regdate=" + goods_regdate + ", goods_update=" + goods_update+ "]";
	}

}
