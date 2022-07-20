package com.example.flightmanagementsystem.entity;

import java.math.BigInteger;

import javax.persistence.*;
import javax.validation.constraints.*;


@Entity
@Table(name = "users")
public class User {
	@Id
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String userId;
	@Column
	@Size(min=10,max=10,message="Invalid Phone Number")
	private String phoneNo;
	@Column
	@Email
	@NotBlank
	private String userEmail;
	@Column
	private String userName;
	@Column
	private String userType;
	@Column
	private String password;

public @Size(min = 10, max = 10, message = "Invalid Phone Number") String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(@Size(min = 10, max = 10, message = "Invalid Phone Number") String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	/*
	 * public String getUserId() { return userId; } 
	 */
	public void setUserId(String userId) { this.userId = userId; }
	 
	
	
}
