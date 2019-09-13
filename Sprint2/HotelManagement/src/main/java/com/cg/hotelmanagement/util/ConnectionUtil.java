/**
 * 
 */
package com.cg.hotelmanagement.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.cg.hotelmanagement.exception.HotelException;


public class ConnectionUtil {
	private static Connection connection;
	public static Connection getConnection() throws HotelException {
		String url="jdbc:mysql://localhost:3306/testdb";
		String user="root";
		String password="123456";
		try {
			
			connection=DriverManager.getConnection(url,user,password);
		} catch (SQLException e) {
			throw new HotelException("Error while obatining Connection ");
		} 
		return connection;
	}
	public static void main(String[] args) throws HotelException {
		connection=ConnectionUtil.getConnection();
		if(connection!=null) System.out.println("Connection Obtained!!");
		else System.out.println("Connection NOT Obtained!!");
	}

}
