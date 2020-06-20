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
<title>Orders</title>
</head>
<body>
<br>
<div class="container">
	<nav class="navbar navbar-expand-lg navbar-light sticky-top" style="background-color: #e3f2fd;">
	
	    <ul class="navbar-nav mr-auto">
	      <li class="nav-item">
	        <a class="nav-link" href="requests">Requests</a>
	      </li>
	      <li class="nav-item">
	        <a class="nav-link" href="viewCaterers">View Caterers</a>
	      </li>
	      <li class="nav-item">
	        <a class="nav-link" href="viewCustomers">View Customers</a>
	      </li>
	      <li class="nav-item">
	        <a class="nav-link active" href="viewOrders">View Orders</a>
	      </li>
	    </ul>
	</nav>
	<br>
	<c:choose>
		<c:when test="${noOrders eq true }" >
			<p class="h2">No Orders !</p>
		</c:when>
		<c:otherwise>
			<table  class="table">
				<thead class="thead-dark">
					<tr>
						<th scope="col"> Order ID </th>
						<th scope="col"> Caterer ID </th>
						<th scope="col"> Customer ID </th>
						<th scope="col"> Order Total </th>
						<th scope="col"> Order Status </th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="order" items="${orders }">
						<tr>
							<td> ${order.ID } </td>
							<td> ${order.caterer.ID } </td>
							<td> ${order.customer.ID } </td>
							<td> ${order.orderTotal } </td>
							<td> ${order.status } </td>
	 					</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:otherwise>
	</c:choose>
</div>
</body>
</html>