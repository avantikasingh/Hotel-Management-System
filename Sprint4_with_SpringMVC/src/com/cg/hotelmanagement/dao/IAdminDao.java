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

	public void makeBooking(Long cityId, Long hotelId, Date checkIn, Date checkOut, Long roomId, Long userId);

	public boolean addBooking(Long cityId, Long hotelId, Long roomId, Booking booking) throws HotelException;

	public List<City> getCityList();
	
	public List<Hotel> showHotel(Long cityId)
			throws HotelException;
	
	public List<Room> showRoom(Long cityId, Long hotelId);

	public List viewHotels(Date checkIn, Date checkOut, Long cityId, boolean sortByRating);

	void showBooking(Booking booking);
	
	public boolean register(Customer customer)throws HotelException;

	//public boolean register(Customer customer, Long userId) throws HotelException;
		
	public boolean updateHotel(Long cityId, Hotel hotel) throws HotelException ;
	
	public boolean updateRoom(Long cityId, Long hotelId,
			Long roomId, String roomType) throws HotelException;

	public Hotel viewHotel(Integer hotelId);
	

//	void updateBooking(Booking booking);

}