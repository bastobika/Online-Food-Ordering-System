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
<title>Your Cart</title>
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
		        <a class="nav-link active" href="${pageContext.request.contextPath}/customer/viewCart">Cart</a>
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
		<c:if test="${placedOrder.equalsIgnoreCase('notPlaced') }">
			<p class="h4">Please order from one caterer at one time. Remove the additional items from the cart and proceed to order.</p>
		</c:if>
		<br>
		<c:choose>
		<c:when test="${ noCartItems == false }">
			<table class="table">
				<thead class="thead-dark">
					<tr>
						<th scope="row"> Caterer Name </th>
						<th scope="row"> Caterer Rating </th>
						<th scope="row"> Food Item Name </th>
						<th scope="row"> Quantity </th>
						<th scope="row"> Price(in Rupees) </th>
						<th scope="row"> Food Item Rating </th>
						<th scope="row"> Units </th>
						<th scope="row"> Delete Food Item </th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="cartItem" items="${cartItems }">
						<tr>
							<td> ${cartItem.foodItem.caterer.name } </td>
							<td> ${cartItem.foodItem.caterer.rating } </td>
							<td> ${cartItem.foodItem.name } </td>
							<td> ${cartItem.foodItem.quantity } </td>
							<td> ${cartItem.foodItem.price } </td>
							<td> ${cartItem.foodItem.rating } </td>
							<td> ${ cartItem.units} </td>
							<td> <form action="deleteCartItem" method="POST" > 
										<input type="hidden" name="CartItemID" value="${cartItem.ID }" />
										<input type="submit" class="btn btn-primary" value="Delete Cart Item" /> </form>  
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<p class="h4"> Order Total :  <c:out value="${orderTotal }"></c:out> </p>
			<a href="orderFood" class="btn btn-primary"> Add Some More ! </a>
			<br><br>
			<form action="placeOrder" method="POST" > <input type="submit" value="Place Order" class="btn btn-primary" /> </form>
		</c:when>
		<c:otherwise>
			<p class="h4">Your Cart Is Empty :(</p>
			<a href="orderFood"  class="btn btn-primary"> Order Food </a>
		</c:otherwise>	
	</c:choose>
</div>
</body>
</html>