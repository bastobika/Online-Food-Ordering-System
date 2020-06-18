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
			<c:if test="${orderUpdated.equalsIgnoreCase('updated') }">
				Order status updated successfully !
			</c:if>
		<c:choose>
				<c:when test="${ noOrders == false }">
						<c:forEach var="order" items="${orders }">
							<ul>
								<li>
									Order ID : ${order.ID } 
									Order Total : ${order.orderTotal }
									Order Status : ${order.status } 
									<form:form action="updateStatus" method="POST"> 
										<input type="hidden" name="orderID" value="${order.ID }" />
										 <input type="submit" value="Update Status To Complete" /> 
									</form:form>
										<table>
										<tr>
											<th> Food Name </th>
											<th> Quantity </th>
											<th> Units </th>
										</tr>
										<c:forEach var="orderedItem" items="${order.orderedItems }" >
											<tr>
														<td> ${orderedItem.foodItem.name } </td>
														<td> ${orderedItem.foodItem.quantity } </td>
														<td> ${orderedItem.units } </td>
											</tr>
										</c:forEach>
										</table>
								</li>
							</ul>
						</c:forEach>
			</c:when>
			<c:when test="${ noOrders == true }" >
				You have no Orders.
				<a href="orderFood"> Order Food !</a>
			</c:when>	
		</c:choose>
</body>
</html>