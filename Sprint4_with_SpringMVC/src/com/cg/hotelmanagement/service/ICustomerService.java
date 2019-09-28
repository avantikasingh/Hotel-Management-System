package com.cg.hotelmanagement.service;

import java.time.LocalDate;
import java.util.Date;

public interface ICustomerService {
	
	public boolean register(String firstName, String lastName,String gender,String username, String emailId, LocalDate dateOfBirth, String userMobileNo, String aadharNumber);
	

}
