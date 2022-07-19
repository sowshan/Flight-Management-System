package com.example.flightmanagementsystem.controllers;

import java.math.BigInteger;


import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.example.flightmanagementsystem.entity.User;
import com.example.flightmanagementsystem.exceptions.AirportNotFoundException;
import com.example.flightmanagementsystem.repositories.UserRepo;
import com.example.flightmanagementsystem.services.UserService;
import com.example.flightmanagementsystem.services.UserServiceImpl;

@RestController
@RequestMapping("/users")

public class UserController {
	@Autowired
	// UserRepo userR;
	public UserService userService;

	@PostMapping(value = "/createUser", consumes = "application/json")
//@ExceptionHandler(RecordAlreadyPresentException.class)
	public String addUser(@RequestBody User newUser) {
		Random rand = new Random();
		Integer resRandom = rand.nextInt((9999 - 100) + 1) + 10;
		newUser.setUserId(newUser.getUserName().substring(0, 2) + Integer.toString(resRandom));

		userService.addUser(newUser);
		return "Added Successfully";

	}

	@PostMapping(value = "/users/login")
	public ResponseEntity<String> loginUser(@RequestParam String userId, @RequestParam String password) {
		
		Boolean r = userService.login(userId, password);
		if (r.equals(true)) {

			return new ResponseEntity<>(HttpStatus.OK);
		}
        
		return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
	}

	@PutMapping("/updateUser")
//@ExceptionHandler(RecordNotFoundException.class)
	public ResponseEntity<String> updateUser(@RequestBody User updateUser) {

		userService.updateUser(updateUser);
		return new ResponseEntity<>(HttpStatus.OK);

	}

	@GetMapping("/searchUser/{id}")
//@ExceptionHandler(RecordNotFoundException.class)
	public User searchUserByID(@PathVariable("id") String userId) {
		return userService.viewUser(userId);
		

	}
}
