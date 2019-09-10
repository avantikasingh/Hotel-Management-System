package com.cg.hotelmanagement.dto;

import java.util.List;
import java.util.Map;

public class City {

    private String cityName;
    private int cityId;
    private Map<Integer,Hotel> hotelList;

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public City(String cityName, int cityId, Map<Integer,Hotel> hotelList) {
        this.cityName = cityName;
        this.cityId = cityId;
        this.hotelList = hotelList;
    }

    public City() {
    }

    public String getCityName() {
        return cityName;
    }

    public Map<Integer,Hotel> getHotelList() {
        return hotelList;
    }

   
    

    public void setHotelList(List<Hotel> hotelList) {
        this.hotelList = (Map<Integer, Hotel>) hotelList;
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
