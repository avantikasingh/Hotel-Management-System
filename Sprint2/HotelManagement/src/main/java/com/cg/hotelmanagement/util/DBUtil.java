package com.cg.hotelmanagement.util;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.cg.hotelmanagement.exception.HotelException;


import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;



public class DBUtil {
	  private static Logger myLogger;
      private static Connection connection;
      static{
    	
    	  Properties props = System.getProperties();
    	  String userDir= props.getProperty("user.dir")+"/src/main/resources/";
    	  myLogger.info("Current working directory is " +userDir);
    	  PropertyConfigurator.configure(userDir+"log4j.properties");
  		myLogger=Logger.getLogger("DBUtil.class");
  		}
      private DBUtil() {
    	  
      }
      public static Connection getConnection() throws HotelException {
    	  try {
    		//creating properties and load the properties
    			Properties prop=DBUtil.loadProp();
    		
    			String url = prop.getProperty("url");
    			String username = prop.getProperty("user");
    			String password = prop.getProperty("password");
    		  //getConnection
    		  connection=DriverManager.getConnection(url, username, password);
    		  myLogger.info("connection Obtained! : "+connection);	
    	  }catch(Exception e) {
    		  myLogger.error("connection Not Obtained!"+e);	
    		  throw new HotelException(e.getMessage());
    	  }
    	   return connection;  
      }//end of method
     //method for loading property file 
      private static Properties loadProp() throws HotelException {
    	  Properties props = System.getProperties();
    	  String userDir= props.getProperty("user.dir")+"/src/main/resources/";
    	  Properties myProp=new Properties();
  		try (FileInputStream fis=new FileInputStream(userDir+"jdbc.properties"))	{  			
  			myProp.load(fis);
  			myLogger.info("Property File loaded : ");	
  		} 
  		catch (Exception e){
  			myLogger.error("Property File Not loaded : "+e);	
  			throw new HotelException(e.getMessage());
  		}
  		return myProp;
	}
//method for closing the connection
	public static void closeConnection() throws HotelException {
    	  try {
    		  if(connection !=null) {
    			  connection.close();
    			  myLogger.error("Closing Connection");
    		  }
    		  else
    			  myLogger.error("Connection already closed");
    	  } catch (Exception e) {
    		  myLogger.error("Connection already closed : "+e);	
    		  throw new HotelException(e.getMessage());
    	  }
      }
}
