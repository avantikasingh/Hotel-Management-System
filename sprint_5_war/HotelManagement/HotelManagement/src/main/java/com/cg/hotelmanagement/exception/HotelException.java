package com.cg.hotelmanagement.exception;

public class HotelException extends Exception {

	/**
	 * @author Saurabh
	 */
	private static final long serialVersionUID = 1L;
	private String message;

	public HotelException(String message) {
		super(message);
	}

}
