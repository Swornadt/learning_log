package model;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class TopicModel {
	private int id;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
	private String name;
	
	private ArrayList<EntryModel> entries = new ArrayList<>();
	
	
	// Constructor
	public TopicModel (int id, String name) {
		this.id = id;
		this.name = name;
		this.createdAt = LocalDateTime.now();
		this.updatedAt = LocalDateTime.now();
	}
	
	
	// Adding Learning Entries into the ArrayList
	public void addEntry(EntryModel entry) {
		this.entries.add(entry);
		this.updatedAt = LocalDateTime.now();
	}
	
	public ArrayList<EntryModel> getEntries() {
		return this.entries;
	}
	
	
	// Getters and Setters
	public int getId() {
		return this.id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public LocalDateTime getCreatedAt() {
		return this.createdAt;
	}
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	
	public LocalDateTime getUpdatedAt() {
		return this.updatedAt;
	}
	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}
}
