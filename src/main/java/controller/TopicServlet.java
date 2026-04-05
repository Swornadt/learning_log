package controller;

import service.TopicService; 

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/topics")
public class TopicServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TopicService service = new TopicService();
       
    public TopicServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("topics", service.getAllTopics());
		request.getRequestDispatcher("/WEB-INF/pages/topics.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("topicName");
	    TopicService service = new TopicService();
	    
	    String result = service.addTopic(name);

	    if (result.equals("Success")) {
	    	response.sendRedirect(request.getContextPath() + "/topics");
	    } else {
	        // Send the specific error message back to the JSP
	        request.setAttribute("error", result);
	        request.setAttribute("topics", service.getAllTopics());
	        request.getRequestDispatcher("/WEB-INF/pages/topics.jsp").forward(request, response);
	    }
	}
}
