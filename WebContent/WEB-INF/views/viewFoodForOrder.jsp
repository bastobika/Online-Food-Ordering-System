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
<title>Food Available For You </title>
</head>
<body>
	<br>
	<div class="container">
	
		<nav class="navbar navbar-expand-lg navbar-light sticky-top" style="background-color: #e3f2fd;">
		    <ul class="navbar-nav mr-auto">
		      <li class="nav-item">
		        <a class="nav-link active" href="${pageContext.request.contextPath}/customer/orderFood">Order Food</a>
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
		<c:choose>
		<c:when test="${ noFoodItems == false }">
			<table class="table">
				<thead class="thead-dark">
					<tr>
						<th scope="row">Caterer Name</th>
						<th scope="row"> Caterer Rating </th>
						<th scope="row"> Food Item </th>
						<th scope="row"> Quantity </th>
						<th scope="row"> Price </th>
						<th scope="row"> Food Item Rating </th>
						<th scope="row"> Add To Cart </th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="foodItem" items="${foodItems }">
						<tr>
							<td> ${foodItem[0].name } </td>
							<td> ${foodItem[0].rating } </td>
							<td> ${foodItem[1].name } </td>
							<td> ${foodItem[1].quantity } </td>
							<td> ${foodItem[1].price } </td>
							<td> ${foodItem[1].rating } </td>
							<td> 
									<form action="addToCart" method="POST" class="form-inline">
										<input type="hidden" name="foodID" value="${foodItem[1].ID }" />
										<div class="form-group">
											<label for="units" class="sr-only">Add Units</label>
											 <input type="text" class="form-control mb-2 mr-sm-2" name="units" />
										</div>
										<br>
										 <button type="submit" class="btn btn-primary  btn-sm">Add To Cart </button>
									</form>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:when>
		<c:when test="${ noFoodItems == true }" >
			No Food Items Available :( 
		</c:when>	
	</c:choose>
	<a href="viewCart" class="btn btn-primary"> View Cart</a>
</div>
</body>
</html>