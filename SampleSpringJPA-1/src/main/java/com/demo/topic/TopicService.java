package com.demo.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {
	
	@Autowired
	private TopicRepository topicRepository;
	
	private List<Topic> topics=new ArrayList<>(List.of(
			new Topic("1","spring boot","spring boot desc"),
			new Topic("2","spring MVC","spring MVC desc"),
			new Topic("3","spring AOP","spring AOP desc")
			));

	
	public List returnService() {
		List<Topic> top=(List<Topic>) topicRepository.findAll();
		return top;
	}
	
	public Topic returnSpecific(String id) {
		Optional<Topic> opt=topicRepository.findById(id);
		return opt.get();
	}
		
	
	public void addTopic(Topic topic) {
		
		//topics.add(topic);
		topicRepository.save(topic);
	}
		
	public void updateTopic(Topic topic, String id) {
		/*for(int i=0;i<topics.size();i++) {
			if(topics.get(i).getId().equals(id)) {
				topics.set(i, topic);
			}
		}*/
		topicRepository.save(topic);
	}
	
	public void deleteTopic(String id) {
		/*
		 * for(int i=0;i<topics.size();i++) { if(topics.get(i).getId().equals(id)) {
		 * topics.remove(i); } }
		 */
		
		topicRepository.deleteById(id);
	}
}
