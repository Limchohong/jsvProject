package com.jsv.mgz.dto;


//매거진 다중이미지 처리를 위한 dto
public class MfileDTO {

		//필드
		private int mFno;	//이미지번호
		private int mno;	//매거진번호
		private String mFtype;	//이미지타입
		private String mFame;	//이미지 이름
	
		
		public int getmFno() {
			return mFno;
		}
		public void setmFno(int mFno) {
			this.mFno = mFno;
		}
		public int getMno() {
			return mno;
		}
		public void setMno(int mno) {
			this.mno = mno;
		}
		public String getmFtype() {
			return mFtype;
		}
		public void setmFtype(String mFtype) {
			this.mFtype = mFtype;
		}
		public String getmFame() {
			return mFame;
		}
		public void setmFame(String mFame) {
			this.mFame = mFame;
		}
		
		@Override
		public String toString() {
			return "MfileDTO [mFno=" + mFno + ", mno=" + mno + ", mFtype=" + mFtype + ", mFame=" + mFame + 
					 "]";
		}
		
		
		
		
		
}
