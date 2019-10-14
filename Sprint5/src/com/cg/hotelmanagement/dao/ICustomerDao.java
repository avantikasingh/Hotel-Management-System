package com.cg.hotelmanagement.dao;


import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import com.cg.hotelmanagement.dto.City;
import com.cg.hotelmanagement.dto.Customer;
import com.cg.hotelmanagement.dto.Hotel;
import com.cg.hotelmanagement.dto.Room;

public interface ICustomerDao {
	
	public boolean register(Customer customer);
	
	public List<Hotel> viewAvailableHotels(LocalDate checkin, LocalDate checkout);
	
	public int authenticateUser(String username, String password);
	
	public List<City> getCityList();
	
	public Map<Hotel,List<Room>> availableRooms(LocalDate checkin, LocalDate checkout, String cityName);

}
