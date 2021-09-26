package com.jsv.mvChart.dto;

import java.sql.Date;

//무비차트의 DTO
public class MvChartDTO {

	private int cno;
	private String c_img;
	private String ctitle;
	private double crate;
	private String cdir;
	private String cactor;
	private String cgenre;
	private String cinfo;
	private String c_content;
	private Date copen;
	
	//검색
	private String searchOption;
	private String keyword;
	
	
	
	
	public Date getCopen() {
		return copen;
	}
	public void setCopen(Date copen) {
		this.copen = copen;
	}
	public String getCactor() {
		return cactor;
	}
	public void setCactor(String cactor) {
		this.cactor = cactor;
	}
	public String getCtitle() {
		return ctitle;
	}
	public void setCtitle(String ctitle) {
		this.ctitle = ctitle;
	}
	public int getCno() {
		return cno;
	}
	public void setCno(int cno) {
		this.cno = cno;
	}
	public String getC_img() {
		return c_img;
	}
	public void setC_img(String c_img) {
		this.c_img = c_img;
	}
	public double getCrate() {
		return crate;
	}
	public void setCrate(double crate) {
		this.crate = crate;
	}
	public String getCdir() {
		return cdir;
	}
	public void setCdir(String cdir) {
		this.cdir = cdir;
	}
	public String getCgenre() {
		return cgenre;
	}
	public void setCgenre(String cgenre) {
		this.cgenre = cgenre;
	}
	public String getCinfo() {
		return cinfo;
	}
	public void setCinfo(String cinfo) {
		this.cinfo = cinfo;
	}
	public String getC_content() {
		return c_content;
	}
	public void setC_content(String c_content) {
		this.c_content = c_content;
	}
	
	
	
	public String getSearchOption() {
		return searchOption;
	}
	public void setSearchOption(String searchOption) {
		this.searchOption = searchOption;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	
	@Override
	public String toString() {
		return "MvChartDTO [cno=" + cno + ", c_img=" + c_img + ", ctitle=" + ctitle + ", crate=" + crate + ", cdir="
				+ cdir + ", cactor=" + cactor + ", cgenre=" + cgenre + ", cinfo=" + cinfo + ", c_content=" + c_content
				+ ", copen=" + copen + ", searchOption=" + searchOption + ", keyword=" + keyword + "]";
	}
	
	
	
}
