package com.cg.hotelmanagement.service;

import com.cg.hotelmanagement.dto.*;

import java.util.List;

public interface IHotelManagementService {

    public List<Customer> showCustomerList();

    public boolean addCustomer(Customer customer);

    public List<City> showCityList();

    public boolean addHotel(Hotel hotel, City city);

    public boolean removeHotel(Hotel hotel, City city);

    public Hotel updateHotel(Hotel hotelOld, Hotel hotelUpdated, City city);

    public List<Admin> showAdminList();

    public List<Booking> showBookingList();

    public boolean addBooking(Booking booking);

}
