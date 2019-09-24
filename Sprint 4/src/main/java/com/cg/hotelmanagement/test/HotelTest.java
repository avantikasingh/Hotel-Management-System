package com.cg.hotelmanagement.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.cg.hotelmanagement.dao.AdminDao;
import com.cg.hotelmanagement.dao.IAdminDao;
import com.cg.hotelmanagement.dto.City;
import com.cg.hotelmanagement.dto.Hotel;
import com.cg.hotelmanagement.dto.Room;
import com.cg.hotelmanagement.exception.HotelException;

class HotelTest {
	
	IAdminDao adminDao;
	City city;
	Hotel hotel;
	Room room;

	@BeforeEach
	void createObject() {
		adminDao = new AdminDao();
		
		city = new City();
		city.setCityName("Kanpur");
		
		hotel = new Hotel();
		hotel.setHotelAddress("Pune");
		hotel.setHotelPhoneNumber(8108734667l);
		hotel.setHotelRating(4.9f);
		
		room = new Room();
		room.setRoomNumber("101");
		room.setRoomRent(100d);
		room.setRoomType("S");
		
	}

	@Test
	void addCityUnitTest() throws Exception{		
		Assertions.assertEquals(true, adminDao.addCity(city));
	}
	
	@Test
	void addHotelUnitTest() throws Exception{		
		Assertions.assertEquals(true, adminDao.addHotel(1l, hotel));
	}
	
	@Test
	void addRoomUnitTest() throws Exception{		
		Assertions.assertEquals(true, adminDao.addRoom(1l, room));
	}
	
	@Test
	void removeCityUnitTest() throws Exception{		
		Assertions.assertEquals(true, adminDao.removeCity(1l));
	}
	
	@Test
	void removeHotelUnitTest() throws Exception{		
		Assertions.assertEquals(true, adminDao.removeHotel(1l,1l));
	}
	
	@Test
	void removeRoomUnitTest() throws Exception{		
		Assertions.assertEquals(true, adminDao.removeRoom(1l,1l));
	}

}
