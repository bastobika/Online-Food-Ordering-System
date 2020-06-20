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

<br>
<div class="container">
	<nav class="navbar navbar-expand-lg navbar-light sticky-top" style="background-color: #e3f2fd;">
	
	    <ul class="navbar-nav mr-auto">
	      <li class="nav-item">
	        <a class="nav-link active" href="welcome">Login</a>
	      </li>
	      <li class="nav-item">
	        <a class="nav-link" href="signUpOptions">Sign Up</a>
	      </li>
	      <li class="nav-item">
	        <a class="nav-link" href="../admin/login">Admin Login</a>
	      </li>
	    </ul>
	</nav>
	
	
	<br>

	<p class="h2"> Login Here ! </p>
	<br>
	<form action="authenticate"  method="POST"  >
			  <div class="form-group">
				    <label for="email">Email : </label>
				    <input type="text" class="form-control"  id="email" aria-describedby="emailHelp"  name="email"> 
			  </div>
			  <div class="form-group">
				    <label for="password">Password :</label>
				    <input type="password" class="form-control" id="password"  name="password" >
				    <small id="emailHelp" class="form-text text-muted">We'll never share your password with anyone else.</small>
			  </div>
			  <button type="submit" class="btn btn-primary">Login</button>
		</form>

	 		
	 <c:choose>
		<c:when test="${ loginFlag eq 'success' and status eq 'Pending' }" >
	 		<p class="h4">Your account will be created after Admin approval. </p>
		 </c:when>
		 <c:when test="${ loginFlag eq 'success' and status eq 'Denied' }" >
	 		<p class="h4"> Your account creation request has been denied. Please contact Admin for more information. </p>
		 </c:when>
		 <c:when test="${loginFlag eq 'failed' }" >
		 	<p class="h4"> Wrong Password. Please try again ! </p>
		 </c:when>
		  <c:when test="${loginFlag eq 'notRegistered' }" >
		 	<p class="h4"> No User Found.  Please Sign Up ! </p>
		 </c:when>
		 <c:when test="${ customerStatus eq 'success' }" >
		 	<p class="h4"> Sign Up successful ! You can login now ! </p>
		 </c:when>
		  <c:when test="${ catererStatus eq 'Pending' }" >
		 	<p class="h4"> Sign Up successful ! Your account will be created after Admin approval ! </p>
		 </c:when>
	</c:choose>
	

</div>
	
</body>
</html>