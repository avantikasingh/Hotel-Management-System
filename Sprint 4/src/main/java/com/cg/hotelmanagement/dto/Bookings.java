package com.cg.hotelmanagement.dto;

import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Embeddable;

@Embeddable
public class Bookings {
	
	private Long bookingId;
	private Date checkin;
	private Date checkout;
	
	public Bookings()
	{
		
	}
	
	public Bookings(Long bookingId, Date checkin, Date checkout) {
		super();
		this.bookingId = bookingId;
		this.checkin = checkin;
		this.checkout = checkout;
	}

	public Long getBookingId() {
		return bookingId;
	}

	public void setBookingId(Long bookingId) {
		this.bookingId = bookingId;
	}

	public Date getCheckin() {
		return checkin;
	}

	public void setCheckin(Date checkin) {
		this.checkin = checkin;
	}

	public Date getCheckout() {
		return checkout;
	}

	public void setCheckout(Date checkout) {
		this.checkout = checkout;
	}

	@Override
	public String toString() {
		return "Bookings [bookingId=" + bookingId + ", checkin=" + checkin + ", checkout=" + checkout + "]";
	}
	
	

}
