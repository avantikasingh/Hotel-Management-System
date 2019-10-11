package com.cg.hotelmanagement.dto;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Booking {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long bookingId;
	// @Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "YYYY-MM-DD")
	@Column(name = "check_in")
	private LocalDate checkIn;
	
	@DateTimeFormat(pattern = "YYYY-MM-DD")
	// @Temporal(TemporalType.DATE)
	@Column(name = "check_out")
	private LocalDate checkOut;
	
	@Column(name = "city_name")
	private String cityName;
	
	@Column(name = "hotel_name")
	private String hotelName;
	
	@Column(name = "hotel_address")
	private String hotelAddress;
	
	@Column(name = "hotel_phoneno")
	private String hotelPhoneno;
	
	@Column(name = "hotel_rating")
	private Float hotelRating;
	
	@ManyToOne
	@JoinColumn(name="room_id")
	private Room room;
	
	
	@Column(name = "delete_flag")
	private int deleteFlag = 0;

	@OneToOne
	private Customer customer;
	
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

	public Booking() {
		// TODO Auto-generated constructor stub
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


	
	
	public Booking(LocalDate checkIn, LocalDate checkOut, Room room, int deleteFlag) {
		super();
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		this.room = room;
		this.deleteFlag = deleteFlag;
		this.hotelName=room.getHotel().getHotelName();
		this.hotelAddress=room.getHotel().getHotelAddress();
		this.hotelRating=room.getHotel().getHotelRating();
		this.hotelPhoneno=room.getHotel().getHotelPhoneNumber();
		this.cityName=room.getHotel().getCity().getCityName();
	}



	public Booking(Long bookingId, LocalDate checkIn, LocalDate checkOut, String cityName, String hotelName,
			String hotelAddress, String hotelPhoneno, Float hotelRating, Room room, int deleteFlag, Customer customer,
			Date createdDate, Date modifiedDate, String createdBy, String modifiedBy) {
		super();
		this.bookingId = bookingId;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		this.cityName = cityName;
		this.hotelName = hotelName;
		this.hotelAddress = hotelAddress;
		this.hotelPhoneno = hotelPhoneno;
		this.hotelRating = hotelRating;
		this.room = room;
		this.deleteFlag = deleteFlag;
		this.customer = customer;
		this.createdDate = createdDate;
		this.modifiedDate = modifiedDate;
		this.createdBy = createdBy;
		this.modifiedBy = modifiedBy;
	}



	public Long getBookingId() {
		return bookingId;
	}

	public void setBookingId(Long bookingId) {
		this.bookingId = bookingId;
	}

	public LocalDate getCheckIn() {
		return checkIn;
	}

	public void setCheckIn(LocalDate checkIn) {
		this.checkIn = checkIn;
	}

	public LocalDate getCheckOut() {
		return checkOut;
	}

	public void setCheckOut(LocalDate checkOut) {
		this.checkOut = checkOut;
	}

	public int getDeleteFlag() {
		return deleteFlag;
	}

	public void setDeleteFlag(int deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	
	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
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

	public String getHotelPhoneno() {
		return hotelPhoneno;
	}

	public void setHotelPhoneno(String hotelPhoneno) {
		this.hotelPhoneno = hotelPhoneno;
	}

	public Float getHotelRating() {
		return hotelRating;
	}

	public void setHotelRating(Float hotelRating) {
		this.hotelRating = hotelRating;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}
	

	@Override
	public String toString() {
		return "Booking [bookingId=" + bookingId + ", checkIn=" + checkIn + ", checkOut=" + checkOut + ", deleteFlag=" + deleteFlag + ", customer=" + customer + "]";
	}

}