package com.app1.quizapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app1.quizapp.entity.Users;

public interface UserRepository extends JpaRepository<Users, Long>{
	public List<Users> findByUsername(String username);
}
