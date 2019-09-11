package com.cg.hotelmanagement.ui;

import com.cg.hotelmanagement.dto.Booking;
import com.cg.hotelmanagement.dto.City;
import com.cg.hotelmanagement.dto.Customer;
import com.cg.hotelmanagement.dto.Hotel;
import com.cg.hotelmanagement.dto.Room;
import com.cg.hotelmanagement.exception.HotelException;
import com.cg.hotelmanagement.service.*;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class MyApplication {
	static long userIdSys=1000;
	static long hotelIdSys=2000;
	static long roomIdSys=4000;
	static long cityIdSys=3000;
    public static void main(String[] args) {

    	Scanner sc = new Scanner(System.in);
    	
    	
    	IAdminService adminService=new AdminService();
    	
    	ICustomerService customerService = new CustomerService();
    	
    	System.out.println("Specify Role :\n1 for Admin\n2 for Customer\n3 For LoggedInUser");
    	
    	int role=sc.nextInt();
    	
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//
//		try {
//			Booking booking = new Booking("1", "1", dateFormat.parse("2017-03-10"), dateFormat.parse("2017-03-17"),dateFormat.parse("2017-03-19"),BigDecimal.valueOf(10));
//			hotelService.addBooking(BigInteger.valueOf(1),BigInteger.valueOf(1),BigInteger.valueOf(1),booking);
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}
		
    	String input;
    	
    	int adminChoice;
    	switch(role)
    	{
    	case 1:
    		do {
    		printAdminDetails();
    		adminChoice=sc.nextInt();
    		
	    		switch(adminChoice)
	    		{
	    		case 1:{
	    			String cityName = new String();
	    			System.out.println("Enter new City Name");
	    			while(true) {
		    			input=sc.next();
		    			try {
		    				cityName=Validate.isStringOnlyAlphabet(input);
		    				break;
		    			}
		    			catch(HotelException e) {
		    				System.out.println(e.getMessage());
		    				continue;
		    			}
		    		}
	    			adminService.addCity(BigInteger.valueOf(cityIdSys++),cityName);
	    			break;
	    		}
	    			
	    		case 2:{
	    			System.out.println("Enter City Id to be Removed :");
	    			
	    			while(true) {
	    				input=sc.next();
	    				if(Validate.isNumeric(input))
	    					break;
	    			}
	    			BigInteger cityId=new BigInteger(input);
	    			adminService.removeCity(cityId);
	    			break;
	    		}
	    		
	    		//////////////////////////
	    		case 3:{
	    			System.out.println("Enter Hotel Id to be updated :");
	    			BigInteger hotelId;
	    			while(true) {
	    				input=sc.next();
	    				if(Validate.isNumeric(input)){
	    					hotelId=new BigInteger(input);
							break;
						}
	    			}
	    			
	    			
	    			break;
	    		}
	    			
	    		case 4:{
	    			BigInteger cityId1;
	    			System.out.println("Enter city Id");
	    			while(true) {
	    				input = sc.next();
	        			if(Validate.isNumeric(input)) {
	        				cityId1 =new BigInteger(input);
	        				break;
	        			}
	    			}
	    			String hotelName,hotelAddress,hotelPhone;
	    			System.out.println("Enter new Hotel Details");
	    			System.out.println("Hotel Name:");
	    			hotelName=sc.next();
	    			System.out.println("Hotel Address:");
	    			hotelAddress=sc.next();
	    			System.out.println("Hotel Contact No:");
	    			while(true) {
	    				input=sc.next();
	    				try {
	    					hotelPhone = Validate.validateMobileNumber(input);
	    					break;
	    				}
	    				catch(HotelException e) {
	    					System.out.println(e.getMessage());
	    					continue;
	    				}
	    			}
	    			System.out.println("Hotel Rating:");
	    			float hotelRating=sc.nextFloat();
	    			
	    			adminService.addHotel(cityId1,BigInteger.valueOf(hotelIdSys++),hotelName,hotelAddress,hotelPhone,hotelRating);
	    			
	    			break;
	    		}
	    			
	    		case 5:
	    			
	    			System.out.println("Enter City Id in which Hotel is to be removed :");
	    			BigInteger cityId2=sc.nextBigInteger();
	    			
	    			System.out.println("Enter Hotel Id to be removed:");
	    			BigInteger hotelId1=sc.nextBigInteger();
	    			
	    			adminService.removeHotel(cityId2,hotelId1);
	    			
	    			break;
	    			
	    		case 6:
	    			String hotelName,hotelAddress,hotelPhone;
	    			System.out.println("City id");
	    			BigInteger cityId = sc.nextBigInteger();
	    			System.out.println("Enter hotel id");
	    			BigInteger hotelId = sc.nextBigInteger();
	    			System.out.println("Enter new Hotel name");
	    			hotelName=sc.next();
	    			adminService.updateHotel(cityId,hotelId,hotelName);
	    			break;
	    			
	    		case 7:{
	    			
	    			System.out.println("Enter City Id in which Room is to be added :");
	    			BigInteger cityId3=sc.nextBigInteger();
	    			
	    			System.out.println("Enter Hotel Id in which Room is to be added:");
	    			BigInteger hotelId2=sc.nextBigInteger();
	    			
	    			System.out.println("Enter new Room Details");
	    			
	    			System.out.println("Room Type:");
	    			String roomType=sc.next();
	    			System.out.println("Room Rent:");
	    			double roomRent=sc.nextDouble();
	    			System.out.println("Room No:");
	    			String roomNumber=sc.next();   			
	    			adminService.addRoom(cityId3,hotelId2,BigInteger.valueOf(roomIdSys++),roomType,roomRent,roomNumber);    			
	    			break;
	    		}
	    			
	    		case 8:{
	    			
	    			System.out.println("Enter City Id in which Room is to be removed :");
	    			BigInteger cityId4=sc.nextBigInteger();
	    			
	    			System.out.println("Enter Hotel Id in which Room is to be removed:");
	    			BigInteger hotelId3=sc.nextBigInteger();
	    			
	    			System.out.println("Enter Room Id to be removed :");
	    			BigInteger roomId1=sc.nextBigInteger();
	    			
	    			adminService.removeRoom(cityId4,hotelId3,roomId1);
	    			
	    			break;
	    		}
	    		
	    		case 10:{
	    			Map<BigInteger,City> cityMap = adminService.showCity();
	    			for (Entry<BigInteger, City> entry : cityMap.entrySet())  
	    	            System.out.println("City Id = " + entry.getKey() + 
	    	                             ", City Name = " + entry.getValue()); 
	    	    	}
	    		
	    		case 11:{
	    			BigInteger cityId1;
	    			while(true) {
	    				input = sc.next();
	        			if(Validate.isNumeric(input)) {
	        				cityId1 =new BigInteger(input);
	        				break;
	        			}
	    			}
	    			Map<BigInteger,Hotel> hotelMap = adminService.showHotel(cityId1);
	    			for (Entry<BigInteger, Hotel> entry : hotelMap.entrySet()) {  
	    	            System.out.println(entry.getValue().toString()); 
	    	    	}
	    		}
	    		
	    		case 12:{
	    			BigInteger cityId1;
	    			while(true) {
	    				input = sc.next();
	        			if(Validate.isNumeric(input)) {
	        				cityId1 =new BigInteger(input);
	        				break;
	        			}
	    			}
	    			BigInteger hotelId11;
	    			while(true) {
	    				input = sc.next();
	        			if(Validate.isNumeric(input)) {
	        				hotelId11 =new BigInteger(input);
	        				break;
	        			}
	    			}
	    			Map<BigInteger,Room> roomMap = adminService.showRoom(cityId1,hotelId11);
	    			for (Entry<BigInteger, Room> entry : roomMap.entrySet()) {  
	    	            System.out.println(entry.getValue().toString()); 
	    	    	}
	    		}
    			
    			
	    		}
    		}while(adminChoice!=13);
    		
    		break;
    	case 2:{
    		input=sc.next();
    		Date checkIn,checkOut;
    		System.out.println("Enter checkIn date");
    		while(true) {
	    		try {
					checkIn = dateFormat.parse(input);
					break;
				} catch (Exception e) {
					// TODO Auto-generated catch block
					System.out.println("Enter date in correct format");
					continue;
				}
    		}
    		input = sc.next();
    		System.out.println("Enter check out date");
    		while(true) {
	    		try {
					checkOut = dateFormat.parse(input);
					break;
				} catch (Exception e) {
					// TODO Auto-generated catch block
					System.out.println("Enter date in correct format");
					continue;
				}
    		}
    		BigInteger cityId;
    		BigInteger hotelId;
    		BigInteger roomId;
    		System.out.println("Enter city id");
			while(true) {
				input = sc.next();
    			if(Validate.isNumeric(input)) {
    				cityId =new BigInteger(input);
    				break;
    			}
			}
    		System.out.println("Enter hotel id");
    		while(true) {
				input = sc.next();
    			if(Validate.isNumeric(input)) {
    				hotelId =new BigInteger(input);
    				break;
    			}
			}
    		System.out.println("Enter room id");
    		while(true) {
				input = sc.next();
    			if(Validate.isNumeric(input)) {
    				roomId =new BigInteger(input);
    				break;
    			}
			}
    		customerService.makeBooking(cityId,hotelId, checkIn, checkOut, roomId);
    		break;
    	}
    	
    	
    	case 3:{
    		int choiceForUser;
			do {
    		printLoggedInUserDetails();
    		choiceForUser = sc.nextInt();
    		switch(choiceForUser) {
    		case 1:{
    			BigInteger userId;
    			System.out.println("Enter userId");
    			while(true) {
    				input = sc.next();
        			if(Validate.isNumeric(input)) {
        				userId =new BigInteger(input);
        				break;
        			}
    			}
    			String username;
    			System.out.println("Enter username");
    			while(true) {
    				input=sc.next();
    				try {
    					username = Validate.isUsernameValid(input);
    					break;
    				}
    				catch(HotelException e) {
    					System.out.println(e.getMessage());
    					continue;
    				}
    			}
    			String emailId;
    			System.out.println("Enter emailId");
    			while(true) {
    				input=sc.next();
	    			try {
	    				emailId = Validate.validateEmail(input);
						break;
					}
					catch(HotelException e) {
						System.out.println(e.getMessage());
						continue;
					}
    			}
    			Date dateOfBirth;
    			System.out.println("Enter dateOfBirth");
    			while(true) {
    				input=sc.next();
    				try {
						Date date = dateFormat.parse(input);
						break;
						
					} catch (ParseException e) {
						System.out.println("Enter date in proper format");
						continue;
					}
    			}
    			String userMobileNo;
    			System.out.println("Enter mobile number");
    			while(true) {
    				input=sc.next();
    				try {
    					userMobileNo = Validate.validateMobileNumber(input);
						break;
						
					} catch (HotelException e) {
						System.out.println(e.getMessage());
						continue;
					}
    			}
    			String firstName;
    			System.out.println("Enter First name");
    			while(true) {
    				input=sc.next();
    				try {
    					firstName = Validate.isStringOnlyAlphabet(input);
						break;
						
					} catch (HotelException e) {
						System.out.println(e.getMessage());
						continue;
					}
    			}
    			String lastName = null;
    			System.out.println("Enter Last Name");
    			while(true) {
    				input=sc.next();
    				try {
    					firstName = Validate.isStringOnlyAlphabet(input);
						break;
						
					} catch (HotelException e) {
						System.out.println(e.getMessage());
						continue;
					}
    			}
    			BigInteger aadharNumber;
    			System.out.println("Enter aadhar number");
    			while(true) {
    				input = sc.next();
        			if(Validate.aadhar(input)) {
        				aadharNumber =new BigInteger(input);
        				break;
        			}
    			}
    			
    			customerService.register(BigInteger.valueOf(userIdSys++),null,firstName,lastName,aadharNumber);
    			
    			//customerService.register(userId,username,emailId,dateOfBirth,userMobileNo);
			break;
    		}
    		case 2:{
    			System.out.println("Enter city Id");
    			BigInteger cityId;
    			while(true) {
    				input = sc.next();
        			if(Validate.isNumeric(input)) {
        				cityId =new BigInteger(input);
        				break;
        			}
    			}
    			BigInteger hotelId = null;
    			while(true) {
    				input = sc.next();
        			if(Validate.isNumeric(input)) {
        				cityId =new BigInteger(input);
        				break;
        			}
    			}
    			customerService.viewHotels(cityId,hotelId);
    		}
    		}
    			
    		}while(choiceForUser!=3);
    	}
    }
    	
    	
    	sc.close();
    	
    	
 }
    public static void printAdminDetails()
    {
    	System.out.println("Enter 1 to Add a City");
    	System.out.println("Enter 2 to Remove a City");
    	//System.out.println("Enter 3 to Update a City");
    	System.out.println("Enter 4 to Add a Hotel");
    	System.out.println("Enter 4 to Remove a Hotel");
    	System.out.println("Enter 5 to Update a Hotel");
    	System.out.println("Enter 6 to Add a Room");
    	System.out.println("Enter 7 to Remove a Room");
    	System.out.println("Enter 8 to Update a Room");
    	System.out.println("Enter 9 to Show a City");
    	System.out.println("Enter 10 to Show a Hotel");
    	System.out.println("Enter 11 to Show a Room");
    }
    
    public static void printHotelUpdateOptions()
    {
    	System.out.println("Enter 1 to Update Hotel Name :");
    	System.out.println("Enter 2 to Update Hotel Address :");
    	System.out.println("Enter 3 to Update Hotel Contact No :");
    	System.out.println("Enter 4 to Update Hotel Rating :");
    }
    
    public static void printLoggedInUserDetails() {
    	System.out.println("Enter 1 to Register");
    	System.out.println("Enter 2 to view hotels");
    }
    
    public static void printCustomerDetails() {
    	System.out.println("Make booking");
    }

}
