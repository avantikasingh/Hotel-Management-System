package com.cg.hotelmanagement.repository;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.cg.hotelmanagement.dto.Booking;
import com.cg.hotelmanagement.dto.City;
import com.cg.hotelmanagement.dto.Customer;
import com.cg.hotelmanagement.dto.Hotel;
import com.cg.hotelmanagement.dto.Room;
import com.cg.hotelmanagement.exception.HotelException;


@Repository("adminDao")
public class AdminDao implements IAdminDao {

	@PersistenceContext
	EntityManager entityManager;

	@Override
	public boolean addCity(City city) throws Exception {
		// TODO Auto-generated method stub

		entityManager.persist(city);
		Long cityId = city.getCityId();
		city.setCityId(cityId);

		return true;
	}

	@Override
	public boolean removeCity(Long cityId) {
		// TODO Auto-generated method stub
		City city = entityManager.find(City.class, cityId);

		if (city != null) {
			try {

				city.setDeleteFlag(1);
				// delete all hotels in the city
				List<Hotel> hotelList = city.getHotelList();
				for (Hotel hotel : hotelList) {
					hotel.setDeleteFlag(1);
					// delete all room in hotel
					List<Room> roomList = hotel.getRoomList();
					for (Room room : roomList)
						room.setDeleteFlag(1);
				}

				entityManager.merge(city);
				return true;

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	@Override
	public boolean addHotel(Long cityId, Hotel hotel) throws HotelException {
		// TODO Auto-generated method stub
		City city = entityManager.find(City.class, cityId);
		if (city != null) {
			city.getHotelList().add(hotel);
			entityManager.merge(city);
			return true;
		}
		return false;
	}

	@Override
	public boolean removeHotel(Long cityId, Long hotelId) {
		// TODO Auto-generated method stub
		Hotel hotel = entityManager.find(Hotel.class, hotelId);
		System.out.println(hotel);
		if (hotel != null) {
			try {

				hotel.setDeleteFlag(1);
				// delete all room in hotel
				List<Room> roomList = hotel.getRoomList();
				for (Room room : roomList)
					room.setDeleteFlag(1);

				entityManager.merge(hotel);

			} catch (Exception e) {
				e.printStackTrace();
			}
			return true;
		}
		return false;
	}

	@Override
	public boolean addRoom(Long hotelId, Room room) throws HotelException {
		// TODO Auto-generated method stub
		Hotel hotel = entityManager.find(Hotel.class, hotelId);
		if (hotel != null) {
			hotel.getRoomList().add(room);
			entityManager.merge(hotel);
			return true;
		}
		return false;
	}

	@Override
	public boolean removeRoom(Long hotelId, Long roomId) {
		// TODO Auto-generated method stub
		Room room = entityManager.find(Room.class, roomId);

		if (room != null) {
			try {

				room.setDeleteFlag(1);
				entityManager.merge(room);

			} catch (Exception e) {
				e.printStackTrace();
			}
			return true;
		}
		return false;
	}

	@Override
	public void makeBooking(Long cityId, Long hotelId, Date checkIn, Date checkOut, Long roomId, Long userId) {
//	Booking booking = new Booking(1l, checkIn, checkOut);
//		Customer customer = entityManager.find(Customer.class, userId);
//		City city = entityManager.find(City.class, cityId);
//		List<Hotel> hotelList = city.getHotelList();
//		List<Room> roomList;
//		for (Hotel hotel : hotelList) {
//			if (hotel.getHotelId() == hotelId) {
//				roomList = hotel.getRoomList();
//				for (Room room : roomList) {
//					if (room.getRoomId() == roomId) {
//						customer.setBooking(booking);
//						room.getBookingDetails().add(booking);
//						entityManager.merge(room);
//					}
//				}
//			}
//		}

	}

	@Override
	public boolean addBooking(Long cityId, Long hotelId, Long roomId, Booking booking) throws HotelException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<City> getCityList() {
		Query query = entityManager.createQuery("From City c where c.deleteFlag!=1");
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
		entityManager.persist(customer);
		Long userId = customer.getUserId();
		customer.setUserId(userId);
		return true;

	}

	@Override
	public boolean updateHotel(Long cityId, Hotel newHotel) throws HotelException {
		City city = entityManager.find(City.class, cityId);
		if (city != null) {
			List<Hotel> hotelList = city.getHotelList();
			for (Hotel hotel : hotelList) {
				if (hotel.getHotelId() == newHotel.getHotelId()) {
					hotel.setHotelAddress(newHotel.getHotelAddress());
					hotel.setHotelName(newHotel.getHotelName());
					hotel.setHotelPhoneNumber(newHotel.getHotelPhoneNumber());
					hotel.setHotelRating(newHotel.getHotelRating());
					entityManager.merge(hotel);
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public boolean updateRoom(Long cityId, Long hotelId, Room newRoom) throws HotelException {
		City city = entityManager.find(City.class, cityId);
		List<Hotel> hotelList = city.getHotelList();
		List<Room> roomList;
		if (city != null) {
			for (Hotel hotel : hotelList) {
				if (hotel.getHotelId() == hotelId) {
					roomList = hotel.getRoomList();
					for (Room room : roomList) {
						if (room.getRoomId() == newRoom.getRoomId()) {
							room.setRoomType(newRoom.getRoomType());
							room.setRoomNumber(newRoom.getRoomNumber());
							room.setRoomRent(newRoom.getRoomRent());
							entityManager.merge(room);
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
		Query query = entityManager.createQuery("From Hotel h where h.cityId:first and h.deleteFlag!=1");
		query.setParameter("first", cityId);
		List<Hotel> hotelList = query.getResultList();
		return hotelList;
	}

	@Override
	public List<Room> showRoom(Long cityId, Long hotelId) {
		Query query = entityManager.createQuery("From Hotel h where h.cityId:first and h.deleteFlag!=1");
		query.setParameter("first", cityId);
		List<Hotel> hotelList = query.getResultList();
		for (Hotel hotel : hotelList) {
			if (hotel.getHotelId() == hotelId) {
				for (Room room : hotel.getRoomList()) {
					if (room.getDeleteFlag() != 1)
						System.out.println(room);
				}
			}
		}
		return null;
	}

	@Override
	public Hotel viewHotel(Integer hotelId) {
		Query query = entityManager.createQuery("From Hotel h where h.deleteFlag!=1");
		List<Hotel> hotelList = query.getResultList();

		for (Hotel hotel : hotelList) {
			if (hotel.getHotelId() == (long) hotelId) {
				return hotel;

			}
		}
		return null;

	}

	@Override
	public Room viewSingleRoom(long roomId) {
		// TODO Auto-generated method stub
		Query query = entityManager.createQuery("From Room h where  h.deleteFlag!=1");

		List<Room> roomList = query.getResultList();
		for (Room room : roomList) {
			if (room.getRoomId() == roomId) {
				return room;
			}
		}
		return null;
	}

	public int authenticateUser(String username, String password) {
	try {
		Query query = entityManager.createQuery("From Customer u where u.username=:first AND u.password=:second");
		query.setParameter("first", username);
		query.setParameter("second", password);
		Customer customer = (Customer) query.getSingleResult();
		if (customer != null) {
			if (customer.getRole().equalsIgnoreCase("Admin"))
				return 1;
			else
				return 0;
		}
	} catch (Exception e) {
		// TODO: handle exception
		return -1;
	}
	return -1;
		
	}

}
