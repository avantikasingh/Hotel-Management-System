package com.cg.hotelmanagement.dao;

import com.cg.hotelmanagement.dto.*;
import com.cg.hotelmanagement.exception.CustomException;
import com.cg.hotelmanagement.service.CompareByDate;

import java.util.*;

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

    @Override
    public boolean showHotel(int cityId) {
        if (cityList.containsKey(cityId)) {
            City city = cityList.get(cityId);
            Map<Integer, Hotel> hotelMap = city.getHotelList();
            for (Map.Entry<Integer, Hotel> entry : hotelMap.entrySet())
                System.out.println(entry.getValue());
            return true;
        }
        System.out.println("City does not exist");
        return false; //Id not found
    }

    @Override
    public boolean showRoom(int cityId, int hotelId){
        if(cityList.containsKey(cityId)){
            City city = cityList.get(cityId);
            Map<Integer, Hotel> hotelMap = city.getHotelList();
            if(hotelMap.containsKey(hotelId)){
                Hotel hotel = hotelMap.get(hotelId);
                Map<Integer,Room> roomMap = hotel.getRoomList();
                for (Map.Entry<Integer, Room> entry : roomMap.entrySet())
                    System.out.println(entry.getValue());
                return true;
            }
            else
                System.out.println("Hotel does not exist");
        }
        System.out.println("City does not exist");
        return false;
    }

    @Override
    public Map<Integer, Hotel> viewHotel(Date checkIn, Date checkOut, int cityId, boolean sortByPrice) throws CustomException{
        int k = 1;
        if(checkIn.after(checkOut))
            throw new CustomException("Check in date should be after check  out date");
        Map<Integer,Room> availableRoom = new HashMap<>();
        System.out.println("5");
        if(cityList.containsKey(cityId)) {
            System.out.println("6");
            City city = cityList.get(cityId);
            Map<Integer,Hotel> hotelMap = city.getHotelList();
            for (Map.Entry<Integer,Hotel> entry : hotelMap.entrySet()) {
                System.out.println("7");
                Hotel hotel = entry.getValue();
                Map<Integer,Room> roomMap = hotel.getRoomList();
                for (Map.Entry<Integer,Room> entry1 : roomMap.entrySet()){
                    System.out.println("8");
                    Room room = entry1.getValue();
                    List<Booking> bookingList = room.getBookingList();
                    List<Date> bookingDate = new ArrayList<>();
                    System.out.println("1");
                    for(Booking booking:bookingList){
                        System.out.println("9");
                        bookingDate.add(booking.getCheckIn());
                        bookingDate.add(booking.getCheckOut());
                    }
                    System.out.println("2");
                    Collections.sort(bookingDate, new CompareByDate());
                    for(Date d:bookingDate){
                        System.out.println(d.toString());
                    }
                    for(int i=1;i<bookingDate.size()-1;i++){
                        System.out.println("10");
                        System.out.println(bookingDate.get(i));
                        System.out.println(bookingDate.get(i+1));
                        if(checkIn.after(bookingDate.get(bookingDate.size()-1))){
                            System.out.println("11");
                            System.out.println("Hotel id: "+entry.getKey()+" Room id: "+entry1.getValue());
                        }
                        if(checkIn.after(bookingDate.get(i)) && i+1<=bookingDate.size() && checkOut.before(bookingDate.get(i+1))) {
                            //if()
                            //availableRoom.put(entry)
                            System.out.println("3");
                            System.out.println("Hotel id: "+entry.getKey()+" Room id: "+entry1.getValue());
                            availableRoom.put(k,entry1.getValue());
                            k++;
                        }
                    }
                }
            }

        }
        else
            throw new CustomException("City does not exist");
        return null;
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

    @Override
    public boolean addBooking(int cityId, int hotelId, int roomId, Booking booking) {
        if(cityList.containsKey(cityId)) {
            City city = cityList.get(cityId);
            Hotel hotel = city.getHotelList().get(hotelId);
            Room room = hotel.getRoomList().get(roomId);
            List<Booking> list = new LinkedList<>();
            list.add(booking);
            room.setBookingList(list);
        }
        else
            System.out.println("City does not exist");
        return true;
    }

    /*public boolean addBooking(Booking booking){
        return bookingList.add(booking);
    }*/

}
