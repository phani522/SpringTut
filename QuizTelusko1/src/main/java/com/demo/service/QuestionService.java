package com.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import com.demo.model.*;

import com.demo.dao.QuestionDao;

@Service
public class QuestionService {
	@Autowired
	QuestionDao dao;
	//@RequestMapping(produces = "application/json")
	public ResponseEntity<List<Question>> getAllQuestions() {
		//System.out.println(dao.findAll());
		try {
		return new ResponseEntity<>(dao.findAll(),HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<List<Question>>(new ArrayList(),HttpStatus.BAD_REQUEST);
		
	}
	
	public ResponseEntity<List<Question>> getQuestionByCategory(String category){
		
		try {
		return new ResponseEntity<>(dao.findByCategory(category),HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<List<Question>>(new ArrayList(),HttpStatus.BAD_REQUEST);
		
	}
	
	public ResponseEntity addQuestion(Question question) {
		
		try {
			dao.save(question);
			return new ResponseEntity<>("success",HttpStatus.CREATED);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>("bad request",HttpStatus.BAD_REQUEST);
	}

}
