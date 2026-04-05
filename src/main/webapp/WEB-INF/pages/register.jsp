<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LearningLog - Register</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/register.css" />
</head>
<body>
	<div class="container">

		<h1>Registration Form</h1>


		<form action="${pageContext.request.contextPath}/register"
			method="post">
			<div class="row">
				<div class="col">
					<label for="first_name">First Name:</label> <input type="text"
						id="firstName" name="first_name" required>
				</div>
				<div class="col">
					<label for="last_name">Last Name:</label> <input type="text"
						id="lastName" name="last_name" required>
				</div>
			</div>
			<div class="row">
				<div class="col">
					<label for="username">Username:</label> <input type="text"
						id="username" name="username" required>
				</div>
				<div class="col">
					<label for="dob">Date of Birth:</label> <input type="date"
						id="dob" name="dob" required>
				</div>
			</div>
			<div class="row">
				<div class="col">
					<label for="gender">Gender:</label> <select id="gender"
						name="gender" required>
						<option value="male">Male</option>
						<option value="female">Female</option>
					</select>
				</div>
				<div class="col">
					<label for="email">Email:</label> <input type="email" id="email"
						name="email" required>
				</div>
			</div>
			<div class="row">
				<div class="col">
					<label for="number">Phone Number:</label> <input type="tel"
						id="number" name="number" required>
				</div>
				<div class="col">
					<label for="program">Subject:</label> <select id="program"
						name="program" required>
						<option value="1">Computing</option>
						<option value="2">Multimedia</option>
						<option value="3">Networking</option>
					</select>
				</div>
			</div>
			<div class="row">
				<div class="col">
					<label for="password">Password:</label> <input type="password"
						id="password" name="password" required>
				</div>
				<div class="col">
					<label for="retypePassword">Retype Password:</label> <input
						type="password" id="retypePassword" name="retypePassword" required>
				</div>
		
			</div>
			<button type="submit">Submit</button>
		</form>
	</div>
</body>
</html>
