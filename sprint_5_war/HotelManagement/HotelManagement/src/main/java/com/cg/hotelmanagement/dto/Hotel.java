package com.cg.hotelmanagement.dto;

import java.math.BigInteger;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.validator.constraints.NotEmpty;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;


@Entity
@EntityListeners({ AuditingEntityListener.class })

@Table(name="Hotel")
public class Hotel {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="hotel_id")
	private Long hotelId;
	@NotEmpty(message = "aasd")
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
	@ManyToOne
	@JoinColumn(name="city_id")
	private City city;
	
	@OneToMany(cascade = CascadeType.ALL ,fetch = FetchType.EAGER)
	@JoinColumn(name="hotel_id")
	private List<Room> roomList = new LinkedList<>();
	
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

	
	public Hotel() {
	}



	public Hotel(Long hotelId, @NotEmpty(message = "aasd") String hotelName, String hotelAddress,
			String hotelPhoneNumber, Float hotelRating, int deleteFlag, City city, List<Room> roomList,
			Date createdDate, Date modifiedDate, String createdBy, String modifiedBy) {
		super();
		this.hotelId = hotelId;
		this.hotelName = hotelName;
		this.hotelAddress = hotelAddress;
		this.hotelPhoneNumber = hotelPhoneNumber;
		this.hotelRating = hotelRating;
		this.deleteFlag = deleteFlag;
		this.city = city;
		this.roomList = roomList;
		this.createdDate = createdDate;
		this.modifiedDate = modifiedDate;
		this.createdBy = createdBy;
		this.modifiedBy = modifiedBy;
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
				+  "]";
	}

	
}