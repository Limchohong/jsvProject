package com.jsv.giftShop.dto;

//상품 카테고리 테이블
public class GoodsCateDTO {

	private int goods_cate_no;		//카테고리 번호
	private String goods_cate_name;	//카테고리명
	
	
	public GoodsCateDTO() {}
	
	public GoodsCateDTO(int goods_cate_no, String goods_cate_name) {
		this.goods_cate_no = goods_cate_no;
		this.goods_cate_name = goods_cate_name;
	}
	
	public int getGoods_cate_no() {
		return goods_cate_no;
	}
	public void setGoods_cate_no(int goods_cate_no) {
		this.goods_cate_no = goods_cate_no;
	}
	public String getGoods_cate_name() {
		return goods_cate_name;
	}
	public void setGoods_cate_name(String goods_cate_name) {
		this.goods_cate_name = goods_cate_name;
	}

	@Override
	public String toString() {
		return "GoodsCategoryDTO [goods_cate_no=" + goods_cate_no + ", goods_cate_name="
				+ goods_cate_name + "]";
	}
}
