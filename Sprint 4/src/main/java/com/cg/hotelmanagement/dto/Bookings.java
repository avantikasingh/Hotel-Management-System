package com.cg.hotelmanagement.dto;

import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Embeddable;

@Embeddable
public class Bookings {
	
	private BigInteger bookingId;
	private Date checkin;
	private Date checkout;

}
