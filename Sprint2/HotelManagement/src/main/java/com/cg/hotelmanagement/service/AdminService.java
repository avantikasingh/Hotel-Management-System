package com.cg.hotelmanagement.service;

import com.cg.hotelmanagement.dao.AdminDao;
import com.cg.hotelmanagement.dao.IAdminDao;
import com.cg.hotelmanagement.dto.*;
import com.cg.hotelmanagement.exception.HotelException;

import java.math.BigInteger;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class AdminService implements IAdminService {

	IAdminDao adminDao = new AdminDao();

	@Override
	public boolean addCity(BigInteger cityId, String cityName) throws Exception {
		City city = new City(cityName, cityId, new HashMap<BigInteger, Hotel>());
		return adminDao.addCity(city);
	}

	// public boolean addCity(){
	// return adminDao.addCity();
	// }

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

		Room newRoom = new Room(roomId, roomType, roomRent, roomNumber,
				new LinkedList<Booking>()); // create Hotel object
		return adminDao.addRoom(hotelId, newRoom); // add new room in
															// the roomList of
															// the hotel
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

	public Map<BigInteger, Hotel> viewHotels(Date checkIn, Date checkOut,
			BigInteger cityId, boolean sortByRating) {
		return adminDao.viewHotels(checkIn, checkOut, cityId, sortByRating);
	}

	// @Override
	// public boolean addRoom() {
	// return adminDao.addRoom();
	// }
	//
	// @Override
	// public boolean addHotel() {
	// return adminDao.addHotel();
	// }

	public Map<BigInteger, City> showCity() {
		return adminDao.getCityList();
	}

	public Map<BigInteger, Hotel> showHotel(BigInteger cityId) {
		Map<BigInteger, City> cityMap = adminDao.getCityList();
		City city = cityMap.get(cityId);
		return city.getHotelList();
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
		adminDao.addHotel(cityId,hotel);
		return true;
	}

	/*public void updateHotel(BigInteger cityId, BigInteger hotelId,
			String hotelName) {
		adminDao.updateHotel(cityId, hotelId, hotelName);
	}

	@Override
	public void updateRoom(BigInteger cityId, BigInteger hotelId,
			BigInteger roomId, String roomType) {
		adminDao.updateRoom(cityId, hotelId, roomId, roomType);

	}*/

}
