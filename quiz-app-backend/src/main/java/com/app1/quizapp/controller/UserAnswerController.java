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
import com.app1.quizapp.entity.UserAnswerDto;
import com.app1.quizapp.entity.UserAnswers;
import com.app1.quizapp.entity.Users;
import com.app1.quizapp.repository.QuestionRepository;
import com.app1.quizapp.repository.UserAnswerRepository;
import com.app1.quizapp.repository.UserRepository;
import com.app1.quizapp.service.UserAnswerService;

@RequestMapping("/api/user-answers")
@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class UserAnswerController {
	
	@Autowired
	QuestionRepository questionRepository;
	@Autowired
	UserRepository userRepository;
	@Autowired
	UserAnswerRepository userAnswerRepository;
	@Autowired
	UserAnswerService userAnswerService;
	public UserAnswerController(UserAnswerService userAnswerService) {
		this.userAnswerService=userAnswerService;
	}
	
	@GetMapping
	public List<UserAnswers> getAllUserAnswers(){
		return userAnswerService.getAllUserAnswers();
	}
	@PostMapping
	public UserAnswers createUserAnswer(@RequestBody UserAnswerDto userAnswerDto) {
		Users user=userRepository.findById(userAnswerDto.getUserId()).orElseThrow(()-> new IllegalArgumentException("User Not Found"));
		Questions question=questionRepository.findById(userAnswerDto.getQuestionId()).orElseThrow(()-> new IllegalArgumentException("Question Not Found"));
		
		UserAnswers userAnswer=new UserAnswers();
		userAnswer.setUsers(user);
		userAnswer.setQuestions(question);
		userAnswer.setSelectedOption(userAnswerDto.getSelectedOption());
		return userAnswerRepository.save(userAnswer);
	}
	@GetMapping("/{id}")
	public UserAnswers getUserAnswerById(@PathVariable Long id) {
		return userAnswerService.getUserAnswerById(id);
	}
	@PutMapping("/{id}")
	public UserAnswers updateUserAnswer(@PathVariable Long id,@RequestBody UserAnswers userAnswer) {
		return userAnswerService.updateUserAnswer(id,userAnswer);
	}
	@DeleteMapping("/{id}")
	public void deleteUserAnswer(@PathVariable Long id) {
		userAnswerService.deleteUserAnswer(id);
	}
	
	
}
