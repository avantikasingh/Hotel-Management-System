package com.cg.hotelmanagement.dto;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;


@Entity
@EntityListeners({ AuditingEntityListener.class })

public class Customer {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long userId;
	@Column(name="username")
	protected String username;
	@Column(name="email_id")
	protected String emailId;
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	@Column(name="dob")
	protected LocalDate dob;
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
	@Column(name="password")
	private String password;
	@Column(name="roles")
	private String roles;
	@Column(name="active")
	private boolean active;
	@Column(name="delete_flag")
	private int deleteFlag=0;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Booking booking;
	
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

	
	//Default role for a new registered user is USER.
	//We can add Admin through database.
	public Customer() {
		this.roles="ROLE_USER";
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




	public void setRoles(String roles) {
		this.roles = roles;
	}




	public Customer(Long userId, String username, String emailId, LocalDate dob, String userMobile, String firstName,
			String lastName, String gender, String aadharNumber, String password, String roles, boolean active,
			int deleteFlag, Booking booking, Date createdDate, Date modifiedDate, String createdBy, String modifiedBy) {
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
		this.password = password;
		this.roles = roles;
		this.active = active;
		this.deleteFlag = deleteFlag;
		this.booking = booking;
		this.createdDate = createdDate;
		this.modifiedDate = modifiedDate;
		this.createdBy = createdBy;
		this.modifiedBy = modifiedBy;
	}




	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRoles() {
		return roles;
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
 
	public int getDeleteFlag() {
		return deleteFlag;
	}

	public void setDeleteFlag(int deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
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
	
	

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	@Override
	public String toString() {
		return "Customer [userId=" + userId + ", username=" + username + ", emailId=" + emailId + ", dob=" + dob
				+ ", userMobile=" + userMobile + ", firstName=" + firstName + ", lastName=" + lastName + ", gender="
				+ gender + ", aadharNumber=" + aadharNumber + ", booking=" + booking + "]";
	}

	
}