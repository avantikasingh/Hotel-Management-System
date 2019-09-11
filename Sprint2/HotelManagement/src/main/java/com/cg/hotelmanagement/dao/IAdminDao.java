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

	public void makeBooking(BigInteger hotelId, BigInteger hotelId2, Date checkIn, Date checkOut,
			BigInteger roomId);

	public boolean register(Customer customer);

	public boolean addBooking(BigInteger cityId, BigInteger hotelId,
			BigInteger roomId, Booking booking);

	public Map<BigInteger, City> getCityList();

	public void viewHotels(BigInteger cityId, BigInteger hotelId);

	public Map<BigInteger, Hotel> viewHotels(Date checkIn, Date checkOut, BigInteger cityId, boolean sortByRating);

	void updateHotel(BigInteger cityId, BigInteger hotelId, String hotelName);

	void updateRoom(BigInteger cityId, BigInteger hotelId, BigInteger roomId, String roomType);
	

}
