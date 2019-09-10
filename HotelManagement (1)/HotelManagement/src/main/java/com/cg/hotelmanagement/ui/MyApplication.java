package com.cg.hotelmanagement.ui;

import com.cg.hotelmanagement.dao.HotelManagementDao;
import com.cg.hotelmanagement.dao.IHotelManagementDao;
import com.cg.hotelmanagement.dto.Booking;
import com.cg.hotelmanagement.dto.City;
import com.cg.hotelmanagement.dto.Hotel;
import com.cg.hotelmanagement.dto.Room;
import com.cg.hotelmanagement.service.AdminService;
import com.cg.hotelmanagement.service.CompareByDate;
import com.cg.hotelmanagement.service.IAdminService;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MyApplication {

    public static void main(String[] args) {

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        List<Booking> bookingList = new ArrayList<Booking>();
        try {
            bookingList.add(new Booking("1","2",dateFormat.parse("2017-01-10"),dateFormat.parse("2017-01-10"),dateFormat.parse("2017-01-12"),new BigDecimal(200)));
            bookingList.add(new Booking("1","2",dateFormat.parse("2017-01-10"),dateFormat.parse("2017-01-11"),dateFormat.parse("2017-01-13"),new BigDecimal(200)));
            bookingList.add(new Booking("1","2",dateFormat.parse("2017-01-10"),dateFormat.parse("2017-01-1"),dateFormat.parse("2017-01-10"),new BigDecimal(200)));
            bookingList.add(new Booking("1","2",dateFormat.parse("2017-01-10"),dateFormat.parse("2017-01-17"),dateFormat.parse("2017-01-10"),new BigDecimal(200)));
        } catch (ParseException e) {
            System.out.println(e.getMessage());
        }

        Collections.sort(bookingList, new CompareByDate());

        for(Booking i: bookingList){
            System.out.println(i);
        }

        IAdminService adminService = new AdminService();

        IHotelManagementDao hotelManagementDao = new HotelManagementDao(new ArrayList<>(),new ArrayList<>(),new ArrayList<>(),new ArrayList<>());

        City city = new City("A",12,new ArrayList<>());

        hotelManagementDao.addCity(city);

        Hotel hotel = new Hotel("B","B","B","B",new ArrayList<>(),new BigInteger("100"),4.5f);

        adminService.addHotel(hotel,city,hotelManagementDao);

        List<Hotel> hotelList = city.getHotelList();

        for(Hotel i: hotelList){
            System.out.println(i);
        }

        adminService.addRoom(new Room("V","V",22.0d,"V","G"),hotel,city,hotelManagementDao);

        System.out.println(hotel.getRoomList());

    }

}
