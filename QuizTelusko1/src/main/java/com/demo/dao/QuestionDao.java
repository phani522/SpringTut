package com.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.demo.model.Question;

public interface QuestionDao extends JpaRepository<Question, Integer> {
	public List<Question> findByCategory(String category);
	@Query(value="select * from question q where q.category=:category order by Random() LIMIT :numQ",nativeQuery = true)
	public List<Question> findRandomQuestionsByCategory(String category, int numQ);

}
