package com.cg.hotelmanagement.dao;

import com.cg.hotelmanagement.dto.*;
import com.cg.hotelmanagement.service.CompareByDate;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class AdminDao implements IAdminDao {

    private Map<BigInteger,Customer> customerList =  new HashMap<>();
    private Map<BigInteger,City> cityList= new HashMap<>();
    private Map<BigInteger,Admin> adminList = new HashMap<>();
    private Map<BigInteger,Booking> bookingList = new HashMap<>();

   
    
    public boolean addCity(){
		City city1 = new City("Mumbai",BigInteger.valueOf(1),new HashMap<BigInteger,Hotel>());
		City city2 = new City("Pune",BigInteger.valueOf(2),new HashMap<BigInteger,Hotel>());
		City city3 = new City("Delhi",BigInteger.valueOf(3),new HashMap<BigInteger,Hotel>());
		City city4 = new City("Banglore",BigInteger.valueOf(4),new HashMap<BigInteger,Hotel>());
		cityList.put(city1.getCityId(), city1);
		cityList.put(city2.getCityId(), city2);
		cityList.put(city3.getCityId(), city3);
		cityList.put(city4.getCityId(), city4);
    	return true;
    	
    }
  

    public boolean addCity(City city){
        if(this.cityList==null)
            cityList = new HashMap<BigInteger,City>();
        
        cityList.put(city.getCityId(),city);
        return true;
    }
    
    public boolean removeCity(BigInteger cityId){
        cityList.remove(cityId);
        return true;
    }

   
    public boolean addHotel(){
    	Hotel hotel1 = new Hotel(BigInteger.valueOf(1),"Taj","Mumbai",new HashMap<BigInteger,Room>(),BigInteger.valueOf(100),4.9f);
    	Hotel hotel2 = new Hotel(BigInteger.valueOf(2),"Taj","Mumbai",new HashMap<BigInteger,Room>(),BigInteger.valueOf(100),4.9f);
    	Hotel hotel3 = new Hotel(BigInteger.valueOf(3),"ITC","Pune",new HashMap<BigInteger,Room>(),BigInteger.valueOf(100),4.9f);
    	Hotel hotel4 = new Hotel(BigInteger.valueOf(4),"ITC","Pune",new HashMap<BigInteger,Room>(),BigInteger.valueOf(100),4.9f);
    	Hotel hotel5 = new Hotel(BigInteger.valueOf(5),"JW","Banglore",new HashMap<BigInteger,Room>(),BigInteger.valueOf(100),4.9f);
    	Hotel hotel6 = new Hotel(BigInteger.valueOf(6),"JW","Banglore",new HashMap<BigInteger,Room>(),BigInteger.valueOf(100),4.9f);
    	addHotel(BigInteger.valueOf(1),hotel1);
    	addHotel(BigInteger.valueOf(1),hotel2);
    	addHotel(BigInteger.valueOf(2),hotel3);
    	addHotel(BigInteger.valueOf(2),hotel4);
    	addHotel(BigInteger.valueOf(3),hotel5);
    	addHotel(BigInteger.valueOf(3),hotel6);
    	return true;
    }
    

    public boolean addHotel(BigInteger cityId,Hotel hotel){
    	
    	City city=cityList.get(cityId);
    	city.getHotelList().put(hotel.getHotelId(),hotel);
    	
        return true;
    }
    

    public boolean removeHotel(BigInteger cityId,BigInteger hotelId){
    	
    	City city=cityList.get(cityId);
    	city.getHotelList().remove(hotelId);
    	
    	return true;
   
    }

   
    public boolean addRoom(){
    	//BigInteger roomId, String roomType, Double roomRent, String roomNumber, List<Booking> bookingList
    	Room room1 = new Room(BigInteger.valueOf(1),"Deluxe",10000.0d,"101",new LinkedList<>());
    	Room room2 = new Room(BigInteger.valueOf(2),"Premium",1000.0d,"102",new LinkedList<>());
    	Room room3 = new Room(BigInteger.valueOf(3),"Standard",100.0d,"103",new LinkedList<>());
    	Room room4 = new Room(BigInteger.valueOf(4),"Deluxe",10000.0d,"101",new LinkedList<>());
    	Room room5 = new Room(BigInteger.valueOf(5),"Premium",1000.0d,"102",new LinkedList<>());
    	Room room6 = new Room(BigInteger.valueOf(6),"Standard",100.0d,"103",new LinkedList<>());
    	Room room7 = new Room(BigInteger.valueOf(7),"Deluxe",10000.0d,"101",new LinkedList<>());
    	Room room8 = new Room(BigInteger.valueOf(8),"Premium",1000.0d,"102",new LinkedList<>());
    	Room room9 = new Room(BigInteger.valueOf(9),"Standard",100.0d,"103",new LinkedList<>());
    	Room room10 = new Room(BigInteger.valueOf(10),"Deluxe",10000.0d,"104",new LinkedList<>());
    	addRoom(BigInteger.valueOf(1),BigInteger.valueOf(1),room1);
    	addRoom(BigInteger.valueOf(1),BigInteger.valueOf(1),room1);
    	addRoom(BigInteger.valueOf(1),BigInteger.valueOf(1),room1);
    	addRoom(BigInteger.valueOf(2),BigInteger.valueOf(1),room1);
    	addRoom(BigInteger.valueOf(2),BigInteger.valueOf(1),room1);
    	addRoom(BigInteger.valueOf(2),BigInteger.valueOf(1),room1);
    	addRoom(BigInteger.valueOf(2),BigInteger.valueOf(2),room1);
    	addRoom(BigInteger.valueOf(2),BigInteger.valueOf(2),room1);
    	addRoom(BigInteger.valueOf(3),BigInteger.valueOf(1),room1);
    	addRoom(BigInteger.valueOf(4),BigInteger.valueOf(1),room1);
    	return true;
    }
    
    
    @Override
    public boolean addRoom(BigInteger cityId,BigInteger hotelId,Room newRoom) {
    	
    	
    	
    	City city=cityList.get(cityId);
    	Hotel hotel=city.getHotelList().get(hotelId);
    	
    	hotel.getRoomList().put(newRoom.getRoomId(),newRoom);
    	
    	return true;
    }
    	
    	
    	
    	
       
    @Override
	public boolean removeRoom(BigInteger cityId, BigInteger hotelId,BigInteger roomId) {

		City city = cityList.get(cityId);
		Hotel hotel=city.getHotelList().get(hotelId);
		
		hotel.getRoomList().remove(roomId);

		return true;

	}

	@Override
	public Map<BigInteger, Hotel> viewHotels(Date checkIn, Date checkOut,
			BigInteger cityId, boolean sortByRating) {
		System.out.println("1");
		Map<BigInteger,Room> availableRoom = new HashMap<>();
		if(cityList.containsKey(cityId)){
			System.out.println("2");
			City city = cityList.get(cityId);
			System.out.println("City");
			System.out.println(city);
			Map<BigInteger,Hotel> hotelMap = city.getHotelList();
			System.out.println("Hotels");
			System.out.println(hotelMap);
			for(Map.Entry<BigInteger, Hotel> entry1: hotelMap.entrySet()){
				Hotel hotel = entry1.getValue();
				Map<BigInteger,Room> roomMap = hotel.getRoomList();
				for(Map.Entry<BigInteger, Room> entry2: roomMap.entrySet()){
					Room room = entry2.getValue();
					System.out.println("Room");
					System.out.println(room);
					List<Booking> bookingList = room.getBookingList();
					
					System.out.println(bookingList);
					List<Date> bookingDate = new LinkedList<>();
					for(Booking booking: bookingList){
						bookingDate.add(booking.getCheckIn());
						bookingDate.add(booking.getCheckOut());
					}
					Collections.sort(bookingDate, new CompareByDate());
					System.out.println("Sorted Booking list");
					System.out.println(bookingDate);
					if(checkOut.before(bookingDate.get(0)))
					{
						availableRoom.put(room.getRoomId(),room);
						continue;
					}
					int i=1;
					while(checkIn.after(bookingDate.get(i))){
						i=i+2;
						if(i>bookingDate.size()-1)
							break;
					}
					if(i>bookingDate.size()-1)
					{
						availableRoom.put(room.getRoomId(),room);
						continue;
					}
					if(checkOut.before(bookingDate.get(i+1)))
					{
						availableRoom.put(room.getRoomId(),room);
						continue;
					}
						
				}
			}
		}
		else{
			System.out.println("Id does not exits"); //Throw exception
		}
		return null;
	}

	@Override
	public Booking makeBooking(BigInteger hotelId, Date checkIn, Date checkOut,
			BigInteger roomId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean register() {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
    public boolean addBooking(BigInteger cityId, BigInteger hotelId, BigInteger roomId, Booking booking) {
        if(cityList.containsKey(cityId)) {
            City city = cityList.get(cityId);
            Hotel hotel = city.getHotelList().get(hotelId);
            Room room = hotel.getRoomList().get(roomId);
            List<Booking> list = new LinkedList<>();
            list.add(booking);
            room.setBookingList(list);
            System.out.println(room.getBookingList());
        }
        else
            System.out.println("City does not exist");
        return true;
    }


  

}
