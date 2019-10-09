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

@Service("adminService")
@Transactional
public class AdminService implements IAdminService {

	@Autowired
	IAdminDao adminDao;
	@Autowired
	CityRepository cityrepo;
	@Autowired
	HotelRepository hotelrepo;

	@Override
	public boolean addCity(City city) throws Exception {
		cityrepo.save(city);
		return true;
	}

	public boolean removeCity(Long cityId) {
		cityrepo.deleteById(cityId);
		return true;
	}

	@Override
	public boolean removeHotel(Long cityId, Long hotelId) {
		 hotelrepo.deleteById(hotelId);
		 return true;
	}

	public boolean addRoom(Long cityId, Long hotelId, Room room) throws HotelException {
		return adminDao.addRoom(hotelId, room); // add new room in the roomList of the hotel
	}

	public boolean removeRoom(Long cityId, Long hotelId, Long roomId) {

		return adminDao.removeRoom(hotelId, roomId);

	}

	@Override
	public boolean addBooking(Long cityId, Long hotelId, Long roomId, Booking booking) throws HotelException {
		return adminDao.addBooking(cityId, hotelId, roomId, booking);
	}

	public List<City> showCity() {
		return adminDao.getCityList();
	}

	public List<Hotel> showHotel(Long cityId) throws HotelException {

		List<City> cityMap = adminDao.getCityList();
		for (City c : cityMap) {
			if (c.getCityId() == cityId) {
				return c.getHotelList();
			}
		}

		return null;
	}

	public List<Room> showRoom(Long cityId, Long hotelId) {

		List<City> cityMap = adminDao.getCityList();
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
//		adminDao.addHotel(cityId, hotel);
//		hotelrepo.save(hotel,cityId);
		City city = cityrepo.findById(cityId).orElse(null);
		if(city!=null) {
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
		City city = cityrepo.findById(cityId).orElse(null);
		List<Hotel> hotelList = city.getHotelList();
		for (Hotel hotel2 : hotelList) {
			if (hotel2.getHotelId() == hotel.getHotelId())
			{
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
		return adminDao.updateRoom(cityId, hotelId, room);
	}

	@Override
	public void makeBooking(Long cityId, Long hotelId, Date checkIn, Date checkOut, Long roomId, Long userId) {
		adminDao.makeBooking(cityId, hotelId, checkIn, checkOut, roomId, userId);
	}

	@Override
	public Hotel viewHotel(Integer hotelId) {
		return adminDao.viewHotel(hotelId);
	}

	@Override
	public Room viewSingleRoom(long roomId) {
		// TODO Auto-generated method stub
		return adminDao.viewSingleRoom(roomId);
	}

	@Override
	public int authenticateUser(String username, String password) {
		return adminDao.authenticateUser(username, password);
	}

	@Override
	public boolean register(Customer customer) throws HotelException {
		return adminDao.register(customer);
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