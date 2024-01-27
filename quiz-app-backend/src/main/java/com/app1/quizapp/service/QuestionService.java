package com.app1.quizapp.service;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app1.quizapp.entity.Questions;
import com.app1.quizapp.repository.QuestionRepository;

@Service
public class QuestionService {
	
	@Autowired
	QuestionRepository questionRepository;

	public List<Questions> getAllQuestion() {
		return questionRepository.findAll();
	}

	public Questions createQuestion(Questions question) {
		
		return questionRepository.save(question);
	}

	public Questions getQuestionById(Long id) {
        return questionRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Question not found"));
    }

	public Questions updateQuestion(Long id , Questions updatedQuestion) {
		Questions question=new Questions();
		question.setQuestionText(updatedQuestion.getQuestionText());
		question.setOption1(updatedQuestion.getOption1());
		question.setOption2(updatedQuestion.getOption2());
		question.setOption3(updatedQuestion.getOption3());
		question.setOption4(updatedQuestion.getOption4());
		question.setCorrectOption(updatedQuestion.getCorrectOption());
		question.setTechnology(updatedQuestion.getTechnology());
		return questionRepository.save(question);
	}

	public void deleteQuestion(Long id) {
		Questions question=getQuestionById(id);
		
		questionRepository.delete(question);
	}
}
