package com.jsv.reserve.dto;

import java.io.Serializable;
import java.util.Date;

public class ReserveDTO{
	private String id;
	private int reserveSequence;
	private String title;
	private String runningTime;
	private String movieDate;
	private String reserveDate;
	private int ticketNumber;
	private String selectedSeat;
	private String selectedTheater;
	private String movieAge;
	
	//private PayDTO payDTO;
	
	public ReserveDTO() {
	}
	
	public ReserveDTO(String id, String title, String runningTime,
	         int ticketNumber, String selectedSeat, String selectedTheater, String movieAge) {
	      this.id = id;
	      this.title = title;
	      this.runningTime = runningTime;
	      this.ticketNumber = ticketNumber;
	      this.selectedSeat = selectedSeat;
	      this.selectedTheater = selectedTheater;
	      this.movieAge = movieAge;
	   }
	
	public ReserveDTO(String id, String title, String runningTime, String movieDate,
			int ticketNumber, String selectedSeat, String selectedTheater, String movieAge) {
		this.id = id;
		this.title = title;
		this.runningTime = runningTime;
		this.movieDate = movieDate;
		this.ticketNumber = ticketNumber;
		this.selectedSeat = selectedSeat;
		this.selectedTheater = selectedTheater;
		this.movieAge = movieAge;
	}

	public ReserveDTO(String id, int reserveSequence, String title, String runningTime, String movieDate,
			int ticketNumber, String selectedSeat, String selectedTheater, String movieAge) {
		this.id = id;
		this.reserveSequence = reserveSequence;
		this.title = title;
		this.runningTime = runningTime;
		this.movieDate = movieDate;
		this.ticketNumber = ticketNumber;
		this.selectedSeat = selectedSeat;
		this.selectedTheater = selectedTheater;
		this.movieAge = movieAge;
	}

	public ReserveDTO(String id, int reserveSequence, String title, String runningTime, String movieDate,
			String reserveDate, int ticketNumber, String selectedSeat, String selectedTheater, String movieAge) {
		this.id = id;
		this.reserveSequence = reserveSequence;
		this.title = title;
		this.runningTime = runningTime;
		this.movieDate = movieDate;
		this.reserveDate = reserveDate;
		this.ticketNumber = ticketNumber;
		this.selectedSeat = selectedSeat;
		this.selectedTheater = selectedTheater;
		this.movieAge = movieAge;
	}

	/*public ReserveDTO(String id, int reserveSequence, String title, String runningTime, String movieDate,
			String reserveDate, int ticketNumber, String selectedSeat, String selectedTheater, String movieAge,
			PayDTO payDTO) {
		this.id = id;
		this.reserveSequence = reserveSequence;
		this.title = title;
		this.runningTime = runningTime;
		this.movieDate = movieDate;
		this.reserveDate = reserveDate;
		this.ticketNumber = ticketNumber;
		this.selectedSeat = selectedSeat;
		this.selectedTheater = selectedTheater;
		this.movieAge = movieAge;
		this.payDTO = payDTO;
	}*/

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getReserveSequence() {
		return reserveSequence;
	}

	public void setReserveSequence(int reserveSequence) {
		this.reserveSequence = reserveSequence;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getRunningTime() {
		return runningTime;
	}

	public void setRunningTime(String runningTime) {
		this.runningTime = runningTime;
	}

	public String getMovieDate() {
		return movieDate;
	}

	public void setMovieDate(String movieDate) {
		this.movieDate = movieDate;
	}

	public String getReserveDate() {
		return reserveDate;
	}

	public void setReserveDate(String reserveDate) {
		this.reserveDate = reserveDate;
	}

	public int getTicketNumber() {
		return ticketNumber;
	}

	public void setTicketNumber(int ticketNumber) {
		this.ticketNumber = ticketNumber;
	}

	public String getSelectedSeat() {
		return selectedSeat;
	}

	public void setSelectedSeat(String selectedSeat) {
		this.selectedSeat = selectedSeat;
	}

	public String getSelectedTheater() {
		return selectedTheater;
	}

	public void setSelectedTheater(String selectedTheater) {
		this.selectedTheater = selectedTheater;
	}

	public String getMovieAge() {
		return movieAge;
	}

	public void setMovieAge(String movieAge) {
		this.movieAge = movieAge;
	}

	/*
	public PayDTO getPayDTO() {
		return payDTO;
	}

	public void setPayDTO(PayDTO payDTO) {
		this.payDTO = payDTO;
	}

	@Override
	public String toString() {
		return "ReserveDTO [id=" + id + ", reserveSequence=" + reserveSequence + ", title=" + title + ", runningTime="
				+ runningTime + ", movieDate=" + movieDate + ", reserveDate=" + reserveDate + ", ticketNumber="
				+ ticketNumber + ", selectedSeat=" + selectedSeat + ", selectedTheater=" + selectedTheater
				+ ", movieAge=" + movieAge + ", payDTO=" + payDTO + "]";
	}*/
	
	@Override
	public String toString() {
		return "ReserveDTO [id=" + id + ", reserveSequence=" + reserveSequence + ", title=" + title + ", runningTime="
				+ runningTime + ", movieDate=" + movieDate + ", reserveDate=" + reserveDate + ", ticketNumber="
				+ ticketNumber + ", selectedSeat=" + selectedSeat + ", selectedTheater=" + selectedTheater
				+ ", movieAge=" + movieAge + "]";
	}

}
