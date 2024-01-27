package com.app1.quizapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app1.quizapp.entity.Quiz;

@Repository
public interface QuizRepository extends JpaRepository<Quiz, Long>{

}
