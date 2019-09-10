package com.cg.hotelmanagement.dto;

import java.util.List;

public class City {

    private String cityName;
    private int cityId;
    private List<Hotel> hotelList;

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public City(String cityName, int cityId, List<Hotel> hotelList) {
        this.cityName = cityName;
        this.cityId = cityId;
        this.hotelList = hotelList;
    }

    public City() {
    }

    public String getCityName() {
        return cityName;
    }

    public List<Hotel> getHotelList() {
        return hotelList;
    }

    public void addHotel(Hotel hotel){
        hotelList.add(hotel);
    }

    public void removeHotel(Hotel hotel){
        hotelList.remove(hotel);
    }

    public void setHotelList(List<Hotel> hotelList) {
        this.hotelList = hotelList;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
