package com.cg.hotelmanagement.dao;

import com.cg.hotelmanagement.dto.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HotelManagementDao implements IHotelManagementDao {

    private List<Customer> customerList;// = new ArrayList<>();
    private Map<Integer,City> cityList;// = new ArrayList<>();
    private List<Admin> adminList;// = new ArrayList<>();
    private List<Booking> bookingList;// = new ArrayList<>();

    public HotelManagementDao(List<Customer> customerList, List<City> cityList, List<Admin> adminList, List<Booking> bookingList) {
        this.customerList = customerList;
        this.cityList = (Map<Integer, City>) cityList;
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
            cityList = new HashMap<Integer,City>();
        
        cityList.put(city.getCityId(),city);
        return true;
    }
    
    public boolean removeCity(int cityId){
        cityList.remove(cityId);
        return true;
    }

    public boolean addCustomer(Customer customer) {
        return this.customerList.add(customer);
    }

    @Override
    public Map<Integer,City> showCityList() {
        return cityList;
    }

    public boolean addHotel(int cityId,Hotel hotel){
    	
    	City city=cityList.get(cityId);
    	city.getHotelList().put(hotel.getHotelId(),hotel);
    	
        return true;
    }

    public boolean removeHotel(int cityId,int hotelId){
    	
    	City city=cityList.get(cityId);
    	city.getHotelList().remove(hotelId);
    	
    	return true;
   
    }

    public Hotel updateHotel(Hotel hotelOld, Hotel hotelUpdated, City city, IHotelManagementDao hotelManagement){
       
        return null;
    }

    @Override
    public boolean addRoom(int cityId,int hotelId,Room newRoom) {
    	
    	City city=cityList.get(cityId);
    	Hotel hotel=city.getHotelList().get(hotelId);
    	
    	hotel.getRoomList().put(newRoom.getRoomId(),newRoom);
    	
    	return true;
    }
    	
    	
    	
    	
       
    @Override
	public boolean removeRoom(int cityId, int hotelId,int roomId) {

		City city = cityList.get(cityId);
		Hotel hotel=city.getHotelList().get(hotelId);
		
		hotel.getRoomList().remove(roomId);

		return true;

	}

    @Override
    public Room updateRoom(Room roomOld, Room roomUpdated, Hotel hotel, City city, IHotelManagementDao hotelManagementDao) {
        
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
