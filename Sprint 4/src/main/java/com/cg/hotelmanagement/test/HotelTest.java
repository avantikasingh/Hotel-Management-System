package com.cg.hotelmanagement.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.cg.hotelmanagement.dao.AdminDao;
import com.cg.hotelmanagement.dao.IAdminDao;
import com.cg.hotelmanagement.dto.City;
import com.cg.hotelmanagement.exception.HotelException;

class HotelTest {
	
	IAdminDao adminDao;

	@BeforeEach
	void createObject() {
		adminDao = new AdminDao();;
	}

	@Test
	void assignTestUnitTest() throws Exception{		
		Assertions.assertEquals(true, adminDao.addCity(new City()));
	}

	@Test
	void test() {
		fail("Not yet implemented");
	}

}
