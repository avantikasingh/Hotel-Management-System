package com.cg.hotelmanagement.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.hotelmanagement.dto.Booking;
import com.cg.hotelmanagement.dto.Customer;
import com.cg.hotelmanagement.dto.Hotel;
import com.cg.hotelmanagement.dto.Room;
import com.cg.hotelmanagement.exception.HotelException;
import com.cg.hotelmanagement.exception.ResourceNotFoundException;
import com.cg.hotelmanagement.repository.BookingRepository;
import com.cg.hotelmanagement.repository.CustomerRepository;
import com.cg.hotelmanagement.service.IAdminService;
import com.cg.hotelmanagement.service.ICustomerService;
import com.cg.hotelmanagement.service.Validate;

@RestController
@RequestMapping("/customer")
@CrossOrigin(origins ="http://localhost:4200")
public class CustomerController {

	@Autowired
	ICustomerService customerService;
	@Autowired
	IAdminService adminService;
	@Autowired
	HttpSession session;
	@Autowired
	CustomerRepository customerRepo;
	@Autowired
	BookingRepository bookingRepo;
	
	/**
	 * Register a new user
	 * @param customer
	 * @return
	 */
	@PostMapping("/register")
	public Customer register(@RequestBody Customer customer) {
		customerService.register(customer);
		return customer;
	}
	
	/**
	 * Returns a Map of available rooms based on checkIn, checkOut and city
	 * @param checkin
	 * @param checkout
	 * @param cityName
	 * @return
	 */
	@GetMapping("/availablerooms")
	public Map<Hotel,List<Room>> availableRooms(@RequestParam("checkIn") String checkIn, @RequestParam("checkOut") String checkOut, @RequestParam("cityId") long cityId){
		LocalDate localDateCheckIn = LocalDate.parse(checkIn);
		LocalDate localDateCheckOut = LocalDate.parse(checkOut);
		if(Validate.validateCheckInCheckOutDate(localDateCheckIn, localDateCheckOut)) {
			//System.out.println(customerService.availableRooms(localDateCheckIn, localDateCheckOut, cityId));
			return customerService.availableRooms(localDateCheckIn, localDateCheckOut, cityId);
		}
		else
			throw new HotelException("Enter valid date");
	}
	
	
	/**
	 * 
	 * @param checkIn
	 * @param checkOut
	 * @param cityId
	 * @param hotelId
	 * @param roomId
	 * @return
	 */
	@PostMapping("/makebooking")
	public Booking makeBooking(@RequestParam("username") String username, @RequestParam("password") String password, @RequestParam("checkIn") String checkIn, @RequestParam("checkOut") String checkOut, @RequestParam("cityId") long cityId,
						@RequestParam("hotelId") long hotelId, @RequestParam("roomId") long roomId) {
							
		Room room = adminService.viewSingleRoom(roomId);
		LocalDate localDateCheckIn = LocalDate.parse(checkIn);
		LocalDate localDateCheckOut = LocalDate.parse(checkOut);
		if(room==null)
			throw new ResourceNotFoundException("Room not found");
		System.out.println(room.getHotel().getCity().getCityId());
		System.out.println(room.getHotel().getHotelId());
		System.out.println(roomId);
		if(room.getHotel().getHotelId()==hotelId && room.getHotel().getCity().getCityId()==cityId) {
			System.out.println("Ok");
			if(customerService.isAvailable(room, localDateCheckIn, localDateCheckOut)) {
				Booking booking = new Booking(localDateCheckIn, localDateCheckOut, room, 0);
				System.out.println(booking);
				Customer customer = customerService.getCustomer(username, password);
				if(customer==null)
					throw new ResourceNotFoundException("Invalid username and password");
				
//				booking.setCustomer(customer);
//				bookingRepo.save(booking);
//				customer.setBooking(booking);
//				customerRepo.save(customer);
				
				
//				customer.setBooking(booking);
//				customerRepo.save(customer);
//				long bookingId = customer.getBooking().getBookingId();
//				booking.setBookingId(bookingId);
//				booking.setCustomer(customer);
//				return booking;
				
				return customerService.makeBooking(booking, username, password);
			
			}
		}
		throw new ResourceNotFoundException("Resource not found");
	}

}
