package com.example.flightmanagementsystem.controllers;

import java.util.List;
import java.math.BigInteger;

import java.util.List;
import java.util.Random;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import com.example.flightmanagementsystem.entity.User;
import com.example.flightmanagementsystem.exceptions.AirportNotFoundException;
import com.example.flightmanagementsystem.exceptions.InvalidCredentialsException;
import com.example.flightmanagementsystem.exceptions.RecordNotFoundException;
import com.example.flightmanagementsystem.repositories.UserRepo;
import com.example.flightmanagementsystem.services.UserService;
import com.example.flightmanagementsystem.services.UserServiceImpl;

@RestController
@RequestMapping("/users")

public class UserController {
	@Autowired
	public UserService userService;

	@PostMapping(value = "/createUser", consumes = "application/json")
	public String addUser(@RequestBody User newUser)
			throws com.example.flightmanagementsystem.exceptions.UserNotCreatedException {
		Random rand = new Random();
		Integer resRandom = rand.nextInt((9999 - 100) + 1) + 10;
		String userid = newUser.getUserName().substring(0, 2) + Integer.toString(resRandom);
		newUser.setUserId(userid);

		userService.addUser(newUser);
		return "Added Successfully!!\nYour UserId is " + userid;

	}

	@PutMapping("/users/{id}")
	public ResponseEntity<User> updateUser(@PathVariable(value = "id") String userId, @Valid @RequestBody User user)
			throws RecordNotFoundException {
		User user1;
		user1 = userService.viewUser(userId);
		user1.setUserEmail(user.getUserEmail());
		user1.setPhoneNo(user.getPhoneNo());
		user1.setUserName(user.getUserName());
		final User updatedUser = userService.updateUser(user1);
		return ResponseEntity.ok(updatedUser);
	}

	@PostMapping(value = "/users/login")
	public ResponseEntity<String> loginUser(@RequestParam String userId, @RequestParam String password)
			throws InvalidCredentialsException {
		return new ResponseEntity<>(userService.login(userId, password), HttpStatus.FOUND);
	}

	/*
	 * @PutMapping("/updateUser/{id}")
	 * 
	 * @ExceptionHandler(RecordNotFoundException.class) public
	 * ResponseEntity<String> updateUser(@PathVariable("id") String userId) {
	 * 
	 * userService.updateUser(userId); return new ResponseEntity<>(HttpStatus.OK);
	 * 
	 * }
	 */

	@GetMapping("/searchUser/{id}")
	// @ExceptionHandler(RecordNotFoundException.class)
	public List<User> searchUserByID(@PathVariable("id") String userId) throws RecordNotFoundException {
		//userService.viewUser(userId);
		// throw new RecordNotFoundException();
		return (List<User>) userService.viewUser(userId);

	}

	@DeleteMapping("/deleteUser/{id}")
	// @ExceptionHandler(RecordNotFoundException.class)
	public void deleteBookingByID(@PathVariable("id") String userId) {
		userService.removeUser(userId);
	}
}
