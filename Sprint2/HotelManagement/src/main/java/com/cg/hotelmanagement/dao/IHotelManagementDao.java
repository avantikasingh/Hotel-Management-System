package com.cg.hotelmanagement.dao;

import com.cg.hotelmanagement.dto.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface IHotelManagementDao {

    public List<Customer> showCustomerList();

    public boolean addCustomer(Customer customer);

    public Map<Integer,City> showCityList();

    public boolean addCity(City city);
    
    public boolean removeCity(int cityId);

    public boolean addHotel(int cityId,Hotel hotel);

    public boolean removeHotel(int cityId,int hotelId);

    public Hotel updateHotel(Hotel hotelOld, Hotel hotelUpdated, City city, IHotelManagementDao hotelManagementDao);

    public boolean addRoom(int cityId,int hotelId,Room newRoom);

    public boolean removeRoom(int cityId, int hotelId,int roomId);

    public Room updateRoom(Room roomOld, Room roomUpdated, Hotel hotel, City city, IHotelManagementDao hotelManagementDao);

    public List<Admin> showAdminList();

    public List<Booking> showBookingList();

    //public boolean addBooking(Booking booking);

    public boolean addBooking(int cityId, int hotelId, int roomId, Booking booking);

    public boolean showHotel(int cityId);

    public boolean showRoom(int cityId, int hotelId);

    public Map<Integer, Hotel> viewHotel(Date checkIn, Date checkOut, int cityId, boolean sortByPrice);



}
