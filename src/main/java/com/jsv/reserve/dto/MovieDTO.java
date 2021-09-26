package com.jsv.reserve.dto;

public class MovieDTO {
	private int movieNo;		//영화 번호
	private String title;		//제목
	private String star_score;	//평점
	private String exp;			//예매율
	private String genne;		//장르
	private String movieDate;	//개봉일
	private String director;	//감독
	private String act;			//출연
	private String runningTime;	//상영시간
	private String movieAge;	//관람등급
	private String summary;		//줄거리
	
	public MovieDTO() {
	}
	
	public MovieDTO(int movieNo, String title, String star_score, String exp, String genne, String movieDate,
			String director, String act, String runningTime, String movieAge, String summary) {
		this.movieNo = movieNo;
		this.title = title;
		this.star_score = star_score;
		this.exp = exp;
		this.genne = genne;
		this.movieDate = movieDate;
		this.director = director;
		this.act = act;
		this.runningTime = runningTime;
		this.movieAge = movieAge;
		this.summary = summary;
	}

	public int getMovieNo() {
		return movieNo;
	}

	public void setMovieNo(int movieNo) {
		this.movieNo = movieNo;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getStar_score() {
		return star_score;
	}

	public void setStar_score(String star_score) {
		this.star_score = star_score;
	}

	public String getExp() {
		return exp;
	}

	public void setExp(String exp) {
		this.exp = exp;
	}

	public String getGenne() {
		return genne;
	}

	public void setGenne(String genne) {
		this.genne = genne;
	}

	public String getMovieDate() {
		return movieDate;
	}

	public void setMovieDate(String movieDate) {
		this.movieDate = movieDate;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getAct() {
		return act;
	}

	public void setAct(String act) {
		this.act = act;
	}

	public String getRunningTime() {
		return runningTime;
	}

	public void setRunningTime(String runningTime) {
		this.runningTime = runningTime;
	}

	public String getMovieAge() {
		return movieAge;
	}

	public void setMovieAge(String movieAge) {
		this.movieAge = movieAge;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	@Override
	public String toString() {
		return "MovieDTO [movieNo=" + movieNo + ", title=" + title + ", star_score=" + star_score + ", exp=" + exp
				+ ", genne=" + genne + ", movieDate=" + movieDate + ", director=" + director + ", act=" + act
				+ ", runningTime=" + runningTime + ", movieAge=" + movieAge + ", summary=" + summary + "]";
	}
	
	
}
