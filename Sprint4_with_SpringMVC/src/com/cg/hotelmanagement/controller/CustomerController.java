package com.cg.hotelmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.cg.hotelmanagement.service.CustomerService;

@Controller
public class CustomerController {
	
	@Autowired
	CustomerService customerService;

}
