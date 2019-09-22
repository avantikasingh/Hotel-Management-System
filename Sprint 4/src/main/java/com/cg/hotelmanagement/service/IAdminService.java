package com.cg.hotelmanagement.service;

import java.math.BigInteger;
import java.util.Date;
import java.util.Map;

import com.cg.hotelmanagement.dto.Booking;
import com.cg.hotelmanagement.dto.City;
import com.cg.hotelmanagement.dto.Hotel;
import com.cg.hotelmanagement.dto.Room;
import com.cg.hotelmanagement.exception.HotelException;

public interface IAdminService {

	public boolean addCity(BigInteger cityId, String cityName) throws Exception;

	public boolean removeCity(BigInteger cityId);

	public boolean removeHotel(BigInteger cityId, BigInteger hotelId);

	public boolean addRoom(BigInteger cityId, BigInteger hotelId,
			BigInteger roomId, String roomType, double roomRent,
			String roomNumber) throws HotelException;

	public boolean removeRoom(BigInteger cityId,BigInteger hotelId,
			BigInteger roomId);

	public boolean addBooking(BigInteger cityId, BigInteger hotelId,
			BigInteger roomId, Booking booking) throws HotelException;

	

	public Map<BigInteger, City> showCity();

	public Map<BigInteger, Hotel> showHotel(BigInteger cityId) throws HotelException;

	public Map<BigInteger, Room> showRoom(BigInteger cityId, BigInteger hotelId);

	public boolean addHotel(BigInteger cityId, String hotelName, String hotelAddress,
			String hotelPhoneNumber, float hotelRating) throws HotelException;
	
	public boolean updateHotel(BigInteger cityId, BigInteger hotelId,
			String hotelName) throws HotelException ;
	
	public boolean updateRoom(BigInteger cityId, BigInteger hotelId,
			BigInteger roomId, String roomType) throws HotelException;
	
	
	

}