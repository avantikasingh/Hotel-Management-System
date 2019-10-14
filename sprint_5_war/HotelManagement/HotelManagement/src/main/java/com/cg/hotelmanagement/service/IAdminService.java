package com.cg.hotelmanagement.service;

import java.util.List;

import com.cg.hotelmanagement.dto.City;
import com.cg.hotelmanagement.dto.Hotel;
import com.cg.hotelmanagement.dto.Room;
import com.cg.hotelmanagement.exception.HotelException;

public interface IAdminService {

	public boolean addCity(City city) throws HotelException;

	public boolean removeCity(Long cityId) throws HotelException;

	public boolean removeHotel(Long cityId, Long hotelId) throws HotelException;

	public boolean addRoom(Long cityId, Long hotelId,
			Room room) throws HotelException;

	public boolean removeRoom(Long cityId,Long hotelId,
			Long roomId) throws HotelException;

//	public boolean addBooking(Long cityId, Long hotelId,
//			Long roomId, Booking booking) throws HotelException;

	

	public List<City> showCity() throws HotelException;

	public List<Hotel> showHotel(Long cityId) throws HotelException;

	public List<Room> showRoom(Long cityId, Long hotelId) throws HotelException;

	public boolean addHotel(Long cityId, Hotel hotel)
			throws HotelException ;
	
	public boolean updateHotel(Long cityId, Hotel hotel) throws HotelException ;
	
	public boolean updateRoom(Long cityId, Long hotelId,
			Room room) throws HotelException;
	
//	public void makeBooking(Long cityId, Long hotelId, Date checkIn, Date checkOut, Long roomId, Long userId);

	public Hotel viewHotel(Long hotelId) throws HotelException;

	public Room viewSingleRoom(long roomId) throws HotelException;
	
	public int authenticateUser(String username, String password);
	
//	public int authenticateUser(String username, String password);
//	
//	public boolean register(Customer customer) throws HotelException;
//	
	
	

}