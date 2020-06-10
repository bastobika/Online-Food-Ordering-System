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
		<c:choose>
		<c:when test="${ noCartItems == false }">
			<table>
				<tr>
					<th> Name </th>
					<th> Quantity </th>
					<th> Price(in Rupees) </th>
					<th> Rating </th>
					<th> Units </th>
				</tr>
				
				<c:forEach var="cartItem" items="${cartItems }">
					<tr>
						<td> ${cartItem.foodItem.name } </td>
						<td> ${cartItem.foodItem.quantity } </td>
						<td> ${cartItem.foodItem.price } </td>
						<td> ${cartItem.foodItem.rating } </td>
						<td> ${ cartItem.units} </td>
					</tr>
				</c:forEach>
			</table>
			<form action="placeOrder" method="POST" > <input type="submit" value="Place Order" /> </form>
		</c:when>
		<c:otherwise>
			Your Cart Is Empty :(
			<a href="orderFood"> Order Food </a>
		</c:otherwise>	
	</c:choose>
</body>
</html>