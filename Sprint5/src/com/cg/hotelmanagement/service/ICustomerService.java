package com.cg.hotelmanagement.service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.cg.hotelmanagement.dto.City;
import com.cg.hotelmanagement.dto.Hotel;
import com.cg.hotelmanagement.dto.Room;

public interface ICustomerService {
	
	boolean register(String firstName, String lastName, String gender, String username, String emailId,
			LocalDate dateOfBirth, String userMobileNo, String aadharNumber, String password);
	
	public int authenticateUser(String username, String password);
	
	public List<City> getCityList();
	
	public Map<Hotel,List<Room>> availableRooms(LocalDate checkin, LocalDate checkout, String cityName);

	
}
