package model;

import java.time.LocalDateTime;

public class EntryModel {
	private int id;
	private String note;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
	
	public EntryModel(int id, String note) {
		this.id = id;
		this.note = note;
		this.createdAt = LocalDateTime.now();
		this.updatedAt = LocalDateTime.now();
	}
	
	
	// Getters and Setters
	public int getId() {
		return this.id;
	}
	public void setId(int id) {
		this.id = id;
	}
		
	public String getNote() {
		return this.note;
	}
	public void setNote(String note) {
		this.note = note;
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
