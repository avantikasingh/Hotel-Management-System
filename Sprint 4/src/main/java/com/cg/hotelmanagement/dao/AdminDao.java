package com.cg.hotelmanagement.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.persistence.*;

import com.cg.hotelmanagement.dto.Booking;
import com.cg.hotelmanagement.dto.City;
import com.cg.hotelmanagement.dto.Hotel;
import com.cg.hotelmanagement.dto.Room;
import com.cg.hotelmanagement.dto.Customer;
import com.cg.hotelmanagement.exception.HotelException;
import com.cg.hotelmanagement.util.JPAUtil;

public class AdminDao implements IAdminDao {
	
	private static EntityTransaction tx;
	private static EntityManager entityManager;

	static {
		entityManager = JPAUtil.getEntityManager();
		tx  = JPAUtil.getEntityManager().getTransaction();
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
			
			city.setDeleteFlag(1);
			//delete all hotels in the city
			List<Hotel> hotelList=city.getHotelList();
			for(Hotel hotel:hotelList)
			{
				hotel.setDeleteFlag(1);
				//delete all room in hotel
				List<Room> roomList=hotel.getRoomList();
				for(Room room:roomList)
					room.setDeleteFlag(1);
			}
			
			entityManager.merge(city);
			tx.commit();
			return true;
		
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		return false;
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
		System.out.println(hotel);
		if (hotel!= null) {
			try{
				tx.begin();
			
			hotel.setDeleteFlag(1);
			//delete all room in hotel
			List<Room> roomList=hotel.getRoomList();
			for(Room room:roomList)
				room.setDeleteFlag(1);

			
			entityManager.merge(hotel);
			tx.commit();
		
			}catch (Exception e) {
				e.printStackTrace();
			}
			return true;
		}
		return false;
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
			
			room.setDeleteFlag(1);
			entityManager.merge(room);
			tx.commit();
		
			}catch (Exception e) {
				e.printStackTrace();
			}
			return true;
		}
		return false;
	}

	@Override
	public void makeBooking(Long cityId, Long hotelId, Date checkIn, Date checkOut, Long roomId, Long userId) {
		Booking booking = new Booking(1l, checkIn, checkOut);
		Customer customer = entityManager.find(Customer.class, userId);
		City city = entityManager.find(City.class, cityId);
		List<Hotel> hotelList = city.getHotelList();
		List<Room> roomList;
		for(Hotel hotel:hotelList) {
			if(hotel.getHotelId()==hotelId) {
				roomList = hotel.getRoomList();
				for(Room room:roomList) {
					if(room.getRoomId()==roomId) {
						tx.begin();
						customer.setBooking(booking);
						room.getBookingDetails().add(booking);
						entityManager.merge(room);
						tx.commit();
					}
				}
			}
		}
		
		
	}

	@Override
	public boolean addBooking(Long cityId, Long hotelId, Long roomId, Booking booking)
			throws HotelException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<City> getCityList() {
		Query query = JPAUtil.getEntityManager().createQuery("From City c where c.deleteFlag!=1");
		List<City> cityList = query.getResultList();
		return cityList;
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
	public boolean register(Customer customer) throws HotelException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateHotel(Long cityId, Long hotelId, String hotelName) throws HotelException {
		City city = entityManager.find(City.class, cityId);
		if(city!=null) {
			List<Hotel> hotelList = city.getHotelList();
			for(Hotel hotel:hotelList) {
				if(hotel.getHotelId()==hotelId) {
					tx.begin();
					hotel.setHotelName(hotelName);
					entityManager.merge(hotel);
					tx.commit();
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public boolean updateRoom(Long cityId, Long hotelId, Long roomId, String roomType)
			throws HotelException {
		City city = entityManager.find(City.class, cityId);
		List<Hotel> hotelList = city.getHotelList();
		List<Room> roomList;
		if(city!=null) {
			for(Hotel hotel:hotelList) {
				if(hotel.getHotelId()==hotelId) {
					roomList = hotel.getRoomList();
					for(Room room:roomList) {
						if(room.getRoomId()==roomId) {
							tx.begin();
							room.setRoomType(roomType);
							entityManager.merge(room);
							tx.commit();
							return true;
						}
					}
				}
			}
		}
		return false;
	}

	@Override
	public List<Hotel> showHotel(Long cityId) throws HotelException {
		Query query = JPAUtil.getEntityManager().createQuery("From Hotel h where h.cityId:first and h.deleteFlag!=1");
		query.setParameter("first", cityId);
		List<Hotel> hotelList = query.getResultList();
		return hotelList;
	}

	@Override
	public List<Room> showRoom(Long cityId, Long hotelId) {
		Query query = JPAUtil.getEntityManager().createQuery("From Hotel h where h.cityId:first and h.deleteFlag!=1");
		query.setParameter("first", cityId);
		List<Hotel> hotelList = query.getResultList();
		for(Hotel hotel:hotelList) {
			if(hotel.getHotelId()==hotelId) {
				for(Room room:hotel.getRoomList())
				{
					if(room.getDeleteFlag()!=1)
						System.out.println(room);
				}
			}
		}
		return null;
	}

}
