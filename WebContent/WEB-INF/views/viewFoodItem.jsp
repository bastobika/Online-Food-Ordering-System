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
<title>All Food Items</title>
</head>
<body>
		<c:if test="${updateStatus eq 'success' }" >
			Updated Successfully !
		</c:if>
		<c:if test="${deleteStatus eq 'success' }" >
			Deleted Successfully !
		</c:if>
		<c:choose>
		<c:when test="${ noFoodItems == false }">
			<table>
				<tr>
					<th> Name </th>
					<th> Quantity </th>
					<th> Price(in Rupees) </th>
					<th> Rating </th>
				</tr>
				
				<c:forEach var="foodItem" items="${foodItems }">
					<tr>
						<td> ${foodItem.name } </td>
						<td> ${foodItem.quantity } </td>
						<td> ${foodItem.price } </td>
						<td> ${foodItem.rating } </td>
						<td> 
						<form action="updateFood" method="POST" >
								<input type="hidden" name="foodItemID" value="${foodItem.ID }" />
								 <input type="submit" value="Update Food Item" />
						</form> 
						<form action="deleteFood" method="POST" >
								<input type="hidden" name="foodItemID" value="${foodItem.ID }" />
								 <input type="submit" value="Delete Food Item" />
						</form> 
						</td>
					</tr>
				</c:forEach>
			</table>
		</c:when>
		<c:when test="${ noFoodItems == true }" >
			You have no Food Items added ! Add Some !
		</c:when>	
	</c:choose>
	<a href="addFood"> Add Food Items</a>
</body>
</html>