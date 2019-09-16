package com.cg.hotelmanagement.dto;

import java.math.BigInteger;
import java.util.List;

public class Room {
	private BigInteger roomId;
	private String roomType;
	private Double roomRent;
	private String roomNumber;
	
	public Room() {
	}

	

	public Room(BigInteger roomId, String roomType, Double roomRent, String roomNumber) {
		super();
		this.roomId = roomId;
		this.roomType = roomType;
		this.roomRent = roomRent;
		this.roomNumber = roomNumber;
	}



	public BigInteger getRoomId() {
		return roomId;
	}

	public void setRoomId(BigInteger roomId) {
		this.roomId = roomId;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public Double getRoomRent() {
		return roomRent;
	}

	public void setRoomRent(Double roomRent) {
		this.roomRent = roomRent;
	}

	public String getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}


	@Override
	public String toString() {
		return "Room [roomId=" + roomId + ", roomType=" + roomType
				+ ", roomRent=" + roomRent + ", roomNumber=" + roomNumber + "]";
	}

}
