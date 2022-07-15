package com.example.flightmanagementsystem.entity;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer userId;
	@Column
	private Integer phoneNo;
	@Column
	private String userEmail;
	@Column
	private String userName;
	@Column
	private String userType;
	@Column
	private String password;
	private Integer loginStatus;
	/*
	 * public User() { super(); // TODO Auto-generated constructor stub } public
	 * User(Integer userId, Integer phoneNo, String userEmail, String userName,
	 * String userType, String password, Integer loginStatus) { super(); this.userId
	 * = userId; this.phoneNo = phoneNo; this.userEmail = userEmail; this.userName =
	 * userName; this.userType = userType; this.password = password;
	 * this.loginStatus = loginStatus; }
	 * 
	 * @Override public String toString() { return "User [userId=" + userId +
	 * ", phoneNo=" + phoneNo + ", userEmail=" + userEmail + ", userName=" +
	 * userName + ", userType=" + userType + ", password=" + password +
	 * ", loginStatus=" + loginStatus + "]"; } public Integer getUserId() { return
	 * userId; } public void setUserId(Integer userId) { this.userId = userId; }
	 * public Integer getPhoneNo() { return phoneNo; } public void
	 * setPhoneNo(Integer phoneNo) { this.phoneNo = phoneNo; } public String
	 * getUserEmail() { return userEmail; } public void setUserEmail(String
	 * userEmail) { this.userEmail = userEmail; } public String getUserName() {
	 * return userName; } public void setUserName(String userName) { this.userName =
	 * userName; } public String getUserType() { return userType; } public void
	 * setUserType(String userType) { this.userType = userType; } public String
	 * getPassword() { return password; } public void setPassword(String password) {
	 * this.password = password; } public Integer getLoginStatus() { return
	 * loginStatus; } public void setLoginStatus(Integer loginStatus) {
	 * this.loginStatus = loginStatus; }
	 */
	
	/*
	 * @OneToMany(mappedBy = "user", targetEntity = Booking.class, cascade =
	 * CascadeType.ALL, fetch = FetchType.LAZY) private Booking booking;
	 */
	
}
