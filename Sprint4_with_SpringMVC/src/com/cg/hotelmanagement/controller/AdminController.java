package com.cg.hotelmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cg.hotelmanagement.dto.City;
import com.cg.hotelmanagement.service.AdminService;
import com.cg.hotelmanagement.service.IAdminService;


@Controller
public class AdminController {
	
	@Autowired
	IAdminService adminService;
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String adminPage() {
		return "AdminPage";
	}
	@RequestMapping(value = "/addcity", method = RequestMethod.GET)
	public String addCity() {
		return "AddCityPage";
	}
	
	@RequestMapping(value = "/pagesubmitaddcitypage", method = RequestMethod.POST)
	public String addCityData(@ModelAttribute("city") City city) throws Exception {
		adminService.addCity(city);
		return "home";
		
	}
	
//	@RequestMapping(value = "/showall", method = RequestMethod.GET)
//	public ModelAndView getAllData() {
//		List<Trainee> traineeList = traineeservice.showAllTrainee();
//		return new ModelAndView("ShowAllTrainee", "data", traineeList);
//	}
//	@RequestMapping(value = "/delete", method = RequestMethod.GET)
//	public String deletePage() {
//		return "DeleteTrainee";
//
//	}
//	@RequestMapping(value = "/deletedata", method = RequestMethod.POST)
//	public String deleteData() {
//		traineeservice.deleteTrainee(idDelete);
//		idDelete = null;
//		return "redirect:/home";
//	}
//
//	@RequestMapping(value = "/search", method = RequestMethod.GET)
//	public String search() {
//		return "SearchTrainee";
//		
//	}
//	
//	@RequestMapping(value = "/showtrainee", method = RequestMethod.POST)
//	public ModelAndView searchTrainee(@RequestParam("tid") int traineeId) {
//		Trainee trainee = traineeservice.searchTrainee(traineeId);
//		return new ModelAndView("SearchTrainee","trainee", trainee);
//		
//	}
//	@RequestMapping(value = "/showdeletetrainee", method = RequestMethod.POST)
//	public ModelAndView searchDeleteTrainee(@RequestParam("tid") int traineeId) {
//		idDelete = traineeId;
//		Trainee trainee = traineeservice.searchTrainee(traineeId);
//		return new ModelAndView("DeleteTrainee","trainee", trainee);
//		
//	}
//	


	
	

}
