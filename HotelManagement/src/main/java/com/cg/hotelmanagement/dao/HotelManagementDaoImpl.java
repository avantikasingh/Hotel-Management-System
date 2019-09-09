package com.cg.hotelmanagement.dao;

import com.cg.hotelmanagement.dto.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HotelManagementDaoImpl implements HotelManagementDao{

    private List<Customer> customerList = new ArrayList<>();
    private List<Hotel> hotelList = new ArrayList<>();
    private List<Admin> adminList = new ArrayList<>();
    private List<Booking> bookingList = new ArrayList<>();
    private List<Room> roomList = new ArrayList<>();
    private Map<String, Integer> roomMap = new HashMap<>();

    public List<Customer> showCustomerList() {
        return customerList;
    }

    public boolean addCustomer(Customer customer) {
        this.customerList.add(customer);
        return true;
    }

    public List<Hotel> showHotelList() {
        return hotelList;
    }

    public boolean addHotel(Hotel hotel){
        hotelList.add(hotel);
        return true;
    }

    public boolean removeHotel(Hotel hotel){
        hotelList.remove(hotel);
        return true;
    }

    public Hotel updateHotel(Hotel hotel){
        return hotel;
    }

    public List<Admin> showAdminList() {
        return adminList;
    }

    public List<Booking> showBookingList() {
        return bookingList;
    }

    public boolean addBooking(Booking booking){
        bookingList.add(booking);
        return true;
    }
    
    public boolean addRoom(Room room) {
		if(roomMap.containsKey(room.getRoomId()))
			roomMap.put(room.getRoomType(), roomMap.get(room.getRoomType())+1);
		else
			roomMap.put(room.getRoomType(), 1);	
    	return false;
    }
    
    public boolean removeRoom(Room room) {
		if(roomMap.containsKey(room.getRoomType())) {
			if(roomMap.get(room.getRoomType())==1)
				roomMap.put(room.getRoomType(), 0);
			roomMap.put(room.getRoomType(), roomMap.get(room.getRoomType())-1);
		}
    	return false;
    }
    
    public boolean updateRoom() {
		return false;
    }

}
