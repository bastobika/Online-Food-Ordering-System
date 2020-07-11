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
<title>Customers</title>
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
	        <a class="nav-link active" href="viewCustomers">View Customers</a>
	      </li>
	      <li class="nav-item">
	        <a class="nav-link" href="viewOrders">View Orders</a>
	      </li>
	       <li class="nav-item">
	        <a class="nav-link active" href="${pageContext.request.contextPath}/common/logout">Logout</a>
	      </li>
	    </ul>
	</nav>
	<br>
	<c:choose>
		<c:when test="${noCustomers eq true }" >
			<p class="h2">No Customers !</p>
		</c:when>
		<c:otherwise>
			<table class="table">
				<thead class="thead-dark">
					<tr>
						<th scope="col"> Customer ID </th>
						<th scope="col"> Customer Name </th>
						<th scope="col"> Customer Email </th>
						<th scope="col"> Customer Phone </th>
						<th scope="col"> Customer Preference </th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="customer" items="${customers }">
						<tr>
							<td> ${customer.ID } </td>
							<td> ${customer.name } </td>
							<td> ${customer.email } </td>
							<td> ${customer.phone } </td>
							<td> ${customer.preference } </td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:otherwise>
	</c:choose>
</div>
</body>
</html>