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
<title>Leave Your Rating</title>
</head>
<body>
		<form action="submitRating" method="POST">
			<input type="hidden" name="orderID" value="${order.ID }" />
			<c:forEach var="orderedItem" items="${order.orderedItems }" >
				<input type="hidden" name="foodItemID" value="${orderedItem.foodItem.ID }" />
				Food Item : <c:out value="${orderedItem.foodItem.name }" /> 
				Your Rating for this Item (out of 5) : <input type="text"  name="foodItemRating" />
			</c:forEach>
				Caterer : <c:out value="${orderedItem.foodItem.caterer.name }" /> 
				Your Rating for the Caterer (out of 5) : <input type="text"  name="catererRating" />
				<input type="submit" value="Give Rating" />
			</form>
</body>
</html>