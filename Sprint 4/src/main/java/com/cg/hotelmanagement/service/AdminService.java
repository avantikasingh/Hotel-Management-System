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
	public boolean addCity(BigInteger cityId, String cityName) throws Exception {
		City city = new City();
		city.setCityName(cityName);
		return adminDao.addCity(city);
	}

	public boolean removeCity(BigInteger cityId) {
		return adminDao.removeCity(cityId);
	}

	@Override
	public boolean removeHotel(BigInteger cityId, BigInteger hotelId) {
		return adminDao.removeHotel(cityId, hotelId);
	}

	public boolean addRoom(BigInteger cityId, BigInteger hotelId,
			BigInteger roomId, String roomType, double roomRent,
			String roomNumber) throws HotelException {

		Room newRoom = new Room(); // create Hotel object
		return adminDao.addRoom(hotelId, newRoom); // add new room in the roomList of the hotel
	}

	public boolean removeRoom(BigInteger cityId,BigInteger hotelId,
			BigInteger roomId) {

		return adminDao.removeRoom(hotelId, roomId);

	}

	@Override
	public boolean addBooking(BigInteger cityId, BigInteger hotelId,
			BigInteger roomId, Booking booking) throws HotelException {
		return adminDao.addBooking(cityId, hotelId, roomId, booking);
	}

	public Map<BigInteger, City> showCity() {
		return adminDao.getCityList();
	}

	public Map<BigInteger, Hotel> showHotel(BigInteger cityId) throws HotelException {
		Map<BigInteger, City> cityMap = adminDao.getCityList();
		City city = cityMap.get(cityId);
		return adminDao.showHotel(cityId);
	}

	public Map<BigInteger, Room> showRoom(BigInteger cityId, BigInteger hotelId) {
		Map<BigInteger, City> cityMap = adminDao.getCityList();
		City city = cityMap.get(cityId);
		Map<BigInteger, Hotel> hotelMap = city.getHotelList();
		Hotel hotel = hotelMap.get(hotelId);
		return hotel.getRoomList();
	}

	@Override
	public boolean addHotel(BigInteger cityId,String hotelName,
			String hotelAddress, String hotelPhoneNumber, float hotelRating)
			throws HotelException {
		Hotel hotel = new Hotel();
		hotel.setHotelName(hotelName);
		hotel.setHotelAddress(hotelAddress);
		hotel.setHotelPhoneNumber(BigInteger.valueOf(Long.parseLong(hotelPhoneNumber)));
		hotel.setHotelRating(hotelRating);
		adminDao.addHotel(cityId,hotel);
		return true;
	}

	@Override
	public boolean updateHotel(BigInteger cityId, BigInteger hotelId,
			String hotelName) throws HotelException {
		return adminDao.updateHotel(cityId, hotelId, hotelName);
	}

	@Override
	public boolean updateRoom(BigInteger cityId, BigInteger hotelId,
			BigInteger roomId, String roomType) throws HotelException {
		return adminDao.updateRoom(cityId, hotelId, roomId, roomType);
	}

//	public boolean updateHotel(BigInteger cityId, BigInteger hotelId,
//			String hotelName) {
//		return adminDao.updateHotel(cityId, hotelId, hotelName);
//	}
//	@Override
//	public boolean updateRoom(BigInteger cityId, BigInteger hotelId,
//			BigInteger roomId, String roomType) {
//		return adminDao.updateRoom(cityId, hotelId, roomId, roomType);
//	}

}