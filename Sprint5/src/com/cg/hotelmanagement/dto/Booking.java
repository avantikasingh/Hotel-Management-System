package com.cg.hotelmanagement.dto;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Booking {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long bookingId;
	// @Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "YYYY-MM-DD")
	@Column(name = "check_in")
	private LocalDate checkIn;
	@DateTimeFormat(pattern = "YYYY-MM-DD")
	// @Temporal(TemporalType.DATE)
	@Column(name = "check_out")
	private LocalDate checkOut;
	@Column(name = "city_name")
	private String cityName;
	@Column(name = "delete_flag")
	private int deleteFlag = 0;

	@OneToOne(cascade = CascadeType.ALL)
	private Customer customer;

	public Booking() {
		// TODO Auto-generated constructor stub
	}

	public Booking(LocalDate checkIn, LocalDate checkOut, int deleteFlag) {
		super();
		this.bookingId = bookingId;
		this.checkIn = checkIn;
		this.checkOut = checkOut;

		this.deleteFlag = deleteFlag;
		this.customer = customer;
	}

	public Long getBookingId() {
		return bookingId;
	}

	public void setBookingId(Long bookingId) {
		this.bookingId = bookingId;
	}

	public LocalDate getCheckIn() {
		return checkIn;
	}

	public void setCheckIn(LocalDate checkIn) {
		this.checkIn = checkIn;
	}

	public LocalDate getCheckOut() {
		return checkOut;
	}

	public void setCheckOut(LocalDate checkOut) {
		this.checkOut = checkOut;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public int getDeleteFlag() {
		return deleteFlag;
	}

	public void setDeleteFlag(int deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "Booking [bookingId=" + bookingId + ", checkIn=" + checkIn + ", checkOut=" + checkOut + ", cityName="
				+ cityName + ", deleteFlag=" + deleteFlag + ", customer=" + customer + "]";
	}

}