package com.cg.hotelmanagement.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cg.hotelmanagement.dto.Booking;
import com.cg.hotelmanagement.dto.City;
import com.cg.hotelmanagement.dto.Customer;
import com.cg.hotelmanagement.dto.Hotel;
import com.cg.hotelmanagement.dto.Room;
import com.cg.hotelmanagement.exception.HotelException;
import com.cg.hotelmanagement.service.ICustomerService;

/**
 * 
 * @author Avantika
 *
 */

@Controller
public class CustomerController {

	@Autowired
	ICustomerService customerService;
	@Autowired
	HttpSession session;

	@RequestMapping(value = "customer", method = RequestMethod.GET)
	public String customerPage(Map<String, Object> model) {

		List<City> cityList = customerService.getCityList();
		System.out.println(cityList);
		model.put("cityList", cityList);
		return "CustomerHomePage";

	}

	@RequestMapping(value = "viewHotelsPage", method = RequestMethod.POST)
	public String viewHotelsPage(@RequestParam("checkIn") String checkin, @RequestParam("checkOut") String checkout,
			@RequestParam("cityname") String cityName, Map<String, Object> model) {

		session.setAttribute("checkin", checkin);
		session.setAttribute("checkout", checkout);
		session.setAttribute("cityName", cityName);

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

		LocalDate checkinDate = LocalDate.parse(checkin, formatter);
		LocalDate checkoutDate = LocalDate.parse(checkout, formatter);

		Map<Hotel, List<Room>> availableRooms = customerService.availableRooms(checkinDate, checkoutDate, cityName);
		model.put("AvailableRooms", availableRooms);
		model.put("cityName", cityName);
		model.put("checkin", checkinDate);
		model.put("checkout", checkoutDate);
		return "viewHotelsPage";

	}
	
	
	@RequestMapping(value = "/ViewBooking", method = RequestMethod.GET)
	public String viewBooking(Map<String, Object> model)  {
		System.out.println("in view booking");
		String username=session.getAttribute("username").toString();
		String password=session.getAttribute("password").toString();
		
		Customer customer=customerService.getCustomer(username, password);
		model.put("booking",customer.getBooking());
		
		return "BookingPage";
	}
	
	

	@RequestMapping(value = "/BookingPage", method = RequestMethod.POST)
	public String makeBooking(@RequestParam("hotelid") Long hotelId, @RequestParam("roomid") Long roomId,
			Map<String, Object> model) throws HotelException {

		System.out.println("In make booking");
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

		LocalDate checkinDate = LocalDate.parse(session.getAttribute("checkin").toString(), formatter);
		LocalDate checkoutDate = LocalDate.parse(session.getAttribute("checkout").toString(), formatter);

		Long cityId = null;
		System.out.println(session.getAttribute("cityName"));
		List<City> cityList = customerService.getCityList();
		for (City city : cityList) {
			System.out.println(city.getCityName());
			if (city.getCityName().equalsIgnoreCase(session.getAttribute("cityName").toString()))
			{	
				
				cityId = city.getCityId();
				System.out.println("cityid"+cityId);
			}
		}
		System.out.println(cityId+"cityId");
		System.out.println(hotelId+"hotelId");
		List<Room> roomList = customerService.showRoom(cityId, hotelId);
		System.out.println(roomList);
		Room selectedRoom = null;
		for (Room room : roomList) {
			if (room.getRoomId() == roomId)
				selectedRoom = room;
		}
		System.out.println("ok1");
		Booking booking = new Booking(checkinDate, checkoutDate, selectedRoom, 0);
		System.out.println("ok2");
		customerService.makeBooking(booking, session.getAttribute("username").toString(),
				session.getAttribute("password").toString());
		
		System.out.println("ok3");
		System.out.println(booking);
		model.put("booking", booking);

		return "ViewBooking";
	}

}
