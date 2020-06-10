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
		<c:if test="${addToCartFlag.equalsIgnoreCase( 'added')}" >
			Item added to cart successfully !
			<a href="viewCart"> View Cart</a>
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
				<!-- 		<form action="updateStatus" method="GET" >
								<input type="hidden" name="catererID" value="${caterer.ID }" />
								 <select name="status" > 
										<option value="Approved"> Approve </option>
										<option value="Denied"> Deny </option>
								 </select>
								 <input type="submit" value="Change Status" />
							</form>  -->
						</td>
					</tr>
				</c:forEach>
			</table>
		</c:when>
		<c:when test="${ noFoodItems == true }" >
			You have no Food Items added ! Add Some !
			<a href="addFoodItem"> Add Food Items</a>
		</c:when>	
	</c:choose>
</body>
</html>