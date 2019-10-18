package com.cg.hotelmanagement.service;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.cg.hotelmanagement.exception.HotelException;

public class Validate {

	/**
	 * Validate Mobile number
	 * @param mobileNumber
	 * @return String
	 */
	public static String validateMobileNumber(String mobileNumber)
	{
		//Mobile number can start with (0 or 91)(optional) and length should be 10.
		Pattern pattern = Pattern.compile("(0/91)?[0-9]{10}");
		Matcher mat = pattern.matcher(mobileNumber);
		if (!(mat.find() && mat.group().equals(mobileNumber)))
			throw new HotelException("Enter a valid mobile number");
		return mobileNumber;

	}
	
	/**
	 * Validate email
	 * @param email
	 * @return
	 * @throws HotelException
	 */
	public static String validateEmail(String email) throws HotelException {

		String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." + "[a-zA-Z0-9_+&*-]+)*@"
				+ "(?:[a-zA-Z0-9-]+\\.)+[a-z" + "A-Z]{2,7}$";
		Pattern pat = Pattern.compile(emailRegex);
		if (email == null)
			throw new HotelException("Enter a valid email address");
		if (!(pat.matcher(email).matches()))
			throw new HotelException("Enter a valid email address");
		return email;
	}
	
	
	/**
	 * Validate password
	 * @param password
	 * @return Boolean
	 */
	public static boolean validatePassword(String password) {
//		This regular expression match can be used for validating strong password.
//		It expects atleast 1 small-case letter, 1 Capital letter, 1 digit, 1 special character
//		and the length should be between 6-10 characters.
		String passwordRegex = "(?=^.{6,10}$)(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&amp;*()_+}{&quot;:;'?/&gt;.&lt;,])(?!.*\\s).*$";
		Pattern pat = Pattern.compile(passwordRegex);
		if (!(pat.matcher(password).matches()))
			throw new HotelException("Enter a password which contains 1 small case, 1 capital, 1 special character"
					+ "and length should be between 6-10 characters ");
		return true;
	}

	/**
	 * Validate if checkIn date is less than checkOut date
	 * @param checkIn
	 * @param checkOut
	 * @return boolean
	 * @throws HotelException
	 */
	public static boolean validateCheckInCheckOutDate(LocalDate checkIn,
			LocalDate checkOut) throws HotelException {
		if (checkIn.isAfter(checkOut))
			throw new HotelException("CheckOut date should after checkIn date");
		return true;
	}

	/**
	 * To check if Id is in BigInteger format
	 * @param input
	 * @return boolean
	 */
	public static boolean isNumeric(String input) {
		try {
			new BigInteger(input);
		} catch (NumberFormatException e) {
			System.out.println("Enter a valid integer");
			return false;
		}
		return true;
	}

	/**
	 * 
	 * @param input
	 * @return 
	 */
	public static boolean aadhar(String input) {
		if (input.length() != 12) {
			System.out.println("Length should be 12");
			return false;
		}
		try {
			new BigInteger(input);
		} catch (NumberFormatException e) {
			System.out.println("Enter a valid integer");
			return false;
		}
		return true;
	}

	public static boolean isDouble(String input) {
		try {
			Double.parseDouble(input);

		} catch (NumberFormatException e) {
			System.out.println("Enter a valid double");
			return false;
		}
		return true;
	}

	public static String isStringOnlyAlphabet(String input)
			throws HotelException {
		if ((!input.equals("")) && (input != null)
				&& (input.matches("^[a-zA-Z]*$")))
			return input;
		else
			throw new HotelException("Name can contain only alphabets");
	}

	public static String isUsernameValid(String input) throws HotelException {
		if (input.length() > 5 && input.length() <= 10)
			return input;
		else
			throw new HotelException(
					"Username should be of minimum 6 digits and maximum 10 digits");
	}

	public boolean isValidChoice(String str) {
		str = str.trim();

		if (str.length() == 0)
			return false;

		// if string is of length 1 and the only
		// character is not a digit
		if (str.length() == 1 && !Character.isDigit(str.charAt(0)))
			return false;

		// If the 1st char is not '+', '-', '.' or digit
		if (str.charAt(0) != '+' && str.charAt(0) != '-'
				&& !Character.isDigit(str.charAt(0)) && str.charAt(0) != '.')
			return false;

		// To check if a '.' or 'e' is found in given
		// string. We use this flag to make sure that
		// either of them appear only once.
		boolean flagDotOrE = false;

		for (int i = 1; i < str.length(); i++) {
			// If any of the char does not belong to
			// {digit, +, -, ., e}
			if (!Character.isDigit(str.charAt(i)) && str.charAt(i) != 'e'
					&& str.charAt(i) != '.' && str.charAt(i) != '+'
					&& str.charAt(i) != '-')
				return false;

			if (str.charAt(i) == '.') {
				// checks if the char 'e' has already
				// occurred before '.' If yes, return 0.
				if (flagDotOrE == true)
					return false;

				// If '.' is the last character.
				if (i + 1 >= str.length())
					return false;

				// if '.' is not followed by a digit.
				if (!Character.isDigit(str.charAt(i + 1)))
					return false;
			}

			else if (str.charAt(i) == 'e') {
				// set flagDotOrE = 1 when e is encountered.
				flagDotOrE = true;

				// if there is no digit before 'e'.
				if (!Character.isDigit(str.charAt(i - 1)))
					return false;

				// If 'e' is the last Character
				if (i + 1 >= str.length())
					return false;

				// if e is not followed either by
				// '+', '-' or a digit
				if (!Character.isDigit(str.charAt(i + 1))
						&& str.charAt(i + 1) != '+' && str.charAt(i + 1) != '-')
					return false;
			}
		}

		/*
		 * If the string skips all above cases, then it is numeric
		 */
		return true;
	}

}