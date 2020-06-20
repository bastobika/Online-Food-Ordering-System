<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
</head>
<body>
	Welcome  ${ name }  !
	
	<a href="../customer/orderFood"> Order Food </a>
	<br>
	<a href="../customer/viewCart"> View Cart</a>
	<br>
	<a href="../customer/viewOrders"> View Orders </a>
	<br>
	<a href="../customer/customerDetails"> View/Update Information </a>
	<br>
	<a href="logout"> Logout </a>

	<c:if test="${ratingStatus eq 'success' }" >
		Rating submitted successfully !
	</c:if>
	
</body>
</html>