package com.cg.hotelmanagement.service;

import java.util.Date;

public interface IUserService {
	
	public boolean register(String firstName, String lastName,String username, String emailId, Date dateOfBirth, String userMobileNo, String aadharNumber);
	

}
