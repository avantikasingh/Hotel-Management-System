package com.cg.hotelmanagement.dao;

import com.cg.hotelmanagement.dto.City;
import com.cg.hotelmanagement.dto.Hotel;
import com.cg.hotelmanagement.dto.Room;

public interface IAdminDao {

    public boolean addHotel(int cityId, Hotel hotel, IHotelManagementDao hotelManagement);

    public boolean removeHotel(int cityId, int hotelId, IHotelManagementDao hotelManagement);

    public Hotel updateHotel(Hotel hotelOld, Hotel hotelUpdated, City city, IHotelManagementDao hotelManagement);

    public Room updateRoom(Room roomOld, Room roomUpdated, Hotel hotel, City city, IHotelManagementDao hotelManagement);

    public boolean removeRoom(int cityId, int hotelId,int roomId, IHotelManagementDao hotelManagement);

    public boolean addRoom(int cityId,int hotelId,Room newRoom, IHotelManagementDao hotelManagement);

}
