package com.cg.hotelmanagement.dao;

import com.cg.hotelmanagement.dto.City;
import com.cg.hotelmanagement.dto.Hotel;
import com.cg.hotelmanagement.dto.Room;

public class AdminDao implements IAdminDao {

    @Override
    public boolean addHotel(Hotel hotel, City city, IHotelManagementDao hotelManagement) {
        return hotelManagement.addHotel(hotel, city, hotelManagement);
    }

    @Override
    public boolean removeHotel(Hotel hotel, City city, IHotelManagementDao hotelManagement) {
        return hotelManagement.removeHotel(hotel, city, hotelManagement);
    }

    @Override
    public Hotel updateHotel(Hotel hotelOld, Hotel hotelUpdated, City city, IHotelManagementDao hotelManagement) {
        return hotelManagement.updateHotel(hotelOld, hotelUpdated, city, hotelManagement);
    }

    @Override
    public Room updateRoom(Room roomOld, Room roomUpdated, Hotel hotel, City city, IHotelManagementDao hotelManagement) {
        return hotelManagement.updateRoom(roomOld, roomUpdated, hotel, city, hotelManagement);
    }

    @Override
    public boolean removeRoom(Room room, Hotel hotel, City city, IHotelManagementDao hotelManagement) {
        return hotelManagement.removeRoom(room, hotel, city, hotelManagement);
    }

    @Override
    public boolean addRoom(Room room, Hotel hotel, City city, IHotelManagementDao hotelManagement) {
        return hotelManagement.addRoom(room, hotel, city, hotelManagement);
    }

}
