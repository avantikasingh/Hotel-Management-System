package com.cg.hotelmanagement.service;

import com.cg.hotelmanagement.dao.AdminDao;
import com.cg.hotelmanagement.dao.IAdminDao;
import com.cg.hotelmanagement.dto.*;

import java.math.BigInteger;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class AdminService implements IAdminService {

    IAdminDao adminDao = new AdminDao();
   
    
    @Override
    public boolean addCity(BigInteger cityId, String cityName) {
    	City city=new City(cityName,cityId,new HashMap<BigInteger,Hotel>());
        return adminDao.addCity(city);
    }
    
    public boolean addCity(){
    	return adminDao.addCity();
    }
    
    public boolean removeCity(BigInteger cityId) {
        return adminDao.removeCity(cityId);
    }

    @Override
    public boolean addHotel(BigInteger cityId1,BigInteger hotelId,String hotelName,String hotelAddress,int hotelPhoneNumber,float hotelRating) {
        
    	HashMap<BigInteger, Room> roomList=new HashMap<BigInteger,Room>();
    	
    	Hotel newHotel=new Hotel(hotelId,hotelName, hotelAddress,roomList,
			BigInteger.valueOf(hotelPhoneNumber), hotelRating);		//create Hotel object
    	return adminDao.addHotel(cityId1,newHotel);	//add new hotel in the hotelList of the city
    }

    @Override
    public boolean removeHotel(BigInteger cityId,BigInteger hotelId) {
        return adminDao.removeHotel(cityId, hotelId);
    }


    public boolean addRoom(BigInteger cityId,BigInteger hotelId,BigInteger roomId,String roomType,double roomRent,String roomNumber) {
        
    	Room newRoom=new Room(roomId,roomType,roomRent,roomNumber, new LinkedList<Booking>());		//create Hotel object
    	return adminDao.addRoom(cityId,hotelId,newRoom);	//add new room in the roomList of the hotel
    }
    
    public boolean removeRoom(BigInteger cityId,BigInteger hotelId,BigInteger roomId){
    	
    	return adminDao.removeRoom(cityId, hotelId, roomId);
    	
    }

	@Override
	public boolean addBooking(BigInteger cityId, BigInteger hotelId,
			BigInteger roomId, Booking booking) {
		return adminDao.addBooking(cityId, hotelId, roomId, booking);
	}
	
	public Map<BigInteger, Hotel> viewHotels(Date checkIn, Date checkOut,
			BigInteger cityId, boolean sortByRating)
			{
				return adminDao.viewHotels(checkIn, checkOut, cityId, sortByRating);
			}

	@Override
	public boolean addRoom() {
		return adminDao.addRoom();
	}

	@Override
	public boolean addHotel() {
		return adminDao.addHotel();
	}
    
}
