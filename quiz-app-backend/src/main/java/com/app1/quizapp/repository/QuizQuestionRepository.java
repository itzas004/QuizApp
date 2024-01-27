package com.app1.quizapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app1.quizapp.entity.Quiz;
import com.app1.quizapp.entity.QuizQuestion;

@Repository
public interface QuizQuestionRepository extends JpaRepository<QuizQuestion, Long>{
	public List<QuizQuestion> findByQuiz(Quiz quiz);
}
