package com.cg.hotelmanagement.service;

import com.cg.hotelmanagement.dao.AdminDao;
import com.cg.hotelmanagement.dao.IAdminDao;
import com.cg.hotelmanagement.dao.IHotelManagementDao;
import com.cg.hotelmanagement.dto.City;
import com.cg.hotelmanagement.dto.Hotel;
import com.cg.hotelmanagement.dto.Room;

import java.time.LocalDate;

public class AdminService implements IAdminService {

    IAdminDao adminDao = new AdminDao();


    @Override
    public boolean addHotel(Hotel hotel, City city, IHotelManagementDao hotelManagement) {
        return adminDao.addHotel(hotel, city, hotelManagement);
    }

    @Override
    public boolean removeHotel(Hotel hotel, City city, IHotelManagementDao hotelManagement) {
        return adminDao.removeHotel(hotel, city, hotelManagement);
    }

    @Override
    public Hotel updateHotel(Hotel hotelOld, Hotel hotelUpdated, City city, IHotelManagementDao hotelManagement) {
        return adminDao.updateHotel(hotelOld, hotelUpdated, city, hotelManagement);
    }

    @Override
    public Room updateRoom(Room roomOld, Room roomUpdated, Hotel hotel, City city, IHotelManagementDao hotelManagement) {
        return adminDao.updateRoom(roomOld,roomUpdated,hotel,city,hotelManagement);
    }

    @Override
    public boolean removeRoom(Room room, Hotel hotel, City city, IHotelManagementDao hotelManagement) {
        return adminDao.removeRoom(room, hotel, city, hotelManagement);
    }

    @Override
    public boolean addRoom(Room room, Hotel hotel, City city, IHotelManagementDao hotelManagement) {
        return adminDao.addRoom(room, hotel, city, hotelManagement);
    }

    @Override
    public boolean approveBooking(Room room, City city, Hotel hotel, LocalDate checkIn, LocalDate checkOut, boolean sortByPrice) {
        return false;
    }
}
