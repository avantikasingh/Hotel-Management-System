package com.cg.hotelmanagement.service;

import com.cg.hotelmanagement.dao.IHotelManagementDao;
import com.cg.hotelmanagement.dto.City;
import com.cg.hotelmanagement.dto.Hotel;
import com.cg.hotelmanagement.dto.Room;

import java.time.LocalDate;

public interface IAdminService {

    public boolean addHotel(Hotel hotel, City city, IHotelManagementDao hotelManagement);

    public boolean removeHotel(Hotel hotel, City city, IHotelManagementDao hotelManagement);

    public Hotel updateHotel(Hotel hotelOld, Hotel hotelUpdated, City city, IHotelManagementDao hotelManagement);

    public Room updateRoom(Room roomOld, Room roomUpdated, Hotel hotel, City city, IHotelManagementDao hotelManagement);

    public boolean removeRoom(Room room, Hotel hotel, City city, IHotelManagementDao hotelManagement);

    public boolean addRoom(Room room, Hotel hotel, City city, IHotelManagementDao hotelManagement);

    public boolean approveBooking(Room room, City city, Hotel hotel, LocalDate checkIn, LocalDate checkOut, boolean sortByPrice);

}
