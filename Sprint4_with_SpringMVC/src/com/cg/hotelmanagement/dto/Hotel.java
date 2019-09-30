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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Hotel")
public class Hotel {
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="hotel_id")
	private Long hotelId;
	@Column(name="hotel_name")
	private String hotelName;
	@Column(name="hotel_address")
	private String hotelAddress;
	@Column(name="hotel_phone_number")
	private String hotelPhoneNumber;
	@Column(name="hotel_rating")
	private Float hotelRating;
	@Column(name="delete_flag")
	private int deleteFlag=0;
	
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="hotel_id")
	private List<Room> roomList = new LinkedList<>();

	
	public Hotel() {
	}

	public Hotel(Long hotelId, String hotelName, String hotelAddress, String hotelPhoneNumber, Float hotelRating,
			List<Room> roomList) {
		super();
		this.hotelId = hotelId;
		this.hotelName = hotelName;
		this.hotelAddress = hotelAddress;
		this.hotelPhoneNumber = hotelPhoneNumber;
		this.hotelRating = hotelRating;
		this.roomList = roomList;
		
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

	public String getHotelPhoneNumber() {
		return hotelPhoneNumber;
	}

	public void setHotelPhoneNumber(String hotelPhoneNumber) {
		this.hotelPhoneNumber = hotelPhoneNumber;
	}

	public Float getHotelRating() {
		return hotelRating;
	}

	public void setHotelRating(Float hotelRating) {
		this.hotelRating = hotelRating;
	}

	public List<Room> getRoomList() {
		return roomList;
	}

	public void setRoomList(List<Room> roomList) {
		this.roomList = roomList;
	}
	
	public int getDeleteFlag() {
		return deleteFlag;
	}

	public void setDeleteFlag(int deleteFlag) {
		this.deleteFlag = deleteFlag;
	}


	
	@Override
	public String toString() {
		return "Hotel [hotelId=" + hotelId + ", hotelName=" + hotelName + ", hotelAddress=" + hotelAddress
				+ ", hotelPhoneNumber=" + hotelPhoneNumber + ", hotelRating=" + hotelRating + ", roomList=" + roomList
				+  "]";
	}

	
}