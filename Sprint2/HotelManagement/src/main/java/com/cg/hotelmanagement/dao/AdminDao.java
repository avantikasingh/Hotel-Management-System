package com.cg.hotelmanagement.dao;

import com.cg.hotelmanagement.dto.*;
import com.cg.hotelmanagement.exception.HotelException;
import com.cg.hotelmanagement.service.CompareByDate;
import com.cg.hotelmanagement.service.Validate;
import com.cg.hotelmanagement.exception.HotelException;
import com.cg.hotelmanagement.util.DBUtil;
import com.cg.lab3.exception.AuthorException;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class AdminDao implements IAdminDao {

	private static Connection connection;
	private PreparedStatement ps;
	private Statement st;
	private ResultSet rs;
	private static Logger myLogger;
	static {
		Properties props = System.getProperties();
		String userDir = props.getProperty("user.dir") + "/src/main/resources/";
		System.out.println("Current working directory is " + userDir);
		PropertyConfigurator.configure(userDir + "log4j.properties");
		myLogger = Logger.getLogger("AdminDao.class");
	}
	static {
		try {
			connection = DBUtil.getConnection();
			myLogger.info("connection Obtained!!");
		} catch (HotelException e) {
			myLogger.error("Connection Not Obtained at authorDao : " + e);
		}
	}

	@Override
	public boolean addCity(City city) throws HotelException {
		// TODO Auto-generated method stub
		int noOfRec = 0;
		String sql = "insert into hotel(city_name) values(?)";
		try {
			// step1 : obtain psz
			ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			// step 2: set the ps placeholder values
			ps.setString(1, city.getCityName());
			// step 3: execute Query (for DML we have executeUpdate method )
			noOfRec = ps.executeUpdate();
		} catch (SQLException e) {
			myLogger.error(" Error at addauthor Dao method : " + e);
			throw new HotelException(" Error at addauthor Dao method : " + e);
		} finally {
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					myLogger.error(" Error at addauthor Dao method : " + e);
				}
			}
		}
		if (noOfRec > 0) {
			return true;

		} else {
			return false;
		}

	}

	@Override
	public boolean removeCity(BigInteger cityId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addHotel(BigInteger cityId, Hotel hotel) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeHotel(BigInteger cityId, BigInteger hotelId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addRoom(BigInteger cityId, BigInteger hotelId, Room newRoom) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeRoom(BigInteger cityId, BigInteger hotelId, BigInteger roomId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void makeBooking(BigInteger hotelId, BigInteger hotelId2, Date checkIn, Date checkOut, BigInteger roomId) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean register(Customer customer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addBooking(BigInteger cityId, BigInteger hotelId, BigInteger roomId, Booking booking) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Map<BigInteger, City> getCityList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void viewHotels(BigInteger cityId) {
		// TODO Auto-generated method stub

	}

	@Override
	public Map<BigInteger, Hotel> viewHotels(Date checkIn, Date checkOut, BigInteger cityId, boolean sortByRating) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateHotel(BigInteger cityId, BigInteger hotelId, String hotelName) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateRoom(BigInteger cityId, BigInteger hotelId, BigInteger roomId, String roomType) {
		// TODO Auto-generated method stub

	}

	@Override
	public void showBooking(Booking booking) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateBooking(Booking booking) {
		// TODO Auto-generated method stub

	}

}
