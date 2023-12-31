package com.demo.topic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TopicController {
	@Autowired
	private TopicService topicService;
	

	@RequestMapping("/topics")
	public List returnAllTopics() {
		return topicService.returnService();
		
	}
	@RequestMapping("/topics/{foo}")
	public Topic returnId(@PathVariable("foo") String id) {
		return topicService.returnSpecific(id);
	}
	
	@RequestMapping(method = RequestMethod.POST, value="/topics")
	public void addTopic(@RequestBody Topic topic) {
		topicService.addTopic(topic);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value="/topics/{id}")
	public void updateTopic(@RequestBody Topic topic, @PathVariable String id ) {
		topicService.updateTopic(topic, id);
	}
	
	@RequestMapping(method = RequestMethod.DELETE,value = "/topics/{id}")
	public void delete(@PathVariable String id) {
		topicService.deleteTopic(id);
	}
	
	
	public TopicController() {
		// TODO Auto-generated constructor stub
	}

}
