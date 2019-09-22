package com.cg.hotelmanagement.service;
import com.cg.hotelmanagement.dao.AdminDao;
import com.cg.hotelmanagement.dao.IAdminDao;
import com.cg.hotelmanagement.dto.*;
import com.cg.hotelmanagement.exception.HotelException;

import java.math.BigInteger;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class AdminService implements IAdminService {

	IAdminDao adminDao = new AdminDao();

	@Override
	public boolean addCity(Long cityId, String cityName) throws Exception {
		City city = new City();
		city.setCityId(cityId);
		city.setCityName(cityName);
		return adminDao.addCity(city);
	}

	public boolean removeCity(Long cityId) {
		return adminDao.removeCity(cityId);
	}

	@Override
	public boolean removeHotel(Long cityId, Long hotelId) {
		return adminDao.removeHotel(cityId, hotelId);
	}

	public boolean addRoom(Long cityId, Long hotelId,
			Long roomId, String roomType, double roomRent,
			String roomNumber) throws HotelException {

		Room newRoom = new Room(); // create Hotel object
		return adminDao.addRoom(hotelId, newRoom); // add new room in the roomList of the hotel
	}

	public boolean removeRoom(Long cityId,Long hotelId,
			Long roomId) {

		return adminDao.removeRoom(hotelId, roomId);

	}

	@Override
	public boolean addBooking(Long cityId, Long hotelId,
			Long roomId, Booking booking) throws HotelException {
		return adminDao.addBooking(cityId, hotelId, roomId, booking);
	}

	public Map<Long, City> showCity() {
		return adminDao.getCityList();
	}

	public Map<Long, Hotel> showHotel(Long cityId) throws HotelException {
		Map<Long, City> cityMap = adminDao.getCityList();
		City city = cityMap.get(cityId);
		return adminDao.showHotel(cityId);
	}

	public Map<Long, Room> showRoom(Long cityId, Long hotelId) {
		Map<Long, City> cityMap = adminDao.getCityList();
		City city = cityMap.get(cityId);
		Map<Long, Hotel> hotelMap = city.getHotelList();
		Hotel hotel = hotelMap.get(hotelId);
		return hotel.getRoomList();
	}

	@Override
	public boolean addHotel(Long cityId,String hotelName,
			String hotelAddress, String hotelPhoneNumber, float hotelRating)
			throws HotelException {
		Hotel hotel = new Hotel();
		hotel.setHotelName(hotelName);
		hotel.setHotelAddress(hotelAddress);
		hotel.setHotelPhoneNumber(Long.valueOf(Long.parseLong(hotelPhoneNumber)));
		hotel.setHotelRating(hotelRating);
		adminDao.addHotel(cityId,hotel);
		return true;
	}

	@Override
	public boolean updateHotel(Long cityId, Long hotelId,
			String hotelName) throws HotelException {
		return adminDao.updateHotel(cityId, hotelId, hotelName);
	}

	@Override
	public boolean updateRoom(Long cityId, Long hotelId,
			Long roomId, String roomType) throws HotelException {
		return adminDao.updateRoom(cityId, hotelId, roomId, roomType);
	}

//	public boolean updateHotel(Long cityId, Long hotelId,
//			String hotelName) {
//		return adminDao.updateHotel(cityId, hotelId, hotelName);
//	}
//	@Override
//	public boolean updateRoom(Long cityId, Long hotelId,
//			Long roomId, String roomType) {
//		return adminDao.updateRoom(cityId, hotelId, roomId, roomType);
//	}

}