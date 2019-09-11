package com.cg.hotelmanagement.service;

import java.math.BigInteger;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.cg.hotelmanagement.exception.HotelException;

public class Validate {
	
	public static String validateMobileNumber(String mobileNumber) throws HotelException{
		
        Pattern p = Pattern.compile("(0/91)?[7-9][0-9]{9}"); 
        Matcher m = p.matcher(mobileNumber);
        if(!(m.find() && m.group().equals(mobileNumber)))
        	throw new HotelException("Enter a valid mobile number");
        return mobileNumber;
		
	}
	
	public static String validateEmail(String email) throws HotelException {
		
		String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+ 
                "[a-zA-Z0-9_+&*-]+)*@" + 
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" + 
                "A-Z]{2,7}$";           
		Pattern pat = Pattern.compile(emailRegex); 
		if (email == null) 
			throw new HotelException("Enter a valid email address"); 
		if(!(pat.matcher(email).matches()))
			throw new HotelException("Enter a valid email address");
		return email;
	}
	
	public static boolean validateCheckInCheckOutDate(Date checkIn, Date checkOut) throws HotelException {
		if(checkIn.after(checkOut))
			throw new HotelException("CheckOut date should after checkIn date");
		return true;
	}
	
	public static boolean isNumeric(String input) {
		try
		{ 
			new BigInteger(input);
		} 
		catch (NumberFormatException e) 
		{ 
			System.out.println("Enter a valid integer");
			return false; 
		}
		return true;
	}
	
	public static boolean isDouble(String input) {
		 try 
	        {
	            Double.parseDouble(input); 
	            
	        }  
	        catch (NumberFormatException e) 
	        { 
	            System.out.println("Enter a valid double");
	            return false;
	        }
		 return true;
	}
	
	public static String isStringOnlyAlphabet(String input) throws HotelException 
	{ 
	    if ((!input.equals("")) 
	            && (input != null) 
	            && (input.matches("^[a-zA-Z]*$")))
	    	return input;
	    else
	    	throw new HotelException("Name can contain only alphabets");
	}
	

}
