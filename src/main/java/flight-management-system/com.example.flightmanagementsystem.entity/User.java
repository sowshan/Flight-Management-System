package com.example.flightmanagementsystem.entity;

import javax.persistence.*;

@Entity
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

}
