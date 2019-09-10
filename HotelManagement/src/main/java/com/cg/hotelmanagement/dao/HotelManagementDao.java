package com.cg.hotelmanagement.dao;

import com.cg.hotelmanagement.dto.*;

import java.util.ArrayList;
import java.util.List;

public class HotelManagementDao implements IHotelManagementDao {

    private List<Customer> customerList;// = new ArrayList<>();
    private List<City> cityList;// = new ArrayList<>();
    private List<Admin> adminList;// = new ArrayList<>();
    private List<Booking> bookingList;// = new ArrayList<>();

    public HotelManagementDao(List<Customer> customerList, List<City> cityList, List<Admin> adminList, List<Booking> bookingList) {
        this.customerList = customerList;
        this.cityList = cityList;
        this.adminList = adminList;
        this.bookingList = bookingList;
    }

    public HotelManagementDao() {
    }

    public List<Customer> showCustomerList() {
        return customerList;
    }

    public boolean addCity(City city){
        if(this.cityList==null)
            cityList = new ArrayList<>();
        cityList.add(city);
        return true;
    }

    public boolean addCustomer(Customer customer) {
        return this.customerList.add(customer);
    }

    @Override
    public List<City> showCityList() {
        return cityList;
    }

    public boolean addHotel(Hotel hotel, City city, IHotelManagementDao hotelManagement){
        for(int i=0;i<cityList.size();i++) {
            if (city.getCityId() == cityList.get(i).getCityId()) {
                List<Hotel> hotelList = cityList.get(i).getHotelList();
                if(hotelList==null)
                    hotelList = new ArrayList<>();
                hotelList.add(hotel);
                city.setHotelList(hotelList);
                return true;
            }
        }
        return false;
    }

    public boolean removeHotel(Hotel hotel, City city, IHotelManagementDao hotelManagement){
        for(int i=0;i<cityList.size();i++){
            if(city==cityList.get(i)){
                cityList.get(i).removeHotel(hotel);
                return true;
            }
        }
        return false;
    }

    public Hotel updateHotel(Hotel hotelOld, Hotel hotelUpdated, City city, IHotelManagementDao hotelManagement){
        for(int i=0;i<cityList.size();i++){
            if(city==cityList.get(i)){
                cityList.get(i).removeHotel(hotelOld);
                cityList.get(i).addHotel(hotelUpdated);
                return hotelUpdated;
            }
        }
        return null;
    }

    @Override
    public boolean addRoom(Room room, Hotel hotel, City city, IHotelManagementDao hotelManagementDao) {
        for(int i=0;i<cityList.size();i++){
            if(city.equals(cityList.get(i))){
                List<Hotel> hotelList = cityList.get(i).getHotelList();
                for(int j=0;j<hotelList.size();j++){
                    if(hotel.equals(hotelList.get(j))){
                        List<Room> roomList = hotelList.get(j).getRoomList();
                        roomList.add(room);
                        hotel.setRoomList(roomList);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override
    public boolean removeRoom(Room room, Hotel hotel, City city, IHotelManagementDao hotelManagementDao) {
        for(int i=0;i<cityList.size();i++){
            if(city==cityList.get(i)){
                List<Hotel> hotelList = cityList.get(i).getHotelList();
                for(int j=0;j<hotelList.size();j++){
                    if(hotel==hotelList.get(j)){
                        List<Room> roomList = hotelList.get(j).getRoomList();
                        roomList.remove(room);
                        hotel.setRoomList(roomList);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override
    public Room updateRoom(Room roomOld, Room roomUpdated, Hotel hotel, City city, IHotelManagementDao hotelManagementDao) {
        for(int i=0;i<cityList.size();i++){
            if(city==cityList.get(i)){
                List<Hotel> hotelList = cityList.get(i).getHotelList();
                for(int j=0;j<hotelList.size();j++){
                    if(hotel.equals(hotelList.get(j))){
                        List<Room> roomList = hotelList.get(j).getRoomList();
                        roomList.remove(roomOld);
                        roomList.add(roomUpdated);
                        hotel.setRoomList(roomList);
                        return roomUpdated;
                    }
                }
            }
        }
        return null;
    }

    public List<Admin> showAdminList() {
        return adminList;
    }

    public List<Booking> showBookingList() {
        return bookingList;
    }

    public boolean addBooking(Booking booking){
        return bookingList.add(booking);
    }

}
