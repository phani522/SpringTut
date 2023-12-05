package com.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.demo.dao.QuestionDao;
import com.demo.dao.QuizDao;
import com.demo.model.Question;
import com.demo.model.QuestionWrapper;
import com.demo.model.Quiz;
import com.demo.model.Response;
@Service
public class QuizService {

	@Autowired
	QuizDao dao;
	@Autowired
	QuestionDao questionDao;
	public ResponseEntity createQuiz(String category, int numQ, String title) {
		// TODO Auto-generated method stub
		List<Question> questions= questionDao.findRandomQuestionsByCategory(category, numQ);
		Quiz quiz=new Quiz();
		quiz.setTitle(title);
		quiz.setQuestions(questions);
		dao.save(quiz);
	
		return new ResponseEntity<>("successful quiz creation", HttpStatus.CREATED);
	}
	
	public ResponseEntity<List<QuestionWrapper>> getQuiz(int quizId) {
		// TODO Auto-generated method stub
		
		//dao.findB
		Quiz quiz=dao.getById(quizId);
		List<Question> questiondb= quiz.getQuestions();
		List<QuestionWrapper> qwrapper= new ArrayList<>();
		for(Question q:questiondb) {
		
			QuestionWrapper qw=new QuestionWrapper(q.getId(), q.getOption1(), q.getOption2(), q.getOption3(), q.getOption4(),q.getQuestionTitle());
			qwrapper.add(qw);
		}
		return new ResponseEntity<List<QuestionWrapper>>(qwrapper,HttpStatus.OK);
	}

	public ResponseEntity<Integer> calculateResult(int id, List<Response> responses) {
		
		Quiz quiz=dao.findById(id).get();
		//System.out.println(quiz);
		System.out.println("submit initiated");
		List<Question> questions=quiz.getQuestions();
		//System.out.println(questions.get(0).getRightAnswer());
		int res=0;//i=0;
		/*for(Response r:responses) {
			System.out.println("response id "+r.getId()+" and response is "+r.getResponse());
			if(r.getId()==questions.get(i).getId()&&r.getResponse().equals(questions.get(i).getRightAnswer())) {
				System.out.println("correct "+r.getId()+" answer is "+questions.get(i).getRightAnswer()+"*");
				res++;
			}
			i++;
			
		}*/
		
		for(Response r:responses) {
			for(int i=0;i<questions.size();i++) {
				if(r.getId()==questions.get(i).getId()&&r.getResponse().equals(questions.get(i).getRightAnswer())) {
					res++;
				}
			}
		}
		// TODO Auto-generated method stub
		return new ResponseEntity<Integer>(res,HttpStatus.OK);
	}

}
