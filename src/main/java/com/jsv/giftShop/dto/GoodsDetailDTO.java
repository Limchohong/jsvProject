package com.jsv.giftShop.dto;

//상품 상세설명 테이블
public class GoodsDetailDTO {

	private int goods_detail_no; 		//상세내용 번호
	private int goods_no;				//상품 번호
	private String goods_detail_desc1; 	//상품상세설명
	private String goods_detail_desc2;	//이용안내
	private String goods_detail_desc3;  //취소&환불안내
	private String goods_detail_desc4;	//미성년자 권리보호 안내
	private String goods_detail_desc5;	//분쟁 해결 안내
	
	public GoodsDetailDTO() {}
	
	public GoodsDetailDTO(int goods_detail_no, int goods_no, String goods_detail_desc1, String goods_detail_desc2,
			String goods_detail_desc3, String goods_detail_desc4, String goods_detail_desc5) {
		this.goods_detail_no = goods_detail_no;
		this.goods_no = goods_no;
		this.goods_detail_desc1 = goods_detail_desc1;
		this.goods_detail_desc2 = goods_detail_desc2;
		this.goods_detail_desc3 = goods_detail_desc3;
		this.goods_detail_desc4 = goods_detail_desc4;
		this.goods_detail_desc5 = goods_detail_desc5;
	}

	public int getGoods_detail_no() {
		return goods_detail_no;
	}

	public void setGoods_detail_no(int goods_detail_no) {
		this.goods_detail_no = goods_detail_no;
	}

	public int getGoods_no() {
		return goods_no;
	}

	public void setGoods_no(int goods_no) {
		this.goods_no = goods_no;
	}

	public String getGoods_detail_desc1() {
		return goods_detail_desc1;
	}

	public void setGoods_detail_desc1(String goods_detail_desc1) {
		this.goods_detail_desc1 = goods_detail_desc1;
	}

	public String getGoods_detail_desc2() {
		return goods_detail_desc2;
	}

	public void setGoods_detail_desc2(String goods_detail_desc2) {
		this.goods_detail_desc2 = goods_detail_desc2;
	}

	public String getGoods_detail_desc3() {
		return goods_detail_desc3;
	}

	public void setGoods_detail_desc3(String goods_detail_desc3) {
		this.goods_detail_desc3 = goods_detail_desc3;
	}

	public String getGoods_detail_desc4() {
		return goods_detail_desc4;
	}

	public void setGoods_detail_desc4(String goods_detail_desc4) {
		this.goods_detail_desc4 = goods_detail_desc4;
	}

	public String getGoods_detail_desc5() {
		return goods_detail_desc5;
	}

	public void setGoods_detail_desc5(String goods_detail_desc5) {
		this.goods_detail_desc5 = goods_detail_desc5;
	}

	@Override
	public String toString() {
		return "GoodsDetail [goods_detail_no=" + goods_detail_no + ", goods_no=" + goods_no + ", goods_detail_desc1="
				+ goods_detail_desc1 + ", goods_detail_desc2=" + goods_detail_desc2 + ", goods_detail_desc3="
				+ goods_detail_desc3 + ", goods_detail_desc4=" + goods_detail_desc4 + ", goods_detail_desc5="
				+ goods_detail_desc5 + "]";
	}
	
	
	
}
