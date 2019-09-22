package com.cg.hotelmanagement.dto;


import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Booking {
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private Long bookingId=Long.valueOf(999);
	@Temporal(TemporalType.DATE)
	@Column(name="check_in")
	private Date checkIn;
	@Temporal(TemporalType.DATE)
	@Column(name="check_out")
	private Date checkOut;
	@OneToOne(cascade = CascadeType.ALL)
	private User user;
	public Booking(Long bookingId, Date checkIn, Date checkOut) {
		super();
		this.bookingId = bookingId;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}
	public Booking() {
		super();
	}
	public Long getBookingId() {
		return bookingId;
	}
	public void setBookingId(Long bookingId) {
		this.bookingId = bookingId;
	}
	public Date getCheckIn() {
		return checkIn;
	}
	public void setCheckIn(Date checkIn) {
		this.checkIn = checkIn;
	}
	public Date getCheckOut() {
		return checkOut;
	}
	public void setCheckOut(Date checkOut) {
		this.checkOut = checkOut;
	}
	@Override
	public String toString() {
		return "Booking [bookingId=" + bookingId + ", checkIn=" + checkIn + ", checkOut=" + checkOut + "]";
	}

	

}