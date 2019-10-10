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
	public boolean addCity(City city) throws HotelException {
//		Add a new city in the database
		try {
			cityrepo.save(city);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			throw new HotelException("Unable to add city");
		}
	}

	public boolean removeCity(Long cityId) throws HotelException {
//		Delete the city from the database
		try {
			cityrepo.deleteById(cityId);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			throw new HotelException("Unable to remove city");
		}
	}

	@Override
	public boolean removeHotel(Long cityId, Long hotelId) throws HotelException {
//		Remove hotel from the database
		try {
			hotelrepo.deleteById(hotelId);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			throw new HotelException("Unable to remove hotel");
		}
	}

	public boolean addRoom(Long cityId, Long hotelId, Room room) throws HotelException {
//		Add a new room in the hotel based on cityid and hotelid
		try {
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

		} catch (Exception e) {
			// TODO: handle exception
			throw new HotelException("Unable to add room");
		}
	}

	public boolean removeRoom(Long cityId, Long hotelId, Long roomId) throws HotelException {
//		Deletes a room from the database based on the roomId
		try {
			Room room = roomrepo.findById(roomId).orElse(null);
			Hotel hotel = room.getHotel();
			City city = hotel.getCity();
			if(city!=null && hotel!=null && city.getCityId()==cityId && hotel.getHotelId()==hotelId) {
				roomrepo.delete(room);
				return true;
			}
		} catch (Exception e) {
			throw new HotelException("Unable to remove room");
		}
		return false;

	}

	@Override
//	public boolean addBooking(Long cityId, Long hotelId, Long roomId, Booking booking) throws HotelException {
//		return adminDao.addBooking(cityId, hotelId, roomId, booking);
//	}

	public List<City> showCity() throws HotelException {
//		Returns a list containing all the cities 
		try {
			List<City> city = cityrepo.findAll();
			return city;
		} catch (Exception e) {
			// TODO: handle exception
			throw new HotelException("Unable to show city");
		}
	}

	public List<Hotel> showHotel(Long cityId) throws HotelException {
//		Returns a list of all the hotels in a city
		try {
			List<City> cityMap = cityrepo.findAll();
			for (City c : cityMap) {
				if (c.getCityId() == cityId) {
					return c.getHotelList();
				}
			}

			return null;
		} catch (Exception e) {
			// TODO: handle exception
			throw new HotelException("Unable to show hotel");
		}
	}

	public List<Room> showRoom(Long cityId, Long hotelId) throws HotelException {
//		returns a list of rooms in a hotel in a city
		try {
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
		} catch (Exception e) {
			// TODO: handle exception
			throw new HotelException("Unable to show Room");
		}
	}

	@Override
	public boolean addHotel(Long cityId, Hotel hotel) throws HotelException {
//		Add a new hotel in the database in existing city
		try {
			City city = cityrepo.findById(cityId).orElse(null);
			if (city != null) {
				List<Hotel> hotelList = city.getHotelList();
				hotelList.add(hotel);
				city.setHotelList(hotelList);
				hotel.setCity(city);
				cityrepo.save(city);
				return true;
			}
			return false;
		} catch (Exception e) {
			// TODO: handle exception
			throw new HotelException("Unable to add hotel");
		}
	}

	@Override
	public boolean updateHotel(Long cityId, Hotel hotel) throws HotelException {
//		Update the credentials of existing hotel
		try {
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
		} catch (Exception e) {
			// TODO: handle exception
			throw new HotelException("Unable to update hotel");
		}
	}

	@Override
	public boolean updateRoom(Long cityId, Long hotelId, Room room) throws HotelException {
//		Update the credentials of existing room

		try {
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
		} catch (Exception e) {
			// TODO: handle exception
			throw new HotelException("Unable to update room");
		}
	}

//	@Override
//	public void makeBooking(Long cityId, Long hotelId, Date checkIn, Date checkOut, Long roomId, Long userId) {
//		adminDao.makeBooking(cityId, hotelId, checkIn, checkOut, roomId, userId);
//	}

	@Override
	public Hotel viewHotel(Long hotelId) throws HotelException {
//		Returns a hotel based on the hotelId
		try {
			Hotel hotel = (Hotel) hotelrepo.findById(Long.valueOf(hotelId)).orElse(null);
			return hotel;
		} catch (Exception e) {
			// TODO: handle exception
			throw new HotelException("No hotel found");
		}
	}

	@Override
	public Room viewSingleRoom(long roomId) throws HotelException {
//		Returns a single room object based on the id supplied
		// TODO Auto-generated method stub
		try {
			Room room = (Room) roomrepo.findById(roomId).orElse(null);
			return room;
		} catch (Exception e) {
			// TODO: handle exception
			throw new HotelException("No room found");
		}
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