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
	public boolean addHotel(Hotel hotel) {
		/*
		 This function has been changed and now accepts an object of room that contains hotelid as well
		 public boolean addHotel(BigInteger cityId, Hotel hotel)  old 
		 public boolean addHotel(Hotel hotel) new
		 the hotel object also contains the city name 
		 */
		
		int noOfRec = 0;
		String sql = "insert into hotel(city_name,hotel_name, hotel_address, hotel_phone_number, hotel_rating, delete_flag) values(?,?,?,?,?,?)";
		try {
			// step1 : obtain psz
			ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			// step 2: set the ps placeholder values
//			ps.setString(1, hotel.getCityName()); get city name and insert in the hotel table
			ps.setString(2, hotel.getHotelName());
			ps.setString(3, hotel.getHotelAddress());
			ps.setString(4, hotel.getHotelAddress());
			ps.setDouble(5, hotel.getHotelRating());
			ps.setBoolean(6,false);
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
	public boolean removeHotel(BigInteger cityId, BigInteger hotelId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addRoom(Room room) {
		/*
		 This function has been changed and now accepts an object of room that contains hotelid as well
		 public boolean addRoom(BigInteger cityId, BigInteger hotelId, Room newRoom)  old 
		 public boolean addRoom(Room room) new
		 */
		int noOfRec = 0;
		String sql = "insert into room(room_type, room_rent, room_number, hotel_id, delete_flag) values(?,?,?,?,?)";
		try {
			// step1 : obtain psz
			ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			// step 2: set the ps placeholder values
			ps.setString(1, room.getRoomType());
			ps.setDouble(2, room.getRoomRent());
			ps.setString(3, room.getRoomNumber());
//			ps.setString(4, room.());room get hotelid
			ps.setBoolean(5, false);
			// step 3: execute Query (for DML w	e have executeUpdate method )
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
		/*
		 This function has been changed and now accepts an object of room that contains hotelid as well
		 public boolean addRoom(BigInteger cityId, BigInteger hotelId, Room newRoom)  old 
		 public boolean addRoom(Room room) new
		 */
		// TODO Auto-generated method stub
		String sql ="insert into booking(booking_status ,author_mname, author_lname, author_phone) values(?,?,?,?)";		
		try {
		//step1 : obtain psz
			ps= connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
		//step 2: set the ps placeholder values
			ps.setString(1, author.getFirstName());
			ps.setString(2, author.getMiddleName());	
			ps.setString(3, author.getLastName());
			ps.setLong(4, author.getPhoneNo().longValue());
		//step 3: execute Query (for DML we have executeUpdate method )
			int noOfRec = ps.executeUpdate();
		//gett
			ing the auto-generated value
			BigInteger generatedId = BigInteger.valueOf(0L);
			rs = ps.getGeneratedKeys();
			if (rs.next()) {
				generatedId = BigInteger.valueOf(rs.getLong(1));
				myLogger.info("Auto generated Id " + generatedId);
			}
		//setting the auto-generated Id to current emp obj
			author.setAuthorId(generatedId);
		} catch (SQLException e) {
			myLogger.error(" Error at addauthor Dao method : "+e);
			throw new AuthorException(" Error at addauthor Dao method : "+e);
		}finally {
			if(ps!=null) {
				try {
					ps.close();
				} catch (SQLException e) {
					System.out.println(" Error at addauthor Dao method : "+e);
				}
			}
		}
		return author;;
	}

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
