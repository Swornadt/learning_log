package service;

import dao.TopicDAO;

import java.util.ArrayList;
import java.util.List;

import dao.EntryDAO;
import model.EntryModel;
import model.TopicModel;

public class TopicService {
	private TopicDAO topicDAO = new TopicDAO();
	private EntryDAO entryDAO = new EntryDAO();
	
	public List<TopicModel> getAllTopics() {
		return topicDAO.findAll();
	}
	
	// Functional Requirement Methods	
	public String addTopic(String name) {
		// 1. Check empty
		if (name == null || name.trim().isEmpty()){
			return "Topic name cannot be empty.";
		}
		// 2. Duplicate Check Logic
		List<TopicModel> existing = topicDAO.findAll();
		for (TopicModel t : existing) {
			if (t.getName().equalsIgnoreCase(name.trim())) {
				return "Duplicate topic name not allowed.";
			}
		}
		
		// 3. Save
		TopicModel newTopic = new TopicModel(0, name.trim());
		topicDAO.save(newTopic);
		return "Success";
	}
	
	
	public void viewAllTopics() {
		for (TopicModel t : topicDAO.findAll()) {
			System.out.println("ID: " + t.getId() + "\nName: " + t.getName());
		}
		if (topicDAO.findAll().isEmpty()) {
			System.out.println("No topics are available.");
		}
	}
	
	
	public void addEntryToTopic(int topicId, String note) {
		for (TopicModel t : topicDAO.findAll()) {
			
			if (t.getId()==topicId) {
				entryDAO.save(note, topicId);
				System.out.println("Entry saved to database for Topic ID: " + topicId);
				return;
			}
		}
		System.out.println("Topic not found");		
	}
	
	
	public List<EntryModel> getEntriesByTopic(String input) {
        try {
            int id = Integer.parseInt(input);
            return entryDAO.findEntryByTopicId(id);
        } catch (NumberFormatException e) {
            return entryDAO.findEntryByTopicName(input);
        }
    }
	
	
	public List<TopicModel> getTopicsByMultipleNames(String input) {
        if (input == null || input.isEmpty()) return new ArrayList<>();
        
        String[] nameArray = input.split(",");
        List<String> names = new ArrayList<>();
        for (String name : nameArray) {
            names.add(name.trim());
        }
        return topicDAO.findTopicsByNames(names);
    }
}
