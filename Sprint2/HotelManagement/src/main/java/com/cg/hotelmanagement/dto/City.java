package com.cg.hotelmanagement.dto;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class City {

	private String cityName;
	private BigInteger cityId;
	private Map<BigInteger, Hotel> hotelList;

	public BigInteger getCityId() {
		return cityId;
	}

	public void setCityId(BigInteger cityId) {
		this.cityId = cityId;
	}
	

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public City(String cityName, BigInteger cityId,
			Map<BigInteger, Hotel> hotelList) {
		this.cityName = cityName;
		this.cityId = cityId;
		this.hotelList = hotelList;
	}

	public City() {
	}

	public String getCityName() {
		return cityName;
	}

	public Map<BigInteger, Hotel> getHotelList() {
		return hotelList;
	}

	public void setHotelList(Map<BigInteger, Hotel> hotelList) {
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
		return "City [cityName=" + cityName + ", cityId=" + cityId
				+ ", hotelList=" + hotelList + "]";
	}

}
