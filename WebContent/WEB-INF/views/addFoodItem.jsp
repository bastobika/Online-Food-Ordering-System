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
<title>Add Food Item</title>
</head>
<body>
		<c:if test="${additionStatus eq 'failure' }" >
			Addition of Food Item failed. Please try Again.
		</c:if>
		Enter Details :
		<form:form action="addFoodItem" method="POST" modelAttribute="foodItem">
			Item Name : <form:input path="name"/>
			Quantity : <form:input path="quantity" />
			Price (in Rupees) : <form:input path="price" />
			Food Type : <form:select path="foodType">
																	<form:option value="Veg"> Veg </form:option>
																	<form:option value="NonVeg"> Non-Veg </form:option>
																	<form:option value="Neutral"> Neutral </form:option>
															   </form:select>
			<input type="submit" value="Add Food Item" />
		</form:form>

</body>
</html>