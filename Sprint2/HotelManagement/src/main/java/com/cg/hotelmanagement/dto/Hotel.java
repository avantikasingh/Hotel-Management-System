package com.cg.hotelmanagement.dto;

import java.math.BigInteger;
import java.util.Map;

public class Hotel {
	private BigInteger hotelId;
	private String hotelName;
	private String hotelAddress;
	
	private Map<BigInteger,Room> roomList;
	private BigInteger hotelPhoneNumber;
	private Float hotelRating;
	public Hotel() {
	}
	public Hotel(BigInteger hotelId, String hotelName, String hotelAddress, Map<BigInteger,Room> roomList,
			BigInteger hotelPhoneNumber, Float hotelRating) {
		super();
		this.hotelId = hotelId;
		this.hotelName = hotelName;
		this.hotelAddress = hotelAddress;
		
		this.roomList = roomList;
		this.hotelPhoneNumber = hotelPhoneNumber;
		this.hotelRating = hotelRating;
	}
	public BigInteger getHotelId() {
		return hotelId;
	}
	public void setHotelId(BigInteger hotelId) {
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
	public void setRoomList(Map<BigInteger,Room> roomList) {
		this.roomList = roomList;
	}
	
	public Map<BigInteger,Room> getRoomList() {
		return this.roomList;
	}
	public BigInteger getHotelPhoneNumber() {
		return hotelPhoneNumber;
	}
	public void setHotelPhoneNumber(BigInteger hotelPhoneNumber) {
		this.hotelPhoneNumber = hotelPhoneNumber;
	}
	public Float getHotelRating() {
		return hotelRating;
	}
	public void setHotelRating(Float hotelRating) {
		this.hotelRating = hotelRating;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((hotelAddress == null) ? 0 : hotelAddress.hashCode());
		
		result = prime * result + ((hotelId == null) ? 0 : hotelId.hashCode());
		result = prime * result + ((hotelName == null) ? 0 : hotelName.hashCode());
		result = prime * result + ((hotelPhoneNumber == null) ? 0 : hotelPhoneNumber.hashCode());
		result = prime * result + ((hotelRating == null) ? 0 : hotelRating.hashCode());
		result = prime * result + ((roomList == null) ? 0 : roomList.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Hotel other = (Hotel) obj;
		if (hotelAddress == null) {
			if (other.hotelAddress != null)
				return false;
		} else if (!hotelAddress.equals(other.hotelAddress))
			return false;
		
		if (hotelId == null) {
			if (other.hotelId != null)
				return false;
		} else if (!hotelId.equals(other.hotelId))
			return false;
		if (hotelName == null) {
			if (other.hotelName != null)
				return false;
		} else if (!hotelName.equals(other.hotelName))
			return false;
		if (hotelPhoneNumber == null) {
			if (other.hotelPhoneNumber != null)
				return false;
		} else if (!hotelPhoneNumber.equals(other.hotelPhoneNumber))
			return false;
		if (hotelRating == null) {
			if (other.hotelRating != null)
				return false;
		} else if (!hotelRating.equals(other.hotelRating))
			return false;
		if (roomList == null) {
			if (other.roomList != null)
				return false;
		} else if (!roomList.equals(other.roomList))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Hotel [hotelId=" + hotelId + ", hotelName=" + hotelName + ", hotelAddress=" + hotelAddress
				+ ", roomList=" + roomList + ", hotelPhoneNumber="
				+ hotelPhoneNumber + ", hotelRating=" + hotelRating + "]";
	}
	
}
