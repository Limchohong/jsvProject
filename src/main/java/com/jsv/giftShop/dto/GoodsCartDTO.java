package com.jsv.giftShop.dto;

//장바구니 테이블
public class GoodsCartDTO {

	private int goods_cart_no;		//장바구니 번호
	private int u_no;				//회원번호
	private int goods_no;			//상품번호
	private int goods_cart_qty;		//장바구니 수량
	
	//=========================================
	private String goods_name;		//상품명
	private String goods_comp;		//상품구성
	private int goods_price;		//상품가격
	private String goods_img;		//상품 이미지명
	
	public GoodsCartDTO(){};
	
	public GoodsCartDTO(int u_no, int goods_no, int goods_cart_qty) {
		this.u_no = u_no;
		this.goods_no = goods_no;
		this.goods_cart_qty = goods_cart_qty;
	}

	public GoodsCartDTO(int goods_cart_no, int u_no, int goods_no, int goods_cart_qty, String goods_name,
			String goods_comp, int goods_price, String goods_img) {
		this.goods_cart_no = goods_cart_no;
		this.u_no = u_no;
		this.goods_no = goods_no;
		this.goods_cart_qty = goods_cart_qty;
		this.goods_name = goods_name;
		this.goods_comp = goods_comp;
		this.goods_price = goods_price;
		this.goods_img = goods_img;
	}

	public int getGoods_cart_no() {
		return goods_cart_no;
	}

	public void setGoods_cart_no(int goods_cart_no) {
		this.goods_cart_no = goods_cart_no;
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

	public int getGoods_cart_qty() {
		return goods_cart_qty;
	}

	public void setGoods_cart_qty(int goods_cart_qty) {
		this.goods_cart_qty = goods_cart_qty;
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

	public String getGoods_img() {
		return goods_img;
	}

	public void setGoods_img(String goods_img) {
		this.goods_img = goods_img;
	}

	@Override
	public String toString() {
		return "CartDTO [goods_cart_no=" + goods_cart_no + ", u_no=" + u_no + ", goods_no=" + goods_no
				+ ", goods_cart_qty=" + goods_cart_qty + ", goods_name=" + goods_name + ", goods_comp=" + goods_comp
				+ ", goods_price=" + goods_price + ", goods_img=" + goods_img + "]";
	}
	
	
	
	
	
	
}
