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
<title>Your Orders</title>
</head>
<body>
			<c:if test="${placedOrder.equalsIgnoreCase('placed') }">
				Order placed successfully !
			</c:if>
		<c:choose>
				<c:when test="${ noOrders == false }">
				<table>
				<tr>
					<th> Caterer Name </th>
					<th> Food Name </th>
					<th> Quantity </th>
					<th> Price(in Rupees) </th>
					<th> Units </th>
					<th> Status </th>
				</tr>
				
	<!-- 		<c:forEach var="order" items="${orders }">
					<tr>
						<td> ${order.caterer.name } </td>
						<td> ${order.foodItem.name } </td>
						<td> ${order.foodItem.quantity } </td>
						<td> ${order.foodItem.price } </td>
						<td> ${ order.units} </td>
						<td> ${ order.status} </td>
					</tr>
				</c:forEach> -->	
			</table>
			</c:when>
			<c:when test="${ noOrders == true }" >
				You have no Orders
				<a href="orderFood"> Order Food !</a>
			</c:when>	
		</c:choose>
</body>
</html>