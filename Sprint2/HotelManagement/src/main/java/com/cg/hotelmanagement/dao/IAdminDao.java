package com.cg.hotelmanagement.dao;

import com.cg.hotelmanagement.dto.*;
import com.cg.hotelmanagement.exception.HotelException;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import java.util.Map;

public interface IAdminDao {

	public boolean addCity(City city) throws HotelException;

	public boolean removeCity(BigInteger cityId);

//	public boolean addHotel(BigInteger cityId, Hotel hotel);;
	// old version used in colections
//	city id depreciated
	public boolean addHotel(Hotel hotel) throws HotelException;

	public boolean removeHotel(BigInteger cityId, BigInteger hotelId);

//	public boolean addRoom(BigInteger cityId, BigInteger hotelId, Room newRoom);
	// old version used in colections
	public boolean addRoom(Room room) throws HotelException;// new verion used in jdbc

	public boolean removeRoom(BigInteger cityId, BigInteger hotelId, BigInteger roomId);

	public void makeBooking(BigInteger hotelId, BigInteger hotelId2, Date checkIn, Date checkOut, BigInteger roomId);

	public boolean register(Customer customer);

	public boolean addBooking(BigInteger cityId, BigInteger hotelId, BigInteger roomId, Booking booking) throws HotelException;

	public Map<BigInteger, City> getCityList();

	public void viewHotels(BigInteger cityId);

	public Map<BigInteger, Hotel> viewHotels(Date checkIn, Date checkOut, BigInteger cityId, boolean sortByRating);

	void updateHotel(BigInteger cityId, BigInteger hotelId, String hotelName);

	void updateRoom(BigInteger cityId, BigInteger hotelId, BigInteger roomId, String roomType);

	void showBooking(Booking booking);

	void updateBooking(Booking booking);

}
