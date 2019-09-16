package com.cg.hotelmanagement.dto;

import java.math.BigInteger;
import java.sql.Date;

public class Customer {

	private BigInteger customerId;
	private Booking booking;
	private String firstName;
	private String lastName;
	private String gender;
	private String aadharNumber;

	public Customer(BigInteger customerId, Booking booking, String firstName,
			String lastName, String aadharNumber) {
		super();
		this.customerId = customerId;
		this.booking = booking;
		this.firstName = firstName;
		this.lastName = lastName;
		this.aadharNumber = aadharNumber;
	}

	public BigInteger getCustomerId() {
		return customerId;
	}

	public void setCustomerId(BigInteger customerId) {
		this.customerId = customerId;
	}

	public Booking getBooking() {
		return booking;
	}

	public void setBooking(Booking booking) {
		this.booking = booking;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPanNumber() {
		return aadharNumber;
	}

	public void setPanNumber(String panNumber) {
		this.aadharNumber = panNumber;
	}

	public Customer(BigInteger customerId, Booking booking, String firstName,
			String lastName, String gender, String panNumber) {
		this.customerId = customerId;
		this.booking = booking;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.aadharNumber = panNumber;
	}

	public Customer() {

	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((booking == null) ? 0 : booking.hashCode());
		result = prime * result
				+ ((customerId == null) ? 0 : customerId.hashCode());
		result = prime * result
				+ ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		result = prime * result
				+ ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result
				+ ((aadharNumber == null) ? 0 : aadharNumber.hashCode());
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
		Customer other = (Customer) obj;
		if (booking == null) {
			if (other.booking != null)
				return false;
		} else if (!booking.equals(other.booking))
			return false;
		if (customerId == null) {
			if (other.customerId != null)
				return false;
		} else if (!customerId.equals(other.customerId))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (gender == null) {
			if (other.gender != null)
				return false;
		} else if (!gender.equals(other.gender))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (aadharNumber == null) {
			if (other.aadharNumber != null)
				return false;
		} else if (!aadharNumber.equals(other.aadharNumber))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", booking=" + booking
				+ ", firstName=" + firstName + ", lastName=" + lastName
				+ ", gender=" + gender + ", panNumber=" + aadharNumber + "]";
	}

}
