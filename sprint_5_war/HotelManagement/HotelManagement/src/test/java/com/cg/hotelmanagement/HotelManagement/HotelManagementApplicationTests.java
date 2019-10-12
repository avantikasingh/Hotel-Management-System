package com.cg.hotelmanagement.HotelManagement;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.hotelmanagement.service.IAdminService;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
public class HotelManagementApplicationTests {

	@Autowired
	TestRestTemplate restTemplate;
	
	@Autowired
	IAdminService adminService;
	
	//-----------------------------------------
	//Admin Controller tests
	
	@Test
	public void checkloginPage() {
		String str = restTemplate.getForObject("/login", String.class);
		assertThat(str.equals("LoginPage"));
	}
	
	@Test
	public void checkregisterPage() {
		String str = restTemplate.getForObject("/register", String.class);
		assertThat(str.equals("RegisterPage"));
	}
	
	@Test
	public void checkregisterUser() {
		String str = restTemplate.getForObject("/registerpage", String.class);
		assertThat(str.equals("LoginPage"));
	}
	
//	@Test
//	public void checklogin() {
//		String str = restTemplate.getForObject("/loginpage", String.class);
//		assertThat(str.equals("LoginPage"));
//	}
	
	@Test
	public void checkaddcity() {
		String str = restTemplate.getForObject("/addcity", String.class);
		assertThat(str.equals("AddCityPage"));
	}
	
	@Test
	public void checkaddCityData() {
		String str = restTemplate.getForObject("/pagesubmitaddcitypage", String.class);
		assertThat(str.equals("AdminPage"));
	}
	
	@Test
	public void checkaddHotel() {
		String str = restTemplate.getForObject("/addhotel", String.class);
		assertThat(str.equals("AddHotelPage"));
	}
	
//	@Test
//	public void checkaddHotelData() {
//		String str = restTemplate.getForObject("/pagesubmitaddhotelpage", String.class);
//		assertThat(str.equals("AddHotelPage"));
//	}
	
	@Test
	public void checkaddroom() {
		String str = restTemplate.getForObject("/addroom", String.class);
		assertThat(str.equals("AddRoomPage"));
	}
	
	@Test
	public void checkaddRoomData() {
		String str = restTemplate.getForObject("/pagesubmitaddroompage", String.class);
		assertThat(str.equals("AdminPage"));
	}
	
	@Test
	public void checkgetAllCityData() {
		String str = restTemplate.getForObject("/showcity", String.class);
		assertThat(str.equals("ShowAllCities"));
	}
	
	@Test
	public void checkgetAllHotelData() {
		String str = restTemplate.getForObject("/showhotel", String.class);
		assertThat(str.equals("ShowHotel"));
	}
	
	@Test
	public void checkshowHotelData() {
		String str = restTemplate.getForObject("/showallhotel", String.class);
		assertThat(str.equals("ShowHotel"));
	}
	
	@Test
	public void checkgetAllRoomData() {
		String str = restTemplate.getForObject("/showroom", String.class);
		assertThat(str.equals("ShowRoom"));
	}
	
	@Test
	public void checkshowRoomData() {
		String str = restTemplate.getForObject("/showallroom", String.class);
		assertThat(str.equals("ShowRoom"));
	}
	
	@Test
	public void checkdeleteCity() {
		String str = restTemplate.getForObject("/deletecity", String.class);
		assertThat(str.equals("DeleteCityPage"));
	}
	
	@Test
	public void checkdeleteCityData() {
		String str = restTemplate.getForObject("/deletecitydata", String.class);
		assertThat(str.equals("AdminPage"));
	}
	
	@Test
	public void checkdeleteHotel() {
		String str = restTemplate.getForObject("/deletehotel", String.class);
		assertThat(str.equals("DeleteHotelPage"));
	}
	
	@Test
	public void checkdeleteHotelData() {
		String str = restTemplate.getForObject("/deletehoteldata", String.class);
		assertThat(str.equals("AdminPage"));
	}
	
	@Test
	public void checkdeleteCityPage() {
		String str = restTemplate.getForObject("/deleteroom", String.class);
		assertThat(str.equals("DeleteRoomPage"));
	}
	
	@Test
	public void checkdeleteRoomData() {
		String str = restTemplate.getForObject("/deleteroomdata", String.class);
		assertThat(str.equals("AdminPage"));
	}
	
	@Test
	public void checkviewHotelModifyPage() {
		String str = restTemplate.getForObject("/updatehotel", String.class);
		assertThat(str.equals("UpdateHotelPage"));
	}
	
	@Test
	public void checkviewHotelModifyDetails() {
		String str = restTemplate.getForObject("/updatehotelview", String.class);
		assertThat(str.equals("UpdateHotelPage"));
	}
	
	@Test
	public void checkupdateHotel() {
		String str = restTemplate.getForObject("/updatehoteldata", String.class);
		assertThat(str.equals("AdminPage"));
	}
	
	@Test
	public void checkviewRoomModifyPage() {
		String str = restTemplate.getForObject("/updateroom", String.class);
		assertThat(str.equals("UpdateRoomPage"));
	}
	
	@Test
	public void checkviewRoomModifyDetails() {
		String str = restTemplate.getForObject("/updateroomview", String.class);
		assertThat(str.equals("UpdateRoomPage"));
	}
	
	@Test
	public void checkupdateRoom() {
		String str = restTemplate.getForObject("/updateroomdata", String.class);
		assertThat(str.equals("AdminPage"));
	}

}
