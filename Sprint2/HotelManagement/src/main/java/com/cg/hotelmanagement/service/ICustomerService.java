package com.cg.hotelmanagement.service;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.cg.hotelmanagement.dto.Booking;
import com.cg.hotelmanagement.dto.Hotel;

public interface ICustomerService {

	public boolean register(BigInteger customerId, Booking booking,
			String firstName, String lastName, BigInteger aadharNumber);

	public List viewHotels(Date checkIn, Date checkOut, BigInteger cityId, boolean sortByRating);

	public void makeBooking(BigInteger cityId, BigInteger hotelId,
			Date checkIn, Date checkOut, BigInteger roomId,
			AdminService adminService);;
}
