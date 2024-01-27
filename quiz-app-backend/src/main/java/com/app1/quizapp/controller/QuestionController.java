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
import com.app1.quizapp.service.QuestionService;
import com.app1.quizapp.service.QuizService;

@RestController
@RequestMapping("/api/questions")
@CrossOrigin(origins = "http://localhost:3000")
public class QuestionController {
	
	@Autowired
	QuestionService questionService;
	
	@GetMapping("/getAllQuestion")
	public List<Questions> getAllQuestion(){
		return questionService.getAllQuestion();
	}
	@PostMapping("/addquestion")
	public Questions createQuestion(@RequestBody Questions question) {
		return questionService.createQuestion(question);
	}
	@GetMapping("/{id}")
	public Questions getQuestionById(@PathVariable Long id) {
		return questionService.getQuestionById(id);
	}
	@PutMapping("/{id}")
	public Questions updateQuestions(@PathVariable Long id,@RequestBody Questions question) {
		return questionService.updateQuestion(id, question);
	}
	@DeleteMapping("/{id}")
	public void deleteQuestion(@PathVariable Long id) {
		questionService.deleteQuestion(id);
	}
	
}
