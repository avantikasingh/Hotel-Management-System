package com.cg.hotelmanagement.HotelManagement;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.hotelmanagement.dto.City;
import com.cg.hotelmanagement.dto.Hotel;
import com.cg.hotelmanagement.dto.Room;
import com.cg.hotelmanagement.service.IAdminService;
import com.cg.hotelmanagement.service.ICustomerService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HotelManagementApplicationTests {
	
	
	@Autowired
	IAdminService adminService;
	@Autowired
	ICustomerService customerService;
	
	@Test
	public void testshowCity() {
		List<City> cityList = adminService.showCity();
		assertEquals(1, cityList.size());
	}
	
	@Test
	public void testfindCityById() {
		City city = adminService.findCityById(1l);
		assertNotNull(city);
		//assertEquals("Pune", city.getCityName());
	}
	
	@Test
	public void testaddCity() {
		City city = new City();
		city.setCityName("Banglore");
		assertEquals("Banglore", adminService.addCity(city).getCityName());
	}
	
	@Test
	public void testremoveCity() {
		assertEquals(true, adminService.removeCity(1l));
	}
	
	@Test
	public void testHotels() {
		List<Hotel> hotelList = adminService.showHotels(9l);
		assertEquals(1, hotelList.size());
	}
	
	@Test
	public void testViewSingleHotel() {
		//Hotel hotel = adminService.viewSingleHotel(2l);
		//Test the object
		//assertEquals(1, actual);
	}
	
	@Test
	public void testaddHotel() {
		Hotel hotel = new Hotel();
		hotel.setHotelName("ABC");
		assertEquals(true, adminService.addHotel(1l, hotel));
	}
	
	@Test
	public void testremoveHotel() {
		assertEquals(true, adminService.removeHotel(2l));
	}
	
	@Test
	public void testupdateHotel() {
		assertEquals(true, adminService.updateHotel(2l,new Hotel()));
	}
	
	@Test
	public void testaddRoom() {
		Room room = new Room();
		room.setRoomNumber("1010");
		assertEquals(true, adminService.addRoom(1l, 4l, room));
	}
	
	@Test
	public void testremoveRoom() {
		assertEquals(true, adminService.removeRoom(2l));
	}
	
	@Test
	public void testViewSingleRoom() {
		assertNotNull(adminService.viewSingleRoom(2l));
	}
	
	@Test
	public void testShowRooms() {
		assertEquals(2, adminService.showRooms(1l, 4l).size());
	}
	
	@Test
	public void testupdateRoom() {
		Room room = new Room();
		room.setRoomNumber("2020");
		room.setRoomRent(2020d);
		assertEquals(true, adminService.updateRoom(2l, room));
	}
}
