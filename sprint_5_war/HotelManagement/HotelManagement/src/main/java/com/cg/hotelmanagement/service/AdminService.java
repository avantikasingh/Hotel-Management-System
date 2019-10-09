/*
 * 
 * 
 */

package com.cg.hotelmanagement.service;

import java.util.Date;
import java.util.List;

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
import com.cg.hotelmanagement.repository.HotelRepository;
import com.cg.hotelmanagement.repository.IAdminDao;
import com.cg.hotelmanagement.repository.RoomRepository;

@Service("adminService")
@Transactional
public class AdminService implements IAdminService {

	@Autowired
	CityRepository cityrepo;
	@Autowired
	HotelRepository hotelrepo;
	@Autowired
	RoomRepository roomrepo;

	@Override
	public boolean addCity(City city) throws Exception {
//		Add a new city in the database
		cityrepo.save(city);
		return true;
	}

	public boolean removeCity(Long cityId) {
//		Delete the city from the database
		cityrepo.deleteById(cityId);
		return true;
	}

	@Override
	public boolean removeHotel(Long cityId, Long hotelId) {
//		Remove hotel from the database
		hotelrepo.deleteById(hotelId);
		return true;
	}

	public boolean addRoom(Long cityId, Long hotelId, Room room) throws HotelException {
//		Add a new room in the hotel based on cityid and hotelid
		City city = cityrepo.findById(cityId).orElse(null);
		List<Hotel> hotelList = city.getHotelList();
		for (Hotel hotel : hotelList) {
			if (hotel.getHotelId() == hotelId) {
				List<Room> roomList = hotel.getRoomList();
				roomList.add(room);
				hotel.setRoomList(roomList);
				break;
			}
		}

		city.setHotelList(hotelList);
		cityrepo.save(city);
		return true;
	}

	public boolean removeRoom(Long cityId, Long hotelId, Long roomId) {
//		Deletes a room from the database based on the roomId
		Room room = roomrepo.findById(roomId).orElse(null);
		roomrepo.delete(room);
		return true;

	}

	@Override
//	public boolean addBooking(Long cityId, Long hotelId, Long roomId, Booking booking) throws HotelException {
//		return adminDao.addBooking(cityId, hotelId, roomId, booking);
//	}

	public List<City> showCity() {
//		Returns a list containing all the cities 
		List<City> city = cityrepo.findAll();
		return city;
	}

	public List<Hotel> showHotel(Long cityId) throws HotelException {
//		Returns a list of all the hotels in a city
		List<City> cityMap = cityrepo.findAll();
		for (City c : cityMap) {
			if (c.getCityId() == cityId) {
				return c.getHotelList();
			}
		}

		return null;
	}

	public List<Room> showRoom(Long cityId, Long hotelId) {
//		returns a list of rooms in a hotel in a city
		List<City> cityMap = cityrepo.findAll();
		for (City c : cityMap) {
			if (c.getCityId() == cityId) {
				List<Hotel> hotelList = c.getHotelList();

				for (Hotel hotel : hotelList) {
					if (hotel.getHotelId() == hotelId)
						return hotel.getRoomList();
				}
			}

		}
		return null;
	}

	@Override
	public boolean addHotel(Long cityId, Hotel hotel) throws HotelException {
//		Add a new hotel in the database in existing city
		City city = cityrepo.findById(cityId).orElse(null);
		if (city != null) {
			List<Hotel> hotelList = city.getHotelList();
			hotelList.add(hotel);
			city.setHotelList(hotelList);
			cityrepo.save(city);
			return true;
		}
		return false;
	}

	@Override
	public boolean updateHotel(Long cityId, Hotel hotel) throws HotelException {
//		Update the credentials of existing hotel
		City city = cityrepo.findById(cityId).orElse(null);
		List<Hotel> hotelList = city.getHotelList();
		for (Hotel hotel2 : hotelList) {
			if (hotel2.getHotelId() == hotel.getHotelId()) {
				hotel2.setHotelAddress(hotel.getHotelAddress());
				hotel2.setHotelName(hotel.getHotelName());
				hotel2.setHotelPhoneNumber(hotel.getHotelPhoneNumber());
				hotel2.setHotelRating(hotel.getHotelRating());
				break;
			}
		}

		cityrepo.save(city);
		return true;
	}

	@Override
	public boolean updateRoom(Long cityId, Long hotelId, Room room) throws HotelException {
//		Update the credentials of existing room
		City city = cityrepo.findById(cityId).orElse(null);
		List<Hotel> hotelList = city.getHotelList();
		for (Hotel hotel : hotelList) {
			if (hotel.getHotelId() == hotelId) {
				for (Room rooms : hotel.getRoomList()) {
					if (rooms.getRoomId() == rooms.getRoomId()) {
						rooms.setRoomType(room.getRoomType());
						rooms.setRoomNumber(room.getRoomNumber());
						rooms.setRoomRent(room.getRoomRent());
						break;
					}
				}
			}

		}
		return true;
	}

//	@Override
//	public void makeBooking(Long cityId, Long hotelId, Date checkIn, Date checkOut, Long roomId, Long userId) {
//		adminDao.makeBooking(cityId, hotelId, checkIn, checkOut, roomId, userId);
//	}

	@Override
	public Hotel viewHotel(Long hotelId) {
//		Returns a hotel based on the hotelId
		Hotel hotel = (Hotel) hotelrepo.findById(Long.valueOf(hotelId)).orElse(null);
		return hotel;
	}

	@Override
	public Room viewSingleRoom(long roomId) {
//		Returns a single room object based on the id supplied
		// TODO Auto-generated method stub
		Room room = (Room) roomrepo.findById(roomId).orElse(null);
		return room;
	}

//	@Override
//	public int authenticateUser(String username, String password) {
//		return adminDao.authenticateUser(username, password);
//	}
//
//	@Override
//	public boolean register(Customer customer) throws HotelException {
//		return adminDao.register(customer);
//	}

}