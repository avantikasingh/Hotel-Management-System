package com.cg.hotelmanagement.service;

import java.util.Date;

import com.cg.hotelmanagement.dao.AdminDao;
import com.cg.hotelmanagement.dao.IAdminDao;
import com.cg.hotelmanagement.dao.IUserDao;
import com.cg.hotelmanagement.dao.UserDao;
import com.cg.hotelmanagement.dto.User;
import com.cg.hotelmanagement.exception.HotelException;

public class UserService implements IUserService {
	
	IUserDao userDao = new UserDao();

	@Override
	public boolean register(String firstName, String lastName, String username, String emailId, Date dateOfBirth,
			String userMobileNo, String aadharNumber) {
		User user = new User(username, emailId, dateOfBirth, userMobileNo, firstName, lastName, aadharNumber, null);
		userDao.register(user);
		return true;
	}

}
