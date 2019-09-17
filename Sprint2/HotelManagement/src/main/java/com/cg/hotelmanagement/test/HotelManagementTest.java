package com.cg.hotelmanagement.test;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigInteger;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.cg.hotelmanagement.exception.HotelException;
import com.cg.hotelmanagement.service.AdminService;
import com.cg.hotelmanagement.service.IAdminService;

class HotelManagementTest {
	
	IAdminService adminService;

	@BeforeEach
	void createObject() {
		adminService = new AdminService();
	}

	@Test
	void addCityUnitTest() throws Exception{		
//		Assertions.assertEquals(true, adminService.addCity(1, "Pune"));
//		Assertions.assertThrows(UserException.class, ()->{service.assignTest(BigInteger.valueOf(3), BigInteger.valueOf(2));});
		Assertions.assertEquals(true, adminService.addCity(null, "Allahabad"));
	}
	
	void removeCityUnitTest() throws Exception{		
		Assertions.assertEquals(true, adminService.removeCity(BigInteger.valueOf(1)));
	}
	
	void addHotelUnitTest() throws Exception{		
		Assertions.assertEquals(true, adminService.addHotel(BigInteger.valueOf(1), "Taj", "Mumbai", "8108734667", (float) 4.9));
	}
	
	void removeHotelUnitTest() throws Exception{		
		Assertions.assertEquals(true, adminService.removeHotel(BigInteger.valueOf(1), BigInteger.valueOf(1)));
	}
	
	void updateHotelUnitTest() throws Exception{		
		Assertions.assertEquals(true, adminService.updateHotel(BigInteger.valueOf(1), BigInteger.valueOf(1), "JW"));
	}
	
	void addRoomUnitTest() throws Exception{		
		Assertions.assertEquals(true, adminService.addRoom(BigInteger.valueOf(1), BigInteger.valueOf(1), BigInteger.valueOf(1), "ABC", 12313, "1"));
	}
	
	void removeRoomUnitTest() throws Exception{		
		Assertions.assertEquals(true, adminService.removeRoom(BigInteger.valueOf(1), BigInteger.valueOf(1), BigInteger.valueOf(1)));
	}
	
	void updateRoomUnitTest() throws Exception{		
		Assertions.assertEquals(true, adminService.updateRoom(BigInteger.valueOf(1), BigInteger.valueOf(1), BigInteger.valueOf(1), "B"));
	}

}
