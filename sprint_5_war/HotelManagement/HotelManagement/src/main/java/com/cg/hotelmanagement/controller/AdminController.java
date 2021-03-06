package com.cg.hotelmanagement.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cg.hotelmanagement.dto.City;
import com.cg.hotelmanagement.dto.Customer;
import com.cg.hotelmanagement.dto.Hotel;
import com.cg.hotelmanagement.dto.Room;
import com.cg.hotelmanagement.exception.HotelException;
import com.cg.hotelmanagement.service.IAdminService;
import com.cg.hotelmanagement.service.ICustomerService;

/**
 * 
 * @author Brighu, Saurabh
 *
 */

@Controller
@RequestMapping(value="/admin")
public class AdminController {

	@Autowired
	HttpSession session;
	@Autowired
	IAdminService adminService;
	@Autowired
	ICustomerService customerService;

	Long cityID = null;
	Long hotelID = null;
//	public AdminController() {
//		// TODO Auto-generated constructor stub
//	}
//	@RequestMapping(value = "/", method = RequestMethod.GET)
//	public String adminPage() {
//		return "AdminPage";
//	}

	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);

	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginPage() {
		return "LoginPage";
	}
	

//	@RequestMapping(value = "/register", method = RequestMethod.GET)
//	public String registerPage(@ModelAttribute("customer") Customer customer) {
//		return "RegisterPage";
//	}
//	
//
//	/**
//	 * @author   Description: Register a new user
//	 * @param customer
//	 * @return LoginPage.jsp
//	 */
//	@RequestMapping(value = "/registerpage", method = RequestMethod.POST)
//	public String registerUser(@ModelAttribute("customer") Customer customer) throws HotelException {
//		customerService.register(customer);
//		return "LoginPage";
//	}

	
	/**
	 * @author   Description: Authenticate a user, and redirect the user to page based on authority
	 * @param username
	 * @param password
	 */
//	@RequestMapping(value = "/loginpage", method = RequestMethod.POST)
//	public ModelAndView checkLogin(@RequestParam("username") String username,
//			@RequestParam("password") String password) {
//
//		session.setAttribute("username", username);
//		session.setAttribute("password", password);
//
//		System.out.println(session.getAttribute("username"));
//
//		int value = customerService.authenticateUser(username, password);
//		//System.out.println("value :" + value);
//
//		if (value == 1) {
//			return new ModelAndView("AdminPage", "session", session);
//
//		}
//		if (value == 0) {
//			return new ModelAndView("Customer", "session", session);
//		}
//		if (value == -1) {
//			return new ModelAndView("LoginPage", "session", null);
//		}
//		return new ModelAndView("LoginPage", "session", null);
//	}

	
	/**
	 * @author
	 * @param city
	 * @return AddCityPage.jsp
	 */
	@RequestMapping(value = "/addcity", method = RequestMethod.GET)
	public String addCity(@ModelAttribute("city") City city) {
		return "AddCityPage";
	}

	
	/**
	 * @author 
	 * Description: Add city
	 * @param city
	 * @return AdminPage.jsp
	 */
	@RequestMapping(value = "/pagesubmitaddcitypage", method = RequestMethod.POST)
	public String addCityData(@ModelAttribute("city") City city) throws Exception {
		try {
			adminService.addCity(city);
			return "AdminPage";
		} catch (Exception e) {
			logger.error("Error in add city controller");
			throw new HotelException("Unable to Show City");
		}
	}
	

	/**
	 * @author 
	 * @param hotel
	 * @return AddHotelPage.jsp
	 */
	@RequestMapping(value = "/addhotel", method = RequestMethod.GET)
	public String addHotel(@ModelAttribute("hotel") Hotel hotel) {
		return "AddHotelPage";
	}
	
	
	/**
	 * @author 
	 * @param hotel
	 * @param cityId
	 * Description: Add hotel
	 * @return AddHotelPage.jsp
	 */
	@RequestMapping(value = "/pagesubmitaddhotelpage", method = RequestMethod.POST)
	public String addHotelData(@Valid @ModelAttribute("hotel") Hotel hotel, BindingResult result,
			@RequestParam("cityid") int cityId) throws Exception {
		try {
			if (result.hasErrors()) {
				logger.error("Error in add hotel controller");
				return "AddHotelPage";
			} else {
				hotel.setDeleteFlag(0);
				adminService.addHotel((long) cityId, hotel);
				return "AdminPage";
			}
		} catch (Exception e) {
			logger.error("Error in add hotel controller");
			throw new HotelException("Unable to perform the operation");
		}

	}
	

	/**
	 * @author 
	 * @param room
	 * Description: Add hotel
	 * @return AddRoomPage.jsp
	 */
	@RequestMapping(value = "/addroom", method = RequestMethod.GET)
	public String addRoom(@ModelAttribute("room") Room room) {
		return "AddRoomPage";
	}
	
	
	/**
	 * @author 
	 * @param room
	 * @param cityid
	 * @param hotelid
	 * Description: Add room
	 * @return AdminPage.jsp
	 */
	@RequestMapping(value = "/pagesubmitaddroompage", method = RequestMethod.POST)
	public String addRoomData(@ModelAttribute("room") Room room, @RequestParam("cityid") int cityId,
			@RequestParam("hotelid") int hotelId) throws Exception {
		
		try {
			adminService.addRoom((long) cityId, (long) hotelId, room);
			return "AdminPage";
		} catch (Exception e) {
			logger.error("Error in add room controller");
			throw new HotelException("Unable to add Room");
		}
	}
	

	/**
	 * @author 
	 * Description: Show all cities
	 * @return ShowAllCities.jsp
	 */
	@RequestMapping(value = "/showcity", method = RequestMethod.GET)
	public ModelAndView getAllCityData() throws HotelException {
		try {
			List<City> myList = adminService.showCity();
			return new ModelAndView("ShowAllCities", "data", myList);
		} catch (Exception e) {
			logger.error("Error in show city controller");
			throw new HotelException("Unable to Show City");
		}
	}
	
	
	/**
	 * @author 
	 * Description: Show hotels
	 * @return ShowHotel.jsp
	 */
	@RequestMapping(value = "/showhotel", method = RequestMethod.GET)
	public String getAllHotelData() {
		return "ShowHotel";
	}
	
	
	/**
	 * @author 
	 * Description: Show hotels
	 * @param cityid
	 * @return ShowHotel.jsp
	 */
	@RequestMapping(value = "/showallhotel", method = RequestMethod.POST)
	public ModelAndView showHotelData(@RequestParam("cityid") int cityId) throws HotelException {
		try {
			List<Hotel> myList = adminService.showHotel((long) cityId);
			return new ModelAndView("ShowHotel", "data", myList);
		} catch (Exception e) {
			logger.error("Error in show hotel controller");
			throw new HotelException("Unable to Show Hotel");
		}
	}
	
	

	/**
	 * @author 
	 * Description: Show hotels
	 * @param cityid
	 * @return ShowRoom.jsp
	 */
	@RequestMapping(value = "/showroom", method = RequestMethod.GET)
	public String getAllRoomData() {
		return "ShowRoom";
	}

	
	/**
	 * @author 
	 * Description: Show rooms
	 * @param cityid
	 * @param hotelid
	 * @return ShowRoom.jsp
	 */
	@RequestMapping(value = "/showallroom", method = RequestMethod.POST)
	public ModelAndView showRoomData(@RequestParam("cityid") int cityId, @RequestParam("hotelid") int hotelId)
			throws HotelException {
		try {
			List<Room> myList = adminService.showRoom((long) cityId, (long) hotelId);
			return new ModelAndView("ShowRoom", "data", myList);
		} catch (Exception e) {
			logger.error("Error in show room controller");
			throw new HotelException("Unable to Show Room");
		}
	}

	
	/**
	 * @author 
	 * Description: Delete city
	 * @return DeleteCityPage.jsp
	 */
	@RequestMapping(value = "/deletecity", method = RequestMethod.GET)
	public String deleteCity() {
		return "DeleteCityPage";
	}

	
	/**
	 * @author 
	 * Description: Delete city
	 * @return AdminPage.jsp
	 */
	@RequestMapping(value = "/deletecitydata", method = RequestMethod.POST)
	public String deleteCityData(@RequestParam("cityid") int cityId) throws HotelException {
		try {
			adminService.removeCity((long) cityId);
			return "AdminPage";
		} catch (HotelException e) {
			logger.error("Error in delete city controller");
			throw new HotelException("Unable to Remove City");			
		}	
	}
	
	
	/**
	 * @author 
	 * Description: Delete hotel
	 * @return DeleteHotelPage.jsp
	 */
	@RequestMapping(value = "/deletehotel", method = RequestMethod.GET)
	public String deleteHotel() {
		return "DeleteHotelPage";
	}
	
	
	/**
	 * @author 
	 * Description: Delete hotel
	 * @param cityid
	 * @param hotelid
	 * @return AdminPage.jsp
	 */
	@RequestMapping(value = "/deletehoteldata", method = RequestMethod.POST)
	public String deleteHotelData(@RequestParam("cityid") int cityId, @RequestParam("hotelid") int hotelId)throws HotelException {
		try {
			adminService.removeHotel((long) cityId, (long) hotelId);
			return "AdminPage";
		} catch (HotelException e) {
			logger.error("Error in delete hotel controller");
			throw new HotelException("Unable to Remove Hotel");
		}	
	}

	
	/**
	 * @author 
	 * Description: Delete room
	 * @return DeleteRoomPage.jsp
	 */
	@RequestMapping(value = "/deleteroom", method = RequestMethod.GET)
	public String deleteCityPage() {
		return "DeleteRoomPage";
	}
	
	
	/**
	 * @author 
	 * Description: Delete room
	 * @param cityid
	 * @param hotelid
	 * @param roomid
	 * @return AdminPage.jsp
	 */
	@RequestMapping(value = "/deleteroomdata", method = RequestMethod.POST)
	public String deleteRoomData(@RequestParam("cityid") int cityId, @RequestParam("hotelid") int hotelId,
			@RequestParam("roomid") int roomId) throws HotelException {
		try {
			adminService.removeRoom((long) cityId, (long) hotelId, (long) roomId);
			return "AdminPage";
		} catch (HotelException e) {
			logger.error("Error in delete room controller");
			throw new HotelException("Unable to Remove Room");
		}
	}
	
	
	/**
	 * @author 
	 * Description: Update hotel
	 * @return UpdateHotelPage.jsp
	 */
	@RequestMapping(value = "/updatehotel", method = RequestMethod.GET)
	public String viewHotelModifyPage(@ModelAttribute("hoteldata") Hotel hotel) {
		return "UpdateHotelPage";
	}
	
	
	/**
	 * @author 
	 * Description: Update hotel
	 * @param cityid
	 * @param hoteldata
	 * @return UpdateHotelPage.jsp
	 */
	@RequestMapping(value = "/updatehotelview", method = RequestMethod.GET)
	public ModelAndView viewHotelModifyDetails(@RequestParam("hotelid") Integer hotelId,
			@RequestParam("cityid") Long cityid, @ModelAttribute("hoteldata") Hotel hotel) throws HotelException {
		try {
			cityID = cityid;
			return new ModelAndView("UpdateHotelPage", "HotelData", adminService.viewHotel((long) hotelId));
		} catch (Exception e) {
			throw new HotelException("Unable to Find Hotel");
		}
	}
	
	
	/**
	 * @author 
	 * Description: Update hotel
	 * @param hoteldata
	 * @return AdminPage.jsp
	 */
	@RequestMapping(value = "/updatehoteldata", method = RequestMethod.POST)
	public String updateHotel(@ModelAttribute("hoteldata") Hotel hotel) throws HotelException {
		try {
			adminService.updateHotel(cityID, hotel);
			cityID = null;
			return "AdminPage";
		} catch (Exception e) {
			logger.error("Error in Update Hotel controller");
			throw new HotelException("Unable to Update Hotel");
		}
	}
	
	

	/**
	 * @author 
	 * Description: Update hotel
	 * @param roomdata
	 * @return UpdateRoomPage.jsp
	 */
	@RequestMapping(value = "/updateroom", method = RequestMethod.GET)
	public String viewRoomModifyPage(@ModelAttribute("roomdata") Room room) {
		return "UpdateRoomPage";
	}

	
	/**
	 * @author 
	 * Description: Update room
	 * @param cityid
	 * @param hotelid
	 * @param roomid
	 * @param room
	 * @return UpdateRoomPage.jsp
	 */
	@RequestMapping(value = "/updateroomview", method = RequestMethod.GET)
	public ModelAndView viewRoomModifyDetails(@RequestParam("cityid") Long cityid,
			@RequestParam("hotelid") Long hotelid, @RequestParam("roomid") Long roomid,
			@ModelAttribute("roomdata") Room room) throws HotelException {
		try {
			cityID = cityid;
			hotelID = hotelid;
			return new ModelAndView("UpdateRoomPage", "RoomData", adminService.viewSingleRoom(roomid));
		} catch (Exception e) {
			logger.error("Error in Update Room controller");
			throw new HotelException("Unable to Find Room");
		}
	}

	
	/**
	 * @author 
	 * Description: Update room
	 * @param roomdata
	 * @return AdminPage.jsp
	 */
	@RequestMapping(value = "/updateroomdata", method = RequestMethod.POST)
	public String updateRoom(@ModelAttribute("roomdata") Room room) throws HotelException {
		try {
			adminService.updateRoom(cityID, hotelID, room);
			cityID = null;
			hotelID = null;
			return "AdminPage";
		} catch (Exception e) {
			logger.error("Error in Update Room controller");
			throw new HotelException("Unable to Update Room");
		}
	}

}
