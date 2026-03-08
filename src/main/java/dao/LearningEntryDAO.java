package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import java.time.LocalDateTime;

import java.util.ArrayList;
import java.util.List;

import model.LearningEntry;

import com.utils.DBconfig;

public class LearningEntryDAO {
	
	public void save(String note, int topicID) {
		String sql = "INSERT INTO entries (topic_id, note, created_at, updated_at) VALUES (?,?,?,?)";
		
		try (Connection conn = DBconfig.getConnection();
				PreparedStatement pre = conn.prepareStatement(sql)) {
			
			LocalDateTime currentTime = LocalDateTime.now();
			pre.setInt(1, topicID);
			pre.setString(2, note);
			pre.setTimestamp(3,  Timestamp.valueOf(currentTime));
			pre.setTimestamp(4,  Timestamp.valueOf(currentTime));
			pre.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public List<LearningEntry> findEntryByTopicId(int topicId) {
        List<LearningEntry> entries = new ArrayList<>();
        String sql = "SELECT * FROM entries WHERE topic_id = ?";
        
        try (Connection conn = DBconfig.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setInt(1, topicId);
            ResultSet rs = pstmt.executeQuery();
            
            while (rs.next()) {
                LearningEntry entry = new LearningEntry(rs.getInt("id"), rs.getString("note"));
                entries.add(entry);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return entries;
    }
	
	
	public List<LearningEntry> findEntryByTopicName(String name) {
        List<LearningEntry> entries = new ArrayList<>();
        String sql = "SELECT e.* FROM entries e " + 
        			"JOIN topics t ON e.topic_id = t.id "+
        			"WHERE UPPER(t.name) = UPPER(?)";
        
        try (Connection conn = DBconfig.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, name);
            ResultSet rs = pstmt.executeQuery();
            
            while (rs.next()) {
                LearningEntry entry = new LearningEntry(rs.getInt("id"), rs.getString("note"));
                entries.add(entry);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return entries;
    }
}
