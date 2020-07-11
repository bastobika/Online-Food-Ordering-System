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
<title>Update Food Item</title>
</head>
<body>
	<br>
	<div class="container">
	
		<nav class="navbar navbar-expand-lg navbar-light sticky-top" style="background-color: #e3f2fd;">
		    <ul class="navbar-nav mr-auto">
		      <li class="nav-item">
		        <a class="nav-link" href="${pageContext.request.contextPath}/caterer/viewOrders">Orders</a>
		      </li>
		      <li class="nav-item">
		        <a class="nav-link" href="${pageContext.request.contextPath}/caterer/viewFoodItems">Food Items</a>
		      </li>
		      <li class="nav-item">
		        <a class="nav-link" href="${pageContext.request.contextPath}/caterer/catererDetails">Profile</a>
		      </li>
		      <li class="nav-item">
		      	<a class="nav-link" href="logout"> Logout </a>
		      </li>
		    </ul>
	   </nav>
	   <br>
		<p class="h4">Update Details -</p>
		<br>
		<form:form action="updateFoodItem" method="POST" modelAttribute="foodItem">
			<form:hidden path="ID"/>    <!-- Adds the original food ID to the update request. Else you lose track of the original food item -->
			<form:hidden path="rating"/>     <!-- Adds the original rating to the update request. Else you lose track of the original rating -->
			 <div class="form-group">
			 	 <label for="name">Item Name :</label>    
				 <form:input path="name" class="form-control"/>
			</div>
			 <div class="form-group">
			 	 <label for="name">Quantity :</label>    
				 <form:input path="quantity" class="form-control"/>
			</div>
			 <div class="form-group">
			 	 <label for="name">Price (in Rupees) :</label>    
				 <form:input path="price" class="form-control"/>
			</div>
			 <div class="form-group">
			 	 <label for="foodType">Food Type :</label>    
				<form:select class="form-control" path="foodType" aria-describedby="foodTypeHelp">
					     <form:option value="Veg"> Veg </form:option>
						 <form:option value="NonVeg"> Non-Veg </form:option>
						 <form:option value="Netural"> Netural </form:option>
				</form:select>
					  <small id="foodTypeHelp" class="form-text text-muted">Veg/NonVeg/Neutral</small>
			</div>
			<input type="submit" class="btn btn-primary" value="Update Food Item" />
		</form:form>
</div>
</body>
</html>