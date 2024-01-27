package com.app1.quizapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app1.quizapp.entity.UserAnswers;
import com.app1.quizapp.repository.UserAnswerRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class UserAnswerService {
	
	@Autowired
	UserAnswerRepository userAnswerRepository;
	public UserAnswerService(UserAnswerRepository userAnswerRepository) {
		this.userAnswerRepository = userAnswerRepository;
	}

	public List<UserAnswers> getAllUserAnswers() {
		
		return userAnswerRepository.findAll();
	}

	public UserAnswers createUserAnswer(UserAnswers userAnswer) {
		
		return userAnswerRepository.save(userAnswer);
	}

	public UserAnswers getUserAnswerById(Long id) {
		return userAnswerRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("User Answer Not Found"));
		
	}

	public UserAnswers updateUserAnswer(Long id, UserAnswers updatedUserAnswers) {
		UserAnswers userAnswer=getUserAnswerById(id);
		userAnswer.setUsers(updatedUserAnswers.getUsers());
		userAnswer.setQuestions(updatedUserAnswers.getQuestions());
		userAnswer.setSelectedOption(updatedUserAnswers.getSelectedOption());;
		
		return userAnswerRepository.save(userAnswer);
	}

	public void deleteUserAnswer(Long id) {
		UserAnswers userAnswer=getUserAnswerById(id);
		userAnswerRepository.delete(userAnswer);
	}

}
