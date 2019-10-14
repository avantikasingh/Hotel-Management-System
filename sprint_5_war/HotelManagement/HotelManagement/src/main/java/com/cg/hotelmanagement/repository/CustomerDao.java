package com.cg.hotelmanagement.repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.cg.hotelmanagement.dto.Booking;
import com.cg.hotelmanagement.dto.City;
import com.cg.hotelmanagement.dto.Customer;
import com.cg.hotelmanagement.dto.Hotel;
import com.cg.hotelmanagement.dto.Room;
import com.cg.hotelmanagement.util.JPAUtil;

@Repository("customerDao")
public class CustomerDao implements ICustomerDao {
	
	
	@PersistenceContext
	EntityManager entityManager;
	
	@Override
	public boolean register(Customer customer) {
		entityManager.persist(customer);
		return true;
	}

	@Override
	public List<Hotel> viewAvailableHotels(LocalDate checkin, LocalDate checkout) {
		// TODO Auto-generated method stub
		
		
		return null;
	}
	
	public int authenticateUser(String username, String password) {
		Query query = entityManager.createQuery("From Customer u where u.username=:first AND u.password=:second");
		query.setParameter("first", username);
		query.setParameter("second", password);
		Customer customer = (Customer) query.getSingleResult();
		if(customer!=null) {
			if(customer.getRole().equalsIgnoreCase("Admin"))
				return 1;
			else
				return 0;
		}
		return -1;
	}
	
	
	@Override
	public List<City> getCityList() {
		Query query = entityManager.createQuery("From City c where c.deleteFlag!=1");
		List<City> cityList = query.getResultList();
		return cityList;
	}
	
	public boolean isAvailable(Room room, LocalDate checkIn, LocalDate checkOut) {
		
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
		System.out.println("false");
		return false;
}

	@Override
	public Map<Hotel,List<Room>> availableRooms(LocalDate checkin, LocalDate checkout, String cityName) {
		// TODO Auto-generated method stub
		List<City> cityList=getCityList();
		List<Hotel> hotelList=new LinkedList<Hotel>();
		for(City city:cityList)
		{
			if(city.getCityName().equalsIgnoreCase(cityName))
			{
				hotelList=city.getHotelList();
				System.out.println(hotelList);
			}
		}
		
		Map<Hotel,List<Room>> availableRooms=new HashMap<Hotel,List<Room>>();
		
		for(Hotel hotel:hotelList)
		{
			List<Room> availableRoomList=new LinkedList<Room>();
			List<Room> roomList=hotel.getRoomList();
			System.out.println(roomList.size());
			
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
	
	



	
}
