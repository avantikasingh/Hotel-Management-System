package com.cg.hotelmanagement.dto;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class City {

	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private Long cityId;
	@Column(name="city_name")
	private String cityName;
	@Column(name="delete_flag")
	private int deleteFlag=0;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="city_id")
	private List<Hotel> hotelList=new LinkedList<Hotel>();

	public City()
	{
		
	}

	public City(Long cityId, String cityName, List<Hotel> hotelList) {
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

	public List<Hotel> getHotelList() {
		return hotelList;
	}

	public void setHotelList(List<Hotel> hotelList) {
		this.hotelList = hotelList;
	}
	public int getDeleteFlag() {
		return deleteFlag;
	}

	public void setDeleteFlag(int deleteFlag) {
		this.deleteFlag = deleteFlag;
	}


	@Override
	public String toString() {
		return "City [cityId=" + cityId + ", cityName=" + cityName + ", hotelList=" + hotelList + "]";
	}
	
	

}