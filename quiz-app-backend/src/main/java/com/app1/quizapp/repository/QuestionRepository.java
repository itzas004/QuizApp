package com.app1.quizapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app1.quizapp.entity.Questions;

public interface QuestionRepository extends JpaRepository<Questions, Long>{

}
