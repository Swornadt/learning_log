<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/topics.css">
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
        <%@ include file="./header.jsp" %>
        
        <div class="scrollable-content">
            <main class="content-wrapper">
                <h1 class="topic-title">Your Topics</h1>
                
                <!-- For Error Messages -->
                <c:if test="${not empty error}">
				    <div class="error-banner" style="color: red; margin-bottom: 20px;">
				        ${error}
				    </div>
				</c:if>
				
				<!-- Main Grid for Entries -->
                <div class="classroom-grid">
	                <div class="topic-card add-topic-card" id="addCard" onclick="toggleForm()" style="cursor: pointer;">
				        <div class="add-button">
				            <span class="plus-icon">+</span>
				            Create New Topic
				        </div>
				    </div>
				    
				    <form id="inputForm" style="display: none; padding: 20px;" action="topics" method="POST">
					    <input type="text" name="topicName" placeholder="Enter topic name..." style="width: 100%; margin-bottom: 10px;">
					    <button type="submit">Save</button>
					    <button type="button" onclick="toggleForm()">Cancel</button>
					</form>
				    
                    <c:choose>
                    	<c:when test="${empty topics}">
				            <p>No topics found. Create your first topic!</p>
				        </c:when>
				        <c:otherwise>
				            <c:forEach var="t" items="${topics}">
				                <div class="topic-card">
				                    <div class="topic-header">
				                        <h2>${t.name}</h2>
				                    </div>
				                    <div class="topic-body">
				                        <p>Click to view all notes for this topic.</p>
				                    </div>
				                    <div class="topic-footer">
				                        <a href="entries?topicId=${t.id}">View Entries</a>
				                    </div>
				                </div>
				            </c:forEach>
				        </c:otherwise>
                    </c:choose>          
                </div>
            </main>
        </div>
        
        <%@ include file="footer.jsp" %>
    </div>
</body>
</body>
</html>