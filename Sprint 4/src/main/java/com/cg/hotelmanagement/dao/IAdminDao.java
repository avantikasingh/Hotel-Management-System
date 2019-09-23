package com.cg.hotelmanagement.dao;

import com.cg.hotelmanagement.dto.*;
import com.cg.hotelmanagement.exception.HotelException;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import java.util.Map;

public interface IAdminDao {

	public boolean addCity(City city) throws Exception;

	public boolean removeCity(Long cityId); // new version

	public boolean addHotel(Long cityId,Hotel hotel) throws HotelException;

	public boolean removeHotel(Long cityId, Long hotelId); // new version

	public boolean addRoom(Long hotelId,Room room) throws HotelException;// new verion used in jdbc

	public boolean removeRoom(Long hotelId, Long roomId); //new version

	public void makeBooking(Long hotelId, Long hotelId2, Date checkIn, Date checkOut, Long roomId);

	public boolean addBooking(Long cityId, Long hotelId, Long roomId, Booking booking) throws HotelException;

	public List<City> getCityList();// old version

	public List viewHotels(Date checkIn, Date checkOut, Long cityId, boolean sortByRating);

	void showBooking(Booking booking);
	
	public boolean register(User user)throws HotelException;

	//public boolean register(Customer customer, Long userId) throws HotelException;
		
	public boolean updateHotel(Long cityId, Long hotelId,
			String hotelName) throws HotelException ;
	
	public boolean updateRoom(Long cityId, Long hotelId,
			Long roomId, String roomType) throws HotelException;
	
	
	public Map<Long,Hotel> showHotel(Long cityId)
			throws HotelException;

//	void updateBooking(Booking booking);

}