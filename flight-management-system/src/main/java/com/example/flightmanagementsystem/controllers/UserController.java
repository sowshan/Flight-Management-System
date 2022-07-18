package com.example.flightmanagementsystem.controllers;

import java.math.BigInteger;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.example.flightmanagementsystem.entity.User;
import com.example.flightmanagementsystem.repositories.UserRepo;
import com.example.flightmanagementsystem.services.UserService;
import com.example.flightmanagementsystem.services.UserServiceImpl;


@RestController
@RequestMapping("/login")

public class UserController {
@Autowired
UserRepo userR;
UserServiceImpl userService = new UserServiceImpl();


@PostMapping("/createUser")
//@ExceptionHandler(RecordAlreadyPresentException.class)
public ResponseEntity<String> addUser(@RequestBody User newUser) {

userService.addUser(newUser);
return new ResponseEntity<>( HttpStatus.OK);

}


@PostMapping(value="/users/login",consumes = "application/json")
public ResponseEntity<String> loginUser(@RequestParam String userId,@RequestParam String password) {
	Boolean r = userService.login(userId,password);
	if(r==true) {
        
    		return new ResponseEntity<>( HttpStatus.OK);
        }
    
    return  new ResponseEntity<>( HttpStatus.BAD_REQUEST);
}
@PutMapping("/updateUser")
//@ExceptionHandler(RecordNotFoundException.class)
public ResponseEntity<String> updateUser(@RequestBody User updateUser) {

	userService.updateUser(updateUser);
	return new ResponseEntity<>( HttpStatus.OK);

}
@GetMapping("/searchUser/{id}")
//@ExceptionHandler(RecordNotFoundException.class)
public ResponseEntity<User> searchUserByID(@PathVariable("id") String userId) {

	return userService.viewUser(userId);

}
}
