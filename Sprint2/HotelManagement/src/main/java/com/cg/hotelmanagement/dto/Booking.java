package com.cg.hotelmanagement.dto;



import java.math.BigDecimal;
import java.util.Date;

public class Booking {
	private String bookingId;
	private String bookingStatus;
	private Date bookingDate;
	private Date checkIn;
	private Date checkOut;
	private BigDecimal BookingCost;

	public Booking() {
	}

	/*public Booking(String bookingId, String bookingStatus, LocalDate bookingDate, LocalDate checkIn,
				   LocalDate checkOut, BigDecimal bookingCost) {
		super();
		this.bookingId = bookingId;
		this.bookingStatus = bookingStatus;
		this.bookingDate = bookingDate;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		BookingCost = bookingCost;
	}*/

	public Booking(String bookingId, String bookingStatus, Date bookingDate, Date checkIn, Date checkOut, BigDecimal bookingCost) {
		this.bookingId = bookingId;
		this.bookingStatus = bookingStatus;
		this.bookingDate = bookingDate;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		BookingCost = bookingCost;
	}

	public String getBookingId() {
		return bookingId;
	}

	public void setBookingId(String bookingId) {
		this.bookingId = bookingId;
	}

	public String getBookingStatus() {
		return bookingStatus;
	}

	public void setBookingStatus(String bookingStatus) {
		this.bookingStatus = bookingStatus;
	}

	public Date getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}

	public Date getCheckIn() {
		return checkIn;
	}

	public void setCheckIn(Date checkIn) {
		this.checkIn = checkIn;
	}

	public Date getCheckOut() {
		return checkOut;
	}

	public void setCheckOut(Date checkOut) {
		this.checkOut = checkOut;
	}

	public BigDecimal getBookingCost() {
		return BookingCost;
	}

	public void setBookingCost(BigDecimal bookingCost) {
		BookingCost = bookingCost;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((BookingCost == null) ? 0 : BookingCost.hashCode());
		result = prime * result + ((bookingDate == null) ? 0 : bookingDate.hashCode());
		result = prime * result + ((bookingId == null) ? 0 : bookingId.hashCode());
		result = prime * result + ((bookingStatus == null) ? 0 : bookingStatus.hashCode());
		result = prime * result + ((checkIn == null) ? 0 : checkIn.hashCode());
		result = prime * result + ((checkOut == null) ? 0 : checkOut.hashCode());
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
		Booking other = (Booking) obj;
		if (BookingCost == null) {
			if (other.BookingCost != null)
				return false;
		} else if (!BookingCost.equals(other.BookingCost))
			return false;
		if (bookingDate == null) {
			if (other.bookingDate != null)
				return false;
		} else if (!bookingDate.equals(other.bookingDate))
			return false;
		if (bookingId == null) {
			if (other.bookingId != null)
				return false;
		} else if (!bookingId.equals(other.bookingId))
			return false;
		if (bookingStatus == null) {
			if (other.bookingStatus != null)
				return false;
		} else if (!bookingStatus.equals(other.bookingStatus))
			return false;
		if (checkIn == null) {
			if (other.checkIn != null)
				return false;
		} else if (!checkIn.equals(other.checkIn))
			return false;
		if (checkOut == null) {
			if (other.checkOut != null)
				return false;
		} else if (!checkOut.equals(other.checkOut))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "BookingManagement [bookingId=" + bookingId + ", bookingStatus=" + bookingStatus + ", bookingDate="
				+ bookingDate + ", checkIn=" + checkIn + ", checkOut=" + checkOut + ", BookingCost=" + BookingCost
				+ "]";
	}
	
	
	
	
	
	

}
