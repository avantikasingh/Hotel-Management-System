package com.cg.hotelmanagement.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.cg.hotelmanagement.dto.Booking;
import com.cg.hotelmanagement.dto.City;
import com.cg.hotelmanagement.dto.Customer;
import com.cg.hotelmanagement.dto.Hotel;
import com.cg.hotelmanagement.dto.Room;
import com.cg.hotelmanagement.exception.HotelException;
import com.cg.hotelmanagement.repository.CityRepository;
import com.cg.hotelmanagement.repository.CustomerRepository;
import com.cg.hotelmanagement.repository.HotelRepository;


@Service("customerService")
@Transactional

public class CustomerService implements ICustomerService {
	
	@Autowired
	CustomerRepository customerRepo;
	@Autowired
	CityRepository cityRepo;
	@Autowired
	HotelRepository hotelRepo;
	
	@Override
	public boolean register(Customer customer) {
		if(!Validate.aadhar(customer.getAadharNumber()))
			throw new HotelException("Length of aadhar must be 12");
		//validateMobileNumber throws exception if mobile number is invalid
		Validate.validateMobileNumber(customer.getUserMobile());
			
		customerRepo.save(customer);
		return true;
	}

	@Override
	public int authenticateUser(String username, String password) {
		
		System.out.println("parameter");
		System.out.println(username);
		System.out.println(password);
		Customer user=getCustomer(username, password);
		System.out.println("attribute");
		System.out.println(user.getUsername());
		System.out.println(user.getPassword());
		if(user!=null)
		{	if (user.getRole().equalsIgnoreCase("Admin"))
					return 1;
				else
					return 0;
		}
		
		return -1;
	}

	@Override
	public List<City> getCityList() {
		// TODO Auto-generated method stub
		return cityRepo.findAll();
	}
	
	
	public boolean isAvailable(Room room, LocalDate checkIn, LocalDate checkOut) {
		
		/*
		 * Return true if room is available in the given date interval
		 * Else returns false 
		 */
		
		List<Booking> bookingList = room.getBookingDetails();
		
		
		if(bookingList.size()==0)
		{
			
			return true;
		}
		List<LocalDate> dates = new ArrayList<>();
		
		LocalDate localDate;
		
		for(Booking b:bookingList) {
			dates.add(b.getCheckIn());
			dates.add(b.getCheckOut());
		}
		
		Collections.sort(dates);
		
		//System.out.println(dates);
		
		if(checkIn.isAfter(dates.get(dates.size()-1)))
			return true;
		
		if(checkOut.isBefore(dates.get(0)))
			return true;
		
		
		for(int i=0;i<dates.size();i+=2) {			
			if(i+1<dates.size() && checkIn.isAfter(dates.get(i+1))) {
				if(i+2<dates.size() && checkOut.isBefore(dates.get(i+2)))
					return true;
			}
		}
		
		return false;
	}
	
	
	@Override
	public Map<Hotel,List<Room>> availableRooms(LocalDate checkin, LocalDate checkout, String cityName) {
		
		/*
		 * Returns a map of Hotel and corresponding Room List for a given City name which are available in the given Date interval  
		 */
		
		// TODO Auto-generated method stub
		List<City> cityList=getCityList();
		List<Hotel> hotelList=new LinkedList<Hotel>();
		for(City city:cityList)
		{
			if(city.getCityName().equalsIgnoreCase(cityName))
			{
				hotelList=city.getHotelList();
				
			}
		}
		
		Map<Hotel,List<Room>> availableRooms=new HashMap<Hotel,List<Room>>();
		
		for(Hotel hotel:hotelList)
		{
			List<Room> availableRoomList=new LinkedList<Room>();
			List<Room> roomList=hotel.getRoomList();
			
			
			for(Room room:roomList)
			{
				if(isAvailable(room,checkin,checkout))
				{
					availableRoomList.add(room);
				}
			}
			
			if(availableRoomList!=null)
			{
				availableRooms.put(hotel,availableRoomList);
			}
		}
		
		return availableRooms;
	}
	

	
	
	public List<Hotel> showHotel(Long cityId) throws HotelException
	{
		List<City> cityList=cityRepo.findAll();
		
		for(City c:cityList)
		{
			if(c.getCityId()==cityId)
				return c.getHotelList();
		}
		
		return null;
	}
	
	public List<Room> showRoom(Long cityId, Long hotelId) throws HotelException
	{
		List<Hotel> hotelList=showHotel(cityId);
		
		for(Hotel hotel:hotelList)
		{
			if(hotel.getHotelId()==hotelId)
				return hotel.getRoomList();
		}
		return null;
	}

	
	
	@Override
	public Booking makeBooking(Booking booking, String username, String password) {
		// TODO Auto-generated method stub
		System.out.println("In cust service make booking");
		
		Customer customer=getCustomer(username, password);
		System.out.println(customer);
		customer.setBooking(booking);
		customerRepo.save(customer);
		Long bookingId = customer.getBooking().getBookingId();
		System.out.println(bookingId);
		booking.setBookingId(bookingId);
		
		return booking;
	}

	
	
	@Override
	public Customer getCustomer(String username, String password) {
		// TODO Auto-generated method stub
		System.out.println("In get Customer");
		List<Customer> customerList=customerRepo.findAll();
		System.out.println(customerList);
		for(Customer customer:customerList)
		{
			System.out.println(customer.getUsername());
			System.out.println(customer.getPassword());
			if((customer.getUsername().equals(username))&&(customer.getPassword().equals(password)))
			{
				System.out.println("ok");
				return customer;
			}
		}
		System.out.println("not ok");
		return null;
	}
	
	
	

}
