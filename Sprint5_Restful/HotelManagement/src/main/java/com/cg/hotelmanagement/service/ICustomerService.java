package com.cg.hotelmanagement.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import com.cg.hotelmanagement.dto.Booking;
import com.cg.hotelmanagement.dto.City;
import com.cg.hotelmanagement.dto.Customer;
import com.cg.hotelmanagement.dto.Hotel;
import com.cg.hotelmanagement.dto.Room;
import com.cg.hotelmanagement.exception.HotelException;

public interface ICustomerService {
	
	public boolean register(Customer customer);
	
	public int authenticateUser(String username, String password);
	
	public List<City> getCityList();
	
	public Map<Hotel,List<Room>> availableRooms(LocalDate checkin, LocalDate checkout, String cityName);
	
	public List<Hotel> showHotel(Long cityId) throws HotelException;
	
	public List<Room> showRoom(Long cityId, Long hotelId) throws HotelException;
	
	public Booking makeBooking(Booking booking, String username, String password);
	
	public Customer getCustomer(String username,String password);

	boolean isAvailable(Room room, LocalDate checkIn, LocalDate checkOut);

	
}

