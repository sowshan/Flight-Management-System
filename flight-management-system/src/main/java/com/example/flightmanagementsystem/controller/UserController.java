package com.example.flightmanagementsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.flightmanagementsystem.entity.User;
import com.example.flightmanagementsystem.repository.UserRepo;


@RestController
public class UserController {
@Autowired
UserRepo userR;

public User registerUser(@RequestBody User newUser) {
	User ur=new User();
	ur.setPassword(newUser.getPassword());
	ur.setPhoneNo(newUser.getPhoneNo());
	ur.setUserEmail(newUser.getUserEmail());
	ur.setUserName(newUser.getUserName());
	ur.setUserType(newUser.getUserType());
    System.out.println("Registered successfully");
    return newUser;
}
@PostMapping(value="/users/login",consumes = "application/json")
public String loginUser(@RequestBody User user) {
    List<User> users = userR.findAll();
    for (User other : users) {
        if (other.equals(user)&& other.getLoginStatus()==false) {
            user.setLoginStatus(true);
            user.setUserType("C");
            if(user.getUserId().equals("admin123")) {
            	user.setUserType("A");
            }
            else {
            	user.setUserType("C");
            }
            userR.save(user);
            return "login successfull";
        }
    }
    return "User_not_found";
}
@PostMapping("/users/logout")
public String logUserOut(@RequestBody User user) {
    List<User> users = userR.findAll();
    for (User other : users) {
        if (other.equals(user)&&other.getLoginStatus()==true) {
            user.setLoginStatus(false);
            if(user.getUserId().equals("admin123")) {
            	user.setUserType("A");
            }
            else {
            	user.setUserType("C");
            }
            userR.save(user);
            return "Logout_Successfully";
        }
    }
    return "Failure";
}


}
