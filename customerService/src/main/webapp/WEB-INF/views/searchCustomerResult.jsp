<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> 
<%@ page session="false" %>
<%
response.setHeader("Cache-Control","no-cache"); //HTTP 1.1
response.setHeader("Pragma","no-cache"); //HTTP 1.0
response.setDateHeader ("Expires", 0);
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>View Customer</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create Customer Page</title>

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">

<!-- Latest compiled and minified JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
</head>
<body>
	<jsp:directive.include file="header.html" />
	</br>
	</br>

	<table class="table table-striped">
		<tr>
			<td>First Name</td>
			<td>Last Name</td>
			<td>Email</td>
			<td>Phone</td>
			<td>Street Address</td>
			<td>Unit</td>
			<td>City</td>
			<td>State</td>
			<td>Country</td>
			<td>ZipCode</td>
		</tr>
		<c:forEach begin="0" end="${fn:length(customerModelList) - 1}"
			var="index">
			<tr>
				<td><c:out value="${customerModelList[index].firstName}" /></td>
				<td><c:out value="${customerModelList[index].lastName }" /></td>
				<td><c:out value="${customerModelList[index].email }" /></td>
				<td><c:out value="${customerModelList[index].phone }" /></td>
				<td><c:out value="${customerModelList[index].streetAddress }" /></td>
				<td><c:out value="${customerModelList[index].unit }" /></td>
				<td><c:out value="${customerModelList[index].city }" /></td>
				<td><c:out value="${customerModelList[index].state}" /></td>
				<td><c:out value="${customerModelList[index].country }" /></td>
				<td><c:out value="${customerModelList[index].zipCode }" /></td>
			</tr>
		</c:forEach>

	</table>
	<center>
	<a class="btn btn-primary" href="/crm/customer/viewCustomer.jsp" role="button">Go Back</a>
	</center>
	<jsp:directive.include file="footer.html" />
</body>
</html>