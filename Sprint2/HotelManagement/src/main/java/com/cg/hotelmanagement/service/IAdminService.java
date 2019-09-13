package com.cg.hotelmanagement.service;

import java.math.BigInteger;
import java.util.Date;
import java.util.Map;

import com.cg.hotelmanagement.dto.Booking;
import com.cg.hotelmanagement.dto.City;
import com.cg.hotelmanagement.dto.Hotel;
import com.cg.hotelmanagement.dto.Room;

public interface IAdminService {

	public boolean addCity(BigInteger cityId, String cityName);

	public boolean removeCity(BigInteger cityId);

	public boolean addHotel(BigInteger cityId1, BigInteger hotelId,
			String hotelName, String hotelAddress, String hotelPhone,
			float hotelRating);

	public boolean removeHotel(BigInteger cityId, BigInteger hotelId);

	public boolean addRoom(BigInteger cityId, BigInteger hotelId,
			BigInteger roomId, String roomType, double roomRent,
			String roomNumber);

	public boolean removeRoom(BigInteger cityId, BigInteger hotelId,
			BigInteger roomId);

	public boolean addBooking(BigInteger cityId, BigInteger hotelId,
			BigInteger roomId, Booking booking);

	public Map<BigInteger, Hotel> viewHotels(Date checkIn, Date checkOut,
			BigInteger cityId, boolean sortByRating);

	public Map<BigInteger, City> showCity();

	public Map<BigInteger, Hotel> showHotel(BigInteger cityId);

	public Map<BigInteger, Room> showRoom(BigInteger cityId, BigInteger hotelId);

	public void updateHotel(BigInteger cityId, BigInteger hotelId,
			String hotelName);

	public void updateRoom(BigInteger cityId, BigInteger hotelId,
			BigInteger roomId, String roomType);

	// public boolean addRoom();
	//
	// public boolean addCity();
	//
	// public boolean addHotel();

}
