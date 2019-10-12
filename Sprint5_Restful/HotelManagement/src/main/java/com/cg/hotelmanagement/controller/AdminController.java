package com.cg.hotelmanagement.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.cg.hotelmanagement.dto.Booking;
import com.cg.hotelmanagement.dto.City;
import com.cg.hotelmanagement.dto.Customer;
import com.cg.hotelmanagement.dto.Hotel;
import com.cg.hotelmanagement.dto.Room;
import com.cg.hotelmanagement.exception.HotelException;
import com.cg.hotelmanagement.service.IAdminService;
import com.cg.hotelmanagement.service.ICustomerService;

import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping(value = "/admin")
public class AdminController {

	@Autowired
	HttpSession session;
	@Autowired
	IAdminService adminService;
	@Autowired
	ICustomerService customerService;

	Long cityID = null;
	Long hotelID = null;
	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);

	@PostMapping(value = "/register")
	public ResponseEntity<Customer> registerUser(@ModelAttribute Customer customer) throws HotelException {
		try {
			customerService.register(customer);
			logger.info("Customer registered: " + customer.getUsername());
			return new ResponseEntity<Customer>(customer, HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("Error in register user controller");
			return new ResponseEntity("User not Registered", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(value = "/loginpage", method = RequestMethod.POST)
	public ModelAndView checkLogin(@RequestParam("username") String username,
			@RequestParam("password") String password) {

		session.setAttribute("username", username);
		session.setAttribute("password", password);

		System.out.println(session.getAttribute("username"));

		int value = customerService.authenticateUser(username, password);
		System.out.println("value :" + value);

		if (value == 1) {
			return new ModelAndView("AdminPage", "session", session);

		}
		if (value == 0) {
			return new ModelAndView("Customer", "session", session);
		}
		if (value == -1) {
			return new ModelAndView("LoginPage", "session", null);
		}
		return new ModelAndView("LoginPage", "session", null);
	}

	@PostMapping(value = "/addcity")
	public ResponseEntity<City> addCityData(@ModelAttribute("city") City city) throws Exception {
		try {
			adminService.addCity(city);
			logger.info("City added: " + city.getCityName());
			return new ResponseEntity<City>(city, HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("Error in add city controller");
			return new ResponseEntity("City not added", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping(value = "/addhotel")
	public ResponseEntity<Hotel> addHotelData(@Valid @ModelAttribute("hotel") Hotel hotel, BindingResult result,
			@RequestParam("cityid") int cityId) throws Exception {
		try {
			adminService.addHotel((long) cityId, hotel);
			logger.info("Hotel registered: " + hotel.getHotelId());
			return new ResponseEntity<Hotel>(hotel, HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("Error in add hotel controller");
			return new ResponseEntity("Hotel not added", HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@PostMapping(value = "/addroom")
	public ResponseEntity<Room> addRoomData(@ModelAttribute Room room, @RequestParam("cityid") int cityId,
			@RequestParam("hotelid") int hotelId) throws Exception {
		try {
			adminService.addRoom((long) cityId, (long) hotelId, room);
			logger.info("Room  registered: " + room.getRoomId());
			return new ResponseEntity<Room>(room, HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("Error in add room controller");
			return new ResponseEntity("Room not added", HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@GetMapping(value = "/showcity")
	public ResponseEntity<List<City>> getAllCityData() throws HotelException {
		List<City> cityList = adminService.showCity();
		try {
			logger.info("All cities showed");
			return new ResponseEntity<List<City>>(cityList, HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("Error in show city controller");
			return new ResponseEntity("No City Found", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping(value = "/showhotel")
	public ResponseEntity<List<Hotel>> showHotelData(@RequestParam("cityid") int cityId) throws HotelException {
		List<Hotel> hotelList = adminService.showHotel((long) cityId);
		try {
			// TODO: handle exception
			logger.info("All hotels showed");
			return new ResponseEntity<List<Hotel>>(hotelList, HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("Error in show hotel controller");
			return new ResponseEntity("Hotel not available", HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@PostMapping(value = "/showroom")
	public ResponseEntity<List<Room>> showRoomData(@RequestParam("cityid") int cityId,
			@RequestParam("hotelid") int hotelId) throws HotelException {
		List<Room> roomList = adminService.showRoom((long) cityId, (long) hotelId);
		try {
			// TODO: handle exception
			logger.info("All Rooms showed");
			return new ResponseEntity<List<Room>>(roomList, HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("Error in show room controller");
			return new ResponseEntity("Room not available", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping(value = "/deletecity")
	public ResponseEntity deleteCityData(@RequestParam("cityid") int cityId) throws HotelException {
		try {
			adminService.removeCity((long) cityId);
			logger.info("City Deleted" + cityId);
			return new ResponseEntity("City deleted", HttpStatus.OK);
		} catch (Exception e) {
			logger.error("Error in delete city controller");
			return new ResponseEntity("City not Deleted", HttpStatus.INTERNAL_SERVER_ERROR);

		}
	}

	@PostMapping(value = "/deletehotel")
	public ResponseEntity deleteHotelData(@RequestParam("cityid") int cityId, @RequestParam("hotelid") int hotelId)
			throws HotelException {
		try {
			adminService.removeHotel((long) cityId, (long) hotelId);
			logger.info("Hotel deleted " + hotelId);
			return new ResponseEntity("Hotel deleted", HttpStatus.OK);
		} catch (Exception e) {
			logger.error("Error in delete hotel controller");
			return new ResponseEntity("Hotel not Deleted", HttpStatus.INTERNAL_SERVER_ERROR);

		}
	}

	@PostMapping(value = "/deleteroom")
	public ResponseEntity deleteRoomData(@RequestParam("cityid") int cityId, @RequestParam("hotelid") int hotelId,
			@RequestParam("roomid") int roomId) throws HotelException {
		try {
			adminService.removeRoom((long) cityId, (long) hotelId, (long) roomId);
			logger.info("Deleted Room" + roomId);
			return new ResponseEntity("Room delted", HttpStatus.OK);
		} catch (Exception e) {
			logger.error("Error in delete room controller");
			return new ResponseEntity("Room not Updated", HttpStatus.INTERNAL_SERVER_ERROR);

		}
	}

////	@RequestMapping(value = "/updatehotelview", method = RequestMethod.GET)
//	public ModelAndView viewHotelModifyDetails(@RequestParam("hotelid") Integer hotelId,
//			@RequestParam("cityid") Long cityid, @ModelAttribute("hoteldata") Hotel hotel) throws HotelException {
//		try {
//			cityID = cityid;
//			return new ModelAndView("UpdateHotelPage", "HotelData", adminService.viewHotel((long) hotelId));
//		} catch (Exception e) {
//			// TODO: handle exception
//			throw new HotelException("Unable to Find Hotel");
//		}
//	}

	@PostMapping(value = "/updatehotel")
	public ResponseEntity<Hotel> updateHotel(@ModelAttribute Hotel hotel) throws HotelException {
		try {
			adminService.updateHotel(cityID, hotel);
			cityID = null;
			logger.info("Hotel Updated: " + hotel.getHotelId());
			return new ResponseEntity<Hotel>(hotel, HttpStatus.OK);

		} catch (Exception e) {
			logger.error("Error in update controller");
			return new ResponseEntity("Hotel not Updated", HttpStatus.INTERNAL_SERVER_ERROR);

		}

	}

//	@RequestMapping(value = "/updateroomview", method = RequestMethod.GET)
//	public ModelAndView viewRoomModifyDetails(@RequestParam("cityid") Long cityid,
//			@RequestParam("hotelid") Long hotelid, @RequestParam("roomid") Long roomid,
//			@ModelAttribute("roomdata") Room room) throws HotelException {
//		try {
//			cityID = cityid;
//			hotelID = hotelid;
//			return new ModelAndView("UpdateRoomPage", "RoomData", adminService.viewSingleRoom(roomid));
//		} catch (Exception e) {
//			// TODO: handle exception
//			throw new HotelException("Unable to Find Room");
//		}
//	}

	@PostMapping(value = "/updateroom")
	public ResponseEntity<Room> updateRoom(@ModelAttribute Room room) throws HotelException {
		try {
			adminService.updateRoom(cityID, hotelID, room);
			cityID = null;
			hotelID = null;
			logger.info("Room update " + room.getRoomId());
			return new ResponseEntity<Room>(room, HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("Error in update room controller");
			return new ResponseEntity("Room not Updated", HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

}
