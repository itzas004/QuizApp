package com.app1.quizapp.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app1.quizapp.entity.Users;
import com.app1.quizapp.repository.UserRepository;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class LoginController {
	@Autowired
	private UserRepository userRepo;
	
	@PostMapping("/login")
	public String Login(@RequestBody Map<String, String> credentials) {
		System.out.println("In Login");
		String username=credentials.get("username");
		String password=credentials.get("password");
		List<Users> userByUsername=userRepo.findByUsername(username);
		for(Users user:userByUsername) {
			if(password.equals(user.getPassword())) {
				if(user.isAdmin()==true) {
					return "admin";
				}
				else {
					return "user";
				}
			}
		}
		return "invalid";
	}
	
}
