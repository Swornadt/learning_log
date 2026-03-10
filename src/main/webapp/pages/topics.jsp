<%@ page import="dao.TopicDAO, model.Topic, java.util.List, java.util.ArrayList" %>
<%
    TopicDAO dao = new TopicDAO();
    //List<Topic> topics = dao.findAll();
    //boolean hasTopics = (topics != null && !topics.isEmpty());
    
    List<Topic> topics = new ArrayList<>();
    topics.add(new Topic(1, "Web Development Basics"));
    topics.add(new Topic(2, "Advanced Java & Spring"));
    topics.add(new Topic(3, "Database Design & SQL"));
    topics.add(new Topic(4, "UI/UX Principles"));
    topics.add(new Topic(5, "Cloud Infrastructure"));
%>

<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="../css/style.css">
    <link rel="stylesheet" href="../css/topics.css">
</head>

<script>
    function toggleForm() {
        var card = document.getElementById('addCard');
        var form = document.getElementById('inputForm');
        
        if (form.style.display === 'none') {
            card.style.display = 'none'; 
            form.style.display = 'block';
        } else {
            card.style.display = 'flex'; 
            form.style.display = 'none'; 
        }
    }
</script>

<body>
    <div class="app-container">
        <%@ include file="header.jsp" %>
        
        <div class="scrollable-content">
            <main class="content-wrapper">
                <h1 class="topic-title">Your Topics</h1>
                
                <div class="classroom-grid">
	                <div class="topic-card add-topic-card" id="addCard" onclick="toggleForm()" style="cursor: pointer;">
				        <div class="add-button">
				            <span class="plus-icon">+</span>
				            Create New Topic
				        </div>
				    </div>
				    
				    <form id="inputForm" style="display: none; padding: 20px;" method="POST">
					    <input type="text" name="topicName" placeholder="Enter topic name..." required style="width: 100%; margin-bottom: 10px;">
					    <button type="submit">Save</button>
					    <button type="button" onclick="toggleForm()">Cancel</button>
					</form>
				    
                    <% if (topics == null || topics.isEmpty()) { %>
                        <p>No topics found. Create your first topic!</p>
                        
                    <% } else { %>
                        <% for (Topic t : topics) { %>
                            <div class="topic-card">
                                <div class="topic-header">
                                    <h2><%= t.getName() %></h2>
                                </div>
                                <div class="topic-body">
                                    <p>Click to view all notes for this topic.</p>
                                </div>
                                <div class="topic-footer">
                                    <a href="entries.jsp?topicId=<%= t.getId() %>">View Entries</a>
                                </div>
                            </div>
                        <% } %>
                    <% } %>
                    
                </div>
            </main>
        </div>
        
        <%@ include file="footer.jsp" %>
    </div>
</body>
</body>
</html>