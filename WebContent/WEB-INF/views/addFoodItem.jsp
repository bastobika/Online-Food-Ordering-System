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
<title>Add Food Item</title>
</head>
<style>
	.error{color : red}
</style>
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
		        <a class="nav-link" href="${pageContext.request.contextPath}/caterer/catererDetails">Profile</a>
		      </li>
		      <li class="nav-item">
		      	<a class="nav-link" href="${pageContext.request.contextPath}/common/logout"> Logout </a>
		      </li>
		    </ul>
	   </nav>
		<br>
		<c:if test="${additionStatus eq 'failure' }" >
			Addition of Food Item failed. Please try Again.
		</c:if>
		<br>
		  <p class="h4"> Enter Details :</p>
		  <br>
			<form:form action="addFoodItem" method="POST" modelAttribute="foodItem">
			  <div class="form-group">
			    <label for="name">Item Name</label>
			      <form:input path="name" class="form-control" />
			       <form:errors path="name" class="error" />
			  </div>
			 <div class="form-group">
			    <label for="quantity">Quantity</label>
			      <form:input path="quantity" class="form-control" aria-describedby="quantityHelp" />
			       <small id="quantityHelp" class="form-text text-muted">Mention the unit also, for e.g., 4 pieces or 200gm</small>
			        <form:errors path="quantity" class="error" />
			  </div>
			  <div class="form-group">
			    <label for="price">Price (in Rupees)</label>
			      <form:input path="price" class="form-control" />
			       <form:errors path="price" class="error" />
			  </div>
			    <div class="form-group">
				    <label for="foodType">Food Type</label>
					    <form:select class="form-control" path="foodType" aria-describedby="foodTypeHelp">
					    	<form:option value="Neutral"> Neutral </form:option>
						     <form:option value="Veg"> Veg </form:option>
							 <form:option value="NonVeg"> Non-Veg </form:option>
					    </form:select>
					  <small id="foodTypeHelp" class="form-text text-muted">Veg/NonVeg/Neutral</small>
	  		</div>
			  <button type="submit" class="btn btn-primary">Add Food Item</button>
			</form:form>
	</div>
</body>
</html>