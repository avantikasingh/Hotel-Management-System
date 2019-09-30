package com.cg.hotelmanagement.service;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.hotelmanagement.dao.IAdminDao;
import com.cg.hotelmanagement.dto.Booking;
import com.cg.hotelmanagement.dto.City;
import com.cg.hotelmanagement.dto.Hotel;
import com.cg.hotelmanagement.dto.Room;
import com.cg.hotelmanagement.exception.HotelException;


@Service("adminService")
@Transactional
public class AdminService implements IAdminService {

	@Autowired
	IAdminDao adminDao;

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
			Room room) throws HotelException {
		return adminDao.addRoom(hotelId, room); // add new room in the roomList of the hotel
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
	public boolean addHotel(Long cityId, Hotel hotel)
			throws HotelException {
		adminDao.addHotel(cityId,hotel);
		return true;
	}

	@Override
	public boolean updateHotel(Long cityId, Hotel hotel) throws HotelException {
		return adminDao.updateHotel(cityId, hotel);
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

	@Override
	public Hotel viewHotel(Integer hotelId) {
		return adminDao.viewHotel(hotelId);
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