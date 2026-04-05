package service;

import java.util.List;
import dao.EntryDAO;
import model.EntryModel;

public class EntryService {
    private EntryDAO entryDAO = new EntryDAO();

    public List<EntryModel> getEntriesByTopicId(int topicId) {
        return entryDAO.findEntryByTopicId(topicId);
    }

    public List<EntryModel> getEntriesByTopicName(String name) {
        if (name == null || name.trim().isEmpty()) return null;
        return entryDAO.findEntryByTopicName(name.trim());
    }

    public String saveEntry(String note, String topicIdStr) {
        if (note == null || note.trim().isEmpty()) {
            return "Note content cannot be empty.";
        }
        
        try {
            int topicId = Integer.parseInt(topicIdStr);
            entryDAO.save(note.trim(), topicId);
            return "Success";
        } catch (NumberFormatException e) {
            return "Invalid Topic ID.";
        }
    }
}