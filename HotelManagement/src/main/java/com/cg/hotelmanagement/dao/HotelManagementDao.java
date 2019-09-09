package com.cg.hotelmanagement.dao;

import com.cg.hotelmanagement.dto.Admin;
import com.cg.hotelmanagement.dto.Booking;
import com.cg.hotelmanagement.dto.Customer;
import com.cg.hotelmanagement.dto.Hotel;

import java.util.List;

public interface HotelManagementDao {

    public List<Customer> showCustomerList();

    public boolean addCustomer(Customer customer);

    public List<Hotel> showHotelList();

    public boolean addHotel(Hotel hotel);

    public boolean removeHotel(Hotel hotel);

    public Hotel updateHotel(Hotel hotel);

    public List<Admin> showAdminList();

    public List<Booking> showBookingList();

    public boolean addBooking(Booking booking);

}
