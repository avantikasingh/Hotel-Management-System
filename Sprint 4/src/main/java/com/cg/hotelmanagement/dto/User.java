package com.cg.hotelmanagement.dto;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class User {
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private Long userId=Long.valueOf(999);
	@Column(name="username")
	protected String username;
	@Column(name="email_id")
	protected String emailId;
	@Column(name="dob")
	protected Date dob;
	@Column(name="user_mobile")
	protected String userMobile;
	@Column(name="first_name")
	private String firstName;
	@Column(name="last_name")
	private String lastName;
	@Column(name="gender")
	private String gender;
	@Column(name="aadhar_number")
	private String aadharNumber;
	@OneToOne
	private Booking booking;

	public User() {
	}

	public User(Long userId, String username, String emailId, Date dob, String userMobile, String firstName,
			String lastName, String gender, String aadharNumber, Booking booking) {
		super();
		this.userId = userId;
		this.username = username;
		this.emailId = emailId;
		this.dob = dob;
		this.userMobile = userMobile;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.aadharNumber = aadharNumber;
		this.booking = booking;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getUserMobile() {
		return userMobile;
	}

	public void setUserMobile(String userMobile) {
		this.userMobile = userMobile;
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

	public String getAadharNumber() {
		return aadharNumber;
	}

	public void setAadharNumber(String aadharNumber) {
		this.aadharNumber = aadharNumber;
	}

	public Booking getBooking() {
		return booking;
	}

	public void setBooking(Booking booking) {
		this.booking = booking;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", username=" + username + ", emailId=" + emailId + ", dob=" + dob
				+ ", userMobile=" + userMobile + ", firstName=" + firstName + ", lastName=" + lastName + ", gender="
				+ gender + ", aadharNumber=" + aadharNumber + ", booking=" + booking + "]";
	}

	
}