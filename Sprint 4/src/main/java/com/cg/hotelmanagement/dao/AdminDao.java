package com.cg.hotelmanagement.dao;

import java.math.BigInteger;
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

		tx.commit();
		
		return true;
	}

	@Override
	public boolean removeCity(BigInteger cityId) {
		// TODO Auto-generated method stub
		City city = entityManager.find(City.class, cityId);
		System.out.println(city);
		if (city!= null) {
			try{
				tx.begin();
			
			
			entityManager.remove(city);
			tx.commit();
		
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	@Override
	public boolean addHotel(BigInteger cityId, Hotel hotel) throws HotelException {
		// TODO Auto-generated method stub
		// Add Hotel object in the hotelList of City class
		City city=entityManager.find(City.class,cityId);
		System.out.println(city);
		
		city.getHotelList().put(hotel.getHotelId(),hotel);
		
		//add hotel to database
		tx.begin();
		entityManager.persist(hotel);
		tx.commit();
		return false;
	}

	@Override
	public boolean removeHotel(BigInteger cityId, BigInteger hotelId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addRoom(BigInteger hotelId, Room room) throws HotelException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeRoom(BigInteger hotelId, BigInteger roomId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void makeBooking(BigInteger hotelId, BigInteger hotelId2, Date checkIn, Date checkOut, BigInteger roomId) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean addBooking(BigInteger cityId, BigInteger hotelId, BigInteger roomId, Booking booking)
			throws HotelException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Map<BigInteger, City> getCityList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List viewHotels(Date checkIn, Date checkOut, BigInteger cityId, boolean sortByRating) {
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
	public boolean updateHotel(BigInteger cityId, BigInteger hotelId, String hotelName) throws HotelException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateRoom(BigInteger cityId, BigInteger hotelId, BigInteger roomId, String roomType)
			throws HotelException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Map<BigInteger, Hotel> showHotel(BigInteger cityId) throws HotelException {
		// TODO Auto-generated method stub
		return null;
	}

}
