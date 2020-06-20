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
<title>Caterers</title>
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
	        <a class="nav-link active" href="viewCaterers">View Caterers</a>
	      </li>
	      <li class="nav-item">
	        <a class="nav-link" href="viewCustomers">View Customers</a>
	      </li>
	      <li class="nav-item">
	        <a class="nav-link" href="viewOrders">View Orders</a>
	      </li>
	    </ul>
	</nav>
	<br>
	<c:choose>
		<c:when test="${noCaterers eq true }" >
			<p class="h2">No Caterers !</p>
		</c:when>
		<c:otherwise>
			<table class="table">
				<thead class="thead-dark">
					<tr>
						<th scope="col"> Caterer ID </th>
						<th scope="col"> Caterer Name </th>
						<th scope="col"> Caterer Email </th>
						<th scope="col"> Caterer Phone </th>
						<th scope="col"> Caterer Rating </th>
						<th scope="col"> Caterer Status </th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="caterer" items="${caterers }">
						<tr>
							<td> ${caterer.ID } </td>
							<td> ${caterer.name } </td>
							<td> ${caterer.email } </td>
							<td> ${caterer.phone } </td>
							<td> ${caterer.rating } </td>
							<td> ${caterer.status } </td>
	 					</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:otherwise>
	</c:choose>
</div>
</body>
</html>