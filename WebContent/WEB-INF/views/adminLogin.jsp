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
<title>Admin Login </title>
</head>
<body>
		<form:form action="authenticate" method="POST" modelAttribute="admin">
				Name : <form:input path="name"/> 
				Password : <form:input path="password" />
				<input type="submit" value="Login" />
		</form:form>
	 	<c:if test="${loginFlag == 'false' }" >
	 			<p> Incorrect Name Or Password ! Try again ! </p>
	 	</c:if>
	
</body>