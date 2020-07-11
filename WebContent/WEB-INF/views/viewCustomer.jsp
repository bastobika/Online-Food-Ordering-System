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
<title>Customer Information </title>
</head>
<style>
	.error{color : red}
</style>
<body>
	<div class="container">
	<br>
		<nav class="navbar navbar-expand-lg navbar-light sticky-top" style="background-color: #e3f2fd;">
		    <ul class="navbar-nav mr-auto">
		      <li class="nav-item">
		        <a class="nav-link" href="${pageContext.request.contextPath}/customer/orderFood">Order Food</a>
		      </li>
		      <li class="nav-item">
		        <a class="nav-link" href="${pageContext.request.contextPath}/customer/viewCart">Cart</a>
		      </li>
		      <li class="nav-item">
		        <a class="nav-link" href="${pageContext.request.contextPath}/customer/viewOrders">Orders</a>
		      </li>
		      <li class="nav-item">
		        <a class="nav-link active" href="${pageContext.request.contextPath}/customer/customerDetails">Profile</a>
		      </li>
		      <li class="nav-item">
		      	<a class="nav-link" href="${pageContext.request.contextPath}/common/logout"> Logout </a>
		      </li>
		    </ul>
	   </nav>
		<br>
		<p class="h4">Your Details -</p>
		<br>
		<form:form action="updateCustomerInfo" method="POST" modelAttribute="customer">
			<form:hidden path="ID"/>      <!-- Adds the original customer ID to the update request. Else you lose track of the original customer -->
			 <div class="form-group">
			 	 <label for="name">Name :</label>    
				 <form:input path="name" class="form-control"/>
				 <form:errors path="name" class="error" />
			</div>
			<div class="form-group">
			 	 <label for="email">Email :</label>    
				 <form:input path="email" readonly="true" class="form-control" />
			</div>
			<div class="form-group">
			 	 <label for="phone">Phone Number :</label>    
				 <form:input path="phone" readonly="true" class="form-control"/>
			</div>
			<div class="form-group">
			 	 <label for="password">Password :</label>    
				 <form:password path="password" showPassword="true" class="form-control"/>
				 <form:errors path="password" class="error" />
			</div>
			<div class="form-group">
			 	 <label for="preference">Preference :</label>    
				<form:select class="form-control" path="preference" aria-describedby="preferenceHelp">
					     <form:option value="Veg"> Veg </form:option>
						 <form:option value="NonVeg"> Non-Veg </form:option>
						 <form:option value="Both"> Both </form:option>
				</form:select>
					  <small id="preferenceHelp" class="form-text text-muted">Veg/NonVeg/Both</small>
			</div>
			<button type="submit" class="btn btn-primary">Update Information</button>
		</form:form>
		<c:if test="${updateStatus.equalsIgnoreCase('success') }">
			<p class="h5">Information Updated Successfully !</p><br>
		</c:if>
		<a href="deleteCustomer" class="btn btn-primary"> Delete Your Account </a>
	</div>
</body>
</html>