<%@ page language="java" contentType="text/html"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<%
	response.setHeader("Cache-Control", "no-cache"); //HTTP 1.1
	response.setHeader("Pragma", "no-cache"); //HTTP 1.0
	response.setDateHeader("Expires", 0);
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search customer</title>
</head>
<body>
	<jsp:directive.include file="header.html" />
	<br />
	<br />
	
	<form action="#" action="/crm/customer/viewCustomerResult" method="POST">
		   <h4> Search customer by</h4>
			 <input type="radio" name="searchType" value="firstName"checked="checked" /> First Name
		     <input type="radio" name="searchType" value="lastName" checked="checked" /> Last Name
			  <input type="radio" name="searchType" value="email"    checked="checked" /> Email
			  <input type="radio" name="searchType" value="phone"    checked="checked" /> Phone 
			  <br />
		 <h4> Enter the value</h4>
			 <input type="text" name="searchValue" size="15" maxlength="30">
		
		<br /> <button type="submit">Submit</button>
		
	</form>
	<jsp:directive.include file="footer.html" />
</body>
</html>