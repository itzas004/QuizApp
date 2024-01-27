package com.app1.quizapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app1.quizapp.entity.Users;
import com.app1.quizapp.service.UserService;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {
	@Autowired
	UserService userService;
	public UserController(UserService userService) {
        this.userService = userService;
    }
	@GetMapping
	public List<Users> getAllUsers(){
		return userService.getAllUsers();
	}
	@PostMapping
	public Users createUsers(@RequestBody Users user) {
		return userService.createUsers(user);
	}
	@PutMapping("/{id}")
    public Users updateUser(@PathVariable Long id, @RequestBody Users user) {
        return userService.updateUser(id, user);
    }
	@GetMapping("/{id}")
	public Users getUserById(@PathVariable Long id) {
		return userService.getUserById(id);
	}
	@DeleteMapping("/{id}")
	public void deleteUser(@PathVariable Long id) {
		userService.deleteUser(id);
	}
}
