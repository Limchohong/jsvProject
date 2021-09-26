package com.jsv.event.dto;

public class EventDTO {

	//필드
	private int eno;
	private String ename;	//이벤트이름
	private String estart; //이벤트시작끝
	private String eEnd;  //이벤트 끝
	private String e_img; //파일이름
	
	
	//메서드
	
	public int getEno() {
		return eno;
	}
	public void setEno(int eno) {
		this.eno = eno;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getEstart() {
		return estart;
	}
	public void setEstart(String estart) {
		this.estart = estart;
	}
	public String geteEnd() {
		return eEnd;
	}
	public void seteEnd(String eEnd) {
		this.eEnd = eEnd;
	}
	public String getE_img() {
		return e_img;
	}
	public void setE_img(String e_img) {
		this.e_img = e_img;
	}
	
	
	@Override
	public String toString() {
		return "EventDTO [eno=" + eno + ", ename=" + ename + ", estart=" + estart + ", eEnd=" + eEnd + ", e_img="
				+ e_img + "]";
	}



	
	
}
