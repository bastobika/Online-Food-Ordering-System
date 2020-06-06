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
<title>Customer Sign Up</title>
</head>
<body>
		<c:if test="${ customerStatus eq 'duplicateEntry' }" >
			Email or Phone Number already exists ! Please try with a different email or phone !
		</c:if>
		<form:form action="../customer/signUp" method="POST" modelAttribute="customer">
			Name : <form:input path="name"/>
			Email : <form:input path="email"/>
			Phone : <form:input path="phone" />
			Password : <form:input path="password" />
			Do you prefer Veg/Non-Veg/Both ? : <form:select path="preference">
																				<form:option value="Veg"> Veg </form:option>
																				<form:option value="NonVeg"> Non-Veg </form:option>
																				<form:option value="Both"> Both </form:option>
																		   </form:select>
			<input type="submit" value="Sign Up" />
		</form:form>
</body>
</html>