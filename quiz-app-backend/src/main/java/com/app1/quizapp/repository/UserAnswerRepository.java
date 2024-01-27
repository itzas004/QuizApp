package com.app1.quizapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app1.quizapp.entity.UserAnswers;

public interface UserAnswerRepository extends JpaRepository<UserAnswers, Long>{

}
