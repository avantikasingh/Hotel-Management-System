package com.cg.hotelmanagement.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.hotelmanagement.dto.City;
import com.cg.hotelmanagement.dto.Hotel;
import com.cg.hotelmanagement.dto.Room;
import com.cg.hotelmanagement.exception.HotelException;
import com.cg.hotelmanagement.exception.ResourceNotFoundException;
import com.cg.hotelmanagement.service.IAdminService;
import com.cg.hotelmanagement.service.ICustomerService;

@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	IAdminService adminService;
	@Autowired
	ICustomerService customerService;

	Long cityID = null;
	Long hotelID = null;
	
	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
	
	
	//----------------------City--------------------------
	
	/**
	 * Show all cities
	 * @return
	 * @throws HotelException
	 */
	@GetMapping("/cities")
	public List<City> getCities(){
		logger.info("getCities in Controller");
		return adminService.showCity();
	}
	
	/**
	 * Find city by cityId
	 * @param cityId
	 * @return
	 */
	@GetMapping("/cities/{cityId}")
	public City getCity(@PathVariable long cityId) {
		logger.info("getCity in Controller");
		return adminService.findCityById(cityId);
	}
	
	/**
	 * Add city
	 * @param city
	 * @return
	 */
	@PostMapping("/cities")
	public City addCity(@RequestBody City city) {
		logger.info("addCity in Controller");
		return adminService.addCity(city);
	}
	
	/**
	 * Delete city by cityId
	 */
	@DeleteMapping("/cities/{cityId}")
	public boolean deleteCity(@PathVariable long cityId) {
		logger.info("deleteCity in Controller"); 
		return adminService.removeCity(cityId);
	}
	
	@GetMapping("/cities/download")
	public boolean downloadCity() {
		List<City> cityList = customerService.getCityList();
		
		return true;
	}
	
	
	
	//----------------------Hotel--------------------------
	
	//-------Error while displaying in JSON, properly displaying in console from service and controller
	/**
	 * Get all hotels in a city
	 * @param cityId
	 * @return
	 */
	@GetMapping("/hotels/{cityId}")
	public List<Hotel> getHotels(@PathVariable long cityId){
		logger.info("getHotels in Controller");
		List<Hotel> hotelList = adminService.showHotels(cityId);
		if(hotelList==null)
			throw new ResourceNotFoundException("No hotels in city with Id: "+cityId);
		System.out.println(hotelList);
		return hotelList;
	}
	
	/**
	 * Find a hotel using hotelId
	 * @param hotelId
	 * @return
	 */
	@GetMapping("/hotels")
	public Hotel getHotel(@RequestParam long hotelId){
		logger.info("getHotel in Controller");
		return adminService.viewSingleHotel(hotelId);
	}
	
	
	//---------------Audit trail error
	/**
	 * Find hotel by Id
	 * @param cityId
	 * @param hotel
	 * @return
	 * @throws HotelException
	 */
	@PostMapping("/hotels")
	public Hotel addHotel(@RequestParam("cityId") long cityId, @RequestBody Hotel hotel) {
		System.out.println("2");
		adminService.addHotel(cityId, hotel);
		System.out.println(hotel);
		logger.info("addHotel in Controller");
		//City city = hotel.getCity();
		//city.setHotelList(null);
		//hotel.setCity(city);
		hotel.setCity(null);
		return hotel;
	}
	
	/**
	 * Add hotel
	 * @param hotelId
	 * @param hotel
	 * @return
	 */
	@PutMapping("/hotels")
	public Hotel updateHotel(@RequestParam("hotelId") long hotelId, @RequestBody Hotel hotel) {
		adminService.updateHotel(hotelId, hotel);
		logger.info("updateHotel in Controller");
		return hotel;
	}
	
	/**
	 * Delete hotel
	 * @param hotelId
	 * @return
	 */
	@DeleteMapping("/hotels")
	public boolean deleteHotel(@RequestParam("hotelId") long hotelId) {
		logger.info("deleteHotel in Controller");
		return adminService.removeHotel(hotelId);
	}
	
	
	//----------------------Room--------------------------
	
	/**
	 * Get all rooms in a given city and hotel
	 * @param cityId
	 * @param hotelId
	 * @return
	 */
	@GetMapping("/rooms")
	public List<Room> getRooms(@RequestParam("cityId") long cityId, @RequestParam("hotelId") long hotelId){
		logger.info("getRooms in Controller");
		return adminService.showRooms(cityId, hotelId);
	}
	
	/**
	 * Find room by Id
	 * @param roomId
	 * @return
	 */
	@GetMapping("/rooms/{roomId}")
	public Room getRoom(@PathVariable long roomId) {
		logger.info("getRoom in Controller");
		return adminService.viewSingleRoom(roomId);
	}
	
	/**
	 * Add room
	 * @param cityId
	 * @param hotelId
	 * @param room
	 * @return
	 */
	@PostMapping("/rooms")
	public Room addRoom(@RequestParam("cityId") long cityId, @RequestParam("hotelId") long hotelId, @RequestBody Room room) {
		adminService.addRoom(cityId, hotelId, room);
		logger.info("addRoom in Controller");
		return room;
	}
	
	/**
	 * Update room
	 * @param roomId
	 * @param room
	 * @return
	 */
	@PutMapping("/rooms")
	public boolean updateRoom(@RequestParam("roomId") long roomId, @RequestBody Room room) {
		logger.info("updateRoom in Controller");
		return adminService.updateRoom(roomId, room);
	}
	
	/**
	 * Delete room
	 * @param roomId
	 * @return
	 */
	@DeleteMapping("rooms/{roomId}")
	public boolean deleteRoom(@PathVariable long roomId) {
		logger.info("deleteRoom in Controller");
		return adminService.removeRoom(roomId);
	}
	
}
