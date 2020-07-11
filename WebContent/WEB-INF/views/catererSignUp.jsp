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
<title>Caterer Sign Up</title>
</head>
<style>
	.error{color : red}
</style>
<body>
	<br>
	<div class="container">
	
		<nav class="navbar navbar-expand-lg navbar-light sticky-top" style="background-color: #e3f2fd;">
	
	    <ul class="navbar-nav mr-auto">
	      <li class="nav-item">
	        <a class="nav-link" href="${pageContext.request.contextPath}/common/welcome">Login</a>
	      </li>
	      <li class="nav-item">
	        <a class="nav-link  active" href="${pageContext.request.contextPath}/common/signUpOptions">Sign Up</a>
	      </li>
	      <li class="nav-item">
	        <a class="nav-link" href="${pageContext.request.contextPath}/admin/login">Admin Login</a>
	      </li>
	    </ul>
	</nav>
	
	<br>
	  <p class="h4"> Pleas fill in your details -</p>
		<form:form action="../caterer/signUp" method="POST" modelAttribute="caterer">
		  <div class="form-group">
		    <label for="name">Name :</label>
		      <form:input path="name" class="form-control" />
		      <form:errors path="name" class="error" />
		  </div>
		 <div class="form-group">
		    <label for="email">Email :</label>
		      <form:input path="email" class="form-control" />
		       <form:errors path="email" class="error" />
		  </div>
		  <div class="form-group">
		    <label for="phone">Phone Number :</label>
		      <form:input path="phone" class="form-control" />
		       <form:errors path="phone" class="error" />
		  </div>
		  <div class="form-group">
		    <label for="password">Password :</label>
		      <form:password path="password" class="form-control" />
		       <form:errors path="password" class="error" />
		  </div>
		  <button type="submit" class="btn btn-primary">Sign up</button>
		</form:form>
		
		<c:if test="${ status == 'duplicateEntry' }" >
			<p class="h4">Email or Phone Number already exists ! Please try with a different email or phone. Login if you already have an account.</p>
		</c:if>
	</div>
</body>
</html>