<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page import="model.EntryModel, java.util.List" %>

<html>
	<head>
	    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
	    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/card.css">
		<title>Topic Entries</title>
	</head>
	<body>
		<div class="app-container">	
		<%@ include file="header.jsp" %>
		
		<div class="scrollable-content">
            <main class="content-wrapper">
                <h1 class="topic-title">Topic Details</h1>
		
		        <form action="entries" method="POST" class="center-form">
                    <input type="hidden" name="topicId" value="${currentTopicId}">
                    
                    <input type="text" name="note" placeholder="Write a note..." required>
                    <button type="submit">Add Entry</button>
                </form>
		
				<div class="card-list">
                    <c:choose>
                        <c:when test="${empty entryList}">
                            <p class="no-data">No entries found for this topic. Start by adding one above!</p>
                        </c:when>
                        <c:otherwise>
                            <c:forEach var="e" items="${entryList}">
                                <div class="learning-card">
                                    <div class="card-content">
                                        <p><c:out value="${e.note}" /></p>
                                        <small>Entry ID: ${e.id}</small>
                                    </div>
                                </div>
                            </c:forEach>
                        </c:otherwise>
                    </c:choose>
                </div>
	    	</main>
	    </div>
	    
	    <%@ include file="footer.jsp"%>
	    </div>
	</body>
</html>