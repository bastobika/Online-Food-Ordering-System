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
		        <a class="nav-link active" href="${pageContext.request.contextPath}/caterer/viewOrders">Orders</a>
		      </li>
		      <li class="nav-item">
		        <a class="nav-link" href="${pageContext.request.contextPath}/caterer/viewFoodItems">Food Items</a>
		      </li>
		      <li class="nav-item">
		        <a class="nav-link" href="${pageContext.request.contextPath}/caterer/catererDetails">Profile</a>
		      </li>
		      <li class="nav-item">
		      	<a class="nav-link" href="${pageContext.request.contextPath}/common/logout"> Logout </a>
		      </li>
		    </ul>
	   </nav>
	   <br>
	<c:if test="${orderUpdated.equalsIgnoreCase('updated') }">
			<p class="h4">Order status updated successfully ! </p>
	</c:if>	
	<br>
	<c:choose>
			<c:when test="${ noOrders == false }">
					<c:forEach var="order" items="${orders }">
						<ul>
							<li>
								<p class="h5"> Order ID : ${order.ID } 
								Order Total : ${order.orderTotal }
								Order Status : ${order.status }  
								<c:if test="${order.status eq 'Placed' }" >
									<form:form action="updateStatus" method="POST"> 
										<input type="hidden" name="orderID" value="${order.ID }" />
										  <button type="submit" class="btn btn-primary  btn-sm">Update Status To Complete </button>
									</form:form> 
								</c:if></p>
								<div class="container">
									<table  class="table-sm">
										<thead class="thead-dark">
											<tr>
												<th scope="col"> Food Name </th>
												<th scope="col"> Quantity </th>
												<th scope="col"> Units </th>
											</tr>
										</thead>
										<tbody>
											<c:forEach var="orderedItem" items="${order.orderedItems }" >
												<tr>
															<td> ${orderedItem.foodItem.name } </td>
															<td> ${orderedItem.foodItem.quantity } </td>
															<td> ${orderedItem.units } </td>
												</tr>
											</c:forEach>
										</tbody>
									</table>
								</div>
							</li>
						</ul>
					</c:forEach>
		</c:when>
		<c:when test="${ noOrders == true }" >
			<p class="h4">You have no Orders yet ! </p>
		</c:when>	
	</c:choose>
</div>
</body>
</html>