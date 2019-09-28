package com.cg.hotelmanagement.service;

import java.time.LocalDate;
import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.hotelmanagement.dao.AdminDao;
import com.cg.hotelmanagement.dao.IAdminDao;
import com.cg.hotelmanagement.dao.ICustomerDao;
import com.cg.hotelmanagement.dao.CustomerDao;
import com.cg.hotelmanagement.dto.Customer;
import com.cg.hotelmanagement.exception.HotelException;


@Service("customerService")
@Transactional

public class CustomerService implements ICustomerService {
	
	@Autowired
	ICustomerDao customerDao;;

	@Override
	public boolean register(String firstName, String lastName, String gender,String username, String emailId, LocalDate dateOfBirth,
			String userMobileNo, String aadharNumber) {
		Customer customer = new Customer(username, emailId, dateOfBirth, userMobileNo, firstName, lastName,gender, aadharNumber, null);
		customerDao.register(customer);
		return true;
	}

}
