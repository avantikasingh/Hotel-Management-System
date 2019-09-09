package com.cg.hotelmanagement.service;

import com.cg.hotelmanagement.dao.HotelManagementDao;
import com.cg.hotelmanagement.dao.HotelManagementDaoImpl;
import com.cg.hotelmanagement.dto.Admin;
import com.cg.hotelmanagement.dto.Booking;
import com.cg.hotelmanagement.dto.Customer;
import com.cg.hotelmanagement.dto.Hotel;

import java.util.List;

public class HotelManagementServiceImpl implements HotelManagementService{

    HotelManagementDao hotelManagementDao = new HotelManagementDaoImpl();

    @Override
    public List<Customer> showCustomerList() {
        return hotelManagementDao.showCustomerList();
    }

    @Override
    public boolean addCustomer(Customer customer) {
        return hotelManagementDao.addCustomer(customer);
    }

    @Override
    public List<Hotel> showHotelList() {
        return hotelManagementDao.showHotelList();
    }

    @Override
    public boolean addHotel(Hotel hotel) {
        return hotelManagementDao.addHotel(hotel);
    }

    @Override
    public boolean removeHotel(Hotel hotel) {
        return hotelManagementDao.removeHotel(hotel);
    }

    @Override
    public Hotel updateHotel(Hotel hotel) {
        return hotelManagementDao.updateHotel(hotel);
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
