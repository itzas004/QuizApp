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

import com.app1.quizapp.entity.Questions;
import com.app1.quizapp.entity.Quiz;
import com.app1.quizapp.entity.QuizQuestion;
import com.app1.quizapp.service.QuizService;

@RestController
@RequestMapping("/api/quizzes")
@CrossOrigin(origins = "http://localhost:3000")
public class QuizController {
	@Autowired
	QuizService quizService;
	
	@PostMapping
	public Quiz createQuiz(@RequestBody Quiz quiz) {
		List<QuizQuestion> quizQuestions=quiz.getQuizQuestions();
		for(QuizQuestion quizQuestion:quizQuestions) {
			quizQuestion.setQuiz(quiz);
		}
		return quizService.createQuiz(quiz);
	}
	@GetMapping
	public List<Quiz> getAllQuizzes(){
		return quizService.geAllQuizzes();
	}
	@GetMapping("/{id}")
	public Quiz getQuizById(@PathVariable Long id){
		return quizService.getQuizById(id);
	}
	@PutMapping("/{id}")
	public Quiz updateQuiz(@PathVariable Long id,@RequestBody Quiz quiz) {
		return quizService.updateQuiz(id,quiz);
	}
	@DeleteMapping("/{id}")
	public void deleteQuiz(@PathVariable Long id) {
		quizService.deleteQuiz(id);
	}
	@GetMapping("/getQuizQuestById")
	public List<Questions> getQuizQuestionById(@PathVariable Long id){
		return quizService.getQuizQuestionById(id);
	}
}
