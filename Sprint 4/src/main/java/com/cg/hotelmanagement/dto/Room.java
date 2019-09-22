package com.cg.hotelmanagement.dto;

import java.math.BigInteger;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="room")
public class Room {
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private BigInteger roomId;
	@Column(name="room_type")
	private String roomType;
	@Column(name="room_rent")
	private Double roomRent;
	@Column(name="room_number")
	private String roomNumber;
	
	private Booking booking;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hotelId")
	private Hotel hotel;

	public Room() {
	}

	public Room(BigInteger roomId, String roomType, Double roomRent,
			String roomNumber, Booking booking) {
		super();
		this.roomId = roomId;
		this.roomType = roomType;
		this.roomRent = roomRent;
		this.roomNumber = roomNumber;
		this.booking = booking;

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

	public Booking getBooking() {
		return booking;
	}

	public void setBooking(Booking booking) {
		this.booking = booking;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	@Override
	public String toString() {
		return "Room [roomId=" + roomId + ", roomType=" + roomType + ", roomRent=" + roomRent + ", roomNumber="
				+ roomNumber + ", booking=" + booking + ", hotel=" + hotel + "]";
	}

}