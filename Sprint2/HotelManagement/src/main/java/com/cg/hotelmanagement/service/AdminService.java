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
    public boolean addHotel(int cityId, Hotel hotel, IHotelManagementDao hotelManagement) {
        return adminDao.addHotel(cityId, hotel, hotelManagement);
    }

    @Override
    public boolean removeHotel(int cityId, int hotelId, IHotelManagementDao hotelManagement) {
        return adminDao.removeHotel(cityId, hotelId, hotelManagement);
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
    public boolean removeRoom(int cityId, int hotelId,int roomId, IHotelManagementDao hotelManagement) {
        return adminDao.removeRoom(cityId, hotelId, roomId, hotelManagement);
    }

    @Override
    public boolean addRoom(int cityId,int hotelId,Room newRoom, IHotelManagementDao hotelManagement) {
        return adminDao.addRoom(cityId, hotelId, newRoom, hotelManagement);
    }

    @Override
    public boolean approveBooking(int cityId, int hotelId, int roomId, LocalDate checkIn, LocalDate checkOut) {
        return false;
    }
}
