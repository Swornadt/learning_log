<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Login to your account</title>
		<link rel="stylesheet" type="text/css"
		href="<%=request.getContextPath()%>/css/login.css" />
	</head>
	<body>
	    <div class="login-box"> <h1>Login</h1> 
		    <%-- Display error if login fails --%>
			<% if (request.getAttribute("errorMessage") != null) { %>
			    <p style="color: red; text-align: center;">
			        <%= request.getAttribute("errorMessage") %>
			    </p>
			<% } %>
	    	<form action="${pageContext.request.contextPath}/login" method="post">
	            <div class="row">
	                <div class="col">
	                    <label for="username">Username:</label>
	                    <input type="text" id="username" name="username" required>
	                </div>
	            </div>
	            
	            <div class="row">
	                <div class="col">
	                    <label for="password">Password:</label>
	                    <input type="password" id="password" name="password" required>
	                </div>
	            </div>
	            
	            <button type="submit">Login</button>
	        </form>
	        
	        <a href="${pageContext.request.contextPath}/forgotpassword" class="forgot-button">
	            Forgot Password?
	        </a>
	        <a href="${pageContext.request.contextPath}/register" class="forgot-button" style="color: #5f6368;">
	            Don't have an account? Register
	        </a>
	    </div>
	</body>
</html>