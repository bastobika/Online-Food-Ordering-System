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
<title>Customer Sign Up</title>
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
	        <a class="nav-link  active" href="signUpOptions">Sign Up</a>
	      </li>
	      <li class="nav-item">
	        <a class="nav-link" href="../admin/login">Admin Login</a>
	      </li>
	    </ul>
	</nav>
	
	<br>
	  <p class="h4"> Pleas fill in your details -</p>
		<form:form action="../customer/signUp" method="POST" modelAttribute="customer">
		  <div class="form-group">
		    <label for="name">Name : </label>
		      <form:input path="name" class="form-control" />
		  </div>
		 <div class="form-group">
		    <label for="email">Email :</label>
		      <form:input path="email" class="form-control" />
		  </div>
		  <div class="form-group">
		    <label for="phone">Phone Number :</label>
		      <form:input path="phone" class="form-control" />
		  </div>
		  <div class="form-group">
		    <label for="password">Password :</label>
		      <form:password path="password" class="form-control" />
		  </div>
		    <div class="form-group">
			    <label for="preference">Do you prefer Veg/Non-Veg/Both ? :</label>
				    <form:select class="form-control" path="preference" aria-describedby="preferenceHelp">
				     <form:option value="Veg"> Veg </form:option>
					 <form:option value="NonVeg"> Non-Veg </form:option>
					 <form:option value="Both"> Both </form:option>
				    </form:select>
				  <small id="preferenceHelp" class="form-text text-muted">You will be shown food items based on the preference you provide.</small>
  		</div>
		  <button type="submit" class="btn btn-primary">Sign up</button>
		</form:form>
		
		<c:if test="${ status eq 'duplicateEntry' }" >
			<p class="h4">Email or Phone Number already exists ! Please try with a different email or phone. Login if you already have an account. </p>
		</c:if>
	</div>

</body>
</html>