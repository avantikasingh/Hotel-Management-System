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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Hotel")
public class Hotel {
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="hotel_id")
	private Long hotelId=Long.valueOf(999);
	@Column(name="hotel_name")
	private String hotelName;
	@Column(name="hotel_address")
	private String hotelAddress;
	@Column(name="hotel_phone_number")
	private Long hotelPhoneNumber;
	@Column(name="hotel_rating")
	private Float hotelRating;
	
	@OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL)
	private Map<Long, Room> roomList = new HashMap<>();

	@ManyToOne
	@JoinColumn(name="city_id")
	private City city;
	
	public Hotel() {
	}

	public Hotel(Long hotelId, String hotelName, String hotelAddress, Long hotelPhoneNumber, Float hotelRating,
			Map<Long, Room> roomList, City city) {
		super();
		this.hotelId = hotelId;
		this.hotelName = hotelName;
		this.hotelAddress = hotelAddress;
		this.hotelPhoneNumber = hotelPhoneNumber;
		this.hotelRating = hotelRating;
		this.roomList = roomList;
		this.city = city;
	}

	public Long getHotelId() {
		return hotelId;
	}

	public void setHotelId(Long hotelId) {
		this.hotelId = hotelId;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public String getHotelAddress() {
		return hotelAddress;
	}

	public void setHotelAddress(String hotelAddress) {
		this.hotelAddress = hotelAddress;
	}

	public Long getHotelPhoneNumber() {
		return hotelPhoneNumber;
	}

	public void setHotelPhoneNumber(Long hotelPhoneNumber) {
		this.hotelPhoneNumber = hotelPhoneNumber;
	}

	public Float getHotelRating() {
		return hotelRating;
	}

	public void setHotelRating(Float hotelRating) {
		this.hotelRating = hotelRating;
	}

	public Map<Long, Room> getRoomList() {
		return roomList;
	}

	public void setRoomList(Map<Long, Room> roomList) {
		this.roomList = roomList;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "Hotel [hotelId=" + hotelId + ", hotelName=" + hotelName + ", hotelAddress=" + hotelAddress
				+ ", hotelPhoneNumber=" + hotelPhoneNumber + ", hotelRating=" + hotelRating + ", roomList=" + roomList
				+ ", city=" + city + "]";
	}

	
}