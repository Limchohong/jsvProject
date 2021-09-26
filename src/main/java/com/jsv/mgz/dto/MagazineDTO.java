package com.jsv.mgz.dto;

import java.sql.Date;

//매거진 dto
public class MagazineDTO {

		private int mno;	//M번호
		private String mname;	//M이름
		private String mtitle;	//M섭타이블
		private String mcontent;	//M내용
		private String mdir;	//M감동
		private String mactor;	//M배우
		private String mgenre;	//M장르
		private String minfo;	//MINFO
		private Date mopen;		//개봉일
		private Date mregDate;	//글등록일
		private String mwriter;	//글쓴이
		
		private String mFame;
		private String mFtype;
		//매서드
		public int getMno() {
			return mno;
		}
		public void setMno(int mno) {
			this.mno = mno;
		}
		public String getMname() {
			return mname;
		}
		public void setMname(String mname) {
			this.mname = mname;
		}
		public String getMtitle() {
			return mtitle;
		}
		public void setMtitle(String mtitle) {
			this.mtitle = mtitle;
		}
		public String getMcontent() {
			return mcontent;
		}
		public void setMcontent(String mcontent) {
			this.mcontent = mcontent;
		}
		public String getMdir() {
			return mdir;
		}
		public void setMdir(String mdir) {
			this.mdir = mdir;
		}
		public String getMactor() {
			return mactor;
		}
		public void setMactor(String mactor) {
			this.mactor = mactor;
		}
		public String getMgenre() {
			return mgenre;
		}
		public void setMgenre(String mgenre) {
			this.mgenre = mgenre;
		}
		public String getMinfo() {
			return minfo;
		}
		public void setMinfo(String minfo) {
			this.minfo = minfo;
		}
		public Date getMopen() {
			return mopen;
		}
		public void setMopen(Date mopen) {
			this.mopen = mopen;
		}
		public Date getMregDate() {
			return mregDate;
		}
		public void setMregDate(Date mregDate) {
			this.mregDate = mregDate;
		}
		public String getMwriter() {
			return mwriter;
		}
		public void setMwriter(String mwriter) {
			this.mwriter = mwriter;
		}
		
		
		public String getmFame() {
			return mFame;
		}
		public void setmFame(String mFame) {
			this.mFame = mFame;
		}
		public String getmFtype() {
			return mFtype;
		}
		public void setmFtype(String mFtype) {
			this.mFtype = mFtype;
		}
		
		
		@Override
		public String toString() {
			return "MagazineDTO [mno=" + mno + ", mname=" + mname + ", mtitle=" + mtitle + ", mcontent=" + mcontent
					+ ", mdir=" + mdir + ", mactor=" + mactor + ", mgenre=" + mgenre + ", minfo=" + minfo + ", mopen="
					+ mopen + ", mregDate=" + mregDate + ", mwriter=" + mwriter + ", mFame=" + mFame + ", mFtype="
					+ mFtype + "]";
		}
		
		
		
	
		
		
		
		
}
