<%@ page import="dao.LearningEntryDAO, model.LearningEntry, java.util.List" %>
<%
String topicIdStr = request.getParameter("topicId");
int topicId = 0; // Default value

if (topicIdStr != null && !topicIdStr.isEmpty()) {
    topicId = Integer.parseInt(topicIdStr);
}
    LearningEntryDAO dao = new LearningEntryDAO();
    
    // Check if user submitted a new note
    String note = request.getParameter("note");
    if (note != null && !note.isEmpty()) {
        dao.save(note, topicId);
        response.sendRedirect("entries.jsp?topicId=" + topicId);
    }
    
    // Get all entries for this topic
    List<LearningEntry> entries = dao.findEntryByTopicId(topicId);
%>

<html>
<head>
    <style>
        .card { border: 1px solid #ccc; padding: 15px; margin: 10px; width: 200px; display: inline-block; vertical-align: top; border-radius: 10px; box-shadow: 2px 2px 5px #eee; }
        form { margin-bottom: 30px; }
    </style>
</head>
<body>
	<%@ include file="header.jsp" %>
    <h1>Topic #<%= topicId %></h1>

    <form method="POST">
        <input type="text" name="note" placeholder="Write a note...">
        <button type="submit">Add Entry</button>
    </form>

    <div>
        <% for (LearningEntry e : entries) { %>
            <div class="card">
                <p><%= e.getNote() %></p>
            </div>
        <% } %>
    </div>
</body>
</html>