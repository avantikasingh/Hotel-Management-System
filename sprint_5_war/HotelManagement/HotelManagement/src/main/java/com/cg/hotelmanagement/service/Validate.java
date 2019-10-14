package com.cg.hotelmanagement.service;

import java.math.BigInteger;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.cg.hotelmanagement.exception.HotelException;

public class Validate {

	public static String validateMobileNumber(String mobileNumber)
			throws HotelException {

		Pattern p = Pattern.compile("(0/91)?[7-9][0-9]{9}");
		Matcher m = p.matcher(mobileNumber);
		if (!(m.find() && m.group().equals(mobileNumber)))
			throw new HotelException("Enter a valid mobile number");
		return mobileNumber;

	}

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

	public static boolean validateCheckInCheckOutDate(Date checkIn,
			Date checkOut) throws HotelException {
		if (checkIn.after(checkOut))
			throw new HotelException("CheckOut date should after checkIn date");
		return true;
	}

	public static boolean isNumeric(String input) {
		try {
			new BigInteger(input);
		} catch (NumberFormatException e) {
			System.out.println("Enter a valid integer");
			return false;
		}
		return true;
	}

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