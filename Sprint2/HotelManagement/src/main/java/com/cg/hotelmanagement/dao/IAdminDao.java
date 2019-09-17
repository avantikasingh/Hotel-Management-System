package com.cg.hotelmanagement.dao;

import com.cg.hotelmanagement.dto.*;
import com.cg.hotelmanagement.exception.HotelException;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import java.util.Map;

public interface IAdminDao {

	public boolean addCity(City city) throws Exception;

//	public boolean removeCity(BigInteger cityId); old version
	public boolean removeCity(BigInteger cityId); // new version

//	public boolean addHotel(BigInteger cityId, Hotel hotel);;
	// old version used in colections
//	city id depreciated
	public boolean addHotel(BigInteger cityId,Hotel hotel) throws HotelException;

//	public boolean removeHotel(BigInteger cityId, BigInteger hotelId); // old version
	public boolean removeHotel(BigInteger cityId, BigInteger hotelId); // new version

//	public boolean addRoom(BigInteger cityId, BigInteger hotelId, Room newRoom);
	// old version used in colections
	public boolean addRoom(BigInteger hotelId,Room room) throws HotelException;// new verion used in jdbc

//	public boolean removeRoom(BigInteger cityId, BigInteger hotelId, BigInteger roomId);
	public boolean removeRoom(BigInteger hotelId, BigInteger roomId); //new version

	public void makeBooking(BigInteger hotelId, BigInteger hotelId2, Date checkIn, Date checkOut, BigInteger roomId);



	public boolean addBooking(BigInteger cityId, BigInteger hotelId, BigInteger roomId, Booking booking) throws HotelException;

	public Map<BigInteger, City> getCityList();// old version
//	public Map<Long, String> getCityList(); //new version returns a map with list and String

	
	public List viewHotels(Date checkIn, Date checkOut, BigInteger cityId, boolean sortByRating);

//	void updateHotel(BigInteger cityId, BigInteger hotelId, String hotelName);
//
//	void updateRoom(BigInteger cityId, BigInteger hotelId, BigInteger roomId, String roomType);

	void showBooking(Booking booking);
	
	public boolean register(User user)throws HotelException;
	public boolean register(Customer customer, BigInteger userId) throws HotelException;
	
	
	public boolean updateHotel(BigInteger cityId, BigInteger hotelId,
			String hotelName) throws HotelException ;
	public boolean updateRoom(BigInteger cityId, BigInteger hotelId,
			BigInteger roomId, String roomType) throws HotelException;
	
	public Map<BigInteger,Hotel> showHotel(BigInteger cityId)
			throws HotelException;

//	void updateBooking(Booking booking);

}
