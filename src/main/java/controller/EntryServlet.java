package controller;

import model.EntryModel;
import service.EntryService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(asyncSupported = true, urlPatterns = { "/entries" })
public class EntryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EntryService entryService = new EntryService();
       
    public EntryServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String topicIdStr = request.getParameter("topicId");
		String topicName = request.getParameter("name");
		List<EntryModel> entries = null;
		
		if (topicIdStr != null && !topicIdStr.isEmpty()) {
			int topicId = Integer.parseInt(topicIdStr);
			entries = entryService.getEntriesByTopicId(topicId);
			request.setAttribute("currentTopicId", topicId);
		}
		else if (topicName != null && !topicName.isEmpty()) {
			entries = entryService.getEntriesByTopicName(topicName);
		}
		
		request.setAttribute("entryList", entries);
		request.getRequestDispatcher("/WEB-INF/pages/entries.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String note = request.getParameter("note");
		String topicIdStr = request.getParameter("topicId");
		
		String result = entryService.saveEntry(note, topicIdStr);
		
		if (result.equals("Success")) {
			response.sendRedirect("entries?topicId=" + topicIdStr);
		} else {
			request.setAttribute("error", result);
			doGet(request, response);
		}
	}

}
