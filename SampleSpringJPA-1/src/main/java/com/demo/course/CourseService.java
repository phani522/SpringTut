package com.demo.course;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {
	
	@Autowired
	private CourseRepository courseRepository;
	
	

	
	public List returnService(String id) {
		List<Course> courses=(List<Course>) courseRepository.findByTopicId(id);
		return courses;
	}
	
	public Course returnSpecific(String id) {
		Optional<Course> opt=courseRepository.findById(id);
		return opt.get();
		
	}
		
	
	public void addTopic(Course course) {
		
		//topics.add(topic);
		courseRepository.save(course);
	}
		
	public void updateTopic(Course course) {
		/*for(int i=0;i<topics.size();i++) {
			if(topics.get(i).getId().equals(id)) {
				topics.set(i, topic);
			}
		}*/
		courseRepository.save(course);
	}
	
	public void deleteTopic(String id) {
		/*
		 * for(int i=0;i<topics.size();i++) { if(topics.get(i).getId().equals(id)) {
		 * topics.remove(i); } }
		 */
		
		courseRepository.deleteById(id);
	}
}
