package com.cg.hotelmanagement.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import com.cg.hotelmanagement.exception.HotelException;

/**
 * 
 * @author Saurabh
 *
 */

@ControllerAdvice
public class GlobalExceptionController {

	@ExceptionHandler(HotelException.class)
	public ModelAndView handleCustomException(HotelException hotelexception) {

		ModelAndView model = new ModelAndView("error");
		model.addObject("errCode", hotelexception.getMessage());
		model.addObject("errMsg", hotelexception.getMessage());

		return model;

	}

	@ExceptionHandler(Exception.class)
	public ModelAndView handleAllException(Exception ex) {

		ModelAndView model = new ModelAndView("error");
		model.addObject("errMsg", "this is Exception.class");

		return model;

	}
	
}
