package com.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.model.Quiz;

public interface QuizDao extends JpaRepository<Quiz, Integer>{
	//public List<Question> findRandomQuestionsByCategory(String category, int numQ);

}
