package com.jsv.member.dto;

import java.util.Date;

//회원테이블 관련
public class MemberDTO {
	
	private int u_no;					//회원번호
	private String u_id;				//회원id	
	private String u_password;			//비밀번호
	private String u_name;				//회원명
	private String u_nic;				//회원명
	private String u_phone;				//휴대폰번호
	private String u_email;				//이메일
	private String is_connection;		//탈퇴 여부
	private Date u_join_date;			//가입일
	

	public MemberDTO() {}
	
	public MemberDTO(int u_no, String u_id, String u_password, String u_name, String u_nic, String u_phone,
			String u_email, String is_connection, Date u_join_date) {
		this.u_no = u_no;
		this.u_id = u_id;
		this.u_password = u_password;
		this.u_name = u_name;
		this.u_nic = u_nic;
		this.u_phone = u_phone;
		this.u_email = u_email;
		this.is_connection = is_connection;
		this.u_join_date = u_join_date;
	}
	
	public int getU_no() {
		return u_no;
	}

	public void setU_no(int u_no) {
		this.u_no = u_no;
	}

	public String getU_id() {
		return u_id;
	}

	public void setU_id(String u_id) {
		this.u_id = u_id;
	}

	public String getU_password() {
		return u_password;
	}

	public void setU_password(String u_password) {
		this.u_password = u_password;
	}

	public String getU_name() {
		return u_name;
	}

	public void setU_name(String u_name) {
		this.u_name = u_name;
	}

	public String getU_nic() {
		return u_nic;
	}

	public void setU_nic(String u_nic) {
		this.u_nic = u_nic;
	}

	public String getU_phone() {
		return u_phone;
	}

	public void setU_phone(String u_phone) {
		this.u_phone = u_phone;
	}

	public String getU_email() {
		return u_email;
	}

	public void setU_email(String u_email) {
		this.u_email = u_email;
	}

	public String getIs_connection() {
		return is_connection;
	}

	public void setIs_connection(String is_connection) {
		this.is_connection = is_connection;
	}

	public Date getU_join_date() {
		return u_join_date;
	}

	public void setU_join_date(Date u_join_date) {
		this.u_join_date = u_join_date;
	}

	@Override
	public String toString() {
		return "MemberDTO [u_no=" + u_no + ", u_id=" + u_id + ", u_password=" + u_password + ", u_name=" + u_name
				+ ", u_nic=" + u_nic + ", u_phone=" + u_phone + ", u_email=" + u_email + ", is_connection="
				+ is_connection + ", u_join_date=" + u_join_date + "]";
	}

	
}
