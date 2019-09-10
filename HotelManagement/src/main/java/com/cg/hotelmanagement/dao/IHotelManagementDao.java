package com.cg.hotelmanagement.dao;

import com.cg.hotelmanagement.dto.*;

import java.util.List;

public interface IHotelManagementDao {

    public List<Customer> showCustomerList();

    public boolean addCustomer(Customer customer);

    public List<City> showCityList();

    public boolean addCity(City city);

    public boolean addHotel(Hotel hotel, City city, IHotelManagementDao hotelManagementDao);

    public boolean removeHotel(Hotel hotel, City city, IHotelManagementDao hotelManagementDao);

    public Hotel updateHotel(Hotel hotelOld, Hotel hotelUpdated, City city, IHotelManagementDao hotelManagementDao);

    public boolean addRoom(Room room, Hotel hotel, City city, IHotelManagementDao hotelManagementDao);

    public boolean removeRoom(Room room, Hotel hotel, City city, IHotelManagementDao hotelManagementDao);

    public Room updateRoom(Room roomOld, Room roomUpdated, Hotel hotel, City city, IHotelManagementDao hotelManagementDao);

    public List<Admin> showAdminList();

    public List<Booking> showBookingList();

    public boolean addBooking(Booking booking);

}
