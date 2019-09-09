package com.cg.hotelmanagement.service;

import com.cg.hotelmanagement.dao.AdminDao;
import com.cg.hotelmanagement.dao.AdminDaoImpl;
import com.cg.hotelmanagement.dao.HotelManagementDao;
import com.cg.hotelmanagement.dto.Hotel;
import com.cg.hotelmanagement.dto.Room;

import java.time.LocalDate;

public class AdminServiceImpl implements AdminService {

    AdminDao adminDao = new AdminDaoImpl();


    @Override
    public boolean addHotel(Hotel hotel, HotelManagementDao hotelManagement) {
        return adminDao.addHotel(hotel, hotelManagement);
    }

    @Override
    public boolean removeHotel(Hotel hotel, HotelManagementDao hotelManagement) {
        return adminDao.removeHotel(hotel, hotelManagement);
    }

    @Override
    public Hotel updateHotel(Hotel hotel, HotelManagementDao hotelManagement) {
        return adminDao.updateHotel(hotel, hotelManagement);
    }

    @Override
    public Room updateRoom(Room room, HotelManagementDao hotelManagement) {
        return null;
    }

    @Override
    public boolean removeRoom(Room room, HotelManagementDao hotelManagement) {
        return false;
    }

    @Override
    public boolean addRoom(Room room, HotelManagementDao hotelManagement) {
        return false;
    }

    @Override
    public boolean approveBooking(Hotel hotel, LocalDate checkIn, LocalDate checkOut, boolean sortByPrice) {
        return false;
    }
}
