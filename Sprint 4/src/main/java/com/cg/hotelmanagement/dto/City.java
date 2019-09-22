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
	private Long cityId;
	@Column(name="city_name")
	private String cityName;
	@OneToMany(mappedBy="city",cascade=CascadeType.ALL)
	private Map<Long, Hotel> hotelList=new HashMap<Long,Hotel>();

	public City()
	{
		
	}

	public City(Long cityId, String cityName, Map<Long, Hotel> hotelList) {
		super();
		this.cityId = cityId;
		this.cityName = cityName;
		this.hotelList = hotelList;
	}

	public Long getCityId() {
		return cityId;
	}

	public void setCityId(Long cityId) {
		this.cityId = cityId;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public Map<Long, Hotel> getHotelList() {
		return hotelList;
	}

	public void setHotelList(Map<Long, Hotel> hotelList) {
		this.hotelList = hotelList;
	}

	@Override
	public String toString() {
		return "City [cityId=" + cityId + ", cityName=" + cityName + ", hotelList=" + hotelList + "]";
	}
	
	

}