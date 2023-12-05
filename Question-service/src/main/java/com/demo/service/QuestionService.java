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

	public ResponseEntity<List<Integer>> generateQuizQuestions(String category, int numQ) {
		// TODO Auto-generated method stub
		
		List<Integer> questions= dao.findRandomQuestionsByCategory(category, numQ);
		return new ResponseEntity<List<Integer>>(questions,HttpStatus.OK);
		
		//return null;
	}

	public ResponseEntity<List<QuestionWrapper>> getQuestionsById(List<Integer> questionIds) {
		
		List<QuestionWrapper> qw=new ArrayList<>();
		List<Question> ques=new ArrayList<>();
		for(int id:questionIds) {
			ques.add(dao.findById(id).get());
		}
		for(Question q:ques) {
			QuestionWrapper wrap=new QuestionWrapper(q.getId(),q.getOption1(),q.getOption2(),q.getOption3(),q.getOption4(),q.getQuestionTitle());
			qw.add(wrap);
			
		}
		
		// TODO Auto-generated method stub
		//return null;
		return new ResponseEntity<List<QuestionWrapper>>(qw,HttpStatus.OK);
	}

	public ResponseEntity<Integer> getScore(List<Response> responses) {
		// TODO Auto-generated method stub
		
		int result=0;
		for(Response res:responses) {
			Question qu=dao.findById(res.getId()).get();
			if(res.getResponse().equals(qu.getRightAnswer())) {
				result++;
			}
		}
		
		return new ResponseEntity(result,HttpStatus.OK);
	}
	
	

}
