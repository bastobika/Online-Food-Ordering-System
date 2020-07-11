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
<title>All Food Items</title>
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
		        <a class="nav-link active" href="${pageContext.request.contextPath}/caterer/viewFoodItems">Food Items</a>
		      </li>
		      <li class="nav-item">
		        <a class="nav-link" href="${pageContext.request.contextPath}/caterer/catererDetails">Profile</a>
		      </li>
		      <li>
		      	<a class="nav-link" href="${pageContext.request.contextPath}/common/logout"> Logout </a>
		      </li>
		    </ul>
	   </nav>
	   <br>
		<c:if test="${updateStatus eq 'success' }" >
			<p class="h4">Updated Successfully ! </p>
		</c:if>
		<c:if test="${deleteStatus eq 'success' }" >
			<p class="h4">Deleted Successfully ! </p>
		</c:if>
		<c:choose>
		<c:when test="${ noFoodItems == true }" >
			<p class="h4">You have no Food Items added ! Add Some ! </p>
			<a href="addFood" class="btn btn-primary"> Add Food Item </a>
		</c:when>
		<c:when test="${ noFoodItems == false }">
			<a href="addFood" class="btn btn-primary"> Add Food Item </a>
			<br>
			<br>
			<table  class="table">
				<thead class="thead-dark">
					<tr>
						<th scope="col"> Name </th>
						<th scope="col"> Quantity </th>
						<th scope="col"> Price(in Rupees) </th>
						<th scope="col"> Food Type </th>
						<th scope="col"> Rating </th>
						<th scope="col"> Action </th>
					</tr>
				</thead>
				<tbody>
				<c:forEach var="foodItem" items="${foodItems }">
					<tr>
						<td> ${foodItem.name } </td>
						<td> ${foodItem.quantity } </td>
						<td> ${foodItem.price } </td>
						<td> ${foodItem.foodType } </td>
						<td> ${foodItem.rating } </td>
						<td> 
						<form action="updateFood" method="POST" >
								<input type="hidden" name="foodItemID" value="${foodItem.ID }" />
								 <button type="submit" class="btn btn-primary">Update Food Item</button>
						</form> 
						<form action="deleteFood" method="POST" >
								<input type="hidden" name="foodItemID" value="${foodItem.ID }" />
								<button type="submit" class="btn btn-primary">Delete Food Item</button>
						</form> 
						</td>
					</tr>
				</c:forEach>
			</table>
		</c:when>	
	</c:choose>
	</div>
</body>
</html>