<%@ page import="dao.EntryDAO,model.EntryModel,java.util.List,java.util.ArrayList" %>

<%
List<EntryModel> dummyEntries = new ArrayList<>();
	
	dummyEntries.add(new EntryModel(1, "Learned how to use JSP"));
	dummyEntries.add(new EntryModel(2, "CSS and Responsive Design"));
	dummyEntries.add(new EntryModel(3, "SQL Database Connectivity"));
	dummyEntries.add(new EntryModel(4, "Learned how to use JSP"));
	dummyEntries.add(new EntryModel(5, "CSS and Responsive Design"));
	dummyEntries.add(new EntryModel(6, "SQL Database Connectivity"));
	dummyEntries.add(new EntryModel(7, "Learned how to use JSP"));
	dummyEntries.add(new EntryModel(8, "CSS and Responsive Design"));
	dummyEntries.add(new EntryModel(9, "SQL Database Connectivity"));
%>

<html>
	<head>
	    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
	    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/card.css">
	</head>
	<body>
		<div class="app-container">	
		<%@ include file="header.jsp" %>
		
		<div class="scrollable-content">
            <main class="content-wrapper">
                <h1 class="topic-title">Topic Details</h1>
		
		        <form method="POST" class="center-form">
		            <input type="text" name="note" placeholder="Write a note...">
		            <button type="submit">Add Entry</button>
		        </form>
		
				<div class="card-list">
                    <%
                    for (EntryModel e : dummyEntries) {
                    %>
				    	<div class="learning-card">
				        	<div class="card-content">
				            	<p><%= e.getNote() %></p>
				                <small>Entry ID: <%= e.getId() %></small>
				            </div>
				        </div>
				    <% } %>
				</div>
	    	</main>
	    </div>
	    
	    <%@ include file="footer.jsp"%>
	    </div>
	</body>
</html>