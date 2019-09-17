package com.cg.hotelmanagement.dao;

import com.cg.hotelmanagement.dto.*;
import com.cg.hotelmanagement.exception.HotelException;
import com.cg.hotelmanagement.service.CompareByDate;
import com.cg.hotelmanagement.service.Validate;
import com.cg.hotelmanagement.exception.HotelException;
import com.cg.hotelmanagement.util.DBUtil;
//import com.cg.jdbc.ems.model.Employee;

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
	public boolean addCity(City city) throws Exception {
		// TODO Auto-generated method stub
		int noOfRec = 0;
		System.out.println(city);
		String sql = "insert into city(city_name) values(?)";
		try {
			// step1 : obtain psz
			ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			// step 2: set the ps placeholder values
			ps.setString(1, city.getCityName());

			// step 3: execute Query (for DML we have executeUpdate method )
			noOfRec = ps.executeUpdate();
		} catch (SQLException e) {
			myLogger.error(" Error at addCity Dao method : " + e);
			throw new HotelException(" Error at addCity Dao method : " + e);
		} finally {
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					myLogger.error(" Error at addCity Dao method : " + e);
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
		String sql = "update  city set delete_flag = 1 where city_id=?";
		int noOfRec = 0;
		try {
			ps = connection.prepareStatement(sql);
			ps.setLong(1, cityId.longValue());

			noOfRec = ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println(" Error at removeCity method : " + e);
		} finally {
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					System.out.println(" Error at removeCity method :  " + e);
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
	public boolean addHotel(BigInteger cityId, Hotel hotel) throws HotelException {
		/*
		 * This function has been changed and now accepts an object of room that
		 * contains hotelid as well public boolean addHotel(BigInteger cityId, Hotel
		 * hotel) old public boolean addHotel(Hotel hotel) new the hotel object also
		 * contains the city name
		 */
		System.out.println(cityId);
		System.out.println(hotel);

		int noOfRec = 0;
		String sql = "insert into hotel(city_Id,hotel_name, hotel_address, hotel_phone_number, hotel_rating) values(?,?,?,?,?)";
		try {
			// step1 : obtain psz
			ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			// step 2: set the ps placeholder values
			ps.setLong(1, cityId.longValue());
			ps.setString(2, hotel.getHotelName());
			ps.setString(3, hotel.getHotelAddress());
			ps.setLong(4, hotel.getHotelPhoneNumber().longValue());
			ps.setDouble(5, hotel.getHotelRating());

			// step 3: execute Query (for DML we have executeUpdate method )
			noOfRec = ps.executeUpdate();
		} catch (SQLException e) {
			myLogger.error(" Error at addHotel Dao method : " + e);
			throw new HotelException(" Error at addHotel Dao method : " + e);
		} finally {
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					myLogger.error(" Error at addHotel Dao method : " + e);
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
		String sql = "update  hotel set delete_flag = 1 where city_id=? AND hotel_id=?";

		int noOfRec = 0;
		try {
			ps = connection.prepareStatement(sql);
			ps.setLong(1, cityId.longValue());
			ps.setLong(2, hotelId.longValue());

			noOfRec = ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println(" Error at removeHotel method :  " + e);
		} finally {
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					System.out.println(" Error at removeHotel method : " + e);
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
	public boolean addRoom(BigInteger hotelId, Room room) throws HotelException {
		/*
		 * This function has been changed and now accepts an object of room that
		 * contains hotelid as well public boolean addRoom(BigInteger cityId, BigInteger
		 * hotelId, Room newRoom) old public boolean addRoom(Room room) new
		 */
		int noOfRec = 0;
		System.out.println(hotelId);
		System.out.println(room);
		String sql = "insert into room(room_type, room_rent, room_number, hotel_id) values(?,?,?,?)";
		try {
			// step1 : obtain psz
			ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			// step 2: set the ps placeholder values
			ps.setString(1, room.getRoomType());
			ps.setDouble(2, room.getRoomRent());
			ps.setString(3, room.getRoomNumber());
			ps.setLong(4, hotelId.longValue());

			// step 3: execute Query (for DML w e have executeUpdate method )
			noOfRec = ps.executeUpdate();
		} catch (SQLException e) {
			myLogger.error(" Error at addRoom Dao method : " + e);
			throw new HotelException(" Error at addRoom Dao method : " + e);
		} finally {
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					myLogger.error(" Error at addRoom Dao method : " + e);
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
	public boolean removeRoom(BigInteger hotelId, BigInteger roomId) {
		// TODO Auto-generated method stub
		String sql = "update  room set delete_flag = 1 where hotel_id=? AND room_id=?";
		int noOfRec = 0;
		try {
			ps = connection.prepareStatement(sql);
			ps.setLong(1, hotelId.longValue());
			ps.setLong(2, roomId.longValue());

			noOfRec = ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println(" Error at removeRoom Dao method : " + e);
		} finally {
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					System.out.println(" Error at dRoom method : " + e);
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
	public void makeBooking(BigInteger hotelId, BigInteger hotelId2, Date checkIn, Date checkOut, BigInteger roomId) {
		// TODO Auto-generated method stub
//same as add booking
	}

	@Override
	public boolean register(User user) throws HotelException {

		int noOfRec = 0;
		String sql = "insert into loggedin_user(user_name, email_id, dob, user_mobile) values(?,?,?,?)";
		try {
			// step1 : obtain ps
			ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			// step 2: set the ps placeholder values
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getEmailId());
			ps.setDate(3, (java.sql.Date) user.getDob());
			ps.setLong(4, Long.parseLong(user.getUserMobile()));

			// step 3: execute Query (for DML we have executeUpdate method )
			noOfRec = ps.executeUpdate();
		} catch (SQLException e) {
			myLogger.error(" Error at user register Dao method : " + e);
			throw new HotelException(" Error at user register Dao method : " + e);
		} finally {
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					myLogger.error(" Error at user register Dao method : " + e);
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
	public boolean register(Customer customer, BigInteger userId) throws HotelException {

		int noOfRec = 0;
		String sql = "update  loggedin_user set aadhar_number = ? where user_id=? ";
		try {
			// step1 : obtain ps
			ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			// step 2: set the ps placeholder values
			ps.setLong(1, Long.parseLong(customer.getPanNumber()));
			ps.setLong(2, userId.longValue());

			// step 3: execute Query (for DML we have executeUpdate method )
			noOfRec = ps.executeUpdate();
		} catch (SQLException e) {
			myLogger.error(" Error at customer register method : " + e);
			throw new HotelException(" Error at customer register method : " + e);
		} finally {
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					myLogger.error(" Error at customer register method : " + e);
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
	public boolean addBooking(BigInteger cityId, BigInteger hotelId, BigInteger roomId, Booking booking)
			throws HotelException {
		/*
		 * This function has been changed and now accepts an object of room that
		 * contains hotelid as well public boolean addRoom(BigInteger cityId, BigInteger
		 * hotelId, Room newRoom) old public boolean addRoom(Room room) new
		 */
		// TODO Auto-generated method stub
		int noOfRec;
		String sql = "insert into booking(booking_status ,booking_date, checkin_date,checkout_date, booking_cost, hotel_id, user_id) values(?,?,?,?,?,?,?)";
		try {

			// step1 : obtain psz
			ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			// step 2: set the ps placeholder values
			ps.setString(1, booking.getBookingStatus());
			ps.setDate(2, (java.sql.Date) booking.getBookingDate());
			ps.setDate(3, (java.sql.Date) booking.getCheckIn());
			ps.setDate(4, (java.sql.Date) booking.getCheckOut());
			ps.setDouble(5, booking.getBookingCost().doubleValue());
			ps.setLong(6, hotelId.longValue());
//			ps.setString(7, booking.get);	edit this for the userid

			// step 3: execute Query (for DML we have executeUpdate method )
			noOfRec = ps.executeUpdate();
			// getting the auto-generated value
			BigInteger generatedId = BigInteger.valueOf(0L);
			rs = ps.getGeneratedKeys();
			if (rs.next()) {
				generatedId = BigInteger.valueOf(rs.getLong(1));
				myLogger.info("Auto generated Id " + generatedId);
			}
			// setting the auto-generated Id to current emp obj
//			booking.setBookingId(generatedId); //set booking id takes string while in database that is set is bigint
		} catch (SQLException e) {
			myLogger.error(" Error at addBooking Dao method : " + e);
			throw new HotelException(" Error at addBooking Dao method : " + e);
		} finally {
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					System.out.println(" Error at addBooking Dao method : " + e);
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
	public Map<BigInteger, City> getCityList() {
		// TODO Auto-generated method stub
		String sql = "select * from city where delete_flag = 0";
		Map<BigInteger, City> cityMap = new HashMap<BigInteger, City>();
		try {
			ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			// for select queries we have executeQuery method which returns ResultSet
			rs = ps.executeQuery();
			City city = new City();
			while (rs.next()) {
				city.setCityId(BigInteger.valueOf(rs.getLong("city_id")));
				city.setCityName(rs.getString("city_name"));
				cityMap.put(BigInteger.valueOf(rs.getLong("city_id")), city);
			}
		} catch (SQLException e) {
			System.out.println(" Error at getCityList Dao method : " + e);
		} finally {
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					System.out.println(" Error at getCityList  Dao method : " + e);
				}
			}
		}
		return cityMap;
	}

	

	@Override
	public List viewHotels(Date checkIn, Date checkOut, BigInteger cityId, boolean sortByRating) {
		// TODO Auto-generated method stub
		
		String sql="SELECT hotel_id, room_id, room_type, room_rent "
				+ "from room"
				+ "WHERE room_id NOT IN "
				+ "("
				+ "SELECT RoomID"
				+ "FROM   room B"
				+ "JOIN room_booking RB"
				+ "ON B.room_id = RB.room_id"
				+ "WHERE  (checkIn <= RB.checkIn AND checkOut  >= RB.checkIn)"
				+ " OR (checkIn < RB.checkOut AND checkOut >= RB.checkOut ) "
				+ "OR (RB.checkIn <= checkIn AND RB.checkout >= checkIn)); ";
						    
					
		//String sql = "select * from hotel where city_id =?  and delete_flag = 0";
		List availableRoomList = new LinkedList();
		try {
			ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			// for select queries we have executeQuery method which returns ResultSet
			rs = ps.executeQuery();
			
			while (rs.next()) {
				availableRoomList.add(BigInteger.valueOf(rs.getLong("hotel_id")));
				availableRoomList.add(BigInteger.valueOf(rs.getLong("room_id")));
				availableRoomList.add(rs.getString("room_type"));
				availableRoomList.add(rs.getDouble("room_rent"));
				
			}
		} catch (SQLException e) {
			System.out.println(" Error at getCityList Dao method : " + e);
		} finally {
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					System.out.println(" Error at getCityList  Dao method : " + e);
				}
			}
		}
		return availableRoomList;
	}

	@Override
	public void showBooking(Booking booking) {
		// TODO Auto-generated method stub

	}

	public boolean updateHotel(BigInteger cityId, BigInteger hotelId, String hotelName) throws HotelException {

		String sql = "update  hotel set hotel_name = ? where city_id=?  and hotel_id = ? ";

		int noOfRec = 0;
		try {
			// step1 : obtain psz
			ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			// step 2: set the ps placeholder values
			ps.setString(1, hotelName);
			ps.setLong(2, cityId.longValue());
			ps.setLong(3, hotelId.longValue());

			// step 3: execute Query (for DML w e have executeUpdate method )
			noOfRec = ps.executeUpdate();
		} catch (SQLException e) {
			myLogger.error(" Error at updateHotel Dao method : " + e);
			throw new HotelException(" Error at updateHotel Dao method : " + e);
		} finally {
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					myLogger.error(" Error at updateRoom  Dao method : " + e);
				}
			}
		}
		if (noOfRec > 0) {
			return true;

		} else {
			return false;
		}

	}

	public boolean updateRoom(BigInteger cityId, BigInteger hotelId, BigInteger roomId, String roomType)
			throws HotelException {
		String sql = "update  room set room_type = ? where city_id=?  and hotel_id = ? and room_id = ?";

		int noOfRec = 0;
		try {
			// step1 : obtain psz
			ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			// step 2: set the ps placeholder values
			ps.setString(1, roomType);
			ps.setLong(2, cityId.longValue());
			ps.setLong(3, hotelId.longValue());
			ps.setLong(4, roomId.longValue());

			// step 3: execute Query (for DML w e have executeUpdate method )
			noOfRec = ps.executeUpdate();
		} catch (SQLException e) {
			myLogger.error(" Error at updateRoom Dao method : " + e);
			throw new HotelException(" Error at updateRoom Dao method : " + e);
		} finally {
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					myLogger.error(" Error at updateRoom  Dao method : " + e);
				}
			}
		}
		if (noOfRec > 0) {
			return true;

		} else {
			return false;
		}

	}

}
