package com.demo.course;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.demo.topic.Topic;

@RestController
public class CourseController {
	@Autowired
	private CourseService courseService;
	

	@RequestMapping("/topics/{topicId}/courses")
	public List returnAllTopics(@PathVariable String topicId) {
		return courseService.returnService(topicId);
		
	}
	@RequestMapping("/topics/{topicId}/courses/{foo}")
	public Course returnId(@PathVariable("foo") String id) {
		return courseService.returnSpecific(id);
	}
	
	@RequestMapping(method = RequestMethod.POST, value="/topics/{topicId}/courses")
	public void addTopic(@RequestBody Course course,@PathVariable String topicId) {
		course.setTopic(new Topic(topicId,"",""));
		courseService.addTopic(course);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value="/topics/{topicId}/courses/{id}")
	public void updateTopic(@RequestBody Course course, @PathVariable String id, @PathVariable String topicId ) {
		course.setTopic(new Topic(topicId,"",""));
		courseService.updateTopic(course);
	}
	
	@RequestMapping(method = RequestMethod.DELETE,value = "/topics/{topicId}/courses/{id}")
	public void delete(@PathVariable String id) {
		courseService.deleteTopic(id);
	}
	
	
	public CourseController() {
		// TODO Auto-generated constructor stub
	}

}
