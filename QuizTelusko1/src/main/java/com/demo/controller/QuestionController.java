package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.dao.QuestionDao;
import com.demo.model.Question;
import com.demo.service.QuestionService;

@RestController
@RequestMapping(path="/question")
public class QuestionController {
	@Autowired
	QuestionService questionService;
	@Autowired
	QuestionDao dao;
	
	@GetMapping(value="/allQuestions", produces ="application/json")
	public ResponseEntity<List<Question>> getAllQuestions() {
		return questionService.getAllQuestions(); 
		//return dao.findAll();
	}

	@GetMapping("/category/{category}")
	public ResponseEntity<List<Question>> getQuestionByCategory(@PathVariable String category){
		return questionService.getQuestionByCategory(category);
		
	}
	
	@PostMapping("/add")
	public ResponseEntity addQuestion(@RequestBody Question question) {
		return questionService.addQuestion(question);
	}
}
