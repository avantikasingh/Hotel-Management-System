package com.cg.hotelmanagement.dao;


import java.time.LocalDate;
import java.util.List;

import com.cg.hotelmanagement.dto.Customer;
import com.cg.hotelmanagement.dto.Hotel;

public interface ICustomerDao {
	
	public boolean register(Customer customer);
	
	public List<Hotel> viewAvailableHotels(LocalDate checkin, LocalDate checkout);

}
