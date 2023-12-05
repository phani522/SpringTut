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

import com.demo.model.QuestionWrapper;
import com.demo.model.Quiz;
import com.demo.model.Response;
import com.demo.service.QuizService;

@RestController
@RequestMapping("/quiz")
public class QuizController {
	@Autowired
	QuizService quizService;
	
	@PostMapping("/create")
	public ResponseEntity createQuiz(@RequestParam String category,@RequestParam int numQ, @RequestParam String title) {
		
		return quizService.createQuiz(category,numQ,title);
	}
	
	@GetMapping("/get/{quizId}")
	public ResponseEntity<List<QuestionWrapper>> getQuiz(@PathVariable int quizId){
		
		return quizService.getQuiz(quizId);
		
	}
	
	@GetMapping("/submit/{id}")
	public ResponseEntity<Integer> calculateResult(@PathVariable int id, @RequestBody List<Response> responses){
		return quizService.calculateResult(id,responses);
	}

	
}
