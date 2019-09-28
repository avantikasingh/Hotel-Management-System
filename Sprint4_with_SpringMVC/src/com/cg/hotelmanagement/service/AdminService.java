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

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("adminService")
@Transactional

public class AdminService implements IAdminService {

	@Autowired
	AdminDao adminDao;

	@Override
	public boolean addCity(City city) throws Exception {
		city.setDeleteFlag(0);
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
		newRoom.setRoomNumber(roomNumber);
		newRoom.setRoomRent(roomRent);
		newRoom.setRoomType(roomType);
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

	public List<City> showCity() {
		return adminDao.getCityList();
	}

	public List<Hotel> showHotel(Long cityId) throws HotelException {
		
		List<City> cityMap = adminDao.getCityList();
		for(City c:cityMap)
		{
			if(c.getCityId()==cityId)
			{
				return c.getHotelList();
			}
		}
		
		return null;
	}

	public List<Room> showRoom(Long cityId, Long hotelId) {
		
		List<City> cityMap = adminDao.getCityList();
		for(City c:cityMap)
		{
			if(c.getCityId()==cityId)
			{
				List<Hotel> hotelList=c.getHotelList();
				
				for(Hotel hotel:hotelList)
				{
					if(hotel.getHotelId()==hotelId)
						return hotel.getRoomList();
				}
			}
			
		}
		return null;
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

	@Override
	public void makeBooking(Long cityId, Long hotelId, Date checkIn, Date checkOut, Long roomId, Long userId) {
		adminDao.makeBooking(cityId, hotelId, checkIn, checkOut, roomId, userId);
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