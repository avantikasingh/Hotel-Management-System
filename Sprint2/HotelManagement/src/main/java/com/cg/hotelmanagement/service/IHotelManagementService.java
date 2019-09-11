package com.cg.hotelmanagement.service;

import com.cg.hotelmanagement.dto.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface IHotelManagementService {

    public List<Customer> showCustomerList();

    public boolean addCustomer(Customer customer);
    
    public boolean addCity(int cityId, String cityName);
    
    public boolean removeCity(int cityId);

    public Map<Integer,City> showCityList();

    public boolean addHotel(int cityId1,int hotelId,String hotelName,String hotelAddress,int hotelPhoneNumber,float hotelRating);

    public boolean removeHotel(int cityId,int hotelId);
    
    public boolean addRoom(int cityId,int hotelId,int roomId,String roomType,double roomRent,String roomNumber);

    public boolean removeRoom(int cityId,int hotelId,int roomId);
    
    public Hotel updateHotel(Hotel hotelOld, Hotel hotelUpdated, City city);

    public List<Admin> showAdminList();

    public List<Booking> showBookingList();

    //public boolean addBooking(Booking booking);

    public boolean showHotel(int cityId);

    public boolean showRoom(int cityId, int roomId);

    public Map<Integer,Hotel> viewHotel(Date checkIn, Date checkOut, int cityId, boolean sortByPrice);

    public boolean addBooking(int cityId, int hotelId, int roomId, Booking booking);

	

}
