package com.jsv.reserve.dto;

public class TheaterDTO {
	int theaterNo;
	String theaterPlace;
	String theaterName;

	public TheaterDTO() {
	}

	public TheaterDTO(int theaterNo, String theaterPlace, String theaterName) {
		this.theaterNo = theaterNo;
		this.theaterPlace = theaterPlace;
		this.theaterName = theaterName;
	}

	public int getTheaterNo() {
		return theaterNo;
	}

	public void setTheaterNo(int theaterNo) {
		this.theaterNo = theaterNo;
	}

	public String getTheaterPlace() {
		return theaterPlace;
	}

	public void setTheaterPlace(String theaterPlace) {
		this.theaterPlace = theaterPlace;
	}

	public String getTheaterName() {
		return theaterName;
	}

	public void setTheaterName(String theaterName) {
		this.theaterName = theaterName;
	}

	@Override
	public String toString() {
		return "TheaterDTO [theaterNo=" + theaterNo + ", theaterPlace=" + theaterPlace + ", theaterName=" + theaterName
				+ "]";
	}

}