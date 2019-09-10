package com.cg.hotelmanagement.service;

import com.cg.hotelmanagement.dao.HotelManagementDao;
import com.cg.hotelmanagement.dao.IHotelManagementDao;
import com.cg.hotelmanagement.dto.*;

import java.math.BigInteger;
import java.util.HashMap;

import java.util.List;
import java.util.Map;

public class HotelManagementService implements IHotelManagementService {

    IHotelManagementDao hotelManagementDao = new HotelManagementDao();

    @Override
    public List<Customer> showCustomerList() {
        return hotelManagementDao.showCustomerList();
    }

    @Override
    public boolean addCustomer(Customer customer) {
        return hotelManagementDao.addCustomer(customer);
    }

    @Override
    public Map<Integer,City> showCityList() {
        return hotelManagementDao.showCityList();
    }
    
    @Override
    public boolean addCity(int cityId, String cityName) {
    	City city=new City(cityName,cityId,new HashMap<Integer,Hotel>());
        return hotelManagementDao.addCity(city);
    }
    
    public boolean removeCity(int cityId) {
        return hotelManagementDao.removeCity(cityId);
    }

    @Override
    public boolean addHotel(int cityId1,int hotelId,String hotelName,String hotelAddress,int hotelPhoneNumber,float hotelRating) {
        
    	HashMap<Integer, Room> roomList=new HashMap<Integer,Room>();
    	
    	Hotel newHotel=new Hotel(hotelId,hotelName, hotelAddress,roomList,
			BigInteger.valueOf(hotelPhoneNumber), hotelRating);		//create Hotel object
    	return hotelManagementDao.addHotel(cityId1,newHotel);	//add new hotel in the hotelList of the city
    }

    @Override
    public boolean removeHotel(int cityId,int hotelId) {
        return hotelManagementDao.removeHotel(cityId, hotelId);
    }

    @Override
    public Hotel updateHotel(Hotel hotelOld, Hotel hotelUpdated, City city) {
        return hotelManagementDao.updateHotel(hotelOld, hotelUpdated, city, hotelManagementDao);
    }

    public boolean addRoom(int cityId,int hotelId,int roomId,String roomType,double roomRent,String roomNumber) {
        
    	Room newRoom=new Room(roomId,roomType,roomRent,roomNumber);		//create Hotel object
    	return hotelManagementDao.addRoom(cityId,hotelId,newRoom);	//add new room in the roomList of the hotel
    }
    
    public boolean removeRoom(int cityId,int hotelId,int roomId){
    	
    	return hotelManagementDao.removeRoom(cityId, hotelId, roomId);
    	
    }
    
    
    @Override
    public List<Admin> showAdminList() {
        return hotelManagementDao.showAdminList();
    }

    @Override
    public List<Booking> showBookingList() {
        return hotelManagementDao.showBookingList();
    }

    @Override
    public boolean addBooking(Booking booking) {
        return hotelManagementDao.addBooking(booking);
    }
}
