package com.cg.hotelmanagement.service;

import java.util.List;

import com.cg.hotelmanagement.dto.City;
import com.cg.hotelmanagement.dto.Hotel;
import com.cg.hotelmanagement.dto.Room;

public interface IAdminService {

	public List<City> showCity();
	
	public City findCityById(Long cityId);
	
	public City addCity(City city);

	public boolean removeCity(Long cityId);
	
	

	
	public List<Hotel> showHotels(Long cityId);
	
	public Hotel viewSingleHotel(Long hotelId);
	
	public boolean addHotel(Long cityId, Hotel hotel);
	
	public boolean removeHotel(Long hotelId);
	
	public boolean updateHotel(Long hotelId, Hotel hotel);
	
	
	
	public List<Room> showRooms(Long cityId, Long hotelId);
	
	public Room viewSingleRoom(long roomId);
	
	public Room addRoom(Long cityId, Long hotelId,
			Room room);

	public boolean removeRoom(Long roomId);

	public boolean updateRoom(Long roomId, Room room);
	
	
	
	public int authenticateUser(String username, String password);
	
	//	public boolean addBooking(Long cityId, Long hotelId,
//			Long roomId, Booking booking) throws HotelException;
	
//	public void makeBooking(Long cityId, Long hotelId, Date checkIn, Date checkOut, Long roomId, Long userId);
	
//	public int authenticateUser(String username, String password);
//	
//	public boolean register(Customer customer) throws HotelException;
//	
	
	

}