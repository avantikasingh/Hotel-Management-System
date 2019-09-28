package com.cg.hotelmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.cg.hotelmanagement.service.AdminService;

@Controller
public class AdminController {
	
	@Autowired
	AdminService adminService;

}
