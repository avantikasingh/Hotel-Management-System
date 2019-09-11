package com.cg.hotelmanagement.dao;

import com.cg.hotelmanagement.dto.*;
import com.cg.hotelmanagement.service.CompareByDate;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
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

    static int bookingId=3000;
    
    public boolean addCity(City city){
        if(this.cityList==null)
            cityList = new HashMap<BigInteger,City>();
        
        cityList.put(city.getCityId(),city);
        return true;
    }
    
    public boolean removeCity(BigInteger cityId){
    	if(cityList.containsKey(cityId))
    		cityList.remove(cityId);
    	else
    		System.out.println("City does not exist");
        return true;
    }

    public boolean addHotel(BigInteger cityId,Hotel hotel){
    	
    	City city=cityList.get(cityId);
    	city.getHotelList().put(hotel.getHotelId(),hotel);
    	
        return true;
    }
    

    public boolean removeHotel(BigInteger cityId,BigInteger hotelId){
    	
    	if(cityList.containsKey(cityId)) {
    		City city=cityList.get(cityId);
    		if(city.getHotelList().containsKey(hotelId))
    			city.getHotelList().remove(hotelId);
    		else
    			System.out.println("Hotel does not exist");
    	}
    	else
    		System.out.println("City does not exist");
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

    	if(cityList.containsKey(cityId)) {
    		City city = cityList.get(cityId);
    		if(city.getHotelList().containsKey(hotelId)) {
    			Hotel hotel=city.getHotelList().get(hotelId);
    			if(hotel.getRoomList().containsKey(roomId))
    				hotel.getRoomList().remove(roomId);
    			else
    				System.out.println("Room does not exist");
    		}
    		else
    			System.out.println("Hotel does not exist");
    	}
    	else
    		System.out.println("City does not exist");
		

		return true;

	}

//	@Override
//	public Map<BigInteger, Hotel> viewHotels(Date checkIn, Date checkOut,
//			BigInteger cityId, boolean sortByRating) {
//		System.out.println("1");
//		Map<BigInteger,Room> availableRoom = new HashMap<>();
//		if(cityList.containsKey(cityId)){
//			System.out.println("2");
//			City city = cityList.get(cityId);
//			System.out.println("City");
//			System.out.println(city);
//			Map<BigInteger,Hotel> hotelMap = city.getHotelList();
//			System.out.println("Hotels");
//			System.out.println(hotelMap);
//			for(Map.Entry<BigInteger, Hotel> entry1: hotelMap.entrySet()){
//				Hotel hotel = entry1.getValue();
//				Map<BigInteger,Room> roomMap = hotel.getRoomList();
//				for(Map.Entry<BigInteger, Room> entry2: roomMap.entrySet()){
//					Room room = entry2.getValue();
//					System.out.println("Room");
//					System.out.println(room);
//					List<Booking> bookingList = room.getBookingList();
//					
//					System.out.println(bookingList);
//					List<Date> bookingDate = new LinkedList<>();
//					for(Booking booking: bookingList){
//						bookingDate.add(booking.getCheckIn());
//						bookingDate.add(booking.getCheckOut());
//					}
//					Collections.sort(bookingDate, new CompareByDate());
//					System.out.println("Sorted Booking list");
//					System.out.println(bookingDate);
//					if(checkOut.before(bookingDate.get(0)))
//					{
//						availableRoom.put(room.getRoomId(),room);
//						continue;
//					}
//					int i=1;
//					while(checkIn.after(bookingDate.get(i))){
//						i=i+2;
//						if(i>bookingDate.size()-1)
//							break;
//					}
//					if(i>bookingDate.size()-1)
//					{
//						availableRoom.put(room.getRoomId(),room);
//						continue;
//					}
//					if(checkOut.before(bookingDate.get(i+1)))
//					{
//						availableRoom.put(room.getRoomId(),room);
//						continue;
//					}
//						
//				}
//			}
//		}
//		else{
//			System.out.println("Id does not exits"); //Throw exception
//		}
//		return null;
//	}


	@Override
	public boolean register(Customer customer) {
		customerList.put(customer.getCustomerId(), customer);
		return true;
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

	public Map<BigInteger, Customer> getCustomerList() {
		return customerList;
	}

	public void setCustomerList(Map<BigInteger, Customer> customerList) {
		this.customerList = customerList;
	}

	public Map<BigInteger, City> getCityList() {
		return cityList;
	}

	public void setCityList(Map<BigInteger, City> cityList) {
		this.cityList = cityList;
	}

	public Map<BigInteger, Admin> getAdminList() {
		return adminList;
	}

	public void setAdminList(Map<BigInteger, Admin> adminList) {
		this.adminList = adminList;
	}

	public Map<BigInteger, Booking> getBookingList() {
		return bookingList;
	}

	public void setBookingList(Map<BigInteger, Booking> bookingList) {
		this.bookingList = bookingList;
	}

	@Override
	public void viewHotels(BigInteger cityId, BigInteger hotelId) {
		if(cityList.containsKey(cityId)) {
			City city = cityList.get(cityId);
			System.out.println(city);
		}
		else
			System.out.println("City does not exist");
	}


	@Override
	public Map<BigInteger, Hotel> viewHotels(Date checkIn, Date checkOut, BigInteger cityId, boolean sortByRating) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void makeBooking(BigInteger cityId, BigInteger hotelId, Date checkIn, Date checkOut, BigInteger roomId) {
		if(cityList.containsKey(cityId)) {
			City city = cityList.get(cityId);
			Map<BigInteger,Hotel> hotMap = city.getHotelList();
			if(hotMap.containsKey(hotelId)) {
				Hotel hotel = hotMap.get(hotelId);
				Map<BigInteger,Room> rMap = hotel.getRoomList();
				if(rMap.containsKey(roomId)) {
					Room room = rMap.get(roomId);
					Date date = new Date();
					Booking booking = new Booking("23","Approved",date,checkIn,checkOut,BigDecimal.valueOf(12d));
				}
			}
		}
		
	}
	



  

}
