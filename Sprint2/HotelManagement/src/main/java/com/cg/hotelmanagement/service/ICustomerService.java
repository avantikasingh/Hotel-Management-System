package com.cg.hotelmanagement.service;

import java.math.BigInteger;
import java.util.Date;
import java.util.Map;

import com.cg.hotelmanagement.dto.Booking;
import com.cg.hotelmanagement.dto.Hotel;

public interface ICustomerService {
	
	public Map<BigInteger,Hotel> viewHotels(Date checkIn, Date checkOut, BigInteger cityId, boolean sortByRating);
	
	public Booking makeBooking(BigInteger hotelId, Date checkIn, Date checkOut, BigInteger roomId);
	
	public boolean register();
	
}
