package com.cg.hotelmanagement.service;

import com.cg.hotelmanagement.dao.HotelManagementDao;
import com.cg.hotelmanagement.dao.IHotelManagementDao;
import com.cg.hotelmanagement.dto.*;

import java.util.List;

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
    public List<City> showCityList() {
        return hotelManagementDao.showCityList();
    }

    @Override
    public boolean addHotel(Hotel hotel, City city) {
        return hotelManagementDao.addHotel(hotel,city,hotelManagementDao);
    }

    @Override
    public boolean removeHotel(Hotel hotel, City city) {
        return hotelManagementDao.removeHotel(hotel, city, hotelManagementDao);
    }

    @Override
    public Hotel updateHotel(Hotel hotelOld, Hotel hotelUpdated, City city) {
        return hotelManagementDao.updateHotel(hotelOld, hotelUpdated, city, hotelManagementDao);
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
