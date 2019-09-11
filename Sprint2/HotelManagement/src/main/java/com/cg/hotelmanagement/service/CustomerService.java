package com.cg.hotelmanagement.service;

import java.math.BigInteger;
import java.util.Date;
import java.util.Map;

import com.cg.hotelmanagement.dao.AdminDao;
import com.cg.hotelmanagement.dao.IAdminDao;
import com.cg.hotelmanagement.dto.Booking;
import com.cg.hotelmanagement.dto.Customer;
import com.cg.hotelmanagement.dto.Hotel;

public class CustomerService implements ICustomerService{

	IAdminDao adminDao = new AdminDao();

	@Override
	public boolean register(BigInteger customerId, Booking booking, String firstName, String lastName,
			BigInteger aadharNumber) {
		Customer customer = new Customer(customerId,booking,firstName,lastName,aadharNumber.toString());
		return adminDao.register(customer);
		
	}

	@Override
	public void viewHotels(BigInteger cityId, BigInteger hotelId) {
		adminDao.viewHotels(cityId,hotelId);
		
	}

	@Override
	public void makeBooking(BigInteger hotelId, BigInteger hotelId2, Date checkIn, Date checkOut,
			BigInteger roomId) {
		adminDao.makeBooking(hotelId,hotelId, checkIn, checkOut, roomId);
	}

	}
