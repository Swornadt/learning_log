package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.utils.DBconfig;
import com.utils.PasswordUtil;

public class LoginDAO {
	public boolean checkUser(String username, String password) throws Exception {

        Connection conn = DBconfig.getConnection();

        // 1. Select only by username
        String sql = "SELECT password FROM student WHERE username = ?";

        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setString(1, username);
        
        // 2. Use executeQuery for select statements
        ResultSet rs = pst.executeQuery();
        boolean isValid = false;
        
        if (rs.next()) {
        	String storedHash = rs.getString("password");
        	// 3. using bcrypt to compare input with the hash
        	isValid = PasswordUtil.checkPassword(password, storedHash);
        }
        
        rs.close();
        pst.close();
        conn.close();
        
        return isValid;
    }
}