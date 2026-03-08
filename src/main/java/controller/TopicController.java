package controller;

import dao.TopicDAO;

import java.util.ArrayList;
import java.util.List;

import dao.LearningEntryDAO;
import model.LearningEntry;
import model.Topic;

public class TopicController {
	private TopicDAO topicDAO = new TopicDAO();
	LearningEntryDAO learningEntryDAO = new LearningEntryDAO();
		
	
	// Functional Requirement Methods	
	public void addTopic(String name) {
		if (name.trim().equals("")) {
			System.out.println("Invalid name.");
			
			for (Topic t : topicDAO.findAll()) {
				if (t.getName().equals(name)) {
					System.out.println("Duplicate topic name not allowed.");
				}
			}
			return;
		}
		Topic newTopic = new Topic(0, name);
		topicDAO.save(newTopic);
	}
	
	
	public void viewAllTopics() {
		for (Topic t : topicDAO.findAll()) {
			System.out.println("ID: " + t.getId() + "\nName: " + t.getName());
		}
		if (topicDAO.findAll().isEmpty()) {
			System.out.println("No topics are available.");
		}
	}
	
	
	public void addEntryToTopic(int topicId, String note) {
		for (Topic t : topicDAO.findAll()) {
			
			if (t.getId()==topicId) {
				learningEntryDAO.save(note, topicId);
				System.out.println("Entry saved to database for Topic ID: " + topicId);
				return;
			}
		}
		System.out.println("Topic not found");		
	}
	
	
	public void viewEntriesByTopic(String input) {
		try {
	        int id = Integer.parseInt(input);
	        // If parsing succeeds, search by ID
	        for (LearningEntry e1 : learningEntryDAO.findEntryByTopicId(id)) {
	            System.out.println("Note: " + e1.getNote());
	        }
	    } catch (NumberFormatException e) {
	        // If parsing fails, treat as a name
	        for (LearningEntry e2 : learningEntryDAO.findEntryByTopicName(input)) {
	            System.out.println("Note: " + e2.getNote());
	        }
	    }
	}
	
	
	public void viewTopicsByNames(String input) {
		String[] nameArray = input.split(",");
		List<String> names = new ArrayList<>();
		for (String name : nameArray) {
			names.add(name.trim());
		}
		
		List<Topic> results = topicDAO.findTopicsByNames(names);
		
		for (Topic t : results) {
			System.out.println("Found: "+t.getName());
		}
	}
}
