package com.cg.hotelmanagement.dto;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class City {

	@Id 
	private BigInteger cityId;
	@Column(name="city_name")
	private String cityName;
	@OneToMany(mappedBy="city",cascade=CascadeType.ALL)
	private Map<BigInteger, Hotel> hotelList=new HashMap<BigInteger,Hotel>();

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