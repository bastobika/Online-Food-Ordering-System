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
<title>Admin Home </title>
</head>
<body>
	<a href="requests" > Approve/Deny Requests </a>
	
	<c:choose>
		<c:when test="${ noRequests == false }">
			<table>
				<tr>
					<th> Name </th>
					<th> Email </th>
					<th> Phone </th>
				</tr>
				
				<c:forEach var="caterer" items="${catererRequests }">
					<tr>
						<td> ${caterer.name } </td>
						<td> ${caterer.email } </td>
						<td> ${caterer.phone } </td>
						<td> 
							<form action="updateStatus" method="GET" >
								<input type="hidden" name="catererID" value="${caterer.ID }" />
								 <select name="status" > 
										<option value="Approved"> Approve </option>
										<option value="Denied"> Deny </option>
								 </select>
								 <input type="submit" value="Change Status" />
							</form>
						</td>
					</tr>
				</c:forEach>
			</table>
		</c:when>
		<c:when test="${ noRequests == true }" >
			You have no new Requests !
		</c:when>	
	</c:choose>
</body>