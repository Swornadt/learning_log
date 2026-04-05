package service;

import dao.RegisterDAO;
import com.utils.PasswordUtil;

public class RegisterService {

    public void addStudent(String firstName, String lastName, String username, String dob,
            String gender, String email, String number, String password, int programId) throws Exception {

        // Hash the password
        String hashedPassword = PasswordUtil.getHashPassword(password);

        RegisterDAO dao = new RegisterDAO();
        dao.insertStudent(firstName, lastName, username, dob, gender, email, number, hashedPassword, programId);
    }
}