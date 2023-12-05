package com.demo.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TopicService {
	private List<Topic> topics=new ArrayList<>(List.of(
			new Topic("1","spring boot","spring boot desc"),
			new Topic("2","spring MVC","spring MVC desc"),
			new Topic("3","spring AOP","spring AOP desc")
			));

	public TopicService() {
		// TODO Auto-generated constructor stub
	}
	
	public List returnService() {
		return topics;
	}
	public Topic returnSpecific(String id) {
		for(Topic t:topics) {
			if(t.getId().equals(id))
				return t;
		}
		return null;
	}
	
	public void addTopic(Topic topic) {
		topics.add(topic);
	}
		
	public void updateTopic(Topic topic, String id) {
		for(int i=0;i<topics.size();i++) {
			if(topics.get(i).getId().equals(id)) {
				topics.set(i, topic);
			}
		}
	}
	
	public void deleteTopic(String id) {
		for(int i=0;i<topics.size();i++) {
			if(topics.get(i).getId().equals(id)) {
				topics.remove(i);
			}
		}
	}
}
