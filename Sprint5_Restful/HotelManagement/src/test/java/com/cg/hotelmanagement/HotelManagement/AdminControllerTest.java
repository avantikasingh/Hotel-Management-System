package com.cg.hotelmanagement.HotelManagement;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.hotelmanagement.controller.AdminController;
import com.cg.hotelmanagement.dto.City;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AdminControllerTest {
	
	@Autowired
	TestRestTemplate restTemplate;
	
	//How to test as some functions have request param
	
	@Autowired
	AdminController adminController;
	
//	@Test
//	public void testgetcities() {
//		assertEquals(3, adminController.getCities().size());
//	}
//	
//	@Test
//	public void testgetcity() {
//		City city = restTemplate.getForObject("/cities",City.class);
//		assertThat(city);
//	}
//	
//	@Test
//	public void testaddCity() {
//		City city = restTemplate.getForObject("/cities/1", City.class);
//		assertThat(city);
//	}
	
	//How to know which mapping as all url's are same

}
