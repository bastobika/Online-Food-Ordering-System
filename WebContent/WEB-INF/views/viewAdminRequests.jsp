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
<title>Admin Requests</title>
</head>
<body>
<br>
<div class="container">
	<nav class="navbar navbar-expand-lg navbar-light sticky-top" style="background-color: #e3f2fd;">
	
	    <ul class="navbar-nav mr-auto">
	      <li class="nav-item">
	        <a class="nav-link active" href="requests">Requests</a>
	      </li>
	      <li class="nav-item">
	        <a class="nav-link" href="viewCaterers">View Caterers</a>
	      </li>
	      <li class="nav-item">
	        <a class="nav-link" href="viewCustomers">View Customers</a>
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
		<c:when test="${ noRequests == false }">
			<table class="table">
				<thead class="thead-dark">
					<tr>
						<th scope="col"> Name </th>
						<th scope="col"> Email </th>
						<th scope="col"> Phone </th>
						<th scope="col"> Change Status </th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="caterer" items="${catererRequests }">				
						<tr>
							<td> ${caterer.name } </td>
							<td> ${caterer.email } </td>
							<td> ${caterer.phone } </td>
							<td> 
								<form:form action="updateStatus"  method="GET"  >
								      <input type="hidden" name="catererID" value="${caterer.ID }" />
									  <div class="form-group">
										    <select class="form-control" name="status">
										      <option value="Approved">Approve</option>
										      <option value="Denied">Deny</option>
										    </select>
									 </div>
									  <button type="submit" class="btn btn-primary">Change Status</button>
							  </form:form>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:when>
		<c:when test="${ noRequests == true }" >
			<p class="h2">You have no new Requests !</p>
		</c:when>	
	</c:choose>
	
</div>
</body>
</html>