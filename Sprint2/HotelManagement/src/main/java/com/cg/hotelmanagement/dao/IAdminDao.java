package com.cg.hotelmanagement.dao;

import com.cg.hotelmanagement.dto.*;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import java.util.Map;

public interface IAdminDao {


    public boolean addCity(City city);
    
    public boolean removeCity(BigInteger cityId);

    public boolean addHotel(BigInteger cityId,Hotel hotel);

    public boolean removeHotel(BigInteger cityId,BigInteger hotelId);

    public boolean addRoom(BigInteger cityId,BigInteger hotelId,Room newRoom);

    public boolean removeRoom(BigInteger cityId, BigInteger hotelId,BigInteger roomId);

	public Map<BigInteger, Hotel> viewHotels(Date checkIn, Date checkOut,
			BigInteger cityId, boolean sortByRating);

	public Booking makeBooking(BigInteger hotelId, Date checkIn, Date checkOut,
			BigInteger roomId);

	public boolean register();

	public boolean addBooking(BigInteger cityId, BigInteger hotelId,
			BigInteger roomId, Booking booking);

	public boolean addCity();

	public boolean addRoom();

	public boolean addHotel();

	

}
