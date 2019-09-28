package com.cg.hotelmanagement.dto;

import java.math.BigInteger;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="room")
public class Room {
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private Long roomId;
	@Column(name="room_type")
	private String roomType;
	@Column(name="room_rent")
	private Double roomRent;
	@Column(name="room_number")
	private String roomNumber;
	@Column(name="delete_flag")
	private int deleteFlag=0;
	
	
	@OneToMany(cascade = CascadeType.ALL )	
	@JoinColumn(name="room_id")
	private List<Booking> bookingDetails=new LinkedList<>();
	
	public Room() {
	}


	
	public Room(Long roomId, String roomType, Double roomRent, String roomNumber, List<Booking> bookingDetails) {
		super();
		this.roomId = roomId;
		this.roomType = roomType;
		this.roomRent = roomRent;
		this.roomNumber = roomNumber;
		this.bookingDetails = bookingDetails;
	}
	
	

	public Long getRoomId() {
		return roomId;
	}

	public void setRoomId(Long roomId) {
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

	public List<Booking> getBookingDetails() {
		return bookingDetails;
	}

	public void setBookingDetails(List<Booking> bookingDetails) {
		this.bookingDetails = bookingDetails;
	}

	public int getDeleteFlag() {
		return deleteFlag;
	}

	public void setDeleteFlag(int deleteFlag) {
		this.deleteFlag = deleteFlag;
	}



	@Override
	public String toString() {
		return "Room [roomId=" + roomId + ", roomType=" + roomType + ", roomRent=" + roomRent + ", roomNumber="
				+ roomNumber + ", bookingDetails=" + bookingDetails +  "]";
	}


	
	
		
}