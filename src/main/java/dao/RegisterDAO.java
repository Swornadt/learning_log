package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import com.utils.DBconfig;

public class RegisterDAO {
	public void insertStudent(String firstName, String lastName, String username, String dob,
            String gender, String email, String number, String password, int programId) throws Exception {

        Connection conn = DBconfig.getConnection();

        String sql = "INSERT INTO student (first_name, last_name, username, dob, gender, email, number, password, program_id) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setString(1, firstName);
        pst.setString(2, lastName);
        pst.setString(3, username);
        pst.setString(4, dob);
        pst.setString(5, gender);
        pst.setString(6, email);
        pst.setString(7, number);
        pst.setString(8, password);
        pst.setInt(9, programId);

        pst.executeUpdate();
        pst.close();
        conn.close();
    }
}