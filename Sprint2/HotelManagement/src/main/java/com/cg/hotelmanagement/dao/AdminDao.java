package com.cg.hotelmanagement.dao;

import com.cg.hotelmanagement.dto.City;
import com.cg.hotelmanagement.dto.Hotel;
import com.cg.hotelmanagement.dto.Room;

public class AdminDao implements IAdminDao {

    //IHotelManagementDao hotelManagementDao = new HotelManagementDao();

    @Override
    public boolean addHotel(int cityId, Hotel hotel, IHotelManagementDao hotelManagement) {
        return hotelManagement.addHotel(cityId, hotel);
    }

    @Override
    public boolean removeHotel(int cityId, int hotelId, IHotelManagementDao hotelManagement) {
        return hotelManagement.removeHotel(cityId, hotelId);
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
    public boolean removeRoom(int cityId, int hotelId,int roomId, IHotelManagementDao hotelManagement) {
        return hotelManagement.removeRoom(cityId,hotelId,roomId);
    }

    @Override
    public boolean addRoom(int cityId,int hotelId,Room newRoom, IHotelManagementDao hotelManagement) {
        return hotelManagement.addRoom(cityId,hotelId,newRoom);
    }

}
