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

	@BeforeEach
	void createObject() {
		adminDao = new AdminDao();;
	}

	@Test
	void addCityUnitTest() throws Exception{		
		Assertions.assertEquals(true, adminDao.addCity(new City()));
	}
	
	@Test
	void addHotelUnitTest() throws Exception{		
		Assertions.assertEquals(true, adminDao.addHotel(2l, new Hotel()));
	}
	
	@Test
	void addRoomUnitTest() throws Exception{		
		Assertions.assertEquals(true, adminDao.addRoom(1l, new Room()));
	}

}
