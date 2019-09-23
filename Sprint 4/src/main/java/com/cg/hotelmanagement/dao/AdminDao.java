package com.cg.hotelmanagement.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.persistence.*;

import com.cg.hotelmanagement.dto.Booking;
import com.cg.hotelmanagement.dto.City;
import com.cg.hotelmanagement.dto.Hotel;
import com.cg.hotelmanagement.dto.Room;
import com.cg.hotelmanagement.dto.User;
import com.cg.hotelmanagement.exception.HotelException;

public class AdminDao implements IAdminDao {
	
	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private static EntityTransaction tx;

	static {
		entityManagerFactory = Persistence.createEntityManagerFactory("HotelBookingManagement");
		entityManager = entityManagerFactory.createEntityManager();
		tx = entityManager.getTransaction();
	}
	

	@Override
	public boolean addCity(City city) throws Exception {
		// TODO Auto-generated method stub
		
		tx.begin();
		
		entityManager.persist(city);
		Long cityId=city.getCityId();
		city.setCityId(cityId);
		tx.commit();
		
		return true;
	}

	@Override
	public boolean removeCity(Long cityId) {
		// TODO Auto-generated method stub
		City city = entityManager.find(City.class, cityId);
		
		if (city!= null) {
			try{
				tx.begin();
			
			
			entityManager.remove(city);
			tx.commit();
		
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		return true;
	}

	@Override
	public boolean addHotel(Long cityId, Hotel hotel) throws HotelException {
		// TODO Auto-generated method stub
		City city=entityManager.find(City.class,cityId);	
		if(city!=null)
		{
			tx.begin();
			city.getHotelList().add(hotel);
			entityManager.merge(city);
			tx.commit();
			return true;
		}	
		return false;
	}

	@Override
	public boolean removeHotel(Long cityId, Long hotelId) {
		// TODO Auto-generated method stub
		Hotel hotel = entityManager.find(Hotel.class, hotelId);
		
		if (hotel!= null) {
			try{
				tx.begin();
			
			
			entityManager.remove(hotel);
			tx.commit();
		
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		return true;
	}

	@Override
	public boolean addRoom(Long hotelId, Room room) throws HotelException {
		// TODO Auto-generated method stub
		Hotel hotel=entityManager.find(Hotel.class,hotelId);	
		if(hotel!=null)
		{
			tx.begin();
			hotel.getRoomList().add(room);
			entityManager.merge(hotel);
			tx.commit();
			return true;
		}	
		return false;
	}

	@Override
	public boolean removeRoom(Long hotelId, Long roomId) {
		// TODO Auto-generated method stub
		Room room = entityManager.find(Room.class, roomId);
		
		if (room!= null) {
			try{
				tx.begin();
			
			
			entityManager.remove(room);
			tx.commit();
		
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		return true;
	}

	@Override
	public void makeBooking(Long hotelId, Long hotelId2, Date checkIn, Date checkOut, Long roomId) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean addBooking(Long cityId, Long hotelId, Long roomId, Booking booking)
			throws HotelException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<City> getCityList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List viewHotels(Date checkIn, Date checkOut, Long cityId, boolean sortByRating) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void showBooking(Booking booking) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean register(User user) throws HotelException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateHotel(Long cityId, Long hotelId, String hotelName) throws HotelException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateRoom(Long cityId, Long hotelId, Long roomId, String roomType)
			throws HotelException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Map<Long, Hotel> showHotel(Long cityId) throws HotelException {
		// TODO Auto-generated method stub
		return null;
	}

}
