package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import dao.LoginDAO;

/**
 * Servlet implementation class LoginController
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/login" })
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/pages/login.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		// To check the credentials, using DAO.
		LoginDAO dao = new LoginDAO();

		try {
			if (dao.checkUser(username, password)) {
				// start a session for the user
				HttpSession session = request.getSession();
				session.setAttribute("isLogin", true);
				session.setAttribute("user", username);	
				response.sendRedirect(request.getContextPath() + "/home");
			} else {
				System.out.println("Login Error: " + username);
				request.setAttribute("errorMessage", "Password or username is invalid.");
				request.getRequestDispatcher("WEB-INF/pages/login.jsp").forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
