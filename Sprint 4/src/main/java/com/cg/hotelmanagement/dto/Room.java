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
	private Long roomId;
	@Column(name="room_type")
	private String roomType;
	@Column(name="room_rent")
	private Double roomRent;
	@Column(name="room_number")
	private String roomNumber;
	
	@Embedded
	private Bookings bookingDates;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hotelId")
	private Hotel hotel;

	public Room() {
	}

	public Room(Long roomId, String roomType, Double roomRent, String roomNumber, Bookings bookingDates, Hotel hotel) {
		super();
		this.roomId = roomId;
		this.roomType = roomType;
		this.roomRent = roomRent;
		this.roomNumber = roomNumber;
		this.bookingDates = bookingDates;
		this.hotel = hotel;
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

	public Bookings getBookingDates() {
		return bookingDates;
	}

	public void setBookingDates(Bookings bookingDates) {
		this.bookingDates = bookingDates;
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
				+ roomNumber + ", bookingDates=" + bookingDates + ", hotel=" + hotel + "]";
	}

	
}