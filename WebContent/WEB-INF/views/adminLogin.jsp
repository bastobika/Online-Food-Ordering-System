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
<title>Admin Login </title>
</head>
<body>
<br>
<div class="container">
	<nav class="navbar navbar-expand-lg navbar-light sticky-top" style="background-color: #e3f2fd;">
	
	    <ul class="navbar-nav mr-auto">
	      <li class="nav-item">
	        <a class="nav-link" href="../common/welcome">Login</a>
	      </li>
	      <li class="nav-item">
	        <a class="nav-link" href="../common/signUpOptions">Sign Up</a>
	      </li>
	      <li class="nav-item">
	        <a class="nav-link active" href="../admin/login">Admin Login</a>
	      </li>
	    </ul>
	</nav>

	<br>
	<p class="h2"> Admin Login ! </p>
	<br>
	<form:form action="authenticate"  method="POST"  modelAttribute="admin" >
			  <div class="form-group">
				    <label for="name">Name : </label>
				    <form:input path="name"  class="form-control" aria-describedby="emailHelp"  />
			  </div>
			  <div class="form-group">
				    <label for="password">Password :</label>
				    <form:password path="password" class="form-control" />
				    <small id="emailHelp" class="form-text text-muted">We'll never share your password with anyone else.</small>
			  </div>
			  <button type="submit" class="btn btn-primary">Login</button>
		</form:form>

	 	<c:if test="${loginFlag == 'false' }" >
	 			<p> Incorrect Name Or Password ! Try again ! </p>
	 	</c:if>
</div>
</body></html>