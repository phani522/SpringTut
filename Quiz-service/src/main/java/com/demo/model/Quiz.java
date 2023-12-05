package com.demo.model;

import java.util.List;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Quiz {
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY )
	private int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public Quiz() {
		super();
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public List<Integer> getQuesIds() {
		return quesIds;
	}
	public void setQuesIds(List<Integer> quesIds) {
		this.quesIds = quesIds;
	}
	
	public Quiz(String title, List<Integer> quesIds) {
		super();
		this.title = title;
		this.quesIds = quesIds;
	}

	private String title;
	@ElementCollection
	private List<Integer> quesIds;
}
