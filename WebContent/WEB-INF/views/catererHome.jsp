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
<title>Home</title>
</head>
<body>
	<br>
	<div class="container">
	
		<nav class="navbar navbar-expand-lg navbar-light sticky-top" style="background-color: #e3f2fd;">
		    <ul class="navbar-nav mr-auto">
		      <li class="nav-item">
		        <a class="nav-link" href="${pageContext.request.contextPath}/caterer/viewOrders">Orders</a>
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
	    <p class="h4"> Welcome  ${ name }  ! </p>
	   <br>
	</div>
</body>
</html>