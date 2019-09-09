package com.cg.hotelmanagement.dao;

import com.cg.hotelmanagement.dto.Hotel;
import com.cg.hotelmanagement.dto.Room;

public interface AdminDao {

    public boolean addHotel(Hotel hotel, HotelManagementDao hotelManagement);

    public boolean removeHotel(Hotel hotel, HotelManagementDao hotelManagement);

    public Hotel updateHotel(Hotel hotel, HotelManagementDao hotelManagement);

    public Room updateRoom(Room room, HotelManagementDao hotelManagement);

    public boolean removeRoom(Room room, HotelManagementDao hotelManagement);

    public boolean addRoom(Room room, HotelManagementDao hotelManagement);

}
