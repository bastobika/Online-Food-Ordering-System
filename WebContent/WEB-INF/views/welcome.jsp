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
<title>Login </title>
</head>
<body>
	<a href="signUpOptions">Sign Up</a>  
	<a href="../admin/login">Admin </a> 
	LOGIN !
	<br>
	
	 <form action="authenticate" method="POST" >
	 		Email : <input type="email" name="email" />
	 		Password : <input type="password" name="password" />
	 		<input type="submit" value="Login" /> 
	 </form>
	 		
	 <c:choose>
		<c:when test="${ loginFlag eq 'success' and status eq 'Pending' }" >
	 		Your account will be created after Admin approval.
		 </c:when>
		 <c:when test="${ loginFlag eq 'success' and status eq 'Denied' }" >
	 		Your account creation request has been denied. Please contact Admin for more information.
		 </c:when>
		 <c:when test="${loginFlag eq 'failed' }" >
		 	Wrong Password. Please try again !
		 </c:when>
		  <c:when test="${loginFlag eq 'notRegistered' }" >
		 	No User Found.  Please Sign Up !
		 </c:when>
		 <c:when test="${ customerStatus eq 'success' }" >
		 	Sign Up successful ! You can login now !
		 </c:when>
		  <c:when test="${ catererStatus eq 'Pending' }" >
		 	Sign Up successful ! Your account will be created after Admin approval !
		 </c:when>
	</c:choose>
	
</body>