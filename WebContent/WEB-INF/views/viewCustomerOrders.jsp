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
	<br>
	<div class="container">
	
		<nav class="navbar navbar-expand-lg navbar-light sticky-top" style="background-color: #e3f2fd;">
		    <ul class="navbar-nav mr-auto">
		      <li class="nav-item">
		        <a class="nav-link" href="${pageContext.request.contextPath}/customer/orderFood">Order Food</a>
		      </li>
		      <li class="nav-item">
		        <a class="nav-link" href="${pageContext.request.contextPath}/customer/viewCart">Cart</a>
		      </li>
		      <li class="nav-item">
		        <a class="nav-link active" href="${pageContext.request.contextPath}/customer/viewOrders">Orders</a>
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
			<c:if test="${placedOrder.equalsIgnoreCase('placed') }">
				<p class="h4">Order placed successfully !</p>
			</c:if>
			<br>
		<c:choose>
				<c:when test="${ noOrders == false }">
						<c:forEach var="order" items="${orders }">
							<ul>
								<li>
									<p class="h5"> Order ID : ${order.ID } 
									Caterer Name : ${order.orderedItems[0].foodItem.caterer.name }
									Order Total : ${order.orderTotal }
									Order Status : ${order.status } 
									<c:if test="${order.status eq 'Completed'  and order.ratingStatus eq 'Not Rated' }" >
											<form:form action="rateOrder" method="POST">
												<input type="hidden" name="orderID" value="${order.ID }" />
												<input type="submit" class="btn btn-primary  btn-sm" value="Rate Order" /> 
											</form:form>
									</c:if> </p>
										<div class="container">
										<table  class="table-sm">
											<thead class="thead-dark">
												<tr>
													<th scope="row"> Food Name </th>
													<th scope="row"> Quantity </th>
													<th scope="row"> Price(in Rupees) </th>
													<th scope="row"> Units </th>
												</tr>
											</thead>
											<tbody>
												<c:forEach var="orderedItem" items="${order.orderedItems }" >
													<tr>
																<td> ${orderedItem.foodItem.name } </td>
																<td> ${orderedItem.foodItem.quantity } </td>
																<td> ${orderedItem.foodItem.price } </td>
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
				<p class="h4">You have no Orders.</p>
				<a href="orderFood" class="btn btn-primary "> Order Food !</a>
			</c:when>	
		</c:choose>
	</div>
</body>
</html>