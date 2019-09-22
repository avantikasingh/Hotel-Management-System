package com.cg.hotelmanagement.exception;

public class HotelException extends Exception {

	private String message;

	public HotelException(String message) {
		super(message);
	}

}