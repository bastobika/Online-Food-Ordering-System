<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" 
	integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous" >

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sign Up</title>
</head>
<body>
<br>
<div class="container">
	<nav class="navbar navbar-expand-lg navbar-light sticky-top" style="background-color: #e3f2fd;">

	    <ul class="navbar-nav mr-auto">
	      <li class="nav-item">
	        <a class="nav-link" href="welcome">Login</a>
	      </li>
	      <li class="nav-item">
	        <a class="nav-link active" href="signUpOptions">Sign Up</a>
	      </li>
	      <li class="nav-item">
	        <a class="nav-link" href="../admin/login">Admin Login</a>
	      </li>
	    </ul>

	</nav>

	<br>
	
		<p class="h2">Are you a </p>
		<form action="signUp"  method="POST"  >
			  <div class="form-check">
				  <input class="form-check-input" type="radio" name="userType" id="userType" value="Caterer">
				  <label class="form-check-label h5" for="userType">
				    Caterer
				  </label>
			</div>
			<div class="form-check">
				  <input class="form-check-input" type="radio" name="userType" id="userType" value="Customer">
				  <label class="form-check-label h5" for="userType">
				    Customer
				  </label>
			</div>
			<br>
			  <button type="submit" class="btn btn-primary">Continue</button>
		</form>
</div>

</body>
</html>