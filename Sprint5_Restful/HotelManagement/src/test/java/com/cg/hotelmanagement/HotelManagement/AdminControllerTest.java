package com.cg.hotelmanagement.HotelManagement;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.hotelmanagement.controller.AdminController;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AdminControllerTest {
	
	//How to test as some functions have request param
	
	@Autowired
	AdminController adminController;
	
	@Test
	public void testgetcities() {
		assertEquals(3, adminController.getCities().size());
	}
	
	@Test
	public void testgetcity() {
		//test class type City
	}
	
	@Test
	public void testaddCity() {
		//test class type City
	}

}
