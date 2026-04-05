package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.utils.DBconfig;

import model.TopicModel;

public class TopicDAO {
	
	public void save(TopicModel topic) {
		String sql = "INSERT INTO topics (name, createdAt, updatedAt) VALUES (?, ?, ?)";
		
		try (Connection conn = DBconfig.getConnection();
				PreparedStatement pre = conn.prepareStatement(sql)) {
			pre.setString(1, topic.getName());
			pre.setTimestamp(2, Timestamp.valueOf(topic.getCreatedAt()));
			pre.setTimestamp(3, Timestamp.valueOf(topic.getUpdatedAt()));
			pre.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public List<TopicModel> findAll() {
		List<TopicModel> topics = new ArrayList<>();
		String sql = "SELECT * FROM topics";
		
		try (Connection conn = DBconfig.getConnection();
				PreparedStatement pre = conn.prepareStatement(sql);
				ResultSet rs = pre.executeQuery()) {
			
			while (rs.next()) {
				TopicModel t = new TopicModel(rs.getInt("id"), rs.getString("name"));
				t.setCreatedAt(rs.getTimestamp("createdAt").toLocalDateTime());
				t.setUpdatedAt(rs.getTimestamp("updatedAt").toLocalDateTime());
				topics.add(t);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return topics;		
	}
	
	
	public List<TopicModel> findTopicsByNames(List<String> names) {
		List<TopicModel> topics = new ArrayList<>();
		
		StringBuilder sql = new StringBuilder("SELECT * FROM topics WHERE name IN (");
		for (int i = 0; i < names.size(); i++ ) {
			sql.append(i==0 ? "?" : ", ?");
		}
		sql.append(")");
		
		try (Connection conn = DBconfig.getConnection();
				PreparedStatement pre = conn.prepareStatement(sql.toString())) {
					
			for (int i=0; i<names.size(); i++) {
				pre.setString(i+1, names.get(i));
			}
			
			ResultSet rs = pre.executeQuery();
			while(rs.next()) {
				topics.add(new TopicModel(rs.getInt("id"), rs.getString("name")));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return topics;
	}
}
