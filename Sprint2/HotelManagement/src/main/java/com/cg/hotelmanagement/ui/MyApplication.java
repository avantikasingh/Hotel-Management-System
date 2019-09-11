package com.cg.hotelmanagement.ui;

import com.cg.hotelmanagement.dto.Booking;
import com.cg.hotelmanagement.service.HotelManagementService;
import com.cg.hotelmanagement.service.IHotelManagementService;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class MyApplication {
	static int userId=1000;
	static int hotelId=2000;
	static int roomId=4000;
	static int cityId=3000;
    public static void main(String[] args) {

    	Scanner sc = new Scanner(System.in);

    	IHotelManagementService hotelService=new HotelManagementService();

		hotelService.addCity(1,"Mumbai");

		hotelService.addCity(2,"Pune");

		System.out.println(hotelService.showCityList());

		hotelService.addHotel(1,1,"Taj","Mumbai",98899,4.9f);

		hotelService.addHotel(2,1,"ITC","Pune",98899,4.9f);

		hotelService.addRoom(1,1,1,"A",2000d,"1");

		hotelService.addRoom(2,1,1,"A",2000d,"1");

		System.out.println(hotelService.showCityList());

		hotelService.showHotel(1);

		hotelService.showHotel(2);

		hotelService.showRoom(1,1);

		hotelService.showRoom(2,1);

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");


		try {
			Booking booking = new Booking("1", "1", dateFormat.parse("2017-01-10"), dateFormat.parse("2017-03-17"),dateFormat.parse("2017-03-19"),new BigDecimal(10));
			hotelService.addBooking(1,1,1,booking);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		try {
			Booking booking = new Booking("1", "1", dateFormat.parse("2017-01-10"), dateFormat.parse("2017-03-22"),dateFormat.parse("2017-03-23"),new BigDecimal(10));
			hotelService.addBooking(1,1,1,booking);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		try {
			hotelService.viewHotel(dateFormat.parse("2017-01-10"),dateFormat.parse("2017-01-10"),1,false);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		System.out.println();

		try {
			hotelService.viewHotel(dateFormat.parse("2017-03-20"),dateFormat.parse("2017-03-21"),1,false);
		} catch (ParseException e) {
			e.printStackTrace();
		}


		System.out.println("Specify Role :\nEnter 1 for Admin\n2. Enter 2 for Customer");
    	int role=sc.nextInt();
    	
    	switch(role)
    	{
    	case 1:
    		printAdminDetails();
    		int adminChoice=sc.nextInt();
    		
    		switch(adminChoice)
    		{
    		case 1:
    			
    			System.out.println("Enter new City Name");
    			String cityName=sc.next();
    			hotelService.addCity(cityId++,cityName);
    			break;
    			
    		case 2:
    			System.out.println("Enter City Id to be Removed :");
    			int id=sc.nextInt();
    			boolean b=hotelService.removeCity(id);
    			break;
    			
    		case 3:
    			System.out.println("Enter Hotel Id to be updated :");
    			
    			int hId=sc.nextInt();
    			
    			printHotelUpdateOptions();
    			
    			int hotelChoice=sc.nextInt();
    			
    			switch(hotelChoice)
    			{
    			case 1:
    				String newHotelName=sc.next();
    				
    			}
    			
    		case 4:
    			System.out.println("Enter City Id in which Hotel is to be added :");
    			int cityId1=sc.nextInt();
    			
    			System.out.println("Enter new Hotel Details");
    			
    			System.out.println("Hotel Name:");
    			String hotelName=sc.next();
    			System.out.println("Hotel Address:");
    			String hotelAddress=sc.next();
    			System.out.println("Hotel Contact No:");
    			int hotelPhoneNo=sc.nextInt();
    			System.out.println("Hotel Rating:");
    			float hotelRating=sc.nextFloat();
    			
    			hotelService.addHotel(cityId1,hotelId++,hotelName,hotelAddress,hotelPhoneNo,hotelRating);
    			
    			break;
    			
    		case 5:
    			
    			System.out.println("Enter City Id in which Hotel is to be removed :");
    			int cityId2=sc.nextInt();
    			
    			System.out.println("Enter Hotel Id to be removed:");
    			int hotelId1=sc.nextInt();
    			
    			hotelService.removeHotel(cityId2,hotelId1);
    			
    			break;
    			
    		case 6:
    			//updateHotel
    			break;
    			
    		case 7:
    			
    			System.out.println("Enter City Id in which Room is to be added :");
    			int cityId3=sc.nextInt();
    			
    			System.out.println("Enter Hotel Id in which Room is to be added:");
    			int hotelId2=sc.nextInt();
    			
    			System.out.println("Enter new Room Details");
    			
    			System.out.println("Room Type:");
    			String roomType=sc.next();
    			System.out.println("Room Rent:");
    			double roomRent=sc.nextDouble();
    			System.out.println("Room No:");
    			String roomNumber=sc.next();
    			
    			
    			hotelService.addRoom(cityId,hotelId,roomId++,roomType,roomRent,roomNumber);
    			
    			
    			
    			
    			
    			break;
    			
    		case 8:
    			
    			System.out.println("Enter City Id in which Room is to be removed :");
    			int cityId4=sc.nextInt();
    			
    			System.out.println("Enter Hotel Id in which Room is to be removed:");
    			int hotelId3=sc.nextInt();
    			
    			System.out.println("Enter Room Id to be removed :");
    			int roomId1=sc.nextInt();
    			
    			hotelService.removeRoom(cityId,hotelId,roomId);
    			
    		break;
    			
    			
    		}
    		
    		break;
    	case 2:
    		//printCustomerDetails();
    		int customerChoice=sc.nextInt();
    		
    		break;
    	}
    	
    	sc.close();
    	
 }
    public static void printAdminDetails()
    {
    	System.out.println("Enter 1 to Add a City");
    	System.out.println("Enter 2 to Remove a City");
    	System.out.println("Enter 3 to Update a City");
    	System.out.println("Enter 4 to Add a Hotel");
    	System.out.println("Enter 5 to Remove a Hotel");
    	System.out.println("Enter 6 to Update a Hotel");
    	System.out.println("Enter 7 to Add a Room");
    	System.out.println("Enter 8 to Remove a Room");
    	System.out.println("Enter 3 to Update a Room");
    }
    
    public static void printHotelUpdateOptions()
    {
    	System.out.println("Enter 1 to Update Hotel Name :");
    	System.out.println("Enter 2 to Update Hotel Address :");
    	System.out.println("Enter 3 to Update Hotel Contact No :");
    	System.out.println("Enter 4 to Update Hotel Rating :");
    }

}
