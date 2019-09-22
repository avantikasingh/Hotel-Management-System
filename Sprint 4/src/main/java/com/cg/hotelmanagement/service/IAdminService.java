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

	public boolean addCity(Long cityId, String cityName) throws Exception;

	public boolean removeCity(Long cityId);

	public boolean removeHotel(Long cityId, Long hotelId);

	public boolean addRoom(Long cityId, Long hotelId,
			Long roomId, String roomType, double roomRent,
			String roomNumber) throws HotelException;

	public boolean removeRoom(Long cityId,Long hotelId,
			Long roomId);

	public boolean addBooking(Long cityId, Long hotelId,
			Long roomId, Booking booking) throws HotelException;

	

	public Map<Long, City> showCity();

	public Map<Long, Hotel> showHotel(Long cityId) throws HotelException;

	public Map<Long, Room> showRoom(Long cityId, Long hotelId);

	public boolean addHotel(Long cityId, String hotelName, String hotelAddress,
			String hotelPhoneNumber, float hotelRating) throws HotelException;
	
	public boolean updateHotel(Long cityId, Long hotelId,
			String hotelName) throws HotelException ;
	
	public boolean updateRoom(Long cityId, Long hotelId,
			Long roomId, String roomType) throws HotelException;
	
	
	

}