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
<title>Food Available For You </title>
</head>
<body>
		<c:choose>
		<c:when test="${ noFoodItems == false }">
			<table>
				<tr>
					<th>Caterer Name</th>
					<th> Caterer Rating </th>
					<th> Food Item </th>
					<th> Quantity </th>
					<th> Price </th>
					<th> Food Item Rating </th>
				</tr>
				
				<c:forEach var="foodItem" items="${foodItems }">
					<tr>
						<td> ${foodItem[0].name } </td>
						<td> ${foodItem[0].rating } </td>
						<td> ${foodItem[1].name } </td>
						<td> ${foodItem[1].quantity } </td>
						<td> ${foodItem[1].price } </td>
						<td> ${foodItem[1].rating } </td>
						<td> 
								<form action="addToCart" method="POST" >
									<input type="hidden" name="foodID" value="${foodItem[1].ID }" />
									Add Units : <input type="text" name="units" />
									<input type="submit" value="Add To Cart" />
								</form>
						</td>
					</tr>
				</c:forEach>
			</table>
		</c:when>
		<c:when test="${ noFoodItems == true }" >
			No Food Items Available :( 
		</c:when>	
	</c:choose>
</body>
</html>