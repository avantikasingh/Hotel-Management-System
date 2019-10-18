package com.cg.hotelmanagement.dto;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;


@Entity
@EntityListeners({ AuditingEntityListener.class })
@Table(name="room")
public class Room {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long roomId;
	@Column(name="room_type")
	private String roomType;
	@Column(name="room_rent")
	
	private Double roomRent;
	@Column(name="room_number")
	private String roomNumber;
	@Column(name="delete_flag")
	private int deleteFlag=0;
	
	@ManyToOne
	@JoinColumn(name="hotel_id")
	private Hotel hotel;
	
	
	@OneToMany(mappedBy = "room",cascade = CascadeType.ALL)	
	private List<Booking> bookingDetails=new LinkedList<>();
	
	
	
	@Column(name = "created_date", nullable = false, updatable = false)
	@CreatedDate
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdDate;
	@Column(name = "modified_date")
	@LastModifiedDate
	@Temporal(TemporalType.TIMESTAMP)
	private Date modifiedDate;
	@Column(name = "created_by")
	@CreatedBy
	private String createdBy;
	@Column(name = "modified_by")
	@LastModifiedBy
	private String modifiedBy;
	
	public Room() {
	}



	

	public Room(Long roomId, String roomType, Double roomRent, String roomNumber, int deleteFlag, Hotel hotel,
			List<Booking> bookingDetails, Date createdDate, Date modifiedDate, String createdBy, String modifiedBy) {
		super();
		this.roomId = roomId;
		this.roomType = roomType;
		this.roomRent = roomRent;
		this.roomNumber = roomNumber;
		this.deleteFlag = deleteFlag;
		this.hotel = hotel;
		this.bookingDetails = bookingDetails;
		this.createdDate = createdDate;
		this.modifiedDate = modifiedDate;
		this.createdBy = createdBy;
		this.modifiedBy = modifiedBy;
	}





	public Date getCreatedDate() {
		return createdDate;
	}





	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}





	public Date getModifiedDate() {
		return modifiedDate;
	}





	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}





	public String getCreatedBy() {
		return createdBy;
	}





	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}





	public String getModifiedBy() {
		return modifiedBy;
	}





	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
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

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}



	@Override
	public String toString() {
		return "Room [roomId=" + roomId + ", roomType=" + roomType + ", roomRent=" + roomRent + ", roomNumber="
				+ roomNumber + ", bookingDetails=" + bookingDetails +  "]";
	}


	
	
		
}