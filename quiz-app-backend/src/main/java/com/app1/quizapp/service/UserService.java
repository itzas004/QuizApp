package com.app1.quizapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app1.quizapp.entity.Users;
import com.app1.quizapp.repository.UserRepository;

import jakarta.persistence.EntityNotFoundException;
@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

	public List<Users> getAllUsers() {
		
		return userRepository.findAll();
	}

	public Users createUsers(Users user) {
		
		return userRepository.save(user);
	}

	public Users updateUser(Long id, Users updatedUser) {
        Users user = getUserById(id);
        // Perform any necessary validation or business logic
        // Update the user entity with the new values
        user.setUsername(updatedUser.getUsername());
        user.setPassword(updatedUser.getPassword());
        user.setEmail(updatedUser.getEmail());
        user.setAdmin(updatedUser.isAdmin());
        return userRepository.save(user);
    }

	public Users getUserById(Long id) {
		
		return userRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("User Not Found"));
	}

	public void deleteUser(Long id) {
		Users user=getUserById(id);
		userRepository.delete(user);
		
	}

}
