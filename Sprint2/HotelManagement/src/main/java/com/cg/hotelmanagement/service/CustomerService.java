package com.cg.hotelmanagement.service;

import java.math.BigInteger;
import java.util.Date;
import java.util.Map;

import com.cg.hotelmanagement.dao.AdminDao;
import com.cg.hotelmanagement.dao.IAdminDao;
import com.cg.hotelmanagement.dto.Booking;
import com.cg.hotelmanagement.dto.Hotel;

public class CustomerService implements ICustomerService{

	IAdminDao adminDao = new AdminDao();
	
	@Override
	public Map<BigInteger, Hotel> viewHotels(Date checkIn, Date checkOut,
			BigInteger cityId, boolean sortByRating) {
		return adminDao.viewHotels(checkIn, checkOut, cityId, sortByRating);
	}

	@Override
	public Booking makeBooking(BigInteger hotelId, Date checkIn, Date checkOut,
			BigInteger roomId) {
		return adminDao.makeBooking(hotelId, checkIn, checkOut, roomId);
	}

	@Override
	public boolean register() {
		return adminDao.register();
	}

}
