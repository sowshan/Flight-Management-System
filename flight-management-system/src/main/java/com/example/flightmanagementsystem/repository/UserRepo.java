package com.example.flightmanagementsystem.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.flightmanagementsystem.entity.User;

public interface UserRepo extends JpaRepository<User, String>{
	
}
