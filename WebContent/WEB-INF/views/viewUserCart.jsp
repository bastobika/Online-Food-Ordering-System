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
		<c:if test="${placedOrder.equalsIgnoreCase('notPlaced') }">
			Please order from one caterer at one time. Remove the additional items from the cart and proceed to order.
		</c:if>
		<c:choose>
		<c:when test="${ noCartItems == false }">
			<table>
				<tr>
					<th> Caterer Name </th>
					<th> Caterer Rating </th>
					<th> Food Item Name </th>
					<th> Quantity </th>
					<th> Price(in Rupees) </th>
					<th> Food Item Rating </th>
					<th> Units </th>
				</tr>
				
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
									<input type="submit" value="Delete Cart Item" /> </form>  
						</td>
					</tr>
				</c:forEach>
			</table>
			<p> Order Total : </p> <c:out value="${orderTotal }"></c:out>
			<a href="orderFood"> Add Some More ! </a>
			<form action="placeOrder" method="POST" > <input type="submit" value="Place Order" /> </form>
		</c:when>
		<c:otherwise>
			Your Cart Is Empty :(
			<a href="orderFood"> Order Food </a>
		</c:otherwise>	
	</c:choose>
</body>
</html>