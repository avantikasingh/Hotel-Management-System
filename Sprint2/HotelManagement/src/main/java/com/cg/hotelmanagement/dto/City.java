package com.cg.hotelmanagement.dto;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class City {

	private String cityName;
	private BigInteger cityId;

	public BigInteger getCityId() {
		return cityId;
	}

	public void setCityId(BigInteger cityId) {
		this.cityId = cityId;
	}
	

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}



	public City(String cityName, BigInteger cityId) {
		super();
		this.cityName = cityName;
		this.cityId = cityId;
	}

	public City() {
	}

	public String getCityName() {
		return cityName;
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
		return "City [cityName=" + cityName + ", cityId=" + cityId + "]";
	}


}
