package com.cg.hotelmanagement.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cg.hotelmanagement.dto.Booking;
import com.cg.hotelmanagement.dto.City;
import com.cg.hotelmanagement.dto.Hotel;
import com.cg.hotelmanagement.dto.Room;
import com.cg.hotelmanagement.service.ICustomerService;

@Controller

public class CustomerController {

	@Autowired
	ICustomerService customerService;

	@RequestMapping(value = "customer", method = RequestMethod.GET)
	public String customerPage(Map<String,Object> model){
		List<City> cityList = customerService.getCityList();
		System.out.println(cityList);
		model.put("cityList", cityList);
		return "CustomerHomePage";

	}

	@RequestMapping(value = "viewHotelsPage", method = RequestMethod.POST)
	public String viewHotelsPage(@RequestParam("checkIn") String checkin, @RequestParam("checkOut") String checkout,
			@RequestParam("cityname") String cityName,Map<String,Object> model) {

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

		LocalDate checkinDate = LocalDate.parse(checkin, formatter);
		LocalDate checkoutDate = LocalDate.parse(checkout, formatter);
		
		Map<Hotel,List<Room>> availableRooms= customerService.availableRooms(checkinDate, checkoutDate, cityName);
		System.out.println(availableRooms);
		model.put("AvailableRooms", availableRooms);
		model.put("cityName", cityName);
		model.put("checkin", checkinDate);
		model.put("checkout", checkoutDate);
		return "viewHotelsPage";

	}

}
