package com.app1.quizapp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app1.quizapp.entity.Questions;
import com.app1.quizapp.entity.Quiz;
import com.app1.quizapp.entity.QuizQuestion;
import com.app1.quizapp.repository.QuestionRepository;
import com.app1.quizapp.repository.QuizQuestionRepository;
import com.app1.quizapp.repository.QuizRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class QuizService {
	@Autowired
	QuizRepository quizRepository;
	@Autowired
	QuizQuestionRepository quizQuestionRepository;
	@Autowired
	QuestionRepository questionRepository;
	public QuizService(QuizRepository quizRepository) {
		this.quizRepository = quizRepository;
	}

	public Quiz createQuiz(Quiz quiz) {
		
		return quizRepository.save(quiz);
	}

	public List<Quiz> geAllQuizzes() {
		
		return quizRepository.findAll();
	}

	public Quiz getQuizById(Long id) {
		
		return quizRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("Quiz"));
	}

	public Quiz updateQuiz(Long id, Quiz updateQuiz) {
		Quiz quiz=getQuizById(id);
		quiz.setQuizName(updateQuiz.getQuizName());
		quiz.setTechnology(updateQuiz.getTechnology());
		
		return quizRepository.save(quiz);
	}

	public void deleteQuiz(Long id) {
		Quiz quiz=getQuizById(id);
		quizRepository.delete(quiz);
		
	}

	public List<Questions> getQuizQuestionById(Long id) {
		System.out.println("Id"+id);
		List<QuizQuestion> quizQuesList=quizQuestionRepository.findByQuiz(getQuizById(id));
		List<Questions> questionList=new ArrayList<>();
		for(QuizQuestion quizQues:quizQuesList) {
			Optional<Questions> optionalQuestion=questionRepository.findById(quizQues.getQuestion().getId());
			optionalQuestion.ifPresent(questionList::add);
		}
		questionList.forEach(q->System.out.println(q.getQuestionText()));
		return questionList;
	}

}
