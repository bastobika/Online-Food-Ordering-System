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
<body>
		Your Details :
		<form:form action="updateCustomerInfo" method="POST" modelAttribute="customer">
			<form:hidden path="ID"/>        
			Name : <form:input path="name"/>
			Email : <form:input path="email" readonly="true" />
			Phone Number : <form:input path="phone" readonly="true"/>
			Password : <form:password path="password" showPassword="true"/>
			Do you prefer Veg/Non-Veg/Both ? : <form:select path="preference">
																				<form:option value="Veg"> Veg </form:option>
																				<form:option value="NonVeg"> Non-Veg </form:option>
																				<form:option value="Both"> Both </form:option>
																		   </form:select>
			<input type="submit"  value="Update Information" />
		</form:form>
		<c:if test="${updateStatus.equalsIgnoreCase('success') }">
			Information Updated Successfully !
		</c:if>
		<a href="deleteCustomer"> Delete Your Account </a>
</body>
</html>