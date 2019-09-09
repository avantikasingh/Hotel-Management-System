package com.cg.hotelmanagement.dao;

import com.cg.hotelmanagement.dto.Hotel;
import com.cg.hotelmanagement.dto.Room;

public class AdminDaoImpl implements AdminDao {

    @Override
    public boolean addHotel(Hotel hotel, HotelManagementDao hotelManagement) {
        return hotelManagement.addHotel(hotel);
    }

    @Override
    public boolean removeHotel(Hotel hotel, HotelManagementDao hotelManagement) {
        return hotelManagement.removeHotel(hotel);
    }

    @Override
    public Hotel updateHotel(Hotel hotel, HotelManagementDao hotelManagement) {
        return hotelManagement.updateHotel(hotel);
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

}
