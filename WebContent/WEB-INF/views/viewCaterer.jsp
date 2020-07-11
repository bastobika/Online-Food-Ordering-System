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
<title>Caterer Information </title>
</head>
<body>
	<div class="container">
	<br>
		<nav class="navbar navbar-expand-lg navbar-light sticky-top" style="background-color: #e3f2fd;">
		    <ul class="navbar-nav mr-auto">
		      <li class="nav-item">
		        <a class="nav-link" href="${pageContext.request.contextPath}/caterer/viewOrders">Orders</a>
		      </li>
		      <li class="nav-item">
		        <a class="nav-link" href="${pageContext.request.contextPath}/caterer/viewFoodItems">Food Items</a>
		      </li>
		      <li class="nav-item">
		        <a class="nav-link active" href="${pageContext.request.contextPath}/caterer/catererDetails">Profile</a>
		      </li>
		      <li class="nav-item">
		      	<a class="nav-link" href="${pageContext.request.contextPath}/common/logout"> Logout </a>
		      </li>
		    </ul>
	   </nav>
		<br>
		<p class="h4">Your Details -</p>
		<br>
		<form:form action="updateCatererInfo" method="POST" modelAttribute="caterer">
			<form:hidden path="ID"/>     <!-- Adds the original caterer ID to the update request. Else you lose track of the original caterer -->
			<form:hidden path="status"/>    
			 <div class="form-group">
			 	 <label for="name">Name :</label>    
				 <form:input path="name" class="form-control"/>
			</div>
			<div class="form-group">
			 	 <label for="email">Email :</label>    
				 <form:input path="email" readonly="true" class="form-control" />
			</div>
			<div class="form-group">
			 	 <label for="phone">Phone Number :</label>    
				 <form:input path="phone" readonly="true" class="form-control"/>
			</div>
			<div class="form-group">
			 	 <label for="password">Password :</label>    
				 <form:password path="password" showPassword="true" class="form-control"/>
			</div>
			<div class="form-group">
			 	 <label for="rating">Rating :</label>    
				 <form:input path="rating" readonly="true" class="form-control"/>
			</div>
			<button type="submit" class="btn btn-primary">Update Information</button>
		</form:form>
		<c:if test="${updateStatus.equalsIgnoreCase('success') }">
			<p class="h5">Information Updated Successfully !</p><br>
		</c:if>
		<a href="deleteCaterer" class="btn btn-primary"> Delete Your Account </a>
	</div>
</body>
</html>