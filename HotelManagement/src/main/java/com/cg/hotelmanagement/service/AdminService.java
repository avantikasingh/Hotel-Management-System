package com.cg.hotelmanagement.service;

import com.cg.hotelmanagement.dao.HotelManagementDao;
import com.cg.hotelmanagement.dto.Hotel;
import com.cg.hotelmanagement.dto.Room;

import java.time.LocalDate;

public interface AdminService {

    public boolean addHotel(Hotel hotel, HotelManagementDao hotelManagement);

    public boolean removeHotel(Hotel hotel, HotelManagementDao hotelManagement);

    public Hotel updateHotel(Hotel hotel, HotelManagementDao hotelManagement);

    public Room updateRoom(Room room, HotelManagementDao hotelManagement);

    public boolean removeRoom(Room room, HotelManagementDao hotelManagement);

    public boolean addRoom(Room room, HotelManagementDao hotelManagement);

    public boolean approveBooking(Hotel hotel, LocalDate checkIn, LocalDate checkOut, boolean sortByPrice);

}
