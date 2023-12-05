package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.dao.QuestionDao;
import com.demo.model.Question;
import com.demo.model.QuestionWrapper;
import com.demo.model.Response;
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
	
	@GetMapping("/generate")
	public ResponseEntity<List<Integer>> generateQuizQuestions(@RequestParam String category, @RequestParam int numQ){
		return questionService.generateQuizQuestions(category,numQ);
	}
	
	@PostMapping("/getQuestions")
	public ResponseEntity<List<QuestionWrapper>> getQuestionsById(@RequestBody List<Integer> questionIds){
		return questionService.getQuestionsById(questionIds);
	}
	
	@PostMapping("/getScore")
	public ResponseEntity<Integer> getScore(@RequestBody List<Response> responses){
		return questionService.getScore(responses);
	}
	
}
