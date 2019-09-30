package com.cg.hotelmanagement.controller;

import java.util.List;
import java.util.Map;

import javax.sound.midi.Soundbank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cg.hotelmanagement.dto.City;
import com.cg.hotelmanagement.dto.Hotel;
import com.cg.hotelmanagement.dto.Room;
import com.cg.hotelmanagement.service.AdminService;
import com.cg.hotelmanagement.service.IAdminService;


@Controller
public class AdminController {

	@Autowired
	IAdminService adminService;

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String adminPage() {
		return "AdminPage";
	}

	@RequestMapping(value = "/addcity", method = RequestMethod.GET)
	public String addCity(@ModelAttribute("city") City city) {
		return "AddCityPage";
	}

	@RequestMapping(value = "/pagesubmitaddcitypage", method = RequestMethod.POST)
	public String addCityData(@ModelAttribute("city") City city) throws Exception {
		adminService.addCity(city);
		return "AdminPage";

	}

	@RequestMapping(value = "/addhotel", method = RequestMethod.GET)
	public String addHotel(@ModelAttribute("hotel") Hotel hotel) {
		return "AddHotelPage";
	}

	@RequestMapping(value = "/pagesubmitaddhotelpage", method = RequestMethod.POST)
	public String addHotelData(@ModelAttribute("hotel") Hotel hotel, @RequestParam("cityid") int cityId)
			throws Exception {
		System.out.println(hotel.toString());
		System.out.println(cityId);
		adminService.addHotel((long) cityId, hotel);
		return "AdminPage";

	}

	@RequestMapping(value = "/addroom", method = RequestMethod.GET)
	public String addRoom(@ModelAttribute("room") Room room) {
		return "AddRoomPage";
	}

	@RequestMapping(value = "/pagesubmitaddroompage", method = RequestMethod.POST)
	public String addRoomData(@ModelAttribute("room") Room room, @RequestParam("cityid") int cityId,
			@RequestParam("hotelid") int hotelId) throws Exception {
		System.out.println(room.toString());
		adminService.addRoom((long) cityId, (long) hotelId, room);
		return "AdminPage";

	}

	@RequestMapping(value = "/showcity", method = RequestMethod.GET)
	public ModelAndView getAllCityData() {
		List<City> myList = adminService.showCity();
		return new ModelAndView("ShowAllCities", "data", myList);
	}
//
//	@RequestMapping(value = "/showhotel", method = RequestMethod.GET)
//	public ModelAndView getAllHotelData() {
//		List<Hotel> myList = adminService.showHotel(cityId);
//		return new ModelAndView("ShowAllHotels", "data", myList);
//	}
//
//	@RequestMapping(value = "/showroom", method = RequestMethod.GET)
//	public ModelAndView getAllRoomData() {
//		List<Room> myList = adminService.showRoom(cityId, hotelId);
//		return new ModelAndView("ShowAllRooms", "data", myList);
//	}
	

	@RequestMapping(value = "/deletecity", method = RequestMethod.GET)
	public String deleteCity() {
		return "DeleteCityPage";

	}

	@RequestMapping(value = "/deletecitydata", method = RequestMethod.POST)
	public String deleteCityData(@RequestParam("cityid") int cityId) {
		adminService.removeCity((long)cityId);
//		return "redirect:/showall";
		return "AdminPage";
	}

	@RequestMapping(value = "/deletehotel", method = RequestMethod.GET)
	public String deleteHotel() {
		return "DeleteHotelPage";

	}

	@RequestMapping(value = "/deletehoteldata", method = RequestMethod.POST)
	public String deleteHotelData(@RequestParam("cityid") int cityId,@RequestParam("hotelid") int hotelId) {
		adminService.removeHotel((long)cityId, (long)hotelId);
		return "AdminPage";
	}

	@RequestMapping(value = "/deleteroom", method = RequestMethod.GET)
	public String deleteCityPage() {
		return "DeleteRoomPage";

	}

	@RequestMapping(value = "/deleteroomdata", method = RequestMethod.POST)
	public String deleteRoomData(@RequestParam("cityid") int cityId,@RequestParam("hotelid") int hotelId,
			@RequestParam("roomid") int roomId) {
		adminService.removeRoom((long)cityId, (long)hotelId, (long)roomId);
		return "AdminPage";
	}

//	@RequestMapping(value = "/showall", method = RequestMethod.GET)
//	public ModelAndView getAllData() {
//		List<Trainee> traineeList = traineeservice.showAllTrainee();
//		return new ModelAndView("ShowAllTrainee", "data", traineeList);
//	}
//
//	@RequestMapping(value = "/search", method = RequestMethod.GET)
//	public String search() {
//		return "SearchTrainee";
//		
//	}
//	
//	@RequestMapping(value = "/showtrainee", method = RequestMethod.POST)
//	public ModelAndView searchTrainee(@RequestParam("tid") int traineeId) {
//		Trainee trainee = traineeservice.searchTrainee(traineeId);
//		return new ModelAndView("SearchTrainee","trainee", trainee);
//		
//	}
//	@RequestMapping(value = "/showdeletetrainee", method = RequestMethod.POST)
//	public ModelAndView searchDeleteTrainee(@RequestParam("tid") int traineeId) {
//		idDelete = traineeId;
//		Trainee trainee = traineeservice.searchTrainee(traineeId);
//		return new ModelAndView("DeleteTrainee","trainee", trainee);
//		
//	}
//	

}
