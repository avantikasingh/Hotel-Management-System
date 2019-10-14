/*
 * 
 * 
 */

package com.cg.hotelmanagement.service;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.hotelmanagement.dto.City;
import com.cg.hotelmanagement.dto.Customer;
import com.cg.hotelmanagement.dto.Hotel;
import com.cg.hotelmanagement.dto.Room;
import com.cg.hotelmanagement.exception.ResourceNotFoundException;
import com.cg.hotelmanagement.repository.CityRepository;
import com.cg.hotelmanagement.repository.CustomerRepository;
import com.cg.hotelmanagement.repository.HotelRepository;
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
	@Autowired
	CustomerRepository customerRepo;
	
	
	private final static String cityNotFound = "City not found with Id: ";
	private final static String hotelNotFound = "Hotel not found with Id: ";
	private final static String roomNotFound = "Room not found with Id: ";
	
	private static final Logger logger = LoggerFactory.getLogger(AdminService.class);

	
	//-------------City-------------------------
	
	/**
	 * Returns a list containing all the cities
	 */
	@Override
	public List<City> showCity() { 
		List<City> cityList = cityrepo.findAll();
		//If no cities exist
		if(cityList==null) {
			logger.error("City not found in showCity()");
			throw new ResourceNotFoundException("No cities found");
		}
		logger.info("showCity method");
		return cityList;
	}
	
	/**
	 * Find city by cityId
	 */
	@Override
	public City findCityById(Long cityId) {
		//First check if city with given id exists
		City city = cityrepo.findById(cityId).orElse(null);
		//If city not found
		if(city==null) {
			logger.error("City not found in findCityById method");
			throw new ResourceNotFoundException(cityNotFound+cityId);
		}
		logger.info("FindCityById method");
		return city;
	}
	
	/**
	 * Add a new city in the database
	 */
	@Override
	public City addCity(City city) {
		//Add city
		cityrepo.save(city);
		logger.info("City addded");
		return city;
	}

	/**
	 * Delete the city from the database
	 */
	@Override
	public boolean removeCity(Long cityId) {
		//First check if city with given id exists
		City city = cityrepo.findById(cityId).orElse(null);
		//If city not found
		if(city==null) {
			logger.error("City not found in removeCity method");
			throw new ResourceNotFoundException(cityNotFound+cityId);
		}
		//Delete city
		cityrepo.deleteById(cityId);
		logger.info("City removed with Id: "+cityId);
		return true;
	}
	

	
	//-------------Hotel-------------------------
	
	/**
	 * Returns a list of all the hotels in a city
	 */
	@Override
	public List<Hotel> showHotels(Long cityId) {
		//First check if city with given id exists
		City city = cityrepo.findById(cityId).orElse(null);
		//If city not found
		if(city==null) {
			logger.error("City not found in showHotels method");
			throw new ResourceNotFoundException(cityNotFound+cityId);
		}
		//Check if hotelList is not empty
		if(city.getHotelList()==null) {
			logger.error("No hotels in given city");
			System.out.println("1");
			throw new ResourceNotFoundException("No hotels in given city: "+cityId);
		}
		System.out.println(city.getHotelList());
		return city.getHotelList();
	}
	
	/**
	 * Returns a hotel based on the hotelId
	 */
	@Override
	public Hotel viewSingleHotel(Long hotelId) {
		//First check if hotel with given id exists
		Hotel hotel = hotelrepo.findById(Long.valueOf(hotelId)).orElse(null);
		//If hotel not found
		if(hotel==null) {
			logger.error("Hotel not found in viewSingleHotel method");
			throw new ResourceNotFoundException(hotelNotFound+hotelId);
		}
		return hotel;
	}
	
	/**
	 * Add a new hotel in the database in existing city
	 */
	@Override
	public boolean addHotel(Long cityId, Hotel hotel){	
		//Validate fields
		//Throws exception if mobile number is not valid
		//Validate.validateMobileNumber(hotel.getHotelPhoneNumber());
		
		//First check if city with given id exists
		City city = cityrepo.findById(cityId).orElse(null);
		System.out.println("4");
		//If city not found
		if(city==null) {
			System.out.println("3");
			logger.error("City not found in addHotel method");
			throw new ResourceNotFoundException(cityNotFound+cityId);
		}
		else {
			//Retrieve hotelList from city
			List<Hotel> hotelList = city.getHotelList();
			//Add hotel to list and set the updated list in city
			hotelList.add(hotel);
			hotel.setCity(city);
			hotelrepo.save(hotel);
			city.setHotelList(hotelList);
			//Set city in hotel for Bidirectional mapping
			//Save city
			cityrepo.save(city);
			System.out.println("1");
			//hotelrepo.save(hotel);
			logger.info("Hotel added");
			return true;
		}
	}
	
	/**
	 * Remove hotel from the database
	 */
	@Override
	public boolean removeHotel(Long hotelId) {
		//First check if hotel with given id exists
		Hotel hotel = hotelrepo.findById(hotelId).orElse(null);
		//If hotel not found
		if(hotel==null) {
			logger.error("Hotel not found in removeHotel method");
			throw new ResourceNotFoundException(hotelNotFound+hotelId);
		}
		//delete hotel
		hotelrepo.deleteById(hotelId);
		logger.info("Hotel deleted with Id: "+hotelId);
		return true;
	}
	
	/**
	 * Update hotel
	 */
	@Override
	public boolean updateHotel(Long hotelId, Hotel hotel) {
		//First check if hotel with given id exists
		Hotel hotelTemp = hotelrepo.findById(hotelId).orElse(null);
		//If hotel not found
		if(hotelTemp==null) {
			logger.error("Hotel not found in updateHotel method");
			throw new ResourceNotFoundException(hotelNotFound+hotelId);
		}
		//If it exists set the Id of the updated hotel object and save it
		hotel.setHotelId(hotelTemp.getHotelId());
		hotelrepo.save(hotel);
		logger.info("Hotel updated with Id: "+hotelId);
		return true;
	}	


	//-------------Room-------------------------
	
	/**
	 * Add a new room in the hotel based on cityid and hotelid
	 */
	public boolean addRoom(Long cityId, Long hotelId, Room room) {
		//First check if city with given id exists
		City city = cityrepo.findById(cityId).orElse(null);
		//If city not found
		if(city==null) {
			logger.error("City not found in addRoom method");
			throw new ResourceNotFoundException(cityNotFound+cityId);
		}
		else {
			//Retrieve hotelList from city
			List<Hotel> hotelList = city.getHotelList();
			//Iterate over list to find hotel
			for(Hotel hotel:hotelList) {
				if(hotel.getHotelId()==hotelId) {
					List<Room> roomList = hotel.getRoomList();
					roomList.add(room);
					hotel.setRoomList(roomList);
					hotelrepo.save(hotel);
					//city.setHotelList(hotelList);
					//cityrepo.save(city);
					logger.info("Room added");
					return true;
				}
			}
			//If hotel not found
			logger.error("Hotel not found in addRoom method");
			throw new ResourceNotFoundException(hotelNotFound+hotelId);
		}
	}

	/**
	 * Deletes a room from the database based on the roomId
	 */
	public boolean removeRoom(Long roomId) {
		//First check if room with given id exists
		Room room = roomrepo.findById(roomId).orElse(null);
		//If room not found
		if(room==null) {
			logger.error("Room not found in removeRoom method");
			throw new ResourceNotFoundException(roomNotFound+roomId);
		}
		//delete room
		roomrepo.delete(room);
		logger.info("Room removed with Id: "+roomId);
		return true;
	}
	
	/**
	 * Returns a single room object based on the id supplied
	 */
	@Override
	public Room viewSingleRoom(long roomId) {
		//First check if room with given id exists
		Room room = roomrepo.findById(roomId).orElse(null);
		//If room not found
		if(room==null) {
			logger.error("Room not found in viewSingleRoom method");
			throw new ResourceNotFoundException(roomNotFound+roomId);
		}
		return room;
	}
	
	/**
	 * returns a list of rooms in a hotel in a city
	 */
	public List<Room> showRooms(Long cityId, Long hotelId) {
		//First check if city with given id exists
		City city = cityrepo.findById(cityId).orElse(null);
		//If city not found
		if(city==null) {
			logger.error("City not found in showRooms method");
			throw new ResourceNotFoundException(cityNotFound+cityId);
		}
		else {
			List<Hotel> hotelList = city.getHotelList();
			//check if hotel with given id exists
			for(Hotel hotel:hotelList) {
				if(hotel.getHotelId()==hotelId) {
					logger.info("showRooms method");
					return hotel.getRoomList();
				}
			}
			//If hotel not found
			logger.error("Hotel not found showRooms method");
			throw new ResourceNotFoundException(hotelNotFound+hotelId);
		}
	}

	/**
	 * Update the credentials of existing room
	 */
	@Override
	public boolean updateRoom(Long roomId, Room room) {
		//First check if room with given id exists
		Room roomTemp = roomrepo.findById(roomId).orElse(null);
		//If room not found
		if(room==null) {
			logger.error("Room not found in updateRoom method");
			throw new ResourceNotFoundException(roomNotFound+roomId);
		}
		//If it exists set the Id of the updated room object and save it
		room.setRoomId(roomTemp.getRoomId());
		roomrepo.save(room);
		logger.info("Room updated with Id: "+roomId);
		return true;
	}
	
	
	@Override
	public int authenticateUser(String username, String password) {
		List<Customer> userList=customerRepo.findAll();
		for(Customer c:userList)
		{
			if((c.getUsername()==username)&&(c.getPassword()==password))
			{
				if (c.getRole().equalsIgnoreCase("Admin"))
					return 1;
				else
					return 0;
			}
		}
		return -1;
	}

//	@Override
//	public boolean addBooking(Long cityId, Long hotelId, Long roomId, Booking booking) throws HotelException {
//		return adminDao.addBooking(cityId, hotelId, roomId, booking);
//	}


//	@Override
//	public void makeBooking(Long cityId, Long hotelId, Date checkIn, Date checkOut, Long roomId, Long userId) {
//		adminDao.makeBooking(cityId, hotelId, checkIn, checkOut, roomId, userId);
//	}


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