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
<title>Leave Your Rating</title>
</head>
<body>
	<br>
	<div class="container">
	
		<nav class="navbar navbar-expand-lg navbar-light sticky-top" style="background-color: #e3f2fd;">
		    <ul class="navbar-nav mr-auto">
		      <li class="nav-item">
		        <a class="nav-link" href="${pageContext.request.contextPath}/customer/orderFood">Order Food</a>
		      </li>
		      <li class="nav-item">
		        <a class="nav-link" href="${pageContext.request.contextPath}/customer/viewCart">Cart</a>
		      </li>
		      <li class="nav-item">
		        <a class="nav-link" href="${pageContext.request.contextPath}/customer/viewOrders">Orders</a>
		      </li>
		      <li class="nav-item">
		        <a class="nav-link" href="${pageContext.request.contextPath}/customer/customerDetails">Profile</a>
		      </li>
		      <li class="nav-item">
		      	<a class="nav-link" href="${pageContext.request.contextPath}/common/logout"> Logout </a>
		      </li>
		    </ul>
	   </nav>
	   <br>
		<form action="submitRating" method="POST">
			<input type="hidden" name="orderID" value="${order.ID }" />
			<c:forEach var="orderedItem" items="${order.orderedItems }" >
				<input type="hidden" name="foodItemID" value="${orderedItem.foodItem.ID }" />
				<div class="form-group">
					<label for="foodItem">Food Item :</label>
					<input type="text"  name="foodItem"  value="${orderedItem.foodItem.name }" class="form-control" readonly="true"/>
				</div>
				<div class="form-group">
					<label for="foodItemRating">Your Rating for this Item (out of 5) :</label>
					<input type="text"  name="foodItemRating" class="form-control"/>
				</div>
				<c:set var="catererName" scope="session" value="${orderedItem.foodItem.caterer.name}" />
			</c:forEach>
				<div class="form-group">
					<label for="caterer">Caterer :</label>
					<input type="text"  name="caterer" class="form-control" value="${catererName }" readonly="true" />
				</div>
				<div class="form-group">
					<label for="catererRating">Your Rating for the Caterer (out of 5) :</label>
					<input type="text"  name="catererRating" class="form-control"/>
				</div>
				<input type="submit" class="btn btn-primary" value="Give Rating" />
			</form>
</div>
</body>
</html>